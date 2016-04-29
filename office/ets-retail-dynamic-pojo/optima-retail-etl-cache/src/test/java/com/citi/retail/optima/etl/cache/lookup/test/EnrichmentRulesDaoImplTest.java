package com.citi.retail.optima.etl.cache.lookup.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.cache.dao.impl.EnrichmentRulesDaoImpl;

/**
 * @author mc56120
 * 
 */

// @RunWith(MockitoJUnitRunner.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.rules.xml",
		"/optima.retail.cache.test.xml" })
public class EnrichmentRulesDaoImplTest {

	@Autowired
	private EnrichmentRulesDaoImpl rulesDaoImpl;

	@Test
	public void testEnrichRulesLoad() throws Exception {
		Assert.assertNotNull(this.rulesDaoImpl.getEnrichmentRulesWithKey());
		Assert.assertTrue(this.rulesDaoImpl.getEnrichmentRulesWithKey().size() > 0);
	}

	@Test
	public void testGetCacheData() throws Exception {
		Assert.assertNotNull(this.rulesDaoImpl.getCacheData(new Object[0]));
	}

	/*
	 * @Mock private EnrichmentRulesDaoImpl rulesDaoImpl;
	 * 
	 * @Before public void init() {
	 * when(rulesDaoImpl.getEnrichmentRules()).thenReturn( new
	 * ArrayList<EnrichmentRulesRef>()); }
	 * 
	 * @Test public void testEnrichRulesLoad() throws Exception {
	 * Assert.assertTrue(rulesDaoImpl.getEnrichmentRules().size() == 0);
	 * Assert.assertFalse(rulesDaoImpl.getEnrichmentRules().size() > 0); }
	 */
}
