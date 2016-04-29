package com.citi.retail.optima.etl.cache.lookup.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.cache.lookup.LlrConCommLookup;
import com.citi.retail.optima.etl.common.model.cache.LlrConCommDomain;

/**
 * @author sr67841
 * 
 */

@SuppressWarnings("unused")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.referencedata.test.xml",
		"/optima.retail.cache.test.xml" })
public class LlrConCommLookupTest {

	@Autowired
	private LlrConCommLookup llrConCommLookup;

	@Test
	public void testTFormLookup() throws Exception {
		LlrConCommDomain domain = llrConCommLookup
				.getConCommLookup(37l, "COMM");
		Assert.assertNotNull(domain);
		Assert.assertTrue(domain.getTrgtConsCommSplt().trim().equals("COMM"));
	}

}