package com.citi.retail.optima.etl.cache.lookup.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.cache.lookup.SourceBULookup;
import com.citi.retail.optima.etl.common.model.cache.SourceBUDomain;

/**
 * @author sr67841
 * 
 */

@SuppressWarnings("unused")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.referencedata.test.xml",
		"/optima.retail.cache.test.xml" })
public class SourceBULookupTest {

	@Autowired
	private SourceBULookup srcbuLookup;

	@Test
	public void testSrcRegionLookup() throws Exception {
		SourceBUDomain domain = srcbuLookup.getSourceBU(37l, "APAC_GCG");
		Assert.assertNotNull(domain);
		Assert.assertTrue(domain.getTrgtBUVal().equals("APAC_GCG"));
	}

}