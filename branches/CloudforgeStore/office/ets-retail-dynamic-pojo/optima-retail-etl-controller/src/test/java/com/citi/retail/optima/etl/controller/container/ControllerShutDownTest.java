package com.citi.retail.optima.etl.controller.container;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.citi.retail.optima.etl.container.Container;
import com.citi.retail.optima.etl.container.ContainerAdmin;
import com.citi.retail.optima.etl.container.jmx.ContainerUtil;

/**
 * This is a Junit class to test the shut down of controller component from container.
 * @author rs70128
 *
 */
@Ignore
public class ControllerShutDownTest {

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
				moduleConfigFile, true);
	}

	@Test
	public void testControllerShutDown() throws Exception {
		System.out.println("Controller module running?:" + admin.isModuleRunning(jmxHost, jmxPort));
		admin.stopModule(jmxHost, jmxPort);
		System.out.println("Controller module running?:" + admin.isModuleRunning(jmxHost, jmxPort));		
	}

}
