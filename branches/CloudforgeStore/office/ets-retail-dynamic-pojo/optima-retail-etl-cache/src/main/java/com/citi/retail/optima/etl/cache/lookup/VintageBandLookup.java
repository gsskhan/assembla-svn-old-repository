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
import com.citi.retail.optima.etl.common.model.cache.VintageBandDomain;

/**
 * helper class for the Range/Band based reference data.
 * 
 * @author mc56120
 * 
 */
public class VintageBandLookup extends SpringCacheBaseLookup {

	private final Logger LOGGER = (Logger) LoggerFactory
			.getLogger(VintageBandLookup.class);
	
	private String bandName = "vintage";

	public VintageBandLookup(CacheManager cacheManager) {
		super(cacheManager);
	}

	@SuppressWarnings("unchecked")
	public VintageBandDomain getVintageSegmentationValue(Integer processingUnitId, Integer value, String segmentType)
			throws OptimaRetailApplicationException {
		try {			
				Cache flatCache = this.cacheManager
						.getCache(bandName + "FlatCache");

				ValueWrapper valueWrapper = flatCache.get(OptimaCacheUtil
						.keyCreator(processingUnitId, segmentType, value));

				if (valueWrapper != null) {
					return (VintageBandDomain) valueWrapper.get();
				}
			
				
		} catch (Exception e) {
			this.LOGGER
					.error("Exception occured in Vintage Band "
							+ e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					"Exception occured in Vintage Band ",
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));			
		}

		return null;
	}
	
	@SuppressWarnings("unchecked")
	public VintageBandDomain getVintageSegmentationValue(Integer processingUnitId, String value, String segmentType)
			throws OptimaRetailApplicationException {
		try {			
				Cache flatCache = this.cacheManager
						.getCache(bandName + "FlatCache");

				ValueWrapper valueWrapper = flatCache.get(OptimaCacheUtil
						.keyCreator(processingUnitId, segmentType, value));

				if (valueWrapper != null) {
					return (VintageBandDomain) valueWrapper.get();
				}
			
				
		} catch (Exception e) {
			this.LOGGER
					.error("Exception occured in Vintage Band "
							+ e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					"Exception occured in Vintage Band ",
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));			
		}

		return null;
	}

	
}