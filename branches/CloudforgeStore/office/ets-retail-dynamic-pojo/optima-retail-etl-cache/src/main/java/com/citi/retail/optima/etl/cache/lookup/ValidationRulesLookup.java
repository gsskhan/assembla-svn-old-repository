package com.citi.retail.optima.etl.cache.lookup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.sf.ehcache.search.Direction;
import net.sf.ehcache.search.Query;
import net.sf.ehcache.search.Result;
import net.sf.ehcache.search.Results;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.cache.Cache;
import com.citi.retail.optima.etl.common.db.dao.ConstraintMapping;
import com.citi.retail.optima.etl.common.db.dao.RuleInfo;

public class ValidationRulesLookup extends SpringCacheBaseLookup implements
		InitializingBean {


	public ValidationRulesLookup(Cache cache) {
		super(cache);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		super.propertiesSet();
	}
		
	public Map<String, Map<String, List<ConstraintMapping>>> getValidationRules(
			List<String> keyList) {
		Map<String, Map<String, List<ConstraintMapping>>> constraintMap = null;
		Query query = getBaseSearchQuery(keyList);
		query.addOrderBy(this.processingUnitId, Direction.ASCENDING);
		Results results = query.execute();
		if (results.all().size() > 0) {
			constraintMap = new HashMap<String, Map<String, List<ConstraintMapping>>>();
			for (Result result : results.all()) {
				ConstraintMapping mapping = (ConstraintMapping) result
						.getValue();
				mapping.setCheckOnlyField(true);
				String className = mapping.getClassName();
				String validationType = mapping.getValidationType();
				if (!constraintMap.containsKey(className)) {
					constraintMap.put(className,
							new HashMap<String, List<ConstraintMapping>>());
				}
				Map<String, List<ConstraintMapping>> constraintTypeMap = constraintMap
						.get(className);
				if (!constraintTypeMap.containsKey(validationType)) {
					constraintTypeMap.put(validationType,
							new ArrayList<ConstraintMapping>());
				}
				List<ConstraintMapping> constraints = constraintTypeMap
						.get(validationType);
				if (constraints.contains(mapping)) {
					ConstraintMapping mappingInList = constraints
							.get(constraints.indexOf(mapping));
					Set<RuleInfo> ruleSet = new HashSet<RuleInfo>(
							mappingInList.getRules());
					ruleSet.addAll(mapping.getRules());
					mappingInList.setRules(new ArrayList<RuleInfo>(ruleSet));
					Collections.sort(mappingInList.getRules());
				} else {
					constraints.add(mapping);
				}

			}
		}
		return constraintMap;
	}

}
