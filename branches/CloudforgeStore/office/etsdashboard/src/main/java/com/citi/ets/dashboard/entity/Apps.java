package com.citi.ets.dashboard.entity;

import java.sql.Date;
import java.util.Set;

/**
 * @author ak64503
 *
 */
public class Apps implements Comparable<Apps>{

private String apps_id;
private String app_csid;
private String app_name;
private String app_area_id;
private Date last_update;
private String last_updatedby;
private Set<Events> events;
private Set<AppStatus> appStatus;
private Set<AppOverallStatus> appOverallStatus;
private Set<Contacts> contact;


/**
 * @return the contact
 */
public Set<Contacts> getContact() {
	return contact;
}
/**
 * @param contact the contact to set
 */
public void setContact(Set<Contacts> contact) {
	this.contact = contact;
}
public Set<AppStatus> getAppStatus() {
	return appStatus;
}
public void setAppStatus(Set<AppStatus> appStatus) {
	this.appStatus = appStatus;
}
public Set<AppOverallStatus> getAppOverallStatus() {
	return appOverallStatus;
}
public void setAppOverallStatus(Set<AppOverallStatus> appOverallStatus) {
	this.appOverallStatus = appOverallStatus;
}
public Set<Events> getEvents() {
	return events;
}
public void setEvents(Set<Events> events) {
	this.events = events;
}
public String getApps_id() {
	return apps_id;
}
public void setApps_id(String apps_id) {
	this.apps_id = apps_id;
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
public String getApp_area_id() {
	return app_area_id;
}
public void setApp_area_id(String app_area_id) {
	this.app_area_id = app_area_id;
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
public int compareTo(Apps app) {
      return (new Integer(this.apps_id) - new Integer(app.apps_id));
    
}




}
