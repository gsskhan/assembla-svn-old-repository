package com.citi.retail.optima.etl.cache.lookup.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.cache.lookup.ProductBandLookup;
import com.citi.retail.optima.etl.common.exception.OptimaRetailBaseException;
import com.citi.retail.optima.etl.common.model.cache.ProductBandDomain;

/**
 * 
 * @author mc56120
 *
 */
 

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.referencedata.xml",
		"/optima.retail.cache.test.xml" })
public class ProductBandLookupTest {

	@Autowired
	private ProductBandLookup productLookup;

	@Test
	public void testCountryLookup() {
		ProductBandDomain productBand = null;
		try{
			productBand = (ProductBandDomain)this.productLookup.getProductSegmentationValue(19,"SU_AUD","USER REFERENCE");
			Assert.assertTrue(productBand!=null);
			productBand = null;
			productBand = (ProductBandDomain)this.productLookup.getProductSegmentationValue(19,"SU_AUD","FED REFERENCE");
			Assert.assertTrue(productBand!=null);
		}catch(OptimaRetailBaseException e){
			Assert.fail();
		}
	}
}
