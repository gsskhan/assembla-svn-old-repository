package com.citi.retail.optima.etl.container;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryNotificationInfo;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.MemoryType;
import java.net.InetAddress;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.JMException;
import javax.management.MalformedObjectNameException;
import javax.management.Notification;
import javax.management.NotificationEmitter;
import javax.management.NotificationListener;

import mx4j.tools.adaptor.http.HttpAdaptor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.container.jmx.ContainerMBean;
import com.citi.retail.optima.etl.container.jmx.ContainerUtil;
import com.citi.retail.optima.etl.container.jmx.OperationalMBean;
import com.citi.retail.optima.etl.container.monitor.ContainerJVMStatus;
import com.citi.retail.optima.etl.container.monitor.ContainerMemoryUsageNotificationListener;
import com.citi.retail.optima.etl.container.monitor.ContainerVMStatusExtractor;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class Container implements ContainerMBean {
	private static class Holder {
		static final Container CONTAINER_INSTANCE = new Container();
	}

	private static final Log LOGGER = LogFactory.getLog(Container.class);

	public static final String DEFAULT_CONTAINER_CONFIG_FILE = "classpath:/optima.retail.etl.container.xml";

	private final ObjectMapper mapper = new ObjectMapper();

	private ConfigurableApplicationContext parentContext;
	private ConfigurableApplicationContext childContext;

	private String jmxHost;
	private Integer jmxPort;
	private boolean running = false;

	private String moduleName;
	private String moduleConfigFile;
	private boolean autoStart = false;

	private String moduleJmxServiceUrl;

	private final Map<String, ContainerMemoryUsageNotificationListener> memoryUsageListenerMap = new HashMap<String, ContainerMemoryUsageNotificationListener>();

	private static final double HEAP_MEMORY_USAGE_WARNING_THRESHOLD = 0.8;
	private static final double NON_HEAP_MEMORY_USAGE_WARNING_THRESHOLD = 0.8;

	private ContainerVMStatusExtractor containerVMStatusExtractor = new ContainerVMStatusExtractor();

	private Container() {
	}

	public static Container getInstance() {
		return Holder.CONTAINER_INSTANCE;
	}

	@Override
	public String getModuleName() {
		return this.moduleName;
	}

	@Override
	public String getModuleJmxObjectName() {
		String objectName = null;
		if (StringUtils.hasText(this.moduleName)) {
			objectName = ContainerUtil.formatObjectName(
					ContainerUtil.OPTIMA_RETAIL_ETL, this.moduleName);
		}
		return objectName;
	}

	@Override
	public String getModuleJmxServiceUrl() {
		return this.moduleJmxServiceUrl;
	}

	public void setMemoryUsageListenerList(
			Collection<ContainerMemoryUsageNotificationListener> memoryUsageListenerList) {

		for (ContainerMemoryUsageNotificationListener memoryUsageListener : memoryUsageListenerList) {
			addMemoryUsageListener(memoryUsageListener);
		}
	}

	public void addMemoryUsageListener(
			ContainerMemoryUsageNotificationListener memoryUsageListener) {
		if (this.memoryUsageListenerMap.get(memoryUsageListener.getName()) == null) {
			this.memoryUsageListenerMap.put(memoryUsageListener.getName(),
					memoryUsageListener);
		} else {
			if (LOGGER.isInfoEnabled()) {
				LOGGER.info("MemoryUsageListener ("
						+ memoryUsageListener.getName() + ") exists!");
			}
		}
	}

	public void setContainerVMStatusExtractor(
			ContainerVMStatusExtractor containerVMStatusExtractor) {
		this.containerVMStatusExtractor = containerVMStatusExtractor;
	}

	public void start(String jmxHost, Integer jmxPort,
			String containerConfigFile, String moduleName,
			String moduleConfigFile, boolean autoStart) throws Exception {

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("In Start method of Container");
		}

		this.running = true;
		this.moduleConfigFile = moduleConfigFile;
		this.autoStart = autoStart;
		this.moduleName = moduleName;
		startContainer(jmxHost, jmxPort, containerConfigFile);

		try {
			registerModule(moduleName, moduleConfigFile, autoStart);
		} catch (Exception e) {
			LOGGER.error("Failed to register module: " + moduleName, e);
			// stop container
			stop();
			throw e;
		}

		// set memory usage threshold
		setHeapMemoryUsageWarningThreshold(HEAP_MEMORY_USAGE_WARNING_THRESHOLD);
		setNonHeapMemoryUsageWarningThreshold(NON_HEAP_MEMORY_USAGE_WARNING_THRESHOLD);

		// start memory monitor
		startMemoryUsageMonitor();
		LOGGER.info("Successfully started container ... ");
	}

	@Override
	public void stop() throws Exception {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("In Stop method of Container");
		}

		this.running = false;
		if (this.childContext != null) {
			OperationalMBean operationalMBean = getOperationalMBean(
					getModuleJmxServiceUrl(), getModuleJmxObjectName());
			if (operationalMBean == null) {
				throw new JMException(
						"No application is running on the speficied location ...");
			}
			operationalMBean.stop();

			this.childContext.close();
			try {
				this.childContext.stop();
			} catch (Exception ex) {
				LOGGER.equals("Application context stop method failed..");
			}			
			this.childContext = null;
		}

		this.parentContext.close();
		this.parentContext.stop();
		this.parentContext = null;
	}

	@Override
	public void startModule() throws Exception {
		try {
			registerModule(this.moduleName, this.moduleConfigFile,
					this.autoStart);
		} catch (Exception e) {
			LOGGER.error("Failed to register module: " + this.moduleName, e);
			throw e;
		}
	}

	@Override
	public void stopModule() throws Exception {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("In stopModule method of Container");
		}

		this.running = false;
		if (this.childContext != null) {
			OperationalMBean operationalMBean = getOperationalMBean(
					getModuleJmxServiceUrl(), getModuleJmxObjectName());
			if (operationalMBean == null) {
				throw new JMException(
						"No application is running on the speficied location ...");
			}
			operationalMBean.stop();

			this.childContext.close();
			this.childContext.stop();
			this.childContext = null;
		}
	}

	@Override
	public String getContainerJVMStatusJsonString(boolean detectDeadLock)
			throws Exception {
		boolean isModuleAlive = false;
		if (this.childContext != null) {
			OperationalMBean operationalMBean = getOperationalMBean(
					getModuleJmxServiceUrl(), getModuleJmxObjectName());
			if (operationalMBean == null) {
				throw new JMException(
						"No application is running on the speficied location ...");
			}
			isModuleAlive = operationalMBean.isAlive();
		}

		List<MemoryPoolMXBean> memoryPoolMXBeanList = this.containerVMStatusExtractor
				.getMemoryPoolMXBeanList();

		ContainerJVMStatus jvmStatus = this.containerVMStatusExtractor
				.retrieveContainerJVMStatus(
						getModuleName(),
						isModuleAlive,
						this.containerVMStatusExtractor.getRuntimeMXBean(),
						this.containerVMStatusExtractor
								.getOperatingSystemMXBean(),
						this.containerVMStatusExtractor.getMemoryMXBean(),
						this.containerVMStatusExtractor
								.getTenuredGenMemoryPoolMXBean(memoryPoolMXBeanList),
						this.containerVMStatusExtractor
								.getPermGenMemoryPoolMXBean(memoryPoolMXBeanList),
						this.containerVMStatusExtractor.getThreadMXBean(),
						detectDeadLock);

		return this.mapper.writeValueAsString(jvmStatus);
	}

	@Override
	public synchronized void setHeapMemoryUsageWarningThreshold(
			double percentage) throws Exception {
		if (this.running) {
			MemoryPoolMXBean tenuredGenPool = this.containerVMStatusExtractor
					.getTenuredGenMemoryPoolMXBean(this.containerVMStatusExtractor
							.getMemoryPoolMXBeanList());
			setMemoryUsageThreshold(tenuredGenPool, percentage);
		}
	}

	@Override
	public synchronized void setNonHeapMemoryUsageWarningThreshold(
			double percentage) throws Exception {
		if (this.running) {
			MemoryPoolMXBean permGenPool = this.containerVMStatusExtractor
					.getPermGenMemoryPoolMXBean(this.containerVMStatusExtractor
							.getMemoryPoolMXBeanList());
			setMemoryUsageThreshold(permGenPool, percentage);
		}
	}

	private void setMemoryUsageThreshold(MemoryPoolMXBean pool,
			double percentage) throws Exception {
		Assert.isTrue(percentage > 0.0 && percentage < 1.0,
				"threshold percentage is not in range: " + percentage);

		long maxMemory = pool.getUsage().getMax();
		long warningThreshold = (long) (maxMemory * percentage);
		pool.setUsageThreshold(warningThreshold);
	}

	private synchronized void startContainer(String jmxHost, Integer jmxPort,
			String configFile) throws IOException, JMException,
			OptimaRetailApplicationException {
		if (this.parentContext != null) {
			throw new IllegalStateException("Container is running!");
		}

		Assert.isTrue(StringUtils.hasText(jmxHost), "jmxHost cannot be null!");
		Assert.isTrue(
				InetAddress.getLocalHost().equals(
						InetAddress.getByName(jmxHost)),
				"Cannot start container at remote host [" + jmxHost + "]");
		Assert.notNull(jmxPort, "jmxPort cannot be null!");

		LOGGER.info("Starting container ...");
		this.jmxHost = jmxHost;
		System.setProperty("jmx.host", jmxHost);

		this.jmxPort = jmxPort;
		System.setProperty("jmx.port", jmxPort.toString());

		String objectName = ContainerUtil.formatObjectName(
				ContainerUtil.OPTIMA_RETAIL_ETL, this.getClass()
						.getSimpleName());
		String serviceUrl = ContainerUtil.getJMXServiceUrl(
				ContainerUtil.JMX_RMI_CONNECTOR, jmxHost, jmxPort, 
				ContainerUtil.JMX_CONTAINER_URL_PATH);
		if (getManagementBean(serviceUrl, objectName, ContainerMBean.class) != null) {
			throw new JMException(
					"An exisitng server is running on speficied location ...");
		}

		this.parentContext = new ClassPathXmlApplicationContext(configFile);
		this.parentContext.registerShutdownHook();

		try {
			HttpAdaptor httpAdaptor = BeanFactoryUtils.beanOfType(
					this.parentContext, HttpAdaptor.class);
			httpAdaptor.start();
		} catch (NoSuchBeanDefinitionException e) {
			LOGGER.info("No http adapter available!");
		}
	}

	private synchronized void registerModule(String moduleName,
			String configFile, boolean autoStart) throws Exception {
		if (this.parentContext == null) {
			throw new IllegalStateException("Container is not running!");
		}
		if (this.childContext != null) {
			throw new IllegalStateException(
					"A module has been regestered on this container!");
		}
		Assert.isTrue(StringUtils.hasText(moduleName),
				"module name cannot be null!");
		System.setProperty("module", moduleName);

		String objectName = ContainerUtil.formatObjectName(
				ContainerUtil.OPTIMA_RETAIL_ETL, moduleName);
		String serviceUrl = ContainerUtil.getJMXServiceUrl(
				ContainerUtil.JMX_RMI_CONNECTOR, this.jmxHost, this.jmxPort,
				moduleName);
		OperationalMBean operationalMBean = getOperationalMBean(serviceUrl,
				objectName);
		if (operationalMBean != null) {
			throw new JMException(
					"An exisitng application is running on speficied location ...");
		}

		this.moduleName = moduleName;
		this.moduleJmxServiceUrl = serviceUrl;
		System.setProperty(ContainerUtil.MODULE, moduleName);

		this.childContext = new ClassPathXmlApplicationContext(
				new String[] { configFile }, this.parentContext);
		this.childContext.registerShutdownHook();

		operationalMBean = BeanFactoryUtils.beanOfType(this.childContext,
				OperationalMBean.class);
		if (autoStart) {
			operationalMBean.start();
		}
	}

	private OperationalMBean getOperationalMBean(String moduleJmxServiceUrl,
			String moduleJmxObjectName) throws MalformedObjectNameException,
			IOException {
		OperationalMBean operationalMBean = null;
		if (StringUtils.hasText(moduleJmxServiceUrl)
				&& StringUtils.hasText(moduleJmxObjectName)) {
			operationalMBean = (OperationalMBean) getManagementBean(
					moduleJmxServiceUrl, moduleJmxObjectName,
					OperationalMBean.class);
		}
		return operationalMBean;
	}

	private Object getManagementBean(String serverUrl, String objectName,
			Class<?> objectClass) {
		Object mBean = null;
		try {
			mBean = ContainerUtil.getMBean(serverUrl, objectName, objectClass);
		} catch (Exception e) {
			LOGGER.info(e.getMessage());
		}
		return mBean;
	}

	private void startMemoryUsageMonitor() {
		NotificationEmitter emitter = (NotificationEmitter) ManagementFactory
				.getMemoryMXBean();
		emitter.addNotificationListener(new JVMNotificationListener(),
				null, null);
	}

	/**
	 * Inner local class for JVM threshold triggered notifications
	 */
	private class JVMNotificationListener implements NotificationListener {
		@Override
		public void handleNotification(Notification notification,
				Object handback) {
			if (notification.getType().equals(
					MemoryNotificationInfo.MEMORY_THRESHOLD_EXCEEDED)) {

				List<MemoryPoolMXBean> memoryPoolMXBeanList = Container.this.containerVMStatusExtractor
						.getMemoryPoolMXBeanList();

				try {
					MemoryPoolMXBean tenuredGenPool = Container.this.containerVMStatusExtractor
							.getTenuredGenMemoryPoolMXBean(memoryPoolMXBeanList);
					if (tenuredGenPool.isUsageThresholdExceeded()) {
						for (ContainerMemoryUsageNotificationListener listener : Container.this.memoryUsageListenerMap
								.values()) {
							listener.exceedUsageThreshold(MemoryType.HEAP,
									tenuredGenPool.getUsage().getMax(),
									tenuredGenPool.getUsage().getUsed());
						}
					}
				} catch (Exception e) {
					throw new IllegalStateException(
							"Failed to notify excreed heap memory usage threshold!",
							e);
				}

				try {
					MemoryPoolMXBean permGenPool = Container.this.containerVMStatusExtractor
							.getPermGenMemoryPoolMXBean(memoryPoolMXBeanList);
					if (permGenPool.isUsageThresholdExceeded()) {
						for (ContainerMemoryUsageNotificationListener listener : Container.this.memoryUsageListenerMap
								.values()) {
							listener.exceedUsageThreshold(MemoryType.NON_HEAP,
									permGenPool.getUsage().getMax(),
									permGenPool.getUsage().getUsed());
						}
					}
				} catch (Exception e) {
					throw new IllegalStateException(
							"Failed to notify excreed heap memory usage threshold!",
							e);
				}
			}
		}

	}
}