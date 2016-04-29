package com.citi.retail.optima.etl.common.model.cache;

public class FicoBandDomain extends BandingDomain {

	private Integer processingUnitId;
	private String segmentType;
	private String bandDesc;
	private Integer segCode;
	private String segVal;

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

	@Override
	public String getBandDesc() {
		return this.bandDesc;
	}

	@Override
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
