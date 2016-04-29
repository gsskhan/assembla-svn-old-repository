package com.citi.retail.optima.etl.cache.helper;

public interface CacheEntryHelper<E, K, V> {
	K getKey(E entity);
	V getValue(E entity);
}
