package com.citi.retail.optima.etl.common.model.cache;

public class LlrConCommDomain {

	private Long consCommSpltId;
	private String srcConsCommSplt;
	private String trgtConsCommSplt;
	private Long sysProcId;

	public Long getConsCommSpltId() {
		return consCommSpltId;
	}

	public void setConsCommSpltId(Long consCommSpltId) {
		this.consCommSpltId = consCommSpltId;
	}

	public String getSrcConsCommSplt() {
		return srcConsCommSplt;
	}

	public void setSrcConsCommSplt(String srcConsCommSplt) {
		this.srcConsCommSplt = srcConsCommSplt;
	}

	public String getTrgtConsCommSplt() {
		return trgtConsCommSplt;
	}

	public void setTrgtConsCommSplt(String trgtConsCommSplt) {
		this.trgtConsCommSplt = trgtConsCommSplt;
	}

	public Long getSysProcId() {
		return sysProcId;
	}

	public void setSysProcId(Long sysProcId) {
		this.sysProcId = sysProcId;
	}

}
