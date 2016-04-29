package com.citi.retail.optima.etl.cache.helper;

import com.citi.retail.optima.etl.common.model.cache.PortfolioDefinitionVO;

public class PortfolioDefinitionCacheEntryHelper implements
		CacheEntryHelper<PortfolioDefinitionVO,String, PortfolioDefinitionVO> {
	
	@Override
	public String getKey(PortfolioDefinitionVO entity) {
		// TODO Auto-generated method stub
		return entity.getPortfolioId();
	}

	@Override
	public PortfolioDefinitionVO getValue(PortfolioDefinitionVO entity) {
		// TODO Auto-generated method stub
		return entity;
	}

}
