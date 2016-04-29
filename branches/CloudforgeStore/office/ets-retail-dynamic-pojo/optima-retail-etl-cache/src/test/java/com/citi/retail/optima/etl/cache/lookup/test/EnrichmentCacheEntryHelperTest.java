package com.citi.retail.optima.etl.cache.lookup.test;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;

import com.citi.retail.optima.etl.cache.dao.impl.EnrichmentRulesDaoImpl;
import com.citi.retail.optima.etl.cache.helper.EnrichmentCacheEntryHelper;
import com.citi.retail.optima.etl.cache.model.EnrichmentRulesRef;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;

/**
 * @author mc56120
 * 
 */

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration({ "/optima.retail.cache.rules.xml",
		"/optima.retail.cache.test.xml" })
public class EnrichmentCacheEntryHelperTest {

	/*
	 * @Autowired private EnrichmentRulesDaoImpl rulesDaoImpl;
	 * 
	 * @Autowired private EnrichmentCacheEntryHelper enrichCacheEntryHelper;
	 * 
	 * @Test public void testEnrichmentRulesEntryHelper() throws Exception {
	 * List<EnrichmentRulesRef> results = rulesDaoImpl.getEnrichmentRules();
	 * Assert.assertNotNull(results);
	 * Assert.assertNotNull(enrichCacheEntryHelper.getKey(results.get(0)));
	 * Assert.assertNotNull(enrichCacheEntryHelper.getValue(results.get(0)));
	 * 
	 * }
	 */

	@Mock
	private EnrichmentRulesDaoImpl rulesDaoImpl;

	private EnrichmentCacheEntryHelper enrichCacheEntryHelper;

	@Before
	public void init() throws OptimaRetailApplicationException {
		when(rulesDaoImpl.getEnrichmentRules()).thenReturn(
				populateEnrichmentRules());
		enrichCacheEntryHelper = new EnrichmentCacheEntryHelper();
	}

	@Test
	public void testEnrichRulesLoad() throws Exception {
		List<EnrichmentRulesRef> results = rulesDaoImpl.getEnrichmentRules();
		Assert.assertNotNull(results);
		Assert.assertNotNull(enrichCacheEntryHelper.getKey(results.get(0)));
		Assert.assertNotNull(enrichCacheEntryHelper.getValue(results.get(0)));
	}

	/**
	 * populate dummy enrichment rules
	 * 
	 * @return
	 */
	private List<EnrichmentRulesRef> populateEnrichmentRules() {
		List<EnrichmentRulesRef> rules = new ArrayList<EnrichmentRulesRef>();
		EnrichmentRulesRef ref = new EnrichmentRulesRef();
		ref.setProductName("CARDS");
		ref.setFunctionName("CCAR");
		ref.setProcessingUnitId(1);
		ref.setRuleToExecute("test rule");
		ref.setRuleOrder(1);
		rules.add(ref);
		return rules;
	}

}
