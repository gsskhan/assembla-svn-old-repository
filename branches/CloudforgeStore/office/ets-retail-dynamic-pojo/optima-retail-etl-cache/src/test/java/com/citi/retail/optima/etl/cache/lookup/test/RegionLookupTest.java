package com.citi.retail.optima.etl.cache.lookup.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.citi.retail.optima.etl.cache.lookup.ReferenceValueLookup;
import com.citi.retail.optima.etl.cache.model.CountryVO;

/**
 * 
 * @author mc56120
 *
 */
 

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.referencedata.xml",
		"/optima.retail.cache.test.xml" })
public class RegionLookupTest {

	@Autowired
	private ReferenceValueLookup regionLookup;

	@Test
	public void testCountryLookup() throws Exception {
		CountryVO countryVo = (CountryVO)this.regionLookup.getSegmentationValue("countryCache", "IN");
		Assert.assertTrue(countryVo!=null);
		
	}
}
