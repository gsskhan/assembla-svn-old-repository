package com.citi.retail.optima.etl.cache.lookup.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.cache.lookup.GeographyLookup;
import com.citi.retail.optima.etl.cache.model.RegionVO;
import com.citi.retail.optima.etl.common.exception.OptimaRetailBaseException;

/**
 * 
 * @author mc56120
 *
 */
 

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.referencedata.xml",
		"/optima.retail.cache.test.xml" })
public class GeographyUserSegmentLookupTest {

	@Autowired
	private GeographyLookup geographyLookup;

	@Test
	public void testCountryLookup()  {
		String regionId = null;
		try{
			regionId = (String)this.geographyLookup.getGeographySegmentation("CITI","FED",2);
			Assert.assertTrue(regionId!=null);
		}catch(OptimaRetailBaseException e){
			Assert.fail();
		}
		
		try{
			regionId = (String)this.geographyLookup.getGeographySegmentation(null,"FED",2);
		}catch(OptimaRetailBaseException e){
			Assert.assertNotNull(e);
		}
	}
}
