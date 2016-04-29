package com.citi.retail.optima.etl.cache.lookup;

import net.sf.ehcache.Element;

import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import ch.qos.logback.classic.Logger;

import com.citi.retail.optima.etl.cache.ehcache.OptimaCacheUtil;
import com.citi.retail.optima.etl.cache.model.EntitlementVO;
import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;

/**
 * @author sr67841 This is the helper class for the Value based reference data.
 *         Ex:- Region
 * 
 */
public class UserEntitlementLookup extends SpringCacheBaseLookup {

	private final Logger LOGGER = (Logger) LoggerFactory
			.getLogger(UserEntitlementLookup.class);

	public UserEntitlementLookup(CacheManager cacheManager) {
		super(cacheManager);
	}

	public UserEntitlementLookup(Cache cache) {
		super(cache);
	}

	public EntitlementVO getEntitledUser(String bussFunctionCd,String soeId)
			throws OptimaRetailApplicationException {
		try {
			
			Element element = this.ehCache.get(OptimaCacheUtil.keyCreator(bussFunctionCd,soeId));

			if (element != null) {
				return (EntitlementVO)element.getObjectValue();
			}

		} catch (Exception e) {
			LOGGER.error("Exception occured while loading ReferenceValue Lookup "
					+ e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					"Exception occured while loading Currency Lookup",
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));
		}

		return null;
	}
}
