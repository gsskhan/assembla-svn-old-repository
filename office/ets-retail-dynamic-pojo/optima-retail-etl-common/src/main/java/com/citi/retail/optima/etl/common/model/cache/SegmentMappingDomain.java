package com.citi.retail.optima.etl.common.model.cache;

public class SegmentMappingDomain {

	private String outputBandType;
	private Integer refBandId;
	private Integer bandId;

	public String getOutputBandType() {
		return this.outputBandType;
	}

	public void setOutputBandType(String outputBandType) {
		this.outputBandType = outputBandType;
	}

	public Integer getRefBandId() {
		return this.refBandId;
	}

	public void setRefBandId(Integer refBandId) {
		this.refBandId = refBandId;
	}

	public Integer getBandId() {
		return this.bandId;
	}

	public void setBandId(Integer bandId) {
		this.bandId = bandId;
	}

}
