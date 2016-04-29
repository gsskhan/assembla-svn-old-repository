package com.citi.retail.optima.etl.controller.resource.manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.citi.retail.optima.etl.common.ETLBatchStatus;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.controller.dao.JobInstanceLoaderDao;
import com.citi.retail.optima.etl.controller.model.BatchInstance;

/**
 * @author gv74035
 * 
 *         This class will load all the jobs for the given report period and
 *         Segregate the jobs with following status. 1. Running 2. Completed 3.
 *         Waiting Within the waiting jobs, this class will pull the high
 *         priority jobs in order and send back to resource manager for further
 *         checks like resource available...etc
 * 
 */
public class JobInstanceLoader {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(JobInstanceLoader.class);

	private JobInstanceHolder jobInstanceHolder;
	private JobInstanceLoaderDao jobInstanceLoaderDao;

	public JobInstanceHolder getJobInstanceHolder() {
		return this.jobInstanceHolder;
	}

	public void setJobInstanceHolder(JobInstanceHolder jobInstanceHolder) {
		this.jobInstanceHolder = jobInstanceHolder;
	}

	public JobInstanceLoaderDao getJobInstanceLoaderDao() {
		return this.jobInstanceLoaderDao;
	}

	public void setJobInstanceLoaderDao(
			JobInstanceLoaderDao jobInstanceLoaderDao) {
		this.jobInstanceLoaderDao = jobInstanceLoaderDao;
	}

	public JobInstanceHolder loadJobInstances()
			throws OptimaRetailApplicationException {

		List<BatchInstance> batchInstanceVOList = this.jobInstanceLoaderDao
				.getAllJobs();

		List<BatchInstance> waitingJobList = new ArrayList<BatchInstance>();
		int allocatedResourceCount = 0;

		this.jobInstanceHolder.getRunningJobsList().clear();
		this.jobInstanceHolder.getWaitingJobsList().clear();
		this.jobInstanceHolder.getCompletedJobsList().clear();

		for (BatchInstance batchInstance : batchInstanceVOList) {
			if (ETLBatchStatus.JOB_INT.name().equals(batchInstance.getStatus())
					|| ETLBatchStatus.BTH_STRT.name().equals(
							batchInstance.getStatus())) {
				
				this.jobInstanceHolder.getRunningJobsList()
						.add(batchInstance.getJobTypeId()
								+ "_"
								+ (batchInstance.getBatchId() != null ? batchInstance.getBatchId() : "")
								+ "_"
								+ (batchInstance.getPortfolioId() != null ? batchInstance.getPortfolioId() : ""));
				allocatedResourceCount += batchInstance.getThreadCount();
			} else if (ETLBatchStatus.BTH_COMP.name().equals(
					batchInstance.getStatus())
					|| ETLBatchStatus.JOB_COMP.name().equals(
							batchInstance.getStatus())) {
				
				this.jobInstanceHolder.getCompletedJobsList().add(
						batchInstance.getBatchId());
			} else if (ETLBatchStatus.JOB_WAIT.name().equals(
					batchInstance.getStatus())) {
				
				waitingJobList.add(batchInstance);
			}
		}
		LOGGER.debug("Total No of Job waiting in Controller Module : " + waitingJobList.size());
		this.jobInstanceHolder.setAllocatedResourceCount(allocatedResourceCount);
		Collections.sort(waitingJobList, new JobInstanceComparator());
		this.jobInstanceHolder.getWaitingJobsList().addAll(waitingJobList);
		return this.jobInstanceHolder;
	}
}
