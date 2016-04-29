package com.citi.retail.optima.etl.cache.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

import com.citi.retail.optima.etl.cache.dao.CacheLoaderDao;
import com.citi.retail.optima.etl.common.model.cache.PortfolioDefinitionVO;

public class PortfolioDefinitionDaoImpl implements CacheLoaderDao<PortfolioDefinitionVO>,
		InitializingBean {

	private JdbcTemplate jdbcTemplate;

	private String sql;	
	public PortfolioDefinitionDaoImpl() {
	
	}
	@Override
	public Collection<PortfolioDefinitionVO> getCacheData(Object... args)
			throws Exception {
		//Get data from sql later
		return getMockData();
	}

	private Collection<PortfolioDefinitionVO> getMockData() {
		List<PortfolioDefinitionVO> voList = new ArrayList<PortfolioDefinitionVO>();
		PortfolioDefinitionVO pdVo = new PortfolioDefinitionVO();		
		pdVo.setApprovalFl("Y");
		pdVo.setCcarBkDisallowCurr("Y");
		pdVo.setCcarBusUnit("BU");
		pdVo.setCcarCsDisallowCurr("Y");
		pdVo.setCcarNumAccountsDefinitionCurr("Basic");
		pdVo.setCcarSecFlgCurr("Y");
		pdVo.setCcarSourceCurr("Y");
		pdVo.setCcarSubproductCurr("ACI");
		pdVo.setCountry("USA");
		pdVo.setDesc("Desc");
		pdVo.setEffectiveDate(new Date());
		pdVo.setEffectiveStatus(true);
		pdVo.setPortfolioId("CNUI004");
		pdVo.setReportingPeriod("2012");
		pdVo.setReportingQuarter(2);
		pdVo.setSourceSysId("User Sub");
		voList.add(pdVo);
		return voList;
	}
	/**
	 * @return the jdbcTemplate
	 */
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	/**
	 * @param jdbcTemplate the jdbcTemplate to set
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	/**
	 * @return the sql
	 */
	public String getSql() {
		return sql;
	}
	/**
	 * @param sql the sql to set
	 */
	public void setSql(String sql) {
		this.sql = sql;
	}
	@Override
	public void afterPropertiesSet() throws Exception {
	}

}
