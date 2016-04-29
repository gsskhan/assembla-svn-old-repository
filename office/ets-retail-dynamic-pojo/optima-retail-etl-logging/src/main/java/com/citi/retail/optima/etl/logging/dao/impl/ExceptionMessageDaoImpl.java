package com.citi.retail.optima.etl.logging.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;

import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.OptimaRetailDataException;
import com.citi.retail.optima.etl.common.exception.OptimaRetailDataExceptionDetail;
import com.citi.retail.optima.etl.logging.dao.ExceptionMessageDao;

/**
 * @author hs73849 Implementation class for Persisting the Exception Message
 *         into Database.
 */
public class ExceptionMessageDaoImpl implements ExceptionMessageDao {

	private Connection connection = null;
	private ArrayDescriptor arrayDescriptor = null;
	private StructDescriptor structDescriptor = null;

	private static final String EXCEPTION_TYP_ARRAY = "RRC_ACCT_LVL_EXCP_TYP_ARRAY";	
	private static final String EXCEPTION_TYPE_STRUCT = "RRC_ACCT_LVL_EXCP_TYP";
	private static final int OBJECT_SIZE = 3;

	private JdbcTemplate jdbcTemplate;

	/**
	 * @param jdbcTemplate
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * @throws SQLException
	 * 
	 */
	public void init() throws SQLException {
		connection = jdbcTemplate.getDataSource().getConnection();
		arrayDescriptor = ArrayDescriptor.createDescriptor(EXCEPTION_TYP_ARRAY,
				connection);
		structDescriptor = StructDescriptor.createDescriptor(
				EXCEPTION_TYPE_STRUCT, connection);
		
	}

	

	
	public boolean saveException(OptimaRetailApplicationException optimaRetailApplicationException,String exceptionJsonString)
			throws Exception {
		
		

		if (connection == null) {
			init();
		}
		Object[] recObj = null;
		OptimaRetailDataException optimaRetailDataException = optimaRetailApplicationException.getDataException();
		int iSize = optimaRetailDataException.getOptimaRetailSkippableList() == null ? 0
				: optimaRetailDataException.getOptimaRetailSkippableList().size();

		List<OptimaRetailDataExceptionDetail> records = optimaRetailDataException
				.getOptimaRetailSkippableList();

		
		

		ARRAY arr = null;
		STRUCT[] structArr = null;

		int i = 0;

		recObj = new Object[OBJECT_SIZE];
		structArr = new STRUCT[iSize];

		if (records != null) {
			for (OptimaRetailDataExceptionDetail optimaRetailExceptionDetail : records) {
				recObj[0] = optimaRetailExceptionDetail.getAttributeName();
				if (optimaRetailExceptionDetail.getExceptionType() != null) {
					recObj[1] = optimaRetailExceptionDetail.getExceptionType()
							.toString();
				}
				recObj[2] = optimaRetailExceptionDetail.getExceptionMessage();
				structArr[i++] = new STRUCT(structDescriptor, connection,
						recObj);
			}
		}
		arr = new ARRAY(arrayDescriptor, connection, structArr);
		
			
		LobHandler lobHandler = new DefaultLobHandler();

		
		jdbcTemplate.update("{call rrc_exception_proc(?,?,?,?,?,?,?,?,?)}",
				new Object[] {
						optimaRetailApplicationException.getRequestLogId(),
						optimaRetailApplicationException.getJobInstanceId(),
						optimaRetailApplicationException.getBatchInstanceId(),
						optimaRetailApplicationException.getServiceName().toString(),
						optimaRetailApplicationException.getExceptionType().toString(),
						new SqlLobValue(exceptionJsonString,
								lobHandler), Integer.valueOf(999),optimaRetailApplicationException.getRootException() ,arr }, new int[] { Types.BIGINT,
						Types.BIGINT, Types.BIGINT, Types.VARCHAR,
						Types.VARCHAR, Types.BLOB,Types.INTEGER, Types.VARCHAR, Types.ARRAY });

		return true;
	}

	
	

	
}
