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
import com.citi.retail.optima.etl.cache.model.RegionUserSegVO;

/**
 * 
 * @author mc56120
 *
 */
public class RegionUserSegmentDataLoaderImpl
		extends
		OptimaCacheDataLoader<Entry<String, Map<String, RegionUserSegVO>>, String, Map<String, RegionUserSegVO>> {
	
	private SingleValueCacheEntryHelper<String, RegionUserSegVO> cacheEntryHelper;
	private RegionDaoImpl dao;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		if (preloadCache) {
			loadCache();
		}
	}
	
	@Override
	protected void loadCache(Object... args) throws Exception {
		Set<Entry<String, RegionUserSegVO>> refSet = getData(this.dao.getCacheData(args));
		for (Entry<String, RegionUserSegVO> entity : refSet) {
			this.cache.put(this.cacheEntryHelper.getKey(entity),
					this.cacheEntryHelper.getValue(entity));
		}

	}	
	
	public Set<Entry<String, RegionUserSegVO>> getData(List<CountryRegionVO> refList) throws SQLException {
		Map<String, RegionUserSegVO> baseRefMap = new HashMap<String, RegionUserSegVO>();
		for (CountryRegionVO countryRegionVo : refList) {
			RegionUserSegVO regionUserSegVO=countryRegionVo.getRegionUserSegVO();
			baseRefMap.put(""+regionUserSegVO.getGeographyId() + "," +regionUserSegVO.getOutputSegType(), regionUserSegVO);
		}
		return baseRefMap.entrySet();
	}	

	/**
	 * @return the cacheEntryHelper
	 */
	public SingleValueCacheEntryHelper<String, RegionUserSegVO> getCacheEntryHelper() {
		return cacheEntryHelper;
	}

	/**
	 * @param cacheEntryHelper the cacheEntryHelper to set
	 */
	public void setCacheEntryHelper(
			SingleValueCacheEntryHelper<String, RegionUserSegVO> cacheEntryHelper) {
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
