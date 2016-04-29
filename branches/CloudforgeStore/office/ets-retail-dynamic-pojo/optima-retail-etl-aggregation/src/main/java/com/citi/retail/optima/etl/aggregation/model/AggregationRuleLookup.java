package com.citi.retail.optima.etl.aggregation.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import ch.qos.logback.classic.Logger;

import com.citi.retail.optima.etl.aggregation.dao.AggregationRuleMeta;
import com.citi.retail.optima.etl.aggregation.dao.AggregationRuleSql;
import com.citi.retail.optima.etl.aggregation.dao.AggregationRulesDao;
import com.citi.retail.optima.etl.aggregation.exception.AggregationException;

/**
 * Responsible in loading aggregation rule in to memory for Aggregation Service
 */

public class AggregationRuleLookup implements InitializingBean{
	private final Logger LOGGER = (Logger) LoggerFactory
			.getLogger(AggregationRuleLookup.class);
    //single copy of the rules guaranteed by the spring context
	private ConcurrentHashMap<String, AggregationRuleMeta> ruleMap = null;
	private ConcurrentHashMap<String, AggregationRuleSql> sqlRuleMap = null;
	private AggregationRulesDao aggregationRulesDao = null;

	
	public AggregationRuleLookup() {
	
	}

	/**
	 * Gets Aggregation Rule meta
	 * @return
	 */
	public ConcurrentHashMap<String, AggregationRuleMeta> getRuleMap() {
		return ruleMap;
	}
	
	/**
	 * Set Aggregation Rule meta
	 * @param ruleMap
	 */
	public void setRuleMap(
			ConcurrentHashMap<String, AggregationRuleMeta> ruleMap) {
		this.ruleMap = ruleMap;
	}
	
	/**
	 * get Aggregation Rule SQL 
	 * @return
	 */

	public ConcurrentHashMap<String, AggregationRuleSql> getSqlRuleMap() {
		return sqlRuleMap;
	}
	
	
	/**
	 * Sets agregation rule Sql
	 * @param sqlRuleMap
	 */
	public void setSqlRuleMap(
			ConcurrentHashMap<String, AggregationRuleSql> sqlRuleMap) {
		this.sqlRuleMap = sqlRuleMap;
	}

	
	/**
	 * Up on property set... pull aggregation rules out into hashmap
	 */
	public void afterPropertiesSet() {

		LOGGER.info("Loading rules from database into concurrent hashmap: ");
		LOGGER.info("Loading Aggregation Rules");
		List<AggregationRuleMeta> ruleList = aggregationRulesDao.getAggregationRulesWithKey();
		if (ruleMap == null) {
			ruleMap = new ConcurrentHashMap<String, AggregationRuleMeta>(
					ruleList.size());
		}
		for (int i = 0; i < ruleList.size(); i++) {
			ruleMap.put(Integer.toString(i), ruleList.get(i));
		}

		LOGGER.info("Loading Sql Type Aggregation Rules");
		List<AggregationRuleSql> sqlRuleList = aggregationRulesDao.getAggregationSQLRuleRef();
		if (sqlRuleMap == null) {
			sqlRuleMap = new ConcurrentHashMap<String, AggregationRuleSql>(
					sqlRuleList.size());
		}
		for (int i = 0; i < sqlRuleList.size(); i++) {
			sqlRuleMap.put(Integer.toString(i), sqlRuleList.get(i));
		}

	}


	/**********************  Lookup Aggregation Rule **************************/


	/**
	 * Gets the aggregation type list in ascending order
	 * @param keyList
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<AggregationType> getAggregationRuleType(List<String> keyList){
		

		List<AggregationRuleMeta> results = getAggregationRuleMetaWithMatchingRuleKey(keyList);

		Collections.sort(results);
		
		Map<Integer, AggregationType> aggrRulesMap = new HashMap<Integer, AggregationType>();
		Map<Integer, List<AggregationRuleMeta>> tmpRulesMap = new HashMap<Integer, List<AggregationRuleMeta>>();
		if (results.size() > 0) {
			return manageAggregationRules(results, aggrRulesMap, tmpRulesMap);
		}
		return null;
	}

	/**
	 * Compile a list og Aggregation Type ...
	 * @param results
	 * @param aggrRulesMap
	 * @param tmpRulesMap
	 * @return
	 */

