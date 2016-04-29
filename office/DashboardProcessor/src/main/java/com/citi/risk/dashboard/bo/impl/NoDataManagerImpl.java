package com.citi.risk.dashboard.bo.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.citi.risk.dashboard.bo.AppAreaOverStatManager;
import com.citi.risk.dashboard.bo.AppAreaStatusManager;
import com.citi.risk.dashboard.bo.AppOverStatManager;
import com.citi.risk.dashboard.bo.AppStatusManager;
import com.citi.risk.dashboard.bo.NoDataManager;
import com.citi.risk.dashboard.dao.GenericDao;
import com.citi.risk.dashboard.entity.AppArea;
import com.citi.risk.dashboard.entity.AppAreaStatus;
import com.citi.risk.dashboard.entity.AppStatus;
import com.citi.risk.dashboard.entity.Apps;
import com.citi.risk.dashboard.exception.DashboardException;
import com.citi.risk.dashboard.util.ConstantsUtil;

/**
 * @author gk85985 This class has method(s) to mark those fields as GREY (i.e
 *         Not applicable)/GREEN which have no data.
 */
@Service("noDataManager")
public class NoDataManagerImpl implements NoDataManager {

    private Logger log = Logger.getLogger(this.getClass());
    @Autowired
    private GenericDao genericDao;
    @Autowired
    private AppStatusManager appStatusManager;
    @Autowired
    private AppOverStatManager appOverStatManager;
    @Autowired
    private AppAreaOverStatManager appAreaOverStatManager;
    @Autowired
    private AppAreaStatusManager appAreaStatusManager;

