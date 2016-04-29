/**
 * 
 */
package com.citi.retail.optima.etl.controller.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author hs73849
 * 
 */
public class ResourceManagerStatusTest {

	@Test
	public void testResAvailableStatus() {
		Assert.assertEquals("RESOURCE_AVAILABLE", ResourceManagerStatus.RESOURCE_AVAILABLE.name());
	}

	@Test
	public void testResNotAvailStatus() {
		Assert.assertEquals("RESOURCE_NOT_AVAILABLE", ResourceManagerStatus.RESOURCE_NOT_AVAILABLE.name());
	}

	@Test
	public void testNewRequestStatus() {
		Assert.assertEquals("NEW_REQUEST",
				ResourceManagerStatus.NEW_REQUEST.name());
	}

	@Test
	public void testCompletionStatus() {
		Assert.assertEquals("COMPLETED",
				ResourceManagerStatus.COMPLETED.name());
	}
	
	@Test
	public void testRunningStatus() {
		Assert.assertEquals("RUNNING",
				ResourceManagerStatus.RUNNING.name());
	}
}
