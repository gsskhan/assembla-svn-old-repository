package com.citi.retail.optima.etl.batch.vo.test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.citi.retail.optima.etl.batch.vo.BatchDetailsVO;
import com.citi.retail.optima.etl.common.ETLBatchStatus;

public class BatchDetailsVOTest {

	private BatchDetailsVO batchDetailsVO;

	@Before
	public void testSetUp() {
		batchDetailsVO = new BatchDetailsVO();
		batchDetailsVO.setBatchInstanceId(121);
	}

	@Test
	public void testSetBatchInstanceId() {
		Assert.assertTrue(batchDetailsVO.getBatchInstanceId() == 121);
	}

	@Test
	public void testSetBatchId() {
		batchDetailsVO.setBatchId(111);
		Assert.assertTrue(batchDetailsVO.getBatchId() == 111);
	}

	@Test
	public void testSetThreadCount() {
		batchDetailsVO.setThreadCount(5);
		Assert.assertTrue(batchDetailsVO.getThreadCount() == 5);
	}

	@Test
	public void testSetReportPeriod() {
		Date dd = new Date();
		batchDetailsVO.setReportPeriod(dd);
		Assert.assertEquals(dd, batchDetailsVO.getReportPeriod());
	}

	@Test
	public void testSetBatchName() {
		batchDetailsVO.setBatchName("CardsJob");
		Assert.assertEquals("CardsJob", batchDetailsVO.getBatchName());
	}

	@Test
	public void testSetPortfolioId() {
		batchDetailsVO.setPortfolioId("TestPortfolioId");
		Assert.assertEquals("TestPortfolioId", batchDetailsVO.getPortfolioId());
	}

	@Test
	public void testSetProductName() {
		batchDetailsVO.setProductName("CARDS");
		Assert.assertEquals("CARDS", batchDetailsVO.getProductName());
	}

	@Test
	public void testSetProcessingUnitIdList() {
		List<Integer> processingUnitList = new ArrayList<Integer>();
		processingUnitList.add(1);
		processingUnitList.add(2);
		batchDetailsVO.setProcessingUnitIdList(processingUnitList);
		Assert.assertTrue(batchDetailsVO.getProcessingUnitIdList().size() == 2);

	}

	@Test
	public void testSetThreshold() {
		batchDetailsVO.setThreshold(10);
		Assert.assertTrue(batchDetailsVO.getThreshold() == 10);
	}

	@Test
	public void testSetRowCount() {
		batchDetailsVO.setRowCount(1000);
		Assert.assertTrue(batchDetailsVO.getRowCount() == 1000);
	}

	@Test
	public void testSetOriginalMessageId() {
		batchDetailsVO.setOriginalMessageId(200L);
		Assert.assertTrue(batchDetailsVO.getOriginalMessageId() == 200L);
	}

	@Test
	public void testSetStatusCode() {
		batchDetailsVO.setStatusCode(ETLBatchStatus.BTH_STRT.toString());
		Assert.assertEquals(ETLBatchStatus.BTH_STRT.toString(),
				batchDetailsVO.getStatusCode());
	}

	@Test
	public void testSetExceptionCount() {
		batchDetailsVO.setExceptionCount(2);
		Assert.assertTrue(batchDetailsVO.getExceptionCount() == 2);
	}

	@Test
	public void testSetProcessCount() {
		batchDetailsVO.setProcessCount(100);
		Assert.assertTrue(batchDetailsVO.getProcessCount() == 100);
	}

	@Test
	public void testSetEndTimeStamp() {
		Timestamp ts = new Timestamp(new Date().getTime());
		batchDetailsVO.setEndTimeStamp(ts);
		Assert.assertEquals(ts, batchDetailsVO.getEndTimeStamp());
	}

	@Test
	public void testSetEventTimestamp() {
		Timestamp ts = new Timestamp(new Date().getTime());
		batchDetailsVO.setEventTimestamp(ts);
		Assert.assertEquals(ts, batchDetailsVO.getEventTimestamp());
	}

	@Test
	public void testProcessingUnitListString() {
		List<Integer> processingUnitList = new ArrayList<Integer>();
		processingUnitList.add(1);
		processingUnitList.add(2);
		batchDetailsVO.setProcessingUnitIdList(processingUnitList);
		// System.out.println(batchDetailsVO.processingUnitListString());
		Assert.assertEquals("1,2", batchDetailsVO.processingUnitListString());
	}

	@Test
	public void testConvertProductListString() {
		List<String> productList = new ArrayList<String>();
		productList.add("CA_CC");
		productList.add("CA_BC");
		String convertString = "'CA_CC','CA_BC'";
		Assert.assertEquals(convertString,
				batchDetailsVO.convertProductListString(productList));
	}

	@Test
	public void testEquals() {
		BatchDetailsVO tmpBatchDetailsVO = new BatchDetailsVO();
		tmpBatchDetailsVO.setBatchInstanceId(121);
		Assert.assertTrue(batchDetailsVO.equals(tmpBatchDetailsVO));

		tmpBatchDetailsVO.setBatchInstanceId(123);
		Assert.assertFalse(batchDetailsVO.equals(tmpBatchDetailsVO));
		
		Assert.assertFalse(batchDetailsVO.equals(new Object()));
		Assert.assertTrue(batchDetailsVO.toString().startsWith("batchInstanceId"));
		Assert.assertEquals(152, batchDetailsVO.hashCode());
		
	}
}
