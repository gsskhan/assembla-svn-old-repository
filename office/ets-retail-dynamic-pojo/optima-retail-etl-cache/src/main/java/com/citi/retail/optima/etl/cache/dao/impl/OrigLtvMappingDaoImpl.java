package com.citi.retail.optima.etl.cache.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

import com.citi.retail.optima.etl.cache.dao.CacheLoaderDao;
import com.citi.retail.optima.etl.cache.resultset.setter.OrigLtvMappingResultSetExtractor;
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
public class OrigLtvMappingDaoImpl implements
		CacheLoaderDao<SegmentMappingDomain>, InitializingBean {

	private JdbcTemplate jdbcTemplate;
	private List<SegmentMappingDomain> origLtvRefList;

	private String sql;

	public List<SegmentMappingDomain> getOrigLtvDetails()
			throws OptimaRetailApplicationException {

		this.origLtvRefList = new ArrayList<SegmentMappingDomain>();
		try {
			this.origLtvRefList = this.jdbcTemplate.query(this.sql,
					new OrigLtvMappingResultSetExtractor());

		} catch (Exception e) {
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					"Exception occured while loading LTV Mapping",
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));
		}
		return this.origLtvRefList;
	}

	@Override
	public List<SegmentMappingDomain> getCacheData(Object... args)
			throws Exception {
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
		getOrigLtvDetails();
	}

}
