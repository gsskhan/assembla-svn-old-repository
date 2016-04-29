package com.citi.retail.optima.etl.cache.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.citi.retail.optima.etl.cache.dao.CacheLoaderDao;
import com.citi.retail.optima.etl.cache.model.ReportingPeriodVO;
import com.citi.retail.optima.etl.cache.resultset.setter.ReportingPeriodResultSetExtractor;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;

/**
 * 
 * @author mc56120
 *
 */
public class ReportingPeriodDaoImpl implements CacheLoaderDao<ReportingPeriodVO>  {

	private JdbcTemplate jdbcTemplate;

	private String sql;
	
	private List<ReportingPeriodVO> reportPeriodList;
	
	
	public void getData()
			throws OptimaRetailApplicationException {
		reportPeriodList = this.jdbcTemplate.query(this.sql,
				new ReportingPeriodResultSetExtractor());
	}

	@Override
	public  List<ReportingPeriodVO> getCacheData(Object... args) throws Exception {
		getData();
		return reportPeriodList;
	}

	/**
	 * 
	 * @param jdbcTemplate
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}
	
}
