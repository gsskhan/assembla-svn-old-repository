package com.citi.retail.optima.etl.controller.container;


import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.util.Assert;

import com.citi.retail.optima.etl.container.Container;
import com.citi.retail.optima.etl.container.ContainerAdmin;
import com.citi.retail.optima.etl.container.jmx.ContainerUtil;

/**
 * This is a Junit class to test the start up of controller component from container.
 * @author rs70128
 *
 */
@Ignore
public class ControllerStartUpTest {

	private static String jmxHost;
	private static Integer jmxPort = 1099;
	private static Integer httpPort = 8080;
	private static String moduleName = "controller";
	private static ContainerAdmin admin = new ContainerAdmin();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		jmxHost = ContainerUtil.getJmxHost(true);
		System.setProperty("http.port", httpPort.toString());
		String containerConfigFile = Container.DEFAULT_CONTAINER_CONFIG_FILE;
		String moduleConfigFile = "classpath:/retail.optima.etl.controller.jmx.test.xml";
		admin.startContainer(jmxHost, jmxPort, containerConfigFile, moduleName,
				moduleConfigFile, false);
	}

	@Test
	public void testControllerStartUp() throws Exception {
		System.out.println("Controller module already running?:" + admin.isModuleRunning(jmxHost, jmxPort));
		admin.startModule(jmxHost, jmxPort);
		System.out.println("Controller module running?:" + admin.isModuleRunning(jmxHost, jmxPort));
		Assert.notNull(admin.retrieveJvmStatus(jmxHost, jmxPort, false),
				"Container is not running!");	
	}

}
