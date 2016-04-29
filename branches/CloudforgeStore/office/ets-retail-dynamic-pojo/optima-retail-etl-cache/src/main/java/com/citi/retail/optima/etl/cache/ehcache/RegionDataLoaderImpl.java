package com.citi.retail.optima.etl.cache.ehcache;

import java.io.StringWriter;
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
public class RegionDataLoaderImpl
		extends
		OptimaCacheDataLoader<Entry<String, Map<String, RegionVO>>, String, Map<String, RegionVO>> {
	
	private SingleValueCacheEntryHelper<String, RegionVO> cacheEntryHelper;
	private RegionDaoImpl dao;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		if (preloadCache) {
			loadCache();
		}
	}
	
	@Override
	protected void loadCache(Object... args) throws Exception {
		Set<Entry<String, RegionVO>> refSet = getData(this.dao.getCacheData(args));
		for (Entry<String, RegionVO> entity : refSet) {
			this.cache.put(this.cacheEntryHelper.getKey(entity),
					this.cacheEntryHelper.getValue(entity));
		}
	}	
	
	public Set<Entry<String, RegionVO>> getData(List<CountryRegionVO> refList) throws SQLException {
		Map<String, RegionVO> baseRefMap = new HashMap<String, RegionVO>();
		for (CountryRegionVO countryRegionVo : refList) {
			RegionVO regionVo=countryRegionVo.getRegionVO();
			baseRefMap.put(generateKey(regionVo), regionVo);
		}
		return baseRefMap.entrySet();
	}	
	
	public String generateKey(RegionVO regionVo){
		StringWriter sw = new StringWriter();
		sw.append(regionVo.getSegmentType());
		sw.append(",");
		sw.append(regionVo.getRegionStrCode()==null ?  (""+regionVo.getRegionIntCode()) : regionVo.getRegionStrCode());
		return sw.toString();
	}

	/**
	 * @return the cacheEntryHelper
	 */
	public SingleValueCacheEntryHelper<String, RegionVO> getCacheEntryHelper() {
		return cacheEntryHelper;
	}

	/**
	 * @param cacheEntryHelper the cacheEntryHelper to set
	 */
	public void setCacheEntryHelper(
			SingleValueCacheEntryHelper<String, RegionVO> cacheEntryHelper) {
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
