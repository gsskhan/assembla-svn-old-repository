package com.citi.retail.optima.etl.controller.dao.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;

import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.db.dao.JobConfigDao;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;
import com.citi.retail.optima.etl.common.util.QueryConfigUtility;
import com.citi.retail.optima.etl.controller.ControllerQueryConstants;
import com.citi.retail.optima.etl.controller.dao.JobDependancyDao;

/**
 * @author hs73849 This class will fetch all the dependent jobs for all the job
 *         ids. Correlated sub query between orc_job_typ_dpnc_map & orc_job_detl
 *         will fetch all the dependent type id. Then the self join with
 *         orc_job_detl table will return the all the dependent job id's.
 * 
 */
public class JobDependancyDaoImpl implements JobDependancyDao {

	private JdbcTemplate jdbcTemplate;
	private JobConfigDao jobConfigDao;
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public boolean isJobTypeDependencyAvailable(Long jobTypeId,
			Long jobInstanceId) throws OptimaRetailApplicationException {
		Integer isJobTypeDependencyAvailable = null;

		try {
			isJobTypeDependencyAvailable = jdbcTemplate.queryForObject(
					QueryConfigUtility.getValue("job.dependency.query"),
					new Object[] { jobTypeId }, Integer.class);
		} catch (Exception exception) {
			throw new OptimaRetailApplicationException(null, jobInstanceId,
					null, ServiceName.CONTROLLER, ExceptionType.ERROR,
					" Exception occurred for Job Type id " + jobTypeId,
					exception.getMessage(),
					OptimaRetailExceptionUtil.getStackTrace(exception),jobConfigDao);
		}
		return (isJobTypeDependencyAvailable == 0) ? true : false;
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
