package com.citi.retail.optima.etl.cache.ehcache.loaders;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import com.citi.retail.optima.etl.cache.dao.impl.AgeBandDaoImpl;
import com.citi.retail.optima.etl.cache.ehcache.CacheBandingLoader;
import com.citi.retail.optima.etl.cache.ehcache.OptimaCacheUtil;
import com.citi.retail.optima.etl.cache.helper.ReferenceBandEntryHelper;
import com.citi.retail.optima.etl.common.model.cache.AgeBandDomain;

/**
 * loads Age band details to cache from reference tables
 * @author mc56120
 *
 */
public class AgeBandLoaderImpl extends
		CacheBandingLoader<AgeBandDaoImpl, AgeBandDomain, String, Integer> {

	private ReferenceBandEntryHelper cacheEntryHelper;
	private AgeBandDaoImpl dao;

	public void setDao(AgeBandDaoImpl dao) {
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
		Set<Entry<String, Map<Integer, AgeBandDomain>>> refSet = convertDataToTreeMap(this.dao
				.getCacheData(args));
		for (Entry<String, Map<Integer, AgeBandDomain>> entity : refSet) {
			this.cache.put(this.cacheEntryHelper.getKey(entity),
					this.cacheEntryHelper.getValue(entity));
		}
	}

	@Override
	public Set<Entry<String, Map<Integer, AgeBandDomain>>> convertDataToTreeMap(
			Collection<AgeBandDomain> collection) {
		Map<String, Map<Integer, AgeBandDomain>> baseRefMap = new HashMap<String, Map<Integer, AgeBandDomain>>();
		String key;
		for (AgeBandDomain refBand : collection) {
			key = OptimaCacheUtil.keyCreator(refBand.getProcessingUnitId(),
					refBand.getSegmentType());
			if (baseRefMap.containsKey(key)) {
				Map<Integer, AgeBandDomain> tempMap = baseRefMap.get(key);
				tempMap.put(refBand.getUpperBand(), refBand);
			} else {
				Map<Integer, AgeBandDomain> tempMap = new TreeMap<Integer, AgeBandDomain>();
				tempMap.put(refBand.getUpperBand(), refBand);
				baseRefMap.put(key, tempMap);
			}

		}
		return baseRefMap.entrySet();
	}

}
