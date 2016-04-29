/**
 * 
 */
package com.citi.retail.optima.etl.cache.helper;

import com.citi.retail.optima.etl.cache.model.AggregationSqlRef;

/**
 * @author mc56120
 * 
 */
public class AggregationSqlCacheEntryHelper implements
		CacheEntryHelper<AggregationSqlRef, String, AggregationSqlRef> {
	private Integer keyVal = 0;

	@Override
	public String getKey(AggregationSqlRef entity) {
		this.keyVal++;
		return this.keyVal.toString();
	}

	@Override
	public AggregationSqlRef getValue(AggregationSqlRef entity) {
		return entity;
	}

}
