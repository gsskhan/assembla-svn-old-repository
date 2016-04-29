package com.citi.retail.optima.etl.cache.lookup;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.CacheManager;

import ch.qos.logback.classic.Logger;

import com.citi.retail.optima.etl.cache.ehcache.OptimaCacheUtil;
import com.citi.retail.optima.etl.cache.model.BaseRef;
import com.citi.retail.optima.etl.cache.model.CalendarVO;
import com.citi.retail.optima.etl.cache.model.CountryGeographyMapVO;
import com.citi.retail.optima.etl.cache.model.GeographyFedSegVO;
import com.citi.retail.optima.etl.cache.model.GeographyVO;
import com.citi.retail.optima.etl.cache.model.PuToSysProcIdVO;
import com.citi.retail.optima.etl.cache.model.ReferenceValueRef;
import com.citi.retail.optima.etl.cache.model.ReportingPeriodVO;
import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;
import com.citi.retail.optima.etl.common.model.cache.KeyRef;

/**
 * @author sr67841 This is the helper class for the Value based reference data.
 *         Ex:- Region
 * 
 */
public class ReferenceValueLookup extends SpringCacheBaseLookup {

	private final Logger LOGGER = (Logger) LoggerFactory
			.getLogger(ReferenceValueLookup.class);
	
	private static final String LOOKUP_EXCP = "Exception occured while loading ReferenceValue Lookup ";

	public ReferenceValueLookup(CacheManager cacheManager) {
		super(cacheManager);
	}

