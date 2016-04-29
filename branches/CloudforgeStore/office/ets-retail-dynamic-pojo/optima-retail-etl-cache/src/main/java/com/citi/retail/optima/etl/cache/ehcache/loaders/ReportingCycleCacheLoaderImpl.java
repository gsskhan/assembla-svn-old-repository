package com.citi.retail.optima.etl.cache.ehcache.loaders;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.citi.retail.optima.etl.cache.dao.impl.ReportCycleDaoImpl;
import com.citi.retail.optima.etl.cache.ehcache.OptimaCacheDataLoader;
import com.citi.retail.optima.etl.cache.ehcache.OptimaCacheUtil;
import com.citi.retail.optima.etl.common.model.cache.ReportCycleDomain;

/**
 * @author sr67841 This is the loader class for loading FICO details to cache
 *         from reference tables.
 * 
 */
public class ReportingCycleCacheLoaderImpl extends OptimaCacheDataLoader {

	private ReportCycleDaoImpl dao;

	public void setDao(ReportCycleDaoImpl dao) {
		this.dao = dao;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if (preloadCache) {
			loadCache();
		}
	}

	@Override
	protected void loadCache(Object... args) throws Exception {

		Set<Entry<String, ReportCycleDomain>> refSet = convertDataToMap(dao
				.getCacheData(args));
		for (Entry<String, ReportCycleDomain> entity : refSet) {
			cache.put(entity.getKey(), entity.getValue());
		}

	}

	public Set<Entry<String, ReportCycleDomain>> convertDataToMap(
			List<ReportCycleDomain> refList) throws SQLException {

		Map<String, ReportCycleDomain> baseRefMap = new HashMap<String, ReportCycleDomain>();

		for (ReportCycleDomain ref : refList) {
			baseRefMap.put(
					OptimaCacheUtil.keyCreator(ref.getRptCycNm(),
							ref.getRptCycQtr(), ref.getRptCycYr()), ref);
		}

		return baseRefMap.entrySet();
	}
}
