package com.citi.risk.dashboard.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import com.citi.risk.dashboard.bo.AppMsgLogManager;
import com.citi.risk.dashboard.vo.TibcoMessageDataHolder;

/**
 * 
 * @author gk85985
 * 
 *         Class usage - To save the XML message to DB.
 */
public class MessageAuditLoggingService {

    private Logger log = Logger.getLogger(MessageAuditLoggingService.class);
    @Autowired
    private AppMsgLogManager msgLogManager;

    /**
     * @param messageDataHolder
     *            To save the contents of message into db.
     */
    public void addXmlMessageToDatabase(TibcoMessageDataHolder messageDataHolder) {
        try {
            log.info("Begin saving message for audit history.");
            msgLogManager.addRecordToAppMsgLog(
                    messageDataHolder.getCorrelationID(),
                    messageDataHolder.getTimestamp(),
                    messageDataHolder.getXmlString(),
                    messageDataHolder.getMsgDateTime());
            log.info("Successfully saved message for audit history.");
        } catch (Exception e) {
            log.error("Problem saving message for audit history.", e);
        }
    }

    // getter - setter methods
    public AppMsgLogManager getMsgLogManager() {
        return msgLogManager;
    }

    public void setMsgLogManager(AppMsgLogManager msgLogManager) {
        this.msgLogManager = msgLogManager;
    }
}
