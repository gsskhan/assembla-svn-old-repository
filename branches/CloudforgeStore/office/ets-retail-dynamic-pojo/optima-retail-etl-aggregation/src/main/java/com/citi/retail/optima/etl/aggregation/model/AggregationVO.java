/**
 * 
 */
package com.citi.retail.optima.etl.aggregation.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

import com.citi.retail.optima.etl.aggregation.util.AggregationJsonResults;

/**
 * @author mc56120
 * 
 */
public class AggregationVO implements Serializable {
	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(AggregationVO.class);
	private static final long serialVersionUID = 1L;
	private Long jobInstanceId;
	private String aggregationType;
	private Map<String, List<String>> aggregationKey;
	private Map<String, List<Number>> aggregationValues;
	private java.sql.Date monthEndDate;
	private String insertSql;
	private Integer sysProcId;

	private Integer processingUnitId;

	/**
	 * @return the jobInstanceId
	 */
	public Long getJobInstanceId() {
		return jobInstanceId;
	}

	/**
	 * @param jobInstanceId
	 *            the jobInstanceId to set
	 */
	public void setJobInstanceId(Long jobInstanceId) {
		this.jobInstanceId = jobInstanceId;
	}

	/**
	 * @return the aggregationType
	 */
	public String getAggregationType() {
		return aggregationType;
	}

	/**
	 * @param aggregationType
	 *            the aggregationType to set
	 */
	public void setAggregationType(String aggregationType) {
		this.aggregationType = aggregationType;
	}

	/**
	 * @return the aggregationKey
	 */
	public Map<String, List<String>> getAggregationKey() {
		return aggregationKey;
	}

	/**
	 * @param aggregationKey
	 *            the aggregationKey to set
	 */
	public void setAggregationKey(Map<String, List<String>> aggregationKey) {
		this.aggregationKey = aggregationKey;
	}

	/**
	 * @return the aggregationValues
	 */
	public Map<String, List<Number>> getAggregationValues() {
		return aggregationValues;
	}

	/**
	 * @param aggregationValues
	 *            the aggregationValues to set
	 */
	public void setAggregationValues(Map<String, List<Number>> aggregationValues) {
		this.aggregationValues = aggregationValues;
	}

	/**
	 * @return the monthEndDate
	 */
	public java.sql.Date getMonthEndDate() {
		return monthEndDate;
	}

	/**
	 * @param monthEndDate
	 *            the monthEndDate to set
	 */
	public void setMonthEndDate(java.sql.Date monthEndDate) {
		this.monthEndDate = monthEndDate;
	}

	/**
	 * @return the insertSql
	 */
	public String getInsertSql() {
		return insertSql;
	}

	/**
	 * @param insertSql
	 *            the insertSql to set
	 */
	public void setInsertSql(String insertSql) {
		this.insertSql = insertSql;
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
	 * @return the sysProcId
	 */
	public Integer getSysProcId() {
		return sysProcId;
	}

	/**
	 * @param sysProcId the sysProcId to set
	 */
	public void setSysProcId(Integer sysProcId) {
		this.sysProcId = sysProcId;
	}
	
	

}
