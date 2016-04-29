package com.citi.retail.optima.etl.cache.ehcache.loaders;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.citi.retail.optima.etl.cache.dao.impl.SourceSystemDaoImpl;
import com.citi.retail.optima.etl.cache.ehcache.OptimaCacheDataLoader;
import com.citi.retail.optima.etl.cache.ehcache.OptimaCacheUtil;
import com.citi.retail.optima.etl.common.model.cache.SourceSystemDomain;

/**
 * @author sr67841 This is the loader class for loading FICO details to cache
 *         from reference tables.
 * 
 */
public class SourceSysCacheLoaderImpl extends OptimaCacheDataLoader {

	private SourceSystemDaoImpl dao;

	public void setDao(SourceSystemDaoImpl dao) {
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

		Set<Entry<String, SourceSystemDomain>> refSet = convertDataToMap(dao
				.getCacheData(args));
		for (Entry<String, SourceSystemDomain> entity : refSet) {
			cache.put(entity.getKey(), entity.getValue());
		}

	}

	public Set<Entry<String, SourceSystemDomain>> convertDataToMap(
			List<SourceSystemDomain> refList) throws SQLException {
		Map<String, SourceSystemDomain> baseRefMap = new HashMap<String, SourceSystemDomain>();
		for (SourceSystemDomain ref : refList) {
			baseRefMap.put(OptimaCacheUtil.keyCreator(ref.getSrcSystemName()),
					ref);

		}

		return baseRefMap.entrySet();
	}
}
