package com.citi.retail.optima.etl.batch.test.container;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.util.Assert;

import com.citi.retail.optima.etl.container.Container;
import com.citi.retail.optima.etl.container.ContainerAdmin;
import com.citi.retail.optima.etl.container.jmx.ContainerUtil;

/**
 * This JUnit class has the implementation to test the Start container and Batch
 * module.
 * 
 * @author mk67854
 * 
 */

@Ignore
public class ContainerBatchStartupTest {

	private final Container container = Container.getInstance();

	private static String jmxHost;
	private static Integer jmxPort = 1099;
	private static Integer httpPort = 8080;

	private static String moduleName;

	@BeforeClass
	public static void setUp() throws Exception {
		ContainerAdmin admin = new ContainerAdmin();

		jmxHost = ContainerUtil.getJmxHost(true);

		moduleName = "BatchModule";
		System.setProperty("module", moduleName);

		System.setProperty("http.port", httpPort.toString());

		String containerConfigFile = Container.DEFAULT_CONTAINER_CONFIG_FILE;
		String moduleConfigFile = "classpath:/batch.module.container.jmx.test.xml";

		admin.startContainer(jmxHost, jmxPort, containerConfigFile, moduleName,
				moduleConfigFile, true);
	}

	@Test
	public void testStartupContainer() throws Exception {
		Assert.notNull(this.container.getContainerJVMStatusJsonString(false),
				"Container is not running!");

		ContainerAdmin admin = new ContainerAdmin();
		Assert.isTrue(admin.isModuleRunning(jmxHost, jmxPort),
				"Module is not running!");
	}

}
