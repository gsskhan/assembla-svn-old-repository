/**
 * 
 */
package com.citi.retail.optima.etl.cache.ehcache;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.citi.retail.optima.etl.cache.dao.impl.CountryGeographyMapDaoImpl;
import com.citi.retail.optima.etl.cache.helper.SingleValueCacheEntryHelper;
import com.citi.retail.optima.etl.cache.model.CountryGeographyMapVO;


/**
 * @author mc56120
 *
 */
@SuppressWarnings("rawtypes")
public class CountryGeographyMapCacheLoaderImpl  extends OptimaCacheDataLoader {

	private SingleValueCacheEntryHelper<String, CountryGeographyMapVO> cacheEntryHelper;
	private CountryGeographyMapDaoImpl dao;

	public void setDao(CountryGeographyMapDaoImpl dao) {
		this.dao = dao;
	}

	public void setCacheEntryHelper(
			SingleValueCacheEntryHelper<String, CountryGeographyMapVO> cacheEntryHelper) {
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
		Set<Entry<String, CountryGeographyMapVO>> refSet = convertDataToMap(this.dao
				.getCacheData(args));
		for (Entry<String, CountryGeographyMapVO> entity : refSet) {
			this.cache.put(this.cacheEntryHelper.getKey(entity),
					this.cacheEntryHelper.getValue(entity));
		}
	}

	public Set<Entry<String, CountryGeographyMapVO>> convertDataToMap(
			List<CountryGeographyMapVO> refList) throws SQLException {
		Map<String, CountryGeographyMapVO> baseRefMap = new HashMap<String, CountryGeographyMapVO>();

		for (CountryGeographyMapVO refBand : refList) {

			baseRefMap.put(OptimaCacheUtil.keyCreator(
					refBand.getCountryCd(), refBand.getProcessingUnit()),
					refBand);
		}
		return baseRefMap.entrySet();
	}


}
