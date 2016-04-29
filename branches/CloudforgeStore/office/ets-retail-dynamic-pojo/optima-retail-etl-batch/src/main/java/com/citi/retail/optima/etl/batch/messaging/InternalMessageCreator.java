package com.citi.retail.optima.etl.batch.messaging;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.integration.support.MessageBuilder;

import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.db.dao.JobConfigDao;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.OptimaRetailBaseException;
import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;
import com.citi.retail.optima.xsd.internal.OptimaRetailETLEvent;

public class InternalMessageCreator implements InitializingBean {

	private MessageChannel internalMessageChannel;
	private MessagingTemplate messagingTemplate;
	private JobConfigDao jobConfigDao;
	
	

	/**
	 * @return the jobConfigDao
	 */
	public JobConfigDao getJobConfigDao() {
		return jobConfigDao;
	}

	/**
	 * @param jobConfigDao the jobConfigDao to set
	 */
	public void setJobConfigDao(JobConfigDao jobConfigDao) {
		this.jobConfigDao = jobConfigDao;
	}

	public void createAndOutgoingCompletionMessage(Integer batchInstanceId)
			throws OptimaRetailBaseException {

		messagingTemplate.convertAndSend(internalMessageChannel,
				createOutgoingCompletionMessage(batchInstanceId));
	}

	/**
	 * This method creates the outgoing message for the completed/failed job
	 * which to be sent to the controller.
	 * 
	 * @param jobExecution
	 *            - needs the details of the job launched which sent in the
	 *            jobExecution object
	 * @return - outgoing message
	 * @throws OptimaRetailException
	 *             - exception while creating the outgoing message
	 */
	private Message createOutgoingCompletionMessage(Integer batchInstanceId)
			throws OptimaRetailBaseException {

		OptimaRetailETLEvent outgoingMessage;
		try {
			outgoingMessage = new OptimaRetailETLEvent();
			outgoingMessage.setBatchInstanceId(new BigInteger(batchInstanceId
					.toString()));
			SimpleDateFormat formater = new SimpleDateFormat(
					"yyyy-MM-dd hh:mm:ss");
			outgoingMessage.setEventTimestamp(formater.format(new Date(System
					.currentTimeMillis())));
			outgoingMessage.setRequestID("ORETL-" + Math.random());
			outgoingMessage
					.setEventType(com.citi.retail.optima.xsd.internal.EventTypes.ORETL_JOB_COMPLETE);

		} catch (Exception e) {
			throw new OptimaRetailApplicationException(null, null,
					batchInstanceId.longValue(), ServiceName.BATCH,
					ExceptionType.FATAL, "Error in Internal Message Creator"
							+ batchInstanceId, e.getMessage(),
					OptimaRetailExceptionUtil.getStackTrace(e),jobConfigDao);
		}

		return MessageBuilder.withPayload(outgoingMessage).build();

	}

	@Override
	public void afterPropertiesSet() {
		messagingTemplate = new MessagingTemplate();

	}

	public void setInternalMessageChannel(MessageChannel internalMessageChannel) {
		this.internalMessageChannel = internalMessageChannel;
	}

	public void setMessagingTemplate(MessagingTemplate messagingTemplate) {
		this.messagingTemplate = messagingTemplate;
	}

}