package com.citi.retail.optima.etl.fileintegrity.common;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

public class ColumnRules implements Comparable<ColumnRules> {
	private Long columnId;
	private String columnName=" ";
	private Boolean duplicate;
	private int order;
	private String dataType="";
	private String regex;
	private boolean notNull;
	private Integer maxlength;
	
	private Map<String, String> errorMessages = new HashMap<String, String>();
	
	public ColumnRules() {
		
	}
	
	public ColumnRules(Long columnId, String columnName, boolean duplicate, int order,String dataType,
			String regex,boolean notNull) {
		super();
		this.columnId = columnId;
		this.columnName = columnName;
		this.duplicate = duplicate;
		this.order = order;
		this.dataType = dataType;
		this.regex = regex;
		this.regex = regex;
		this.notNull = notNull;
	}


	@XmlAttribute(required=false)
	public boolean isNotNull() {
		return notNull;
	}
	public void setNotNull(boolean notNull) {
		this.notNull = notNull;
	}
	
	@XmlAttribute(required=false)
	public String getRegex() {
		return regex;
	}
	public void setRegex(String regex) {
		this.regex = regex;
	}
	@XmlAttribute
	public Boolean getDuplicate() {
		return duplicate;
	}
	@XmlAttribute
	public Long getColumnId() {
		return columnId;
	}
	public void setColumnId(Long columnId) {
		this.columnId = columnId;
	}
	@XmlAttribute
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	@XmlAttribute
	public Boolean isDuplicate() {
		return duplicate;
	}
	public void setDuplicate(Boolean duplicate) {
		this.duplicate = duplicate;
	}
	@XmlAttribute
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	@XmlAttribute
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	
	@XmlJavaTypeAdapter(MapAdapter.class)
	@XmlElement(required=false)
	public Map<String, String> getErrorMessages() {
		return errorMessages;
	}
	public void setErrorMessages(Map<String, String> errorMessages) {
		this.errorMessages = errorMessages;
	}
	
	@XmlElement(required=false)
	public Integer getMaxlength() {
		return maxlength;
	}

	public void setMaxlength(Integer maxlength) {
		this.maxlength = maxlength;
	}

	public int compareTo(ColumnRules o) {
		if(o!=null){
			if (this.order>o.getOrder()){
				return 1;
			}else{
				return -1; 
			}
		}
		return 0;
	}
}
