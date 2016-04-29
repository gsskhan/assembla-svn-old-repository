/**
 * 
 */
package com.citi.retail.optima.etl.validation.validator;

import java.util.List;

import org.springframework.expression.EvaluationContext;

import com.citi.retail.optima.etl.validation.constraint.RuleConstraint;
import com.citi.retail.optima.etl.validation.exception.ValidationDataException;


/**
 * @author TJ
 *
 */
public interface ItemValidator<T>  {
	
	void validate(T value) throws ValidationDataException;
	
	void setRulesList(List<RuleConstraint> rulesList);
	
	public void setEvalContext(EvaluationContext evalContext);
}
