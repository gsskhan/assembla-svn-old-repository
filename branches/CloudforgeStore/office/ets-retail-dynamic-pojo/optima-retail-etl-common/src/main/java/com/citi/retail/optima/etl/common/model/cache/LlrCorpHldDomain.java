package com.citi.retail.optima.etl.common.model.cache;

public class LlrCorpHldDomain {

	private Long corpHoldId;
	private String srcCorpHoldCd;
	private String trgtCorpHold;
	private Long sysProcId;

	public Long getCorpHoldId() {
		return corpHoldId;
	}

	public void setCorpHoldId(Long corpHoldId) {
		this.corpHoldId = corpHoldId;
	}

	public String getSrcCorpHoldCd() {
		return srcCorpHoldCd;
	}

	public void setSrcCorpHoldCd(String srcCorpHoldCd) {
		this.srcCorpHoldCd = srcCorpHoldCd;
	}

	public String getTrgtCorpHold() {
		return trgtCorpHold;
	}

	public void setTrgtCorpHold(String trgtCorpHold) {
		this.trgtCorpHold = trgtCorpHold;
	}

	public Long getSysProcId() {
		return sysProcId;
	}

	public void setSysProcId(Long sysProcId) {
		this.sysProcId = sysProcId;
	}

}
