package com.citi.retail.optima.etl.cache.ehcache.loaders;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.citi.retail.optima.etl.cache.dao.impl.LlrLVDaoImpl;
import com.citi.retail.optima.etl.cache.ehcache.OptimaCacheDataLoader;
import com.citi.retail.optima.etl.cache.ehcache.OptimaCacheUtil;
import com.citi.retail.optima.etl.common.model.cache.LlrLVDomain;

/**
 * @author sr67841 This is the loader class for loading FICO details to cache
 *         from reference tables.
 * 
 */
public class LlrLVCacheLoaderImpl extends OptimaCacheDataLoader {

	private LlrLVDaoImpl dao;

	public void setDao(LlrLVDaoImpl dao) {
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

		Set<Entry<String, LlrLVDomain>> refSet = convertDataToMap(dao
				.getCacheData(args));
		for (Entry<String, LlrLVDomain> entity : refSet) {
			cache.put(entity.getKey(), entity.getValue());
		}

	}

	public Set<Entry<String, LlrLVDomain>> convertDataToMap(
			List<LlrLVDomain> refList) throws SQLException {

		Map<String, LlrLVDomain> baseRefMap = new HashMap<String, LlrLVDomain>();

		for (LlrLVDomain ref : refList) {
			baseRefMap.put(
					OptimaCacheUtil.keyCreator(ref.getSysProcId(),
							ref.getSrcLvName()), ref);

		}

		return baseRefMap.entrySet();
	}
}
