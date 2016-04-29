/**
 * 
 */
package com.citi.retail.optima.etl.cache.lookup.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.cache.lookup.ReferenceValueLookup;

/**
 * @author mc56120
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.referencedata.xml",
		"/optima.retail.cache.test.xml" })
public class ProductToProcessingUnitLookupTest {
	
	@Autowired
	private ReferenceValueLookup productToPuLookup;

	@Test
	public void testProductToPuLookup() throws Exception {
		@SuppressWarnings("unchecked")
		List<Integer> valList= (List<Integer>)this.productToPuLookup.getAllPus("CA_BC", "DE");
		Assert.assertEquals(1, valList.size());
	}	

}
