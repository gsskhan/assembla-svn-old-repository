package com.citi.retail.optima.etl.cache.ehcache;

import java.util.List;

import com.citi.retail.optima.etl.cache.dao.impl.PortfolioDefinitionDaoImpl;
import com.citi.retail.optima.etl.common.model.cache.PortfolioDefinitionVO;

public class PortfolioDefinitionLoaderImpl extends
		OptimaCacheDataLoader<String, PortfolioDefinitionVO, String> {	
	private PortfolioDefinitionDaoImpl dao;
	/**
	 * @return the dao
	 */
	public PortfolioDefinitionDaoImpl getDao() {
		return dao;
	}
	/**
	 * @param dao the dao to set
	 */
	public void setDao(PortfolioDefinitionDaoImpl dao) {
		this.dao = dao;
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		loadCache();	
	}
	
	@Override
	protected void loadCache(Object... args) throws Exception {
		List<PortfolioDefinitionVO> refSet = (List<PortfolioDefinitionVO>)this.dao.getCacheData(args);
		for (PortfolioDefinitionVO entity : refSet) {
			this.cache.put(entity.getPortfolioId() + "," +entity.getReportingQuarter()+ "," + entity.getReportingPeriod(),
					entity);
		}

	}	
}
