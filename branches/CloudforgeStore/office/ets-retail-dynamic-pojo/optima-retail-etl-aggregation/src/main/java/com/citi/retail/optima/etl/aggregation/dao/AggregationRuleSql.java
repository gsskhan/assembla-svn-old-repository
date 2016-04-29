package com.citi.retail.optima.etl.aggregation.dao;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * POJO Holds Aggregation Inseration Rule Sql 
 * @author yh43239
 *
 */
public class AggregationRuleSql implements Serializable {

	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(AggregationRuleSql.class);
	private static final long serialVersionUID = -6836853083830547683L;
	
	//unique key set 
	private Integer aggregationId;
	private String aggregationName;
	private String rulesKey;
	private String productName;
	private Integer processingUnitId;
	
	//insertiong sql used for the rule
	private String insertSql;
	
	public AggregationRuleSql(Integer processingUnitId) {
		super();
		this.processingUnitId = processingUnitId;
	}

	/**
	 * get aggregation rule id
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
     * Get aggregation rule name
     * @return
     */
	public String getAggregationName() {
		return aggregationName;
	}

	/**
	 * Set aggregation rule name
	 * @param aggregationName
	 */
	public void setAggregationName(String aggregationName) {
		this.aggregationName = aggregationName;
	}
	
	/**
	 * get aggregation rule key
	 * @return
	 */
	public String getRulesKey() {
		return rulesKey;
	}



	/**
	 * set aggregation rule key
	 * @param rulesKey
	 */
	public void setRulesKey(String rulesKey) {
		this.rulesKey = rulesKey;
	}



	/**
	 * get product name
	 * @return
	 */
	public String getProductName() {
		return productName;
	}


	/**
	 * Set product name
	 * @param productName
	 */

	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * get process unit id
	 * @return
	 */
	public Integer getProcessingUnitId() {
		return processingUnitId;
	}
	
	/**
	 * set process unit id
	 * @param processingUnitId
	 */
	public void setProcessingUnitId(Integer processingUnitId) {
		this.processingUnitId = processingUnitId;
	}


	/**
	 * @return the insertSql
	 */
	public String getInsertSql() {
		return this.insertSql;
	}

	/**
	 * @param insertSql
	 *            the insertSql to set
	 */
	public void setInsertSql(String insertSql) {
		this.insertSql = insertSql;
	}

}
