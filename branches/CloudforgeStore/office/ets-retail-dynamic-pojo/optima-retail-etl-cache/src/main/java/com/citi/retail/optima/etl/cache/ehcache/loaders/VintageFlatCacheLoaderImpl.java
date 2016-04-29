package com.citi.retail.optima.etl.cache.ehcache.loaders;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.citi.retail.optima.etl.cache.dao.impl.VintageDaoImpl;
import com.citi.retail.optima.etl.cache.ehcache.OptimaCacheDataLoader;
import com.citi.retail.optima.etl.cache.ehcache.OptimaCacheUtil;
import com.citi.retail.optima.etl.cache.helper.SingleValueCacheEntryHelper;
import com.citi.retail.optima.etl.common.model.cache.VintageBandDomain;

/**
 * 
 * @author sv16441
 *
 */
public class VintageFlatCacheLoaderImpl extends OptimaCacheDataLoader {

	private SingleValueCacheEntryHelper<String, VintageBandDomain> cacheEntryHelper;
	private VintageDaoImpl dao;

	public void setDao(VintageDaoImpl dao) {
		this.dao = dao;
	}

	public void setCacheEntryHelper(
			SingleValueCacheEntryHelper<String, VintageBandDomain> cacheEntryHelper) {
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
		Set<Entry<String, VintageBandDomain>> refSet = convertDataToMap(this.dao
				.getCacheData(args));
		for (Entry<String, VintageBandDomain> entity : refSet) {
			this.cacheEntryHelper.getKey(entity);
			this.cache.put(this.cacheEntryHelper.getKey(entity),
					this.cacheEntryHelper.getValue(entity));
		}

	}

	public Set<Entry<String, VintageBandDomain>> convertDataToMap(
			List<VintageBandDomain> refList) throws SQLException {
		Map<String, VintageBandDomain> baseRefMap = new HashMap<String, VintageBandDomain>();
		String segValue;
		for (VintageBandDomain refBand : refList) {
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
