/**
 * 
 */
package com.citi.retail.optima.etl.cache.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

import ch.qos.logback.classic.Logger;

import com.citi.retail.optima.etl.cache.dao.CacheLoaderDao;
import com.citi.retail.optima.etl.cache.model.GeographyFedSegVO;
import com.citi.retail.optima.etl.cache.resultset.setter.GeographyFedSegResultSetExtractor;
import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;


/**
 * @author mc56120
 *
 */

public class GeographyFedSegDaoImpl implements CacheLoaderDao<GeographyFedSegVO>,
InitializingBean {
	private final Logger LOGGER = (Logger) LoggerFactory
			.getLogger(GeographyFedSegDaoImpl.class);
	private JdbcTemplate jdbcTemplate;
	List<GeographyFedSegVO> resultList;
	private String sql;

	@Override
	public void afterPropertiesSet() throws Exception {
		getCacheData();
	}

	@Override
	public List<GeographyFedSegVO> getCacheData(Object... args) throws Exception {
		return this.resultList;
	}
	
	public List<GeographyFedSegVO> getCacheData() throws OptimaRetailApplicationException {
		this.resultList = new ArrayList<GeographyFedSegVO>();
		try {
			this.resultList = this.jdbcTemplate.query(this.sql,
					new GeographyFedSegResultSetExtractor());
		} catch (Exception e) {
			LOGGER.error(" Exception occured while loading Geography Fed Segment " + e);

			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.FATAL,
					" Exception occured while loading Geography Fed Segment", e.getMessage(),
					OptimaRetailExceptionUtil.getStackTrace(e));
		}
		return this.resultList;
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


	
}
