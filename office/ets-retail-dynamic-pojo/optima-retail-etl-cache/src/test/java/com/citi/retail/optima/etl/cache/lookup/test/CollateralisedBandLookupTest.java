package com.citi.retail.optima.etl.cache.lookup.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.cache.lookup.AgeBandLookup;
import com.citi.retail.optima.etl.cache.lookup.CollateralisedBandLookup;

/**
 * @author sr67841
 * 
 */

@SuppressWarnings("unused")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.referencedata.xml",
		"/optima.retail.cache.test.xml" })
public class CollateralisedBandLookupTest {

	@Autowired
	private CollateralisedBandLookup collateralisedLookup;

	@Test
	public void testCollateralisedLookup() throws Exception {		
		//collateralised flag is not available for PU=1
		Assert.assertNull(this.collateralisedLookup.getOutputSegmentationId(1, 1, "User Reference", "Fed Reference"));
		
		Assert.assertEquals("4", this.collateralisedLookup.getOutputSegmentationId(5, 1, "User Reference", "Fed Reference"));
	}

	@Test
	public void testCollateralisedMapingLookup() throws Exception {
		Assert.assertTrue(this.collateralisedLookup
				.deriveOutputSegmentation(5, 9, "User Reference", "Fed Reference")
				.getSegVal().equals("02"));
	}
	
	@Test
	public void testCollateralisedValueLookup() throws Exception {		
		Assert.assertNotNull(this.collateralisedLookup.getCollateralisedSegmentationValue(5, 1, "User Reference"));
	}
}