	@SuppressWarnings("unchecked")
	public String getSegmentationValue(String cacheName,
			Integer processingUnitId, String value)
			throws OptimaRetailApplicationException {
		try {
			Cache cache = cacheManager.getCache(cacheName);
			ValueWrapper valueWrapper = cache
					.get(new BaseRef(processingUnitId));

			if (valueWrapper != null) {
				HashMap<String, String> segmentationValueMap = (HashMap<String, String>) valueWrapper
						.get();
				return segmentationValueMap.get(value);
			}
		} catch (Exception e) {
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					"Exception occured while loading ReferenceValue Lookup",
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));
		}

		return null;
	}

	public Object getSegmentationValue(String cacheName, Object value)
			throws OptimaRetailApplicationException {
		try {
			Cache cache = cacheManager.getCache(cacheName);
			ValueWrapper valueWrapper = cache.get(value);

			if (valueWrapper != null) {
				return valueWrapper.get();
			}

		} catch (Exception e) {
			LOGGER.error("Exception occured while loading ReferenceValue Lookup "
					+ e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					"Exception occured while loading ReferenceValue Lookup ",
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	public String getSegmentationValue(String cacheName,
			Integer processingUnitId, String value, String segmentType)
			throws OptimaRetailApplicationException {
		try {
			Cache cache = cacheManager.getCache(cacheName);
			ValueWrapper valueWrapper = cache.get(new KeyRef(processingUnitId,
					segmentType));

			if (valueWrapper != null) {
				TreeMap<String, ReferenceValueRef> segmentationValueMap = (TreeMap<String, ReferenceValueRef>) valueWrapper
						.get();
				ReferenceValueRef referenceValueRef = segmentationValueMap
						.get(value);
				if (referenceValueRef != null){
					return referenceValueRef.getValue();
				}
			}
		} catch (Exception e) {
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					"Exception occured while loading ReferenceValue Lookup ",
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));
		}

		return null;
	}
	
	public PuToSysProcIdVO getPuToSysProcId(Integer processingUnit, Integer jobTypeId)
			throws OptimaRetailApplicationException {
		try {
			Cache cache = cacheManager.getCache("puToSysProcIdCache");
			ValueWrapper valueWrapper = cache.get(OptimaCacheUtil.keyCreator(
					processingUnit, jobTypeId));
			if (valueWrapper != null) {
				return (PuToSysProcIdVO) valueWrapper.get();
			} else {
				return null;
			}
		} catch (Exception e) {
			LOGGER.error(LOOKUP_EXCP + e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					LOOKUP_EXCP,
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));
		}

	}	
	
	
	public CountryGeographyMapVO getGeographyByCountry(String countryCd, Integer processingUnit)
			throws OptimaRetailApplicationException {
		try {
			Cache cache = cacheManager.getCache("countryGeographyMapCache");
			ValueWrapper valueWrapper = cache.get(OptimaCacheUtil.keyCreator(
					countryCd,processingUnit));
			if (valueWrapper != null) {
				return (CountryGeographyMapVO) valueWrapper.get();
			} else {
				return null;
			}
		} catch (Exception e) {
			LOGGER.error(LOOKUP_EXCP + e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					LOOKUP_EXCP,
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));
		}

	}		
	
	public GeographyVO isValidGeography(Integer value, Integer procUnitId)
			throws OptimaRetailApplicationException {
		try {
			Cache cache = cacheManager.getCache("commonGeographyCache");
			ValueWrapper valueWrapper =  cache.get(OptimaCacheUtil.keyCreator(
					value,procUnitId));

			if (valueWrapper != null) {
				return (GeographyVO)valueWrapper.get();
			}

		} catch (Exception e) {
			LOGGER.error("Exception occured while loading ReferenceValue Lookup for isValidGeography(...) "
					+ e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					"Exception occured while loading ReferenceValue Lookup for isValidGeography(...) ",
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));
		}

		return null;
	}	
	
	public GeographyFedSegVO getGeographyFedSeg(Integer geographyId, Integer processingUnit)
			throws OptimaRetailApplicationException {
		try {
			Cache cache = cacheManager.getCache("geographyFedSegCache");
			ValueWrapper valueWrapper = cache.get(OptimaCacheUtil.keyCreator(
					geographyId,processingUnit));
			if (valueWrapper != null) {
				return (GeographyFedSegVO) valueWrapper.get();
			} else {
				return null;
			}
		} catch (Exception e) {
			LOGGER.error(LOOKUP_EXCP + e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					LOOKUP_EXCP,
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));
		}

	}
	
	public ReportingPeriodVO getReportingPeriod(Integer reportingPeriod)
			throws OptimaRetailApplicationException {
		try {
			Cache cache = cacheManager.getCache("rptPeriodCache");
			ValueWrapper valueWrapper = cache.get(reportingPeriod);
			if (valueWrapper != null) {
				return (ReportingPeriodVO) valueWrapper.get();
			} else {
				return null;
			}
		} catch (Exception e) {
			LOGGER.error(LOOKUP_EXCP + e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					LOOKUP_EXCP,
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));
		}
	}

	public CalendarVO getValidCalendar(Integer pu)
			throws OptimaRetailApplicationException {
		try {
			Cache cache = cacheManager.getCache("calendarCache");
			ValueWrapper valueWrapper = cache.get(pu);
			if (valueWrapper != null) {
				return (CalendarVO) valueWrapper.get();
			} else {
				return null;
			}
		} catch (Exception e) {
			LOGGER.error(LOOKUP_EXCP + e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					LOOKUP_EXCP,
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));
		}

	}
	
	public List<Integer> getAllPus(String productCd,String cntryCd)
			throws OptimaRetailApplicationException {
		try {
			Cache cache = cacheManager.getCache("productToPUCache");
			ValueWrapper valueWrapper = cache.get(OptimaCacheUtil.keyCreator(productCd,cntryCd));
			if (valueWrapper != null) {
				return (List<Integer>) valueWrapper.get();
			} else {
				return null;
			}
		} catch (Exception e) {
			LOGGER.error(LOOKUP_EXCP + e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					LOOKUP_EXCP,
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));
		}

	}
	
	public String getRegionByCountry(String countryCd)
			throws OptimaRetailApplicationException {
		try {
			Cache cache = cacheManager.getCache("countryRegionCache");
			ValueWrapper valueWrapper = cache.get(OptimaCacheUtil.keyCreator(
					countryCd).toUpperCase());
			if (valueWrapper != null) {
				return (String) valueWrapper.get().toString();
			} else {
				return null;
			}
		}catch (Exception e) {
			LOGGER.error(LOOKUP_EXCP + e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					LOOKUP_EXCP,
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));
		}
	}
}
