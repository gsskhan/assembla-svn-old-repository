package org.dms.web.entity;


/*/
 * Comparable interface has been implemented for viewing data on UI, nothing to do with hibernate
 */
public class Constants implements Comparable<Constants> {
	
	private int constantId;
	private String variable;
	private int variableId;
	private String value;
	private int parentVariableId;
	
	// constructors
	public Constants(){
		super();
	}
	
	public Constants(String variable, int variableId, String value,
			int parentVariableId) {
		super();
		this.variable = variable;
		this.variableId = variableId;
		this.value = value;
		this.parentVariableId = parentVariableId;
	}
	
	// getter - setters methods
	public int getConstantId() {
		return constantId;
	}
	public void setConstantId(int constantId) {
		this.constantId = constantId;
	}
	public String getVariable() {
		return variable;
	}
	public void setVariable(String variable) {
		this.variable = variable;
	}
	public int getVariableId() {
		return variableId;
	}
	public void setVariableId(int variableId) {
		this.variableId = variableId;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public int getParentVariableId() {
		return parentVariableId;
	}
	public void setParentVariableId(int parentVariableId) {
		this.parentVariableId = parentVariableId;
	}

	// To String override
	public String toString() {
		return "[constantId=" + constantId + ", variable=" + variable
				+ ", variableId=" + variableId + ", value=" + value
				+ ", parentVariableId=" + parentVariableId + "]";
	}

	// To compare data on UI(esp. for grids)
	public int compareTo(Constants o) {
		return this.variable.toLowerCase().compareTo(o.getVariable().toLowerCase());
	}
	

	

}
