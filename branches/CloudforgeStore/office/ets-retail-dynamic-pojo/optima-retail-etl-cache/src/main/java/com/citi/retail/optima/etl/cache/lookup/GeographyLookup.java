package com.citi.retail.optima.etl.cache.lookup;

import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.CacheManager;

import ch.qos.logback.classic.Logger;

import com.citi.retail.optima.etl.cache.model.CountryRegionMappingVO;
import com.citi.retail.optima.etl.cache.model.RegionUserSegVO;
import com.citi.retail.optima.etl.cache.model.RegionVO;
import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;

/**
 * @author sr67841 This is the helper class for the Value based reference data.
 *         Ex:- Region
 * 
 */
public class GeographyLookup extends SpringCacheBaseLookup {

	private final Logger LOGGER = (Logger) LoggerFactory
			.getLogger(GeographyLookup.class);

	public GeographyLookup(CacheManager cacheManager) {
		super(cacheManager);
	}

	public GeographyLookup(Cache cache) {
		super(cache);
	}
	
	private static final String GEO_LUK_EXCP = "Exception occured while loading Geography Lookup";
	
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
	public Object getValidGeographyCode(String segType, Integer value)
			throws OptimaRetailApplicationException {
		try {
			Cache cache = cacheManager.getCache("geographyCache");
			String key = segType + "," + "" + value;
			ValueWrapper valueWrapper = cache.get(key);

			if (valueWrapper != null) {
				return valueWrapper.get();
			}

		} catch (Exception e) {
			LOGGER.error(GEO_LUK_EXCP + e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					GEO_LUK_EXCP,
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));
		}
		return null;
	}

	/**
	 * is geography code valid for FED segment type (used in validation)
	 * 
	 * @param cacheName
	 * @param segType
	 * @param value
	 * @return
	 * @throws OptimaRetailException
	 */
	public Object getValidGeographyCode(String segType, String value)
			throws OptimaRetailApplicationException {
		try {
			Cache cache = cacheManager.getCache("geographyCache");
			String key = segType + "," + value;
			ValueWrapper valueWrapper = cache.get(key);

			if (valueWrapper != null) {
				return valueWrapper.get();
			}

		} catch (Exception e) {
			LOGGER.error(GEO_LUK_EXCP + e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					GEO_LUK_EXCP,
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));
		}

		return null;
	}

	/**
	 * get FED Segment based on the user submission geography value
	 * 
	 * @param cacheName
	 * @param inputSegType
	 * @param outputSegType
	 * @param value
	 * @return
	 * @throws OptimaRetailException
	 */
	// only for account level
	public String getGeographySegmentation(String inputSegType,
			String outputSegType, Integer value)
			throws OptimaRetailApplicationException {
		try {
			Cache cache = cacheManager.getCache("geographyCache");
			String key = inputSegType + "," + value;
			ValueWrapper valueWrapper = cache.get(key);

			if (valueWrapper != null) {
				RegionVO regionVo = (RegionVO) valueWrapper.get();
				Cache userSegCache = cacheManager
						.getCache("regionUserSegCache");
				valueWrapper = null;
				valueWrapper = userSegCache.get(regionVo.getGeographyId() + ","
						+ outputSegType);
				if (valueWrapper != null) {
					RegionUserSegVO userSegmentVo = (RegionUserSegVO) valueWrapper
							.get();
					return userSegmentVo.getGeographyRefId().toString();
				}
			}

		} catch (Exception e) {
			LOGGER.error(GEO_LUK_EXCP + e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					GEO_LUK_EXCP,
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));
		}

		return null;
	}

	/**
	 * get Region code by country
	 * 
	 * @param cacheName
	 * @param segType
	 * @return
	 * @throws OptimaRetailException
	 */
	public Object getGeographyByCountryCode(String countryCode, String segType)
			throws OptimaRetailApplicationException {
		try {
			Cache cache = cacheManager.getCache("countryGeographyMappingCache");
			String key = countryCode + "," + segType;
			ValueWrapper valueWrapper = cache.get(key);

			if (valueWrapper != null) {
				CountryRegionMappingVO countryRegionMappingVO = (CountryRegionMappingVO) valueWrapper
						.get();
				Cache regionByIdCache = cacheManager
						.getCache("regionByIdCache");
				valueWrapper = null;
				valueWrapper = regionByIdCache.get(countryRegionMappingVO
						.getRefGeographyId());
				if (valueWrapper != null) {
					return valueWrapper.get();
				}
			}

		} catch (Exception e) {
			LOGGER.error(GEO_LUK_EXCP + e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					GEO_LUK_EXCP,
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));
		}

		return null;
	}
}
