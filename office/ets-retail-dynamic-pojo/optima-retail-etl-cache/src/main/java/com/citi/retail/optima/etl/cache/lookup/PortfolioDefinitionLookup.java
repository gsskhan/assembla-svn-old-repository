package com.citi.retail.optima.etl.cache.lookup;

import net.sf.ehcache.Element;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import com.citi.retail.optima.etl.common.model.cache.PortfolioDefinitionVO;

public class PortfolioDefinitionLookup extends SpringCacheBaseLookup {

	public PortfolioDefinitionLookup(Cache cache) {
		super(cache);
		// TODO Auto-generated constructor stub
	}

	public PortfolioDefinitionLookup(CacheManager cacheManager) {
		super(cacheManager);
		// TODO Auto-generated constructor stub
	}
	
	public PortfolioDefinitionVO getPortfolioDefinition(String portfolioId) {

		PortfolioDefinitionVO portofolioDefnition = null;

		Element valueWrapper = this.ehCache.get(portfolioId);

		if (valueWrapper != null){
			portofolioDefnition = (PortfolioDefinitionVO) valueWrapper.getObjectValue();
		}

		return portofolioDefnition;
	}
	
	
	public PortfolioDefinitionVO getPortfolioDefinition(String portfolioId,Integer rptPeriod) {

		PortfolioDefinitionVO portofolioDefnition = null;
		String rptPrd = rptPeriod.toString();
		String rptYear = rptPrd.substring(0,4);
		int rptQtr = (int) Math.ceil(Double.parseDouble(rptPrd.substring(5))/3);
		
		Element valueWrapper = this.ehCache.get(portfolioId+","+rptQtr+","+rptYear);

		if (valueWrapper != null){
			portofolioDefnition = (PortfolioDefinitionVO) valueWrapper.getObjectValue();
		}

		return portofolioDefnition;
	}
}
