package com.citi.retail.optima.etl.cache.ehcache;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.citi.retail.optima.etl.cache.dao.impl.CountryDaoImpl;
import com.citi.retail.optima.etl.cache.helper.SingleValueCacheEntryHelper;
import com.citi.retail.optima.etl.cache.model.CountryVO;

/**
 * 
 * @author mc56120
 *
 */
public class CountryDataLoaderImpl
		extends
		OptimaCacheDataLoader<Entry<String, Map<String, CountryVO>>, String, Map<String, CountryVO>> {
	
	private SingleValueCacheEntryHelper<String, CountryVO> cacheEntryHelper;
	private CountryDaoImpl dao;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		if (preloadCache) {
			loadCache();
		}
	}
	
	@Override
	protected void loadCache(Object... args) throws Exception {
		Set<Entry<String, CountryVO>> refSet = getData(this.dao.getCacheData(args));
		for (Entry<String, CountryVO> entity : refSet) {
			this.cache.put(this.cacheEntryHelper.getKey(entity),this.cacheEntryHelper.getValue(entity));
		}

	}	
	
	public Set<Entry<String, CountryVO>> getData(List<CountryVO> refList) throws SQLException {
		Map<String, CountryVO> baseRefMap = new HashMap<String, CountryVO>();
		for (CountryVO countryVo : refList) {
			baseRefMap.put(countryVo.getCountryCode(), countryVo);
		}
		return baseRefMap.entrySet();
	}	

	/**
	 * @return the cacheEntryHelper
	 */
	public SingleValueCacheEntryHelper<String, CountryVO> getCacheEntryHelper() {
		return cacheEntryHelper;
	}

	/**
	 * @param cacheEntryHelper the cacheEntryHelper to set
	 */
	public void setCacheEntryHelper(
			SingleValueCacheEntryHelper<String, CountryVO> cacheEntryHelper) {
		this.cacheEntryHelper = cacheEntryHelper;
	}

	/**
	 * @return the dao
	 */
	public CountryDaoImpl getDao() {
		return dao;
	}

	/**
	 * @param dao the dao to set
	 */
	public void setDao(CountryDaoImpl dao) {
		this.dao = dao;
	}
	
	
}
