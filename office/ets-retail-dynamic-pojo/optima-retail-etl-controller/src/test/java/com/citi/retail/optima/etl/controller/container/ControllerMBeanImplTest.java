/**
 * 
 */
package com.citi.retail.optima.etl.controller.container;

import static org.junit.Assert.fail;

import java.net.InetAddress;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.integration.jms.JmsMessageDrivenEndpoint;

import com.citi.retail.optima.etl.container.Container;
import com.citi.retail.optima.etl.container.ContainerAdmin;
import com.citi.retail.optima.etl.controller.container.jmx.impl.ControllerMBeanImpl;


/**
 * @author hs73849
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ControllerMBeanImplTest {

	@Mock
	private ControllerMBeanImpl controllerMBean;

	@Mock
	private JmsMessageDrivenEndpoint genesisJmsAdapter;
	
	@Mock
	private JmsMessageDrivenEndpoint internalJmsAdapter;
	

	private static String jmxHost;
	private static Integer jmxPort = 3099;
	private static Integer httpPort = 8070;
	private static String moduleName = "controller";

	private static ContainerAdmin admin = new ContainerAdmin();

	@Before
	public void setUp() throws Exception {
		jmxHost = InetAddress.getLocalHost().getHostAddress();
		System.setProperty("jmx.host", jmxHost);
		System.setProperty("jmx.port", jmxPort.toString());
		System.setProperty("http.port", httpPort.toString());
		System.setProperty("module", moduleName);
		String containerConfigFile = Container.DEFAULT_CONTAINER_CONFIG_FILE;
		String moduleConfigFile = "classpath:/retail.optima.etl.controller.jmx.test.xml";
		admin.startContainer(jmxHost, jmxPort, containerConfigFile, moduleName,
				moduleConfigFile, false);
	}

	@Test
	public void testStart() {
		try {
			Mockito.when(controllerMBean.isAlive()).thenReturn(true);
			controllerMBean.start();
			Assert.assertTrue(controllerMBean.isAlive());
		} catch (Exception e) {
			fail("Controller - Container Start failed");
		}
	}
}
