package com.citi.ets.publisher.service;

import javax.jms.JMSException;

/**
 * 
 * @author gk85985
 *
 */
public interface MessageSender {
	
	public boolean sendXML(final String xml) throws JMSException;	
	

}
