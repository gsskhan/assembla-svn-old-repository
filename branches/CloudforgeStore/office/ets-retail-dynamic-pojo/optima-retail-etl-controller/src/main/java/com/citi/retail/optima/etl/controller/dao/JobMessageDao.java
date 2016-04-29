package com.citi.retail.optima.etl.controller.dao;

import java.util.List;
import java.util.Map;

import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.controller.model.EventFileMapVO;
import com.citi.retail.optima.etl.controller.model.MessageLog;

/**
 * @author hs73849
 * 
 */
public interface JobMessageDao {

	Long saveInternalMessageDetails(MessageLog messageLog)
			throws OptimaRetailApplicationException;

	Long saveGenesisMessageDetails(MessageLog messageLog)
			throws OptimaRetailApplicationException;

	void saveUserSubmissionMessageDetails(MessageLog messageLog)
			throws OptimaRetailApplicationException;
	
	void saveGCBCPortfolioDefinationDetails(MessageLog messageLog)
			throws OptimaRetailApplicationException;

	Long getRequestLogId() throws OptimaRetailApplicationException;

	void saveRequestLogId(MessageLog messageLog)
			throws OptimaRetailApplicationException;
	
	void saveDataAcquisitionMessageDetails(MessageLog messageLog) throws OptimaRetailApplicationException;
	
	List<EventFileMapVO> getAllControlFiles() throws OptimaRetailApplicationException;
	List<EventFileMapVO> getSupportingFilesInfo(Long reqEventId) throws OptimaRetailApplicationException;
	Integer updateReqLogStatus(Long logId, String status) throws OptimaRetailApplicationException;
	Integer insertIntoFileLog(Long logId, List<String> recdFileNameList) throws OptimaRetailApplicationException;
	List<String> getAllFilesByReqLog(Long reqLodId) throws OptimaRetailApplicationException;
	public List<String> getAllFilesByBatchId(Long batchInstanceId)throws OptimaRetailApplicationException;
	String getControlFileByBatch(Long batchInstanceId) throws OptimaRetailApplicationException;
	String getControlFileByReqLogId(Long reqLogId) throws OptimaRetailApplicationException;

	Integer updateRequestEvent(Long logId, Long requestEvent)
			throws OptimaRetailApplicationException;
	
	int logProcessAudit(int fileId,String fileName, String type,boolean status,String comments, String dateValue);

	//boolean logInputFileAudit(Long auditFileId, String auditFiles, long longValue, String processedFiles,java.sql.Timestamp startTime);
	
	boolean logOutputFileAudit(final Long auditFileId, String trlFileName, final java.sql.Timestamp startTime, final long recordCount);
	public int logProcessAuditErrorStep(final int fileId, final String fileName, final String type, final boolean status,
			final String comments);

	void poppulateEmailContent(String validationType, String fileName, Map<String, String> argMap);

	int getCountForRunnableJobs();

	int getCountForRunningJobs();

	void insertRunningJobs(String product, String fileName);
	
	boolean isFileNameExists(String fileName);
	
}
