package com.citi.retail.optima.etl.cache.ehcache;

import java.util.Map;
import java.util.Map.Entry;

import com.citi.retail.optima.etl.cache.model.BaseRef;

/**
 * @author sr67841 This is the loader class for loading Product Details to cache
 *         from reference tables.
 * 
 */
public class ProductLoaderImpl
		extends
		OptimaCacheDataLoader<Entry<BaseRef, Map<String, String>>, BaseRef, Map<String, String>> {
	@Override
	public void afterPropertiesSet() throws Exception {
		if (preloadCache) {
			loadCache();
		}
	}
}
