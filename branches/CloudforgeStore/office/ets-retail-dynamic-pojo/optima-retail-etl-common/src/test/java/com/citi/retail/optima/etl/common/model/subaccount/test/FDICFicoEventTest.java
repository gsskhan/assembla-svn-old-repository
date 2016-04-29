package com.citi.retail.optima.etl.common.model.subaccount.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.citi.retail.optima.etl.common.model.subaccount.FDICFicoEvent;

/**
 * @author sv16441
 * 
 */
public class FDICFicoEventTest {

	private FDICFicoEvent acct;

	@Before
	public void setUp() {
		acct = new FDICFicoEvent();
	}

	@Test
	public void testFicoScore() {
		acct.setFicoScore(10);
		Assert.assertEquals(acct.getFicoScore(), new Integer(10));
	}

	@Test
	public void testModelVersion() {
		acct.setModelVersion("Test Model Version");
		Assert.assertEquals(acct.getModelVersion(), new String(
				"Test Model Version"));
	}

	@Test
	public void testBureau() {
		acct.setCreditBureau("TEST_BUREAU");
		Assert.assertEquals(acct.getCreditBureau(), "TEST_BUREAU");
	}

	@Test
	public void testEventType() {
		acct.setEventType("TEST_EVENT_TYPE");
		Assert.assertEquals(acct.getEventType(), new String("TEST_EVENT_TYPE"));
	}

	@Test
	public void testAccountNumber() {
		acct.setAccountNumber("TEST_ACC_NUMBER");
		Assert.assertEquals(acct.getAccountNumber(), new String(
				"TEST_ACC_NUMBER"));
	}

	@Test
	public void testPortfolioID() {
		acct.setPortfolioId("TEST_PORT_ID");
		Assert.assertEquals(acct.getPortfolioId(), new String("TEST_PORT_ID"));
	}

	@Test
	public void testFicoEventType() {
		acct.setEventType("C");
		Assert.assertEquals(acct.getEventType(), "C");
	}
}
