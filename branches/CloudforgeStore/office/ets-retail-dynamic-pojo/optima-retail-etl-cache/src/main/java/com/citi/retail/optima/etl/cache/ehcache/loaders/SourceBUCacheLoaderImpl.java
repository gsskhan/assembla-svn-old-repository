package com.citi.retail.optima.etl.cache.ehcache.loaders;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.citi.retail.optima.etl.cache.dao.impl.SourceBUDaoImpl;
import com.citi.retail.optima.etl.cache.ehcache.OptimaCacheDataLoader;
import com.citi.retail.optima.etl.cache.ehcache.OptimaCacheUtil;
import com.citi.retail.optima.etl.common.model.cache.SourceBUDomain;

/**
 * @author sr67841 This is the loader class for loading FICO details to cache
 *         from reference tables.
 * 
 */
public class SourceBUCacheLoaderImpl extends OptimaCacheDataLoader {

	private SourceBUDaoImpl dao;

	public void setDao(SourceBUDaoImpl dao) {
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

		Set<Entry<String, SourceBUDomain>> refSet = convertDataToMap(dao
				.getCacheData(args));
		for (Entry<String, SourceBUDomain> entity : refSet) {
			cache.put(entity.getKey(), entity.getValue());
		}

	}

	public Set<Entry<String, SourceBUDomain>> convertDataToMap(
			List<SourceBUDomain> refList) throws SQLException {
		Map<String, SourceBUDomain> baseRefMap = new HashMap<String, SourceBUDomain>();
		for (SourceBUDomain ref : refList) {
			baseRefMap.put(
					OptimaCacheUtil.keyCreator(ref.getSysProcId(),
							ref.getSrcBUVal()), ref);

		}

		return baseRefMap.entrySet();
	}
}
