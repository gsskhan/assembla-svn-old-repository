package com.citi.retail.optima.etl.batch.vo;

import java.sql.Timestamp;

/**
 * Maps to the message log table in the database
 * 
 * @author ns21567
 * 
 */
public class MessageLogVO {

	private int originalMessageId;
	private Timestamp eventTimestamp;
	private Long fileId;
	private String fileType;

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

	public int getOriginalMessageId() {
		return this.originalMessageId;
	}

	public void setOriginalMessageId(int originalMessageId) {
		this.originalMessageId = originalMessageId;
	}

	/**
	 * @return the fileId
	 */
	public Long getFileId() {
		return fileId;
	}

	/**
	 * @param fileId the fileId to set
	 */
	public void setFileId(Long fileId) {
		this.fileId = fileId;
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

}