    /*
     * (non-Javadoc)
     * 
     * @see com.citi.risk.dashboard.bo.NADataManager#addNotApplicableRecords()
     * To insert Not applicable Color/ Default color into fields which have no
     * data rows in (AppStatus) and (AppAreaStatus) referenced tables.
     */
    public void addNotApplicableRecords() {
        log.info("Begin re-calculating process for assigning GREY (i.e Not applicable) or Default (i.e Green) colour to fields which have no data ...");
        try {
            // find all the apps for which data is present in AppEvents.
            List<Apps> appsList = getAllAppsFromAppEvents();
            log.info("Total apps found = " + appsList.size());
            for (Apps app : appsList) {
                Date currentdateTime = new Date();
                AppArea appArea = app.getAppArea();
                boolean insertflag = false;
                log.info("searching for appsId = " + app.getAppsId()
                        + ", csi id = " + app.getAppCsid() + " , app name = "
                        + app.getAppName());
                // If data for FEEDS OUT is not present in AppEvents and
                // AppStatus, insert a new row with NA color to AppStatus.
                if ((!hasKpiCatInAppEvent(app,
                        ConstantsUtil.KPI_CAT_FEEDS_OUT.getConstants()))
                        && (!hasKpiCatInAppStatus(app,
                                ConstantsUtil.KPI_CAT_FEEDS_OUT.getConstants()))) {
                    addNewAppStatus(new AppStatus(app,
                            ConstantsUtil.KPI_CAT_FEEDS_OUT.getConstants(),
                            ConstantsUtil.COL_GREY.getConstants(),
                            currentdateTime,
                            ConstantsUtil.UPDATE_USER_NAME_DEV.getConstants()));
                    insertflag = true;
                    // If data for FEEDS OUT is not present in AppAreaStatus,
                    // insert a new row with NA color to AppAreaStatus.
                    if (!hasKpiCatInAppAreaStatus(appArea,
                            ConstantsUtil.KPI_CAT_FEEDS_OUT.getConstants())) {
                        addNewAppAreaStatus(new AppAreaStatus(appArea,
                                appArea.getAppAreaName(),
                                ConstantsUtil.KPI_CAT_FEEDS_OUT.getConstants(),
                                ConstantsUtil.COL_GREY.getConstants(),
                                currentdateTime,
                                ConstantsUtil.UPDATE_USER_NAME_DEV
                                        .getConstants()));
                        insertflag = true;
                    }
                }
                // If data for FEEDS IN is not present in AppEvents and
                // AppStatus, insert a new row with NA color to AppStatus.
                if ((!hasKpiCatInAppEvent(app,
                        ConstantsUtil.KPI_CAT_FEEDS_IN.getConstants()))
                        && (!hasKpiCatInAppStatus(app,
                                ConstantsUtil.KPI_CAT_FEEDS_IN.getConstants()))) {
                    addNewAppStatus(new AppStatus(app,
                            ConstantsUtil.KPI_CAT_FEEDS_IN.getConstants(),
                            ConstantsUtil.COL_GREY.getConstants(),
                            currentdateTime,
                            ConstantsUtil.UPDATE_USER_NAME_DEV.getConstants()));
                    insertflag = true;
                    // If data for FEEDS OUT is not present in AppAreaStatus,
                    // insert a new row with NA color to AppAreaStatus.
                    if (!hasKpiCatInAppAreaStatus(appArea,
                            ConstantsUtil.KPI_CAT_FEEDS_IN.getConstants())) {
                        addNewAppAreaStatus(new AppAreaStatus(appArea,
                                appArea.getAppAreaName(),
                                ConstantsUtil.KPI_CAT_FEEDS_IN.getConstants(),
                                ConstantsUtil.COL_GREY.getConstants(),
                                currentdateTime,
                                ConstantsUtil.UPDATE_USER_NAME_DEV
                                        .getConstants()));
                        insertflag = true;
                    }
                }
                // If data for INFRASTRUCTURE is not present in AppEvents and
                // AppStatus, call manager to insert a new row with Default
                // color(as of now Green) to AppStatus.
                if ((!hasKpiCatInAppEvent(app,
                        ConstantsUtil.KPI_CAT_INFRA.getConstants()))
                        && (!hasKpiCatInAppStatus(app,
                                ConstantsUtil.KPI_CAT_INFRA.getConstants()))) {
                    appStatusManager.addRecordToAppStatus(app,
                            ConstantsUtil.KPI_CAT_INFRA.getConstants(),
                            currentdateTime);
                    insertflag = true;
                    // If data for INFRASTRUCTURE is not present in
                    // AppAreaStatus, call manager to insert a new row with NA
                    // color to AppAreaStatus.
                    if (!hasKpiCatInAppAreaStatus(appArea,
                            ConstantsUtil.KPI_CAT_INFRA.getConstants())) {
                        appAreaStatusManager.addRecordToAppAreasStatus(app,
                                ConstantsUtil.KPI_CAT_INFRA.getConstants(),
                                currentdateTime);
                        insertflag = true;
                    }
                }
                // If any new record has been inserted for an application,
                // re-calculate the colors for app and area overall status.
                if (insertflag) {
                    log.info("New row(s) have been added for apps id = "
                            + app.getAppsId() + ", aread id = "
                            + app.getAppArea().getAppAreaId()
                            + ", re-calculating overall status.");
                    appOverStatManager.addToAppOverStat(app, currentdateTime);
                    appAreaOverStatManager.addRecordToAppAreaOverStat(app,
                            currentdateTime);
                }
            }
        } catch (HibernateException e) {
            log.error("Error in re-calculation process of assigning GREY (i.e Not applicable) or Default (i.e Green) colour to fields which have no data ... ", e);
        } catch (DashboardException e) {
            log.error("Error in re-calculation process of assigning GREY (i.e Not applicable) or Default (i.e Green) colour to fields which have no data ... ", e);
        } catch (Exception e) {
            log.error( "Error in re-calculation process of assigning GREY (i.e Not applicable) or Default (i.e Green) colour to fields which have no data ... ", e);
        }
        log.info("finished re-calculating process ... ");
    }

    /**
     * @return List of Apps
     * @throws Exception
     */
    private List<Apps> getAllAppsFromAppEvents() throws HibernateException {
        return genericDao.getList("select distinct apps from AppEvent", null,
                1000);
    }

    /**
     * @param app
     *            - object having application data reference
     * @param kpiCategoryName
     *            - String containing Kpi category Name, ex - INFRASTRUCTURE,
     *            FEEDS IN, FEEDS OUT, etc..
     * @return true if records are present in AppStatus referenced table for an
     *         application and kpi category name
     * @throws Exception
     */
    private boolean hasKpiCatInAppEvent(Apps app, String kpiCategoryName)
            throws HibernateException {
        Long appsId = app.getAppsId();
        String hql = " select count(appEventId) from AppEvent where kpiCatName = :vkpiCategoryName "
                + " and apps.appsId = :vappId ";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("vkpiCategoryName", kpiCategoryName);
        paramMap.put("vappId", appsId);
        Long counter = genericDao.getEntity(hql, paramMap);
        if (counter > 0) {
            log.info(counter + " Row(s) present for apps id = " + appsId
                    + ", Kpi category Name = " + kpiCategoryName
                    + " in AppEvent.");
            return true;
        } else {
            log.info("No rows present for apps id = " + appsId
                    + ", Kpi category Name = " + kpiCategoryName
                    + " in AppEvent.");
            return false;
        }
    }

