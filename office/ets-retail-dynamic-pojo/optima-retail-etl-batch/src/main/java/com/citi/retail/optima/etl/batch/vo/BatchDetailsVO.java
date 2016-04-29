package com.citi.retail.optima.etl.batch.vo;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * The Value Object class maps to the job details and job instance details table
 * in the database.
 * 
 * @author ns21567
 * 
 */
public class BatchDetailsVO {

	private int batchInstanceId;
	private int batchId;
	private int threadCount;
	private Date reportPeriod;
	private int rptPeriodId;
	private int year;
	private int qtr;
	private int month;
	private String batchName;
	private String portfolioId;
	private String productName;
	private List<Integer> processingUnitIdList;
	private int threshold;
	private int rowCount;
	private Long originalMessageId;
	private String statusCode;
	private int exceptionCount;
	private int processCount;
	private Timestamp endTimeStamp;
	private Timestamp eventTimestamp;
	private Long fileId;
	private String fileType;
	private int sysProcId;
	
	public String ProdListString;
	

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getQtr() {
		return qtr;
	}

	public void setQtr(int qtr) {
		this.qtr = qtr;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public Long getFileId() {
		return fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}

	/**
	 * @return the prodListString
	 */
	public String getProdListString() {
		return this.ProdListString;
	}

	/**
	 * @param prodListString
	 *            the prodListString to set
	 */
	public void setProdListString(String prodListString) {
		this.ProdListString = prodListString;
	}

	/**
	 * @return the eventTimestamp
	 */
	public Timestamp getEventTimestamp() {
		return this.eventTimestamp;
	}

	/**
	 * @param eventTimestamp
	 *            the eventTimestamp to set
	 */
	public void setEventTimestamp(Timestamp eventTimestamp) {
		this.eventTimestamp = eventTimestamp;
	}

	/**
	 * @return the batchInstanceId
	 */
	public int getBatchInstanceId() {
		return this.batchInstanceId;
	}

	/**
	 * @param batchInstanceId
	 *            the batchInstanceId to set
	 */
	public void setBatchInstanceId(int batchInstanceId) {
		this.batchInstanceId = batchInstanceId;
	}

	/**
	 * @return the batchId
	 */
	public int getBatchId() {
		return this.batchId;
	}

	/**
	 * @param batchId
	 *            the batchId to set
	 */
	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	/**
	 * @return the threadCount
	 */
	public int getThreadCount() {
		return this.threadCount;
	}

	/**
	 * @param threadCount
	 *            the threadCount to set
	 */
	public void setThreadCount(int threadCount) {
		this.threadCount = threadCount;
	}

	/**
	 * @return the reportPeriod
	 */
	public Date getReportPeriod() {
		return this.reportPeriod;
	}

	/**
	 * @param reportPeriod
	 *            the reportPeriod to set
	 */
	public void setReportPeriod(Date reportPeriod) {
		this.reportPeriod = reportPeriod;
	}

	/**
	 * @return the batchName
	 */
	public String getBatchName() {
		return this.batchName;
	}

	/**
	 * @param batchName
	 *            the batchName to set
	 */
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	/**
	 * @return the portfolioId
	 */
	public String getPortfolioId() {
		return this.portfolioId;
	}

	/**
	 * @param portfolioId
	 *            the portfolioId to set
	 */
	public void setPortfolioId(String portfolioId) {
		this.portfolioId = portfolioId;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return this.productName;
	}

	/**
	 * @param productName
	 *            the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the processingUnitIdList
	 */
	public List<Integer> getProcessingUnitIdList() {
		return this.processingUnitIdList;
	}

	/**
	 * @param processingUnitIdList
	 *            the processingUnitIdList to set
	 */
	public void setProcessingUnitIdList(List<Integer> processingUnitIdList) {
		this.processingUnitIdList = processingUnitIdList;
	}

	/**
	 * @return the threshold
	 */
	public int getThreshold() {
		return this.threshold;
	}

	/**
	 * @param threshold
	 *            the threshold to set
	 */
	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}

