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
import com.citi.retail.optima.etl.cache.model.CountryRegionMappingVO;
import com.citi.retail.optima.etl.cache.model.CountryRegionVO;

/**
 * 
 * @author mc56120
 *
 */
public class CountryRegionMappingDataLoaderImpl
		extends
		OptimaCacheDataLoader<Entry<String, Map<String, CountryRegionMappingVO>>, String, Map<String, CountryRegionMappingVO>> {
	
	private SingleValueCacheEntryHelper<String, CountryRegionMappingVO> cacheEntryHelper;
	private RegionDaoImpl dao;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		if (preloadCache) {
			loadCache();
		}
	}
	
	@Override
	protected void loadCache(Object... args) throws Exception {
		Set<Entry<String, CountryRegionMappingVO>> refSet = getData(this.dao.getCacheData(args));
		for (Entry<String, CountryRegionMappingVO> entity : refSet) {
			this.cache.put(this.cacheEntryHelper.getKey(entity),
					this.cacheEntryHelper.getValue(entity));
		}

	}	
	
	public Set<Entry<String, CountryRegionMappingVO>> getData(List<CountryRegionVO> refList) throws SQLException {
		Map<String, CountryRegionMappingVO> baseRefMap = new HashMap<String, CountryRegionMappingVO>();
		for (CountryRegionVO countryRegionVo : refList) {
			CountryRegionMappingVO countryRegionMappingVO=countryRegionVo.getCountryRegionMapping();
			baseRefMap.put(generateKey(countryRegionMappingVO), countryRegionMappingVO);
		}
		return baseRefMap.entrySet();
	}	
	
	public String generateKey(CountryRegionMappingVO countryRegionMappingVO){
		StringWriter sw = new StringWriter();
		sw.append(countryRegionMappingVO.getCountryCode());
		sw.append(",");
		sw.append(countryRegionMappingVO.getSegmentType());
		return sw.toString();
	}	

	/**
	 * @return the cacheEntryHelper
	 */
	public SingleValueCacheEntryHelper<String, CountryRegionMappingVO> getCacheEntryHelper() {
		return cacheEntryHelper;
	}

	/**
	 * @param cacheEntryHelper the cacheEntryHelper to set
	 */
	public void setCacheEntryHelper(
			SingleValueCacheEntryHelper<String, CountryRegionMappingVO> cacheEntryHelper) {
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
