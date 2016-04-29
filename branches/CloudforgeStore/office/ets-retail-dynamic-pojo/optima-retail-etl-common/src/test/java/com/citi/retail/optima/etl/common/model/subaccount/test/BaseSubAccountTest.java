/**
 * 
 */
package com.citi.retail.optima.etl.common.model.subaccount.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.citi.retail.optima.etl.common.model.AccountTraceabilityInfo;
import com.citi.retail.optima.etl.common.model.subaccount.BaseSubAccount;

/**
 * @author mc56120
 * 
 */
public class BaseSubAccountTest {

	private BaseSubAccount acct;

	@Before
	public void setUp() {
		acct = new DummySubAccount();
	}

	@Test
	public void testSetAccountTraceInfoList() {
		List<AccountTraceabilityInfo> traceList = new ArrayList<AccountTraceabilityInfo>();
		AccountTraceabilityInfo acctTrace = new AccountTraceabilityInfo();
		acctTrace.setAccountNumber("123456");
		acctTrace.setAggregationTypeId(1L);
		acctTrace.setProcessingUnitId(1);
		acctTrace.setBatchInstanceId(100L);
		traceList.add(acctTrace);
		acct.setAccountTraceInfoList(traceList);
		Assert.assertTrue(acct.getAccountTraceInfoList().size() > 0);
	}

	@Test
	public void testSetAccountNumber() {
		acct.setAccountNumber("123456");
		Assert.assertEquals("123456", acct.getAccountNumber());
	}

	@Test
	public void testSetPortfolioId() {
		acct.setPortfolioId("USE00001");
		Assert.assertEquals("USE00001", acct.getPortfolioId());
	}

	@Test
	public void testSetProductType() {
		acct.setProductType("CARDS");
		Assert.assertEquals("CARDS", acct.getProductType());
	}

	@Test
	public void testSetAccountOpenDate() {
		Date dd = new Date(new Date().getTime());
		acct.setAccountOpenDate(dd);
		Assert.assertEquals(dd, acct.getAccountOpenDate());
	}

	@Test
	public void testSetReportDate() {
		Date dd = new Date(new Date().getTime());
		acct.setReportDate(dd);
		Assert.assertEquals(dd, acct.getReportDate());
	}

	@Test
	public void testSetAcquisitionDate() {
		Date dd = new Date(new Date().getTime());
		acct.setAcquisitionDate(dd);
		Assert.assertEquals(dd, acct.getAcquisitionDate());
	}

}

class DummySubAccount extends BaseSubAccount {

}