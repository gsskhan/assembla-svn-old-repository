package com.citi.ets.dashboard.dao;

import java.util.List;

import com.citi.ets.dashboard.entity.Acronym;
import com.citi.ets.dashboard.entity.Contacts;
import com.citi.ets.dashboard.entity.Events;
import com.citi.ets.dashboard.entity.Org;

/**
 * @author ak64503
 *
 */
public interface ETSDashboardDaoI {	
	public List<Org> getOrgRefDetails();	
	public List<String> getDistinctAppsId();
	public List<String> getDistinctKPIbyAppCSI(String csi);
	public String getAppAreaOverallStatus(String areaId);
	public String getAppAreaStatus(String areaId, String categoryName);
	public String getAppOverallStatus(String appId);
	public String getAppStatus(String appId, String categoryName);
	public Events getLatestEvent(String appCsid, String appKpiName, String kpiCategoryName);	
	public Events getHistoryDetails(String appName, String kpiCategoryName, String kpiCategory);
	public Contacts getContactDetails(String appId);
	public Acronym getAcronymDetails(String appId);
	public List<Events> getReportEvents(String appCsi, String startDate, String endDate) throws Exception;
	public List<Events> getReportEvents(String appCsi, String month) throws Exception;
}
