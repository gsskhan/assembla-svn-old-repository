package com.citi.gpa.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection="etsAppIfXref")
public class EtsAppIfXref {
	
	@Id
	private String id;
	
	@Indexed
	@Field("appIfXrefId")
	private long appIfXrefId;
	
	@Field("appIfSeverity")
	private long appIfSeverity;
	
	@Field("status")
	private int appIfStatus;
	
	@DBRef
	private EtsApp etsApp;
	
	@DBRef
	private EtsInfrastructure etsInfrastructure;
	
	public EtsAppIfXref() {
		super();
	}

	public EtsAppIfXref(long appIfXrefId, long appIfSeverity, int appIfStatus,
			EtsApp etsApp, EtsInfrastructure etsInfrastructure) {
		super();
		this.appIfXrefId = appIfXrefId;
		this.appIfSeverity = appIfSeverity;
		this.appIfStatus = appIfStatus;
		this.etsApp = etsApp;
		this.etsInfrastructure = etsInfrastructure;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getAppIfXrefId() {
		return appIfXrefId;
	}

	public void setAppIfXrefId(long appIfXrefId) {
		this.appIfXrefId = appIfXrefId;
	}

	public long getAppIfSeverity() {
		return appIfSeverity;
	}

	public void setAppIfSeverity(long appIfSeverity) {
		this.appIfSeverity = appIfSeverity;
	}

	public int getAppIfStatus() {
		return appIfStatus;
	}

	public void setAppIfStatus(int appIfStatus) {
		this.appIfStatus = appIfStatus;
	}

	public EtsApp getEtsApp() {
		return etsApp;
	}

	public void setEtsApp(EtsApp etsApp) {
		this.etsApp = etsApp;
	}

	public EtsInfrastructure getEtsInfrastructure() {
		return etsInfrastructure;
	}

	public void setEtsInfrastructure(EtsInfrastructure etsInfrastructure) {
		this.etsInfrastructure = etsInfrastructure;
	}

	@Override
	public String toString() {
		return "EtsAppIfXref [id=" + id + ", appIfXrefId=" + appIfXrefId
				+ ", appIfSeverity=" + appIfSeverity + ", appIfStatus="
				+ appIfStatus + ", etsApp=" + etsApp + ", etsInfrastructure="
				+ etsInfrastructure + "]";
	}	

}
