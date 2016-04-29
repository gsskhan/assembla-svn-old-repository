package org.dms.web.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="constants")
@CompoundIndexes(value={
		@CompoundIndex(def="{'variablename':1,'variablevalue':1}", name="varaibleNameAndValueIdx", unique=true)
})
public class Constants implements Comparable<Constants>{
	
	@Id
	private String id;
	
	@Field(value="variablename")
	private String variableName;
	
	@Field(value="variableid")
	private int variableId;
	
	@Field(value="variablevalue")
	private String variableValue;
	
	@Field(value="parentvariableid")
	private int parentVariableId;
	
	public Constants() {
		super();
	}	

	public Constants(String variableName, int variableId,
			String variableValue, int parentVariableId) {
		super();
		this.variableName = variableName;
		this.variableId = variableId;
		this.variableValue = variableValue;
		this.parentVariableId = parentVariableId;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVariableName() {
		return variableName;
	}

	public void setVariableName(String variableName) {
		this.variableName = variableName;
	}

	public int getVariableId() {
		return variableId;
	}

	public void setVariableId(int variableId) {
		this.variableId = variableId;
	}

	public String getVariableValue() {
		return variableValue;
	}

	public void setVariableValue(String variableValue) {
		this.variableValue = variableValue;
	}

	public int getParentVariableId() {
		return parentVariableId;
	}

	public void setParentVariableId(int parentVariableId) {
		this.parentVariableId = parentVariableId;
	}

	@Override
	public String toString() {
		return "Constants [id=" + id + ", variableName=" + variableName + ", variableId="
				+ variableId + ", variableValue=" + variableValue
				+ ", parentVariableId=" + parentVariableId + "]";
	}


	// To compare data on UI(esp. for grids)
	public int compareTo(Constants o) {
		return this.variableName.toLowerCase().compareTo(o.getVariableName().toLowerCase());
	}
}
