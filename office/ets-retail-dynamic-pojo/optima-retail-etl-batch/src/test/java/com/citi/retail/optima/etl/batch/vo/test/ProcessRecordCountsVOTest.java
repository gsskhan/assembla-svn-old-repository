package com.citi.retail.optima.etl.batch.vo.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.citi.retail.optima.etl.batch.vo.ProcessRecordCountsVO;

public class ProcessRecordCountsVOTest {

	private ProcessRecordCountsVO processRecordCountsVO;

	@Before
	public void setUp() {
		processRecordCountsVO = new ProcessRecordCountsVO();
		processRecordCountsVO.setFeedPartitionId(1);
		processRecordCountsVO.setProcessTypeCode("Test");
	}

	@Test
	public void setReadCount() {
		processRecordCountsVO.setReadCount(100);
		Assert.assertTrue(processRecordCountsVO.getReadCount() == 100);
	}

	@Test
	public void setProcessedCount() {
		processRecordCountsVO.setProcessedCount(100);
		Assert.assertTrue(processRecordCountsVO.getProcessedCount() == 100);
	}

	@Test
	public void setSkippedCount() {
		processRecordCountsVO.setSkippedCount(2);
		Assert.assertTrue(processRecordCountsVO.getSkippedCount() == 2);
	}

	@Test
	public void setProcessTypeCode() {
		Assert.assertEquals("Test", processRecordCountsVO.getProcessTypeCode());
	}

	@Test
	public void setFeedPartitionId() {

		Assert.assertTrue(processRecordCountsVO.getFeedPartitionId() == 1);
	}

	@Test
	public void setBatchInstanceId() {
		processRecordCountsVO.setBatchInstanceId(121);
		Assert.assertTrue(processRecordCountsVO.getBatchInstanceId() == 121);
	}

	@Test
	public void testEquals() {
		ProcessRecordCountsVO tmpProcessRecordCountsVO = new ProcessRecordCountsVO();
		tmpProcessRecordCountsVO.setFeedPartitionId(1);
		tmpProcessRecordCountsVO.setProcessTypeCode("Test");
		Assert.assertTrue(processRecordCountsVO
				.equals(tmpProcessRecordCountsVO));
		ProcessRecordCountsVO tmpFalseProcessRecordCountsVO = new ProcessRecordCountsVO();
		tmpFalseProcessRecordCountsVO.setFeedPartitionId(2);
		tmpFalseProcessRecordCountsVO.setProcessTypeCode("Test");
		Assert.assertFalse(processRecordCountsVO
				.equals(tmpFalseProcessRecordCountsVO));
		Assert.assertFalse(processRecordCountsVO.equals(new Object()));
	}

	@Test
	public void testHashCode() {
		System.out.println(processRecordCountsVO.hashCode());
		Assert.assertEquals(2604178, processRecordCountsVO.hashCode());
	}
}
