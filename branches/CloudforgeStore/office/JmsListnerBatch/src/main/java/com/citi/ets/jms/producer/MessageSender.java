package com.citi.ets.jms.producer;

import java.util.UUID;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class MessageSender {
	
	private JmsTemplate jmsTemplate;
	
	private Logger log = Logger.getLogger(MessageSender.class);
	
	public boolean sendXML(final String xml) throws JMSException {		
		MessageCreator messageCreator = new MessageCreator() {			
			public Message createMessage(Session session) throws JMSException {
				if (xml.isEmpty() || xml ==null) {
					throw new NullPointerException("XML body is null or empty. Abort sending message.");
				}
				TextMessage message = session.createTextMessage();
				message.setJMSCorrelationID(UUID.randomUUID().toString());
				message.setText(xml);
				log.info("Message = "+ message);
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
