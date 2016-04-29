package com.citi.retail.optima.etl.cache.dao.impl;

import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import ch.qos.logback.classic.Logger;

import com.citi.retail.optima.etl.cache.dao.CacheLoaderDao;
import com.citi.retail.optima.etl.cache.model.BaseRef;
import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;

/**
 * @author sr67841 This is the DAO class that loads the Product from reference
 *         tables
 * 
 */
public class ProductDaoImpl implements
		CacheLoaderDao<Entry<BaseRef, Map<String, String>>> {

	private final Logger LOGGER = (Logger) LoggerFactory
			.getLogger(ProductDaoImpl.class);
	private JdbcTemplate jdbcTemplate;

	private String sql;

	public Set<Entry<BaseRef, Map<String, String>>> getProductDetails()
			throws OptimaRetailApplicationException {

		Set<Entry<BaseRef, Map<String, String>>> productRefList = new HashSet<Entry<BaseRef, Map<String, String>>>();
		try {
			productRefList = jdbcTemplate.query(sql,
					new ReferenceValueResultSetExtractor());

		} catch (Exception e) {
			LOGGER.error(" Exception occured while loading Product " + e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					"Exception occured while loading Product", e.getMessage(),
					OptimaRetailExceptionUtil.getStackTrace(e));
		}
		return productRefList;
	}

	@Override
	public Set<Entry<BaseRef, Map<String, String>>> getCacheData(Object... args)
			throws Exception {
		return getProductDetails();
	}

	/**
	 * 
	 * @param jdbcTemplate
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * @param sQL
	 *            the sQL to set
	 */
	public void setSql(String sql) {
		this.sql = sql;
	}

}
