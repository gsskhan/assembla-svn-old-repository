/**
 * 
 */
package com.citi.retail.optima.etl.cache.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import ch.qos.logback.classic.Logger;

import com.citi.retail.optima.etl.cache.dao.CacheLoaderDao;
import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;

/**
 * @author hp44940
 * 
 * @param <Integer, String> This is a generic DAO contract for direct lookup of Key to
 *        Value
 */
public class FedPortifolioCacheLoaderDaoImpl<K, V> implements
		CacheLoaderDao<Entry<Integer, V>>, InitializingBean {

	private final Logger LOGGER = (Logger) LoggerFactory
			.getLogger(FedPortifolioCacheLoaderDaoImpl.class);

	protected String sql;

	protected JdbcTemplate jdbcTemplate;

	@Override
	public Set<Entry<Integer, V>> getCacheData(Object... args) throws Exception {
		return getEntrySet();
	}

	/**
	 * 
	 * @param jdbcTemplate
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Set<Entry<Integer, V>> getEntrySet() throws OptimaRetailApplicationException {

		Set<Entry<Integer, V>> mapEntrySet;
		try {
			mapEntrySet = jdbcTemplate.query(sql,
					new ResultSetExtractor<Set<Entry<Integer, V>>>() {
						@SuppressWarnings("unchecked")
						@Override
						public Set<Entry<Integer, V>> extractData(ResultSet rs)
								throws SQLException {
							Map<Integer, V> tempMap = new HashMap<Integer, V>();
							while (rs.next()) {
								tempMap.put(rs.getInt(1), (V)rs.getObject(2));								
							}
							return tempMap.entrySet();
						}
					});

		} catch (Exception e) {
			LOGGER.error(" Exception occured while loading single value cache "
					+ e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					"Exception occured while loading single value cache",
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));
		}
		return mapEntrySet;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		LOGGER.debug("Cache Loader SQL=" + sql);
	}

}
