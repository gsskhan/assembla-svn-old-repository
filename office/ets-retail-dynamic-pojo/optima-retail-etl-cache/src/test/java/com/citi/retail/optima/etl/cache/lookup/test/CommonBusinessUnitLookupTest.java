package com.citi.retail.optima.etl.cache.lookup.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.cache.lookup.BusinessUnitLookup;

/**
 * @author sr67841
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.referencedata.xml",
		"/optima.retail.cache.test.xml" })
public class CommonBusinessUnitLookupTest {

	@Autowired
	private BusinessUnitLookup commonBusinessUnitLookup;

	@Test
	public void testBusinessUnitLookup() throws Exception {
		Assert.assertEquals(new Integer(11), this.commonBusinessUnitLookup.getBusinessUnit(
				"CCAR 14Q", "ASIA GCB"));		
	}
}
