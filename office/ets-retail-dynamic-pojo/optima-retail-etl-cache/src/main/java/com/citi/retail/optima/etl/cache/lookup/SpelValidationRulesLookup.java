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

import com.citi.retail.optima.etl.cache.model.SPELidationRulesRef;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;

public class SpelValidationRulesLookup extends SpringCacheBaseLookup implements
		InitializingBean {
	Attribute<Integer> ruleOrder;
	
	public SpelValidationRulesLookup(Cache cache) {
		super(cache);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		this.ruleOrder = this.ehCache.getSearchAttribute("ruleOrder");
		super.propertiesSet();
	}

	public Set<SPELidationRulesRef> getSpelValidationRules(List<String> keyList)
			throws OptimaRetailApplicationException {

		Query query = getBaseSearchQuery(keyList);
		Results results = query.addOrderBy(this.ruleOrder, Direction.ASCENDING)
				.execute();
		Set<SPELidationRulesRef> rulesSet = new LinkedHashSet<SPELidationRulesRef>();
		if (results.all().size() > 0) {
			for (Result result : results.all()) {
				rulesSet.add((SPELidationRulesRef) result.getValue());
			}
			return rulesSet;
		}
		return null;
	}
}
