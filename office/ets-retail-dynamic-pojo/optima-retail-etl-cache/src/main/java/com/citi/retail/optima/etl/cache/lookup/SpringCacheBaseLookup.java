package com.citi.retail.optima.etl.cache.lookup;

import java.util.List;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.search.Attribute;
import net.sf.ehcache.search.Query;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;


public class SpringCacheBaseLookup {

	CacheManager cacheManager;

	Ehcache ehCache;

	Attribute<Integer> processingUnitId;
	Attribute<String> rulesKey;

	public SpringCacheBaseLookup(Cache cache) {
		this.ehCache = (Ehcache) cache.getNativeCache();
	}

	public SpringCacheBaseLookup(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

	public void propertiesSet() throws Exception {
		this.processingUnitId = this.ehCache
				.getSearchAttribute("processingUnitId");
		this.rulesKey = this.ehCache.getSearchAttribute("rulesKey");
	}

	public Query getBaseSearchQuery(Integer processingUnitId) {
		Query query = this.ehCache.createQuery().includeKeys().includeValues();
		if (processingUnitId != null) {
			query.addCriteria(this.processingUnitId.eq(processingUnitId));
		}
		return query;
	}

	public Query getBaseSearchQuery(List<String> keyList) {
		Query query = this.ehCache.createQuery().includeKeys().includeValues();
		if (keyList != null) {
			query.addCriteria(this.rulesKey.in(keyList));
		}

		return query;
	}

	public Query getBaseSearchQueryDeprecated(List<Integer> processingUnitId) {
		Query query = this.ehCache.createQuery().includeKeys().includeValues();
		if (processingUnitId != null) {
			query.addCriteria(this.processingUnitId.in(processingUnitId));
		}
		return query;
	}

	public Ehcache getEhCache() {
		return this.ehCache;
	}

	public void setEhCache(Ehcache ehCache) {
		this.ehCache = ehCache;
	}

}
