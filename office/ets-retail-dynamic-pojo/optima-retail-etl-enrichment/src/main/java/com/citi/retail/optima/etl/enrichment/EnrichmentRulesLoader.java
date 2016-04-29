package com.citi.retail.optima.etl.enrichment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.citi.retail.optima.etl.enrichment.common.EnrichmentRule;
import com.citi.retail.optima.etl.enrichment.dao.EnrichmentRulesDao;
import com.citi.retail.optima.etl.enrichment.exception.EnrichmentException;

/**
 * @author ms04453 Loads Enrichment rules for various criteria passed.
 */
public class EnrichmentRulesLoader  {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(EnrichmentRulesLoader.class);
	
	private Map<String, List<EnrichmentRule>> enrichmentRulesMap = new ConcurrentHashMap<String, List<EnrichmentRule>>();	

	private EnrichmentRulesDao<Map<String, List<EnrichmentRule>>> enrichmentRulesDao;

	

	/**
	 * This method would get the validation rules from map and returns to caller.
	 * 
	 * @param keyList
	 * @return
	 * @throws OptimaRetailApplicationException
	 */
	public synchronized List<EnrichmentRule> getRulesList(List<String> keyList)	throws EnrichmentException {
		List<EnrichmentRule> rulesList = new ArrayList<EnrichmentRule>();
		for (String key: keyList) {
			if (enrichmentRulesMap.containsKey(key)) {
				rulesList.addAll(enrichmentRulesMap.get(key));				
			} else {
				List<EnrichmentRule> enrichmentRulesList = enrichmentRulesDao.getEnrichmentRules(key);
				if (!enrichmentRulesList.isEmpty()) {
					enrichmentRulesMap.put(key, enrichmentRulesList);
					rulesList.addAll(enrichmentRulesList);		
				}				
			}
		}	
		
		if (rulesList.isEmpty()) {
			String errorMsg = "EnrichmentService would not be loaded the rules for key "
					+ keyList
					+ " as there are no Enrichment Rules Specified for the given criteria.";
			LOGGER.error(errorMsg);		
		}
		return rulesList;
	}	
	
	public void setEnrichmentRulesDao(
			EnrichmentRulesDao<Map<String, List<EnrichmentRule>>> enrichmentRulesDao) {
		this.enrichmentRulesDao = enrichmentRulesDao;
	}
	
}
