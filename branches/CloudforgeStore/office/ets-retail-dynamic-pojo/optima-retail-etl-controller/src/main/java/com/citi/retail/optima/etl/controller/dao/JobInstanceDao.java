package com.citi.retail.optima.etl.controller.dao;

import java.util.Map;

import com.citi.retail.optima.etl.common.ETLBatchStatus;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.controller.model.BatchInstance;
import com.citi.retail.optima.etl.controller.model.MessageLog;
import com.citi.retail.optima.xsd.internal.OptimaRetailETLEvent;

/**
 * @author hs73849
 * 
 */
public interface JobInstanceDao {

	BatchInstance getJobInstanceDetails(Long jobInstanceId)
			throws OptimaRetailApplicationException;

	Boolean updateJobCompletionStatus(Long batchInstanceId)
			throws OptimaRetailApplicationException;

	Integer updateJobRunningStatus(Long jobInstanceId, Long jobId,
			ETLBatchStatus jobStatus) throws OptimaRetailApplicationException;

	OptimaRetailETLEvent getJobRequestDetails(Long jobInstanceId)
			throws OptimaRetailApplicationException;

	Map<String, Object> createUserSubmissionJobInstance(MessageLog messageLogVO)
			throws OptimaRetailApplicationException;

	String getEventTypeForBatchInstance(Long batchInstanceId)
			throws OptimaRetailApplicationException;
	
	Map<String, Object> createDataAcquisitionJobInstance(MessageLog messageLogVO)
			throws OptimaRetailApplicationException;
	
	Long getRequestLogId(Long batchInstanceId) throws OptimaRetailApplicationException;
	//TODO remove it shud not be in both DAO
	Integer updateReqLogStatus(Long logId, String status) throws OptimaRetailApplicationException;
	
	

}
