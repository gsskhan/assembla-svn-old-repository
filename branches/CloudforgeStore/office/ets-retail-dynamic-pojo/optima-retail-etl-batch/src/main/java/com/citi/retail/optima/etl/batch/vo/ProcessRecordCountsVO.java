package com.citi.retail.optima.etl.batch.vo;

/**
 * Transfer Object to hold record counts under various categories for the
 * process named in process type code.
 * 
 * @author ms04453
 * 
 */
public class ProcessRecordCountsVO {

	private int readCount;
	private int processedCount;
	private int skippedCount;
	private String processTypeCode;
	private long feedPartitionId;
	private long batchInstanceId;

	/**
	 * @return the readCount
	 */
	public int getReadCount() {
		return this.readCount;
	}

	/**
	 * @param readCount
	 *            the readCount to set
	 */
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	/**
	 * @return the processedCount
	 */
	public int getProcessedCount() {
		return this.processedCount;
	}

	/**
	 * @param processedCount
	 *            the processedCount to set
	 */
	public void setProcessedCount(int processedCount) {
		this.processedCount = processedCount;
	}

	/**
	 * @return the skippedCount
	 */
	public int getSkippedCount() {
		return this.skippedCount;
	}

	/**
	 * @param skippedCount
	 *            the skippedCount to set
	 */
	public void setSkippedCount(int skippedCount) {
		this.skippedCount = skippedCount;
	}

	/**
	 * @return the processTypeCode
	 */
	public String getProcessTypeCode() {
		return this.processTypeCode;
	}

	/**
	 * @param processTypeCode
	 *            the processTypeCode to set
	 */
	public void setProcessTypeCode(String processTypeCode) {
		this.processTypeCode = processTypeCode;
	}

	/**
	 * @return the feedPartitionId
	 */
	public long getFeedPartitionId() {
		return this.feedPartitionId;
	}

	/**
	 * @param feedPartitionId
	 *            the feedPartitionId to set
	 */
	public void setFeedPartitionId(long feedPartitionId) {
		this.feedPartitionId = feedPartitionId;
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof ProcessRecordCountsVO) {
			if (this.feedPartitionId == ((ProcessRecordCountsVO) object).feedPartitionId
					&& this.processTypeCode == ((ProcessRecordCountsVO) object).processTypeCode) {
				return true;
			} 
			return false;			
		}
		return false;
	}

	/**
	 * @return the batchInstanceId
	 */
	public long getBatchInstanceId() {
		return this.batchInstanceId;
	}

	/**
	 * @param batchInstanceId
	 *            the batchInstanceId to set
	 */
	public void setBatchInstanceId(long batchInstanceId) {
		this.batchInstanceId = batchInstanceId;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((Long)feedPartitionId).intValue();
		result = (prime * result) + (processTypeCode==null?0:processTypeCode.hashCode());		
		return result;
	}	

}
