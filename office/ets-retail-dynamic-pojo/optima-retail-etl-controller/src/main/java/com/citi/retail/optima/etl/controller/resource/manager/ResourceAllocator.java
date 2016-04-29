package com.citi.retail.optima.etl.controller.resource.manager;

import com.citi.retail.optima.etl.common.ETLBatchStatus;
import com.citi.retail.optima.etl.controller.dao.JobInstanceDao;
import com.citi.retail.optima.etl.controller.model.BatchInstance;

/**
 * @author hs73849
 * 
 */
public class ResourceAllocator {

	private JobInstanceHolder jobInstanceHolder;
	private JobInstanceDao jobInstanceDao;

	public void allocateReources(BatchInstance batchInstance) throws Exception {
		this.jobInstanceDao.updateJobRunningStatus(
				batchInstance.getBatchInstanceId(),batchInstance.getJobId(), ETLBatchStatus.JOB_INT);
		this.jobInstanceHolder.setAllocatedResourceCount(this.jobInstanceHolder
				.getAllocatedResourceCount() + batchInstance.getThreadCount());
		this.jobInstanceHolder.getRunningJobsList().add(
				batchInstance.getJobTypeId()
				+ "_"
				+ (batchInstance.getBatchId() != null ? batchInstance.getBatchId() : "")
				+ "_"
				+ (batchInstance.getPortfolioId() != null ? batchInstance.getPortfolioId() : ""));
	}

	public void setJobInstanceHolder(JobInstanceHolder jobInstanceHolder) {
		this.jobInstanceHolder = jobInstanceHolder;
	}

	public void setJobInstanceDao(JobInstanceDao jobInstanceDao) {
		this.jobInstanceDao = jobInstanceDao;
	}

	public JobInstanceHolder getJobInstanceHolder() {
		return jobInstanceHolder;
	}

	public JobInstanceDao getJobInstanceDao() {
		return jobInstanceDao;
	}
}
