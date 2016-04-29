package com.citi.risk.dashboard.bo.impl;

import java.text.ParseException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citi.risk.dashboard.bo.AppEventsManager;
import com.citi.risk.dashboard.dao.AppEventDao;
import com.citi.risk.dashboard.dao.ThresholdMasterDao;
import com.citi.risk.dashboard.entity.AppEvent;
import com.citi.risk.dashboard.entity.Apps;
import com.citi.risk.dashboard.exception.DashboardException;
import com.citi.risk.dashboard.util.ConstantsUtil;

/**
 * 
 * @author gk85985,gc63735 This class contains all the methods needed to
 *         implement business logic, to maintain data in table -
 *         "CLOUDAPP"."ETS_DSHBD_APP_EVENTS".
 */

/*
 * Rule1: validate input parameters. Rule2: Confirm "CSI ID/APP NAME" exist in
 * reference data table. Rule3: Get APP_EVENT_CATEGORY_STATUS from threshold
 * table. Rule4: Don't save the data if any rule is violated.
 */

@Service("appEventsManager")
public class AppEventsManagerImpl implements AppEventsManager {

    private Logger log = Logger.getLogger(AppEventsManager.class);

    @Autowired
    private AppEventDao appEventDAO;
    @Autowired
    private ThresholdMasterDao thresholdDao;

    /*
     * Method with business logic to add a new row to table. Refer above for
     * rules implemented.
     */
    public boolean addRecordToAppEvents(Apps app, String kpiName,
            String kpiCategoryName, String kpiValue, String eventMsg,
            String kpiParameter, Date eventTimestamp, String correlationId,
            Date msgDateTime) throws DashboardException {
        if (app == null) {
            log.error("'Apps' cannot be null.");
            return false;
        }
        String csiId = app.getAppCsid();
        String appName = app.getAppName();

        log.info("Processing [csiId=" + csiId + ",appName=" + appName + ","
                + "kpiName=" + kpiName + ",kpiCategoryName=" + kpiCategoryName
                + "," + "kpiValue=" + kpiValue + ", kpiParameter= "
                + kpiParameter + "," + "eventMsg=" + eventMsg
                + ", eventTimestamp=" + eventTimestamp + ", msgDateTime="
                + msgDateTime + "]");

        if (!valInParams(csiId, appName, kpiName, kpiCategoryName, kpiValue)) {
            log.error("Either of the above parameters is null or empty, skip to next record.");
            return false;
        }

        String appCatstatus = findColourCode(csiId, appName, kpiCategoryName,
                kpiName, kpiParameter, kpiValue);
        if (appCatstatus == null || appCatstatus.length() < 1) {
            log.error("Couldn't find colour code from master threshold table. Skip to next record(if any).");
            return false;
        }
        AppEvent appEvent = new AppEvent(app, csiId, appName, kpiName,
                kpiCategoryName, kpiValue, eventMsg,
                this.getRequiredString(kpiParameter), appCatstatus,
                eventTimestamp, correlationId, msgDateTime,
                ConstantsUtil.UPDATE_USER_NAME_DEV.getConstants());
        appEventDAO.saveAppEvents(appEvent);
        log.info("Added successfully. [csiId=" + csiId + ",appName=" + appName
                + "," + "kpiName=" + kpiName + ",kpiCategoryName="
                + kpiCategoryName + "," + "kpiValue=" + kpiValue
                + ", kpiParameter= " + kpiParameter + "," + "eventMsg="
                + eventMsg + ", eventTimestamp=" + eventTimestamp + "]");
        return true;
    }

    /* To decrease the length of string if Input string is more >= 4000 */
    private String getRequiredString(String input) {
        int maxlen = input.length();
        if (maxlen >= 3999) {
            log.warn("Found String with length > 4000, required trimming of string done. ");
            return input.substring(0, 3998);
        }
        return input;
    }

    /* To validate input parameters. */
    public boolean valInParams(String csiId, String appName, String kpiName,
            String kpiCategoryName, String kpiValue) {
        if (csiId == null || appName == null || kpiName == null
                || kpiCategoryName == null || kpiValue == null) {
            return false;
        }
        if (csiId.isEmpty() || appName.isEmpty() || kpiName.isEmpty()
                || kpiCategoryName.isEmpty() || kpiValue.isEmpty()) {
            return false;
        }
        return true;
    }

    /* To find the color code from threshold master table. */
    public String findColourCode(String csiId, String appName,
            String kpiCategoryName, String kpiName, String kpiParameter,
            String kpiValue) throws DashboardException {
        Double value = null;
        String colourCode = null;
        try {
            value = this.getDoubleValue(kpiValue);
        } catch (ParseException pe) {
            log.error("Problem extracting value from input kpiValue. "
                    + pe.getMessage());
            return null;
        }
        if (kpiName.contains("FEEDS")) {
            colourCode = thresholdDao.getColorCode(csiId, appName,
                    kpiCategoryName, kpiName, null, value);
        } else {
            colourCode = thresholdDao.getColorCode(csiId, appName,
                    kpiCategoryName, kpiName, kpiParameter, value);
        }
        if (colourCode == null) {
            log.error("Colour code not found in threshold table for {csi="
                    + csiId + " ,appName=" + appName + " ,kpiCategoryName="
                    + kpiCategoryName + " ,kpiParameter =" + kpiParameter
                    + " ,kpiName=" + kpiName + " ,(extracted)kpiValue=" + value
                    + "}.");
            return null;
        }
        return colourCode;
    }

    /* To get first occurrence of double from String */
    private double getDoubleValue(String mixedDataString) throws ParseException {
        double val = 0;
        // to support float
        Pattern pattern = Pattern.compile("[\\d\\.]+");
        Matcher matcher = pattern.matcher(mixedDataString);
        if (matcher.find()) {
            log.info("KPI Value after parsing with regex: " + matcher.group());
            val = Double.parseDouble(matcher.group());
        } else {
            throw new ParseException("Cannot get kpi value from string {"
                    + mixedDataString + "}.", 0);
        }
        return val;
    }

    // getter-setters methods
    public AppEventDao getAppEventDAO() {
        return appEventDAO;
    }

    public void setAppEventDAO(AppEventDao appEventDAO) {
        this.appEventDAO = appEventDAO;
    }

    public ThresholdMasterDao getThresholdDao() {
        return thresholdDao;
    }

    public void setThresholdDao(ThresholdMasterDao thresholdDao) {
        this.thresholdDao = thresholdDao;
    }

}
