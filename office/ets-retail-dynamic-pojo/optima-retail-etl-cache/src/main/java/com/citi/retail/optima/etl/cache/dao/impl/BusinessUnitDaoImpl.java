package com.citi.retail.optima.etl.cache.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import ch.qos.logback.classic.Logger;

import com.citi.retail.optima.etl.cache.dao.CacheLoaderDao;
import com.citi.retail.optima.etl.cache.ehcache.OptimaCacheUtil;

public class BusinessUnitDaoImpl implements CacheLoaderDao<Entry<String,Integer>> {
	/**
	 * @param jdbcTemplate the jdbcTemplate to set
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	/**
	 * @param sql the sql to set
	 */
	public void setSql(String sql) {
		this.sql = sql;
	}

	private JdbcTemplate jdbcTemplate;

	private String sql;	
	@Override
	public Set<Entry<String,Integer>> getCacheData(Object... args)
			throws Exception {
		Set<Entry<String, Integer>>  mapEntrySet;
		mapEntrySet = jdbcTemplate
				.query(sql,
						new ResultSetExtractor<Set<Map.Entry<String, Integer>>>() {
					@SuppressWarnings("unchecked")
					@Override
					public Set<Entry<String,Integer>> extractData(
							ResultSet rs) throws SQLException {
						Map<String, Integer> tempMap = new HashMap<String, Integer>();
						while (rs.next()) {
							tempMap.put(OptimaCacheUtil
									.keyCreator(rs.getString(3), rs.getString(2)),rs.getInt(1));							
						}
						return tempMap.entrySet();
					}
				});
		return mapEntrySet;
	}
}
