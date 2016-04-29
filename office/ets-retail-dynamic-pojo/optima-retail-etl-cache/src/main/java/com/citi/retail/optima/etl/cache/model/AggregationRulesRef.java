/**
 * 
 */
package com.citi.retail.optima.etl.cache.model;

import java.io.Serializable;

/**
 * @author mc56120
 * 
 */
public class AggregationRulesRef extends BaseRef implements Serializable {

	private static final long serialVersionUID = 1L;

	private String rulesKey;
	private Integer aggregationId;
	private String aggregationName;
	private int aggregationRuleType;
	private String aggregationRule;
	private int aggregationRuleOrder;
	private String desc;

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
	 * @return the aggregationId
	 */
	public Integer getAggregationId() {
		return this.aggregationId;
	}

	/**
	 * @param aggregationId
	 *            the aggregationId to set
	 */
	public void setAggregationId(Integer aggregationId) {
		this.aggregationId = aggregationId;
	}

	/**
	 * @return the aggregationName
	 */
	public String getAggregationName() {
		return this.aggregationName;
	}

	/**
	 * @param aggregationName
	 *            the aggregationName to set
	 */
	public void setAggregationName(String aggregationName) {
		this.aggregationName = aggregationName;
	}

	/**
	 * @return the aggregationRuleType
	 */
	public int getAggregationRuleType() {
		return this.aggregationRuleType;
	}

	/**
	 * @param aggregationRuleType
	 *            the aggregationRuleType to set
	 */
	public void setAggregationRuleType(int aggregationRuleType) {
		this.aggregationRuleType = aggregationRuleType;
	}

	/**
	 * @return the aggregationRule
	 */
	public String getAggregationRule() {
		return this.aggregationRule;
	}

	/**
	 * @param aggregationRule
	 *            the aggregationRule to set
	 */
	public void setAggregationRule(String aggregationRule) {
		this.aggregationRule = aggregationRule;
	}

	/**
	 * @return the aggregationRuleOrder
	 */
	public int getAggregationRuleOrder() {
		return this.aggregationRuleOrder;
	}

	/**
	 * @param aggregationRuleOrder
	 *            the aggregationRuleOrder to set
	 */
	public void setAggregationRuleOrder(int aggregationRuleOrder) {
		this.aggregationRuleOrder = aggregationRuleOrder;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	

}
