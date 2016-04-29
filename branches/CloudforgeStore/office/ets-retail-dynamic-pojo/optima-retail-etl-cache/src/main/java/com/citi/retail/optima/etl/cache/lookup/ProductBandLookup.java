package com.citi.retail.optima.etl.cache.lookup;

import net.sf.ehcache.Element;

import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;

import ch.qos.logback.classic.Logger;

import com.citi.retail.optima.etl.cache.ehcache.OptimaCacheUtil;
import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;
import com.citi.retail.optima.etl.common.model.cache.ProductBandDomain;

/**
 * helper class for the Range/Band based reference data.
 * 
 * @author mc56120
 * 
 */
public class ProductBandLookup extends SpringCacheBaseLookup {

	private final Logger LOGGER = (Logger) LoggerFactory
			.getLogger(ProductBandLookup.class);	
	
	public ProductBandLookup(Cache cache) {
		super(cache);
	}

	@SuppressWarnings("unchecked")
	public ProductBandDomain getProductSegmentationValue(Integer processingUnitId, String productCd,String segType)
			throws OptimaRetailApplicationException {
		try {
			Element productBand = this.ehCache.get(OptimaCacheUtil
						.keyCreator(productCd.toLowerCase(), processingUnitId,segType.toLowerCase()));

				if (productBand != null) {
					return (ProductBandDomain) productBand.getObjectValue();
				}
			
				
		} catch (Exception e) {
			this.LOGGER
					.error("Exception occured in Product Band "
							+ e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					"Exception occured in Product Band ",
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));			
		}

		return null;
	}	
}