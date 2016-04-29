package com.citi.gpa.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="etsAppStatus")
public class EtsAppStatus {

	@Id
	private String id;
	
	@Field("appid")
	@Indexed(unique=true)
	private long appId;
	
	@Field("status")
	@Indexed
	private int appStatus;

	@DBRef
	private EtsApp etsApp;
	
	public EtsAppStatus() {
		super();
	}
	
	public EtsAppStatus(long appId, int appStatus, EtsApp etsApp) {
		super();
		this.appId = appId;
		this.appStatus = appStatus;
		this.etsApp = etsApp;
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
	public int getAppStatus() {
		return appStatus;
	}
	public void setAppStatus(int appStatus) {
		this.appStatus = appStatus;
	}
	public EtsApp getEtsApp() {
		return etsApp;
	}
	public void setEtsApp(EtsApp etsApp) {
		this.etsApp = etsApp;
	}

	@Override
	public String toString() {
		return "EtsAppStatus [id=" + id + ", appId=" + appId + ", appStatus="+ appStatus + ", etsApp=" + etsApp + "]";
	}	
	
	
}
