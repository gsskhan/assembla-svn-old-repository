package com.citi.retail.optima.etl.cache.helper;

import java.util.Map.Entry;

/**
 * @author TJ
 * 
 */
public class SingleValueCacheEntryHelper<K, V> implements
		CacheEntryHelper<Entry<K, V>, K, V> {

	@Override
	public K getKey(Entry<K, V> entity) {
		return entity.getKey();
	}

	@Override
	public V getValue(Entry<K, V> entity) {
		return entity.getValue();
	}

}
