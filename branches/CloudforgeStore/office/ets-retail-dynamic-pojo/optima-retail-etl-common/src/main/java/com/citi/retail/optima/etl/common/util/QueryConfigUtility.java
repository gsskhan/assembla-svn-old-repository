package com.citi.retail.optima.etl.common.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

public class QueryConfigUtility implements InitializingBean{

	private JdbcTemplate jdbcTemplate;
	private static Map<String,String> queryMap;
	@Override
	public void afterPropertiesSet() throws Exception {
		init();
		
	}

	private void init() {
		String getSqlQuerires = "SELECT QUERY_NAME, QUERY_TO_EXEC FROM HDA_QUERY_CONFIG WHERE EFF_STS='A'";
		ResultSetExtractor<Map<String,String>> resultSetExtractor = new ResultSetExtractor<Map<String,String>>() {
						
			@Override
			public Map<String, String> extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				Map<String,String> queryDetails = new HashMap<String, String>();
				while(rs.next()){
					String queryName = rs.getString("QUERY_NAME").trim();
					String queryToExec = rs.getString("QUERY_TO_EXEC").trim();
					queryDetails.put(queryName,queryToExec);
				}
				return queryDetails;
			}
		};
		queryMap = jdbcTemplate.query(getSqlQuerires, resultSetExtractor);
	}
	
	public static String getValue(String key){
		return queryMap.get(key);
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

	/**
	 * @return the queryMap
	 */
	public static Map<String, String> getQueryMap() {
		return queryMap;
	}

	/**
	 * @param queryMap the queryMap to set
	 */
	public static void setQueryMap(Map<String, String> queryMap) {
		QueryConfigUtility.queryMap = queryMap;
	}

	
}
