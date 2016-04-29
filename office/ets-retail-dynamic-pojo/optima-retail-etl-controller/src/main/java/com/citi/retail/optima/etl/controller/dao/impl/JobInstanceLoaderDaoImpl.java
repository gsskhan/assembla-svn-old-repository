package com.citi.retail.optima.etl.controller.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.db.dao.JobConfigDao;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;
import com.citi.retail.optima.etl.common.util.QueryConfigUtility;
import com.citi.retail.optima.etl.controller.dao.JobInstanceLoaderDao;
import com.citi.retail.optima.etl.controller.model.BatchInstance;
import com.citi.retail.optima.etl.controller.resource.manager.JobInstanceLoader;

/**
 * @author hs73849
 * 
 */
public class JobInstanceLoaderDaoImpl implements JobInstanceLoaderDao {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(JobInstanceLoader.class);

	private JdbcTemplate jdbcTemplate;
	private JobConfigDao jobConfigDao;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<BatchInstance> getAllJobs()
			throws OptimaRetailApplicationException {
		List<BatchInstance> jobsList = null;
		//System.out.println("********************* JobInstanceLoaderDaoImpl.getAllJobs() ****************** ");
		try {
			
			jdbcTemplate.update(QueryConfigUtility.getValue("job.instance.clear.query"));
			
			jobsList = jdbcTemplate.query(QueryConfigUtility.getValue("job.instance.loader.query"),
					new RowMapper<BatchInstance>() {
						@Override
						public BatchInstance mapRow(ResultSet rs, int rowNum)
								throws SQLException {
							BatchInstance batchInstanceVO = new BatchInstance();
							setBatchJobValues(batchInstanceVO, rs);
							return batchInstanceVO;
						}
					});
		} catch (Exception e) {
			LOGGER.error(" Error while loading the job instance details for Resource Manager "
					+ e);
			throw new OptimaRetailApplicationException(
					null,
					null,
					null,
					ServiceName.CONTROLLER,
					ExceptionType.ERROR,
					"Error while loading the job instance details for Resource Manager",
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e),jobConfigDao);
		}
		return jobsList;
	}

	/**
	 * @param batchInstanceVO
	 * @param rs
	 * @throws SQLException
	 */

	private void setBatchJobValues(BatchInstance batchInstanceVO, ResultSet rs)
			throws SQLException {
		batchInstanceVO.setBatchId(rs.getLong("BTH_ID"));
		batchInstanceVO.setBatchInstanceId(rs.getLong("BTH_INST_ID"));
		batchInstanceVO.setCurrentPriority(rs.getInt("CURR_PRIORITY"));
		batchInstanceVO.setThreadCount(2);
		batchInstanceVO.setJobTypeId(rs.getLong("JOB_TYP_ID"));
		batchInstanceVO.setStatus(rs.getString("STS_CD"));
		batchInstanceVO.setJobId(rs.getLong("JOB_ID"));

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
