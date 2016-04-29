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

import com.citi.retail.optima.etl.cache.dao.impl.GeographyFedSegDaoImpl;
import com.citi.retail.optima.etl.cache.helper.SingleValueCacheEntryHelper;
import com.citi.retail.optima.etl.cache.model.GeographyFedSegVO;

/**
 * @author mc56120
 *
 */
@SuppressWarnings("rawtypes")
public class GeographyFedSegCacheLoaderImpl  extends OptimaCacheDataLoader {

	private SingleValueCacheEntryHelper<String, GeographyFedSegVO> cacheEntryHelper;
	private GeographyFedSegDaoImpl dao;

	public void setDao(GeographyFedSegDaoImpl dao) {
		this.dao = dao;
	}

	public void setCacheEntryHelper(
			SingleValueCacheEntryHelper<String, GeographyFedSegVO> cacheEntryHelper) {
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
		Set<Entry<String, GeographyFedSegVO>> refSet = convertDataToMap(this.dao
				.getCacheData(args));
		for (Entry<String, GeographyFedSegVO> entity : refSet) {
			this.cache.put(this.cacheEntryHelper.getKey(entity),
					this.cacheEntryHelper.getValue(entity));
		}
	}

	public Set<Entry<String, GeographyFedSegVO>> convertDataToMap(
			List<GeographyFedSegVO> refList) throws SQLException {
		Map<String, GeographyFedSegVO> baseRefMap = new HashMap<String, GeographyFedSegVO>();

		for (GeographyFedSegVO refBand : refList) {
			baseRefMap.put(OptimaCacheUtil.keyCreator(
					refBand.getGeographyId(), refBand.getProcessingUnitId()),
					refBand);
		}
		return baseRefMap.entrySet();
	}

}
