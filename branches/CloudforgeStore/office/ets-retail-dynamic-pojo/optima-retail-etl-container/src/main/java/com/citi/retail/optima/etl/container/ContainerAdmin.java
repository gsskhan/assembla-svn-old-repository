package com.citi.retail.optima.etl.container;

import javax.management.JMException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.daemon.Daemon;
import org.apache.commons.daemon.DaemonContext;
import org.apache.commons.daemon.DaemonInitException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;
import com.citi.retail.optima.etl.container.jmx.ContainerMBean;
import com.citi.retail.optima.etl.container.jmx.ContainerUtil;
import com.citi.retail.optima.etl.container.jmx.OperationalMBean;

public class ContainerAdmin implements Daemon {

	private static final Log LOGGER = LogFactory.getLog(ContainerAdmin.class);

	public static final String START = "start";
	public static final String STOP = "stop";
	public static final String IS_ALIVE = "isAlive";
	public static final String STATUS = "status";
	public static final String SET_HEAP_MEMORY_USAGE_WARNING_THRESHOLD = "setHeapMemoryUsageWarningThreshold";
	public static final String SET_NON_HEAP_MEMORY_USAGE_WARNING_THRESHOLD = "setNonHeapMemoryUsageWarningThreshold";
	public static final String PRINT_JVM_STATUS = "printJvmStatus";

	public static final String CONTAINER = "container";
	public static final String MODULE = "module";
	public static final String ADAPTER = "adapter";
	public static final String LIT_TYPE = "type";
	public static final String LIT_HOST = "Host=";
	public static final String LIT_PORT = ", Port=";
	public static final String LIT_CONT_RUNN_SPEC_LOC_HOST = "There is no container running on speficied location. Host=";

	private String[] arguments;
	private final CommandLineParser parser = new GnuParser();
	private final Options options = new Options();

	@SuppressWarnings("static-access")
	public ContainerAdmin() {
		options.addOption(OptionBuilder.withLongOpt("command")
				.withDescription("command").hasArg().withArgName("COMMAND")
				.isRequired().create());
		options.addOption(OptionBuilder.withLongOpt(LIT_TYPE)
				.withDescription(LIT_TYPE).hasArg()
				.withArgName("[CONTAINER|MODULE]").create());
		options.addOption(OptionBuilder.withLongOpt("container-config")
				.withDescription("container config file").hasArg()
				.withArgName("FILE").create());
		options.addOption(OptionBuilder.withLongOpt("module-name")
				.withDescription("module name").hasArg().withArgName("NAME")
				.create());
		options.addOption(OptionBuilder.withLongOpt("module-config")
				.withDescription("module config file").hasArg()
				.withArgName("FILE").create());
		options.addOption(OptionBuilder.withLongOpt("auto-start").hasArg()
				.withArgName("BOOLEAN").withDescription("auto start module")
				.create());
		options.addOption(OptionBuilder.withLongOpt("memory-percentage")
				.withDescription("percentage of memory").hasArg()
				.withArgName("PERCENTAGE").create());
		options.addOption(OptionBuilder.withLongOpt("dead-lock-status")
				.withDescription("dead lock status").hasArg()
				.withArgName("LOCK_STATUS").create());
	}

	public void startContainer(String jmxHost, Integer jmxPort,
			String containerConfigFile, String moduleName,
			String moduleConfigFile, boolean autoStart) throws Exception {
		Assert.isTrue(StringUtils.hasText(moduleName),
				"module name cannot be null!");
		Assert.isTrue(StringUtils.hasText(moduleConfigFile),
				"moduleConfigFile cannot be null!");
		Container container = Container.getInstance();
		container.start(jmxHost, jmxPort, containerConfigFile, moduleName,
				moduleConfigFile, autoStart);
	}

	public void stopContainer(String jmxHost, Integer jmxPort) throws Exception {
		ContainerMBean containerMBean = getContainerMBean(jmxHost, jmxPort);
		if (containerMBean != null) {
			LOGGER.info("Stoping container:" + LIT_HOST + jmxHost + LIT_PORT
					+ jmxPort);
			containerMBean.stop();
		} else {
			LOGGER.debug(LIT_CONT_RUNN_SPEC_LOC_HOST + jmxHost + LIT_PORT
					+ jmxPort);
		}
	}

