package com.citi.ets.publisher.domain;

import java.sql.Timestamp;

/**
 * 
 * @author gk85985
 * Mapping for RTVIEW_ETS_ALERTS_VIEW
 * 	DESC rtvhist.RTVIEW_ETS_ALERTS_VIEW
	Name                    Null Type              
	----------------------- ---- ----------------- 
	CSIID                        NUMBER(10)        
	SHORTNAME                    VARCHAR2(50 CHAR) 
	COMPONENT                    VARCHAR2(50)      
	KPI                          VARCHAR2(50 CHAR) 
	EVENT_TIMESTAMP              TIMESTAMP(6)      
	APPLICATION_DESCRIPTION      VARCHAR2(1200)    
	ALERT_VALUE                  VARCHAR2(600)     
	SEVERITY                     NUMBER            
	CLEARED                      NUMBER(38)        
 *
 */

public class AlertsView {
	
	private long csiId;
	private String shortname;
	private String component;
	private String kpi;
	private Timestamp eventTimestamp;
	private String appDescription;
	private String alertValue;
	private long severity;
	private long cleared;
	
		
	public AlertsView() {
		super();
	}

	public AlertsView(long csiId, String shortname, String component,
			String kpi, Timestamp eventTimestamp, String appDescription,
			String alertValue, long severity, long cleared) {
		super();
		this.csiId = csiId;
		this.shortname = shortname;
		this.component = component;
		this.kpi = kpi;
		this.eventTimestamp = eventTimestamp;
		this.appDescription = appDescription;
		this.alertValue = alertValue;
		this.severity = severity;
		this.cleared = cleared;
	}
	
	public long getCsiId() {
		return csiId;
	}
	public void setCsiId(long csiId) {
		this.csiId = csiId;
	}
	public String getShortname() {
		return shortname;
	}
	public void setShortname(String shortname) {
		this.shortname = shortname;
	}
	public String getComponent() {
		return component;
	}
	public void setComponent(String component) {
		this.component = component;
	}
	public String getKpi() {
		return kpi;
	}
	public void setKpi(String kpi) {
		this.kpi = kpi;
	}
	public Timestamp getEventTimestamp() {
		return eventTimestamp;
	}
	public void setEventTimestamp(Timestamp eventTimestamp) {
		this.eventTimestamp = eventTimestamp;
	}
	public String getAppDescription() {
		return appDescription;
	}
	public void setAppDescription(String appDescription) {
		this.appDescription = appDescription;
	}
	public String getAlertValue() {
		return alertValue;
	}
	public void setAlertValue(String alertValue) {
		this.alertValue = alertValue;
	}
	public long getSeverity() {
		return severity;
	}
	public void setSeverity(long severity) {
		this.severity = severity;
	}
	public long getCleared() {
		return cleared;
	}
	public void setCleared(long cleared) {
		this.cleared = cleared;
	}

	@Override
	public String toString() {
		return "AlertsView [csiId=" + csiId + ", shortname=" + shortname
				+ ", component=" + component + ", kpi=" + kpi
				+ ", eventTimestamp=" + eventTimestamp + ", appDescription="
				+ appDescription + ", alertValue=" + alertValue + ", severity="
				+ severity + ", cleared=" + cleared + "]";
	}
		

}
