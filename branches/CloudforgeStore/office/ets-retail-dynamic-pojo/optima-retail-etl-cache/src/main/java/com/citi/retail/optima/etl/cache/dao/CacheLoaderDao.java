package com.citi.retail.optima.etl.cache.dao;

import java.util.Collection;

public interface CacheLoaderDao<E> {
	Collection<E> getCacheData(Object... args) throws Exception;

}