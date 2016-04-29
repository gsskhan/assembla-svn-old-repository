package com.citi.retail.optima.etl.cache.lookup.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.cache.lookup.SourceRegionLookup;
import com.citi.retail.optima.etl.common.model.cache.SourceRegionDomain;

/**
 * @author sr67841
 * 
 */

@SuppressWarnings("unused")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.referencedata.test.xml",
		"/optima.retail.cache.test.xml" })
public class SourceRegionLookupTest {

	@Autowired
	private SourceRegionLookup srcReqionLookup;

	@Test
	public void testSrcRegionLookup() throws Exception {
		SourceRegionDomain domain = srcReqionLookup.getSourceRegion("NAM", 37l);
		Assert.assertNotNull(domain);
		Assert.assertTrue(domain.getRgnId() == 112);
	}

}