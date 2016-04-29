/**
 * 
 */
package com.citi.retail.optima.etl.cache.ehcache;

import com.citi.retail.optima.etl.cache.model.AggregationRulesRef;

/**
 * @author mc56120
 * 
 */
public class AggregationRulesLoaderImpl
		extends
		OptimaCacheDataLoader<AggregationRulesRef, Integer, AggregationRulesRef> {
	@Override
	public void afterPropertiesSet() throws Exception {
		if (preloadCache) {
			loadCache();
		}
	}

}
