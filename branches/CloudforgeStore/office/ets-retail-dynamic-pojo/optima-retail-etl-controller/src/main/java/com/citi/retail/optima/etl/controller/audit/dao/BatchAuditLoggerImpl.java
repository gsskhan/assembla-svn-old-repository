package com.citi.retail.optima.etl.controller.audit.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;


public class BatchAuditLoggerImpl implements BatchAuditLogger{
	
	 
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int logProcessAudit(String fileName, String type, boolean status,
			String comments) {
		// TODO Auto-generated method stub
		Date date=new Date(System.currentTimeMillis());
		int reportingPeriod=0;
		
		String insertQuery="INSERT INTO TMP_RRC_AUDIT_PROC_AUD (cntl_file_id,cntl_File_nm,vldt_typ,vldt_sts,cmnts,crte_dt,rprt_prd)"
				+ " VALUES (TMP_RRC_AUDIT_PROC_ID.nextval,'"+fileName+"','"+type+"',"+1+",'"+comments+"',"+date+","+reportingPeriod+")";
		
		try {
			jdbcTemplate.execute(insertQuery);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return 0;
	}
	
	
	public int insertEmployee() {
		final String INSERT_SQL = "INSERT INTO TMP_RRC_AUDIT_PROC_AUD (cntl_file_id,cntl_File_nm,vldt_typ,vldt_sts,cmnts,crte_dt,rprt_prd) values(?,?,?,?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		getJdbcTemplate().update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL,
						new String[] { "employee_id" });
				ps.setString(1, "Yashwant");
				ps.setString(2, "Chavan");
				return ps;
			}
		}, keyHolder);

		return keyHolder.getKey().intValue();
	}
	
	public int logInputFileAudit(int CntFileId){
		return 0;
	}
	public static void main(String[] args) {
	
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


//	/**
//	 * @return the dataSource
//	 */
//	public DataSource getDataSource() {
//		return dataSource;
//	}
//
//	/**
//	 * @param dataSource the dataSource to set
//	 */
//	public void setDataSource(DataSource dataSource) {
//		this.dataSource = dataSource;
//	}
	public void setDataSource(DataSource dataSource)   
	 {   
	    this.jdbcTemplate = new JdbcTemplate(dataSource);   
	  }  
	
}
