package com.citi.retail.optima.etl.cache.lookup.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.cache.lookup.CountryLookup;
import com.citi.retail.optima.etl.cache.model.CountryVO;
import com.citi.retail.optima.etl.common.exception.OptimaRetailBaseException;

/**
 * 
 * @author mc56120
 *
 */
 

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.referencedata.xml",
		"/optima.retail.cache.test.xml" })
public class CountryLookupTest {

	@Autowired
	private CountryLookup countryLookup;

	@Test
	public void testCountryLookup() {
		CountryVO countryVo = null;
		try{
			countryVo = (CountryVO)this.countryLookup.getCountryForCode("TT");
			Assert.assertTrue(countryVo!=null);
		}catch(OptimaRetailBaseException e){
			Assert.fail();
		}
		countryVo=null;
		try{
			countryVo = (CountryVO)this.countryLookup.getCountryForCode("C1000");
			Assert.assertFalse(countryVo!=null);
		}catch(OptimaRetailBaseException e){
			Assert.fail();
		}
		
		try{
			countryVo = (CountryVO)this.countryLookup.getCountryForCode(null);
		}catch(OptimaRetailBaseException e){
			Assert.assertNotNull(e);
		}
		
	}
}