	/**
	 * @return the rowCount
	 */
	public int getRowCount() {
		return this.rowCount;
	}

	/**
	 * @param rowCount
	 *            the rowCount to set
	 */
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	/**
	 * @return the originalMessageId
	 */
	public Long getOriginalMessageId() {
		return this.originalMessageId;
	}

	/**
	 * @param originalMessageId
	 *            the originalMessageId to set
	 */
	public void setOriginalMessageId(Long originalMessageId) {
		this.originalMessageId = originalMessageId;
	}

	/**
	 * @return the statusCode
	 */
	public String getStatusCode() {
		return this.statusCode;
	}

	/**
	 * @param statusCode
	 *            the statusCode to set
	 */
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * @return the exceptionCount
	 */
	public int getExceptionCount() {
		return this.exceptionCount;
	}

	/**
	 * @param exceptionCount
	 *            the exceptionCount to set
	 */
	public void setExceptionCount(int exceptionCount) {
		this.exceptionCount = exceptionCount;
	}

	/**
	 * @return the processCount
	 */
	public int getProcessCount() {
		return this.processCount;
	}

	/**
	 * @param processCount
	 *            the processCount to set
	 */
	public void setProcessCount(int processCount) {
		this.processCount = processCount;
	}

	/**
	 * @return the endTimeStamp
	 */
	public Timestamp getEndTimeStamp() {
		return this.endTimeStamp;
	}

	/**
	 * @param endTimeStamp
	 *            the endTimeStamp to set
	 */
	public void setEndTimeStamp(Timestamp endTimeStamp) {
		this.endTimeStamp = endTimeStamp;
	}

	/**
	 * @return the fileType
	 */
	public String getFileType() {
		return fileType;
	}

	/**
	 * @param fileType the fileType to set
	 */
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public int getRptPeriodId() {
		return rptPeriodId;
	}

	public void setRptPeriodId(int rptPeriodId) {
		this.rptPeriodId = rptPeriodId;
	}

	public int getSysProcId() {
		return sysProcId;
	}

	public void setSysProcId(int sysProcId) {
		this.sysProcId = sysProcId;
	}
	
	@Override
	public boolean equals(Object object) {
		if (object instanceof BatchDetailsVO) {
			if (this.batchInstanceId == ((BatchDetailsVO) object).batchInstanceId) {
				return true;
			}
			return false;			
		}
		return false;		
	}

	public String processingUnitListString() {
		StringBuilder processingUnitString = new StringBuilder();
		for (Integer processingUnitId : this.processingUnitIdList) {
			processingUnitString.append(processingUnitId.toString() + ",");
		}
		processingUnitString.deleteCharAt(processingUnitString.length() - 1);
		return processingUnitString.toString();
	}

	public String convertProductListString(List<String> sourceProductList) {		
		if ((sourceProductList == null || sourceProductList.isEmpty())) {
			return null;
		}		
		StringBuilder productString = new StringBuilder();
		for (String prod : sourceProductList) {
			productString.append(prod + "','");
		}
		productString.deleteCharAt(productString.length() - 1);
		productString.deleteCharAt(productString.length() - 1);
		return "'" + productString.toString();
	}

	@Override
	public String toString() {

		return "batchInstanceId:" + this.batchInstanceId + "|batchId:"
				+ this.batchId + "threadCount:" + this.threadCount
				+ "reportPeriod:" + this.reportPeriod + "|batchName:"
				+ this.batchName + "|portfolioId:" + this.portfolioId
				+ "|productName:" + this.productName + "|processingUnitIdList:"
				+ this.processingUnitIdList + "threshold:" + this.threshold
				+ "|rowCount:" + this.rowCount + "|originalMessageId:"
				+ this.originalMessageId + "|statusCode:" + this.statusCode
				+ "|exceptionCount:" + this.exceptionCount + "|processCount:"
				+ this.processCount + "|endTimeStamp:" + this.endTimeStamp
				+ "|eventTimestamp:" + this.eventTimestamp + "|ProdListString:"
				+ this.ProdListString;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + batchInstanceId;
				
		return result;
	}	

}
