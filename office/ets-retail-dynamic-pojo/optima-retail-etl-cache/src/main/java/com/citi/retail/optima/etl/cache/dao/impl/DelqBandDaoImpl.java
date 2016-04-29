package com.citi.retail.optima.etl.cache.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

import ch.qos.logback.classic.Logger;

import com.citi.retail.optima.etl.cache.dao.CacheLoaderDao;
import com.citi.retail.optima.etl.cache.resultset.setter.DelqResultSetExtractor;
import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;
import com.citi.retail.optima.etl.common.model.cache.DelqBandDomain;

/**
 * 
 */
public class DelqBandDaoImpl implements CacheLoaderDao<DelqBandDomain>,
		InitializingBean {

	private final Logger LOGGER = (Logger) LoggerFactory
			.getLogger(DelqBandDaoImpl.class);
	private JdbcTemplate jdbcTemplate;
	private List<DelqBandDomain> delqRefList;

	private String sql;

	public List<DelqBandDomain> getCacheData() throws OptimaRetailApplicationException {

		this.delqRefList = new ArrayList<DelqBandDomain>();
		try {
			this.delqRefList = this.jdbcTemplate.query(this.sql,
					new DelqResultSetExtractor());

		} catch (Exception e) {
			this.LOGGER.error("Exception occured while loading Delq " + e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					"Exception occured while loading Delq",
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));
		}
		return this.delqRefList;
	}

	@Override
	public List<DelqBandDomain> getCacheData(Object... args) throws Exception {
		return this.delqRefList;
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

	@Override
	public void afterPropertiesSet() throws Exception {
		getCacheData();

	}

}
