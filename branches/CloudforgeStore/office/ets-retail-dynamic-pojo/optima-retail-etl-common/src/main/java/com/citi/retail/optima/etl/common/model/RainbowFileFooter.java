package com.citi.retail.optima.etl.common.model;

/**
 * 
 * @author TJ
 *
 */
public class RainbowFileFooter {
	
	private Long writeCount;

	private Long aggregatedHashValue;

	private String hashFileType;

	private String hashField;

	private String outputFileResourceName;

	public Long getWriteCount() {
		return writeCount;
	}

	public void setWriteCount(Long writeCount) {
		this.writeCount = writeCount;
	}

	public Long getAggregatedHashValue() {
		return aggregatedHashValue;
	}

	public void setAggregatedHashValue(Long aggregatedHashValue) {
		this.aggregatedHashValue = aggregatedHashValue;
	}

	public String getHashFileType() {
		return hashFileType;
	}

	public void setHashFileType(String hashFileType) {
		this.hashFileType = hashFileType;
	}

	public String getHashField() {
		return hashField;
	}

	public void setHashField(String hashField) {
		this.hashField = hashField;
	}

	public String getOutputFileResourceName() {
		return outputFileResourceName;
	}

	public void setOutputFileResourceName(String outputFileResourceName) {
		this.outputFileResourceName = outputFileResourceName;
	}

}
