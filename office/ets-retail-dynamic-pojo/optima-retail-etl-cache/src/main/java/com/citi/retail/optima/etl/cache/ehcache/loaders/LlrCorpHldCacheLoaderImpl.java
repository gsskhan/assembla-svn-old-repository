package com.citi.retail.optima.etl.cache.ehcache.loaders;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.citi.retail.optima.etl.cache.dao.impl.LlrCorpHldDaoImpl;
import com.citi.retail.optima.etl.cache.ehcache.OptimaCacheDataLoader;
import com.citi.retail.optima.etl.cache.ehcache.OptimaCacheUtil;
import com.citi.retail.optima.etl.common.model.cache.LlrCorpHldDomain;

/**
 * @author sr67841 This is the loader class for loading FICO details to cache
 *         from reference tables.
 * 
 */
public class LlrCorpHldCacheLoaderImpl extends OptimaCacheDataLoader {

	private LlrCorpHldDaoImpl dao;

	public void setDao(LlrCorpHldDaoImpl dao) {
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

		Set<Entry<String, LlrCorpHldDomain>> refSet = convertDataToMap(dao
				.getCacheData(args));
		for (Entry<String, LlrCorpHldDomain> entity : refSet) {
			cache.put(entity.getKey(), entity.getValue());
		}

	}

	public Set<Entry<String, LlrCorpHldDomain>> convertDataToMap(
			List<LlrCorpHldDomain> refList) throws SQLException {

		Map<String, LlrCorpHldDomain> baseRefMap = new HashMap<String, LlrCorpHldDomain>();

		for (LlrCorpHldDomain ref : refList) {
			baseRefMap.put(
					OptimaCacheUtil.keyCreator(ref.getSysProcId(),
							ref.getSrcCorpHoldCd()), ref);

		}

		return baseRefMap.entrySet();
	}
}
