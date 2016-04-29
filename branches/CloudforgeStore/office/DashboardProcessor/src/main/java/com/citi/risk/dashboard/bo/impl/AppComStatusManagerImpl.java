package com.citi.risk.dashboard.bo.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.citi.risk.dashboard.bo.AppComStatusManager;
import com.citi.risk.dashboard.dao.AppComStatusDao;
import com.citi.risk.dashboard.dao.AppEventDao;
import com.citi.risk.dashboard.entity.AppComStatus;
import com.citi.risk.dashboard.entity.Apps;
import com.citi.risk.dashboard.exception.DashboardException;
import com.citi.risk.dashboard.util.ColorPicker;
import com.citi.risk.dashboard.util.ConstantsUtil;

/**
 * @author gk85985 This interface contain method to implement business logic,
 *         for maintaining data in table -
 *         "CLOUDAPP"."ETS_DSHBD_APP_COM_STATUS".
 */

@Service("appComStatusManager")
public class AppComStatusManagerImpl implements AppComStatusManager {

    private Logger log = Logger.getLogger(AppComStatusManagerImpl.class);

    @Autowired
    private AppEventDao appEventDao;
    @Autowired
    private AppComStatusDao appComStatusDao;

    public boolean addRecordToAppComStatus(Apps app, String kpiCategoryName,
            Date msgDateTime) throws DashboardException {
        log.info("Begin adding record to AppComStatus entity (ETS_DSHBD_APP_COM_STATUS).");

        if (app == null) {
            log.error("'Apps' cannot be null. Skip adding record to AppComStatus.");
            return false;
        }

        // if KPI CATEGORY is 'FEEDS IN' or 'FEEDS OUT', then find color and add
        // one record, else ignore adding record.
        if (kpiCategoryName.equalsIgnoreCase(ConstantsUtil.KPI_CAT_FEEDS_IN
                .getConstants())
                || kpiCategoryName
                        .equalsIgnoreCase(ConstantsUtil.KPI_CAT_FEEDS_OUT
                                .getConstants())) {
            // Get apps Id
            long appsId = app.getAppsId();
            // Get list of latest id.
            String listOfIds = csvlistOfLatestId(appsId, kpiCategoryName);
            log.info("List of latest records =" + listOfIds);
            // Find list of colors for above ids
            List<String> listOfColors = getListColorCode(listOfIds);
            log.info("List of colors to choose from = " + listOfColors);
            // Choose the max priority color
            String color = new ColorPicker().getMaxColor(listOfColors);
            log.info("Calculated final color = " + color);
            // Save appstatus record to db
            appComStatusDao.saveAppComStatus(new AppComStatus(app,
                    ConstantsUtil.KPI_FEEDS.getConstants(), kpiCategoryName,
                    color, msgDateTime, ConstantsUtil.UPDATE_USER_NAME_DEV
                            .getConstants()));
            log.info("Finished adding record to AppComStatus entity (ETS_DSHBD_APP_COM_STATUS).");
            return true;
        } else {
            log.info("No record added, since Kpi Category - '"
                    + kpiCategoryName
                    + "' is not required for adding AppComStatus. ");
            return true;
        }
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

    /*
     * To Find the list of latest id for APP_KPI_NAME belonging to a
     * KPI_CATEGORY_NAME.
     */
    @SuppressWarnings("unchecked")
    private String csvlistOfLatestId(long appsId, String kpiCatName)
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

    // getter - setter methods.
    public AppEventDao getAppEventDao() {
        return appEventDao;
    }

    public void setAppEventDao(AppEventDao appEventDao) {
        this.appEventDao = appEventDao;
    }

    public AppComStatusDao getAppComStatusDao() {
        return appComStatusDao;
    }

    public void setAppComStatusDao(AppComStatusDao appComStatusDao) {
        this.appComStatusDao = appComStatusDao;
    }

}
