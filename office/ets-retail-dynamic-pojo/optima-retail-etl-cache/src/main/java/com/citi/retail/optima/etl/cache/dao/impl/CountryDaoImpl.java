package com.citi.retail.optima.etl.cache.dao.impl;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

import com.citi.retail.optima.etl.cache.dao.CacheLoaderDao;
import com.citi.retail.optima.etl.cache.model.CountryVO;
import com.citi.retail.optima.etl.cache.resultset.setter.CountryResultSetExtractor;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;

/**
 * 
 * @author mc56120
 *
 */
public class CountryDaoImpl implements InitializingBean,
		CacheLoaderDao<CountryVO>  {
	private JdbcTemplate jdbcTemplate;

	private String sql;
	
	private List<CountryVO> countryList;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		countryList = getData();
	}

	public List<CountryVO> getData()
			throws OptimaRetailApplicationException {
		countryList = this.jdbcTemplate.query(this.sql,
				new CountryResultSetExtractor());
		return countryList;
	}

	@Override
	public  List<CountryVO> getCacheData(Object... args) throws Exception {
		return countryList;
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
