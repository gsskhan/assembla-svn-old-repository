package com.citi.retail.optima.etl.cache.ehcache;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.citi.retail.optima.etl.cache.dao.impl.FicoModelRangeDaoImpl;
import com.citi.retail.optima.etl.cache.helper.SingleValueCacheEntryHelper;
import com.citi.retail.optima.etl.cache.model.ModelRangeVO;

/**
 * @author sr67841 This is the loader class for loading FICO details to cache
 *         from reference tables.
 * 
 */
@SuppressWarnings("rawtypes")
public class FicoModelRangeCacheLoaderImpl extends OptimaCacheDataLoader {

	private SingleValueCacheEntryHelper<String, ModelRangeVO> cacheEntryHelper;
	private FicoModelRangeDaoImpl dao;

	public void setDao(FicoModelRangeDaoImpl dao) {
		this.dao = dao;
	}

	public void setCacheEntryHelper(
			SingleValueCacheEntryHelper<String, ModelRangeVO> cacheEntryHelper) {
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

		Set<Entry<String, ModelRangeVO>> refSet = convertDataToMap(this.dao
				.getCacheData(args));
		for (Entry<String, ModelRangeVO> entity : refSet) {
			this.cache.put(this.cacheEntryHelper.getKey(entity),
					this.cacheEntryHelper.getValue(entity));
		}

	}

	public Set<Entry<String, ModelRangeVO>> convertDataToMap(
			List<ModelRangeVO> refList) throws SQLException {

		Map<String, ModelRangeVO> baseRefMap = new HashMap<String, ModelRangeVO>();

		for (ModelRangeVO refBand : refList) {

			baseRefMap.put(OptimaCacheUtil.keyCreator(
					refBand.getCreditBureau(), refBand.getModelVersion()),
					refBand);

		}

		return baseRefMap.entrySet();
	}
}
