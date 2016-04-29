package com.citi.ets.dashboard.entity;

import java.sql.Date;

/**
 * @author ak64503
 *
 */
public class AppAreaStatus {
	
	private String app_area_status_id;
	private String app_area_id;
	private String app_area_name;
	private String kpi_category_name;
	private String app_compstatus;
	private Date last_update;
	private String last_updatedby;
	
	
	public String getApp_area_status_id() {
		return app_area_status_id;
	}
	public void setApp_area_status_id(String app_area_status_id) {
		this.app_area_status_id = app_area_status_id;
	}
	public String getApp_area_id() {
		return app_area_id;
	}
	public void setApp_area_id(String app_area_id) {
		this.app_area_id = app_area_id;
	}
	public String getApp_area_name() {
		return app_area_name;
	}
	public void setApp_area_name(String app_area_name) {
		this.app_area_name = app_area_name;
	}
	public String getKpi_category_name() {
		return kpi_category_name;
	}
	public void setKpi_category_name(String kpi_category_name) {
		this.kpi_category_name = kpi_category_name;
	}
	public String getApp_compstatus() {
		return app_compstatus;
	}
	public void setApp_compstatus(String app_compstatus) {
		this.app_compstatus = app_compstatus;
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
