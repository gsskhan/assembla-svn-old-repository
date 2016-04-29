package com.citi.retail.optima.etl.cache.model;

public class ModelRangeVO {

	String creditBureau;
	String modelVersion;
	Integer maxValue;
	Integer minValue;

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

	public Integer getMaxValue() {
		return this.maxValue;
	}

	public void setMaxValue(Integer maxValue) {
		this.maxValue = maxValue;
	}

	public Integer getMinValue() {
		return this.minValue;
	}

	public void setMinValue(Integer minValue) {
		this.minValue = minValue;
	}

}
