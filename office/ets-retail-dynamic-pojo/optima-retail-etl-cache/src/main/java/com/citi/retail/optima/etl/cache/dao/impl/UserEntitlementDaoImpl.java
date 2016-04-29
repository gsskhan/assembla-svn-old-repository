package com.citi.retail.optima.etl.cache.dao.impl;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

import ch.qos.logback.classic.Logger;

import com.citi.retail.optima.etl.cache.dao.CacheLoaderDao;
import com.citi.retail.optima.etl.cache.model.EntitlementVO;
import com.citi.retail.optima.etl.cache.resultset.setter.UserEntitlementResultSetExtractor;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;

/**
 * 
 * @author mc56120
 *
 */
public class UserEntitlementDaoImpl implements InitializingBean,
		CacheLoaderDao<EntitlementVO>  {

	private JdbcTemplate jdbcTemplate;

	private String sql;
	
	private List<EntitlementVO> userList;
	
	@Override
	public void afterPropertiesSet() throws Exception {		
	}

	public void getData()
			throws OptimaRetailApplicationException {
		userList = this.jdbcTemplate.query(this.sql,
				new UserEntitlementResultSetExtractor());		
	}

	@Override
	public  List<EntitlementVO> getCacheData(Object... args) throws Exception {
		getData();
		return userList;
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
