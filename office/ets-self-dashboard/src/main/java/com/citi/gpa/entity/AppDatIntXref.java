package com.citi.gpa.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="ETS_POC_APP_DAT_INT_XREF")
public class AppDatIntXref implements Serializable{
	
	private static final long serialVersionUID = -3811878316630907751L;
	
	@Id
	@Column(name="APP_DAT_INT_XREF_ID",nullable=false,unique=true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long appDatIntXrefId;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="APP_ID")
	private App app;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="DATA_INT_ID")
	private DataInterface dataInterface;
	
	@Column(name="DATA_INT_TYPE")
	private String DataIntType;

	@Column(name="APP_DATA_INT_SEVERITY")
	private long appDataIntSeverity;	
	
	public long getAppDatIntXrefId() {
		return appDatIntXrefId;
	}
	public void setAppDatIntXrefId(long appDatIntXrefId) {
		this.appDatIntXrefId = appDatIntXrefId;
	}
	public App getApp() {
		return app;
	}
	public void setApp(App app) {
		this.app = app;
	}
	public DataInterface getDataInterface() {
		return dataInterface;
	}
	public void setDataInterface(DataInterface dataInterface) {
		this.dataInterface = dataInterface;
	}
	public String getDataIntType() {
		return DataIntType;
	}
	public void setDataIntType(String dataIntType) {
		DataIntType = dataIntType;
	}
	public long getAppDataIntSeverity() {
		return appDataIntSeverity;
	}
	public void setAppDataIntSeverity(long appDataIntSeverity) {
		this.appDataIntSeverity = appDataIntSeverity;
	}		

}
