package com.citi.risk.dashboard.bo.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.citi.risk.dashboard.bo.AppStatusManager;
import com.citi.risk.dashboard.dao.AppEventDao;
import com.citi.risk.dashboard.dao.AppStatusDao;
import com.citi.risk.dashboard.entity.AppStatus;
import com.citi.risk.dashboard.entity.Apps;
import com.citi.risk.dashboard.exception.DashboardException;
import com.citi.risk.dashboard.util.ColorPicker;
import com.citi.risk.dashboard.util.ConstantsUtil;

/**
 * @author gk85985 This class contains all the methods needed to implement
 *         business logic, to maintain data in table
 *         "CLOUDAPP"."ETS_DSHBD_APP_STATUS".
 */
@Service("appStatusManager")
public class AppStatusManagerImpl implements AppStatusManager {

    private Logger log = Logger.getLogger(AppEventsManagerImpl.class);
    @Autowired
    private AppEventDao appEventDao;
    @Autowired
    private AppStatusDao appStatusDao;

    public boolean addRecordToAppStatus(Apps app, String kpiCategoryName,
            Date msgDateTime) throws DashboardException {
        log.info("Begin adding record to AppStatus entity (ETS_DSHBD_APP_STATUS).");
        if (app == null) {
            log.error("'Apps' cannot be null. Skip adding record to AppStatus entity (ETS_DSHBD_APP_STATUS).");
            return false;
        }
        // Get apps Id
        long appsId = app.getAppsId();
        // Get list of latest ids
        String listOfIds = csvlistOfLatestId(appsId, kpiCategoryName);
        log.info("List of latest records =" + listOfIds);
        // Find list of colors for above ids
        List<String> listOfColors = getListColorCode(listOfIds);
        log.info("List of colors to choose from = " + listOfColors);
        // Choose the max priority color
        String color = new ColorPicker().getMaxColor(listOfColors);
        log.info("Calculated final color = " + color);
        // Save appstatus record to db
        appStatusDao
                .saveAppStatus(new AppStatus(app, kpiCategoryName, color,
                        msgDateTime, ConstantsUtil.UPDATE_USER_NAME_DEV
                                .getConstants()));
        log.info("Finished adding record to AppStatus entity (ETS_DSHBD_APP_STATUS).");
        return true;
    }

    /*
     * To Find the list of latest id for APP_KPI_NAME belonging to a
     * KPI_CATEGORY_NAME.
     */
    @SuppressWarnings("unchecked")
    public String csvlistOfLatestId(long appsId, String kpiCatName)
            throws DashboardException {
        List<Object> tmplist = (List<Object>) appEventDao
                .listMaxIdByKpiCatName(appsId, kpiCatName);
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
     * To get list of distinct colors for the input csv list of latest
     * appEventId(s).
     */
    @SuppressWarnings("unchecked")
    public List<String> getListColorCode(String csvListOfIds)
            throws DashboardException {
        if (csvListOfIds != null && csvListOfIds.length() > 0) {
            return (List<String>) appEventDao.listOfColorCodes(csvListOfIds);
        }
        return null;
    }

    // getter-setter methods
    public AppEventDao getAppEventDao() {
        return appEventDao;
    }

    public void setAppEventDao(AppEventDao appEventDao) {
        this.appEventDao = appEventDao;
    }

    public AppStatusDao getAppStatusDao() {
        return appStatusDao;
    }

    public void setAppStatusDao(AppStatusDao appStatusDao) {
        this.appStatusDao = appStatusDao;
    }
}
