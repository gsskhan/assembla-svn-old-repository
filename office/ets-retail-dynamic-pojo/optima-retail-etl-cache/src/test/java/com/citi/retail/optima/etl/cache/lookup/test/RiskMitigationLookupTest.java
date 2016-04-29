package com.citi.retail.optima.etl.cache.lookup.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.cache.lookup.ReferenceValueLookup;

/**
 * @author TJ
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.referencedata.xml",
		"/optima.retail.cache.test.xml" })
public class RiskMitigationLookupTest {

	@Autowired
	private ReferenceValueLookup riskMitigationLookup;

	@Test
	public void testRiskMitigationLookup() throws Exception {
/*		Assert.assertTrue("01".equals(riskMitigationLookup
				.getSegmentationValue("riskMitigationCache", 5, "Y")));
		Assert.assertTrue("02".equals(riskMitigationLookup
				.getSegmentationValue("riskMitigationCache", 5, "N")));
		Assert.assertTrue("01".equals(riskMitigationLookup
				.getSegmentationValue("riskMitigationCache", 7, "Y")));
		Assert.assertTrue("02".equals(riskMitigationLookup
				.getSegmentationValue("riskMitigationCache", 7, "N")));
		Assert.assertNull(riskMitigationLookup.getSegmentationValue(
				"riskMitigationCache", 3, "X"));*/
	}

}
