package com.citi.retail.optima.etl.integration.test.dao.impl;

import java.math.BigInteger;
import java.sql.Types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.citi.retail.optima.etl.integration.test.dao.IntegrationTestDao;



public class IntegrationTestDaoImpl implements IntegrationTestDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(IntegrationTestDaoImpl.class);
		
	
	private SimpleJdbcCall jdbcCall;
	
	private JdbcTemplate jdbcTemplate;
	
	public void init() throws Exception {
		this.jdbcCall = new SimpleJdbcCall(this.jdbcTemplate.getDataSource())
				.withProcedureName("ORC_COMP_ENRCH_AGG_CCAR_PRC").declareParameters(
						new SqlParameter("P_BATCH_INST_ID", Types.BIGINT));
	}
	
	@Override
	public void testBatchJob(BigInteger batchInstanceId) throws Exception {
		MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
		sqlParameterSource.addValue("P_BATCH_INST_ID",batchInstanceId, Types.BIGINT);
		this.jdbcCall.execute(sqlParameterSource);
		LOGGER.debug("ORC_COMP_ENRCH_AGG_CCAR_PRC invoked ~ Batch instance id:"+batchInstanceId);
	}
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


}
