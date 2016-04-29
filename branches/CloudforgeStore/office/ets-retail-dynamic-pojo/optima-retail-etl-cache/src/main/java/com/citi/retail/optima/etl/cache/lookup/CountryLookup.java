package com.citi.retail.optima.etl.cache.lookup;

import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.CacheManager;

import ch.qos.logback.classic.Logger;

import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;

/**
 * @author sr67841 This is the helper class for the Value based reference data.
 *         Ex:- Region
 * 
 */
public class CountryLookup extends SpringCacheBaseLookup {

	private final Logger LOGGER = (Logger) LoggerFactory
			.getLogger(CountryLookup.class);

	public CountryLookup(CacheManager cacheManager) {
		super(cacheManager);
	}

	public CountryLookup(Cache cache) {
		super(cache);
	}

	public Object getCountryForCode(Object countryCode)
			throws OptimaRetailApplicationException {
		try {
			Cache cache = cacheManager.getCache("countryCache");
			ValueWrapper valueWrapper = cache.get(countryCode);

			if (valueWrapper != null) {
				return valueWrapper.get();
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
