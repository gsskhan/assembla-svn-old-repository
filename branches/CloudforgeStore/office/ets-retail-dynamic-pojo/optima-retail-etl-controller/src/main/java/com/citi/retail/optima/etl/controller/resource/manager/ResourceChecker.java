package com.citi.retail.optima.etl.controller.resource.manager;

import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.db.dao.JobConfigDao;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;
import com.citi.retail.optima.etl.controller.model.BatchInstance;

/**
 * @author hs73849
 * 
 */
public class ResourceChecker {

	private JobInstanceHolder jobInstanceHolder;
	private JobConfigDao jobConfigDao;

	private int availableResourceCount;

	public boolean checkResourceAvailability(BatchInstance batchInstance)
			throws OptimaRetailApplicationException {
		try {
			return (availableResourceCount >= jobInstanceHolder
					.getAllocatedResourceCount()
					+ batchInstance.getThreadCount()) ? true : false;
		} catch (Exception exception) {

			throw new OptimaRetailApplicationException(null, null,
					batchInstance.getBatchInstanceId(), ServiceName.CONTROLLER,
					ExceptionType.ERROR,
					"Error when checking resource availability.",
					exception.getMessage(),
					OptimaRetailExceptionUtil.getStackTrace(exception),jobConfigDao);
		}
	}

	public void setJobInstanceHolder(JobInstanceHolder jobInstanceHolder) {
		this.jobInstanceHolder = jobInstanceHolder;
	}

	public JobInstanceHolder getJobInstanceHolder() {
		return jobInstanceHolder;
	}

	public int getAvailableResourceCount() {
		return availableResourceCount;
	}

	public void setAvailableResourceCount(int availableResourceCount) {
		this.availableResourceCount = availableResourceCount;
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
