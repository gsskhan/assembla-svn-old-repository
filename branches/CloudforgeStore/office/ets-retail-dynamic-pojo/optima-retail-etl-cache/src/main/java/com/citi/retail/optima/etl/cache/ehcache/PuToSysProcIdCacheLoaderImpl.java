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

import com.citi.retail.optima.etl.cache.dao.impl.PuToSysProcIdDaoImpl;
import com.citi.retail.optima.etl.cache.helper.SingleValueCacheEntryHelper;
import com.citi.retail.optima.etl.cache.model.PuToSysProcIdVO;

/**
 * @author mc56120
 *
 */
@SuppressWarnings("rawtypes")
public class PuToSysProcIdCacheLoaderImpl extends OptimaCacheDataLoader {

	private SingleValueCacheEntryHelper<String, PuToSysProcIdVO> cacheEntryHelper;
	private PuToSysProcIdDaoImpl dao;

	public void setDao(PuToSysProcIdDaoImpl dao) {
		this.dao = dao;
	}

	public void setCacheEntryHelper(
			SingleValueCacheEntryHelper<String, PuToSysProcIdVO> cacheEntryHelper) {
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
		Set<Entry<String, PuToSysProcIdVO>> refSet = convertDataToMap(this.dao
				.getCacheData(args));
		for (Entry<String, PuToSysProcIdVO> entity : refSet) {
			this.cache.put(this.cacheEntryHelper.getKey(entity),
					this.cacheEntryHelper.getValue(entity));
		}

	}

	public Set<Entry<String, PuToSysProcIdVO>> convertDataToMap(
			List<PuToSysProcIdVO> refList) throws SQLException {
		Map<String, PuToSysProcIdVO> baseRefMap = new HashMap<String, PuToSysProcIdVO>();

		for (PuToSysProcIdVO refBand : refList) {

			baseRefMap.put(OptimaCacheUtil.keyCreator(
					refBand.getProcessingUnit(), refBand.getBatchId()),
					refBand);
		}
		return baseRefMap.entrySet();
	}

}
