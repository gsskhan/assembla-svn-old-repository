package com.citi.retail.optima.etl.cache.lookup.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.cache.lookup.AgeBandLookup;

/**
 * @author sr67841
 * 
 */

@SuppressWarnings("unused")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.referencedata.xml",
		"/optima.retail.cache.test.xml" })
public class AgeLookupTest {

	@Autowired
	private AgeBandLookup ageLookup;

	@Test
	public void testAgeLookup() throws Exception {
		/*
		 * Assert.assertTrue(this.ageLookup .getSegmentationValue("ageCache", 7,
		 * 36).equals("04"));
		 * Assert.assertTrue(this.ageLookup.getSegmentationValue("ageCache", 7,
		 * 0) .equals("01")); Assert.assertTrue(this.ageLookup
		 * .getSegmentationValue("ageCache", 7, 21).equals("02"));
		 * Assert.assertTrue(this.ageLookup.getSegmentationValue("ageCache",
		 * 100, 50) == null);
		 * Assert.assertTrue(this.ageLookup.getSegmentationValue("ageCache", 7,
		 * -45).equals("09"));
		 * Assert.assertTrue(this.ageLookup.getSegmentationValue("ageCache", 7,
		 * 999999999) == null);
		 */

		Assert.assertTrue(this.ageLookup
				.getAgeSegmentationValue(2, 21, "User Reference").getSegCode()
				.equals(2));
		Assert.assertEquals("14", this.ageLookup.getOutputSegmentationId(2, 1, "User Reference", "Fed Reference"));
	}

	@Test
	public void testAgeMapingLookup() throws Exception {

		Assert.assertTrue(this.ageLookup
				.deriveOutputSegmentation(2, 1, "User Reference", "Fed Reference")
				.getSegVal().equals("01"));

	}
}