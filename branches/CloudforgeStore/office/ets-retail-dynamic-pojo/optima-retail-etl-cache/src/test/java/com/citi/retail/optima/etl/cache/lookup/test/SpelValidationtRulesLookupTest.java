package com.citi.retail.optima.etl.cache.lookup.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.cache.lookup.SpelValidationRulesLookup;
import com.citi.retail.optima.etl.cache.model.SPELidationRulesRef;

/**
 * @author mc56120
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.rules.xml",
		"/optima.retail.cache.test.xml" })
public class SpelValidationtRulesLookupTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpelValidationtRulesLookupTest.class);
	@Autowired
	private SpelValidationRulesLookup spelValidationRulesLookup;

	@Test
	public void testGetSpelValidationRules() throws Exception {

		List<String> keyList = new ArrayList<String>();
		keyList.add("USCCARProcessStep:"+3);
		Set<SPELidationRulesRef> rulesList = this.spelValidationRulesLookup
				.getSpelValidationRules(keyList);
		LOGGER.info("spel ValidationRules Map"+rulesList);
		Assert.assertNotNull(rulesList);
		Assert.assertTrue(rulesList.size() > 0);
		keyList.removeAll(keyList);
		keyList.add("invalidEntry");
		rulesList = this.spelValidationRulesLookup
				.getSpelValidationRules(keyList);
		Assert.assertNull(rulesList);
	}

}
