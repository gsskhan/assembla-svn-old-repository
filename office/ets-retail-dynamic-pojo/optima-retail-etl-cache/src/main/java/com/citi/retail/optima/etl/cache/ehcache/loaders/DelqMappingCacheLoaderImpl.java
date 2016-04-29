package com.citi.retail.optima.etl.cache.ehcache.loaders;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.citi.retail.optima.etl.cache.dao.impl.DelqMappingDaoImpl;
import com.citi.retail.optima.etl.cache.ehcache.OptimaCacheDataLoader;
import com.citi.retail.optima.etl.cache.ehcache.OptimaCacheUtil;
import com.citi.retail.optima.etl.cache.helper.SingleValueCacheEntryHelper;
import com.citi.retail.optima.etl.common.model.cache.SegmentMappingDomain;

/**
 * @author sr67841 This is the loader class for loading FICO details to cache
 *         from reference tables.
 * 
 */
public class DelqMappingCacheLoaderImpl extends OptimaCacheDataLoader {

	private SingleValueCacheEntryHelper<String, Integer> cacheEntryHelper;
	private DelqMappingDaoImpl dao;

	public void setDao(DelqMappingDaoImpl dao) {
		this.dao = dao;
	}

	public void setCacheEntryHelper(
			SingleValueCacheEntryHelper<String, Integer> cacheEntryHelper) {
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

		Set<Entry<String, Integer>> refSet = convertDataToMap(this.dao
				.getCacheData(args));
		for (Entry<String, Integer> entity : refSet) {
			this.cache.put(this.cacheEntryHelper.getKey(entity),
					this.cacheEntryHelper.getValue(entity));
		}

	}

	public Set<Entry<String, Integer>> convertDataToMap(
			List<SegmentMappingDomain> refList) throws SQLException {

		Map<String, Integer> baseRefMap = new HashMap<String, Integer>();

		for (SegmentMappingDomain refBand : refList) {

			baseRefMap.put(
					OptimaCacheUtil.keyCreator(refBand.getRefBandId(),
							refBand.getOutputBandType()), refBand.getBandId());

		}

		return baseRefMap.entrySet();
	}
}
