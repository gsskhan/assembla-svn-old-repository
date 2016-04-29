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
public class FDICRegionLookupTest {

	@Autowired
	private ReferenceValueLookup regionLookup;

	@Test
	public void testfdicRegionLookup() throws Exception {
		Assert.assertEquals("01",
				this.regionLookup.getSegmentationValue("fdicRegionCache", "US"));
		Assert.assertEquals("01",
				this.regionLookup.getSegmentationValue("fdicRegionCache", "CA"));
		Assert.assertEquals("02",
				this.regionLookup.getSegmentationValue("fdicRegionCache", "GB"));
		Assert.assertEquals("03",
				this.regionLookup.getSegmentationValue("fdicRegionCache", "CO"));
		Assert.assertEquals("04",
				this.regionLookup.getSegmentationValue("fdicRegionCache", "AU"));
		Assert.assertEquals(null, this.regionLookup.getSegmentationValue(
				"fdicRegionCache", "test"));
	}

}
