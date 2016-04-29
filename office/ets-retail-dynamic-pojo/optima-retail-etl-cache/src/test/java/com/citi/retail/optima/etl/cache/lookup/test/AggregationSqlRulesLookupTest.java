/**
 * 
 */
package com.citi.retail.optima.etl.cache.lookup.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.cache.lookup.AggregationSqlRuleLookup;
import com.citi.retail.optima.etl.cache.model.AggregationSqlRef;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;

/**
 * @author mc56120
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.rules.xml",
		"/optima.retail.cache.test.xml" })
public class AggregationSqlRulesLookupTest {
	@Autowired
	private AggregationSqlRuleLookup aggregationSqlLookup;

	@Test
	public void testAggregationSqlRulesLookup() throws OptimaRetailApplicationException {
		List<String> keyList = new ArrayList<String>();
		keyList.add("USCCARProcessStep:3");
		// keyList.add("MONTH:1");
		Map<String, AggregationSqlRef> resultMap = this.aggregationSqlLookup
				.getAggregationSql(keyList);
		Assert.assertNotNull(resultMap);
		Assert.assertTrue(resultMap.size() > 0);

		keyList.removeAll(keyList);
		keyList.add("invalidname");

		resultMap = this.aggregationSqlLookup.getAggregationSql(keyList);
		Assert.assertNull(resultMap);

	}
}
