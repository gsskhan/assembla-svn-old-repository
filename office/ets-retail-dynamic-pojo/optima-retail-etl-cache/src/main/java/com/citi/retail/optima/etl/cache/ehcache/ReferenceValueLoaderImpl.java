package com.citi.retail.optima.etl.cache.ehcache;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import com.citi.retail.optima.etl.cache.dao.impl.ReferenceValueDaoImpl;
import com.citi.retail.optima.etl.cache.helper.ReferenceValueEntryHelperNew;
import com.citi.retail.optima.etl.cache.model.ReferenceValueRef;
import com.citi.retail.optima.etl.common.model.cache.KeyRef;

/**
 * @author sr67841 This is the loader class for loading FICO details to cache
 *         from reference tables.
 * 
 */
public class ReferenceValueLoaderImpl
		extends
		OptimaCacheDataLoader<Entry<KeyRef, Map<String, String>>, KeyRef, Map<String, String>> {

	private ReferenceValueEntryHelperNew cacheEntryHelper;
	private ReferenceValueDaoImpl dao;

	public void setDao(ReferenceValueDaoImpl dao) {
		this.dao = dao;
	}

	public void setCacheEntryHelper(ReferenceValueEntryHelperNew cacheEntryHelper) {
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

		Set<Entry<KeyRef, Map<String, ReferenceValueRef>>> refSet = convertDataToTreeMap(this.dao
				.getCacheData(args));
		for (Entry<KeyRef, Map<String, ReferenceValueRef>> entity : refSet) {
			this.cache.put(this.cacheEntryHelper.getKey(entity),
					this.cacheEntryHelper.getValue(entity));
		}

	}

	public Set<Entry<KeyRef, Map<String, ReferenceValueRef>>> convertDataToTreeMap(
			List<ReferenceValueRef> refList) throws SQLException {

		Map<KeyRef, Map<String, ReferenceValueRef>> baseRefMap = new HashMap<KeyRef, Map<String, ReferenceValueRef>>();
		KeyRef baseRef;

		for (ReferenceValueRef refBand : refList) {
			baseRef = new KeyRef();
			baseRef.setProcessingUnitId(refBand.getProcessingUnitId());
			baseRef.setSegmentType(refBand.getBandType());
			if (baseRefMap.containsKey(baseRef)) {
				Map<String, ReferenceValueRef> tempMap = baseRefMap
						.get(baseRef);
				tempMap.put(refBand.getKey(), refBand);
			} else {
				Map<String, ReferenceValueRef> tempMap = new TreeMap<String, ReferenceValueRef>();
				tempMap.put(refBand.getKey(), refBand);
				baseRefMap.put(baseRef, tempMap);
			}

		}

		return baseRefMap.entrySet();
	}
}
