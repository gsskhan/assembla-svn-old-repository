package com.citi.retail.optima.etl.validation.exception;

import java.io.Serializable;

public class FieldError implements Serializable {
		
	private static final long serialVersionUID = -6190254720101221130L;
	
	private static final String COMMA = " , ";
	private String rule;
	private Integer ruleId;
	private String stackTrace;
	private String attributeName;
	private Integer attributeId;
	private String userErrorMessage;
	private String exceptionMessage;
	private ExceptionType exceptionType;

	public ExceptionType getExceptionType() {
		return exceptionType;
	}

	public void setExceptionType(ExceptionType exceptionType) {
		this.exceptionType = exceptionType;
	}

	public Integer getRuleId() {
		return ruleId;
	}

	public void setRuleId(Integer ruleId) {
		this.ruleId = ruleId;
	}

	public Integer getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(Integer attributeId) {
		this.attributeId = attributeId;
	}


	/**
	 * @return the userErrorMessage
	 */
	public String getUserErrorMessage() {
		return userErrorMessage;
	}

	/**
	 * @param userErrorMessage
	 *            the userErrorMessage to set
	 */
	public void setUserErrorMessage(String userErrorMessage) {
		this.userErrorMessage = userErrorMessage;
	}

	/**
	 * @return the rule
	 */
	public String getRule() {
		return rule;
	}

	/**
	 * @param rule
	 *            the rule to set
	 */
	public void setRule(String rule) {
		this.rule = rule;
	}

	/**
	 * @return the stackTrace
	 */
	public String getStackTrace() {
		return stackTrace;
	}

	/**
	 * @param stackTrace
	 *            the stackTrace to set
	 */
	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}

	/**
	 * @return the attributeName
	 */
	public String getAttributeName() {
		return attributeName;
	}

	/**
	 * @param attributeName
	 *            the attributeName to set
	 */
	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	/**
	 * @return the exceptionMessage
	 */
	public String getExceptionMessage() {
		return exceptionMessage;
	}

	/**
	 * @param exceptionMessage
	 *            the exceptionMessage to set
	 */
	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
		

	/*
	 * (non-Javadoc) To String Override for Converting the Object to JSON String
	 * Format
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		
		toStringByParam(builder, "\"exceptionMessage\" : \"", exceptionMessage,
				"\"");
		toStringByParam(builder, "\"rule\" : \"", rule, "\"");
		toStringByParam(builder, "\"attributeName\" : \"", attributeName, "\"");
		toStringByParam(builder, "\"stackTrace\" : \"", stackTrace, "\"");
		builder.append("}");
		return builder.toString();
	}

	private void toStringByParam(StringBuilder builder, String paramCaption,
			Object param, String paramSuffix) {
		if (param != null) {
			if (builder.length() > 1) {
				builder.append(COMMA);
			}
			builder.append(paramCaption).append(param);
			if (paramSuffix != null && !"".equals(paramSuffix)) {
				builder.append(paramSuffix);
			}
		}
	}
}
