package com.citi.retail.optima.etl.cache.ehcache.loaders;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.citi.retail.optima.etl.cache.dao.impl.DelqBandDaoImpl;
import com.citi.retail.optima.etl.cache.ehcache.OptimaCacheDataLoader;
import com.citi.retail.optima.etl.cache.ehcache.OptimaCacheUtil;
import com.citi.retail.optima.etl.cache.helper.SingleValueCacheEntryHelper;
import com.citi.retail.optima.etl.common.model.cache.DelqBandDomain;

/**
 * @author sr67841 This is the loader class for loading FICO details to cache
 *         from reference tables.
 * 
 */
public class DelqFlatCacheLoaderImpl extends OptimaCacheDataLoader {

	private SingleValueCacheEntryHelper<String, DelqBandDomain> cacheEntryHelper;
	private DelqBandDaoImpl dao;

	public void setDao(DelqBandDaoImpl dao) {
		this.dao = dao;
	}

	public void setCacheEntryHelper(
			SingleValueCacheEntryHelper<String, DelqBandDomain> cacheEntryHelper) {
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

		Set<Entry<String, DelqBandDomain>> refSet = convertDataToMap(this.dao
				.getCacheData(args));
		for (Entry<String, DelqBandDomain> entity : refSet) {
			this.cacheEntryHelper.getKey(entity);
			this.cache.put(this.cacheEntryHelper.getKey(entity),
					this.cacheEntryHelper.getValue(entity));
		}

	}

	public Set<Entry<String, DelqBandDomain>> convertDataToMap(
			List<DelqBandDomain> refList) throws SQLException {

		Map<String, DelqBandDomain> baseRefMap = new HashMap<String, DelqBandDomain>();
		String segValue;

		for (DelqBandDomain refBand : refList) {
			if (refBand.getSegVal() != null) {
				segValue = refBand.getSegVal();
			} else {
				segValue = refBand.getSegCode().toString();
			}

			baseRefMap.put(OptimaCacheUtil.keyCreator(
					refBand.getProcessingUnitId(), refBand.getSegmentType(),
					segValue), refBand);

		}

		return baseRefMap.entrySet();
	}

}
