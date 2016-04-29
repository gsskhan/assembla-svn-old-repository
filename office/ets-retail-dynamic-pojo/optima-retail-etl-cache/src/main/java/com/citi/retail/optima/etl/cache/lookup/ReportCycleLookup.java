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
import com.citi.retail.optima.etl.common.model.cache.ReportCycleDomain;

/**
 * @author sr67841 This is the helper class for the Value based reference data.
 *         Ex:- Region
 * 
 */
public class ReportCycleLookup extends SpringCacheBaseLookup {

	private final Logger LOGGER = (Logger) LoggerFactory
			.getLogger(ReportCycleLookup.class);

	public ReportCycleLookup(CacheManager cacheManager) {
		super(cacheManager);
	}

	public ReportCycleLookup(Cache cache) {
		super(cache);
	}

	private static final String LLR_REPORT_CYCLE_EXCP = "Exception occured while loading Llr Report Cycle Lookup";

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

	public ReportCycleDomain getRptCycId(String rptCycName, String rptCycleQtr,
			String rptCycleYear) throws OptimaRetailApplicationException {
		try {
			Cache cache = cacheManager.getCache("rptCycleCache");
			String key = OptimaCacheUtil.keyCreator(rptCycName, rptCycleQtr,
					rptCycleYear);
			ValueWrapper valueWrapper = cache.get(key);

			if (valueWrapper != null) {
				return (ReportCycleDomain) valueWrapper.get();
			}

		} catch (Exception e) {
			LOGGER.error(LLR_REPORT_CYCLE_EXCP + e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					LLR_REPORT_CYCLE_EXCP, e.getMessage(),
					OptimaRetailExceptionUtil.getStackTrace(e));
		}
		return null;
	}

}
