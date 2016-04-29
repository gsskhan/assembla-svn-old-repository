package com.citi.retail.optima.etl.cache.util;

import com.citi.retail.optima.etl.cache.ehcache.OptimaCacheDataLoader;

/**
 * 
 * @author TJ
 *
 */
public class CacheRefreshUtility<E, K, V> {

	private OptimaCacheDataLoader<E, K, V> cacheLoader;

	/**
	 * This is the utility method to be called for refreshing any cache.
	 */
	public final void refreshCache() throws Exception {
		cacheLoader.reloadCache();
	}

	public OptimaCacheDataLoader<E, K, V> getCacheLoader() {
		return cacheLoader;
	}

	public void setCacheLoader(OptimaCacheDataLoader<E, K, V> cacheLoader) {
		this.cacheLoader = cacheLoader;
	}

}
