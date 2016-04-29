package com.citi.retail.optima.etl.cache.ehcache.loaders;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.citi.retail.optima.etl.cache.dao.impl.CollateralisedBandDaoImpl;
import com.citi.retail.optima.etl.cache.ehcache.OptimaCacheDataLoader;
import com.citi.retail.optima.etl.cache.ehcache.OptimaCacheUtil;
import com.citi.retail.optima.etl.cache.helper.SingleValueCacheEntryHelper;
import com.citi.retail.optima.etl.common.model.cache.CollateralisedBandDomain;

/**
 * 
 * @author mc56120
 *
 */
public class CollateralisedIdCacheLoaderImpl extends OptimaCacheDataLoader {

	private SingleValueCacheEntryHelper<String, CollateralisedBandDomain> cacheEntryHelper;
	private CollateralisedBandDaoImpl dao;

	public void setDao(CollateralisedBandDaoImpl dao) {
		this.dao = dao;
	}

	public void setCacheEntryHelper(
			SingleValueCacheEntryHelper<String, CollateralisedBandDomain> cacheEntryHelper) {
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

		Set<Entry<String, CollateralisedBandDomain>> refSet = convertDataToMap(this.dao
				.getCacheData(args));
		for (Entry<String, CollateralisedBandDomain> entity : refSet) {
			this.cacheEntryHelper.getKey(entity);
			this.cache.put(this.cacheEntryHelper.getKey(entity),
					this.cacheEntryHelper.getValue(entity));
		}

	}

	public Set<Entry<String, CollateralisedBandDomain>> convertDataToMap(
			List<CollateralisedBandDomain> refList) throws SQLException {

		Map<String, CollateralisedBandDomain> baseRefMap = new HashMap<String, CollateralisedBandDomain>();
		for (CollateralisedBandDomain refBand : refList) {
			baseRefMap.put(OptimaCacheUtil.keyCreator(refBand.getKeyId()),
					refBand);
		}

		return baseRefMap.entrySet();
	}

}
