package com.citi.risk.dashboard.bo.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.citi.risk.dashboard.bo.AppAreaStatusManager;
import com.citi.risk.dashboard.dao.AppAreaStatusDao;
import com.citi.risk.dashboard.dao.AppStatusDao;
import com.citi.risk.dashboard.entity.AppArea;
import com.citi.risk.dashboard.entity.AppAreaStatus;
import com.citi.risk.dashboard.entity.Apps;
import com.citi.risk.dashboard.exception.DashboardException;
import com.citi.risk.dashboard.util.ColorPicker;
import com.citi.risk.dashboard.util.ConstantsUtil;

/**
 * @author gk85985
 * 
 */

@Service("appAreaStatusManager")
public class AppAreaStatusManagerImpl implements AppAreaStatusManager {

    private Logger log = Logger.getLogger(AppAreaStatusManagerImpl.class);
    @Autowired
    private AppStatusDao appStatusDao;
    @Autowired
    private AppAreaStatusDao appAreaStatusDao;

    public boolean addRecordToAppAreasStatus(Apps app, String kpiCategoryName,
            Date msgDateTime) throws DashboardException {
        log.info("Begin adding record to AppAreaStatus entity (ETS_DSHBD_APP_AREA_STATUS).");
        if (app != null) {
            // Get app area details.
            AppArea area = app.getAppArea();
            // Get list of latest id(s)
            String listOfIds = csvlistOfLatestId(area.getAppAreaId(),
                    kpiCategoryName);
            log.info("List of latest records =" + listOfIds);
            // Find list of colors for above id(s)
            List<String> listOfColors = getListColorCode(listOfIds);
            log.info("List of colors to choose from = " + listOfColors);
            // Choose the max priority color
            String color = new ColorPicker().getMaxColor(listOfColors);
            log.info("Calculated final color = " + color);

            appAreaStatusDao.saveAppAreaStatus(new AppAreaStatus(area, area
                    .getAppAreaName(), kpiCategoryName, color, msgDateTime,
                    ConstantsUtil.UPDATE_USER_NAME_DEV.getConstants()));
            log.info("Finished adding record to AppAreaStatus entity (ETS_DSHBD_APP_AREA_STATUS).");
            return true;
        } else {
            log.error("No apps object is null.  No record saved for AppAreaStatus entity (ETS_DSHBD_APP_AREA_STATUS).");
            return false;
        }
    }

    /*
     * To Find the list of latest id for APPS_ID belonging to a Area Id and Kpi
     * Category Name.
     */
    @SuppressWarnings("unchecked")
    public String csvlistOfLatestId(long appAreaId, String kpiCategoryName)
            throws DashboardException {
        List<Object> tmplist = (List<Object>) appStatusDao.listMaxIdByArea(
                appAreaId, kpiCategoryName);
        List<Long> maxIdList = new ArrayList<Long>();
        Iterator<Object> itr = tmplist.iterator();
        while (itr.hasNext()) {
            Object[] obj = (Object[]) itr.next();
            maxIdList.add((Long) obj[1]);
            log.debug(obj[0] + " : " + obj[1]);
        }
        if (maxIdList.size() > 0) {
            return StringUtils.collectionToCommaDelimitedString(maxIdList);
        }
        return null;
    }

    /*
     * To get list of distinct colors for the input csv list of latest Id(s).
     */
    @SuppressWarnings("unchecked")
    public List<String> getListColorCode(String csvListOfIds)
            throws DashboardException {
        if (csvListOfIds != null && csvListOfIds.length() > 0) {
            return (List<String>) appStatusDao.listOfColorCodes(csvListOfIds);
        }
        return null;
    }

    // getter - setter methods
    public AppStatusDao getAppStatusDao() {
        return appStatusDao;
    }

    public void setAppStatusDao(AppStatusDao appStatusDao) {
        this.appStatusDao = appStatusDao;
    }

    public AppAreaStatusDao getAppAreaStatusDao() {
        return appAreaStatusDao;
    }

    public void setAppAreaStatusDao(AppAreaStatusDao appAreaStatusDao) {
        this.appAreaStatusDao = appAreaStatusDao;
    }

}
