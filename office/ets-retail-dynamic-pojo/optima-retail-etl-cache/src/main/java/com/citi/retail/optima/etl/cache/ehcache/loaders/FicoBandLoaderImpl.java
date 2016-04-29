package com.citi.retail.optima.etl.cache.ehcache.loaders;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import com.citi.retail.optima.etl.cache.dao.impl.FicoBandDaoImpl;
import com.citi.retail.optima.etl.cache.ehcache.CacheBandingLoader;
import com.citi.retail.optima.etl.cache.ehcache.OptimaCacheUtil;
import com.citi.retail.optima.etl.cache.helper.ReferenceBandEntryHelper;
import com.citi.retail.optima.etl.common.model.cache.FicoBandDomain;

/**
 * @author sr67841 This is the loader class for loading FICO details to cache
 *         from reference tables.
 * 
 */
public class FicoBandLoaderImpl extends
		CacheBandingLoader<FicoBandDaoImpl, FicoBandDomain, String, Integer> {

	private ReferenceBandEntryHelper cacheEntryHelper;
	private FicoBandDaoImpl dao;

	public void setDao(FicoBandDaoImpl dao) {
		this.dao = dao;
	}

	@Override
	public void setCacheEntryHelper(ReferenceBandEntryHelper cacheEntryHelper) {
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

		Set<Entry<String, Map<Integer, FicoBandDomain>>> refSet = convertDataToTreeMap(this.dao
				.getCacheData(args));
		for (Entry<String, Map<Integer, FicoBandDomain>> entity : refSet) {
			this.cache.put(this.cacheEntryHelper.getKey(entity),
					this.cacheEntryHelper.getValue(entity));
		}

	}

	@Override
	public Set<Entry<String, Map<Integer, FicoBandDomain>>> convertDataToTreeMap(
			Collection<FicoBandDomain> collection) {
		Map<String, Map<Integer, FicoBandDomain>> baseRefMap = new HashMap<String, Map<Integer, FicoBandDomain>>();
		String key;
		for (FicoBandDomain refBand : collection) {
			key = OptimaCacheUtil.keyCreator(refBand.getProcessingUnitId(),
					refBand.getSegmentType());
			if (baseRefMap.containsKey(key)) {
				Map<Integer, FicoBandDomain> tempMap = baseRefMap.get(key);
				tempMap.put(refBand.getUpperBand(), refBand);
			} else {
				Map<Integer, FicoBandDomain> tempMap = new TreeMap<Integer, FicoBandDomain>();
				tempMap.put(refBand.getUpperBand(), refBand);
				baseRefMap.put(key, tempMap);
			}

		}

		return baseRefMap.entrySet();
	}

}
