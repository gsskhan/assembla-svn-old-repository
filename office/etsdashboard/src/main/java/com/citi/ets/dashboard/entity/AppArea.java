package com.citi.ets.dashboard.entity;

import java.sql.Date;
import java.util.Set;

/**
 * @author ak64503
 *
 */
public class AppArea implements Comparable<AppArea>{

private String app_area_id;
private String org_id;
private String app_area_name;
private Date last_update;
private String last_updatedby;
private Set<Apps> apps;
private Set<AppAreaStatus> appAreaStatus;
private Set<AppAreaOverallStatus> appAreaOverallStatus;


public Set<AppAreaStatus> getAppAreaStatus() {
	return appAreaStatus;
}
public void setAppAreaStatus(Set<AppAreaStatus> appAreaStatus) {
	this.appAreaStatus = appAreaStatus;
}
public Set<AppAreaOverallStatus> getAppAreaOverallStatus() {
	return appAreaOverallStatus;
}
public void setAppAreaOverallStatus(
		Set<AppAreaOverallStatus> appAreaOverallStatus) {
	this.appAreaOverallStatus = appAreaOverallStatus;
}
public Set<Apps> getApps() {
	return apps;
}
public void setApps(Set<Apps> apps) {
	this.apps = apps;
}
public String getApp_area_id() {
	return app_area_id;
}
public void setApp_area_id(String app_area_id) {
	this.app_area_id = app_area_id;
}
public String getOrg_id() {
	return org_id;
}
public void setOrg_id(String org_id) {
	this.org_id = org_id;
}
public String getApp_area_name() {
	return app_area_name;
}
public void setApp_area_name(String app_area_name) {
	this.app_area_name = app_area_name;
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
@Override
public int compareTo(AppArea area) {
      return (new Integer(this.app_area_id) - new Integer(area.app_area_id));
    
}





}
