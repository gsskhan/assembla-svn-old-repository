package com.citi.retail.optima.etl.common.model.cache;

public class LlrLVDomain {

	private Long lvId;
	private String srcLvName;
	private String trgtLvName;
	private Long sysProcId;

	public Long getLvId() {
		return lvId;
	}

	public void setLvId(Long lvId) {
		this.lvId = lvId;
	}

	public String getSrcLvName() {
		return srcLvName;
	}

	public void setSrcLvName(String srcLvName) {
		this.srcLvName = srcLvName;
	}

	public String getTrgtLvName() {
		return trgtLvName;
	}

	public void setTrgtLvName(String trgtLvName) {
		this.trgtLvName = trgtLvName;
	}

	public Long getSysProcId() {
		return sysProcId;
	}

	public void setSysProcId(Long sysProcId) {
		this.sysProcId = sysProcId;
	}

}
