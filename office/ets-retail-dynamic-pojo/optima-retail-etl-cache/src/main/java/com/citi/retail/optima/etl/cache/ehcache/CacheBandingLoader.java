package com.citi.retail.optima.etl.cache.ehcache;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.citi.retail.optima.etl.cache.dao.CacheLoaderDao;
import com.citi.retail.optima.etl.cache.helper.ReferenceBandEntryHelper;


/**
 * @author sr67841 This is the loader class for loading FICO details to cache
 *         from reference tables.
 * @param <E>
 * @param <K>
 * 
 */
public abstract class CacheBandingLoader<T extends CacheLoaderDao<E>, E, K, U>
		extends OptimaCacheDataLoader {

	protected ReferenceBandEntryHelper<K, E, U> cacheEntryHelper;

	public void setCacheEntryHelper(ReferenceBandEntryHelper cacheEntryHelper) {
		this.cacheEntryHelper = cacheEntryHelper;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if (this.preloadCache) {
			loadCache();
		}
	}

	@Override
	protected void loadCache(Object... args) throws Exception {

		Set<Entry<K, Map<U, E>>> refSet = convertDataToTreeMap(this.dao
				.getCacheData(args));
		for (Entry<K, Map<U, E>> entity : refSet) {
			this.cache.put(this.cacheEntryHelper.getKey(entity),
					this.cacheEntryHelper.getValue(entity));
		}

	}

	public abstract Set<Entry<K, Map<U, E>>> convertDataToTreeMap(
			Collection<E> collection);
}
