package com.citi.risk.dashboard.util;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;

/**
 * 
 * @author gk85985 dbcp BasicDataSource extension with encryption support
 */
public class CustomDataSource extends BasicDataSource {

    private Logger log = Logger.getLogger(CustomDataSource.class);

    public CustomDataSource() {
        super();
    }

    @Override
    public void setPassword(String password) {
        String passStr = "";
        try {
            passStr = EncryptDecryptUtil.decrypt(password);
        } catch (Exception e) {
            log.warn("Setting default password as = " + passStr);
            log.error("Unable to decrypt and set password. " + e);
        }
        super.setPassword(passStr);
    }
}
