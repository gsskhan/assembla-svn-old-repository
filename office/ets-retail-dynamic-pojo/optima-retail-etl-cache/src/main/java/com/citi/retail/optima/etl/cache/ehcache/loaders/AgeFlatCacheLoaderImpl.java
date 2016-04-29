package com.citi.retail.optima.etl.cache.ehcache.loaders;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.citi.retail.optima.etl.cache.dao.impl.AgeBandDaoImpl;
import com.citi.retail.optima.etl.cache.ehcache.OptimaCacheDataLoader;
import com.citi.retail.optima.etl.cache.ehcache.OptimaCacheUtil;
import com.citi.retail.optima.etl.cache.helper.SingleValueCacheEntryHelper;
import com.citi.retail.optima.etl.common.model.cache.AgeBandDomain;

/**
 * 
 * @author mc56120
 *
 */
public class AgeFlatCacheLoaderImpl extends OptimaCacheDataLoader {

	private SingleValueCacheEntryHelper<String, AgeBandDomain> cacheEntryHelper;
	private AgeBandDaoImpl dao;

	public void setDao(AgeBandDaoImpl dao) {
		this.dao = dao;
	}

	public void setCacheEntryHelper(
			SingleValueCacheEntryHelper<String, AgeBandDomain> cacheEntryHelper) {
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
		Set<Entry<String, AgeBandDomain>> refSet = convertDataToMap(this.dao
				.getCacheData(args));
		for (Entry<String, AgeBandDomain> entity : refSet) {
			this.cacheEntryHelper.getKey(entity);
			this.cache.put(this.cacheEntryHelper.getKey(entity),
					this.cacheEntryHelper.getValue(entity));
		}

	}

	public Set<Entry<String, AgeBandDomain>> convertDataToMap(
			List<AgeBandDomain> refList) throws SQLException {
		Map<String, AgeBandDomain> baseRefMap = new HashMap<String, AgeBandDomain>();
		String segValue;
		for (AgeBandDomain refBand : refList) {
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
