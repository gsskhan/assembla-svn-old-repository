/**
 * 
 */
package com.citi.retail.optima.etl.controller.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author hs73849
 * 
 */
public class RequestMessageTypeTest {

	@Test
	public void testGenesisType() {
		Assert.assertEquals("GENESIS", RequestMessageType.GENESIS.name());
	}

	@Test
	public void testManualType() {
		Assert.assertEquals("MANUAL", RequestMessageType.MANUAL.name());
	}

	@Test
	public void testNewRequestType() {
		Assert.assertEquals("NEW_REQUEST",
				RequestMessageType.NEW_REQUEST.name());
	}

	@Test
	public void testBatchCompletionType() {
		Assert.assertEquals("BATCH_COMPLETION",
				RequestMessageType.BATCH_COMPLETION.name());
	}
}
