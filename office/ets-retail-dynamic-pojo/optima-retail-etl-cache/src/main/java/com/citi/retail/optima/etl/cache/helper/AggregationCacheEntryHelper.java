/**
 * 
 */
package com.citi.retail.optima.etl.cache.helper;

import com.citi.retail.optima.etl.cache.model.AggregationRulesRef;

/**
 * @author mc56120
 * 
 */
public class AggregationCacheEntryHelper implements
		CacheEntryHelper<AggregationRulesRef, String, AggregationRulesRef> {
	private Integer keyVal = 0;

	@Override
	public String getKey(AggregationRulesRef entity) {
		this.keyVal++;
		return this.keyVal.toString();
	}

	@Override
	public AggregationRulesRef getValue(AggregationRulesRef entity) {
		return entity;
	}

}
