/**
 * 
 */
package com.citi.retail.optima.etl.cache.lookup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.ehcache.search.Attribute;
import net.sf.ehcache.search.Direction;
import net.sf.ehcache.search.Query;
import net.sf.ehcache.search.Result;
import net.sf.ehcache.search.Results;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.cache.Cache;

import ch.qos.logback.classic.Logger;

import com.citi.retail.optima.etl.cache.model.AggregationRulesRef;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.model.AggregationType;

/**
 * @author mc56120
 * 
 */
public class AggregationRulesLookup extends SpringCacheBaseLookup implements
		InitializingBean {

	private static final Logger LOGGER = (Logger) LoggerFactory
			.getLogger(AggregationRulesLookup.class);
	private Attribute<Integer> aggregationRuleOrder;

	/**
	 * 
	 * @param cache
	 */
	public AggregationRulesLookup(Cache cache) {
		super(cache);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		super.propertiesSet();
		this.aggregationRuleOrder = this.ehCache
				.getSearchAttribute("aggregationRuleOrder");
	}

	/**
	 * Lookup for fetching aggregation rules based on processingUnit
	 * 
	 * @param processingUnitIds
	 * @return
	 * @throws OptimaRetailException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<AggregationType> getAggregationRules(List<String> keyList)
			throws OptimaRetailApplicationException {
		Query query = getBaseSearchQuery(keyList);
		Results results = query.addOrderBy(this.aggregationRuleOrder,
				Direction.ASCENDING).execute();
		Map<Integer, AggregationType> aggrRulesMap = new HashMap<Integer, AggregationType>();
		Map<Integer, List<AggregationRulesRef>> tmpRulesMap = new HashMap<Integer, List<AggregationRulesRef>>();
		if (results.all().size() > 0) {
			return manageAggregationRules(results, aggrRulesMap, tmpRulesMap);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	private List<AggregationType> manageAggregationRules(Results results,
			Map<Integer, AggregationType> aggrRulesMap,
			Map<Integer, List<AggregationRulesRef>> tmpRulesMap) throws OptimaRetailApplicationException {
		List<String> aggrkey = null;
		List<String> aggrMetrics = null;
		String whereCriteria = null;
		Integer aggregationId = 0;
		String aggregationRule = null;
		Integer sysProcId = null;
		String desc=null;
		AggregationRulesRef aggrRule;
		List<AggregationRulesRef> aggrRulesRefList = null;
		for (Result result : results.all()) {
			aggrRule = (AggregationRulesRef) result.getValue();
			aggregationId = aggrRule.getAggregationId();
			aggrRulesRefList = tmpRulesMap.get(aggregationId);
			if (aggrRulesRefList == null || aggrRulesRefList != null
					&& aggrRulesRefList.size() == 0) {
				aggrRulesRefList = new ArrayList<AggregationRulesRef>();
				tmpRulesMap.put(aggregationId, aggrRulesRefList);
			}
			aggrRulesRefList.add(aggrRule);
		}
		for (Integer keys : tmpRulesMap.keySet()) {
			aggrkey = new ArrayList<String>();
			aggrMetrics = new ArrayList<String>();
			List<AggregationRulesRef> aggrRuleRefList = tmpRulesMap
					.get(keys);
			AggregationType aggrTypes=null;
			if (aggrRuleRefList!=null && aggrRuleRefList.size() > 0) {
				for (AggregationRulesRef aggrRuleRef : aggrRuleRefList) {
					aggregationId = aggrRuleRef.getAggregationId();
					aggregationRule = aggrRuleRef.getAggregationRule();
					sysProcId = aggrRuleRef.getProcessingUnitId();
					desc = aggrRuleRef.getDesc();
					if (aggrRuleRef.getAggregationRuleType() == 1) {
						aggrkey.add(aggregationRule);
					} else if (aggrRuleRef.getAggregationRuleType() == 2) {
						aggrMetrics.add(aggregationRule);
					} else if (aggrRuleRef.getAggregationRuleType() == 3) {
						whereCriteria = aggregationRule;
					}
				}
				aggrTypes = new AggregationType();
				aggrTypes.setId(aggregationId.longValue());
				String sysProcIdAggrId = sysProcId + ":"
						+ aggregationId.toString();
				aggrTypes.setName(sysProcIdAggrId);
				aggrTypes.setAggregationRuleKeySpelExpr(aggrkey);
				aggrTypes.setColumnsToAggregateValueSpelExpr(aggrMetrics);
				aggrTypes.setWhereCriteriaSpelExpr(whereCriteria);
				aggrTypes.setProcessingUnitId(sysProcId);
				aggrTypes.setDesc(desc);
			}
			aggrRulesMap.put(aggregationId, aggrTypes);
		}
		LOGGER.info("Aggregation values" + aggrRulesMap.values());
		return new ArrayList(Arrays.asList(aggrRulesMap.values().toArray()));
	}
}
