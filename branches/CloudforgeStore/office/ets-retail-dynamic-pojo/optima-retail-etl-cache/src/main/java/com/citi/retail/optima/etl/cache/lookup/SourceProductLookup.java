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
import com.citi.retail.optima.etl.common.model.cache.SourceProductDomain;

/**
 * @author sr67841 This is the helper class for the Value based reference data.
 *         Ex:- Region
 * 
 */
public class SourceProductLookup extends SpringCacheBaseLookup {

	private final Logger LOGGER = (Logger) LoggerFactory
			.getLogger(SourceProductLookup.class);

	public SourceProductLookup(CacheManager cacheManager) {
		super(cacheManager);
	}

	public SourceProductLookup(Cache cache) {
		super(cache);
	}

	private static final String LLR_SRC_PROD_LUK_EXCP = "Exception occured while loading Llr SRC Product Lookup";

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

	// LKUP.SRC_DATA_VAL,
	// LKUP.TRGT_ATTR,
	// SS.src_sys_id
	public SourceProductDomain getSourceProduct(String prod1, String prod2,
			String prod3) throws OptimaRetailApplicationException {
		try {
			Cache cache = cacheManager.getCache("srcProdCache");
			String key = OptimaCacheUtil.keyCreator(prod1, prod2, prod3);
			ValueWrapper valueWrapper = cache.get(key);

			if (valueWrapper != null) {
				return (SourceProductDomain) valueWrapper.get();
			}
		} catch (Exception e) {
			LOGGER.error(LLR_SRC_PROD_LUK_EXCP + e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					LLR_SRC_PROD_LUK_EXCP, e.getMessage(),
					OptimaRetailExceptionUtil.getStackTrace(e));
		}
		return null;
	}

}