	public void startModule(String jmxHost, Integer jmxPort) throws Exception {
		ContainerMBean containerMBean = getContainerMBean(jmxHost, jmxPort);
		if (containerMBean == null) {
			throw new JMException(LIT_CONT_RUNN_SPEC_LOC_HOST + jmxHost
					+ LIT_PORT + jmxPort);
		}
		containerMBean.startModule();
	}

	public void stopModule(String jmxHost, Integer jmxPort) throws Exception {
		ContainerMBean containerMBean = getContainerMBean(jmxHost, jmxPort);
		if (containerMBean == null) {
			throw new JMException(LIT_CONT_RUNN_SPEC_LOC_HOST + jmxHost
					+ LIT_PORT + jmxPort);
		}
		containerMBean.stopModule();
	}

	public void startJmsAdapter(String jmxHost, Integer jmxPort)
			throws Exception {
		OperationalMBean operationalMBean = getOperationalMBean(jmxHost,
				jmxPort);
		if (operationalMBean == null) {
			throw new JMException(
					"There is no module registered on speficied container. Host="
							+ jmxHost + LIT_PORT + jmxPort);
		}
		operationalMBean.start();
	}

	public void stopJmsAdapter(String jmxHost, Integer jmxPort)
			throws Exception {
		OperationalMBean operationalMBean = getOperationalMBean(jmxHost,
				jmxPort);
		if (operationalMBean == null) {
			throw new JMException(
					"There is no module registered on speficied container. Host="
							+ jmxHost + LIT_PORT + jmxPort);
		}
		operationalMBean.stop();
	}

	public boolean isModuleRunning(String jmxHost, Integer jmxPort)
			throws Exception {
		OperationalMBean operationalMBean = getOperationalMBean(jmxHost,
				jmxPort);
		if (operationalMBean == null) {
			throw new JMException(
					"There is no module registered on speficied container. Host="
							+ jmxHost + LIT_PORT + jmxPort);
		}
		return operationalMBean.isAlive();
	}

	public void setHeapMemoryUsageWarningThreshold(String jmxHost,
			Integer jmxPort, Double percentage) throws Exception {
		Assert.notNull(percentage, "percentage cannot be null!");
		ContainerMBean containerMBean = getContainerMBean(jmxHost, jmxPort);
		if (containerMBean == null) {
			throw new JMException(
					"There is no container running on specified location. Host="
							+ jmxHost + LIT_PORT + jmxPort);
		}
		containerMBean.setHeapMemoryUsageWarningThreshold(percentage);
	}

	public void setNonHeapMemoryUsageWarningThreshold(String jmxHost,
			Integer jmxPort, Double percentage) throws Exception {
		Assert.notNull(percentage, "percentage cannot be null!");
		ContainerMBean containerMBean = getContainerMBean(jmxHost, jmxPort);
		if (containerMBean == null) {
			throw new JMException(
					"There is no container running on specified location. Host="
							+ jmxHost + LIT_PORT + jmxPort);
		}
		containerMBean.setNonHeapMemoryUsageWarningThreshold(percentage);
	}

	protected ContainerMBean getContainerMBean(String jmxHost, Integer jmxPort) {
		Assert.isTrue(StringUtils.hasText(jmxHost), "jmxHost cannot be null!");
		Assert.notNull(jmxPort, "jmxPort cannot be null!");
		ContainerMBean containerMBean = null;
		try {
			String objectName = ContainerUtil.formatObjectName(
					ContainerUtil.OPTIMA_RETAIL_ETL,
					Container.class.getSimpleName());
			String serviceUrl = ContainerUtil.getJMXServiceUrl(
					ContainerUtil.JMX_RMI_CONNECTOR, jmxHost, jmxPort,
					ContainerUtil.JMX_CONTAINER_URL_PATH);

			containerMBean = (ContainerMBean) ContainerUtil.getMBean(
					serviceUrl, objectName, ContainerMBean.class);
		} catch (Exception e) {
			LOGGER.info("There is no container running on specified location. Host="
					+ jmxHost + LIT_PORT + jmxPort);
		}

		return containerMBean;
	}

