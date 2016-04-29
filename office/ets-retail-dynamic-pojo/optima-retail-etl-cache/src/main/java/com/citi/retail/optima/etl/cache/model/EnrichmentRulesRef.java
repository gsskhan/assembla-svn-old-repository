package com.citi.retail.optima.etl.cache.model;

import java.io.Serializable;

/**
 * @author mc56120
 * 
 */
public class EnrichmentRulesRef extends BaseRef implements Serializable {

	private static final long serialVersionUID = 1L;

	private String rulesKey;
	private String ruleToExecute;
	private Integer ruleOrder;

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

}
