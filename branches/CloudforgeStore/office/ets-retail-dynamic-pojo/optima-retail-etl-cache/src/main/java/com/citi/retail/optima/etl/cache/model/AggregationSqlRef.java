/**
 * 
 */
package com.citi.retail.optima.etl.cache.model;

import java.io.Serializable;

/**
 * @author mc56120
 * 
 */
public class AggregationSqlRef extends BaseRef implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer aggregationId;
	private String aggregationName;
	private String rulesKey;
	private String insertSql;

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
