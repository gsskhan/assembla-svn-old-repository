package com.citi.retail.optima.etl.integration.test.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 * @author hs73849
 * 
 */
public class MessageLog implements Serializable {

	private static final long serialVersionUID = -3577526591254238528L;

	private Long messageId;
	private BigInteger orgMessageId;
	private String eventType;
	private String reqtrId;
	private String message;
	private Date receivedTime;
	private String messageTypeId;
	private BigInteger priority;
	private BigInteger rowCount;
	private String reptPeriod;
	private BigInteger jobInstId;
	private String portfolioID;
	private String countryCode;
	private String versionID;
	private String tableName;
	private String approverID;
	private List<String> productList;

	/**
	 * @return the tableName
	 */
	public String getTableName() {
		return this.tableName;
	}

	/**
	 * @param tableName
	 *            the tableName to set
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * @return the messageId
	 */
	public Long getMessageId() {
		return this.messageId;
	}

	/**
	 * @param messageId
	 *            the messageId to set
	 */
	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

	/**
	 * @return the orgMessageId
	 */
	public BigInteger getOrgMessageId() {
		return this.orgMessageId;
	}

	/**
	 * @param orgMessageId
	 *            the orgMessageId to set
	 */
	public void setOrgMessageId(BigInteger orgMessageId) {
		this.orgMessageId = orgMessageId;
	}

	/**
	 * @return the eventType
	 */
	public String getEventType() {
		return this.eventType;
	}

	/**
	 * @param eventType
	 *            the eventType to set
	 */
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	/**
	 * @return the reqtrId
	 */
	public String getReqtrId() {
		return this.reqtrId;
	}

	/**
	 * @param reqtrId
	 *            the reqtrId to set
	 */
	public void setReqtrId(String reqtrId) {
		this.reqtrId = reqtrId;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return this.message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the receivedTime
	 */
	public Date getReceivedTime() {
		return this.receivedTime;
	}

	/**
	 * @param receivedTime
	 *            the receivedTime to set
	 */
	public void setReceivedTime(Date receivedTime) {
		this.receivedTime = receivedTime;
	}

	/**
	 * @return the messageTypeId
	 */
	public String getMessageTypeId() {
		return this.messageTypeId;
	}

	/**
	 * @param messageTypeId
	 *            the messageTypeId to set
	 */
	public void setMessageTypeId(String messageTypeId) {
		this.messageTypeId = messageTypeId;
	}

	/**
	 * @return the priority
	 */
	public BigInteger getPriority() {
		return this.priority;
	}

	/**
	 * @param priority
	 *            the priority to set
	 */
	public void setPriority(BigInteger priority) {
		this.priority = priority;
	}

	/**
	 * @return the rowCount
	 */
	public BigInteger getRowCount() {
		return this.rowCount;
	}

	/**
	 * @param rowCount
	 *            the rowCount to set
	 */
	public void setRowCount(BigInteger rowCount) {
		this.rowCount = rowCount;
	}

	/**
	 * @return the reptPeriod
	 */
	public String getReptPeriod() {
		return this.reptPeriod;
	}

	/**
	 * @param reptPeriod
	 *            the reptPeriod to set
	 */
	public void setReptPeriod(String reptPeriod) {
		this.reptPeriod = reptPeriod;
	}

	/**
	 * @return the jobInstId
	 */
	public BigInteger getJobInstId() {
		return this.jobInstId;
	}

	/**
	 * @param jobInstId
	 *            the jobInstId to set
	 */
	public void setJobInstId(BigInteger jobInstId) {
		this.jobInstId = jobInstId;
	}

	/**
	 * @return the portfolioID
	 */
	public String getPortfolioID() {
		return this.portfolioID;
	}

	/**
	 * @param portfolioID
	 *            the portfolioID to set
	 */
	public void setPortfolioID(String portfolioID) {
		this.portfolioID = portfolioID;
	}

	/**
	 * @return the versionID
	 */
	public String getVersionID() {
		return this.versionID;
	}

	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return this.countryCode;
	}

	/**
	 * @param countryCode
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * @param versionID
	 *            the versionID to set
	 */
	public void setVersionID(String versionID) {
		this.versionID = versionID;
	}

	/**
	 * @return the approverID
	 */
	public String getApproverID() {
		return this.approverID;
	}

	/**
	 * @param approverID
	 *            the approverID to set
	 */
	public void setApproverID(String approverID) {
		this.approverID = approverID;
	}

	/**
	 * @return the productList
	 */
	public List<String> getProductList() {
		return this.productList;
	}

	/**
	 * @param productList
	 *            the productList to set
	 */
	public void setProductList(List<String> productList) {
		this.productList = productList;
	}
}
