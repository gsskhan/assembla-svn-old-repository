package com.citi.retail.optima.etl.common;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author hs73849
 *
 */
public class ETLBatchStatusTest {

	@Test
	public void testBatchComplete() {
		Assert.assertEquals("BTH_COMP", ETLBatchStatus.BTH_COMP.name());
	}

	@Test
	public void testJobWaiting() {
		Assert.assertEquals("JOB_WAIT", ETLBatchStatus.JOB_WAIT.name());
	}

	@Test
	public void testJOB_INT() {
		Assert.assertEquals("JOB_INT", ETLBatchStatus.JOB_INT.name());
	}

	@Test
	public void testBatchStart() {
		Assert.assertEquals("BTH_STRT", ETLBatchStatus.BTH_STRT.name());
	}

	@Test
	public void testBatchFailed() {
		Assert.assertEquals("BTH_FAIL", ETLBatchStatus.BTH_FAIL.name());
	}

	@Test
	public void testJobCompleted() {
		Assert.assertEquals("JOB_COMP", ETLBatchStatus.JOB_COMP.name());
	}

	@Test
	public void testJobFailed() {
		Assert.assertEquals("JOB_FAIL", ETLBatchStatus.JOB_FAIL.name());
	}
}
