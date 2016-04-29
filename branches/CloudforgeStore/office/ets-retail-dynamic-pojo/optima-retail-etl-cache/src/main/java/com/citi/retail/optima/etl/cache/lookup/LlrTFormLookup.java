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
import com.citi.retail.optima.etl.common.model.cache.LlrTFormDomain;

/**
 * @author sr67841 This is the helper class for the Value based reference data.
 *         Ex:- Region
 * 
 */
public class LlrTFormLookup extends SpringCacheBaseLookup {

	private final Logger LOGGER = (Logger) LoggerFactory
			.getLogger(LlrTFormLookup.class);

	public LlrTFormLookup(CacheManager cacheManager) {
		super(cacheManager);
	}

	public LlrTFormLookup(Cache cache) {
		super(cache);
	}

	private static final String LLR_TFORM_LUK_EXCP = "Exception occured while loading Llr TForm Lookup";

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

	public LlrTFormDomain getLlrTFormLookup(String srcSysId, String srcDataVal,
			String trgtAttr) throws OptimaRetailApplicationException {
		try {
			Cache cache = cacheManager.getCache("llrTFormCache");
			String key = OptimaCacheUtil.keyCreator(srcSysId, srcDataVal,
					trgtAttr);
			ValueWrapper valueWrapper = cache.get(key);

			if (valueWrapper != null) {
				return (LlrTFormDomain) valueWrapper.get();
			}

		} catch (Exception e) {
			LOGGER.error(LLR_TFORM_LUK_EXCP + e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR, LLR_TFORM_LUK_EXCP,
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));
		}
		return null;
	}

}
