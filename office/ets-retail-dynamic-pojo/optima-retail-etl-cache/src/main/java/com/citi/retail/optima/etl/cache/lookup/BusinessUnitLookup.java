package com.citi.retail.optima.etl.cache.lookup;

import net.sf.ehcache.Element;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import com.citi.retail.optima.etl.cache.ehcache.OptimaCacheUtil;

public class BusinessUnitLookup extends SpringCacheBaseLookup {

	public BusinessUnitLookup(Cache cache) {
		super(cache);
		// TODO Auto-generated constructor stub
	}

	public BusinessUnitLookup(CacheManager cacheManager) {
		super(cacheManager);
		// TODO Auto-generated constructor stub
	}
	
	public Integer getBusinessUnit(String bussinessFunction,String businessUnit) {
		Element valueWrapper = this.ehCache.get(OptimaCacheUtil
				.keyCreator(bussinessFunction, businessUnit));

		if (valueWrapper != null){
			return (Integer)valueWrapper.getObjectValue();
		}

		return null;
	}

}
