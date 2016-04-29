package com.citi.retail.optima.etl.cache.lookup.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.cache.dao.impl.DelqBandDaoImpl;

/**
 * @author sr67841
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.referencedata.xml",
		"/optima.retail.cache.test.xml" })
public class DelinquencyMappingDaoImplTest {

	@Autowired
	private DelqBandDaoImpl delQDaoImpl;

	@Test
	public void testDeliquencyStatusDao() throws Exception {
		Assert.assertTrue(this.delQDaoImpl.getCacheData().size() > 0);
		Assert.assertFalse(this.delQDaoImpl.getCacheData().size() == 0);
	}

}
