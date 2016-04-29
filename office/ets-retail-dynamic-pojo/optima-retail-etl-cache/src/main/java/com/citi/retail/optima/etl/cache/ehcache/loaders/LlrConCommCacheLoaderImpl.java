package com.citi.retail.optima.etl.cache.ehcache.loaders;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.citi.retail.optima.etl.cache.dao.impl.LlrConCommDaoImpl;
import com.citi.retail.optima.etl.cache.ehcache.OptimaCacheDataLoader;
import com.citi.retail.optima.etl.cache.ehcache.OptimaCacheUtil;
import com.citi.retail.optima.etl.common.model.cache.LlrConCommDomain;

/**
 * @author sr67841 This is the loader class for loading FICO details to cache
 *         from reference tables.
 * 
 */
public class LlrConCommCacheLoaderImpl extends OptimaCacheDataLoader {

	private LlrConCommDaoImpl dao;

	public void setDao(LlrConCommDaoImpl dao) {
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

		Set<Entry<String, LlrConCommDomain>> refSet = convertDataToMap(dao
				.getCacheData(args));
		for (Entry<String, LlrConCommDomain> entity : refSet) {
			cache.put(entity.getKey(), entity.getValue());
		}

	}

	public Set<Entry<String, LlrConCommDomain>> convertDataToMap(
			List<LlrConCommDomain> refList) throws SQLException {

		Map<String, LlrConCommDomain> baseRefMap = new HashMap<String, LlrConCommDomain>();

		for (LlrConCommDomain ref : refList) {
			baseRefMap.put(
					OptimaCacheUtil.keyCreator(ref.getSysProcId(),
							ref.getSrcConsCommSplt()), ref);

		}

		return baseRefMap.entrySet();
	}
}
