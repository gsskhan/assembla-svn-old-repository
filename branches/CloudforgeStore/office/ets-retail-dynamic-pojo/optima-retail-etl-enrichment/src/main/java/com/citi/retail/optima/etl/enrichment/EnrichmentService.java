package com.citi.retail.optima.etl.enrichment;

import com.citi.retail.optima.etl.enrichment.exception.EnrichmentException;

/**
 * 
 * @author MS04453 This Interface is implemented by actual Enrichment service
 *         for each of the account Type. This declares/defines the methods that
 *         perform enrichment across different account types.
 * @param <T>
 */
public interface EnrichmentService<T> {

	/**
	 * The implementation of this method has to provide the functionality of
	 * enriching the current account object being passed.
	 * 
	 * @param currentAccount
	 * @return enriched Account Object of same type
	 * @throws OptimaRetailApplicationException
	 */
	T enrich(T currentAccount) throws EnrichmentException;

}
