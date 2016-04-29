package com.citi.retail.optima.etl.cache.lookup.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.citi.retail.optima.etl.cache.lookup.SpringCacheBaseLookup;
import com.citi.retail.optima.etl.cache.util.CacheRefreshUtility;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.rules.xml",
"/optima.retail.cache.test.xml" })
public class AggregationCacheRefreshUtilityTest<E, K, V> {

	@Autowired
	private CacheRefreshUtility<E, K, V> aggregationCacheRefreshUtility;
	
	@Autowired
	private SpringCacheBaseLookup aggregationRulesLookup;

	@Test
	public void testRefreshAggregationCache() throws Exception {
		testRefreshCache(aggregationCacheRefreshUtility, aggregationRulesLookup);
	}

	private void testRefreshCache(CacheRefreshUtility<E, K, V> c, SpringCacheBaseLookup l) throws Exception {
		int iBeforeSize = l.getEhCache().getSize();;
		String strBeforeTxt = l.getEhCache().getAll(l.getEhCache().getKeys()).toString();
		c.refreshCache();
		int iAfterSize = l.getEhCache().getSize();
		String strAfterTxt = l.getEhCache().getAll(l.getEhCache().getKeys()).toString();
		Assert.assertEquals(iBeforeSize, iAfterSize);
		System.out.println("Cache before size="+iBeforeSize+" not equal to after size"+iAfterSize);
		Assert.assertNotEquals(strBeforeTxt , strAfterTxt);
		System.out.println("Cache before hashcode=\n"+strBeforeTxt+"\n not equal to after hashcode\n"+strAfterTxt);
	}

}
