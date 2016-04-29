/**
 * 
 */
package com.citi.retail.optima.etl.cache.ehcache;

import com.citi.retail.optima.etl.cache.model.AggregationSqlRef;

/**
 * @author mc56120
 * 
 */
public class AggregationSqlLoaderImpl extends
		OptimaCacheDataLoader<AggregationSqlRef, Integer, AggregationSqlRef> {
	@Override
	public void afterPropertiesSet() throws Exception {
		if (preloadCache) {
			loadCache();
		}
	}

}
