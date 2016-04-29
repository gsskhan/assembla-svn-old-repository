package com.citi.retail.optima.etl.cache.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

import ch.qos.logback.classic.Logger;

import com.citi.retail.optima.etl.cache.dao.CacheLoaderDao;
import com.citi.retail.optima.etl.cache.resultset.setter.OrigLtvResultSetExtractor;
import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;
import com.citi.retail.optima.etl.common.model.cache.OrigLtvBandDomain;

/**
 * DAO class to load the Original LTV band from reference tables
 * @author mc56120
 *
 */
public class OrigLtvBandDaoImpl implements CacheLoaderDao<OrigLtvBandDomain>,
		InitializingBean {

	private final Logger LOGGER = (Logger) LoggerFactory
			.getLogger(OrigLtvBandDaoImpl.class);
	private JdbcTemplate jdbcTemplate;
	private List<OrigLtvBandDomain> origLtvRefList;

	private String sql;

	public List<OrigLtvBandDomain> getCacheData() throws OptimaRetailApplicationException {

		this.origLtvRefList = new ArrayList<OrigLtvBandDomain>();
		try {
			this.origLtvRefList = this.jdbcTemplate.query(this.sql,
					new OrigLtvResultSetExtractor());

		} catch (Exception e) {
			this.LOGGER.error(" Exception occured while loading LTV " + e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					"Exception occured while loading LTV",
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));
		}
		return this.origLtvRefList;
	}

	@Override
	public List<OrigLtvBandDomain> getCacheData(Object... args) throws Exception {
		return this.origLtvRefList;
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
