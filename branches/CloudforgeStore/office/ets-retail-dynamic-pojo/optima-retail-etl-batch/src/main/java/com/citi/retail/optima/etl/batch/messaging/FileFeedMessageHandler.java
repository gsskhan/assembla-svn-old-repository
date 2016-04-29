package com.citi.retail.optima.etl.batch.messaging;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;

import org.springframework.integration.Message;
import org.springframework.integration.support.MessageBuilder;

import com.citi.retail.optima.etl.batch.dao.BatchJobInstanceDao;
import com.citi.retail.optima.etl.common.ETLBatchStatus;
import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.db.dao.JobConfigDao;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.OptimaRetailBaseException;
import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;
import com.citi.retail.optima.etl.common.model.FileInformation;
import com.citi.retail.optima.etl.controller.dao.JobMessageDao;
import com.citi.retail.optima.xsd.internal.OptimaRetailETLEvent;

/**
 * This class facilitates the handling of internal batch feed request. It pull
 * out the original request message, parses it and persist the necessary details
 * into the feed instance and partition instance tables.
 * 
 * @author ns21567
 * 
 */
public class FileFeedMessageHandler {

	private BatchJobInstanceDao jobInstanceDao;
	private JobMessageDao jobMessageDao;
	private InternalMessageCreator internalMessageCreator;
	private JobConfigDao jobConfigDao;

	public void setJobInstanceDao(BatchJobInstanceDao jobInstanceDao) {
		this.jobInstanceDao = jobInstanceDao;
	}

	public void setJobMessageDao(JobMessageDao jobMessageDao) {
		this.jobMessageDao = jobMessageDao;
	}

	/**
	 * Persists the message of feed type. Takes the message from the message log
	 * table for which it get the id from the job instance table. It persists
	 * the feed details and the partition details in the respective tables.
	 * 
	 * @param optimaRetailInternalEvent
	 * @return
	 * @throws JAXBException
	 * @throws SQLException
	 * @throws OptimaRetailException
	 */
	public Message<Object[]> handleIncomingFeedRequest(
			Message<OptimaRetailETLEvent> message)
			throws JAXBException, SQLException, OptimaRetailBaseException {

		OptimaRetailETLEvent optimaRetailInternalEvent = (OptimaRetailETLEvent) message.getPayload();
		
		Map<String,Object> fileInformation = getFileInformation(optimaRetailInternalEvent);
		Map<String, String> messageHeader = new HashMap<String, String>();
		return MessageBuilder
				.withPayload(
						new Object[] { optimaRetailInternalEvent,
								fileInformation }).copyHeaders(messageHeader)
				.build();
	}

	private Map<String,Object> getFileInformation(
			OptimaRetailETLEvent optimaRetailInternalEvent)
			throws OptimaRetailBaseException {

		try {
			Map<String,Object> fileDetailsMap = new HashMap<String,Object>() ;
			
			List<String> dataFileNames = jobMessageDao.getAllFilesByBatchId(optimaRetailInternalEvent
					.getBatchInstanceId().longValue());
			String controlFileName = jobMessageDao.getControlFileByBatch(optimaRetailInternalEvent
					.getBatchInstanceId().longValue());
			
			fileDetailsMap.put("dataFileNames", dataFileNames);
			fileDetailsMap.put("controlFileName", controlFileName);
			
			return fileDetailsMap;
		} catch (Exception e) {
			internalMessageCreator
					.createAndOutgoingCompletionMessage(optimaRetailInternalEvent
							.getBatchInstanceId().intValue());
			jobInstanceDao.updateBatchStatus(optimaRetailInternalEvent
					.getBatchInstanceId().intValue(), ETLBatchStatus.BTH_FAIL);
			throw new OptimaRetailApplicationException(null, null,
					optimaRetailInternalEvent.getBatchInstanceId().longValue(),
					ServiceName.BATCH, ExceptionType.FATAL,
					"Error in File Feed Message Handler "
							+ optimaRetailInternalEvent.getBatchInstanceId(),
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e),jobConfigDao);

		}

	}

	public void setInternalMessageCreator(
			InternalMessageCreator internalMessageCreator) {
		this.internalMessageCreator = internalMessageCreator;
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
