/**
 * 
 */
package com.citi.retail.optima.etl.cache.lookup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.ehcache.search.Query;
import net.sf.ehcache.search.Result;
import net.sf.ehcache.search.Results;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.cache.Cache;

import com.citi.retail.optima.etl.cache.model.AggregationSqlRef;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;

/**
 * look up to fetch aggregation insert sql from cache
 * 
 * @author mc56120
 * 
 */
public class AggregationSqlRuleLookup extends SpringCacheBaseLookup implements
		InitializingBean {

	/**
	 * 
	 * @param cache
	 */
	public AggregationSqlRuleLookup(Cache cache) {
		super(cache);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		super.propertiesSet();
	}

	/**
	 * lookup to fetch insert sql (aggreagtion output insert SQL) based on
	 * processingUnit
	 * 
	 * @param processingUnitIds
	 * @return
	 * @throws OptimaRetailException
	 */
	public Map<String, AggregationSqlRef> getAggregationSqlDeprecated(
			List<Integer> processingUnitIds) throws OptimaRetailApplicationException {

		Query query = getBaseSearchQueryDeprecated(processingUnitIds);
		Results results = query.execute();
		Map<String, AggregationSqlRef> aggrRulesMap = new HashMap<String, AggregationSqlRef>();
		if (results.all().size() > 0) {
			for (Result result : results.all()) {
				AggregationSqlRef aggrSqlRef = (AggregationSqlRef) result
						.getValue();
				aggrRulesMap.put(aggrSqlRef.getAggregationName(), aggrSqlRef);
			}
			return aggrRulesMap;
		}
		return null;
	}

	public Map<String, AggregationSqlRef> getAggregationSql(List<String> keyList)
			throws OptimaRetailApplicationException {

		Query query = getBaseSearchQuery(keyList);
		Results results = query.execute();
		Map<String, AggregationSqlRef> aggrRulesMap = new HashMap<String, AggregationSqlRef>();
		if (results.all().size() > 0) {
			for (Result result : results.all()) {
				AggregationSqlRef aggrSqlRef = (AggregationSqlRef) result
						.getValue();
				Integer sysProcId= aggrSqlRef.getProcessingUnitId();
				String aggregationType = aggrSqlRef.getAggregationId().toString();
				String key = sysProcId + ":" + aggregationType;
				aggrRulesMap.put(key, aggrSqlRef);
			}
			return aggrRulesMap;
		}
		return null;
	}

}
