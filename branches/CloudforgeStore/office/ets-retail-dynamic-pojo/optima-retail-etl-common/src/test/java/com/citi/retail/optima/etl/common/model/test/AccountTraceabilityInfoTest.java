/**
 * 
 */
package com.citi.retail.optima.etl.common.model.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.citi.retail.optima.etl.common.model.AccountTraceabilityInfo;

/**
 * @author hs73849
 * 
 */
public class AccountTraceabilityInfoTest {

	private AccountTraceabilityInfo acct;

	@Before
	public void setUp() {
		acct = new AccountTraceabilityInfo();
	}

	@Test
	public void testAccountTraceObj() {
		acct.setAggregationTypeId(1L);
		Assert.assertEquals(acct.getAggregationTypeId(), new Long(1L));

		acct.setAggregationTypeName("AGGR_TYP_NAME");
		Assert.assertEquals(acct.getAggregationTypeName(), "AGGR_TYP_NAME");

		acct.setBatchInstanceId(1L);
		Assert.assertEquals(acct.getBatchInstanceId(), new Long(1L));

		acct.setAccountNumber("123456");
		Assert.assertEquals(acct.getAccountNumber(), "123456");

		acct.setProcessingUnitId(1);
		Assert.assertEquals(acct.getProcessingUnitId(), new Integer(1));
	}
}
