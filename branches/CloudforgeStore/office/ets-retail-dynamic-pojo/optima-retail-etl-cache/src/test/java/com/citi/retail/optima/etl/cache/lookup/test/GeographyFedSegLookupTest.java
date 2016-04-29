/**
 * 
 */
package com.citi.retail.optima.etl.cache.lookup.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.cache.lookup.ReferenceValueLookup;
import com.citi.retail.optima.etl.cache.model.GeographyFedSegVO;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;

/**
 * @author mc56120
 *
 */
@SuppressWarnings("unused")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.referencedata.xml",
		"/optima.retail.cache.test.xml" })
public class GeographyFedSegLookupTest {
	
	@Autowired
	private ReferenceValueLookup geographyFedSegLookup;

	@Test
	public void testCountryGeographyLookup() throws OptimaRetailApplicationException {
		@SuppressWarnings("unchecked")
		GeographyFedSegVO result = this.geographyFedSegLookup.getGeographyFedSeg(2,19);
		Assert.assertNotNull(result);
		Assert.assertTrue("Region 2".equalsIgnoreCase(result.getGeographyBndDescr()));
		
	}

}
