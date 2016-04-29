package com.citi.risk.dashboard.bo;

import java.util.Date;

import com.citi.risk.dashboard.entity.Apps;
import com.citi.risk.dashboard.exception.DashboardException;

/**
 * @author gk85985 This interface contain method to implement business logic,
 *         for maintaining data in table -
 *         "CLOUDAPP"."ETS_DSHBD_APP_COM_STATUS".
 */

public interface AppComStatusManager {

    boolean addRecordToAppComStatus(Apps app, String kpiCategoryName,
            Date msgDateTime) throws DashboardException;

}
