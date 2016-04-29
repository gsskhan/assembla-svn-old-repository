package com.citi.gpa.entity;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name="ETS_POC_APP_IF_XREF")
public class AppIfXref  implements Serializable{
	
	private static final long serialVersionUID = -6503398011924412694L;
	
	@Id
	@Column(name="APP_IF_XREF_ID",nullable=false,unique=true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long appIfXrefId;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="APP_ID")
	private App app;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="IF_ID")
	private Infrastructure infrastructure;
	
	@Column(name="APP_IF_SEVERITY")
	private long appIfSeverity;

	public long getAppIfXrefId() {
		return appIfXrefId;
	}
	public void setAppIfXrefId(long appIfXrefId) {
		this.appIfXrefId = appIfXrefId;
	}
	public App getApp() {
		return app;
	}
	public void setApp(App app) {
		this.app = app;
	}
	public Infrastructure getInfrastructure() {
		return infrastructure;
	}
	public void setInfrastructure(Infrastructure infrastructure) {
		this.infrastructure = infrastructure;
	}


}
