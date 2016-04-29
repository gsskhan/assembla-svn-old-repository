package com.citi.retail.optima.etl.validation.dao;

import java.util.List;

import com.citi.retail.optima.etl.validation.constraint.RuleConstraint;
import com.citi.retail.optima.etl.validation.exception.ValidationException;

public interface ValidationRulesDao<E> {
	
	List<RuleConstraint> getValidationRules(String key) throws ValidationException;
	
}