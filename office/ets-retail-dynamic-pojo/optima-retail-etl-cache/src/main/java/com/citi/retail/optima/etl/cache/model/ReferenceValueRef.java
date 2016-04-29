package com.citi.retail.optima.etl.cache.model;

import com.citi.retail.optima.etl.common.model.cache.KeyRef;

public class ReferenceValueRef extends KeyRef {

	private String bandType;
	private String value;
	private String key;
	
	
	public String getBandType() {
		return bandType;
	}
	public void setBandType(String bandType) {
		this.bandType = bandType;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	
	
}
