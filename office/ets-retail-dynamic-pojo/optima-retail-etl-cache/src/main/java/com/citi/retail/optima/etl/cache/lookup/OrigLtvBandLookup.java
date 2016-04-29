package com.citi.retail.optima.etl.cache.lookup;

import java.util.Map.Entry;
import java.util.TreeMap;

import net.sf.ehcache.Ehcache;

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
import com.citi.retail.optima.etl.common.model.cache.OrigLtvBandDomain;

/**
 * helper class for the Range/Band based reference data.
 * 
 * @author mc56120
 * 
 */
public class OrigLtvBandLookup extends SpringCacheBaseLookup {

	private final Logger LOGGER = (Logger) LoggerFactory
			.getLogger(OrigLtvBandLookup.class);

	public OrigLtvBandLookup(CacheManager cacheManager) {
		super(cacheManager);
	}
	
	private String bandName = "ltv";

	private static final String LTV_LUK_EXCP = "Exception occured while loading LTV Lookup ";
	
	@SuppressWarnings("unchecked")
	public OrigLtvBandDomain getOrigLtvSegmentationValue(Integer processingUnitId, Integer value, String segmentType)
			throws OptimaRetailApplicationException {
		try {
			Cache cache = this.cacheManager.getCache(bandName + "Cache");
			ValueWrapper valueWrapper = cache.get(OptimaCacheUtil.keyCreator(
					processingUnitId, segmentType));

			if (valueWrapper != null) {
				TreeMap<Integer, OrigLtvBandDomain> segmentationBandMap = (TreeMap<Integer, OrigLtvBandDomain>) valueWrapper
						.get();
				Entry<Integer, OrigLtvBandDomain> map;

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
					.error(LTV_LUK_EXCP + e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					LTV_LUK_EXCP,
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));
		}

		return null;
	}

	/**
	 * 
	 * @param bandName
	 * @param processingUnitId
	 * @param inputValue
	 * @param inputSegmentType
	 * @param outputSegmentType
	 * @return
	 * @throws OptimaRetailException
	 */
	public OrigLtvBandDomain deriveOutputSegmentation(Integer processingUnitId, Integer inputValue,
			String inputSegmentType, String outputSegmentType)
			throws OptimaRetailApplicationException {

		return deriveSegFromGenericInput(processingUnitId,
				inputValue, inputSegmentType, outputSegmentType);
	}

	/**
	 * 
	 * @param bandName
	 * @param processingUnitId
	 * @param inputValue
	 * @param inputSegmentType
	 * @param outputSegmentType
	 * @return
	 * @throws OptimaRetailException
	 */
	public OrigLtvBandDomain deriveOutputSegmentation(Integer processingUnitId, String inputValue,
			String inputSegmentType, String outputSegmentType)
			throws OptimaRetailApplicationException {

		return deriveSegFromGenericInput(processingUnitId,
				inputValue, inputSegmentType, outputSegmentType);
	}

	/**
	 * 
	 * @param bandName
	 * @param processingUnitId
	 * @param value
	 * @param inputSegmentType
	 * @param outputSegmentType
	 * @return
	 * @throws OptimaRetailException
	 */
	private OrigLtvBandDomain deriveSegFromGenericInput(Integer processingUnitId, Object value, String inputSegmentType,
			String outputSegmentType) throws OptimaRetailApplicationException {
		try {
			Cache flatCache = this.cacheManager
					.getCache(bandName + "FlatCache");

			ValueWrapper valueWrapper = flatCache.get(OptimaCacheUtil
					.keyCreator(processingUnitId, inputSegmentType, value));

			if (valueWrapper != null) {

				OrigLtvBandDomain refBandVo = (OrigLtvBandDomain) valueWrapper
						.get();
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

						refBandVo = (OrigLtvBandDomain) valueWrapper.get();
						return refBandVo;
					}

				}

			}
		} catch (Exception e) {
			this.LOGGER
					.error(LTV_LUK_EXCP + e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					LTV_LUK_EXCP,
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));
		}

		return null;
	}

	/**
	 * 
	 * @param bandName
	 * @param processingUnitId
	 * @param value
	 * @param inputSegmentType
	 * @param outputSegmentType
	 * @return
	 * @throws OptimaRetailException
	 */
	public String getOutputSegmentationId(Integer processingUnitId, Integer value, String inputSegmentType,
			String outputSegmentType) throws OptimaRetailApplicationException {
		try {
			Cache flatCache = this.cacheManager
					.getCache(bandName + "FlatCache");

			ValueWrapper valueWrapper = flatCache.get(OptimaCacheUtil
					.keyCreator(processingUnitId, inputSegmentType, value));

			if (valueWrapper != null) {
				OrigLtvBandDomain refBandVo = (OrigLtvBandDomain) valueWrapper
						.get();
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
					.error(LTV_LUK_EXCP + e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					LTV_LUK_EXCP,
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));
		}
		return null;
	}
}