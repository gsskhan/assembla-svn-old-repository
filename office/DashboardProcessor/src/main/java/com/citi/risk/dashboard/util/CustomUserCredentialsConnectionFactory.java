package com.citi.risk.dashboard.util;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.QueueConnection;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.jms.connection.UserCredentialsConnectionFactoryAdapter;

public class CustomUserCredentialsConnectionFactory extends
        UserCredentialsConnectionFactoryAdapter {

    private Logger log = Logger
            .getLogger(CustomUserCredentialsConnectionFactory.class);
    private String sslKeypass = null;

    @Override
    protected Connection doCreateConnection(String username, String password)
            throws JMSException {
        initTibSSL();
        return super.doCreateConnection(username, password);
    }

    @Override
    protected QueueConnection doCreateQueueConnection(String username,
            String password) throws JMSException {
        initTibSSL();
        return super.doCreateQueueConnection(username, password);
    }

    private void initTibSSL() {
        if (!StringUtils.isEmpty(sslKeypass)) {
            log.info("Setting TibjmsSSL password");
            com.tibco.tibjms.TibjmsSSL.setPassword(sslKeypass.toCharArray());
            log.info("done");
        }
    }

    public String getSslKeypass() {
        return sslKeypass;
    }

    public void setSslKeypass(String sslKeypass) {
        this.sslKeypass = sslKeypass;
    }
}
