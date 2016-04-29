package com.citi.retail.optima.etl.enrichment.common;

import java.io.Serializable;

import org.springframework.expression.Expression;

/**
 * @author mc56120
 * 
 */
public class EnrichmentRule implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer sysProcId;	
	private String rulesKey;
	private String ruleToExecute;
	private Integer ruleOrder;
	private Integer attributeId;
	private String attrName;
	private Expression rule;
	
	/**
	 * @return the rulesKey
	 */
	public String getRulesKey() {
		return this.rulesKey;
	}

	/**
	 * @param rulesKey
	 *            the rulesKey to set
	 */
	public void setRulesKey(String rulesKey) {
		this.rulesKey = rulesKey;
	}

	/**
	 * @return the ruleToExecute
	 */
	public String getRuleToExecute() {
		return this.ruleToExecute;
	}

	/**
	 * @param ruleToExecute
	 *            the ruleToExecute to set
	 */
	public void setRuleToExecute(String ruleToExecute) {
		this.ruleToExecute = ruleToExecute;
	}

	/**
	 * @return the ruleOrder
	 */
	public Integer getRuleOrder() {
		return this.ruleOrder;
	}

	/**
	 * @param ruleOrder
	 *            the ruleOrder to set
	 */
	public void setRuleOrder(Integer ruleOrder) {
		this.ruleOrder = ruleOrder;
	}

	public Expression getRule() {
		return rule;
	}

	public void setRule(Expression rule) {
		this.rule = rule;
	}
	
	public Integer getSysProcId() {
		return sysProcId;
	}

	public void setSysProcId(Integer sysProcId) {
		this.sysProcId = sysProcId;
	}	

	public Integer getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(Integer attributeId) {
		this.attributeId = attributeId;
	}

	public String getAttrName() {
		return attrName;
	}

	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}
}
