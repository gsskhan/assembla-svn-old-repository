package com.citi.retail.optima.etl.cache.lookup.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.cache.lookup.OrigLtvBandLookup;

/**
 * @author sr67841
 * 
 */

@SuppressWarnings("unused")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.referencedata.xml",
		"/optima.retail.cache.test.xml" })
public class LtvRatioLookupTest {

	@Autowired
	private OrigLtvBandLookup origLtvBandLookup;

	@Test
	public void testLtvRatioLookup() throws Exception {
		/*
		 * Assert.assertTrue(this.ltvRationLookup.getSegmentationValue(
		 * "ltvRatioCache", 2, 60).equals("01"));
		 * Assert.assertTrue(this.ltvRationLookup.getSegmentationValue(
		 * "ltvRatioCache", 2, 80).equals("03"));
		 * Assert.assertTrue(this.ltvRationLookup.getSegmentationValue(
		 * "ltvRatioCache", 2, 60).equals("01")); Assert.assertEquals(null,
		 * this.ltvRationLookup.getSegmentationValue( "ltvRatioCache", 2,
		 * null)); Assert.assertEquals(null,
		 * this.ltvRationLookup.getSegmentationValue( "ltvRatioCache", 2,
		 * 9999999)); Assert.assertEquals("09",
		 * this.ltvRationLookup.getSegmentationValue( "ltvRatioCache", 2,
		 * -14534));
		 * Assert.assertTrue(this.ltvRationLookup.getSegmentationValue(
		 * "ltvRatioCache", 100, 50) == null);
		 */
	}

	@Test
	public void testLtvBandLookup() throws Exception {

		/*
		 * Assert.assertTrue(this.ltvRationLookup .getSegmentationValue("fico",
		 * 5, 58, "Citi").getSegCode() .equals(3));
		 */
	}

	@Test
	public void testLtvMapingLookup() throws Exception {

		Assert.assertTrue(this.origLtvBandLookup
				.deriveOutputSegmentation(2, 3, "User Reference", "Fed Reference")
				.getSegVal().equals("02"));
		Assert.assertTrue(this.origLtvBandLookup
				.getOrigLtvSegmentationValue(2, 72, "User Reference").getSegCode()
				.equals(2));
		Assert.assertEquals("12", this.origLtvBandLookup
				.getOutputSegmentationId(2, 1, "User Reference", "Fed Reference"));

	}
}