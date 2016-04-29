package com.citi.retail.optima.etl.batch.vo;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

import com.citi.retail.optima.etl.common.ETLBatchStatus;

/**
 * This value object maps to the details of all the partitions stored for a
 * particular job.
 * 
 * @author ns21567
 * 
 */
public class FeedPartitionDetailsVO {

	private int feedPartitionId;
	private int batchInstanceId;
	private ETLBatchStatus statusCode;
	private Date reportPeriod;
	private BigInteger minimumKey;
	private BigInteger maximumKey;
	private int readCount;
	private int processCount;
	private int exceptionCount;
	private Timestamp endTimeStamp;

	
	/**
	 * @return the feedPartitionId
	 */
	public int getFeedPartitionId() {
		return feedPartitionId;
	}

	/**
	 * @param feedPartitionId the feedPartitionId to set
	 */
	public void setFeedPartitionId(int feedPartitionId) {
		this.feedPartitionId = feedPartitionId;
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

	public ETLBatchStatus getStatusCode() {
		return this.statusCode;
	}

	public void setStatusCode(ETLBatchStatus statusCode) {
		this.statusCode = statusCode;
	}

	public Date getReportPeriod() {
		return this.reportPeriod;
	}

	public void setReportPeriod(Date reportPeriod) {
		this.reportPeriod = reportPeriod;
	}

	public BigInteger getMinimumKey() {
		return this.minimumKey;
	}

	public void setMinimumKey(BigInteger minimumKey) {
		this.minimumKey = minimumKey;
	}

	public BigInteger getMaximumKey() {
		return this.maximumKey;
	}

	public void setMaximumKey(BigInteger maximumKey) {
		this.maximumKey = maximumKey;
	}

	public int getReadCount() {
		return this.readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public int getProcessCount() {
		return this.processCount;
	}

	public void setProcessCount(int processCount) {
		this.processCount = processCount;
	}

	public int getExceptionCount() {
		return this.exceptionCount;
	}

	public void setExceptionCount(int exceptionCount) {
		this.exceptionCount = exceptionCount;
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

	@Override
	public boolean equals(Object object) {
		if (object instanceof FeedPartitionDetailsVO) {
			if (this.feedPartitionId == ((FeedPartitionDetailsVO) object).feedPartitionId
					&& this.batchInstanceId == ((FeedPartitionDetailsVO) object).batchInstanceId) {
				return true;
			} 
			return false;			
		} 
		return false;		
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + feedPartitionId;
		result = (prime * result) + batchInstanceId;		
		return result;
	}		

}
