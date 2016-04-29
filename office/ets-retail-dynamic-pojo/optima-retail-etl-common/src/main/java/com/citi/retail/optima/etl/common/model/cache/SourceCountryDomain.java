package com.citi.retail.optima.etl.common.model.cache;

public class SourceCountryDomain {

	private String srcCntryCd;
	private String trgtCntryCd;
	private String trgtAttribute;
	private Long sourceSysId;

	public String getSrcCntryCd() {
		return srcCntryCd;
	}

	public void setSrcCntryCd(String srcCntryCd) {
		this.srcCntryCd = srcCntryCd;
	}

	public String getTrgtCntryCd() {
		return trgtCntryCd;
	}

	public void setTrgtCntryCd(String trgtCntryCd) {
		this.trgtCntryCd = trgtCntryCd;
	}

	public String getTrgtAttribute() {
		return trgtAttribute;
	}

	public void setTrgtAttribute(String trgtAttribute) {
		this.trgtAttribute = trgtAttribute;
	}

	public Long getSourceSysId() {
		return sourceSysId;
	}

	public void setSourceSysId(Long sourceSysId) {
		this.sourceSysId = sourceSysId;
	}

}
