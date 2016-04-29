package com.citi.retail.optima.etl.controller.request.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.integration.handler.AbstractMessageHandler;
import org.springframework.integration.support.MessageBuilder;

import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.db.dao.JobConfigDao;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;
import com.citi.retail.optima.etl.controller.dao.JobInstanceDao;
import com.citi.retail.optima.etl.controller.file.mover.FileMoverUtility;
import com.citi.retail.optima.etl.controller.model.RequestMessageType;
import com.citi.retail.optima.xsd.internal.OptimaRetailETLEvent;

/**
 * @author hs73849
 * 
 */
public class JobCompletionRequestHandler  extends AbstractMessageHandler implements InitializingBean{

	private static final Logger LOGGER = LoggerFactory
			.getLogger(JobCompletionRequestHandler.class);

	private JobInstanceDao jobInstanceDao;
	private MessagingTemplate messageTemplate = new MessagingTemplate();
	private MessageChannel messageChannel;
	private FileMoverUtility fileMovementUtlity; 
	private JobConfigDao jobConfigDao;
	
	public void handleMessageInternal(Message<?> message)
			throws Exception {
		Long batchInstId = null;
		boolean isJobSuccessful = false;
		try {
			batchInstId = ((OptimaRetailETLEvent)message.getPayload()).getBatchInstanceId().longValue(); 
			isJobSuccessful = jobInstanceDao.updateJobCompletionStatus(batchInstId);
			fileMovementUtlity.moveFileForBatch(batchInstId, isJobSuccessful?"success":"failed");
		} catch (Exception e) {
			Long requestLogId= jobInstanceDao.getRequestLogId(batchInstId);
			jobInstanceDao.updateReqLogStatus(requestLogId,"FAILED");
		
			throw new OptimaRetailApplicationException(requestLogId, null, null,
					ServiceName.CONTROLLER, ExceptionType.ERROR,
					" Exception occured in JobCompletionRequestHandler.handleRequest() for " + requestLogId,
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e),jobConfigDao);			
		}
		messageTemplate.send(messageChannel,MessageBuilder.withPayload(RequestMessageType.BATCH_COMPLETION).build());
	}

	public void setJobInstanceDao(JobInstanceDao jobInstanceDao) {
		this.jobInstanceDao = jobInstanceDao;
	}

	/**
	 * @param fileMovementUtlity the fileMovementUtlity to set
	 */
	public void setFileMovementUtlity(FileMoverUtility fileMovementUtlity) {
		this.fileMovementUtlity = fileMovementUtlity;
	}

	/**
	 * @param messageTemplate the messageTemplate to set
	 */
	public void setMessageTemplate(MessagingTemplate messageTemplate) {
		this.messageTemplate = messageTemplate;
	}

	/**
	 * @param messageChannel the messageChannel to set
	 */
	public void setMessageChannel(MessageChannel messageChannel) {
		this.messageChannel = messageChannel;
	}

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
	
	

}
