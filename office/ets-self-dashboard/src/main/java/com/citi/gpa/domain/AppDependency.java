package com.citi.gpa.domain;

public class AppDependency {
	
	private long fromAppId;
	private long toAppId;
	
	public AppDependency() {
		super();
	}
	
	public AppDependency(long fromAppId, long toAppId) {
		super();
		this.fromAppId = fromAppId;
		this.toAppId = toAppId;
	}

	public long getFromAppId() {
		return fromAppId;
	}
	public void setFromAppId(long fromAppId) {
		this.fromAppId = fromAppId;
	}
	public long getToAppId() {
		return toAppId;
	}
	public void setToAppId(long toAppId) {
		this.toAppId = toAppId;
	}

	@Override
	public String toString() {
		return "AppDependency [fromAppId=" + fromAppId + ", toAppId=" + toAppId	+ "]";
	}	
	

}
