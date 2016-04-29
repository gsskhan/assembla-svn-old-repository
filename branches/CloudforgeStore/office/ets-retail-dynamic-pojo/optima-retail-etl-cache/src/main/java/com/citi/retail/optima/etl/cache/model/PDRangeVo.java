package com.citi.retail.optima.etl.cache.model;

public class PDRangeVo {

	private Integer segVal;
	private Float lowerBandValue;
	private Float upperBandValue;
	private String bandDescr;

	public Integer getSegVal() {
		return this.segVal;
	}

	public void setSegVal(Integer segVal) {
		this.segVal = segVal;
	}

	public Float getLowerBandValue() {
		return this.lowerBandValue;
	}

	public void setLowerBandValue(Float lowerBandValue) {
		this.lowerBandValue = lowerBandValue;
	}

	public Float getUpperBandValue() {
		return this.upperBandValue;
	}

	public void setUpperBandValue(Float upperBandValue) {
		this.upperBandValue = upperBandValue;
	}

	public String getBandDescr() {
		return this.bandDescr;
	}

	public void setBandDescr(String bandDescr) {
		this.bandDescr = bandDescr;
	}

}
