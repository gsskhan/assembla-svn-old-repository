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
@ContextConfiguration({ "/optima.retail.cache.rules.xml", "/optima.retail.cache.test.xml"}) 
public class EnrichmentCacheRefreshUtilityTest<E, K, V> {

	@Autowired
	private CacheRefreshUtility<E, K, V> enrichCacheRefreshUtility;
	
	@Autowired
	private SpringCacheBaseLookup enrichmentRulesLookup;

	@Test
	public void testRefreshEnrichmentCache() throws Exception {
		testRefreshCache(enrichCacheRefreshUtility, enrichmentRulesLookup);
		
	}

	private void testRefreshCache(CacheRefreshUtility<E, K, V> c, SpringCacheBaseLookup l) throws Exception {
		int iBeforeSize = l.getEhCache().getSize();;
		String strBeforeTxt = l.getEhCache().getAll(l.getEhCache().getKeys()).toString();
		c.refreshCache();
		int iAfterSize = l.getEhCache().getSize();
		String strAfterTxt = l.getEhCache().getAll(l.getEhCache().getKeys()).toString();
		Assert.assertEquals(iBeforeSize, iAfterSize);
		System.out.println("Cache before size="+iBeforeSize+" equal to after size"+iAfterSize);
		System.out.println("Cache before hashcode=\n"+strBeforeTxt+"\n not equal to after hashcode\n"+strAfterTxt);
	}



}
