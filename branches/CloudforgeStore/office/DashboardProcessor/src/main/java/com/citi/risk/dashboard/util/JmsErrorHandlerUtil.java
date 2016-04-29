package com.citi.risk.dashboard.util;

import org.apache.log4j.Logger;
import org.springframework.util.ErrorHandler;

/**
 * 
 * @author gk85985 This class shall handle errors with Jms listner container.
 */
public class JmsErrorHandlerUtil implements ErrorHandler {

    private Logger log = Logger.getLogger(JmsErrorHandlerUtil.class);

    public void handleError(Throwable th) {
        log.error("Error in jms listner.", th);
    }
}
