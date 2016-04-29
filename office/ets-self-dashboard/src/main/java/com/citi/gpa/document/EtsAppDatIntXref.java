package com.citi.gpa.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection="etsAppDatIntXref")
public class EtsAppDatIntXref {
	
	@Id
	private String id;
	
	@Indexed(unique=true,name="appDatIntXrefIdIdx")
	@Field("appDatIntXrefId")
	private long appDatIntXrefId;
	
	@Field("dataIntType")
	private String dataIntType;

	@Field("appDataIntSeverity")
	private long appDataIntSeverity;	
	
	@Field("status")
	private int dataIntstatus;	

	@DBRef
	private EtsApp etsApp;
	
	@DBRef
	private EtsDataInterface etsDataInterface;
	
	public EtsAppDatIntXref() {
		super();
	}

	public EtsAppDatIntXref(long appDatIntXrefId, String dataIntType,
			long appDataIntSeverity, int dataIntstatus, EtsApp etsApp,
			EtsDataInterface etsDataInterface) {
		super();
		this.appDatIntXrefId = appDatIntXrefId;
		this.dataIntType = dataIntType;
		this.appDataIntSeverity = appDataIntSeverity;
		this.dataIntstatus = dataIntstatus;
		this.etsApp = etsApp;
		this.etsDataInterface = etsDataInterface;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getAppDatIntXrefId() {
		return appDatIntXrefId;
	}

	public void setAppDatIntXrefId(long appDatIntXrefId) {
		this.appDatIntXrefId = appDatIntXrefId;
	}

	public String getDataIntType() {
		return dataIntType;
	}

	public void setDataIntType(String dataIntType) {
		this.dataIntType = dataIntType;
	}

	public long getAppDataIntSeverity() {
		return appDataIntSeverity;
	}

	public void setAppDataIntSeverity(long appDataIntSeverity) {
		this.appDataIntSeverity = appDataIntSeverity;
	}

	public int getDataIntstatus() {
		return dataIntstatus;
	}

	public void setDataIntstatus(int dataIntstatus) {
		this.dataIntstatus = dataIntstatus;
	}

	public EtsApp getEtsApp() {
		return etsApp;
	}

	public void setEtsApp(EtsApp etsApp) {
		this.etsApp = etsApp;
	}

	public EtsDataInterface getEtsDataInterface() {
		return etsDataInterface;
	}

	public void setEtsDataInterface(EtsDataInterface etsDataInterface) {
		this.etsDataInterface = etsDataInterface;
	}

	@Override
	public String toString() {
		return "EtsAppDatIntXref [id=" + id + ", appDatIntXrefId="
				+ appDatIntXrefId + ", dataIntType=" + dataIntType
				+ ", appDataIntSeverity=" + appDataIntSeverity
				+ ", dataIntstatus=" + dataIntstatus + ", etsApp=" + etsApp
				+ ", etsDataInterface=" + etsDataInterface + "]";
	}
	

}
