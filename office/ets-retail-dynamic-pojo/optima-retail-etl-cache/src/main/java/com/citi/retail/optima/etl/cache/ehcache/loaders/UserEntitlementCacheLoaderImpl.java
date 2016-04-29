package com.citi.retail.optima.etl.cache.ehcache.loaders;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.citi.retail.optima.etl.cache.dao.impl.UserEntitlementDaoImpl;
import com.citi.retail.optima.etl.cache.ehcache.OptimaCacheDataLoader;
import com.citi.retail.optima.etl.cache.ehcache.OptimaCacheUtil;
import com.citi.retail.optima.etl.cache.helper.SingleValueCacheEntryHelper;
import com.citi.retail.optima.etl.cache.model.EntitlementVO;

/**
 * 
 * @author av51190
 *
 */
public class UserEntitlementCacheLoaderImpl extends OptimaCacheDataLoader<EntitlementVO,String,EntitlementVO> {

	private SingleValueCacheEntryHelper<String, EntitlementVO> cacheEntryHelper;
	private UserEntitlementDaoImpl dao;

	public void setDao(UserEntitlementDaoImpl dao) {
		this.dao = dao;
	}

	public void setCacheEntryHelper(
			SingleValueCacheEntryHelper<String, EntitlementVO> cacheEntryHelper) {
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
		Set<Entry<String, EntitlementVO>> refSet = convertDataToMap(this.dao
				.getCacheData(args));
		for (Entry<String, EntitlementVO> entity : refSet) {
			this.cacheEntryHelper.getKey(entity);
			this.cache.put(this.cacheEntryHelper.getKey(entity),
					this.cacheEntryHelper.getValue(entity));
		}

	}

	public Set<Entry<String, EntitlementVO>> convertDataToMap(
			List<EntitlementVO> refList) throws SQLException {
		Map<String, EntitlementVO> baseRefMap = new HashMap<String, EntitlementVO>();		
		for (EntitlementVO user : refList) {			
			baseRefMap.put(OptimaCacheUtil.keyCreator(user.getBussFuncCd(),user.getSoeId()),user);
		}
		return baseRefMap.entrySet();
	}

}
