/**
 * 
 */
package com.citi.retail.optima.etl.aggregation.model;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.citi.retail.optima.etl.aggregation.model.AggregationDAOHelper;

/**
 * @author mc56120
 * 
 */
public class AggregationDAOHelperTest {

	@Test
	public void testSetAggregationValues() {
		List<Number> aggregationValues = new ArrayList<Number>();
		List<String> aggregationKey = new ArrayList<String>();
		AggregationDAOHelper aggrHelper = new AggregationDAOHelper(
				aggregationKey, aggregationValues);
		Assert.assertTrue(aggrHelper.getAggregationKey().size() == 0);
		Assert.assertTrue(aggrHelper.getAggregationValues().size() == 0);

	}

}
