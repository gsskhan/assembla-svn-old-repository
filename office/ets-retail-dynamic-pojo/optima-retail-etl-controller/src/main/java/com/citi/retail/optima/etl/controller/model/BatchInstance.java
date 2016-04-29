package com.citi.retail.optima.etl.controller.model;

import java.util.Date;

/**
 * @author hs73849
 * 
 */
public class BatchInstance {

	private Long batchId;
	private Long msdId;
	private String portfolioId;
	private Long batchInstanceId;
	private Long jobTypeId;
	private Integer threadCount;
	private Integer waitingStatus;
	private Integer currentPriority;
	private String status;
	private Date requestDate;
	private Long jobId;

	/**
	 * @return the batchId
	 */
	public Long getBatchId() {
		return batchId;
	}

	/**
	 * @param batchId
	 *            the batchId to set
	 */
	public void setBatchId(Long batchId) {
		this.batchId = batchId;
	}

	/**
	 * @return the msdId
	 */
	public Long getMsdId() {
		return msdId;
	}

	/**
	 * @param msdId
	 *            the msdId to set
	 */
	public void setMsdId(Long msdId) {
		this.msdId = msdId;
	}

	/**
	 * @return the portfolioId
	 */
	public String getPortfolioId() {
		return portfolioId;
	}

	/**
	 * @param portfolioId
	 *            the portfolioId to set
	 */
	public void setPortfolioId(String portfolioId) {
		this.portfolioId = portfolioId;
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
	 * @return the jobTypeId
	 */
	public Long getJobTypeId() {
		return jobTypeId;
	}

	/**
	 * @param jobTypeId
	 *            the jobTypeId to set
	 */
	public void setJobTypeId(Long jobTypeId) {
		this.jobTypeId = jobTypeId;
	}

	/**
	 * @return the threadCount
	 */
	public Integer getThreadCount() {
		return threadCount;
	}

	/**
	 * @param threadCount
	 *            the threadCount to set
	 */
	public void setThreadCount(Integer threadCount) {
		this.threadCount = threadCount;
	}

	/**
	 * @return the waitingStatus
	 */
	public Integer getWaitingStatus() {
		return waitingStatus;
	}

	/**
	 * @param waitingStatus
	 *            the waitingStatus to set
	 */
	public void setWaitingStatus(Integer waitingStatus) {
		this.waitingStatus = waitingStatus;
	}

	/**
	 * @return the currentPriority
	 */
	public Integer getCurrentPriority() {
		return currentPriority;
	}

	/**
	 * @param currentPriority
	 *            the currentPriority to set
	 */
	public void setCurrentPriority(Integer currentPriority) {
		this.currentPriority = currentPriority;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the requestDate
	 */
	public Date getRequestDate() {
		return requestDate;
	}

	/**
	 * @param requestDate
	 *            the requestDate to set
	 */
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

}
