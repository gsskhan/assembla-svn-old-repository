/**
 * 
 */
package com.citi.retail.optima.etl.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.citi.retail.optima.etl.validation.constraint.RuleConstraint;
import com.citi.retail.optima.etl.validation.dao.ValidationRulesDao;
import com.citi.retail.optima.etl.validation.exception.ValidationException;

/**
 * @author TJ
 * 
 */
public class ValidationRulesLoader {
	
	private static final Logger LOGGER = LoggerFactory
			.getLogger(ValidationRulesLoader.class);

	private Map<String, List<RuleConstraint>> valiationRulesMap	= new ConcurrentHashMap<String, List<RuleConstraint>>();
	
	private ValidationRulesDao<List<RuleConstraint>> validationRulesDao;
	
	
	/**
	 * This method would get the validation rules from map and returns to caller.
	 * 
	 * @param keyList
	 * @return
	 * @throws OptimaRetailApplicationException
	 */
	public synchronized List<RuleConstraint> getRulesList(List<String> keyList)	throws ValidationException {		
		List<RuleConstraint> rulesList = new ArrayList<RuleConstraint>();
		for (String key: keyList) {
			if ( valiationRulesMap.containsKey(key)) {
				rulesList.addAll(valiationRulesMap.get(key));	
			} else {
				List<RuleConstraint> validationRules = validationRulesDao.getValidationRules(key);
				if (validationRules != null && !validationRules.isEmpty() ) {
					valiationRulesMap.put(key, validationRules);
					rulesList.addAll(validationRules);	
				}
				
			}
		}		
		
		if (rulesList.isEmpty()) {
			String errorMsg = "ValidationService would not be loaded the rules for key "
					+ keyList
					+ " as there are no Validation Rules Specified for the given criteria.";
			LOGGER.error(errorMsg);		
		}
		return rulesList;
	}

	
	public void setValidationRulesDao(ValidationRulesDao<List<RuleConstraint>> validationRulesDao) {
		this.validationRulesDao = validationRulesDao;
	}
	
}
