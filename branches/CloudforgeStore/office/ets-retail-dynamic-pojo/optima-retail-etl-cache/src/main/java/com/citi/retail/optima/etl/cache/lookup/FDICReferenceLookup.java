package com.citi.retail.optima.etl.cache.lookup;

import java.util.Map.Entry;
import java.util.TreeMap;

import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.CacheManager;

import ch.qos.logback.classic.Logger;

import com.citi.retail.optima.etl.cache.ehcache.OptimaCacheUtil;
import com.citi.retail.optima.etl.cache.model.FICOScoreVO;
import com.citi.retail.optima.etl.cache.model.ModelRangeVO;
import com.citi.retail.optima.etl.cache.model.PDRangeVo;
import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;

public class FDICReferenceLookup extends SpringCacheBaseLookup {

	private final Logger LOGGER = (Logger) LoggerFactory
			.getLogger(FDICReferenceLookup.class);

	private static final String FDIC_LUK_EXCP = "Exception occured while loading ReferenceBand Lookup ";
	
	public FDICReferenceLookup(CacheManager cacheManager) {
		super(cacheManager);
	}

	@SuppressWarnings("unchecked")
	public Integer getPDRangeSegment(Float inputPDRange)
			throws OptimaRetailApplicationException {

		try {
			Cache cache = cacheManager.getCache("pdRangeCache");
			ValueWrapper valueWrapper = cache.get("0");

			if (valueWrapper != null) {

				TreeMap<Float, PDRangeVo> segmentationBandMap = (TreeMap<Float, PDRangeVo>) valueWrapper
						.get();
				Entry<Float, PDRangeVo> map;

				if (inputPDRange != null) {
					map = segmentationBandMap.ceilingEntry(inputPDRange);
					if (map != null) {
						return map.getValue().getSegVal();
					}
				}
			}
		} catch (Exception e) {
			LOGGER.error(FDIC_LUK_EXCP + e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					FDIC_LUK_EXCP,
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));
		}

		return null;

	}

	public Boolean getFICOSplScore(Integer reportingPeriod, Integer ficoScore)
			throws OptimaRetailApplicationException {

		try {
			Cache cache = cacheManager.getCache("ficoSplScrCache");
			ValueWrapper valueWrapper = cache.get(OptimaCacheUtil.keyCreator(
					reportingPeriod, ficoScore));

			if (valueWrapper != null) {

				return ((FICOScoreVO) valueWrapper.get()).getSplScoreFlag();

			} else {
				return false;
			}
		} catch (Exception e) {
			LOGGER.error(FDIC_LUK_EXCP + e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					FDIC_LUK_EXCP,
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));			
		}

	}

	public Boolean getFICOIncludeScore(Integer reportingPeriod,
			Integer ficoScore) throws OptimaRetailApplicationException {

		try {
			Cache cache = cacheManager.getCache("ficoSplScrCache");
			ValueWrapper valueWrapper = cache.get(OptimaCacheUtil.keyCreator(
					reportingPeriod, ficoScore));

			if (valueWrapper != null) {

				return ((FICOScoreVO) valueWrapper.get()).getIncludeFlag();

			} else {
				return false;
			}
		} catch (Exception e) {
			LOGGER.error(FDIC_LUK_EXCP + e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					FDIC_LUK_EXCP,
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));
		}

	}

	public FICOScoreVO getFicoPDMap(String creditBureau, String modelVersion,
			Integer modelScore) throws OptimaRetailApplicationException {

		try {
			Cache cache = cacheManager.getCache("ficoPdMapCache");
			ValueWrapper valueWrapper = cache.get(OptimaCacheUtil.keyCreator(
					creditBureau, modelVersion, modelScore));

			if (valueWrapper != null) {

				return (FICOScoreVO) valueWrapper.get();

			} else {
				return null;
			}
		} catch (Exception e) {
			LOGGER.error(FDIC_LUK_EXCP + e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					FDIC_LUK_EXCP,
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));
		}

	}

	public Double getFicoPDPercent(String creditBureau, String modelVersion,
			Integer modelScore, String productType)
			throws OptimaRetailApplicationException {

		try {
			FICOScoreVO ficoScoreVO = getFicoPDMap(creditBureau, modelVersion,
					modelScore);
			if (ficoScoreVO != null) {
				return ficoScoreVO.getProductPDMap().get(productType);
			}

		} catch (Exception e) {
			LOGGER.error(FDIC_LUK_EXCP + e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					FDIC_LUK_EXCP,
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));
		}
		return null;
	}

	public ModelRangeVO getModelRange(String creditBureau, String modelVersion)
			throws OptimaRetailApplicationException {

		try {
			Cache cache = cacheManager.getCache("ficoModelRangeCache");
			ValueWrapper valueWrapper = cache.get(OptimaCacheUtil.keyCreator(
					creditBureau, modelVersion));

			if (valueWrapper != null) {

				return (ModelRangeVO) valueWrapper.get();

			} else {
				return null;
			}
		} catch (Exception e) {
			LOGGER.error(FDIC_LUK_EXCP + e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					FDIC_LUK_EXCP,
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));
		}

	}

}
