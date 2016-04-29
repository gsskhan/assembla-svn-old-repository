package com.citi.gpa.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection="etsApp")
public class EtsApp {
	
	@Id
	private String id;
	
	@Field("appid")
	@Indexed(unique=true)
	private long appId;
	
	@Field("csi")
	@Indexed
	private long appCsiId;	
	
	@Field("name")
	@Indexed
	private String appName;	
	
	@Field("desc")
	private String appDesc;	
	
	@Field("category")
	private String appCategory;
	
	public EtsApp() {
		super();
	}
	
	public EtsApp(long appId, long appCsiId, String appName, String appDesc, String appCategory) {
		super();
		this.appId = appId;
		this.appCsiId = appCsiId;
		this.appName = appName;
		this.appDesc = appDesc;
		this.appCategory = appCategory;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getAppId() {
		return appId;
	}
	public void setAppId(long appId) {
		this.appId = appId;
	}
	public long getAppCsiId() {
		return appCsiId;
	}
	public void setAppCsiId(long appCsiId) {
		this.appCsiId = appCsiId;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getAppDesc() {
		return appDesc;
	}
	public void setAppDesc(String appDesc) {
		this.appDesc = appDesc;
	}
	public String getAppCategory() {
		return appCategory;
	}
	public void setAppCategory(String appCategory) {
		this.appCategory = appCategory;
	}
	
	@Override
	public String toString() {
		return "EtsApp [ id=" + id +", appId=" + appId + ", appCsiId=" + appCsiId + ", appName="
				+ appName + ", appDesc=" + appDesc + ", AppCategory=" + appCategory	+ "]";
	}
	
	

}
