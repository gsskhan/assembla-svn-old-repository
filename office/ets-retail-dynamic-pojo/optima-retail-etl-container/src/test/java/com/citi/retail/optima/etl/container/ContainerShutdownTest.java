package com.citi.retail.optima.etl.container;

import javax.management.JMException;

import org.junit.Test;

public class ContainerShutdownTest  extends AbstractStartedContainerTest {
	
	
	@Test(expected = JMException.class)
	public void testShutdownContainer() throws Exception {
		admin.stopContainer(jmxHost, jmxPort);

		// it should throw a JMException because the container has been shutdown
		admin.retrieveJvmStatus(jmxHost, jmxPort, false);
	}	
}
