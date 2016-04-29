package com.citi.retail.optima.etl.cache.ehcache;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import com.citi.retail.optima.etl.cache.dao.impl.PDRangeDaoImpl;
import com.citi.retail.optima.etl.cache.helper.ReferenceBandEntryHelper;
import com.citi.retail.optima.etl.cache.model.PDRangeVo;

public class PDRangeCacheLoaderImpl extends
		OptimaCacheDataLoader {

	public void setCacheEntryHelper(ReferenceBandEntryHelper cacheEntryHelper) {
		this.cacheEntryHelper = cacheEntryHelper;
	}

	public void setDao(PDRangeDaoImpl dao) {
		this.dao = dao;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if (this.preloadCache) {
			loadCache();
		}
	}
	
	@Override
	protected void loadCache(Object... args) throws Exception {
		Set<Entry<String,Map<Float,PDRangeVo>>> refSet = convertDataToTreeMap(this.dao
				.getCacheData(args));
		for (Entry<String, Map<Float, PDRangeVo>> entity : refSet) {
			this.cache.put(this.cacheEntryHelper.getKey(entity),
					this.cacheEntryHelper.getValue(entity));
		}
	}

	public Set<Entry<String, Map<Float, PDRangeVo>>> convertDataToTreeMap(
			Collection<PDRangeVo> collection) {

		Map<String, Map<Float, PDRangeVo>> baseRefMap = new HashMap<String, Map<Float, PDRangeVo>>();
		Integer i = 0;

		for (PDRangeVo refBand : collection) {
			if (baseRefMap.containsKey(i.toString())) {
				Map<Float, PDRangeVo> tempMap = baseRefMap.get(i.toString());
				tempMap.put(refBand.getUpperBandValue(), refBand);
			} else {
				Map<Float, PDRangeVo> tempMap = new TreeMap<Float, PDRangeVo>();
				tempMap.put(refBand.getUpperBandValue(), refBand);
				baseRefMap.put(i.toString(), tempMap);
			}

		}

		return baseRefMap.entrySet();

	}

}