    /**
     * @param app
     *            - object having application data reference
     * @param kpiCategoryName
     *            - String containing Kpi category Name, ex - INFRASTRUCTURE,
     *            FEEDS IN, FEEDS OUT, etc..
     * @return true if records are present in AppStatus referenced table for an
     *         application and kpi category name
     * @throws Exception
     */
    private boolean hasKpiCatInAppStatus(Apps app, String kpiCategoryName)
            throws HibernateException {
        Long appsId = app.getAppsId();
        String hql = " select count(appStatusId) from AppStatus where kpiCategoryName = :vkpiCategoryName "
                + " and apps.appsId = :vappId ";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("vkpiCategoryName", kpiCategoryName);
        paramMap.put("vappId", appsId);
        Long counter = genericDao.getEntity(hql, paramMap);
        if (counter > 0) {
            log.info(counter + " Row(s) present for apps id = " + appsId
                    + ", Kpi category Name = " + kpiCategoryName
                    + " in AppStatus.");
            return true;
        } else {
            log.info("No rows present for apps id = " + appsId
                    + ", Kpi category Name = " + kpiCategoryName
                    + " in AppStatus.");
            return false;
        }
    }

    /**
     * @param appArea
     *            - object having Application Area data reference
     * @param kpiCategoryName
     *            - String containing Kpi category Name, ex - INFRASTRUCTURE,
     *            FEEDS IN, FEEDS OUT, etc..
     * @return true if records are present in AppAreaStatus referenced table for
     *         an application's area and kpi category name.
     * @throws Exception
     */
    private boolean hasKpiCatInAppAreaStatus(AppArea appArea,
            String kpiCategoryName) throws HibernateException {
        Long appAreaId = appArea.getAppAreaId();
        String hql = " select count(appAreaStatusId) from AppAreaStatus where kpiCategoryName = :vkpiCategoryName "
                + " and appArea.appAreaId = :vappAreaId ";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("vkpiCategoryName", kpiCategoryName);
        paramMap.put("vappAreaId", appAreaId);
        Long counter = genericDao.getEntity(hql, paramMap);
        if (counter > 0) {
            log.info(counter + " Row(s) present for App Area Id = " + appAreaId
                    + ", Kpi category Name = " + kpiCategoryName
                    + " in AppAreaStatus.");
            return true;
        } else {
            log.info("No rows present for App Area Id = " + appAreaId
                    + ", Kpi category Name = " + kpiCategoryName
                    + " in AppAreaStatus.");
            return false;
        }
    }

    /**
     * @param appStatus
     *            - object containing AppStatus data
     * @return true if insertion of param 'appStatus' is successful
     * @throws Exception
     */
    private boolean addNewAppStatus(AppStatus appStatus)
            throws HibernateException {
        long tmpId = (Long) genericDao.saveEntity(appStatus);
        log.info("1 Row(s) added to AppStatus with appStatusId  = " + tmpId);
        return true;
    }

    /**
     * @param appAreaStatus
     *            - object containing AppAreaStatus data
     * @return true if insertion of param 'appAreaStatus' is successful
     * @throws Exception
     */
    private boolean addNewAppAreaStatus(AppAreaStatus appAreaStatus)
            throws HibernateException {
        long tmpId = (Long) genericDao.saveEntity(appAreaStatus);
        log.info("1 Row(s) added to AppAreaStatus with appAreaStatusId  = "
                + tmpId);
        return true;
    }

    // getter-setter methods
    public GenericDao getGenericDao() {
        return genericDao;
    }

    public void setGenericDao(GenericDao genericDao) {
        this.genericDao = genericDao;
    }

    public AppStatusManager getAppStatusManager() {
        return appStatusManager;
    }

    public void setAppStatusManager(AppStatusManager appStatusManager) {
        this.appStatusManager = appStatusManager;
    }

    public AppOverStatManager getAppOverStatManager() {
        return appOverStatManager;
    }

    public void setAppOverStatManager(AppOverStatManager appOverStatManager) {
        this.appOverStatManager = appOverStatManager;
    }

    public AppAreaOverStatManager getAppAreaOverStatManager() {
        return appAreaOverStatManager;
    }

    public void setAppAreaOverStatManager(
            AppAreaOverStatManager appAreaOverStatManager) {
        this.appAreaOverStatManager = appAreaOverStatManager;
    }

    public AppAreaStatusManager getAppAreaStatusManager() {
        return appAreaStatusManager;
    }

    public void setAppAreaStatusManager(
            AppAreaStatusManager appAreaStatusManager) {
        this.appAreaStatusManager = appAreaStatusManager;
    }
}
