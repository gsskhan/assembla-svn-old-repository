package com.citi.retail.optima.etl.common.model.cache;

public class SourceRegionDomain {

	private Long rgnId;
	private String rgnNm;
	private String sourceDataVal;
	private String trgtAttribute;
	private String trgtAttributeVal;
	private Long sysProcId;

	public Long getRgnId() {
		return rgnId;
	}

	public void setRgnId(Long rgnId) {
		this.rgnId = rgnId;
	}

	public String getRgnNm() {
		return rgnNm;
	}

	public void setRgnNm(String rgnNm) {
		this.rgnNm = rgnNm;
	}

	public String getSourceDataVal() {
		return sourceDataVal;
	}

	public void setSourceDataVal(String sourceDataVal) {
		this.sourceDataVal = sourceDataVal;
	}

	public String getTrgtAttribute() {
		return trgtAttribute;
	}

	public void setTrgtAttribute(String trgtAttribute) {
		this.trgtAttribute = trgtAttribute;
	}

	public String getTrgtAttributeVal() {
		return trgtAttributeVal;
	}

	public void setTrgtAttributeVal(String trgtAttributeVal) {
		this.trgtAttributeVal = trgtAttributeVal;
	}

	public Long getSysProcId() {
		return sysProcId;
	}

	public void setSysProcId(Long sysProcId) {
		this.sysProcId = sysProcId;
	}

}
