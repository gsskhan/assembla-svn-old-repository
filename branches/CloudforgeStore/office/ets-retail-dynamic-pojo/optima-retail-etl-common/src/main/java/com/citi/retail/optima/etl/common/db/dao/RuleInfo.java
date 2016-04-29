package com.citi.retail.optima.etl.common.db.dao;

import java.io.Serializable;
import java.util.Properties;

public class RuleInfo implements Comparable<RuleInfo>, Serializable {

	private String name;
	private Integer id;
	private Integer execOrder;
	private String className;
	private String[] paramsName;
	private String[] paramsValue;
	private Properties properties;
	
	/**
	 * @return the paramsName
	 */
	public String[] getParamsName() {
		return paramsName;
	}

	/**
	 * @return the paramsValue
	 */
	public String[] getParamsValue() {
		return paramsValue;
	}

	public Properties getProperties() {
		return properties;
	}

	public String getClassName() {
		return this.className;
	}

	public String getName() {
		return name;
	}

	public Integer getId() {
		return id;
	}

	public Integer getExecOrder() {
		return execOrder;
	}
	
	public RuleInfo(String pName, Integer pId, Integer pExecOrder, String pClassName) {
		this.name = pName;
		this.id = pId;
		this.execOrder = pExecOrder;
		this.className = pClassName;
		this.properties = new Properties();
	}
	
	public RuleInfo(String pName, Integer pId, Integer pExecOrder, String pClassName,String paramsName,String patamsValue) {
		this.name = pName;
		this.id = pId;
		this.execOrder = pExecOrder;
		this.className = pClassName;
		this.paramsName = paramsName.trim().split("\\|");
		this.paramsValue = patamsValue.trim().split("\\|");
		this.properties = new Properties();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;		
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		RuleInfo other = (RuleInfo) obj;
		return this.id != null && this.name != null  
				&& this.id.equals(other.id) && this.name.equals(other.name); 
	}

	@Override
	public int compareTo(RuleInfo other) {
		if (other != null) {
			return  this.getExecOrder().compareTo(other.getExecOrder());
		}
		return -1;
	}

}
