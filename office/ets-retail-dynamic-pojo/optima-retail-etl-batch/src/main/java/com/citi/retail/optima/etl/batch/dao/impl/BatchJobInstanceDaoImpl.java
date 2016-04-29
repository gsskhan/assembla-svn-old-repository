package com.citi.retail.optima.etl.batch.dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import com.citi.retail.optima.etl.batch.dao.BatchJobInstanceDao;
import com.citi.retail.optima.etl.common.ETLBatchStatus;
import com.citi.retail.optima.etl.common.model.FileInformation;
import com.citi.retail.optima.etl.common.util.QueryConfigUtility;

public class BatchJobInstanceDaoImpl implements BatchJobInstanceDao {

	private JdbcTemplate jdbcTemplate;


	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public boolean updateBatchStatus(final int batchInstance,
			final ETLBatchStatus status) {

		int updateCount = 0;
		String updateQuery;
		if (ETLBatchStatus.BTH_STRT.compareTo(status) == 0) {
			updateQuery = QueryConfigUtility.getValue("batch.status.query");
		} else {
			updateQuery = QueryConfigUtility.getValue("batch.end.status.query");
		}

		updateCount = jdbcTemplate.update(updateQuery,
				new PreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement ps)
							throws SQLException {
						ps.setString(1, status.toString());
						ps.setDate(2, new Date(System.currentTimeMillis()));
						ps.setInt(3, batchInstance);
					}
				});

		return updateCount > 0 ? true : false;
	}

	@Override
	public List<FileInformation> getFileInformation(final int batchInstanceId) {
		List<FileInformation> fileInformation = jdbcTemplate.query(QueryConfigUtility.getValue("job.file.info"),
				new PreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement ps)
							throws SQLException {
						ps.setInt(1, batchInstanceId);
					}
				}, new RowMapper<FileInformation>() {

					@Override
					public FileInformation mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						FileInformation fileInformation = new FileInformation();
						fileInformation.setFileName("input_file_name_exp");
						return fileInformation;
					}
				});
		return fileInformation;
	}

	@Override
	public int getSysProcId(int batchDetlId) {
		return jdbcTemplate.queryForInt(QueryConfigUtility.getValue("sys_proc.id"), batchDetlId);
	}

	@Override
	public long getProcUnitId(long batchDetlId) {
		return jdbcTemplate.queryForLong(QueryConfigUtility.getValue("proc_unit_id"), batchDetlId);
	}

	@Override
	public int getOriginalMessageId(int batchInstanceId) {
		int originalMessageId = jdbcTemplate.queryForInt(QueryConfigUtility.getValue("job.orig.msg.id.query"),
				batchInstanceId);
		return originalMessageId;
	}

	@Override
	public void updateJobStatusAudit(final String batchNm, final String status,
			final String comments, final java.util.Date rptPrd) {
		jdbcTemplate.update(QueryConfigUtility.getValue("job.audit.query"),
				new PreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement ps)
							throws SQLException {
						ps.setString(1, batchNm);
						ps.setString(2, status);
						ps.setString(3, comments);
						ps.setDate(4, new java.sql.Date(rptPrd.getTime()));
						ps.setTimestamp(5,new java.sql.Timestamp(System.currentTimeMillis()));
					}
				});

	}

}
