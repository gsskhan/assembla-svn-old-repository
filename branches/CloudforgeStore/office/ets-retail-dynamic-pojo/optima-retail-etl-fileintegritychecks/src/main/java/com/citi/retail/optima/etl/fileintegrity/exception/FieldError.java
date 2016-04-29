package com.citi.retail.optima.etl.fileintegrity.exception;

import java.io.Serializable;
import java.util.Map;

public class FieldError implements Serializable {

	/**
	 * 
	 */
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
	private String reportedValues;
	private Map<String, String> otherAttributesMap;

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

	public String getReportedValues() {
		return reportedValues;
	}

	public void setReportedValues(String reportedValues) {
		this.reportedValues = reportedValues;
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

	/**
	 * @return the exceptionType
	 */
	public ExceptionType getExceptionType() {
		return exceptionType;
	}

	/**
	 * @param exceptionType
	 *            the exceptionType to set
	 */
	public void setExceptionType(ExceptionType exceptionType) {
		this.exceptionType = exceptionType;
	}

	/**
	 * @return the otherAttributesMap
	 */
	public Map<String, String> getOtherAttributesMap() {
		return otherAttributesMap;
	}

	/**
	 * @param otherAttributes
	 *            the otherAttributes to set
	 */
	public void setOtherAttributesMap(Map<String, String> otherAttributesMap) {
		this.otherAttributesMap = otherAttributesMap;
	}

	/*
	 * (non-Javadoc) To String Override for Converting the Object to JSON String
	 * Format
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{");

		toStringByParam(builder, "\"exceptionType\" : \"", exceptionType, "\"");
		toStringByParam(builder, "\"exceptionMessage\" : \"", exceptionMessage,
				"\"");
		toStringByParam(builder, "\"rule\" : \"", rule, "\"");
		toStringByParam(builder, "\"attributeName\" : \"", attributeName, "\"");
		toStringByParam(builder, "\"stackTrace\" : \"", stackTrace, "\"");
		toStringByParam(builder, "\"otherAttributesMap\" : ",
				convertMaptoJsonString(), "");

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

	public String convertMaptoJsonString() {
		StringBuilder builder = new StringBuilder();
		if (otherAttributesMap != null) {
			builder.append("{");
			for (Map.Entry<String, String> entry : otherAttributesMap
					.entrySet()) {
				if (builder.length() > 1) {
					builder.append(COMMA);
				}
				builder.append("\"").append(entry.getKey()).append("\"")
						.append(" : ").append("\"").append(entry.getValue())
						.append("\"");
			}
			builder.append("}");
		} else {
			builder.append("{}");
		}
		return builder.toString();
	}
}
