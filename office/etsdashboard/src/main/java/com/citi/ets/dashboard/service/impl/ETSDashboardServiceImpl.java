package com.citi.ets.dashboard.service.impl;

import java.util.List;

import com.citi.ets.dashboard.dao.impl.ETSDashboardDaoImpl;
import com.citi.ets.dashboard.entity.Acronym;
import com.citi.ets.dashboard.entity.Contacts;
import com.citi.ets.dashboard.entity.Events;
import com.citi.ets.dashboard.entity.Org;
import com.citi.ets.dashboard.service.ETSDashboardServiceI;

public class ETSDashboardServiceImpl implements ETSDashboardServiceI {

    private static ETSDashboardDaoImpl dashboardDao;

    public void setDashboardDao(ETSDashboardDaoImpl dashboardDao) {
	ETSDashboardServiceImpl.dashboardDao = dashboardDao;
    }

    public List<Org> getOrgRefDetails() {
	return dashboardDao.getOrgRefDetails();
    }

    @Override
    public List<String> getDistinctKPIbyAppCSI(String csi) {
	return dashboardDao.getDistinctKPIbyAppCSI(csi);
    }
   
    @Override
    public String getAppAreaOverallStatus(String areaId) {
	return dashboardDao.getAppAreaOverallStatus(areaId);
    }

   
    @Override
    public String getAppAreaStatus(String areaId, String categoryName) {
	return dashboardDao.getAppAreaStatus(areaId, categoryName);
    }

    @Override
    public String getAppOverallStatus(String appId) {
	return dashboardDao.getAppOverallStatus(appId);
    }

    @Override
    public String getAppStatus(String appId, String categoryName) {
	return dashboardDao.getAppStatus(appId, categoryName);
    }

    @Override
    public Events getLatestEvent(String appCsid, String appKpiName, String kpiCategoryName) {
	return dashboardDao.getLatestEvent(appCsid, appKpiName, kpiCategoryName);
    }

    @Override
    public List<String> getDistinctAppsId() {
	return dashboardDao.getDistinctAppsId();
    }

    @Override
    public Events getHistoryDetails(String appName, String kpiCategoryName, String kpiCategory) {
	return dashboardDao.getHistoryDetails(appName, kpiCategoryName, kpiCategory);
    }

    @Override
    public Contacts getContactDetails(String appId) {
	return dashboardDao.getContactDetails(appId);
    }

	@Override
	public Acronym getAcronymDetails(String appId) {
	return dashboardDao.getAcronymDetails(appId);
	}

	@Override
	public List<Events> getReportEvents(String appCsi, String startDate, String endDate) throws Exception {
	return dashboardDao.getReportEvents(appCsi, startDate, endDate);
	}

	@Override
	public List<Events> getReportEvents(String appCsi, String month) throws Exception {
		return dashboardDao.getReportEvents(appCsi, month);
	}

}
