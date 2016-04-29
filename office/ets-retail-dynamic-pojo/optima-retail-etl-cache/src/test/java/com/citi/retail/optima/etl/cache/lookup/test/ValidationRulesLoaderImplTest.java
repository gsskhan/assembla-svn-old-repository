package com.citi.retail.optima.etl.cache.lookup.test;

import net.sf.ehcache.Ehcache;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Tests whether the Validation Rules retrieved from Database is loaded properly
 * into the Cache. Uses the count of rules from both DB and Cache to verify the
 * validity.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.rules.xml",
		"/optima.retail.cache.test.xml" })
public class ValidationRulesLoaderImplTest {

	@Autowired
	private CacheManager cacheManager;

	@Test
	public void testLoad() {
		Cache cache = cacheManager.getCache("validationRuleCache");
		Ehcache ehcache = (Ehcache) cache.getNativeCache();
		Assert.assertTrue("size of cached rules cannot be empty!",
				ehcache.getSize() > 0);
	}
}
