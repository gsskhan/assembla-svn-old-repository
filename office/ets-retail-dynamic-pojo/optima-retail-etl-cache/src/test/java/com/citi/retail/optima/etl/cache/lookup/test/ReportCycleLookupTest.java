package com.citi.retail.optima.etl.cache.lookup.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.cache.lookup.ReportCycleLookup;
import com.citi.retail.optima.etl.common.model.cache.ReportCycleDomain;

/**
 * @author sr67841
 * 
 */

@SuppressWarnings("unused")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.referencedata.test.xml",
		"/optima.retail.cache.test.xml" })
public class ReportCycleLookupTest {

	@Autowired
	private ReportCycleLookup rptCycleLookup;

	@Test
	public void testTFormLookup() throws Exception {
		ReportCycleDomain domain = rptCycleLookup.getRptCycId("MidQ", "4",
				"2013");
		Assert.assertTrue(domain.getRptCycId() == 1);
	}

}