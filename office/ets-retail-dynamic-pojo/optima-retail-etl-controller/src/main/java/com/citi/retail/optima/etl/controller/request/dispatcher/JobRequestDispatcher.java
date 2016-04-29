package com.citi.retail.optima.etl.controller.request.dispatcher;

import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.integration.Message;

import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.db.dao.JobConfigDao;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;
import com.citi.retail.optima.etl.controller.dao.JobInstanceDao;
import com.citi.retail.optima.etl.controller.model.BatchInstance;
import com.citi.retail.optima.xsd.internal.EventTypes;
import com.citi.retail.optima.xsd.internal.OptimaRetailETLEvent;

/**
 * @author hs73849
 * 
 */
public class JobRequestDispatcher {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(JobRequestDispatcher.class);

	private JobInstanceDao jobInstanceDao;
	private JobConfigDao jobConfigDao;

	public List<OptimaRetailETLEvent> dispatchRequest(Message<List<BatchInstance>> message)
			throws OptimaRetailApplicationException {
		
		//System.out.println("********************* JobRequestDispatcher ****************** ");		
		List<OptimaRetailETLEvent> batchRequestList = new ArrayList<OptimaRetailETLEvent>();
		Long batchInstId=0L;
		try {

			List<BatchInstance> jobInstanceList = message.getPayload();
			for (BatchInstance jobInstance : jobInstanceList) {
				batchInstId=jobInstance.getBatchInstanceId();
				OptimaRetailETLEvent jobRequstEvent = jobInstanceDao
						.getJobRequestDetails(batchInstId);
				jobRequstEvent.setBatchInstanceId(new BigInteger(jobInstance
						.getBatchInstanceId().toString()));

				jobRequstEvent.setEventType(EventTypes.fromValue(jobInstanceDao
						.getEventTypeForBatchInstance(jobInstance
								.getBatchInstanceId())));

				batchRequestList.add(jobRequstEvent);

				LOGGER.debug(" Job request XML sent to batch module for launching the job :: "
						+ jobRequstEvent);
			}
		} catch (Exception exception) {
			LOGGER.error(" Exception in Job Request Dispatcher " + exception);
			Long requestLogId= jobInstanceDao.getRequestLogId(batchInstId);
			jobInstanceDao.updateReqLogStatus(requestLogId,"FAILED");
			throw new OptimaRetailApplicationException(requestLogId, null, null,
					ServiceName.CONTROLLER, ExceptionType.ERROR,
					" Exception occured in JobRequestDispatcher.dispatchRequest() for " + requestLogId,
					exception.getMessage(), OptimaRetailExceptionUtil.getStackTrace(exception),jobConfigDao);

		}
		return batchRequestList;
	}

	public JobInstanceDao getJobInstanceDao() {
		return jobInstanceDao;
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
