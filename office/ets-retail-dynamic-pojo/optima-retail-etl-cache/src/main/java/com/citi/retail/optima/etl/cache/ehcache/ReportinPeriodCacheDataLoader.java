package com.citi.retail.optima.etl.cache.ehcache;

import com.citi.retail.optima.etl.cache.model.ReportingPeriodVO;

public class ReportinPeriodCacheDataLoader 
	extends OptimaCacheDataLoader<ReportingPeriodVO, Integer, ReportingPeriodVO> {
	
	@Override
	public void afterPropertiesSet() throws Exception {
		if (preloadCache) {
			loadCache();
		}
	}
}
