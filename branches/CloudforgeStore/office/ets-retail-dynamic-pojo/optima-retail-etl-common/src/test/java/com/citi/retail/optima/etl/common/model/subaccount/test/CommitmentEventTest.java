/**
 * 
 */
package com.citi.retail.optima.etl.common.model.subaccount.test;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.citi.retail.optima.etl.common.model.subaccount.CommitmentEvent;

/**
 * @author hs73849
 * 
 */
public class CommitmentEventTest {

	private CommitmentEvent acct;

	@Before
	public void setUp() {
		acct = new CommitmentEvent();
	}

	@Test
	public void testAccountLimitEventCd() {
		acct.setAccountLimitEventCd("TEST_EVENT_CODE");
		Assert.assertEquals(acct.getAccountLimitEventCd(), "TEST_EVENT_CODE");
	}

	@Test
	public void testAccountLimitEventAmount() {
		acct.setAccountLimitEventAmount(12.34);
		Assert.assertEquals(acct.getAccountLimitEventAmount(),
				new Double(12.34));
	}

	@Test
	public void testAccountLimitEventInitCd() {
		acct.setAccountLimitEventInitCd("TEST_EVENT_INT_CODE");
		Assert.assertEquals(acct.getAccountLimitEventInitCd(),
				"TEST_EVENT_INT_CODE");
	}

	@Test
	public void testECommitmentIncAmt() {
		acct.seteCommitmentIncAmt(12.34);
		Assert.assertEquals(acct.geteCommitmentIncAmt(), new Double(12.34));
	}

	@Test
	public void testECommitmentDecAmt() {
		acct.seteCommitmentDecAmt(12.34);
		Assert.assertEquals(acct.geteCommitmentDecAmt(), new Double(12.34));
	}

	@Test
	public void testAccountLimitEventDate() {
		Date dd = new Date(new Date().getTime());
		acct.setAccountLimitEventDate(dd);
		Assert.assertEquals(dd, acct.getAccountLimitEventDate());
	}
}
