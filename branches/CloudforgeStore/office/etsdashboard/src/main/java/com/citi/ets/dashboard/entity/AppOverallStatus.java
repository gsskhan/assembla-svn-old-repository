package com.citi.ets.dashboard.entity;

import java.sql.Date;

/**
 * @author ak64503
 *
 */
public class AppOverallStatus {
	
	private String app_overall_status_id;
	private String apps_id;
	private String app_overall_status;
	private Date last_update;
	private String last_updatedby;
	public String getApp_overall_status_id() {
		return app_overall_status_id;
	}
	public void setApp_overall_status_id(String app_overall_status_id) {
		this.app_overall_status_id = app_overall_status_id;
	}
	public String getApps_id() {
		return apps_id;
	}
	public void setApps_id(String apps_id) {
		this.apps_id = apps_id;
	}
	public String getApp_overall_status() {
		return app_overall_status;
	}
	public void setApp_overall_status(String app_overall_status) {
		this.app_overall_status = app_overall_status;
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
