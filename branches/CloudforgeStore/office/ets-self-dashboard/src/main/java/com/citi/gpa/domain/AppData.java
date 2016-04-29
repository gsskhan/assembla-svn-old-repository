package com.citi.gpa.domain;

public class AppData {
	
	private String appName;
	private long appId;
	private String appStatus;
	
	public AppData(String appName, long appId, String appStatus) {
		super();
		this.appName = appName;
		this.appId = appId;
		this.appStatus = appStatus;
	}	
	
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public long getAppId() {
		return appId;
	}
	public void setAppId(long appId) {
		this.appId = appId;
	}
	public String getAppStatus() {
		return appStatus;
	}
	public void setAppStatus(String appStatus) {
		this.appStatus = appStatus;
	}	
	
	@Override
	public String toString() {
		return "AppData [appName=" + appName + ", appId=" + appId + ", appStatus=" + appStatus + "]";
	}

}
