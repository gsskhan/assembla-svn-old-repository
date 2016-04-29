package com.citi.retail.optima.etl.batch.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.citi.retail.optima.etl.batch.dao.BatchJobDetailsDao;
import com.citi.retail.optima.etl.batch.vo.BatchDetailsVO;
import com.citi.retail.optima.etl.batch.vo.mappers.JobDetailsVoMapper;
import com.citi.retail.optima.etl.common.util.QueryConfigUtility;

/**
 * DAO class related to fetching all the job related details
 * 
 * @author ns21567
 * 
 */
public class BatchJobDetailsDaoImpl implements BatchJobDetailsDao {

	private JdbcTemplate jdbcTemplate;


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * Joins JobInstance, JobFeedInstance and JobDetails with JobFeedDetails to
	 * gather all the required details of a job to build job parameters and
	 * launch the job.
	 */
	@Override
	public BatchDetailsVO getBatchdetails(final int batchInstanceId) {

		List<BatchDetailsVO> detailsVOList = jdbcTemplate.query(
				QueryConfigUtility.getValue("batch.detl.query"), new PreparedStatementSetter() {

					@Override
					public void setValues(PreparedStatement ps)
							throws SQLException {
						ps.setInt(1, batchInstanceId);
					}
				}, new JobDetailsVoMapper());

		if (detailsVOList.size() > 0) {
			return detailsVOList.get(0);
		} else {
			return null;
		}

	}
	
	/**
	 * Method to get job id for a given instance of a job.
	 */
	@Override
	public int getBatchId(int batchInsatnceId) {

		int batchId = jdbcTemplate.queryForInt(QueryConfigUtility.getValue("batch.id.form.job.inst"),
				batchInsatnceId);
		return batchId;
	}

}
