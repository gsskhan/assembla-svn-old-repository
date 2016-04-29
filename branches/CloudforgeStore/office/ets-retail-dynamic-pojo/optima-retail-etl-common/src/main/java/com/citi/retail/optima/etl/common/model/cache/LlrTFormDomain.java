package com.citi.retail.optima.etl.common.model.cache;

import java.util.Date;

public class LlrTFormDomain {

	private Long srcSysId;
	private String srcDataVal;
	private String trgtAttr;
	private String trgtAttrVal;
	private String effSts;
	private Date effDt;
	private Date endDt;
	private String crteUserId;
	private Date crteDt;
	private String lstUpdUserId;
	private Date lstUpdDt;

	public Long getSrcSysId() {
		return srcSysId;
	}

	public void setSrcSysId(Long srcSysId) {
		this.srcSysId = srcSysId;
	}

	public String getSrcDataVal() {
		return srcDataVal;
	}

	public void setSrcDataVal(String srcDataVal) {
		this.srcDataVal = srcDataVal;
	}

	public String getTrgtAttr() {
		return trgtAttr;
	}

	public void setTrgtAttr(String trgtAttr) {
		this.trgtAttr = trgtAttr;
	}

	public String getTrgtAttrVal() {
		return trgtAttrVal;
	}

	public void setTrgtAttrVal(String trgtAttrVal) {
		this.trgtAttrVal = trgtAttrVal;
	}

	public String getEffSts() {
		return effSts;
	}

	public void setEffSts(String effSts) {
		this.effSts = effSts;
	}

	public Date getEffDt() {
		return effDt;
	}

	public void setEffDt(Date effDt) {
		this.effDt = effDt;
	}

	public Date getEndDt() {
		return endDt;
	}

	public void setEndDt(Date endDt) {
		this.endDt = endDt;
	}

	public String getCrteUserId() {
		return crteUserId;
	}

	public void setCrteUserId(String crteUserId) {
		this.crteUserId = crteUserId;
	}

	public Date getCrteDt() {
		return crteDt;
	}

	public void setCrteDt(Date crteDt) {
		this.crteDt = crteDt;
	}

	public String getLstUpdUserId() {
		return lstUpdUserId;
	}

	public void setLstUpdUserId(String lstUpdUserId) {
		this.lstUpdUserId = lstUpdUserId;
	}

	public Date getLstUpdDt() {
		return lstUpdDt;
	}

	public void setLstUpdDt(Date lstUpdDt) {
		this.lstUpdDt = lstUpdDt;
	}

}
