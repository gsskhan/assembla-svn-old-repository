package com.citi.retail.optima.etl.cache.ehcache.loaders;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.citi.retail.optima.etl.cache.dao.impl.SourceProductDaoImpl;
import com.citi.retail.optima.etl.cache.ehcache.OptimaCacheDataLoader;
import com.citi.retail.optima.etl.cache.ehcache.OptimaCacheUtil;
import com.citi.retail.optima.etl.common.model.cache.SourceProductDomain;

/**
 * @author sr67841 This is the loader class for loading FICO details to cache
 *         from reference tables.
 * 
 */
public class SourceProductCacheLoaderImpl extends OptimaCacheDataLoader {

	private SourceProductDaoImpl dao;

	public void setDao(SourceProductDaoImpl dao) {
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

		Set<Entry<String, SourceProductDomain>> refSet = convertDataToMap(dao
				.getCacheData(args));
		for (Entry<String, SourceProductDomain> entity : refSet) {
			cache.put(entity.getKey(), entity.getValue());
		}

	}

	public Set<Entry<String, SourceProductDomain>> convertDataToMap(
			List<SourceProductDomain> refList) throws SQLException {

		Map<String, SourceProductDomain> baseRefMap = new HashMap<String, SourceProductDomain>();
		for (SourceProductDomain ref : refList) {
			baseRefMap.put(
					OptimaCacheUtil.keyCreator(ref.getSrcProd1(),
							ref.getSrcProd2(), ref.getSrcProd3()), ref);

		}

		return baseRefMap.entrySet();
	}
}
