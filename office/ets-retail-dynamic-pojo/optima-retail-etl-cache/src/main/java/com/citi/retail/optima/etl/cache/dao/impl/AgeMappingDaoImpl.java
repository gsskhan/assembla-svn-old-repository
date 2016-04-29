package com.citi.retail.optima.etl.cache.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

import com.citi.retail.optima.etl.cache.dao.CacheLoaderDao;
import com.citi.retail.optima.etl.cache.resultset.setter.AgeMappingResultSetExtractor;
import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;
import com.citi.retail.optima.etl.common.model.cache.SegmentMappingDomain;

/**
 * 
 * @author mc56120
 *
 */
public class AgeMappingDaoImpl implements
		CacheLoaderDao<SegmentMappingDomain>, InitializingBean {

	private JdbcTemplate jdbcTemplate;
	private List<SegmentMappingDomain> ageRefList;

	private String sql;

	public List<SegmentMappingDomain> getAgeDetails()
			throws OptimaRetailApplicationException {

		this.ageRefList = new ArrayList<SegmentMappingDomain>();
		try {
			this.ageRefList = this.jdbcTemplate.query(this.sql,
					new AgeMappingResultSetExtractor());

		} catch (Exception e) {
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					"Exception occured while Age Mapping Bands",
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));
		}
		return this.ageRefList;
	}

	@Override
	public List<SegmentMappingDomain> getCacheData(Object... args)
			throws Exception {
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
		getAgeDetails();

	}

}
