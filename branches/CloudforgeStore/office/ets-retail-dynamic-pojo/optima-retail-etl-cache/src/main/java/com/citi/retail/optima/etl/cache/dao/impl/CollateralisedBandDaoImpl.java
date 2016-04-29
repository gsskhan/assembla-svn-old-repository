package com.citi.retail.optima.etl.cache.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

import ch.qos.logback.classic.Logger;

import com.citi.retail.optima.etl.cache.dao.CacheLoaderDao;
import com.citi.retail.optima.etl.cache.resultset.setter.CollateralisedResultSetExtractor;
import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;
import com.citi.retail.optima.etl.common.model.cache.CollateralisedBandDomain;

/**
 * DAO class to load the AGE band from reference tables
 * @author mc56120
 *
 */
public class CollateralisedBandDaoImpl implements CacheLoaderDao<CollateralisedBandDomain>,
		InitializingBean {

	private final Logger LOGGER = (Logger) LoggerFactory
			.getLogger(CollateralisedBandDaoImpl.class);
	private JdbcTemplate jdbcTemplate;
	private List<CollateralisedBandDomain> collateralisedRefList;

	private String sql;

	public List<CollateralisedBandDomain> getCacheData() throws OptimaRetailApplicationException{

		this.collateralisedRefList = new ArrayList<CollateralisedBandDomain>();
		try {
			this.collateralisedRefList = this.jdbcTemplate.query(this.sql,
					new CollateralisedResultSetExtractor());

		} catch (Exception e) {
			this.LOGGER.error(" Exception occured while loading Collateralised Band " + e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					"Exception occured while loading Collateralised Band",
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));
		}
		return this.collateralisedRefList;
	}

	@Override
	public List<CollateralisedBandDomain> getCacheData(Object... args) throws Exception {
		return this.collateralisedRefList;
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
