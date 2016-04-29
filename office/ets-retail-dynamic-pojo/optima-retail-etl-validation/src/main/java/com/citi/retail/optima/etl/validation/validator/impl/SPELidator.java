/**
 * 
 */
package com.citi.retail.optima.etl.validation.validator.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.EvaluationException;
import org.springframework.expression.Expression;

import com.citi.retail.optima.etl.validation.constraint.RuleConstraint;
import com.citi.retail.optima.etl.validation.exception.ExceptionType;
import com.citi.retail.optima.etl.validation.exception.FieldError;
import com.citi.retail.optima.etl.validation.exception.ValidationDataException;
import com.citi.retail.optima.etl.validation.exception.ValidationException;
import com.citi.retail.optima.etl.validation.validator.ItemValidator;

/**
 * @author TJ
 * 
 */
public class SPELidator<T> implements ItemValidator<T> {

	private EvaluationContext evalContext;

	private List<RuleConstraint> rulesList;

	private List<FieldError> fieldErrors;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(SPELidator.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.citi.retail.optima.etl.validation.ItemValidator#validate(java.lang
	 * .Object)
	 */
	public void validate(T item) throws ValidationDataException {
		if (rulesList == null || rulesList.isEmpty()) {
			LOGGER.debug("validate() | No rules processed as rules list is empty!");
			return;
		}
		fieldErrors = new ArrayList<FieldError>();
		if (item != null) {

			for (RuleConstraint ruleConstraint : rulesList) {

				Object result = eval(item,
						(Expression) ruleConstraint.getRule(),
						ruleConstraint.getAttributeName());

				if (result != null) {
					Boolean success = (Boolean) result;
					// Build Validation error message
					if (!success) {
						LOGGER.warn("Constraint Violation for "
								+ ruleConstraint.getAttributeName()
								+ " while validating rule:- "
								+ ruleConstraint.getRuleAsString());
						handleValidationErrors(item, ruleConstraint);
					}
				}

			}
			if (fieldErrors != null
					&& fieldErrors.size() > 0) {
				LOGGER.error("Validation errors found for item");
				throw new ValidationDataException(fieldErrors);
			}
		} else {
			LOGGER.error("NULL valued Account Object passed into Validator, Hence add this to Skipped Records : "
					+ item);
			ValidationDataException validationDataException = new ValidationDataException();
			FieldError fieldError = new FieldError();
			fieldError.setUserErrorMessage("NULL valued Account Object passed into Validator, Hence add this to Skipped Records : ");
			fieldError.setExceptionMessage("NULL valued Account Object passed into Validator, Hence add this to Skipped Records : ");
			fieldError.setExceptionType(ExceptionType.ERROR);
			fieldErrors.add(fieldError);
			validationDataException.setFieldErrors(fieldErrors);
			throw validationDataException;
		}

	}

	/**
	 * 
	 * @param item
	 * @param expr
	 * @param attributeName
	 * @return
	 */
	private Object eval(T item, Expression expr, String attributeName) {
		Object result = null;
		try {

			result = expr.getValue(this.evalContext, item);

		} catch (EvaluationException e) {
			LOGGER.error("Evaluation Exception encountered when evaluating SPEL:"
					+ expr.getExpressionString());
			handleExceptions(expr.getExpressionString(), attributeName, e);
		}

		// Rule Configuration error leads to null result
		if (result == null) {
			LOGGER.error("Evaluation Result is null when evaluating SPEL:"
					+ expr.getExpressionString());
			handleExceptions(expr.getExpressionString(), attributeName,
					new IllegalArgumentException("SPEL misconfiguration"));
		}
		return result;
	}

	/**
	 * 
	 * @param ruleConstraint
	 */
	private void handleValidationErrors(T item, RuleConstraint ruleConstraint) {
		FieldError fieldError = new FieldError();
		fieldError.setAttributeId(ruleConstraint.getAttributeId());
		fieldError.setAttributeName(ruleConstraint.getAttributeName());
		fieldError.setExceptionType(ExceptionType.SKIPPABLE);
		fieldError.setRuleId(ruleConstraint.getRuleId());
		fieldError.setRule(ruleConstraint.getRuleAsString());
		fieldError.setUserErrorMessage(ruleConstraint.getViolationMsg());
		fieldError.setExceptionMessage("Constraint Violation for: "
				+ ruleConstraint.getAttributeName());

		if (ruleConstraint.getAuditValuesExpr() != null) {
			Object evalResult = eval(item,
					(Expression) ruleConstraint.getAuditValuesExpr(),
					ruleConstraint.getAttributeName());

			if (evalResult != null) {
				fieldError.setExceptionMessage((String) evalResult);
			}
		}
		fieldErrors.add(fieldError);
	}

	/**
	 * @param currExp
	 * @param exception
	 */
	private void handleExceptions(String currExp, String attributeName,
			RuntimeException exception) {
		FieldError fieldError = new FieldError();
		fieldError
				.setUserErrorMessage("Error while validating data for: "
						+ attributeName);
		fieldError
				.setExceptionMessage(exception.getMessage() == null ? exception
						.getClass().getName() : exception.getMessage());
		fieldError.setRule(currExp);
		fieldError.setAttributeName(attributeName);
		fieldError.setExceptionType(ExceptionType.ERROR);
		fieldError.setStackTrace(ValidationException.getStackTrace(exception));
		fieldErrors.add(fieldError);
	}

	public EvaluationContext getEvalContext() {
		return evalContext;
	}

	public void setEvalContext(EvaluationContext evalContext) {
		this.evalContext = evalContext;
	}

	public List<RuleConstraint> getRulesList() {
		return rulesList;
	}

	public void setRulesList(List<RuleConstraint> rulesList) {
		this.rulesList = rulesList;
	}

}
