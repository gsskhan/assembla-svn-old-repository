package com.citi.retail.optima.etl.common.db.dao;

import java.io.Serializable;
import java.util.List;

public class ConstraintMapping implements Serializable {

	private static final long serialVersionUID = -2789378568981987946L;
	private String className;
	private String fieldName;
	private String validationType;
	private List<RuleInfo> rules;
	private Integer processingUnitId;
	private String validationCategory;
	private String rulesKey;
	private boolean checkOnlyField;

	public void setCheckOnlyField(boolean checkOnlyField) {
		this.checkOnlyField = checkOnlyField;
	}

	public List<RuleInfo> getRules() {
		return rules;
	}

	public void setRules(List<RuleInfo> rules) {
		this.rules = rules;
	}

	public String getValidationCategory() {
		return validationCategory;
	}

	public void setValidationCategory(String validationCategory) {
		this.validationCategory = validationCategory;
	}

	public ConstraintMapping(String pFieldName, String pValidationType,
			Integer processingUnitId, String pValidationCategory,String pRulesKey) {
		this.fieldName = pFieldName;
		this.validationType = pValidationType;
		this.processingUnitId = processingUnitId;
		this.validationCategory = pValidationCategory;
		this.rulesKey=pRulesKey;
	}

	/**
	 * @return the processingUnitId
	 */
	public Integer getProcessingUnitId() {
		return processingUnitId;
	}

	/**
	 * @param processingUnitId
	 *            the processingUnitId to set
	 */
	public void setProcessingUnitId(Integer processingUnitId) {
		this.processingUnitId = processingUnitId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getValidationType() {
		return validationType;
	}

	public void setValidationType(String validationType) {
		this.validationType = validationType;
	}

	@Override
	public boolean equals(Object obj) {
		ConstraintMapping mapping = (ConstraintMapping) obj;
		return ((mapping != null) && (fieldName != null) && fieldName
				.equals(mapping.fieldName)) ? (checkOnlyField ? true
				: ((validationType != null) && (processingUnitId != null)
						&& (validationCategory != null)
						&& validationType.equals(mapping.validationType)
						&& processingUnitId.equals(mapping.processingUnitId) && validationCategory
						.equals(mapping.validationCategory)))
				: false;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result)
				+ ((fieldName == null) ? 0 : fieldName.hashCode());
		result = (prime * result)
				+ ((validationType == null) ? 0 : validationType.hashCode());
		result = (prime * result)
				+ ((processingUnitId == null) ? 0 : processingUnitId.hashCode());
		result = (prime * result)
				+ ((validationCategory == null) ? 0 : validationCategory
						.hashCode());
		result = (prime * result)
				+ ((rulesKey == null) ? 0 : rulesKey
						.hashCode());
		return result;
	}
	
	/**
	 * @return the rulesKey
	 */
	public String getRulesKey() {
		return rulesKey;
	}

	/**
	 * @param rulesKey the rulesKey to set
	 */
	public void setRulesKey(String rulesKey) {
		this.rulesKey = rulesKey;
	}

}
