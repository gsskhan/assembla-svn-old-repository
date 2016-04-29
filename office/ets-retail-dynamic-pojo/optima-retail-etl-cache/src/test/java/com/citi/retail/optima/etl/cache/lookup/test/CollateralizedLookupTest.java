package com.citi.retail.optima.etl.cache.lookup.test;

import org.junit.Assert;
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

@SuppressWarnings("unused")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.referencedata.xml",
		"/optima.retail.cache.test.xml" })
public class CollateralizedLookupTest {

	@Autowired
	private ReferenceValueLookup collateralizedLookup;

	@Test
	public void testCollateralizedLookup() throws Exception {
		
		Assert.assertTrue(collateralizedLookup.getSegmentationValue("collateralizedCache",
				5, "1","Fed").equals("01"));
	}
}