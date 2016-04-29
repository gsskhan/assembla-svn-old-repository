package com.citi.retail.optima.etl.cache.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.citi.retail.optima.etl.cache.dao.CacheLoaderDao;
import com.citi.retail.optima.etl.cache.model.CalendarVO;
import com.citi.retail.optima.etl.cache.resultset.setter.CalendarResultSetExtractor;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;

/**
 * 
 * @author mc56120
 *
 */
public class CalendarDaoImpl implements CacheLoaderDao<CalendarVO>  {

	private JdbcTemplate jdbcTemplate;

	private String sql;
	
	private List<CalendarVO> calendarList;
	
	
	public void getData()
			throws OptimaRetailApplicationException {
		calendarList = this.jdbcTemplate.query(this.sql,
				new CalendarResultSetExtractor());
	}

	@Override
	public  List<CalendarVO> getCacheData(Object... args) throws Exception {
		getData();
		return calendarList;
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
