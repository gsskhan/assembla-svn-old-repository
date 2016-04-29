package com.citi.retail.optima.etl.cache.ehcache.loaders;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import com.citi.retail.optima.etl.cache.dao.impl.DelqBandDaoImpl;
import com.citi.retail.optima.etl.cache.ehcache.CacheBandingLoader;
import com.citi.retail.optima.etl.cache.ehcache.OptimaCacheUtil;
import com.citi.retail.optima.etl.cache.helper.ReferenceBandEntryHelper;
import com.citi.retail.optima.etl.common.model.cache.DelqBandDomain;

/**
 * @author sr67841 This is the loader class for loading FICO details to cache
 *         from reference tables.
 * 
 */
public class DelqBandLoaderImpl extends
		CacheBandingLoader<DelqBandDaoImpl, DelqBandDomain, String, Integer> {

	private ReferenceBandEntryHelper cacheEntryHelper;
	private DelqBandDaoImpl dao;

	public void setDao(DelqBandDaoImpl dao) {
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

		Set<Entry<String, Map<Integer, DelqBandDomain>>> refSet = convertDataToTreeMap(this.dao
				.getCacheData(args));
		for (Entry<String, Map<Integer, DelqBandDomain>> entity : refSet) {
			this.cache.put(this.cacheEntryHelper.getKey(entity),
					this.cacheEntryHelper.getValue(entity));
		}

	}

	@Override
	public Set<Entry<String, Map<Integer, DelqBandDomain>>> convertDataToTreeMap(
			Collection<DelqBandDomain> collection) {
		Map<String, Map<Integer, DelqBandDomain>> baseRefMap = new HashMap<String, Map<Integer, DelqBandDomain>>();
		String key;
		for (DelqBandDomain refBand : collection) {
			key = OptimaCacheUtil.keyCreator(refBand.getProcessingUnitId(),
					refBand.getSegmentType());
			if (baseRefMap.containsKey(key)) {
				Map<Integer, DelqBandDomain> tempMap = baseRefMap.get(key);
				tempMap.put(refBand.getUpperBand(), refBand);
			} else {
				Map<Integer, DelqBandDomain> tempMap = new TreeMap<Integer, DelqBandDomain>();
				tempMap.put(refBand.getUpperBand(), refBand);
				baseRefMap.put(key, tempMap);
			}

		}

		return baseRefMap.entrySet();
	}

}
