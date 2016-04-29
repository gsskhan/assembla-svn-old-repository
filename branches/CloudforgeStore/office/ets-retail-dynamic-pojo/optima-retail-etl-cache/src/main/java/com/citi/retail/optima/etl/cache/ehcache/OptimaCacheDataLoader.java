package com.citi.retail.optima.etl.cache.ehcache;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.cache.Cache;

import com.citi.retail.optima.etl.cache.dao.CacheLoaderDao;
import com.citi.retail.optima.etl.cache.helper.CacheEntryHelper;

/**
 * @author sr67841 This is the base loader class for loading the data to the
 *         cache. Every loader class should be created by extending this class.
 * 
 * @param <E>
 * @param <K>
 * @param <V>
 */
public abstract class OptimaCacheDataLoader<E, K, V> implements
		InitializingBean {
	protected Cache cache;
	protected CacheEntryHelper<E, K, V> cacheEntryHelper;
	protected CacheLoaderDao<E> dao;

	protected boolean preloadCache;

	@Required
	public void setCache(Cache cache) {
		this.cache = cache;
	}

	public void setCacheEntryHelper(CacheEntryHelper<E, K, V> cacheEntryHelper) {
		this.cacheEntryHelper = cacheEntryHelper;
	}

	@Required
	public void setDao(CacheLoaderDao<E> dao) {
		this.dao = dao;
	}

	@Required
	public void setPreloadCache(boolean preloadCache) {
		this.preloadCache = preloadCache;
	}

	protected void loadCache(Object... args) throws Exception {
		for (E entity : this.dao.getCacheData(args)) {
			this.cacheEntryHelper.getKey(entity);
			this.cache.put(this.cacheEntryHelper.getKey(entity),
					this.cacheEntryHelper.getValue(entity));
		}
	}

	public void reloadCache() throws Exception {
		this.cache.clear();
		loadCache();
	}

}
