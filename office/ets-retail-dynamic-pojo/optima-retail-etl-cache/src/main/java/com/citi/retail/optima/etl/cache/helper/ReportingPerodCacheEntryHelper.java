package com.citi.retail.optima.etl.cache.helper;

import com.citi.retail.optima.etl.cache.model.ReportingPeriodVO;

public class ReportingPerodCacheEntryHelper implements CacheEntryHelper<ReportingPeriodVO, Integer, ReportingPeriodVO> {
	
	@Override
	public Integer getKey(ReportingPeriodVO entity) {	
		return entity.getRptPrd();
	}

	@Override
	public ReportingPeriodVO getValue(ReportingPeriodVO entity) {
		return entity;
	}
	
}
