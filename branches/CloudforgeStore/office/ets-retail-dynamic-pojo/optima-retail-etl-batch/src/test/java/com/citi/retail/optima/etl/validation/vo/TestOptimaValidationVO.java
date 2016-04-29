package com.citi.retail.optima.etl.validation.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * A Test VO, to check the Validation Framework Classes and implementation.
 */
public class TestOptimaValidationVO implements Serializable {

	private String fieldStr;
	private Integer fieldInt;
	private Date fieldDt;

	public String getFieldStr() {
		return fieldStr;
	}

	public void setFieldStr(String fieldStr) {
		this.fieldStr = fieldStr;
	}

	public Integer getFieldInt() {
		return fieldInt;
	}

	public void setFieldInt(Integer fieldInt) {
		this.fieldInt = fieldInt;
	}

	public Date getFieldDt() {
		return fieldDt;
	}

	public void setFieldDt(Date fieldDt) {
		this.fieldDt = fieldDt;
	}

}
