/**
 * 
 */
package com.citi.retail.optima.etl.cache.lookup.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.cache.ehcache.AggregationRulesLoaderImpl;
import com.citi.retail.optima.etl.cache.lookup.AggregationRulesLookup;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.model.AggregationType;

/**
 * @author mc56120
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.rules.xml",
		"/optima.retail.cache.test.xml" })
public class AggregationRulesLookupTest {

	@Autowired
	private AggregationRulesLookup aggregationRulesLookup;

	@Autowired
	private AggregationRulesLoaderImpl aggregationCacheLoader;

	@Test
	public void testAggregationRulesLookupWithResult()
			throws OptimaRetailApplicationException {
		List<String> keyList = new ArrayList<String>();
		keyList.add("USCCARProcessStep:3");
		// keyList.add("cardsMonthEndStep:1");
		List<AggregationType> aggregationTypeList = this.aggregationRulesLookup
				.getAggregationRules(keyList);
		Assert.assertNotNull(aggregationTypeList);
		Assert.assertTrue(aggregationTypeList.size() > 0);

	}

	@Test
	public void testAggregationRulesLookupNoResult()
			throws OptimaRetailApplicationException {
		List<String> keyList = new ArrayList<String>();
		keyList.add("cardsMonthEndStepTest:3000");

		List<AggregationType> aggregationTypeList = this.aggregationRulesLookup
				.getAggregationRules(keyList);
		Assert.assertNull(aggregationTypeList);
	}
}
