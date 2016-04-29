package com.citi.retail.optima.etl.cache.helper;

import com.citi.retail.optima.etl.cache.model.CalendarVO;

public class CalendarCacheEntryHelper implements CacheEntryHelper<CalendarVO, Integer, CalendarVO> {
	
	@Override
	public Integer getKey(CalendarVO entity) {	
		return entity.getProcessingUnit();
	}

	@Override
	public CalendarVO getValue(CalendarVO entity) {
		return entity;
	}
	
}
