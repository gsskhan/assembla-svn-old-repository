package com.citi.retail.optima.etl.cache.helper;

import com.citi.retail.optima.etl.cache.model.SPELidationRulesRef;

public class SpelValidationCacheEntryHelper implements CacheEntryHelper<SPELidationRulesRef, Integer, SPELidationRulesRef> {
	
	private Integer i = 0;

	@Override
	public Integer getKey(SPELidationRulesRef entity) {		
		return i++;
	}

	@Override
	public SPELidationRulesRef getValue(SPELidationRulesRef entity) {
		return entity;
	}
	
}
