package com.citi.ets.publisher.common;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.QueueConnection;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.jms.connection.UserCredentialsConnectionFactoryAdapter;


public class CustomUserCredentialsConnectionFactory extends UserCredentialsConnectionFactoryAdapter{
	
	private Logger log = Logger.getLogger(CustomUserCredentialsConnectionFactory.class);
	private String ssl_keypass = null;
	
	@Override
	protected Connection doCreateConnection(String username, String password) throws JMSException {
		initTibSSL();
		
		return super.doCreateConnection(username, password);
	}
	
	@Override
	protected QueueConnection doCreateQueueConnection(String username,	String password) throws JMSException {
		initTibSSL();
		
		return super.doCreateQueueConnection(username, password);
	}
	

	private void initTibSSL() {
		if (!StringUtils.isEmpty(ssl_keypass)){
			log.info("Setting TibjmsSSL password");
			com.tibco.tibjms.TibjmsSSL.setPassword(ssl_keypass.toCharArray());
			log.info("done");
		}
	}

	public String getSsl_keypass() {
		return ssl_keypass;
	}

	public void setSsl_keypass(String ssl_keypass) {
		this.ssl_keypass = ssl_keypass;
	}
	
	
}
