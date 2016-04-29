package com.citi.ets.publisher.service.impl;

import java.util.ArrayList;

import javax.jms.JMSException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citi.ets.publisher.common.ProcessInstance;
import com.citi.ets.publisher.service.MessageSender;
import com.citi.ets.publisher.service.XmlSendService;
import com.citi.ets.publisher.vo.XmlDataHolder;

@Service("xmlSendService")
public class XmlSendServiceImpl implements XmlSendService{
	
	private Logger log = Logger.getLogger(XmlSendServiceImpl.class);
	
	@Autowired
	private MessageSender messageSender;

	public void jmsXMLSender(ArrayList<XmlDataHolder> xmlList) throws JMSException {
		boolean sendStatus = false;
		for (XmlDataHolder xmlDataHolder : xmlList) {
				sendStatus = messageSender.sendXML(xmlDataHolder.getXml());
				if (! sendStatus) {
					log.error("Problem sending message.");
					return;
				} else {
					log.info("Message sent successfully.");
					ProcessInstance.setTimeLastProcessed(xmlDataHolder.getTime());
				}
		}
		
	}

	public MessageSender getMessageSender() {
		return messageSender;
	}
	public void setMessageSender(MessageSender messageSender) {
		this.messageSender = messageSender;
	}
	

}
