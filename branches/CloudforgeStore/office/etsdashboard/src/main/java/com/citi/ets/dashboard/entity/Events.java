package com.citi.ets.dashboard.entity;

import java.sql.Date;

/**
 * @author ak64503
 *
 */
public class Events {
	
	private String app_events_id;
	private String app_csid;
	private String app_name;
	private String event_message;
	private String app_kpi_name;
	private String kpi_category_name;
	private String kpi_value;	
	private String kpi_parameter;
	private Date event_timestamp;
	private String apps_id;
	private String correlation_id;
	private String app_event_category_status;
	private Date last_update;
	private String last_updatedby;
	
	public String getApp_events_id() {
		return app_events_id;
	}
	public void setApp_events_id(String app_events_id) {
		this.app_events_id = app_events_id;
	}
	public String getApp_csid() {
		return app_csid;
	}
	public void setApp_csid(String app_csid) {
		this.app_csid = app_csid;
	}
	public String getApp_name() {
		return app_name;
	}
	public void setApp_name(String app_name) {
		this.app_name = app_name;
	}
	public String getEvent_message() {
		return event_message;
	}
	public void setEvent_message(String event_message) {
		this.event_message = event_message;
	}
	public String getApp_kpi_name() {
		return app_kpi_name;
	}
	public void setApp_kpi_name(String app_kpi_name) {
		this.app_kpi_name = app_kpi_name;
	}
	public String getKpi_category_name() {
		return kpi_category_name;
	}
	public void setKpi_category_name(String kpi_category_name) {
		this.kpi_category_name = kpi_category_name;
	}
	public String getKpi_value() {
		return kpi_value;
	}
	public void setKpi_value(String kpi_value) {
		this.kpi_value = kpi_value;
	}
	public String getKpi_parameter() {
		return kpi_parameter;
	}
	public void setKpi_parameter(String kpi_parameter) {
		this.kpi_parameter = kpi_parameter;
	}
	public Date getEvent_timestamp() {
		return event_timestamp;
	}
	public void setEvent_timestamp(Date event_timestamp) {
		this.event_timestamp = event_timestamp;
	}
	public String getApps_id() {
		return apps_id;
	}
	public void setApps_id(String apps_id) {
		this.apps_id = apps_id;
	}
	public String getCorrelation_id() {
		return correlation_id;
	}
	public void setCorrelation_id(String correlation_id) {
		this.correlation_id = correlation_id;
	}
	public String getApp_event_category_status() {
		return app_event_category_status;
	}
	public void setApp_event_category_status(String app_event_category_status) {
		this.app_event_category_status = app_event_category_status;
	}
	public Date getLast_update() {
		return last_update;
	}
	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}
	public String getLast_updatedby() {
		return last_updatedby;
	}
	public void setLast_updatedby(String last_updatedby) {
		this.last_updatedby = last_updatedby;
	}
	
	
	
	
}
