/**
 * 
 */
package com.citi.ets.dashboard.entity;

import java.sql.Date;

/**
 * @author ak64503
 * 
 */
public class Contacts {
	
private String contact_id;
private String apps_id;
private String sector;
private String app_mgr;
private String supp_mgr;
private String level3Org;
private String level5Org;
private Date last_update;
private String last_updatedby;



/**
 * @return the contact_id
 */
public String getContact_id() {
	return contact_id;
}
/**
 * @param contact_id the contact_id to set
 */
public void setContact_id(String contact_id) {
	this.contact_id = contact_id;
}
/**
 * @return the apps_id
 */
public String getApps_id() {
	return apps_id;
}
/**
 * @return the sector
 */
public String getSector() {
	return sector;
}
/**
 * @param sector the sector to set
 */
public void setSector(String sector) {
	this.sector = sector;
}
/**
 * @param apps_id the apps_id to set
 */
public void setApps_id(String apps_id) {
	this.apps_id = apps_id;
}
/**
 * @return the app_mgr
 */
public String getApp_mgr() {
	return app_mgr;
}
/**
 * @param app_mgr the app_mgr to set
 */
public void setApp_mgr(String app_mgr) {
	this.app_mgr = app_mgr;
}
/**
 * @return the supp_mgr
 */
public String getSupp_mgr() {
	return supp_mgr;
}
/**
 * @param supp_mgr the supp_mgr to set
 */
public void setSupp_mgr(String supp_mgr) {
	this.supp_mgr = supp_mgr;
}
/**
 * @return the level3Org
 */
public String getLevel3Org() {
	return level3Org;
}
/**
 * @param level3Org the level3Org to set
 */
public void setLevel3Org(String level3Org) {
	this.level3Org = level3Org;
}
/**
 * @return the level5Org
 */
public String getLevel5Org() {
	return level5Org;
}
/**
 * @param level5Org the level5Org to set
 */
public void setLevel5Org(String level5Org) {
	this.level5Org = level5Org;
}
/**
 * @return the last_update
 */
public Date getLast_update() {
	return last_update;
}
/**
 * @param last_update the last_update to set
 */
public void setLast_update(Date last_update) {
	this.last_update = last_update;
}
/**
 * @return the last_updatedby
 */
public String getLast_updatedby() {
	return last_updatedby;
}
/**
 * @param last_updatedby the last_updatedby to set
 */
public void setLast_updatedby(String last_updatedby) {
	this.last_updatedby = last_updatedby;
}



}
