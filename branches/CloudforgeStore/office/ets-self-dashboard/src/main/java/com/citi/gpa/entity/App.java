package com.citi.gpa.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="ETS_POC_APP")
public class App implements Serializable{
	
	private static final long serialVersionUID = 1113640461417929078L;
	
	@Id
	@Column(name="APP_ID",nullable=false,unique=true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long appId;
	
	@Column(name="APP_CSI_ID")
	private long appCsiId;
	
	@Column(name="APP_NAME")
	private String appName;
	
	@Column(name="APP_DESC")
	private String appDesc;
	
	@Column(name="APP_STATUS")
	private String appStatus;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="app")
	private Set<AppHierarchy> appHierarchies = new HashSet<AppHierarchy>();
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="app")
	private Set<AppDatIntXref> appDatIntXrefs = new HashSet<AppDatIntXref>();
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="app")
	private Set<AppIfXref> appIfXrefs = new HashSet<AppIfXref>();
	
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
	public String getAppStatus() {
		return appStatus;
	}
	public void setAppStatus(String appStatus) {
		this.appStatus = appStatus;
	}
	public Set<AppHierarchy> getAppHierarchies() {
		return appHierarchies;
	}
	public void setAppHierarchies(Set<AppHierarchy> appHierarchies) {
		this.appHierarchies = appHierarchies;
	}
	public Set<AppDatIntXref> getAppDatIntXrefs() {
		return appDatIntXrefs;
	}
	public void setAppDatIntXrefs(Set<AppDatIntXref> appDatIntXrefs) {
		this.appDatIntXrefs = appDatIntXrefs;
	}
	public Set<AppIfXref> getAppIfXrefs() {
		return appIfXrefs;
	}
	public void setAppIfXrefs(Set<AppIfXref> appIfXrefs) {
		this.appIfXrefs = appIfXrefs;
	}		
		

}
