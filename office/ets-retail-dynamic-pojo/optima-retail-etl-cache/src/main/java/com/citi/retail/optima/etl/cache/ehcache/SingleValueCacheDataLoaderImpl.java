package com.citi.retail.optima.etl.cache.ehcache;

import java.util.Map.Entry;

/**
 * @author TJ 
 * This is the loader class for loading Single Value records in cache
 */
public class SingleValueCacheDataLoaderImpl<K, V>
		extends
		OptimaCacheDataLoader<Entry<K, V>, K, V> {
	@Override
	public void afterPropertiesSet() throws Exception {
		if (preloadCache) {
			loadCache();
		}
	}
}
