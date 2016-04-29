package com.citi.retail.optima.etl.cache.helper;

import com.citi.retail.optima.etl.cache.model.EnrichmentRulesRef;

/**
 * @author mc56120
 * 
 */
public class EnrichmentCacheEntryHelper implements
		CacheEntryHelper<EnrichmentRulesRef, String, EnrichmentRulesRef> {
	private Integer keyVal = 0;

	@Override
	public String getKey(EnrichmentRulesRef entity) {
		this.keyVal++;
		return this.keyVal.toString();
	}

	@Override
	public EnrichmentRulesRef getValue(EnrichmentRulesRef entity) {
		return entity;
	}

}
