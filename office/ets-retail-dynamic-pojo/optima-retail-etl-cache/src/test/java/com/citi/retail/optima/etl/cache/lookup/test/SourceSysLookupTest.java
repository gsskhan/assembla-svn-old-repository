package com.citi.retail.optima.etl.cache.lookup.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.cache.lookup.SourceSysLookup;
import com.citi.retail.optima.etl.common.model.cache.SourceSystemDomain;

/**
 * @author sr67841
 * 
 */

@SuppressWarnings("unused")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.referencedata.test.xml",
		"/optima.retail.cache.test.xml" })
public class SourceSysLookupTest {

	@Autowired
	private SourceSysLookup srcSysLookup;

	@Test
	public void testSrcRegionLookup() throws Exception {
		SourceSystemDomain domain = srcSysLookup.getSourceSysId("GC20");
		Assert.assertTrue(domain.getSrcSysId() == 5);
	}

}