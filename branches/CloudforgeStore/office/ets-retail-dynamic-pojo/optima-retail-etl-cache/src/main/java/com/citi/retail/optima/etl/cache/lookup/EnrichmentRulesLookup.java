package com.citi.retail.optima.etl.cache.lookup;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import net.sf.ehcache.search.Attribute;
import net.sf.ehcache.search.Direction;
import net.sf.ehcache.search.Query;
import net.sf.ehcache.search.Result;
import net.sf.ehcache.search.Results;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.cache.Cache;

import com.citi.retail.optima.etl.cache.model.EnrichmentRulesRef;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;

/**
 * @author mc56120
 * 
 */
public class EnrichmentRulesLookup extends SpringCacheBaseLookup implements
		InitializingBean {

	private Attribute<Integer> ruleOrder;

	/**
	 * 
	 * @param cache
	 */
	public EnrichmentRulesLookup(Cache cache) {
		super(cache);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		super.propertiesSet();
		this.ruleOrder = this.ehCache.getSearchAttribute("ruleOrder");
	}

	/**
	 * retrieve enrichment rules based on the requested input
	 * 
	 * @param productName
	 * @param functionName
	 * @param processingUnitId
	 * @return
	 * @throws OptimaRetailException
	 */
	@Deprecated
	public Set<String> getEnrichmentRulesDeprecated(
			List<Integer> processingUnitIds) throws OptimaRetailApplicationException {

		Query query = getBaseSearchQueryDeprecated(processingUnitIds);
		Results results = query.addOrderBy(this.ruleOrder, Direction.ASCENDING)
				.execute();
		LinkedHashSet<String> rulesSet = new LinkedHashSet<String>();
		if (results.all().size() > 0) {
			EnrichmentRulesRef enrichmentRulesRef;
			for (Result result : results.all()) {
				enrichmentRulesRef = (EnrichmentRulesRef) result.getValue();
				rulesSet.add(enrichmentRulesRef.getRuleToExecute());
			}
			return rulesSet;
		}
		return null;
	}

	/**
	 * retrieve enrichment rules based on the requested input
	 * 
	 * @param productName
	 * @param functionName
	 * @param processingUnitId
	 * @return
	 * @throws OptimaRetailException
	 */
	public Set<String> getEnrichmentRules(List<String> keyList)
			throws OptimaRetailApplicationException {

		Query query = getBaseSearchQuery(keyList);
		Results results = query.addOrderBy(this.ruleOrder, Direction.ASCENDING)
				.execute();
		LinkedHashSet<String> rulesSet = new LinkedHashSet<String>();
		if (results.all().size() > 0) {
			EnrichmentRulesRef enrichmentRulesRef;
			for (Result result : results.all()) {
				enrichmentRulesRef = (EnrichmentRulesRef) result.getValue();
				rulesSet.add(enrichmentRulesRef.getRuleToExecute());
			}
			return rulesSet;
		}
		return null;
	}

}
