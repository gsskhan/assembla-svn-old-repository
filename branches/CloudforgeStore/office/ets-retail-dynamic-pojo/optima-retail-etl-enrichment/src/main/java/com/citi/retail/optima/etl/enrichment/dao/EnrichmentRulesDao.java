package com.citi.retail.optima.etl.enrichment.dao;

import java.util.List;

import com.citi.retail.optima.etl.enrichment.common.EnrichmentRule;
import com.citi.retail.optima.etl.enrichment.exception.EnrichmentException;

public interface EnrichmentRulesDao<E> {
	List<EnrichmentRule> getEnrichmentRules(String key) throws EnrichmentException;

}