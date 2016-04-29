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

import com.citi.retail.optima.etl.cache.dao.impl.GeographyCacheDaoImpl;
import com.citi.retail.optima.etl.cache.helper.SingleValueCacheEntryHelper;
import com.citi.retail.optima.etl.cache.model.GeographyVO;


/**
 * @author mc56120
 *
 */
@SuppressWarnings("rawtypes")
public class GeographyCacheLoaderImpl  extends OptimaCacheDataLoader {

	private SingleValueCacheEntryHelper<String, GeographyVO> cacheEntryHelper;
	private GeographyCacheDaoImpl dao;

	public void setDao(GeographyCacheDaoImpl dao) {
		this.dao = dao;
	}

	public void setCacheEntryHelper(
			SingleValueCacheEntryHelper<String, GeographyVO> cacheEntryHelper) {
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
		Set<Entry<String, GeographyVO>> refSet = convertDataToMap(this.dao
				.getCacheData(args));
		for (Entry<String, GeographyVO> entity : refSet) {
			this.cache.put(this.cacheEntryHelper.getKey(entity),
					this.cacheEntryHelper.getValue(entity));
		}
	}

	public Set<Entry<String, GeographyVO>> convertDataToMap(
			List<GeographyVO> refList) throws SQLException {
		Map<String, GeographyVO> baseRefMap = new HashMap<String, GeographyVO>();

		for (GeographyVO refBand : refList) {

			baseRefMap.put(OptimaCacheUtil.keyCreator(
					refBand.getGeographyCd(), refBand.getProcUnitId()),
					refBand);
		}
		return baseRefMap.entrySet();
	}


}
