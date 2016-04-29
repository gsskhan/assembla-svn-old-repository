package com.citi.retail.optima.etl.cache.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

import com.citi.retail.optima.etl.cache.dao.CacheLoaderDao;
import com.citi.retail.optima.etl.cache.resultset.setter.DelqMappingResultSetExtractor;
import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;
import com.citi.retail.optima.etl.common.model.cache.SegmentMappingDomain;

/**
 * @author ns21567 This is the DAO class that loads the FICO from reference
 *         tables
 * 
 */
public class DelqMappingDaoImpl implements
		CacheLoaderDao<SegmentMappingDomain>, InitializingBean {

	private JdbcTemplate jdbcTemplate;
	private List<SegmentMappingDomain> delqRefList;

	private String sql;

	public List<SegmentMappingDomain> getDelqDetails()
			throws OptimaRetailApplicationException {

		this.delqRefList = new ArrayList<SegmentMappingDomain>();
		try {
			this.delqRefList = this.jdbcTemplate.query(this.sql,
					new DelqMappingResultSetExtractor());

		} catch (Exception e) {
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					"Exception occured while loading Delq Mapping",
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));
		}
		return this.delqRefList;
	}

	@Override
	public List<SegmentMappingDomain> getCacheData(Object... args)
			throws Exception {
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
		getDelqDetails();

	}

}
