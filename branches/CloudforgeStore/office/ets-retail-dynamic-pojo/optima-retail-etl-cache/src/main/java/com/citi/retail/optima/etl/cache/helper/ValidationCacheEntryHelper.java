package com.citi.retail.optima.etl.cache.helper;

import com.citi.retail.optima.etl.common.db.dao.ConstraintMapping;




public class ValidationCacheEntryHelper implements CacheEntryHelper<ConstraintMapping, Integer, ConstraintMapping> {
	
	private Integer i = 0;

	@Override
	public Integer getKey(ConstraintMapping entity) {		
		return i++;
	}

	@Override
	public ConstraintMapping getValue(ConstraintMapping entity) {
		return entity;
	}
	
}
