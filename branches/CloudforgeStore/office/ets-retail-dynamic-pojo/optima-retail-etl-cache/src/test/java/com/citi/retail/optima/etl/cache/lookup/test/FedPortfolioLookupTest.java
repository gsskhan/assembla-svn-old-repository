package com.citi.retail.optima.etl.cache.lookup.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.cache.lookup.ReferenceValueLookup;


/**
 * @author hp44940
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.referencedata.xml",
		"/optima.retail.cache.test.xml" })
public class FedPortfolioLookupTest {
	@Autowired
	private ReferenceValueLookup fedPortfolioValueLookup;

	@Test
	public void testfedPortfolioLookup() throws Exception {		
		Integer fedProcessingUnitId = 1;
		Assert.assertTrue("INTFM".equalsIgnoreCase((String)this.fedPortfolioValueLookup.getSegmentationValue("fedPortfolioCache", 	fedProcessingUnitId)));	
	}
}