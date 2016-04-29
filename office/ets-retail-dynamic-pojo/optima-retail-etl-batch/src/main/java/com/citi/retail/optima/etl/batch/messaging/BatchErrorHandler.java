package com.citi.retail.optima.etl.batch.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jms.core.JmsTemplate;

import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.JmsLoggingExceptionPublisher;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;
import com.citi.retail.optima.etl.common.log.LoggingMarker;

/**
 * Handles integration channel based exceptions.
 * 
 * @author ns21567
 * 
 */
public class BatchErrorHandler implements InitializingBean {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(BatchErrorHandler.class);

	private JmsTemplate jmsTemplate;

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void handleError(Exception exceptionObject) {
		LOGGER.error(
				LoggingMarker.JMS.getMarker(),
				new OptimaRetailApplicationException(null, null, null,
						ServiceName.BATCH, ExceptionType.ERROR,
						"Error in Bact Error Handler", exceptionObject
								.getMessage(), OptimaRetailExceptionUtil
								.getStackTrace(exceptionObject),null).toString());

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		JmsLoggingExceptionPublisher publisher;
		publisher = new JmsLoggingExceptionPublisher();
		publisher.setJmsTemplate(jmsTemplate);

	}

}
