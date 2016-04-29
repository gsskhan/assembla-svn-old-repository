package com.citi.retail.optima.etl.batch.test.container;

import com.citi.retail.optima.etl.container.Container;
import com.citi.retail.optima.etl.container.ContainerAdmin;
import com.citi.retail.optima.etl.container.jmx.ContainerUtil;

public class ContainerStartupMain {

	private final Container container = Container.getInstance();

	private static String jmxHost;
	private static Integer jmxPort = 1099;
	private static Integer httpPort = 8080;

	private static String moduleName;

	public static void main(String[] args) throws Exception {
		ContainerAdmin admin = new ContainerAdmin();

		jmxHost = ContainerUtil.getJmxHost(true);

		moduleName = "module";
		System.setProperty("module", moduleName);

		System.setProperty("http.port", httpPort.toString());

		String containerConfigFile = Container.DEFAULT_CONTAINER_CONFIG_FILE;
		String moduleConfigFile = "classpath:/batch.module.container.jmx.test.xml";

		admin.startContainer(jmxHost, jmxPort, containerConfigFile, moduleName,
				moduleConfigFile, true);

		// admin.stopContainer(jmxHost, jmxPort);

	}

}
