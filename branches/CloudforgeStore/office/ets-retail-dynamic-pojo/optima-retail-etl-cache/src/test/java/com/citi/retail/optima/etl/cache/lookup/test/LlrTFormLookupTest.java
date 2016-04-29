package com.citi.retail.optima.etl.cache.lookup.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.cache.lookup.LlrTFormLookup;
import com.citi.retail.optima.etl.common.model.cache.LlrTFormDomain;

/**
 * @author sr67841
 * 
 */

@SuppressWarnings("unused")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.referencedata.test.xml",
		"/optima.retail.cache.test.xml" })
public class LlrTFormLookupTest {

	@Autowired
	private LlrTFormLookup llrTFormLookup;

	@Test
	public void testTFormLookup() throws Exception {
		LlrTFormDomain domain = llrTFormLookup.getLlrTFormLookup("3", "HN",
				"COUNTRY");
		Assert.assertTrue(domain.getTrgtAttrVal().trim().equals("HN"));
	}

}