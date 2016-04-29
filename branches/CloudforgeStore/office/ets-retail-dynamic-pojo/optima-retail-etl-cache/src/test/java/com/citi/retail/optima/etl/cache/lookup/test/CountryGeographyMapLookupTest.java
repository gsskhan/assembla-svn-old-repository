/**
 * 
 */
package com.citi.retail.optima.etl.cache.lookup.test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.cache.lookup.FDICReferenceLookup;
import com.citi.retail.optima.etl.cache.lookup.ReferenceValueLookup;
import com.citi.retail.optima.etl.cache.model.CountryGeographyMapVO;
import com.citi.retail.optima.etl.cache.model.PuToSysProcIdVO;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;

/**
 * @author mc56120
 *
 */
@SuppressWarnings("unused")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.referencedata.xml",
		"/optima.retail.cache.test.xml" })
public class CountryGeographyMapLookupTest {
	
	@Autowired
	private ReferenceValueLookup countryGeographyMapLookup;

	@Test
	public void testCountryGeographyLookup() throws OptimaRetailApplicationException {
		@SuppressWarnings("unchecked")
		CountryGeographyMapVO result = this.countryGeographyMapLookup.getGeographyByCountry("US",19);
		Assert.assertNotNull(result);
		Assert.assertTrue(61==result.getGeographyId());
		
	}

}
