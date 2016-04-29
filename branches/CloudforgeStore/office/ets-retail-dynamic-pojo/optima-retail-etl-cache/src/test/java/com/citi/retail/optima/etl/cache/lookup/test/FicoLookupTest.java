package com.citi.retail.optima.etl.cache.lookup.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.cache.lookup.FicoBandLookup;

/**
 * @author sr67841
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.referencedata.xml",
		"/optima.retail.cache.test.xml" })
public class FicoLookupTest {

	@Autowired
	private FicoBandLookup ficoLookup;

	/*
	 * @Test
	 * 
	 * @Ignore public void testFicoLookup() throws Exception {
	 * Assert.assertEquals("01",
	 * this.ficoLookup.getSegmentationValue("ficoCache", 2, 60));
	 * Assert.assertEquals(null,
	 * this.ficoLookup.getSegmentationValue("ficoCache", 100, 60));
	 * 
	 * Assert.assertEquals("02",
	 * this.ficoLookup.getSegmentationValue("ficoCache", 2, 620));
	 * Assert.assertEquals("02",
	 * this.ficoLookup.getSegmentationValue("ficoCache", 2, 630));
	 * Assert.assertEquals(null,
	 * this.ficoLookup.getSegmentationValue("ficoCache", 2, null));
	 * Assert.assertEquals(null,
	 * this.ficoLookup.getSegmentationValue("ficoCache", 2, 999999999));
	 * Assert.assertEquals("03",
	 * this.ficoLookup.getSegmentationValue("ficoCache", 2, 660));
	 * Assert.assertEquals("09",
	 * this.ficoLookup.getSegmentationValue("ficoCache", 2, -4565)); }
	 */

	@Test
	public void testFicoBandLookup() throws Exception {

		Assert.assertTrue(this.ficoLookup
				.getFicoSegmentationValue(2, 600, "User Reference").getSegCode()
				.equals(1));
		Assert.assertEquals("12", this.ficoLookup.getOutputSegmentationId(2, 1, "User Reference", "Fed Reference"));

	}

	@Test
	public void testFicoMapingLookup() throws Exception {

		Assert.assertTrue(this.ficoLookup
				.deriveOutputSegmentation(2, 2, "User Reference", "Fed Reference")
				.getSegVal().equals("01"));

	}

}
