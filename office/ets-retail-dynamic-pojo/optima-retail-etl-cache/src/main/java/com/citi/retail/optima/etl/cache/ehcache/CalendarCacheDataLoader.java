package com.citi.retail.optima.etl.cache.ehcache;

import com.citi.retail.optima.etl.cache.model.CalendarVO;

public class CalendarCacheDataLoader 
	extends OptimaCacheDataLoader<CalendarVO, Integer, CalendarVO> {
	
	@Override
	public void afterPropertiesSet() throws Exception {
		if (preloadCache) {
			loadCache();
		}
	}
}
