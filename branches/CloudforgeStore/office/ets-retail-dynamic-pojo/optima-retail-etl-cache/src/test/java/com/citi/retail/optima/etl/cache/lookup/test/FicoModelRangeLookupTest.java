package com.citi.retail.optima.etl.cache.lookup.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.cache.lookup.FDICReferenceLookup;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;

@SuppressWarnings("unused")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.referencedata.xml",
		"/optima.retail.cache.test.xml" })
public class FicoModelRangeLookupTest {

	@Autowired
	private FDICReferenceLookup fdicRefLookup;

	@Test
	public void testFicoRangeLookup() throws OptimaRetailApplicationException {
		assertNotNull(this.fdicRefLookup.getModelRange("TransUnion",
				"Account Management Model 2.0"));
	}
}
