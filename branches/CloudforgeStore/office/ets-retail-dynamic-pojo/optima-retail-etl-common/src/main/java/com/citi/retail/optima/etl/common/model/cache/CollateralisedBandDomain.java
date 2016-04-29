package com.citi.retail.optima.etl.common.model.cache;

/**
 * domain object for collateralised band
 * @author av51190
 *
 */
public class CollateralisedBandDomain {

	private Integer processingUnitId;
	private String segmentType;
	private String bandDesc;
	private Integer segCode;
	private String segVal;
	private Integer keyId;

	public Integer getKeyId() {
		return keyId;
	}

	public void setKeyId(Integer keyId) {
		this.keyId = keyId;
	}

	public Integer getProcessingUnitId() {
		return this.processingUnitId;
	}

	public void setProcessingUnitId(Integer processingUnitId) {
		this.processingUnitId = processingUnitId;
	}

	public String getSegmentType() {
		return this.segmentType;
	}

	public void setSegmentType(String segmentType) {
		this.segmentType = segmentType;
	}

	public String getBandDesc() {
		return this.bandDesc;
	}

	public void setBandDesc(String bandDesc) {
		this.bandDesc = bandDesc;
	}

	public Integer getSegCode() {
		return this.segCode;
	}

	public void setSegCode(Integer segCode) {
		this.segCode = segCode;
	}

	public String getSegVal() {
		return this.segVal;
	}

	public void setSegVal(String segVal) {
		this.segVal = segVal;
	}

}
