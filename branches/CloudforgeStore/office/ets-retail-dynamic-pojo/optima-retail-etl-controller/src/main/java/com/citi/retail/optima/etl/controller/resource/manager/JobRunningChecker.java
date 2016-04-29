package com.citi.retail.optima.etl.controller.resource.manager;

import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.controller.model.BatchInstance;

/**
 * @author hs73849
 * 
 */
public class JobRunningChecker {

	private JobInstanceHolder jobInstanceHolder;

	public boolean checkJobRunningStatus(BatchInstance batchInstance)
			throws OptimaRetailApplicationException {

		return (jobInstanceHolder.getRunningJobsList().contains(batchInstance
				.getJobTypeId()
				+ "_"
				+ (batchInstance.getBatchId() != null ? batchInstance
						.getBatchId() : "")
				+ "_"
				+ (batchInstance.getPortfolioId() != null ? batchInstance
						.getPortfolioId() : ""))) ? true : false;

	}

	public void setJobInstanceHolder(JobInstanceHolder jobInstanceHolder) {
		this.jobInstanceHolder = jobInstanceHolder;
	}
}
