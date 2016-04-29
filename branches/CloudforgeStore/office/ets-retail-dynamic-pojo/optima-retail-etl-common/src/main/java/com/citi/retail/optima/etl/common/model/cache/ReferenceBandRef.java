package com.citi.retail.optima.etl.common.model.cache;


public class ReferenceBandRef extends KeyRef {

	private String bandType;
	private String bandDesc;
	private Integer lowerBand;
	private Integer upperBand;
	private Integer segCode;
	private String segVal;
	private Integer keyId;

	public String getBandType() {
		return this.bandType;
	}

	public void setBandType(String bandType) {
		this.bandType = bandType;
	}

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

	public Integer getSegCode() {
		return this.segCode;
	}

	public void setSegCode(Integer segCode) {
		this.segCode = segCode;
	}

	public String getSegVal() {
		return this.segVal;
	}

	public void setSegVal(String segVal) {
		this.segVal = segVal;
	}

	public Integer getKeyId() {
		return this.keyId;
	}

	public void setKeyId(Integer keyId) {
		this.keyId = keyId;
	}

}
