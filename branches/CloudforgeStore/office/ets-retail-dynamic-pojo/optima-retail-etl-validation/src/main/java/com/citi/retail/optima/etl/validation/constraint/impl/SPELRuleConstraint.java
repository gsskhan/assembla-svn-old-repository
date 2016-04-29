/**
 * 
 */
package com.citi.retail.optima.etl.validation.constraint.impl;

import org.springframework.expression.Expression;

import com.citi.retail.optima.etl.validation.constraint.RuleConstraint;

/**
 * @author TJ
 *
 */
public class SPELRuleConstraint extends RuleConstraint {
	
	private Expression rule;
	
	private Expression auditValuesExpr;
	
	/* (non-Javadoc)
	 * @see com.citi.retail.optima.etl.validation.RuleConstraint#getRule()
	 * Covariant return type for Expression
	 */
	@Override
	public Expression getRule() {
		return rule;
	}

	public void setRule(Expression rule) {
		this.rule = rule;
	}

	/*
	 * (non-Javadoc)
	 * @see com.citi.retail.optima.etl.validation.constraint.RuleConstraint#getErrorValues()
	 * Covariant return type for Expression
	 */
	@Override
	public Expression getAuditValuesExpr() {
		return auditValuesExpr;
	}

	public void setAuditValuesExpr(Expression auditValuesExpr) {
		this.auditValuesExpr = auditValuesExpr;
	}

	
	
}
