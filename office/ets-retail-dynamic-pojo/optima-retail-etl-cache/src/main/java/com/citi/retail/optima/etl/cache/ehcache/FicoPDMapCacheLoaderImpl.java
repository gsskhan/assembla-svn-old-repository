package com.citi.retail.optima.etl.cache.ehcache;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.citi.retail.optima.etl.cache.dao.impl.FicoPDMapDaoImpl;
import com.citi.retail.optima.etl.cache.helper.SingleValueCacheEntryHelper;
import com.citi.retail.optima.etl.cache.model.FICOScoreVO;

/**
 * @author sr67841 This is the loader class for loading FICO details to cache
 *         from reference tables.
 * 
 */
@SuppressWarnings("rawtypes")
public class FicoPDMapCacheLoaderImpl extends OptimaCacheDataLoader {

	private SingleValueCacheEntryHelper<String, FICOScoreVO> cacheEntryHelper;
	private FicoPDMapDaoImpl dao;

	public void setDao(FicoPDMapDaoImpl dao) {
		this.dao = dao;
	}

	public void setCacheEntryHelper(
			SingleValueCacheEntryHelper<String, FICOScoreVO> cacheEntryHelper) {
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

		Set<Entry<String, FICOScoreVO>> refSet = convertDataToMap(this.dao
				.getCacheData(args));
		for (Entry<String, FICOScoreVO> entity : refSet) {
			this.cache.put(this.cacheEntryHelper.getKey(entity),
					this.cacheEntryHelper.getValue(entity));
		}

	}

	public Set<Entry<String, FICOScoreVO>> convertDataToMap(
			List<FICOScoreVO> refList) throws SQLException {

		Map<String, FICOScoreVO> baseRefMap = new HashMap<String, FICOScoreVO>();

		for (FICOScoreVO refBand : refList) {

			baseRefMap.put(OptimaCacheUtil.keyCreator(refBand.getCreditBureau()
					.toLowerCase(), refBand.getModelVersion().toLowerCase(),
					refBand.getFicoScore()), refBand);

		}

		return baseRefMap.entrySet();
	}
}