	protected OperationalMBean getOperationalMBean(String jmxHost,
			Integer jmxPort) throws Exception {
		ContainerMBean containerMBean = getContainerMBean(jmxHost, jmxPort);
		if (containerMBean == null) {
			throw new JMException(LIT_CONT_RUNN_SPEC_LOC_HOST + jmxHost
					+ LIT_PORT + jmxPort);
		}
		String objectName = containerMBean.getModuleJmxObjectName();
		String serviceUrl = containerMBean.getModuleJmxServiceUrl();
		OperationalMBean operationalMBean = null;
		try {
			operationalMBean = (OperationalMBean) ContainerUtil.getMBean(
					serviceUrl, objectName, OperationalMBean.class);
		} catch (Exception e) {
			LOGGER.info(e.getMessage());
		}
		return operationalMBean;
	}

	public String retrieveJvmStatus(String jmxHost, Integer jmxPort,
			Boolean detectDeadLock) throws Exception {
		boolean detectDeadLockStatus = false;
		ContainerMBean containerMBean = getContainerMBean(jmxHost, jmxPort);
		if (containerMBean == null) {
			throw new JMException(LIT_CONT_RUNN_SPEC_LOC_HOST + jmxHost
					+ LIT_PORT + jmxPort);
		}
		if (detectDeadLock != null) {
			detectDeadLockStatus = detectDeadLock;
		}

		return containerMBean
				.getContainerJVMStatusJsonString(detectDeadLockStatus);
	}

	public void printJvmStatus(String jmxHost, Integer jmxPort,
			Boolean detectDeadLock) throws Exception {
		LOGGER.info(retrieveJvmStatus(jmxHost, jmxPort, detectDeadLock));
	}

	public void run(String[] args) throws Exception {
		String jmxHost = ContainerUtil.getJmxHost(true);
		Integer jmxPort = ContainerUtil.getJmxPort();
		LOGGER.info("In run of Container Admin, jmxHost is - " + jmxHost
				+ " and Port is - " + jmxPort);
		CommandLine commandLine = parser.parse(options, args);
		String command = commandLine.getOptionValue("command");
		String type = null;
		if (commandLine.hasOption(LIT_TYPE)) {
			type = commandLine.getOptionValue(LIT_TYPE);
			if (!(type.equalsIgnoreCase(CONTAINER) || type
					.equalsIgnoreCase(MODULE))) {
				throw new OptimaRetailApplicationException(
						ServiceName.CONTAINER, ExceptionType.ERROR,
						"Unknown type received: " + type, null, null, null);
			}
		}
		String containerConfigFile = Container.DEFAULT_CONTAINER_CONFIG_FILE;
		if (commandLine.hasOption("container-config")) {
			containerConfigFile = commandLine
					.getOptionValue("container-config");
		}
		String moduleName = commandLine.getOptionValue("module-name");
		String moduleConfigFile = commandLine.getOptionValue("module-config");
		boolean autoStart = true;
		if (commandLine.hasOption("auto-start")) {
			autoStart = Boolean.parseBoolean(commandLine
					.getOptionValue("auto-start"));
		}
		Double percentageOfMemory = null;
		if (commandLine.hasOption("memory-percentage")) {
			percentageOfMemory = Double.valueOf(commandLine
					.getOptionValue("memory-percentage"));
		}
		Boolean deadLockStatus = Boolean.valueOf(commandLine
				.getOptionValue("dead-lock-status"));
		handleCommands(jmxHost, jmxPort, command, type, containerConfigFile,
				moduleName, moduleConfigFile, autoStart, percentageOfMemory,
				deadLockStatus);
	}

	@Override
	public void destroy() {
		LOGGER.info("Destory method invoked...");
	}

	@Override
	public void init(DaemonContext daemonContext) throws DaemonInitException {
		this.arguments = daemonContext.getArguments();
		if (this.arguments != null) {
			LOGGER.info("System arguments:" + this.arguments);
		}
	}

	@Override
	public void start() throws Exception {
		if (this.arguments != null) {
			run(this.arguments);
		}
	}

