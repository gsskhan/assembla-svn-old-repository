package com.citi.retail.optima.etl.cache.lookup.test;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.cache.lookup.UserEntitlementLookup;
import com.citi.retail.optima.etl.common.exception.OptimaRetailBaseException;

/**
 * 
 * @author mc56120
 *
 */
 

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.referencedata.xml",
		"/optima.retail.cache.test.xml" })
public class UserEntitlementLookupTest {

	@Autowired
	private UserEntitlementLookup userEntitlementLookup;

	@Test
	@Ignore
	public void testUserLookup() {
		try{			
			Assert.assertTrue(this.userEntitlementLookup.getEntitledUser("ICCAR","PJ58187")!=null);
		}catch(OptimaRetailBaseException e){
			Assert.fail();
		}	
	}
}
