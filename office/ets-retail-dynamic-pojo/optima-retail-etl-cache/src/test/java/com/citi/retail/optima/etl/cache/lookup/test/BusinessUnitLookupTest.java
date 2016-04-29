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
// This test case is ignored since the ORR_PORT_TO_BU_MAP table does not have
// the data for required portfolios. Needs to be reverted back once data is
// available.
@Ignore
public class BusinessUnitLookupTest {

	@Autowired
	private ReferenceValueLookup regionLookup;

	@Test
	public void testfdicRegionLookup() throws Exception {
		Assert.assertEquals("BU1", this.regionLookup.getSegmentationValue(
				"fdicBusinessUnitCache", "CA102"));
		Assert.assertEquals("BU2", this.regionLookup.getSegmentationValue(
				"fdicBusinessUnitCache", "CA103"));
		Assert.assertEquals(null, this.regionLookup.getSegmentationValue(
				"fdicBusinessUnitCache", "test"));
	}
}
