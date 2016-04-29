package com.citi.retail.optima.etl.cache.ehcache.loaders;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import com.citi.retail.optima.etl.cache.dao.impl.OrigLtvBandDaoImpl;
import com.citi.retail.optima.etl.cache.ehcache.CacheBandingLoader;
import com.citi.retail.optima.etl.cache.ehcache.OptimaCacheUtil;
import com.citi.retail.optima.etl.cache.helper.ReferenceBandEntryHelper;
import com.citi.retail.optima.etl.common.model.cache.OrigLtvBandDomain;

/**
 * loads Orig Ltv band details to cache from reference tables
 * @author mc56120
 *
 */
public class OrigLtvBandLoaderImpl extends
		CacheBandingLoader<OrigLtvBandDaoImpl, OrigLtvBandDomain, String, Integer> {

	private ReferenceBandEntryHelper cacheEntryHelper;
	private OrigLtvBandDaoImpl dao;

	public void setDao(OrigLtvBandDaoImpl dao) {
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
		Set<Entry<String, Map<Integer, OrigLtvBandDomain>>> refSet = convertDataToTreeMap(this.dao
				.getCacheData(args));
		for (Entry<String, Map<Integer, OrigLtvBandDomain>> entity : refSet) {
			this.cache.put(this.cacheEntryHelper.getKey(entity),
					this.cacheEntryHelper.getValue(entity));
		}
	}

	@Override
	public Set<Entry<String, Map<Integer, OrigLtvBandDomain>>> convertDataToTreeMap(
			Collection<OrigLtvBandDomain> collection) {
		Map<String, Map<Integer, OrigLtvBandDomain>> baseRefMap = new HashMap<String, Map<Integer, OrigLtvBandDomain>>();
		String key;
		for (OrigLtvBandDomain refBand : collection) {
			key = OptimaCacheUtil.keyCreator(refBand.getProcessingUnitId(),
					refBand.getSegmentType());
			if (baseRefMap.containsKey(key)) {
				Map<Integer, OrigLtvBandDomain> tempMap = baseRefMap.get(key);
				tempMap.put(refBand.getUpperBand(), refBand);
			} else {
				Map<Integer, OrigLtvBandDomain> tempMap = new TreeMap<Integer, OrigLtvBandDomain>();
				tempMap.put(refBand.getUpperBand(), refBand);
				baseRefMap.put(key, tempMap);
			}
		}
		return baseRefMap.entrySet();
	}



}
