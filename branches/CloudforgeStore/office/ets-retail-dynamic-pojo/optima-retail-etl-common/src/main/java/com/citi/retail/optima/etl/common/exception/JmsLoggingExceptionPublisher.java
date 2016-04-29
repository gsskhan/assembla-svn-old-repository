/**
 * 
 */
package com.citi.retail.optima.etl.common.exception;

import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;

import ch.qos.logback.classic.Logger;

import com.citi.retail.optima.etl.common.log.LoggingMarker;
import com.citi.retail.optima.etl.common.log.LoggingPublisher;

/**
 * . This class will publish the OptimaRetailException and its child object as
 * message to JMS Queue
 * 
 */
public class JmsLoggingExceptionPublisher implements
		LoggingPublisher<Exception> {

	private static final Logger LOGGER = (Logger) LoggerFactory
			.getLogger(JmsLoggingExceptionPublisher.class);

	private JmsTemplate jmsTemplate;

	public JmsTemplate getJmsTemplate() {
		return this.jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.citi.retail.optima.etl.common.log.LoggingPublisher#publish(java.lang
	 * .Exception)
	 */
	@Override
	public void publish(Exception exception) {
		// TODO Auto-generated method stub
		try {
			LOGGER.error(LoggingMarker.JMS.getMarker(),exception.toString());
		} catch (Exception e) {
			LOGGER.error(" Error while sending the exception details "
					+ e.getMessage());
			throw new IllegalStateException(e);
		}
	}

}
