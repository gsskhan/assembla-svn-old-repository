package com.citi.retail.optima.etl.container.jmx;

import java.io.IOException;
import java.net.InetAddress;
import java.text.MessageFormat;

import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import javax.validation.constraints.NotNull;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;

public final class ContainerUtil {
	
	private static final Log LOGGER = LogFactory.getLog(ContainerUtil.class);
	
	public static final String OPTIMA_RETAIL_ETL_JMX_DOMAIN = "optimaRetailEtl";
	public static final String OPTIMA_RETAIL_ETL = "optima.retail.etl";

	public static final String JMX_HOST = "jmx.host";
	public static final String JMX_PORT = "jmx.port";
	public static final String MODULE = "module";

	public static final String JMX_RMI_CONNECTOR = "rmi";
	public static final String JMX_SERVICE_URL_TEMPLATE = "service:jmx:{0}:///jndi/{0}://{1}:{2}/{3}";

	public static final String JMX_OBJECT_NAME_TEMPLATE = "{0}:module={1}";
	
	public static final String JMX_CONTAINER_URL_PATH = "jmxrmi";

	/**
	 * Private Constructor to avoid Sonar violation for Utility classes
	 */
	private ContainerUtil() {
	}

	public static String getJmxHost(boolean defaultToLocalhost)
			throws Exception {
		String hostname = System.getProperty(JMX_HOST);
		if (!StringUtils.hasText(hostname)) {
			if (defaultToLocalhost) {
				hostname = InetAddress.getLocalHost().getHostName();
				System.setProperty(JMX_HOST, hostname);
			} else {
				hostname = null;
			}
		}

		return hostname;
	}

	public static Integer getJmxPort() {
		Integer port = null;

		String portNumber = System.getProperty(JMX_PORT);
		if (StringUtils.hasText(portNumber)) {
			port = Integer.parseInt(portNumber);
		}

		if (port != null && port <= 0) {
			throw new IllegalStateException("Incorrect port number received:"
					+ port);
		}

		return port;
	}

	public static Object getMBean(@NotNull String serverUrl,
			@NotNull String objectName, @NotNull Class<?> objectClass)
			throws IOException, MalformedObjectNameException {
		JMXConnector connector = JMXConnectorFactory.connect(new JMXServiceURL(
				serverUrl));
		MBeanServerConnection mbsc = connector.getMBeanServerConnection();
		return MBeanServerInvocationHandler.newProxyInstance(mbsc,
				ObjectName.getInstance(objectName), objectClass, false);
	}

	public static String getJMXServiceUrl(@NotNull String jmxServiceType,
			@NotNull String jmxHost, @NotNull Integer jmxPort,
			@NotNull String module) throws OptimaRetailApplicationException {
		String urlString = null;

		if (JMX_RMI_CONNECTOR.equalsIgnoreCase(jmxServiceType)) {
			urlString = MessageFormat.format(JMX_SERVICE_URL_TEMPLATE,
					jmxServiceType, jmxHost, String.valueOf(jmxPort), module);
		} else {
			LOGGER.error("Un-support JMX service connection type [" + jmxServiceType
							+ "] in ContainerUtil");
			throw new OptimaRetailApplicationException(ServiceName.CONTAINER,
					ExceptionType.ERROR,"Un-support JMX service connection type [" + jmxServiceType
							+ "]", null, null, null);
		}

		return urlString;
	}

	public static String formatObjectName(@NotNull String type,
			@NotNull String module) {
		return MessageFormat.format(JMX_OBJECT_NAME_TEMPLATE, type, module);
	}
}
