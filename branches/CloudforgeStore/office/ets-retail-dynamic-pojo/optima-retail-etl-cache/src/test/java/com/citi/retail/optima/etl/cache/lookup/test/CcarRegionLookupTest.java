package com.citi.retail.optima.etl.cache.lookup.test;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.cache.lookup.ReferenceValueLookup;

/**
 * @author sr67841
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.referencedata.xml",
		"/optima.retail.cache.test.xml" })
@Ignore
public class CcarRegionLookupTest {

	@Autowired
	private ReferenceValueLookup ccarregionLookup;

	@Test
	public void testCcarRegionLookup() throws Exception {
		Assert.assertEquals("00", this.ccarregionLookup.getSegmentationValue(
				"iccarRegionCache", "US"));
		Assert.assertEquals("01", this.ccarregionLookup.getSegmentationValue(
				"iccarRegionCache", "CA"));
		Assert.assertEquals("02", this.ccarregionLookup.getSegmentationValue(
				"iccarRegionCache", "GB"));
		Assert.assertEquals("03", this.ccarregionLookup.getSegmentationValue(
				"iccarRegionCache", "CO"));
		Assert.assertEquals("04", this.ccarregionLookup.getSegmentationValue(
				"iccarRegionCache", "AU"));
		Assert.assertEquals(null, this.ccarregionLookup.getSegmentationValue(
				"iccarRegionCache", "test"));
	}

}
