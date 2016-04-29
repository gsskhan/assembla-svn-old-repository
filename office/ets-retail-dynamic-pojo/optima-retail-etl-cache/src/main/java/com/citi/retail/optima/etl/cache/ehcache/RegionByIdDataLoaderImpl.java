package com.citi.retail.optima.etl.cache.ehcache;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.citi.retail.optima.etl.cache.dao.impl.RegionDaoImpl;
import com.citi.retail.optima.etl.cache.helper.SingleValueCacheEntryHelper;
import com.citi.retail.optima.etl.cache.model.CountryRegionVO;
import com.citi.retail.optima.etl.cache.model.RegionVO;

/**
 * 
 * @author mc56120
 *
 */
public class RegionByIdDataLoaderImpl
		extends
		OptimaCacheDataLoader<Entry<Integer, RegionVO>, Integer, RegionVO> {
	
	private SingleValueCacheEntryHelper<Integer, RegionVO> cacheEntryHelper;
	private RegionDaoImpl dao;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		if (preloadCache) {
			loadCache();
		}
	}
	
	@Override
	protected void loadCache(Object... args) throws Exception {
		Set<Entry<Integer, RegionVO>> refSet = getData(this.dao.getCacheData(args));
		for (Entry<Integer, RegionVO> entity:refSet) {
			this.cache.put(this.cacheEntryHelper.getKey(entity),
					this.cacheEntryHelper.getValue(entity));
		}
	}	
	
	public Set<Entry<Integer, RegionVO>> getData(List<CountryRegionVO> refList) throws SQLException {
		Map<Integer, RegionVO> baseRefMap = new HashMap<Integer, RegionVO>();
		for (CountryRegionVO countryRegionVo : refList) {
			RegionVO regionVo=countryRegionVo.getRegionVO();
			baseRefMap.put(regionVo.getGeographyId(), regionVo);
		}
		return baseRefMap.entrySet();
	}	


	/**
	 * @return the cacheEntryHelper
	 */
	public SingleValueCacheEntryHelper<Integer, RegionVO> getCacheEntryHelper() {
		return cacheEntryHelper;
	}

	/**
	 * @param cacheEntryHelper the cacheEntryHelper to set
	 */
	public void setCacheEntryHelper(
			SingleValueCacheEntryHelper<Integer, RegionVO> cacheEntryHelper) {
		this.cacheEntryHelper = cacheEntryHelper;
	}

	/**
	 * @return the dao
	 */
	public RegionDaoImpl getDao() {
		return dao;
	}

	/**
	 * @param dao the dao to set
	 */
	public void setDao(RegionDaoImpl dao) {
		this.dao = dao;
	}
	
	
}
