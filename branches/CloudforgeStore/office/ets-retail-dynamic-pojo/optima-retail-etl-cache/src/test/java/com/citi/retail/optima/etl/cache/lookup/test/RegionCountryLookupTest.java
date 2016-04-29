package com.citi.retail.optima.etl.cache.lookup.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.cache.lookup.ReferenceValueLookup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.referencedata.test.xml",
		"/optima.retail.cache.test.xml" })
public class RegionCountryLookupTest {
	
	@Autowired
	private ReferenceValueLookup countryRegionLookup;
	
	@Test
	public void testTFormLookup() throws Exception {
		String regionCode = countryRegionLookup.getRegionByCountry("MD");
		System.out.println(regionCode);
	}
}
