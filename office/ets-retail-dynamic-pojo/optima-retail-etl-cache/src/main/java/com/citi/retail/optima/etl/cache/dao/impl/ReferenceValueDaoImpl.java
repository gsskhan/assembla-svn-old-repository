package com.citi.retail.optima.etl.cache.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

import ch.qos.logback.classic.Logger;

import com.citi.retail.optima.etl.cache.dao.CacheLoaderDao;
import com.citi.retail.optima.etl.cache.model.ReferenceValueRef;
import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;

/**
 * @author sr67841 This is the DAO class that loads the FICO from reference
 *         tables
 * 
 */
public class ReferenceValueDaoImpl implements
		CacheLoaderDao<ReferenceValueRef>, InitializingBean {

	private final Logger LOGGER = (Logger) LoggerFactory
			.getLogger(ReferenceValueDaoImpl.class);
	private JdbcTemplate jdbcTemplate;
	private List<ReferenceValueRef> ficoRefList;

	private String sql;

	public List<ReferenceValueRef> getFicoDetails()
			throws OptimaRetailApplicationException {

		ficoRefList = new ArrayList<ReferenceValueRef>();
		try {
			ficoRefList = jdbcTemplate.query(sql,
					new ReferenceValueResultSetExtractorNew());

		} catch (Exception e) {
			LOGGER.error(" Exception occured while loading FICO " + e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					"Exception occured while loading Reference Value",
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));
		}
		return ficoRefList;
	}

	@Override
	public List<ReferenceValueRef> getCacheData(Object... args)
			throws Exception {
		return ficoRefList;
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
		getFicoDetails();

	}

}
