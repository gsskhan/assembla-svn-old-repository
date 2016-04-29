package com.citi.retail.optima.etl.batch.dao;

import java.util.Date;
import java.util.List;

import com.citi.retail.optima.etl.common.ETLBatchStatus;
import com.citi.retail.optima.etl.common.model.FileInformation;

/**
 * Contract for fetching and updating details in the job instance tables.
 * 
 * @author ns21567
 * 
 */
public interface BatchJobInstanceDao {

	boolean updateBatchStatus(int jobInstance, ETLBatchStatus status);

	List<FileInformation> getFileInformation(int batchInstanceId);

	int getOriginalMessageId(int batchInstanceId);

	int getSysProcId(int batchDetlId);

	long getProcUnitId(long batchDetlId);
	
	void updateJobStatusAudit(String batchNm,String status, String comments,Date rptPrd);
}
