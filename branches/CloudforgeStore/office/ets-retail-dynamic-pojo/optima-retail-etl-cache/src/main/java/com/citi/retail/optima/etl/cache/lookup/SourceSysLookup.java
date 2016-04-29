package com.citi.retail.optima.etl.cache.lookup;

import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.CacheManager;

import ch.qos.logback.classic.Logger;

import com.citi.retail.optima.etl.cache.ehcache.OptimaCacheUtil;
import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;
import com.citi.retail.optima.etl.common.model.cache.SourceSystemDomain;

/**
 * @author sr67841 This is the helper class for the Value based reference data.
 *         Ex:- Region
 * 
 */
public class SourceSysLookup extends SpringCacheBaseLookup {

	private final Logger LOGGER = (Logger) LoggerFactory
			.getLogger(SourceSysLookup.class);

	public SourceSysLookup(CacheManager cacheManager) {
		super(cacheManager);
	}

	public SourceSysLookup(Cache cache) {
		super(cache);
	}

	private static final String LLR_SRC_SYS_LUK_EXCP = "Exception occured while loading Llr SRC SYS Lookup";

	// TODO refactor
	/**
	 * is geography code valid for CITI segment type (used in validation)
	 * 
	 * @param cacheName
	 * @param segType
	 * @param value
	 * @return
	 * @throws OptimaRetailException
	 */

	public SourceSystemDomain getSourceSysId(String srcVal)
			throws OptimaRetailApplicationException {
		try {
			Cache cache = cacheManager.getCache("srcSysCache");
			String key = OptimaCacheUtil.keyCreator(srcVal);
			ValueWrapper valueWrapper = cache.get(key);

			if (valueWrapper != null) {
				return (SourceSystemDomain) valueWrapper.get();
			}
		} catch (Exception e) {
			LOGGER.error(LLR_SRC_SYS_LUK_EXCP + e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					LLR_SRC_SYS_LUK_EXCP, e.getMessage(),
					OptimaRetailExceptionUtil.getStackTrace(e));
		}
		return null;
	}

}