	@Override
	public void stop() throws Exception {
		String jmxHost = ContainerUtil.getJmxHost(true);
		Integer jmxPort = ContainerUtil.getJmxPort();
		LOGGER.info("In run of Container Admin, jmxHost is - " + jmxHost
				+ " and Port is - " + jmxPort);
		this.stopContainer(jmxHost, jmxPort);
		LOGGER.info("Container Stoped...");
	}

	public static void main(String[] args) throws OptimaRetailApplicationException {
		ContainerAdmin launcher = new ContainerAdmin();
		try {
			launcher.run(args);
		} catch (Exception e) {
			LOGGER.error(
					"RunTime Exception in ContainerAdmin.main(): "
							+ e.getMessage(), e);
			throw new OptimaRetailApplicationException(ServiceName.CONTAINER,
					ExceptionType.ERROR,
					"RunTime Exception in ContainerAdmin.main()",
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e),
					null);
		}
	}

	private void handleCommands(String jmxHost, Integer jmxPort,
			String command, String type, String containerConfigFile,
			String moduleName, String moduleConfigFile, boolean autoStart,
			Double percentageOfMemory, Boolean deadLockStatus) throws Exception {
		if (command.equalsIgnoreCase(START)) {
			startCommand(jmxHost, jmxPort, type, containerConfigFile,
					moduleName, moduleConfigFile, autoStart);
		} else if (command.equalsIgnoreCase(STOP)) {
			stopCommand(type, jmxHost, jmxPort);
		} else if (command.equalsIgnoreCase(IS_ALIVE)) {
			boolean alive = isModuleRunning(jmxHost, jmxPort);
			LOGGER.info(alive);
		} else if (command
				.equalsIgnoreCase(SET_HEAP_MEMORY_USAGE_WARNING_THRESHOLD)) {
			setHeapMemoryUsageWarningThreshold(jmxHost, jmxPort,
					percentageOfMemory);
		} else if (command
				.equalsIgnoreCase(SET_NON_HEAP_MEMORY_USAGE_WARNING_THRESHOLD)) {
			setNonHeapMemoryUsageWarningThreshold(jmxHost, jmxPort,
					percentageOfMemory);
		} else if (command.equalsIgnoreCase(PRINT_JVM_STATUS)) {
			printJvmStatus(jmxHost, jmxPort, deadLockStatus);
		} else {
			LOGGER.error("ContainerAdmin().handleCommands() - Unknown command received: "
					+ command);
			throw new OptimaRetailApplicationException(ServiceName.CONTAINER,
					ExceptionType.ERROR,
					"Unknown command received: " + command, null, null, null);
		}
	}

	private void stopCommand(String type, String jmxHost, Integer jmxPort)
			throws Exception {
		if (type == null) {
			throw new OptimaRetailApplicationException(ServiceName.CONTAINER,
					ExceptionType.ERROR,
					"type is required for stopping container/module!" + type,
					null, null, null);
		}
		if (type.equalsIgnoreCase(CONTAINER)) {
			stopContainer(jmxHost, jmxPort);
		} else if (type.equalsIgnoreCase(MODULE)) {
			stopModule(jmxHost, jmxPort);
		} else if (type.equalsIgnoreCase(ADAPTER)) {
			stopJmsAdapter(jmxHost, jmxPort);
		}
	}

	private void startCommand(String jmxHost, Integer jmxPort, String type,
			String containerConfigFile, String moduleName,
			String moduleConfigFile, boolean autoStart) throws Exception {
		if (type == null) {
			LOGGER.error("ContainerAdmin.startCommand() - type is required for starting container/module!"
					+ type);
			throw new OptimaRetailApplicationException(ServiceName.CONTAINER,
					ExceptionType.ERROR,
					"type is required for starting container/module!" + type,
					null, null, null);
		}
		if (type.equalsIgnoreCase(CONTAINER)) {
			startContainer(jmxHost, jmxPort, containerConfigFile, moduleName,
					moduleConfigFile, autoStart);
		} else if (type.equalsIgnoreCase(MODULE)) {
			startModule(jmxHost, jmxPort);
		} else if (type.equalsIgnoreCase(ADAPTER)) {
			startJmsAdapter(jmxHost, jmxPort);
		}
	}
}
