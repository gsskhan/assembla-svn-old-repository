package com.citi.retail.optima.etl.cache.ehcache;

import com.citi.retail.optima.etl.cache.model.EnrichmentRulesRef;

/**
 * @author mc56120
 * 
 */
public class EnrichmentRulesLoaderImpl extends
		OptimaCacheDataLoader<EnrichmentRulesRef, Integer, EnrichmentRulesRef> {
	@Override
	public void afterPropertiesSet() throws Exception {
		if (preloadCache) {
			loadCache();
		}
	}
}
