/**
 * 
 */
package com.citi.retail.optima.etl.batch.vo.test;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.citi.retail.optima.etl.batch.vo.FeedPartitionDetailsVO;
import com.citi.retail.optima.etl.common.ETLBatchStatus;

/**
 * @author mc56120
 * 
 */
public class FeedPartitionDetailsVOTest {

	private FeedPartitionDetailsVO feedPartitionDetailsVO;

	@Before
	public void testSetUp() {
		feedPartitionDetailsVO = new FeedPartitionDetailsVO();
		feedPartitionDetailsVO.setFeedPartitionId(1);
		feedPartitionDetailsVO.setBatchInstanceId(121);
	}

	@Test
	public void testSetFeedPartitionId() {
		Assert.assertTrue(feedPartitionDetailsVO.getFeedPartitionId() == 1);
	}

	@Test
	public void testSetBatchInstanceId() {
		Assert.assertTrue(feedPartitionDetailsVO.getBatchInstanceId() == 121);
	}

	@Test
	public void testSetStatusCode() {
		feedPartitionDetailsVO.setStatusCode(ETLBatchStatus.BTH_STRT);
		Assert.assertEquals(ETLBatchStatus.BTH_STRT,
				feedPartitionDetailsVO.getStatusCode());
	}

	@Test
	public void testSetReportPeriod() {
		Date dd = new Date();
		feedPartitionDetailsVO.setReportPeriod(dd);
		Assert.assertEquals(dd, feedPartitionDetailsVO.getReportPeriod());
	}

	@Test
	public void testSetMinimumKey() {
		BigInteger minKey = new BigInteger("1");
		feedPartitionDetailsVO.setMinimumKey(minKey);
		Assert.assertEquals(minKey, feedPartitionDetailsVO.getMinimumKey());
	}

	@Test
	public void testSetMaximumKey() {
		BigInteger maxKey = new BigInteger("1000");
		feedPartitionDetailsVO.setMaximumKey(maxKey);
		Assert.assertEquals(maxKey, feedPartitionDetailsVO.getMaximumKey());
	}

	@Test
	public void testSetReadCount() {
		feedPartitionDetailsVO.setReadCount(100);
		Assert.assertTrue(feedPartitionDetailsVO.getReadCount() == 100);
	}

	@Test
	public void testSetProcessCount() {
		feedPartitionDetailsVO.setProcessCount(98);
		Assert.assertTrue(feedPartitionDetailsVO.getProcessCount() == 98);
	}

	@Test
	public void testSetExceptionCount() {
		feedPartitionDetailsVO.setExceptionCount(2);
		Assert.assertTrue(feedPartitionDetailsVO.getExceptionCount() == 2);
	}

	@Test
	public void testSetEndTimeStamp() {
		Timestamp ts = new Timestamp(new Date().getTime());
		feedPartitionDetailsVO.setEndTimeStamp(ts);
		Assert.assertEquals(ts, feedPartitionDetailsVO.getEndTimeStamp());
	}

	@Test
	public void testEquals() {
		FeedPartitionDetailsVO tmpFeedPartitionDetailsVO = new FeedPartitionDetailsVO();
		tmpFeedPartitionDetailsVO.setFeedPartitionId(1);
		tmpFeedPartitionDetailsVO.setBatchInstanceId(121);
		Assert.assertTrue(feedPartitionDetailsVO
				.equals(tmpFeedPartitionDetailsVO));

		tmpFeedPartitionDetailsVO.setFeedPartitionId(2);
		Assert.assertFalse(feedPartitionDetailsVO
				.equals(tmpFeedPartitionDetailsVO));

	}

}