	private List<AggregationType> manageAggregationRules(List<AggregationRuleMeta> results,
			Map<Integer, AggregationType> aggrRulesMap,
			Map<Integer, List<AggregationRuleMeta>> tmpRulesMap)  {
		
		
		
		List<String> aggrkey = null;
		List<String> aggrMetrics = null;
		String whereCriteria = null;
		Integer aggregationId = 0;
		String aggregationRule = null;
		Integer sysProcId = null;
		String desc=null;

		List<AggregationRuleMeta> aggrRulesRefList = null;
		for (AggregationRuleMeta aggregationRuleRef : results) {
			
			aggregationId = aggregationRuleRef.getAggregationId();
			aggrRulesRefList = tmpRulesMap.get(aggregationId);
			if (aggrRulesRefList == null || aggrRulesRefList != null
					&& aggrRulesRefList.size() == 0) {
				aggrRulesRefList = new ArrayList<AggregationRuleMeta>();
				tmpRulesMap.put(aggregationId, aggrRulesRefList);
			}
			aggrRulesRefList.add(aggregationRuleRef);
		}
		for (Integer keys : tmpRulesMap.keySet()) {
			aggrkey = new ArrayList<String>();
			aggrMetrics = new ArrayList<String>();
			List<AggregationRuleMeta> aggrRuleRefList = tmpRulesMap
					.get(keys);
			AggregationType aggrTypes=null;
			
			if (aggrRuleRefList!=null && aggrRuleRefList.size() > 0) {
				
				for (AggregationRuleMeta aggrRuleRef : aggrRuleRefList) {
					aggregationId = aggrRuleRef.getAggregationId();
					aggregationRule = aggrRuleRef.getAggregationRule();
					sysProcId = aggrRuleRef.getProcessingUnitId();
					desc = aggrRuleRef.getDesc();
					//Schedule Value Type SEGMENT, METRIC, CRETERIA
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
				String sysProcIdAggrId = sysProcId + ":"+ aggregationId.toString();
				aggrTypes.setName(sysProcIdAggrId);
				aggrTypes.setAggregationRuleKeySpelExpr(aggrkey);
				aggrTypes.setColumnsToAggregateValueSpelExpr(aggrMetrics);
				aggrTypes.setWhereCriteriaSpelExpr(whereCriteria);
				aggrTypes.setProcessingUnitId(sysProcId);
				aggrTypes.setDesc(desc);
			}
			aggrRulesMap.put(aggregationId, aggrTypes);
		}
		
		return new ArrayList<AggregationType>(aggrRulesMap.values());
	}
	
	
	
	

	/**********************  Lookup Aggregation Sql **************************/
	
	
	
	/**
	 * Gets Aggregation Rule Sqls by processing unit ids
	 * @param processingUnitIds
	 * @return
	 * @throws AggregationException
	 */
	
	public Map<String, AggregationRuleSql> getAggregationSqlDeprecated(
			List<Integer> processingUnitIds) throws AggregationException {


		List<AggregationRuleSql> results = getRuleSqlWithMatchingPuKey(processingUnitIds);

		Map<String, AggregationRuleSql> aggrRulesMap = new HashMap<String, AggregationRuleSql>();
		
		if (results.size() > 0) {
			for (AggregationRuleSql aggregationRuleRef : results) {
			
				aggrRulesMap.put(aggregationRuleRef.getAggregationName(), aggregationRuleRef);
			}
			return aggrRulesMap;
		}
		return null;
		

	}
	
	/**
	 * Gets Aggregation Rule Sqls by Keylist (CategoryName and system process id)
	 * @param keyList
	 * @return
	 * @throws AggregationException
	 */

	public Map<String, AggregationRuleSql> getAggregationSql(List<String> keyList)
			throws AggregationException {
	

		List<AggregationRuleSql> results = getSqlRuleWithMatchingRuleKey(keyList);
		Map<String, AggregationRuleSql> aggrRulesMap = new HashMap<String, AggregationRuleSql>();

		if (results.size() > 0) {
			for (AggregationRuleSql aggregationRuleRef : results) {
				Integer sysProcId= aggregationRuleRef.getProcessingUnitId();
				String aggregationType = aggregationRuleRef.getAggregationId().toString();
				String key = sysProcId + ":" + aggregationType;
				aggrRulesMap.put(key, aggregationRuleRef);
			}
			return aggrRulesMap;
		}
		
		return null;
		
		
	}

	
	/**
	 * Gets Aggregation Rule Metas associated to Keylist (CategoryName and system process id)
	 * @param keyList
	 * @return
	 */

	public List<AggregationRuleMeta> getAggregationRuleMetaWithMatchingRuleKey (List<String> keyList) {

		ArrayList<AggregationRuleMeta> results = null;
		
        if (keyList != null) {
        	results = new ArrayList<AggregationRuleMeta>(getRuleMap().size());
        	for( AggregationRuleMeta aggregationRuleRef: getRuleMap().values())
        	{
        	   for(String ruleKey: keyList){
        		   if(aggregationRuleRef.getRulesKey().equals(ruleKey)){
        		    results.add(aggregationRuleRef);
        		   }
        	   }
        	}
		
		}else{
			results = new ArrayList<AggregationRuleMeta>(getRuleMap().values());
	
		}
        return results;
        
	}
	
	/**
	 * Get Aggregation Rule Sql  associated to Keylist process unit id)
	 * @param processingUnitIds
	 * @return
	 */
	
	
	public List<AggregationRuleSql>  getRuleSqlWithMatchingPuKey(List<Integer> processingUnitIds) {
	
        ArrayList<AggregationRuleSql> results = null;
		
        if (processingUnitIds != null) {
        	results = new ArrayList<AggregationRuleSql>(getSqlRuleMap().size());
        	for(AggregationRuleSql aggregationRuleRef: getSqlRuleMap().values())
        	{
        	   for(Integer puId: processingUnitIds){
        		   if(aggregationRuleRef.getProcessingUnitId().intValue()==puId.intValue() ){
        		      results.add(aggregationRuleRef);
        		   }
        	   }
        	}
		
		}else{
			results = new ArrayList<AggregationRuleSql>(getSqlRuleMap().values());
	
		}
        return results;

	}
	/**
	 * Get Aggregation Rule Sql  associated to Keylist (CategoryName and system process id)
	 * @param processingUnitIds
	 * @return
	 */
	
	public List<AggregationRuleSql>  getSqlRuleWithMatchingRuleKey(List<String> keyList) {
		
        ArrayList<AggregationRuleSql> results = null;
		
        if (keyList != null) {
        	results = new ArrayList<AggregationRuleSql>(getSqlRuleMap().size());
        	for(AggregationRuleSql aggregationRuleRef: getSqlRuleMap().values())
        	{
        	   for(String ruleKey: keyList){
        		   if(aggregationRuleRef.getRulesKey().equals(ruleKey)){
        		    results.add(aggregationRuleRef);
        		   }
        	   }
        	}
		
		}else{
			results = new ArrayList<AggregationRuleSql>(getSqlRuleMap().values());
	
		}
        return results;

	}

	/**
	 *  For getting AggregationRulesDao
	 * @return
	 */
	
	public AggregationRulesDao getAggregationRulesDao() {
		return aggregationRulesDao;
	}

	/**
	 * Setting AggregationRuleDao
	 * @param aggregationRulesDao
	 */

	public void setAggregationRulesDao(AggregationRulesDao aggregationRulesDao) {
		this.aggregationRulesDao = aggregationRulesDao;
	}


}
