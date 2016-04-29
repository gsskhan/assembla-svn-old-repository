package com.citi.retail.optima.etl.container;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.util.Assert;

import com.citi.retail.optima.etl.container.jmx.ContainerUtil;

public class ContainerStartupTest {
	private static String jmxHost;
	protected static Integer jmxPort = 1112;
	protected static Integer httpPort = 8083;

	private static String moduleName = "module";
	

	@BeforeClass
	public static void setUp() throws Exception {
		jmxHost = ContainerUtil.getJmxHost(true);
		System.setProperty("http.port", httpPort.toString());
	}
	
	@Ignore
	@Test
	public void testStartupContainer() throws Exception {
		ContainerAdmin admin = new ContainerAdmin();

		String containerConfigFile = Container.DEFAULT_CONTAINER_CONFIG_FILE;
		String moduleConfigFile = "classpath:/optima.retail.etl.module.test.xml";
		admin.startContainer(jmxHost, jmxPort, containerConfigFile, moduleName,
			moduleConfigFile, true);
		Assert.notNull(admin.retrieveJvmStatus(jmxHost, jmxPort, false),
				"Container is not running!");	
		admin.stopContainer(jmxHost, jmxPort);
	}
	

}
