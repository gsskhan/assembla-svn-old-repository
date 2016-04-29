package com.citi.retail.optima.etl.common.model.cache;

public class SourceBUDomain {

	// BU.BSUNIT_ID, LKUP.SRC_DATA_VAL, LKUP.TRGT_ATTR, LKUP.TRGT_ATTR_VAL

	private Long bsUnitId;
	private String srcBUVal;
	private String trgtBUVal;
	private String trgtAttr;
	private Long sysProcId;

	public Long getSysProcId() {
		return sysProcId;
	}

	public void setSysProcId(Long sysProcId) {
		this.sysProcId = sysProcId;
	}

	public Long getBsUnitId() {
		return bsUnitId;
	}

	public void setBsUnitId(Long bsUnitId) {
		this.bsUnitId = bsUnitId;
	}

	public String getSrcBUVal() {
		return srcBUVal;
	}

	public void setSrcBUVal(String srcBUVal) {
		this.srcBUVal = srcBUVal;
	}

	public String getTrgtBUVal() {
		return trgtBUVal;
	}

	public void setTrgtBUVal(String trgtBUVal) {
		this.trgtBUVal = trgtBUVal;
	}

	public String getTrgtAttr() {
		return trgtAttr;
	}

	public void setTrgtAttr(String trgtAttr) {
		this.trgtAttr = trgtAttr;
	}

}
