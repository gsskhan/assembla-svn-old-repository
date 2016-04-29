package com.citi.retail.optima.etl.cache.helper;

import java.util.Map;
import java.util.Map.Entry;

/**
 * @author sr67841
 * 
 */
public class ReferenceBandEntryHelper<K, E, U> implements
		CacheEntryHelper<Entry<K, Map<U, E>>, K, Map<U, E>> {

	@Override
	public K getKey(Entry<K, Map<U, E>> entity) {
		return entity.getKey();
	}

	@Override
	public Map<U, E> getValue(Entry<K, Map<U, E>> entity) {
		return entity.getValue();
	}

}
