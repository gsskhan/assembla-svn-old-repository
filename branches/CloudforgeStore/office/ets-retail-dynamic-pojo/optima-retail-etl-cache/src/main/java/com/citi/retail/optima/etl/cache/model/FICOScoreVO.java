package com.citi.retail.optima.etl.cache.model;

import java.util.Map;

public class FICOScoreVO {

	String creditBureau;
	String modelVersion;
	Integer ficoScore;
	String scoreDesc;
	Boolean includeFlag;
	Boolean splScoreFlag;
	String reportingPeriod;
	Map<String, Double> productPDMap;

	public String getReportingPeriod() {
		return this.reportingPeriod;
	}

	public void setReportingPeriod(String reportingPeriod) {
		this.reportingPeriod = reportingPeriod;
	}

	public String getCreditBureau() {
		return this.creditBureau;
	}

	public void setCreditBureau(String creditBureau) {
		this.creditBureau = creditBureau;
	}

	public String getModelVersion() {
		return this.modelVersion;
	}

	public void setModelVersion(String modelVersion) {
		this.modelVersion = modelVersion;
	}

	public Integer getFicoScore() {
		return this.ficoScore;
	}

	public void setFicoScore(Integer ficoScore) {
		this.ficoScore = ficoScore;
	}

	public String getScoreDesc() {
		return this.scoreDesc;
	}

	public void setScoreDesc(String scoreDesc) {
		this.scoreDesc = scoreDesc;
	}

	public Boolean getIncludeFlag() {
		return this.includeFlag;
	}

	public void setIncludeFlag(Boolean includeFlag) {
		this.includeFlag = includeFlag;
	}

	public Boolean getSplScoreFlag() {
		return this.splScoreFlag;
	}

	public void setSplScoreFlag(Boolean splScoreFlag) {
		this.splScoreFlag = splScoreFlag;
	}

	public Map<String, Double> getProductPDMap() {
		return this.productPDMap;
	}

	public void setProductPDMap(Map<String, Double> productPDMap) {
		this.productPDMap = productPDMap;
	}

}
