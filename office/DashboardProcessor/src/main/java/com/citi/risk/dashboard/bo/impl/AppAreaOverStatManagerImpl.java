package com.citi.risk.dashboard.bo.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.citi.risk.dashboard.bo.AppAreaOverStatManager;
import com.citi.risk.dashboard.dao.AppAreaOverStatDao;
import com.citi.risk.dashboard.dao.AppOverallStatusDao;
import com.citi.risk.dashboard.entity.AppArea;
import com.citi.risk.dashboard.entity.AppAreaOverStatus;
import com.citi.risk.dashboard.entity.Apps;
import com.citi.risk.dashboard.exception.DashboardException;
import com.citi.risk.dashboard.util.ColorPicker;
import com.citi.risk.dashboard.util.ConstantsUtil;

/**
 * @author gk85985 This class contain method to implement business logic, for
 *         maintaining data in table -
 *         "CLOUDAPP"."ETS_DSHBD_APP_AREA_OVERALL_STS".
 */

@Service("appAreaOverStatManager")
public class AppAreaOverStatManagerImpl implements AppAreaOverStatManager {

    private Logger log = Logger.getLogger(AppAreaOverStatManagerImpl.class);

    @Autowired
    private AppOverallStatusDao appOverallStatusDao;
    @Autowired
    private AppAreaOverStatDao appAreaOverStatDao;

    public boolean addRecordToAppAreaOverStat(Apps app, Date msgDateTime)
            throws DashboardException {
        log.info("Begin adding record to AppAreaOverStatus entity (ETS_DSHBD_APP_AREA_OVERALL_STS).");
        if (app != null) {
            // Get app area details.
            AppArea area = app.getAppArea();
            // Get list of latest id(s)
            String listOfIds = csvlistOfLatestId(area.getAppAreaId());
            log.info("List of latest records =" + listOfIds);
            // Find list of colors for above id(s)
            List<String> listOfColors = getListColorCode(listOfIds);
            log.info("List of colors to choose from = " + listOfColors);
            // Choose the max priority color
            String color = new ColorPicker().getMaxColor(listOfColors);
            log.info("Calculated final color = " + color);

            appAreaOverStatDao.saveAppAreaOverStatus(new AppAreaOverStatus(
                    area, area.getAppAreaName(), color, msgDateTime,
                    ConstantsUtil.UPDATE_USER_NAME_DEV.getConstants()));
            log.info("Finished adding record to AppAreaOverStatus entity (ETS_DSHBD_APP_AREA_OVERALL_STS).");
            return true;
        } else {
            log.error("'Apps' is null. No record saved for AppAreaOverStatus entity (ETS_DSHBD_APP_AREA_OVERALL_STS).");
            return false;
        }
    }

    /*
     * To Find the list of latest id for APPS_ID belonging to a Application Id.
     */
    @SuppressWarnings("unchecked")
    public String csvlistOfLatestId(long appAreaId) throws DashboardException {
        List<Object> tmplist = (List<Object>) appOverallStatusDao
                .listMaxIdByApp(appAreaId);
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
            return (List<String>) appOverallStatusDao
                    .listOfColorCodes(csvListOfIds);
        }
        return null;
    }

    // getter-setter methods
    public AppOverallStatusDao getAppOverallStatusDao() {
        return appOverallStatusDao;
    }

    public void setAppOverallStatusDao(AppOverallStatusDao appOverallStatusDao) {
        this.appOverallStatusDao = appOverallStatusDao;
    }

    public AppAreaOverStatDao getAppAreaOverStatDao() {
        return appAreaOverStatDao;
    }

    public void setAppAreaOverStatDao(AppAreaOverStatDao appAreaOverStatDao) {
        this.appAreaOverStatDao = appAreaOverStatDao;
    }
}
