package com.citi.ets.publisher.service.impl;

import java.util.UUID;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.citi.ets.publisher.service.MessageSender;

@Service("messageSender")
public class MessageSenderImpl implements MessageSender {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	public boolean sendXML(final String xml) throws JMSException {		
		MessageCreator messageCreator = new MessageCreator() {			
			public Message createMessage(Session session) throws JMSException {
				TextMessage message = session.createTextMessage();
				message.setJMSCorrelationID(UUID.randomUUID().toString());
				message.setText(xml);
				return message;
			}
		};
		jmsTemplate.send(messageCreator);
		return true;
	}

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	

}
