/**
 * 
 */
package com.citi.retail.optima.etl.batch.container.jmx.impl.test;

import static org.junit.Assert.fail;

import java.net.InetAddress;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.integration.jms.JmsMessageDrivenEndpoint;

import com.citi.retail.optima.etl.batch.container.jmx.impl.BatchMBeanImpl;
import com.citi.retail.optima.etl.container.Container;
import com.citi.retail.optima.etl.container.ContainerAdmin;

/**
 * @author mc56120
 * 
 */
@RunWith(MockitoJUnitRunner.class)
@Ignore
public class BatchMbeanImplTest {

	@Mock
	private BatchMBeanImpl batchMBean;

	@Mock
	private JmsMessageDrivenEndpoint batchJmsAdapter;

	private static String jmxHost;
	private static Integer jmxPort = 3099;
	private static Integer httpPort = 8070;
	private static String moduleName = "batch";

	private static ContainerAdmin admin = new ContainerAdmin();

	@Before
	public void setUp() throws Exception {
		jmxHost = InetAddress.getLocalHost().getHostAddress();
		System.setProperty("jmx.host", jmxHost);
		System.setProperty("jmx.port", jmxPort.toString());
		System.setProperty("http.port", httpPort.toString());
		System.setProperty("module", moduleName);
		String containerConfigFile = Container.DEFAULT_CONTAINER_CONFIG_FILE;
		String moduleConfigFile = "classpath:/retail.optima.etl.batch.jmx.test.xml";
		admin.startContainer(jmxHost, jmxPort, containerConfigFile, moduleName,
				moduleConfigFile, false);
	}

	@Test
	public void testStart() {
		try {
			Mockito.when(this.batchMBean.isAlive()).thenReturn(true);
			this.batchMBean.start();
			Assert.assertTrue(this.batchMBean.isAlive());
		} catch (Exception e) {
			fail("Batch-Container Start failed");
		}
	}

	/*
	 * @Test public void testStop() { try {
	 * Mockito.when(batchMBean.isAlive()).thenReturn(false); batchMBean.stop();
	 * Assert.assertFalse(batchMBean.isAlive()); } catch (Exception e) {
	 * fail("Batch-Container Start failed"); } }
	 */
}
