/**
 * 
 */
package com.citi.retail.optima.etl.common.model;

import java.io.Serializable;

/**
 * This class holds the aggergation type details.
 * 
 * @author mc56120
 * 
 */
public class AccountTraceabilityInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long aggregationTypeId;
	private String aggregationTypeName;
	private Long batchInstanceId;
	private String accountNumber;
	private Integer processingUnitId;

	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber
	 *            the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the aggregationTypeId
	 */
	public Long getAggregationTypeId() {
		return aggregationTypeId;
	}

	/**
	 * @param aggregationTypeId
	 *            the aggregationTypeId to set
	 */
	public void setAggregationTypeId(Long aggregationTypeId) {
		this.aggregationTypeId = aggregationTypeId;
	}

	/**
	 * @return the aggregationTypeName
	 */
	public String getAggregationTypeName() {
		return aggregationTypeName;
	}

	/**
	 * @param aggregationTypeName
	 *            the aggregationTypeName to set
	 */
	public void setAggregationTypeName(String aggregationTypeName) {
		this.aggregationTypeName = aggregationTypeName;
	}

	/**
	 * @return the batchInstanceId
	 */
	public Long getBatchInstanceId() {
		return batchInstanceId;
	}

	/**
	 * @param batchInstanceId
	 *            the batchInstanceId to set
	 */
	public void setBatchInstanceId(Long batchInstanceId) {
		this.batchInstanceId = batchInstanceId;
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

}
