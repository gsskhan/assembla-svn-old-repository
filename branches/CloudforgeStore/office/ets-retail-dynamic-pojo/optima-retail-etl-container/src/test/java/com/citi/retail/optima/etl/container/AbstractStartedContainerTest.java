package com.citi.retail.optima.etl.container;

import org.junit.BeforeClass;
import org.springframework.util.Assert;

import com.citi.retail.optima.etl.container.jmx.ContainerUtil;

public abstract class AbstractStartedContainerTest {
	protected static String jmxHost;
	protected static Integer jmxPort = 1112;
	protected static Integer httpPort = 8084;

	protected static String moduleName = "module";

	protected static ContainerAdmin admin = new ContainerAdmin();

	@BeforeClass
	public static void setUp() throws Exception {
		if (jmxHost == null) {
			jmxHost = ContainerUtil.getJmxHost(true);
			System.setProperty("http.port", httpPort.toString());

			String containerConfigFile = Container.DEFAULT_CONTAINER_CONFIG_FILE;
			String moduleConfigFile = "classpath:/optima.retail.etl.module.test.xml";
			admin.startContainer(jmxHost, jmxPort, containerConfigFile, moduleName,
					moduleConfigFile, true);

			Assert.notNull(admin.retrieveJvmStatus(jmxHost, jmxPort, false),
					"Container is not running!");		
		}	
	}
	
}
