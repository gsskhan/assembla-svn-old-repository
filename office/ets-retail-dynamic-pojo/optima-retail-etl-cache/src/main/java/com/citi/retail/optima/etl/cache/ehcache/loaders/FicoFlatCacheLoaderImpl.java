package com.citi.retail.optima.etl.cache.ehcache.loaders;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.citi.retail.optima.etl.cache.dao.impl.FicoBandDaoImpl;
import com.citi.retail.optima.etl.cache.ehcache.OptimaCacheDataLoader;
import com.citi.retail.optima.etl.cache.ehcache.OptimaCacheUtil;
import com.citi.retail.optima.etl.cache.helper.SingleValueCacheEntryHelper;
import com.citi.retail.optima.etl.common.model.cache.FicoBandDomain;

/**
 * @author sr67841 This is the loader class for loading FICO details to cache
 *         from reference tables.
 * 
 */
public class FicoFlatCacheLoaderImpl extends OptimaCacheDataLoader {

	private SingleValueCacheEntryHelper<String, FicoBandDomain> cacheEntryHelper;
	private FicoBandDaoImpl dao;

	public void setDao(FicoBandDaoImpl dao) {
		this.dao = dao;
	}

	public void setCacheEntryHelper(
			SingleValueCacheEntryHelper<String, FicoBandDomain> cacheEntryHelper) {
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

		Set<Entry<String, FicoBandDomain>> refSet = convertDataToMap(this.dao
				.getCacheData(args));
		for (Entry<String, FicoBandDomain> entity : refSet) {
			this.cacheEntryHelper.getKey(entity);
			this.cache.put(this.cacheEntryHelper.getKey(entity),
					this.cacheEntryHelper.getValue(entity));
		}

	}

	public Set<Entry<String, FicoBandDomain>> convertDataToMap(
			List<FicoBandDomain> refList) throws SQLException {

		Map<String, FicoBandDomain> baseRefMap = new HashMap<String, FicoBandDomain>();
		String segValue;

		for (FicoBandDomain refBand : refList) {
			if (refBand.getSegVal() != null) {
				segValue = refBand.getSegVal();
			} else {
				segValue = refBand.getSegCode().toString();
			}

			baseRefMap.put(OptimaCacheUtil.keyCreator(
					refBand.getProcessingUnitId(), refBand.getSegmentType(),
					segValue), refBand);

		}

		return baseRefMap.entrySet();
	}

}
