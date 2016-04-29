package com.citi.retail.optima.etl.cache.lookup.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.cache.lookup.SourceCountryLookup;
import com.citi.retail.optima.etl.common.model.cache.SourceCountryDomain;

/**
 * @author sr67841
 * 
 */

@SuppressWarnings("unused")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.referencedata.test.xml",
		"/optima.retail.cache.test.xml" })
public class SourceCountryLookupTest {

	@Autowired
	private SourceCountryLookup srcCountryLookup;

	@Test
	public void testSrcRegionLookup() throws Exception {
		SourceCountryDomain domain = srcCountryLookup.getSourceCountry("CN",
				37l);
		Assert.assertTrue(domain.getTrgtCntryCd().equals("CN"));
	}

}