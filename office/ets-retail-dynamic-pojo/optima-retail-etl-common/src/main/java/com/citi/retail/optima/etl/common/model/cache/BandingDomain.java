package com.citi.retail.optima.etl.common.model.cache;

public class BandingDomain {

	private String bandDesc;
	private Integer lowerBand;
	private Integer upperBand;
	private Integer keyId;

	public String getBandDesc() {
		return this.bandDesc;
	}

	public void setBandDesc(String bandDesc) {
		this.bandDesc = bandDesc;
	}

	public Integer getLowerBand() {
		return this.lowerBand;
	}

	public void setLowerBand(Integer lowerBand) {
		this.lowerBand = lowerBand;
	}

	public Integer getUpperBand() {
		return this.upperBand;
	}

	public void setUpperBand(Integer upperBand) {
		this.upperBand = upperBand;
	}

	public Integer getKeyId() {
		return this.keyId;
	}

	public void setKeyId(Integer keyId) {
		this.keyId = keyId;
	}

}
