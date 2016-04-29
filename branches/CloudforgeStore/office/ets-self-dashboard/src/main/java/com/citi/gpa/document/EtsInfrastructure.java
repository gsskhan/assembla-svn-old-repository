package com.citi.gpa.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection="etsInfrastructure")
public class EtsInfrastructure {
	
	@Id
	private String id;
	
	@Indexed(unique=true,name="ifidIdx")
	@Field(value="ifId")
	private long ifId;	

	@Field(value="ifName")
	private String ifName;
	
	@Field(value="ifCategory")
	private String ifCategory;
	
	@Field(value="ifType")
	private String ifType;
	
	@Field(value="location")
	private String location;
	
	public EtsInfrastructure() {
		super();
	}

	public EtsInfrastructure(long ifId, String ifName, String ifCategory,
			String ifType, String location) {
		super();
		this.ifId = ifId;
		this.ifName = ifName;
		this.ifCategory = ifCategory;
		this.ifType = ifType;
		this.location = location;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getIfId() {
		return ifId;
	}
	public void setIfId(long ifId) {
		this.ifId = ifId;
	}
	public String getIfName() {
		return ifName;
	}
	public void setIfName(String ifName) {
		this.ifName = ifName;
	}
	public String getIfCategory() {
		return ifCategory;
	}
	public void setIfCategory(String ifCategory) {
		this.ifCategory = ifCategory;
	}
	public String getIfType() {
		return ifType;
	}
	public void setIfType(String ifType) {
		this.ifType = ifType;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "EtsInfrastructure [id=" + id + ", ifId=" + ifId + ", ifName="
				+ ifName + ", ifCategory=" + ifCategory + ", ifType=" + ifType
				+ ", location=" + location + "]";
	}	
	
	
}
