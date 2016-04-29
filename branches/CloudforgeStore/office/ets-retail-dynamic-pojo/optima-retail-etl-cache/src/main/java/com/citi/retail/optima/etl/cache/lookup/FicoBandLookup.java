package com.citi.retail.optima.etl.cache.lookup;

import java.util.Map.Entry;
import java.util.TreeMap;

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
import com.citi.retail.optima.etl.common.model.cache.FicoBandDomain;

/**
 * @author sr67841 This is the helper class for the Range/Band based reference
 *         data. Ex:- FICO
 * 
 */
public class FicoBandLookup extends SpringCacheBaseLookup {

	private final Logger LOGGER = (Logger) LoggerFactory
			.getLogger(FicoBandLookup.class);

	public FicoBandLookup(CacheManager cacheManager) {
		super(cacheManager);
	}
	private String bandName = "fico";
	private static final String FICO_LUK_EXCP = "Exception occured while loading FICO band Lookup ";
	
	@SuppressWarnings("unchecked")
	public FicoBandDomain getFicoSegmentationValue(Integer processingUnitId, Integer value, String segmentType)
			throws OptimaRetailApplicationException {
		try {
			Cache cache = this.cacheManager.getCache(bandName + "Cache");
			ValueWrapper valueWrapper = cache.get(OptimaCacheUtil.keyCreator(
					processingUnitId, segmentType));

			if (valueWrapper != null) {
				TreeMap<Integer, FicoBandDomain> segmentationBandMap = (TreeMap<Integer, FicoBandDomain>) valueWrapper
						.get();
				Entry<Integer, FicoBandDomain> map;

				if (value != null) {
					map = segmentationBandMap.ceilingEntry(value);
					if (map != null) {
						return map.getValue();
					} else {
						return null;
					}
				} else {
					return null;
				}
			}
		} catch (Exception e) {
			this.LOGGER
					.error(FICO_LUK_EXCP + e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					FICO_LUK_EXCP,
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	public FicoBandDomain deriveOutputSegmentation(Integer processingUnitId, Integer inputValue,
			String inputSegmentType, String outputSegmentType)
			throws OptimaRetailApplicationException {

		return deriveSegFromGenericInput(processingUnitId,
				inputValue, inputSegmentType, outputSegmentType);
	}

	@SuppressWarnings("unchecked")
	public FicoBandDomain deriveOutputSegmentation(Integer processingUnitId, String inputValue,
			String inputSegmentType, String outputSegmentType)
			throws OptimaRetailApplicationException {

		return deriveSegFromGenericInput(processingUnitId,
				inputValue, inputSegmentType, outputSegmentType);
	}

	private FicoBandDomain deriveSegFromGenericInput(Integer processingUnitId, Object value, String inputSegmentType,
			String outputSegmentType) throws OptimaRetailApplicationException {
		try {
			Cache flatCache = this.cacheManager
					.getCache(bandName + "FlatCache");

			ValueWrapper valueWrapper = flatCache.get(OptimaCacheUtil
					.keyCreator(processingUnitId, inputSegmentType, value));

			if (valueWrapper != null) {

				FicoBandDomain refBandVo = (FicoBandDomain) valueWrapper.get();
				Cache mappingCache = this.cacheManager.getCache(bandName
						+ "MappingCache");
				valueWrapper = mappingCache.get(OptimaCacheUtil.keyCreator(
						refBandVo.getKeyId(), outputSegmentType));
				if (valueWrapper != null) {
					Integer refMappingId = (Integer) valueWrapper.get();

					Cache idCache = this.cacheManager.getCache(bandName
							+ "IdCache");

					valueWrapper = idCache.get(OptimaCacheUtil
							.keyCreator(refMappingId));

					if (valueWrapper != null) {

						refBandVo = (FicoBandDomain) valueWrapper.get();
						return refBandVo;
					}

				}

			}
		} catch (Exception e) {
			this.LOGGER
					.error(FICO_LUK_EXCP + e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					FICO_LUK_EXCP,
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));
		}

		return null;
	}

	public String getOutputSegmentationId(Integer processingUnitId, Integer value, String inputSegmentType,
			String outputSegmentType) throws OptimaRetailApplicationException {
		try {
			Cache flatCache = this.cacheManager
					.getCache(bandName + "FlatCache");

			ValueWrapper valueWrapper = flatCache.get(OptimaCacheUtil
					.keyCreator(processingUnitId, inputSegmentType, value));

			if (valueWrapper != null) {
				FicoBandDomain refBandVo = (FicoBandDomain) valueWrapper.get();
				Cache mappingCache = this.cacheManager.getCache(bandName
						+ "MappingCache");
				valueWrapper = mappingCache.get(OptimaCacheUtil.keyCreator(
						refBandVo.getKeyId(), outputSegmentType));
				if (valueWrapper != null) {
					Integer refMappingId = (Integer) valueWrapper.get();
					return refMappingId.toString();
				}
			}
		} catch (Exception e) {
			this.LOGGER
					.error(FICO_LUK_EXCP + e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					FICO_LUK_EXCP,
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));			
		}
		return null;
	}
}