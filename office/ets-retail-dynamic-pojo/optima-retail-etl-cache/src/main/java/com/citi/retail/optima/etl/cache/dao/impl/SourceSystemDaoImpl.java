package com.citi.retail.optima.etl.cache.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

import ch.qos.logback.classic.Logger;

import com.citi.retail.optima.etl.cache.dao.CacheLoaderDao;
import com.citi.retail.optima.etl.cache.resultset.setter.SourceSysSetExtractor;
import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;
import com.citi.retail.optima.etl.common.model.cache.SourceSystemDomain;

/**
 * @author sr67841 This is the DAO class that loads the FICO from reference
 *         tables
 * 
 */
public class SourceSystemDaoImpl implements CacheLoaderDao<SourceSystemDomain>,
		InitializingBean {

	private final Logger LOGGER = (Logger) LoggerFactory
			.getLogger(SourceSystemDaoImpl.class);
	private JdbcTemplate jdbcTemplate;
	private List<SourceSystemDomain> srcSysRefList;

	private String sql;

	public List<SourceSystemDomain> getCacheData()
			throws OptimaRetailApplicationException {

		srcSysRefList = new ArrayList<SourceSystemDomain>();
		try {
			srcSysRefList = jdbcTemplate
					.query(sql, new SourceSysSetExtractor());

		} catch (Exception e) {
			LOGGER.error(" Exception occured while loading Src Sys " + e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					"Exception occured while loading Src Sys", e.getMessage(),
					OptimaRetailExceptionUtil.getStackTrace(e));
		}
		return srcSysRefList;
	}

	@Override
	public List<SourceSystemDomain> getCacheData(Object... args)
			throws Exception {
		return srcSysRefList;
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
