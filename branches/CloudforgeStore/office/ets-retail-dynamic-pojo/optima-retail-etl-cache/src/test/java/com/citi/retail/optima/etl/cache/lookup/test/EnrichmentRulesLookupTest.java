package com.citi.retail.optima.etl.cache.lookup.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.cache.ehcache.EnrichmentRulesLoaderImpl;
import com.citi.retail.optima.etl.cache.lookup.EnrichmentRulesLookup;

/**
 * @author mc56120
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.rules.xml",
		"/optima.retail.cache.test.xml" })
public class EnrichmentRulesLookupTest {

	@Autowired
	private EnrichmentRulesLookup enrichmentRulesLookup;

	@Autowired
	private EnrichmentRulesLoaderImpl enrichCacheLoader;

	/*
	 * @Test public void testEnrichRulesLoad() throws Exception {
	 * Assert.assertNotNull(rulesDaoImpl.getEnrichmentRules()); }
	 */
	@Test
	public void testGetEnrichmentRules() throws Exception {

		List<String> keyList = new ArrayList<String>();
		// keyList.add("MONTH:" + 1);
		// keyList.add("MONTH:" + 2);
		keyList.add("USCCARProcessStep:" + 3);

		// Map<Integer,Map<String, String>> results =
		// enrichmentRulesLookup.getEnrichmentRules(processingUnitIds);
		Set<String> results = this.enrichmentRulesLookup
				.getEnrichmentRules(keyList);

		Assert.assertNotNull(results);
		Assert.assertTrue(results.size() > 0);

		keyList.removeAll(keyList);

		keyList.add("invalidEntry");
		results = this.enrichmentRulesLookup.getEnrichmentRules(keyList);

		Assert.assertNull(results);
	}

	/*
	 * @Mock private EnrichmentRulesLookup enrichmentRulesLookup;
	 * 
	 * @Test public void testEnrichmentLookup() throws OptimaRetailException {
	 * when(enrichmentRulesLookup.getEnrichmentRules("CARDS", "", ""))
	 * .thenReturn(populateEnrichmentRules());
	 * 
	 * LinkedHashMap<String, String> rulesMap = enrichmentRulesLookup
	 * .getEnrichmentRules("CARDS", "", ""); Assert.assertNotNull(rulesMap);
	 * Assert.assertTrue(rulesMap.size() > 0); }
	 *//**
	 * populate dummy enrichment rules
	 * 
	 * @return
	 */
	/*
	 * private LinkedHashMap<String, String> populateEnrichmentRules() {
	 * LinkedHashMap<String, String> rulesMap = new LinkedHashMap<String,
	 * String>(); EnrichmentRulesRef ref = new EnrichmentRulesRef();
	 * ref.setProductName("CARDS"); ref.setFunctionName("CCAR");
	 * ref.setProcessingUnitId(1); ref.setRuleToExecute("test rule");
	 * ref.setRuleAttribute("test attribute"); ref.setRuleOrder(1);
	 * rulesMap.put(ref.getRuleAttribute(), ref.getRuleToExecute()); return
	 * rulesMap;
	 * 
	 * }
	 */

}
