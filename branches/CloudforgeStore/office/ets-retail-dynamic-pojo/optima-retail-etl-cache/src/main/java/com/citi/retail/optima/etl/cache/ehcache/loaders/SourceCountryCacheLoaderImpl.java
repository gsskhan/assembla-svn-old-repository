package com.citi.retail.optima.etl.cache.ehcache.loaders;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.citi.retail.optima.etl.cache.dao.impl.SourceCountryDaoImpl;
import com.citi.retail.optima.etl.cache.ehcache.OptimaCacheDataLoader;
import com.citi.retail.optima.etl.cache.ehcache.OptimaCacheUtil;
import com.citi.retail.optima.etl.common.model.cache.SourceCountryDomain;

/**
 * @author sr67841 This is the loader class for loading FICO details to cache
 *         from reference tables.
 * 
 */
public class SourceCountryCacheLoaderImpl extends OptimaCacheDataLoader {

	private SourceCountryDaoImpl dao;

	public void setDao(SourceCountryDaoImpl dao) {
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

		Set<Entry<String, SourceCountryDomain>> refSet = convertDataToMap(dao
				.getCacheData(args));
		for (Entry<String, SourceCountryDomain> entity : refSet) {
			cache.put(entity.getKey(), entity.getValue());
		}

	}

	public Set<Entry<String, SourceCountryDomain>> convertDataToMap(
			List<SourceCountryDomain> refList) throws SQLException {

		Map<String, SourceCountryDomain> baseRefMap = new HashMap<String, SourceCountryDomain>();
		for (SourceCountryDomain ref : refList) {
			baseRefMap.put(
					OptimaCacheUtil.keyCreator(ref.getSourceSysId(),
							ref.getSrcCntryCd()), ref);

		}

		return baseRefMap.entrySet();
	}
}
