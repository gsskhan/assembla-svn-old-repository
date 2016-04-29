/**
 * 
 */
package com.citi.retail.optima.etl.cache.lookup.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;

import com.citi.retail.optima.etl.cache.dao.impl.EnrichmentRulesDaoImpl;

/**
 * @author mc56120
 * 
 */

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration({ "/optima.retail.cache.rules.xml",
		"/optima.retail.cache.test.xml" })
public class EnrichmentRulesDaoImplMockTest {

	@Mock
	private EnrichmentRulesDaoImpl rulesDaoImpl;

	@Before
	public void init() {
	//	when(rulesDaoImpl.getEnrichmentRules()).thenReturn(
	//			new ArrayList<EnrichmentRulesRef>());
	}

	@Test
	public void testEnrichRulesLoad() throws Exception {
		Assert.assertTrue(rulesDaoImpl.getEnrichmentRules().size() == 0);
		Assert.assertFalse(rulesDaoImpl.getEnrichmentRules().size() > 0);
	}
}
