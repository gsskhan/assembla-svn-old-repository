package com.citi.retail.optima.etl.cache.helper;

import java.util.Map;
import java.util.Map.Entry;

import com.citi.retail.optima.etl.cache.model.BaseRef;

/**
 * @author sr67841
 * 
 */
public class ReferenceValueEntryHelper
		implements
		CacheEntryHelper<Entry<BaseRef, Map<String, String>>, BaseRef, Map<String, String>> {

	@Override
	public BaseRef getKey(Entry<BaseRef, Map<String, String>> entity) {
		return entity.getKey();
	}

	@Override
	public Map<String, String> getValue(
			Entry<BaseRef, Map<String, String>> entity) {
		return entity.getValue();
	}

}
