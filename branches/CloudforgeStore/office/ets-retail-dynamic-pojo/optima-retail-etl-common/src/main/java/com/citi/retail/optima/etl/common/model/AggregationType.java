/**
 * 
 */
package com.citi.retail.optima.etl.common.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author mc56120
 * 
 */
public class AggregationType implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private List<String> aggregationRuleKeySpelExpr;
	private List<String> columnsToAggregateValueSpelExpr;
	private String whereCriteriaSpelExpr;
	private Integer processingUnitId;
	private String desc;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the aggregationRuleKeySpelExpr
	 */
	public List<String> getAggregationRuleKeySpelExpr() {
		return aggregationRuleKeySpelExpr;
	}

	/**
	 * @param aggregationRuleKeySpelExpr
	 *            the aggregationRuleKeySpelExpr to set
	 */
	public void setAggregationRuleKeySpelExpr(
			List<String> aggregationRuleKeySpelExpr) {
		this.aggregationRuleKeySpelExpr = aggregationRuleKeySpelExpr;
	}

	/**
	 * @return the columnsToAggregateValueSpelExpr
	 */
	public List<String> getColumnsToAggregateValueSpelExpr() {
		return columnsToAggregateValueSpelExpr;
	}

	/**
	 * @param columnsToAggregateValueSpelExpr
	 *            the columnsToAggregateValueSpelExpr to set
	 */
	public void setColumnsToAggregateValueSpelExpr(
			List<String> columnsToAggregateValueSpelExpr) {
		this.columnsToAggregateValueSpelExpr = columnsToAggregateValueSpelExpr;
	}

	/**
	 * @return the whereCriteriaSpelExpr
	 */
	public String getWhereCriteriaSpelExpr() {
		return whereCriteriaSpelExpr;
	}

	/**
	 * @param whereCriteriaSpelExpr
	 *            the whereCriteriaSpelExpr to set
	 */
	public void setWhereCriteriaSpelExpr(String whereCriteriaSpelExpr) {
		this.whereCriteriaSpelExpr = whereCriteriaSpelExpr;
	}

	/**
	 * @return the processingUnitId
	 */
	public Integer getProcessingUnitId() {
		return processingUnitId;
	}

	/**
	 * @param processingUnitId
	 *            the processingUnitId to set
	 */
	public void setProcessingUnitId(Integer processingUnitId) {
		this.processingUnitId = processingUnitId;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AggregationType ["
				+ (id != null ? "id=" + id + ", " : "")
				+ (name != null ? "name=" + name + ", " : "")
				+ (aggregationRuleKeySpelExpr != null ? "aggregationRuleKeySpelExpr="
						+ aggregationRuleKeySpelExpr + ", "
						: "")
				+ (columnsToAggregateValueSpelExpr != null ? "columnsToAggregateValueSpelExpr="
						+ columnsToAggregateValueSpelExpr + ", "
						: "")
				+ (whereCriteriaSpelExpr != null ? "whereCriteriaSpelExpr="
						+ whereCriteriaSpelExpr + ", " : "")
				+ (processingUnitId != null ? "processingUnitId="
						+ processingUnitId : "") + "]";
	}

}
