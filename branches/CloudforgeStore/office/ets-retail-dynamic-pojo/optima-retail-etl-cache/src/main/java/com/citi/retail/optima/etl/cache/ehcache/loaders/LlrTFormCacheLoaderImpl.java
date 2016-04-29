package com.citi.retail.optima.etl.cache.ehcache.loaders;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.citi.retail.optima.etl.cache.dao.impl.LlrTFormDaoImpl;
import com.citi.retail.optima.etl.cache.ehcache.OptimaCacheDataLoader;
import com.citi.retail.optima.etl.cache.ehcache.OptimaCacheUtil;
import com.citi.retail.optima.etl.common.model.cache.LlrTFormDomain;

/**
 * @author sr67841 This is the loader class for loading FICO details to cache
 *         from reference tables.
 * 
 */
public class LlrTFormCacheLoaderImpl extends OptimaCacheDataLoader {

	private LlrTFormDaoImpl dao;

	public void setDao(LlrTFormDaoImpl dao) {
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

		Set<Entry<String, LlrTFormDomain>> refSet = convertDataToMap(dao
				.getCacheData(args));
		for (Entry<String, LlrTFormDomain> entity : refSet) {
			cache.put(entity.getKey(), entity.getValue());
		}

	}

	public Set<Entry<String, LlrTFormDomain>> convertDataToMap(
			List<LlrTFormDomain> refList) throws SQLException {

		Map<String, LlrTFormDomain> baseRefMap = new HashMap<String, LlrTFormDomain>();

		for (LlrTFormDomain ref : refList) {
			baseRefMap.put(
					OptimaCacheUtil.keyCreator(ref.getSrcSysId(),
							ref.getSrcDataVal(), ref.getTrgtAttr()), ref);

		}

		return baseRefMap.entrySet();
	}
}
