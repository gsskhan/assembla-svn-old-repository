package com.citi.retail.optima.etl.aggregation.dao;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * POJO Holds aggregation rule meta information
 * @author yh43239
 *
 */
public class AggregationRuleMeta implements Comparable<AggregationRuleMeta>, Serializable {

	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(AggregationRuleMeta.class);
	private static final long serialVersionUID = -5560620281371618219L;
	//keys to identify a unique rule
	private Integer aggregationId;
	private String aggregationName;
	private String rulesKey;
	private String productName;
	private Integer processingUnitId;

	//rule meta values
	private int aggregationRuleType;
	private String aggregationRule;
	private int aggregationRuleOrder;
	private String desc;

	
	
	
	public AggregationRuleMeta(Integer processingUnitId) {
		super();
		this.processingUnitId = processingUnitId;
	}

	/**
	 *  get Aggregation rule id
	 * @return
	 */
	public Integer getAggregationId() {
		return aggregationId;
	}

	/**
	 * Set aggregation rule id
	 * @param aggregationId
	 */
	public void setAggregationId(Integer aggregationId) {
		this.aggregationId = aggregationId;
	}
	/**
	 * Set aggregation rule name
	 * @return
	 */
	public String getAggregationName() {
		return aggregationName;
	}
	/** 
	 * Get aggregation rule name
	 * @param aggregationName
	 */
	public void setAggregationName(String aggregationName) {
		this.aggregationName = aggregationName;
	}

	/**
	 * Get aggregation rule key
	 * @return
	 */
	public String getRulesKey() {
		return rulesKey;
	}
	/**
	 * Set aggregation rule key
	 * @param rulesKey
	 */
	public void setRulesKey(String rulesKey) {
		this.rulesKey = rulesKey;
	}

	/**
	 * Get product name
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * Set product name
	 * @return 
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/***
	 * Get Process Unit id
	 * @return
	 */

	public Integer getProcessingUnitId() {
		return processingUnitId;
	}
	/**
	 * Set Process Unit id
	 * @param processingUnitId
	 */

	public void setProcessingUnitId(Integer processingUnitId) {
		this.processingUnitId = processingUnitId;
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
	 * @param desc
	 *            the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	


	/**
	 * Sorting order by ascending 
	 */
	@Override
	public int compareTo(AggregationRuleMeta thatAggregationRuleMeta) {
	
		if(this.getAggregationRuleOrder() == thatAggregationRuleMeta.getAggregationRuleOrder()) {
			return 0;
		} else {
			return this.getAggregationRuleOrder() > thatAggregationRuleMeta.getAggregationRuleOrder() ? 1 : -1;
		}
	
	}
}


