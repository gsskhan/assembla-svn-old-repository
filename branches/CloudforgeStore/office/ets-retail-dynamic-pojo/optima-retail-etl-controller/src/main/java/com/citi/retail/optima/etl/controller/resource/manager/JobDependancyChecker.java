package com.citi.retail.optima.etl.controller.resource.manager;

import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.controller.dao.JobDependancyDao;
import com.citi.retail.optima.etl.controller.model.BatchInstance;

/**
 * @author hs73849
 * 
 */
public class JobDependancyChecker {

	private JobDependancyDao jobDependancyDao;

	public JobDependancyDao getJobDependancyDao() {
		return jobDependancyDao;
	}

	public boolean checkJobDependancies(BatchInstance batchbInstance,
			Long jobInstanceId) throws OptimaRetailApplicationException {
		boolean isJobDependanciesAvailable = false;
		try {
			isJobDependanciesAvailable = jobDependancyDao
					.isJobTypeDependencyAvailable(
							batchbInstance.getJobTypeId(), jobInstanceId);
		} catch (OptimaRetailApplicationException e) {
			isJobDependanciesAvailable = false;
		}
		return isJobDependanciesAvailable;
	}

	public void setJobDependancyDao(JobDependancyDao jobDependancyDao) {
		this.jobDependancyDao = jobDependancyDao;
	}
}
