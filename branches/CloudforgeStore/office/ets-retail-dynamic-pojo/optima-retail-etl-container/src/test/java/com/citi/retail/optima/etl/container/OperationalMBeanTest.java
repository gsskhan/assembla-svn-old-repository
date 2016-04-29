package com.citi.retail.optima.etl.container;

import org.junit.Test;
import org.springframework.util.Assert;

public class OperationalMBeanTest extends AbstractStartedContainerTest {

	@Test
	public void testStopModule() throws Exception {
		admin.stopModule(jmxHost, jmxPort);		
	}

	@Test
	public void testStartModule() throws Exception {
		if (admin.isModuleRunning(jmxHost, jmxPort)) {
			admin.stopModule(jmxHost, jmxPort);		
		}
		admin.startModule(jmxHost, jmxPort);
		Assert.isTrue(admin.isModuleRunning(jmxHost, jmxPort),
				"Failed to start module!");
	}

	@Test
	public void testIsAlive() throws Exception {
		Assert.isTrue(admin.isModuleRunning(jmxHost, jmxPort),
				"Module is not running!");
	}
}
