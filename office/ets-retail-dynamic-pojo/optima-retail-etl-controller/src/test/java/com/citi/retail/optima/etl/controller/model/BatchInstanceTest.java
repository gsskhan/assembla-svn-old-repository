/**
 * 
 */
package com.citi.retail.optima.etl.controller.model;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author mc56120
 * 
 */

public class BatchInstanceTest {

	private BatchInstance batchInstance;

	@Before
	public void setUp() {
		batchInstance = new BatchInstance();
	}

	@Test
	public void testSetBatchId() {
		batchInstance.setBatchId(new Long(1));
		Assert.assertEquals(new Long(1), batchInstance.getBatchId());
	}

	@Test
	public void testSetMsdId() {
		batchInstance.setMsdId(new Long(1));
		Assert.assertEquals(new Long(1), batchInstance.getMsdId());
	}

	@Test
	public void testSetPortfolioId() {
		batchInstance.setPortfolioId("portfolioId");
		Assert.assertEquals("portfolioId", batchInstance.getPortfolioId());
	}

	@Test
	public void testSetBatchInstanceId() {
		batchInstance.setBatchInstanceId(new Long(1));
		Assert.assertEquals(new Long(1), batchInstance.getBatchInstanceId());
	}

	@Test
	public void testSetJobTypeId() {
		batchInstance.setJobTypeId(new Long(1));
		Assert.assertEquals(new Long(1), batchInstance.getJobTypeId());
	}

	@Test
	public void testSetThreadCount() {
		batchInstance.setThreadCount(new Integer(1));
		Assert.assertEquals(new Integer(1), batchInstance.getThreadCount());
	}

	@Test
	public void testSetWaitingStatus() {
		batchInstance.setWaitingStatus(new Integer(1));
		Assert.assertEquals(new Integer(1), batchInstance.getWaitingStatus());
	}

	@Test
	public void testSetCurrentPriority() {
		batchInstance.setCurrentPriority(new Integer(1));
		Assert.assertEquals(new Integer(1), batchInstance.getCurrentPriority());
	}

	@Test
	public void testSetStatus() {
		batchInstance.setStatus("SUCCESS");
		Assert.assertEquals("SUCCESS", batchInstance.getStatus());
	}
	
	@Test
	public void testSetJobId() {
		batchInstance.setJobId(1L);
		Assert.assertEquals(new Long(1), batchInstance.getJobId());
	}

	@Test
	public void testSetRequestDate() {
		java.sql.Date requestDate = new java.sql.Date(new Date().getTime());
		batchInstance.setRequestDate(requestDate);
		Assert.assertEquals(requestDate, batchInstance.getRequestDate());
	}
}
