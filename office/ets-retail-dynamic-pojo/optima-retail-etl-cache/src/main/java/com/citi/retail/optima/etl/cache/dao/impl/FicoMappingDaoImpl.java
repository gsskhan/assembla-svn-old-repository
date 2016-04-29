package com.citi.retail.optima.etl.cache.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

import com.citi.retail.optima.etl.cache.dao.CacheLoaderDao;
import com.citi.retail.optima.etl.cache.resultset.setter.FicoMappingResultSetExtractor;
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
public class FicoMappingDaoImpl implements
		CacheLoaderDao<SegmentMappingDomain>, InitializingBean {

	private JdbcTemplate jdbcTemplate;
	private List<SegmentMappingDomain> ficoRefList;

	private String sql;

	public List<SegmentMappingDomain> getFicoDetails()
			throws OptimaRetailApplicationException {

		this.ficoRefList = new ArrayList<SegmentMappingDomain>();
		try {
			this.ficoRefList = this.jdbcTemplate.query(this.sql,
					new FicoMappingResultSetExtractor());

		} catch (Exception e) {
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					"Exception occured while loading FICO Mapping",
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));
		}
		return this.ficoRefList;
	}

	@Override
	public List<SegmentMappingDomain> getCacheData(Object... args)
			throws Exception {
		return this.ficoRefList;
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
