package com.citi.risk.dashboard.bo.impl;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.citi.risk.dashboard.bo.AppMsgLogManager;
import com.citi.risk.dashboard.dao.AppMsgLogDao;
import com.citi.risk.dashboard.entity.AppMsgLog;
import com.citi.risk.dashboard.exception.DashboardException;
import com.citi.risk.dashboard.util.ConstantsUtil;

/**
 * @author gk85985 This class contain methods to implement business logic, for
 *         maintaining data in table - "CLOUDAPP"."ETS_DSHBD_APP_MSG_LOG" .
 */
@Repository("appMsgLogManager")
public class AppMsgLogManagerImpl implements AppMsgLogManager {

    @Autowired
    private AppMsgLogDao etsDshbdAppMsgLogDao;

    public void addRecordToAppMsgLog(String correlationID, long timestamp,
            String xmlString, Date msgDateTime) throws DashboardException {
        etsDshbdAppMsgLogDao.saveAppMsgXml(new AppMsgLog(correlationID.trim(),
                timestamp, xmlString, msgDateTime,
                ConstantsUtil.UPDATE_USER_NAME_DEV.getConstants()));
    }

    // getter-setter methods
    public AppMsgLogDao getEtsDshbdAppMsgLogDao() {
        return etsDshbdAppMsgLogDao;
    }

    public void setEtsDshbdAppMsgLogDao(AppMsgLogDao etsDshbdAppMsgLogDao) {
        this.etsDshbdAppMsgLogDao = etsDshbdAppMsgLogDao;
    }
}
