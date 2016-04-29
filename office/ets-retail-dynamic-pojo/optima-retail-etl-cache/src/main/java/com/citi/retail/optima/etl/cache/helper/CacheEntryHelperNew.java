package com.citi.retail.optima.etl.cache.helper;

public interface CacheEntryHelperNew<E, K, V> {
	K getKey(E entity);
	V getValue(E entity);
}
