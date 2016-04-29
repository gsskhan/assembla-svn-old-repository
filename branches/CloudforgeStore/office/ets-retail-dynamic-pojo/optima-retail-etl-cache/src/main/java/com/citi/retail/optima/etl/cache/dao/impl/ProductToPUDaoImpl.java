package com.citi.retail.optima.etl.cache.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import ch.qos.logback.classic.Logger;

import com.citi.retail.optima.etl.cache.dao.CacheLoaderDao;
import com.citi.retail.optima.etl.cache.ehcache.OptimaCacheUtil;
import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;

/**
 * @author mc56120
 * 
 */
public class ProductToPUDaoImpl implements
		CacheLoaderDao<Entry<String, List<Integer>>> {

	private final Logger LOGGER = (Logger) LoggerFactory
			.getLogger(ProductToPUDaoImpl.class);
	protected String sql;
	protected JdbcTemplate jdbcTemplate;

	@Override
	public Set<Entry<String, List<Integer>>> getCacheData(Object... args)
			throws Exception {
		return getEntrySet();
	}

	/**
	 * 
	 * @return
	 * @throws OptimaRetailException
	 */
	public Set<Entry<String, List<Integer>>> getEntrySet()
			throws OptimaRetailApplicationException {

		Set<Entry<String, List<Integer>>> mapEntrySet;
		try {
			mapEntrySet = jdbcTemplate
					.query(sql,
							new ResultSetExtractor<Set<Map.Entry<String, List<Integer>>>>() {
								@SuppressWarnings("unchecked")
								@Override
								public Set<Entry<String, List<Integer>>> extractData(
										ResultSet rs) throws SQLException {
									Map<String, List<Integer>> tempMap = new HashMap<String, List<Integer>>();
									while (rs.next()) {
										List<Integer> valList = tempMap.get(OptimaCacheUtil.keyCreator(rs.getString(1),rs.getString(2)));
										if (valList == null) {
											valList = new ArrayList<Integer>();
										}
										valList.add(rs.getInt(3));
										tempMap.put(OptimaCacheUtil.keyCreator(rs.getString(1),rs.getString(2)), valList);
									}
									return tempMap.entrySet();
								}
							});

		} catch (Exception e) {
			LOGGER.error(" Exception occured while loading product to Processing Unit "
					+ e);
			throw new OptimaRetailApplicationException(
					null,
					null,
					null,
					ServiceName.CACHE,
					ExceptionType.ERROR,
					"Exception occured while loading product to Processing Unit",
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));
		}
		return mapEntrySet;
	}

	/**
	 * 
	 * @param jdbcTemplate
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

}
