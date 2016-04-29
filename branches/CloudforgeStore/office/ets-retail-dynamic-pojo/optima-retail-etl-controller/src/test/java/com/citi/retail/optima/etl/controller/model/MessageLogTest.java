/**
 * 
 */
package com.citi.retail.optima.etl.controller.model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * @author mc56120
 * 
 */

public class MessageLogTest {

	private MessageLog messageLog;

	@Before
	public void setUp() {
		messageLog = new MessageLog();
	}

	@Test
	public void testSetMessageId() {
		messageLog.setMessageId(new Long(1));
		Assert.assertEquals(new Long(1), messageLog.getMessageId());
	}

	@Test
	public void testSetOrgMessageId() {
		messageLog.setOrgMessageId(new BigInteger("1"));
		Assert.assertEquals(new BigInteger("1"), messageLog.getOrgMessageId());
	}

	@Test
	public void testSetEventType() {
		messageLog.setEventType("PP-DATA-AVAILABLE");
		Assert.assertEquals("PP-DATA-AVAILABLE", messageLog.getEventType());
	}

	@Test
	public void testSetReqtrId() {
		messageLog.setReqtrId("TEST_REQSTRID");
		Assert.assertEquals("TEST_REQSTRID", messageLog.getReqtrId());
	}

	@Test
	public void testSetMessage() {
		messageLog.setMessage("MSG");
		Assert.assertEquals("MSG", messageLog.getMessage());
	}

	@Test
	public void testSetReceivedTime() {
		java.sql.Date receivedTime = new java.sql.Date(new Date().getTime());
		messageLog.setReceivedTime(receivedTime);
		Assert.assertEquals(receivedTime, messageLog.getReceivedTime());
	}

	@Test
	public void testSetMessageTypeId() {
		messageLog.setMessageTypeId("MSG_TYP_ID");
		Assert.assertEquals("MSG_TYP_ID", messageLog.getMessageTypeId());
	}

	@Test
	public void testSetPriority() {
		messageLog.setPriority(new BigInteger("1"));
		Assert.assertEquals(new BigInteger("1"), messageLog.getPriority());
	}

	@Test
	public void testSetRowCount() {
		messageLog.setRowCount(new BigInteger("1"));
		Assert.assertEquals(new BigInteger("1"), messageLog.getRowCount());
	}

	@Test
	public void testSetReptPeriod() {
		messageLog.setReptPeriod("RPT_PERIOD");
		Assert.assertEquals("RPT_PERIOD", messageLog.getReptPeriod());
	}

	@Test
	public void testSetJobInstId() {
		messageLog.setJobInstId(new BigInteger("1"));
		Assert.assertEquals(new BigInteger("1"), messageLog.getJobInstId());
	}

	@Test
	public void testSetPortfolioID() {
		messageLog.setPortfolioID("PORT_ID");
		Assert.assertEquals("PORT_ID", messageLog.getPortfolioID());
	}

	@Test
	public void testSetVersionID() {
		messageLog.setVersionID("VRN_ID");
		Assert.assertEquals("VRN_ID", messageLog.getVersionID());
	}

	@Test
	public void testSetApproverID() {
		messageLog.setApproverID("APPR_ID");
		Assert.assertEquals("APPR_ID", messageLog.getApproverID());
	}

	@Test
	public void testSetCountryCode() {
		messageLog.setCountryCode("CA");
		Assert.assertEquals("CA", messageLog.getCountryCode());
	}
	
	@Test
	public void testSetProductList() {
		List<String> productList = new ArrayList<String>();
		String productOne = new String("LOANS");
		String productTwo = new String("CARDS");
		productList.add(productOne);
		productList.add(productTwo);
		messageLog.setProductList(productList);
		Assert.assertEquals(productList.size(), messageLog.getProductList()
				.size());
	}

}
