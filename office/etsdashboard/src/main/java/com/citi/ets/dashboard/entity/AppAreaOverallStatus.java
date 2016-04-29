package com.citi.ets.dashboard.entity;

import java.sql.Date;

/**
 * @author ak64503
 *
 */
public class AppAreaOverallStatus {
	
	private String status_id;
	private String app_area_id;
	private String app_area_name;	
	private String app_area_overall_status;
	private Date last_update;
	private String last_updatedby;
	
	
	
	public String getStatus_id() {
		return status_id;
	}
	public void setStatus_id(String status_id) {
		this.status_id = status_id;
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
	public String getApp_area_overall_status() {
		return app_area_overall_status;
	}
	public void setApp_area_overall_status(String app_area_overall_status) {
		this.app_area_overall_status = app_area_overall_status;
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
