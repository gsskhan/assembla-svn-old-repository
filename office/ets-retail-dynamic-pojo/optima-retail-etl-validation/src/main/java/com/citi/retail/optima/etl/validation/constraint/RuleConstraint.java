/**
 * 
 */
package com.citi.retail.optima.etl.validation.constraint;



/**
 * @author TJ
 *
 */
public abstract class RuleConstraint {

	protected Integer ruleId;
	
	private Integer sysProcId;
	
	protected String ruleAsString;
	
	protected String violationMsg;
	
	protected Integer attributeId;
	
	protected String attributeName;
	
	protected String AuditValuesExprAsString;
	
	private Integer ruleOrder;
	
	private String rulesKey;
	

	public abstract Object getRule();
	
	public abstract Object getAuditValuesExpr();
	
	public String getRulesKey() {
		return rulesKey;
	}

	public void setRulesKey(String rulesKey) {
		this.rulesKey = rulesKey;
	}

	public Integer getSysProcId() {
		return sysProcId;
	}

	public void setSysProcId(Integer sysProcId) {
		this.sysProcId = sysProcId;
	}

	public Integer getRuleOrder() {
		return ruleOrder;
	}

	public void setRuleOrder(Integer ruleOrder) {
		this.ruleOrder = ruleOrder;
	}



	public String getRuleAsString() {
		return ruleAsString;
	}

	public void setRuleAsString(String ruleAsString) {
		this.ruleAsString = ruleAsString;
	}

	public String getViolationMsg() {
		return violationMsg;
	}

	public void setViolationMsg(String violationMsg) {
		this.violationMsg = violationMsg;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public Integer getRuleId() {
		return ruleId;
	}

	public void setRuleId(Integer ruleId) {
		this.ruleId = ruleId;
	}

	public String getAuditValuesExprAsString() {
		return AuditValuesExprAsString;
	}

	public void setAuditValuesExprAsString(String auditValuesExprAsString) {
		AuditValuesExprAsString = auditValuesExprAsString;
	}

	public Integer getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(Integer attributeId) {
		this.attributeId = attributeId;
	}

}
