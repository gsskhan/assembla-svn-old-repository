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
import com.citi.retail.optima.etl.common.model.cache.CollateralisedBandDomain;

/**
 * helper class for the Range/Band based reference data.
 * 
 * @author mc56120
 * 
 */
public class CollateralisedBandLookup extends SpringCacheBaseLookup {

	private final Logger LOGGER = (Logger) LoggerFactory
			.getLogger(CollateralisedBandLookup.class);
	
	private String bandName = "collateralised";

	public CollateralisedBandLookup(CacheManager cacheManager) {
		super(cacheManager);
	}

	@SuppressWarnings("unchecked")
	public CollateralisedBandDomain getCollateralisedSegmentationValue(Integer processingUnitId, Integer value, String segmentType)
			throws OptimaRetailApplicationException {
		try {			
				Cache flatCache = this.cacheManager
						.getCache(bandName + "FlatCache");

				ValueWrapper valueWrapper = flatCache.get(OptimaCacheUtil
						.keyCreator(processingUnitId, segmentType, value));

				if (valueWrapper != null) {
					return (CollateralisedBandDomain) valueWrapper.get();
				}
			
				
		} catch (Exception e) {
			this.LOGGER
					.error("Exception occured in Collateralise Band "
							+ e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					"Exception occured in Collateralise Band ",
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
	 * @throws OptimaRetailApplicationException
	 */
	public CollateralisedBandDomain deriveOutputSegmentation(Integer processingUnitId, Integer inputValue,
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
	 * @throws OptimaRetailApplicationException
	 */
	public CollateralisedBandDomain deriveOutputSegmentation(Integer processingUnitId, String inputValue,
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
	 * @throws OptimaRetailApplicationException
	 */
	private CollateralisedBandDomain deriveSegFromGenericInput(Integer processingUnitId, Object value, String inputSegmentType,
			String outputSegmentType) throws OptimaRetailApplicationException {
		try {
			Cache flatCache = this.cacheManager
					.getCache(bandName + "FlatCache");

			ValueWrapper valueWrapper = flatCache.get(OptimaCacheUtil
					.keyCreator(processingUnitId, inputSegmentType, value));

			if (valueWrapper != null) {

				CollateralisedBandDomain refBandVo = (CollateralisedBandDomain) valueWrapper.get();
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

						refBandVo = (CollateralisedBandDomain) valueWrapper.get();
						return refBandVo;
					}

				}

			}
		} catch (Exception e) {
			this.LOGGER
					.error("Exception occured in Collateralise Band "
							+ e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					"Exception occured in Collateralise Band ",
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
	 * @throws OptimaRetailApplicationException
	 */
	public String getOutputSegmentationId(Integer processingUnitId, Integer value, String inputSegmentType,
			String outputSegmentType) throws OptimaRetailApplicationException {
		try {
			Cache flatCache = this.cacheManager
					.getCache(bandName + "FlatCache");

			ValueWrapper valueWrapper = flatCache.get(OptimaCacheUtil
					.keyCreator(processingUnitId, inputSegmentType, value));

			if (valueWrapper != null) {
				CollateralisedBandDomain refBandVo = (CollateralisedBandDomain) valueWrapper.get();
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
					.error("Exception occured in Collateralised Band "
							+ e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					"Exception occured in Collateralised Band ",
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));			
		}
		return null;
	}
}