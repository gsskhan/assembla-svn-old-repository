package com.citi.retail.optima.etl.cache.lookup.test;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.cache.lookup.ReferenceValueLookup;
import com.citi.retail.optima.etl.cache.lookup.VintageBandLookup;

/**
 * @author sv16441
 * 
 */

@SuppressWarnings("unused")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.referencedata.xml",
		"/optima.retail.cache.test.xml" })
public class VintageLookupTest {

	@Autowired
	private VintageBandLookup vintageLookup;

	@Test	
	public void testVintageLookup() throws Exception {		
		Assert.assertTrue(vintageLookup.getVintageSegmentationValue(25,"1","User Reference")!=null);
		Assert.assertFalse(vintageLookup.getVintageSegmentationValue(25,"10","User Reference")!=null);
	}
}