package com.citi.ets.jms.listner;

import javax.jms.TextMessage;
import org.apache.log4j.Logger;
import org.springframework.integration.Message;
import org.springframework.integration.support.converter.SimpleMessageConverter;


public class ConsumerProcess {
	
	private Logger  log = Logger.getLogger(this.getClass());
	
	public void processMessage(Message<?> message){
		
		try {			
			SimpleMessageConverter converter = new SimpleMessageConverter();
			log.debug("RECIEVED MESSAGE =" + message);		
			
			if (converter.fromMessage(message) instanceof TextMessage) {					
				TextMessage msg = (TextMessage) converter.fromMessage(message);				
				log.info("Received message(textmessage) = " + msg);
				
				if (msg.getJMSCorrelationID() == null) {
					log.error("Received message has JMSCorrelationID as null, message dropped. Please check log for details.");
					return;
				}
				log.info("Received message contents     = " + msg.getText());
				
			} else {
				log.error("Message received with not required payload. Message ="+ message);
				return;
			}
			
		} catch (Exception e) {
			log.error("Problem processing message in ConsumerProcess.", e);		
			return;
		}
		
		
	}
	
	

}
