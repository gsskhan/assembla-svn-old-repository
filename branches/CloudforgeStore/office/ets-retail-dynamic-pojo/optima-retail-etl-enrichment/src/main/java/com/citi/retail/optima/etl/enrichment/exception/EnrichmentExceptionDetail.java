package com.citi.retail.optima.etl.enrichment.exception;

import java.io.Serializable;

public class EnrichmentExceptionDetail implements Serializable {

	private static final long serialVersionUID = -2119081817044285817L;

	private String rule;
	private String stackTrace;
	private String attributeName;
	private Integer attributeId;
	private String userErrorMessage;
	private String exceptionMessage;
	
	private ExceptionType exceptionType;

	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}
	
	public String getStackTrace() {
		return stackTrace;
	}
	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}
	public String getAttributeName() {
		return attributeName;
	}
	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}
	public Integer getAttributeId() {
		return attributeId;
	}
	public void setAttributeId(Integer attributeId) {
		this.attributeId = attributeId;
	}
	public String getUserErrorMessage() {
		return userErrorMessage;
	}
	public void setUserErrorMessage(String userErrorMessage) {
		this.userErrorMessage = userErrorMessage;
	}
	public String getExceptionMessage() {
		return exceptionMessage;
	}
	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
	public ExceptionType getExceptionType() {
		return exceptionType;
	}
	public void setExceptionType(ExceptionType exceptionType) {
		this.exceptionType = exceptionType;
	}

	
}
