package com.citi.ets.dashboard.entity;

import java.sql.Date;
import java.util.Set;

/**
 * @author ak64503
 *
 */
public class Org {

private String org_id;
private String org_name;
private Date last_update;
private String last_updatedby;
private Set<AppArea> appAreas;


public String getOrg_id() {
	return org_id;
}
public void setOrg_id(String org_id) {
	this.org_id = org_id;
}
public String getOrg_name() {
	return org_name;
}
public void setOrg_name(String org_name) {
	this.org_name = org_name;
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
public Set<AppArea> getAppAreas() {
	return appAreas;
}
public void setAppAreas(Set<AppArea> appAreas) {
	this.appAreas = appAreas;
}



}
