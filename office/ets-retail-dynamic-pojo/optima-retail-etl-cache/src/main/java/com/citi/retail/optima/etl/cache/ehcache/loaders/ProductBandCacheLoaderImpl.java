package com.citi.retail.optima.etl.cache.ehcache.loaders;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.citi.retail.optima.etl.cache.dao.impl.ProductBandDaoImpl;
import com.citi.retail.optima.etl.cache.ehcache.OptimaCacheDataLoader;
import com.citi.retail.optima.etl.cache.ehcache.OptimaCacheUtil;
import com.citi.retail.optima.etl.cache.helper.SingleValueCacheEntryHelper;
import com.citi.retail.optima.etl.common.model.cache.ProductBandDomain;

/**
 * 
 * @author mc56120
 *
 */
public class ProductBandCacheLoaderImpl extends OptimaCacheDataLoader<ProductBandDomain,String,ProductBandDomain> {

	private SingleValueCacheEntryHelper<String, ProductBandDomain> cacheEntryHelper;
	private ProductBandDaoImpl dao;

	public void setDao(ProductBandDaoImpl dao) {
		this.dao = dao;
	}

	public void setCacheEntryHelper(
			SingleValueCacheEntryHelper<String, ProductBandDomain> cacheEntryHelper) {
		this.cacheEntryHelper = cacheEntryHelper;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if (this.preloadCache) {
			loadCache();
		}
	}

	@Override
	protected void loadCache(Object... args) throws Exception {
		Set<Entry<String, ProductBandDomain>> refSet = convertDataToMap(this.dao
				.getCacheData(args));
		for (Entry<String, ProductBandDomain> entity : refSet) {
			this.cacheEntryHelper.getKey(entity);
			this.cache.put(this.cacheEntryHelper.getKey(entity),
					this.cacheEntryHelper.getValue(entity));
		}

	}

	public Set<Entry<String, ProductBandDomain>> convertDataToMap(
			List<ProductBandDomain> refList) throws SQLException {
		Map<String, ProductBandDomain> baseRefMap = new HashMap<String, ProductBandDomain>();		
		for (ProductBandDomain prodBand : refList) {			
			baseRefMap.put(OptimaCacheUtil.keyCreator(prodBand.getAccLvlproductTypeCd(),
					prodBand.getProcessingUnitId(),prodBand.getSegmentType()), prodBand);
		}
		return baseRefMap.entrySet();
	}

}
