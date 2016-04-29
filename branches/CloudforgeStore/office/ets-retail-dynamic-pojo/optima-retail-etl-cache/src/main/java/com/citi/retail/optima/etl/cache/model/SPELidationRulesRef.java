package com.citi.retail.optima.etl.cache.model;

import java.io.Serializable;

/**
 * @author sv16441
 * 
 */
public class SPELidationRulesRef extends BaseRef implements Serializable {

	private static final long serialVersionUID = 7101244668438544547L;
	
	private String rulesKey;
	private Integer ruleId;
	private String ruleToExecute;
	private Integer ruleOrder;
	private String errorMessage;
	private String auditValues;
	private Integer attrId;
	private String attrName;
	
	public String getRulesKey() {
		return rulesKey;
	}
	public void setRulesKey(String rulesKey) {
		this.rulesKey = rulesKey;
	}
	public String getRuleToExecute() {
		return ruleToExecute;
	}
	public void setRuleToExecute(String ruleToExecute) {
		this.ruleToExecute = ruleToExecute;
	}
	public Integer getRuleOrder() {
		return ruleOrder;
	}
	public void setRuleOrder(Integer ruleOrder) {
		this.ruleOrder = ruleOrder;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((ruleToExecute == null) ? 0 : ruleToExecute.hashCode());
		result = prime * result
				+ ((rulesKey == null) ? 0 : rulesKey.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj){
			return true;
		}
		if (!super.equals(obj)){
			return false;
		}
		if (getClass() != obj.getClass()){
			return false;
		}
		SPELidationRulesRef other = (SPELidationRulesRef) obj;
		if (ruleToExecute == null) {
			if (other.ruleToExecute != null){
				return false;
			}
		} else if (!ruleToExecute.equals(other.ruleToExecute)){
			return false;
		}
		if (rulesKey == null) {
			if (other.rulesKey != null){
				return false;
			}
		} else if (!rulesKey.equals(other.rulesKey)){
			return false;
		}
		return true;
	}
	public String getAttrName() {
		return attrName;
	}
	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}
	public Integer getRuleId() {
		return ruleId;
	}
	public void setRuleId(Integer ruleId) {
		this.ruleId = ruleId;
	}
	public Integer getAttrId() {
		return attrId;
	}
	public void setAttrId(Integer attrId) {
		this.attrId = attrId;
	}
	public String getAuditValues() {
		return auditValues;
	}
	public void setAuditValues(String auditValues) {
		this.auditValues = auditValues;
	}

}
