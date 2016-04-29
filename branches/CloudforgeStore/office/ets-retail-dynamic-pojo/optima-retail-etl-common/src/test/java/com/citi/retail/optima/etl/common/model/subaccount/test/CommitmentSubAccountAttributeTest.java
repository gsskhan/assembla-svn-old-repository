/**
 * 
 */
package com.citi.retail.optima.etl.common.model.subaccount.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.citi.retail.optima.etl.common.model.subaccount.CommitmentSubAccountAttribute;

/**
 * @author hs73849
 * 
 */
public class CommitmentSubAccountAttributeTest {

	private CommitmentSubAccountAttribute acct;

	@Before
	public void setUp() {
		acct = new CommitmentSubAccountAttribute();
	}

	@Test
	public void testCommitmentIncrease() {
		acct.setCommitmentIncrease(12.34);
		Assert.assertEquals(acct.getCommitmentIncrease(), new Double(12.34));
	}

	@Test
	public void testCommitmentDecrease() {
		acct.setCommitmentDecrease(12.34);
		Assert.assertEquals(acct.getCommitmentDecrease(), new Double(12.34));
	}
}
