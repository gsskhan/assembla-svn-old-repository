/**
 * 
 */
package com.citi.retail.optima.etl.common.model.subaccount.test;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.citi.retail.optima.etl.common.model.subaccount.DeliquencySubAccountAttribute;

/**
 * @author hs73849
 * 
 */
public class DeliquencySubAccountAttributeTest {

	private DeliquencySubAccountAttribute acct;

	@Before
	public void setUp() {
		acct = new DeliquencySubAccountAttribute();
	}

	@Test
	public void testDeliquencyStartDt() {
		Date dd = new Date(new Date().getTime());
		acct.setDeliquencyStartDt(dd);
		Assert.assertEquals(dd, acct.getDeliquencyStartDt());
	}

	@Test
	public void testDeliquencyEndDt() {
		Date dd = new Date(new Date().getTime());
		acct.setDeliquencyEndDt(dd);
		Assert.assertEquals(dd, acct.getDeliquencyEndDt());
	}

	@Test
	public void testEDelinquentStatus() {
		acct.setEDelinquentStatus("TEST_DELQ_STATUS");
		Assert.assertEquals(acct.getEDelinquentStatus(), "TEST_DELQ_STATUS");
	}

	@Test
	public void testEDaysPastDue() {
		acct.setEDaysPastDue(1);
		Assert.assertEquals(acct.getEDaysPastDue(), new Integer(1));
	}

	@Test
	public void testDeliquencyDuration() {
		acct.setDeliquencyDuration(1);
		Assert.assertEquals(acct.getDeliquencyDuration(), new Integer(1));
	}
}
