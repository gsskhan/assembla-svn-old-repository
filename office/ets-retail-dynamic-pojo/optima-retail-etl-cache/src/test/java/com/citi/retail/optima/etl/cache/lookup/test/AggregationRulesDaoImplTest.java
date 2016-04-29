package com.citi.retail.optima.etl.cache.lookup.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.cache.dao.CacheLoaderDao;

/**
 * 
 */

/**
 * @author mc56120
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.rules.xml",
		"/optima.retail.cache.test.xml" })
public class AggregationRulesDaoImplTest {

	@SuppressWarnings("rawtypes")
	@Autowired
	private CacheLoaderDao aggregationRuleDao;

	@Test
	public void testGetCacheData() throws Exception {
		Assert.assertNotNull(aggregationRuleDao.getCacheData(new Object[0]));
		Assert.assertTrue(aggregationRuleDao.getCacheData(new Object[0]).size() > 0);
	}
}
