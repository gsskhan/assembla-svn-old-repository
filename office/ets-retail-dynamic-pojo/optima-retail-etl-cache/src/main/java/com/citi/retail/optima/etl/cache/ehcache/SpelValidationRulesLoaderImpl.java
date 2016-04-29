package com.citi.retail.optima.etl.cache.ehcache;

import com.citi.retail.optima.etl.cache.model.SPELidationRulesRef;

public class SpelValidationRulesLoaderImpl
		extends
		OptimaCacheDataLoader<SPELidationRulesRef, Integer, SPELidationRulesRef> {

	@Override
	public void afterPropertiesSet() throws Exception {
		if (preloadCache) {
			loadCache();
		}
	}
	
}
