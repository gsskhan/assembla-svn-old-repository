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
public class FicoSplScoreLookupTest {

	@Autowired
	private FDICReferenceLookup fdicRefLookup;

	@Test
	public void testFicoSplScoreLookup() throws OptimaRetailApplicationException {
		assertNotNull(this.fdicRefLookup.getFICOSplScore(201309,
				5));
	}
}
