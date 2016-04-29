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
public class ProductLookupTest {

	
	
	@Autowired
	private ReferenceValueLookup productLookup;

	@Test
	public void testProductLookup() throws Exception {
		Assert.assertEquals(productLookup.getSegmentationValue("productCache",2, "RE_HL"), "01");
		Assert.assertEquals(productLookup.getSegmentationValue("productCache",3, "CA_CC"), "02");
	}

}
