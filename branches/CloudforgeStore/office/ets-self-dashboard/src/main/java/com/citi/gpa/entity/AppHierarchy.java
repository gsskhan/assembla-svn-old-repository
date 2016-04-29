package com.citi.gpa.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="ETS_POC_APP_HIERARCHY")
public class AppHierarchy implements Serializable{
	
	private static final long serialVersionUID = -3579685653562273631L;
	
	@Id
	@Column(name="APP_HIERARCHY_ID",nullable=false,unique=true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long appHierarchyId;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="APP_ID")
	private App app;
	
	@Column(name="DEPENDENT_APP_ID")
	private long dependentApp_id;
	
	@Column(name="STREAM_FLAG")
	private String streamFlag;

	
	public long getAppHierarchyId() {
		return appHierarchyId;
	}
	public void setAppHierarchyId(long appHierarchyId) {
		this.appHierarchyId = appHierarchyId;
	}
	public App getApp() {
		return app;
	}
	public void setApp(App app) {
		this.app = app;
	}
	public long getDependentApp_id() {
		return dependentApp_id;
	}
	public void setDependentApp_id(long dependentApp_id) {
		this.dependentApp_id = dependentApp_id;
	}
	public String getStreamFlag() {
		return streamFlag;
	}
	public void setStreamFlag(String streamFlag) {
		this.streamFlag = streamFlag;
	}
	
	
	@Override
	public String toString() {
		return "AppHierarchy [appHierarchyId=" + appHierarchyId + ", app="
				+ app + ", dependentApp_id=" + dependentApp_id
				+ ", streamFlag=" + streamFlag + "]";
	}	
	


}
