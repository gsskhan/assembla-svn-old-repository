package com.citi.retail.optima.etl.cache.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

import ch.qos.logback.classic.Logger;

import com.citi.retail.optima.etl.cache.dao.CacheLoaderDao;
import com.citi.retail.optima.etl.cache.resultset.setter.AgeResultSetExtractor;
import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;
import com.citi.retail.optima.etl.common.model.cache.AgeBandDomain;

/**
 * DAO class to load the AGE band from reference tables
 * @author mc56120
 *
 */
public class AgeBandDaoImpl implements CacheLoaderDao<AgeBandDomain>,
		InitializingBean {

	private final Logger LOGGER = (Logger) LoggerFactory
			.getLogger(AgeBandDaoImpl.class);
	private JdbcTemplate jdbcTemplate;
	private List<AgeBandDomain> ageRefList;

	private String sql;

	public List<AgeBandDomain> getCacheData() throws OptimaRetailApplicationException {

		this.ageRefList = new ArrayList<AgeBandDomain>();
		try {
			this.ageRefList = this.jdbcTemplate.query(this.sql,
					new AgeResultSetExtractor());

		} catch (Exception e) {
			this.LOGGER.error(" Exception occured while loading Age " + e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					"Exception occured while Age Bands",
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));
		}
		return this.ageRefList;
	}

	@Override
	public List<AgeBandDomain> getCacheData(Object... args) throws Exception {
		return this.ageRefList;
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
