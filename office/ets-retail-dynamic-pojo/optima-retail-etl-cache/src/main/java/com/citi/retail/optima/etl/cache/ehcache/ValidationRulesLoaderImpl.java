package com.citi.retail.optima.etl.cache.ehcache;

import com.citi.retail.optima.etl.common.db.dao.ConstraintMapping;

public class ValidationRulesLoaderImpl
		extends
		OptimaCacheDataLoader<ConstraintMapping, Integer, ConstraintMapping> {

	@Override
	public void afterPropertiesSet() throws Exception {
		if (preloadCache) {
			loadCache();
		}
	}
	
}
