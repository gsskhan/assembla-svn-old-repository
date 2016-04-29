package com.citi.retail.optima.etl.common.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.citi.retail.optima.etl.common.util.QueryConfigUtility;

public class JobConfigDao {
	private JdbcTemplate jdbcTemplate;
	
	public void clearRunningEntries(final String ctlFileName) {
		if(ctlFileName != null){
			jdbcTemplate.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection con)
						throws SQLException {
					PreparedStatement ps = con.prepareStatement(QueryConfigUtility.getValue("query.to.delete.completed.job"));
					ps.setString(1, ctlFileName);
					return ps;
				}
			});
		}
	}
			
	public Long getRequestLogId(Long batchInstanceId){
				Object [] args = {batchInstanceId};
				int [] argTypes = new int[]{Types.INTEGER};
				Long reqLogId = jdbcTemplate.queryForLong(QueryConfigUtility.getValue("message.reqlog.query"), args, argTypes);		
				return reqLogId;
	}

	/**
	 * @return the jdbcTemplate
	 */
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	/**
	 * @param jdbcTemplate the jdbcTemplate to set
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public String getControlFileNameByReqLogId(Long requestLogId) {
		Object [] args = {requestLogId};
		int [] argTypes = new int[]{Types.INTEGER};
		String fileName = jdbcTemplate.queryForObject(QueryConfigUtility.getValue("query.to.get.ctl.file.req.log"), args,argTypes,String.class);		
		return fileName;
	}
	
	
}
