package com.citi.retail.optima.etl.controller.request.handler;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.Message;

import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.db.dao.JobConfigDao;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;
import com.citi.retail.optima.etl.controller.dao.JobInstanceDao;
import com.citi.retail.optima.etl.controller.model.MessageLog;
import com.citi.retail.optima.etl.controller.model.RequestMessageType;

public class UserSubmissionJobCreationRequestHandler implements RequestHandler<MessageLog> {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(UserSubmissionJobCreationRequestHandler.class);
	
	private JobInstanceDao jobInstanceDao;
	private JobConfigDao jobConfigDao;

	@Override
	public RequestMessageType handleRequest(Message<MessageLog> message)
			throws OptimaRetailApplicationException {
		MessageLog messageLog=null;
		Long requestLogId=0L;
		try {
			messageLog=message.getPayload();
			requestLogId=messageLog.getMessageId();
			LOGGER.debug("Job Creation Request received for the Message Id: "
					+ requestLogId);
			Map<String, Object> resultMap = this.jobInstanceDao.createDataAcquisitionJobInstance(messageLog);
		} catch (Exception e) {
			throw new OptimaRetailApplicationException(requestLogId, null, null,
					ServiceName.CONTROLLER, ExceptionType.ERROR,
					" Exception occured in UserSubmissionJobCreationRequestHandler.handleRequest() for " + requestLogId,
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e),jobConfigDao);			
			
		}
		return RequestMessageType.NEW_REQUEST;
	}

	public void setJobInstanceDao(JobInstanceDao jobInstanceDao) {
		this.jobInstanceDao = jobInstanceDao;
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
