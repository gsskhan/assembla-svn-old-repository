/**
 * 
 */
package com.citi.retail.optima.etl.aggregation.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.aggregation.AggregationService;
import com.citi.retail.optima.etl.aggregation.exception.AggregationException;
import com.citi.retail.optima.etl.aggregation.impl.AggregationServiceFactoryImpl;

/**
 * @author mc56120
 * 
 *         Verify the aggregation service is de-referenced properly(clear
 *         aggregation service map after job is done)
 * 
 *         Scenarios ----------
 * 
 *         Valid BatchId & Valid Category BatchId = null & Category =null Valid
 *         BatchId & Category =null
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.aggregation.test.config.xml"})
public class AggregationServiceClearTest {

	@Autowired
	private AggregationServiceFactoryImpl<?> aggregationServiceFactoryImpl;

	private AggregationService<Object> aggregationService = null;

	/**
	 * clear aggregation service map after job is done valid batchId + valid
	 * category
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void clearAggregationServiceTestScenario1() {
		List<String> keyList = new ArrayList<String>();
		Long batchId = 3L;
		String category = "cardsMonthEndStep";
		String key = null;
		try {
			key = aggregationServiceFactoryImpl.getAggregationKey(batchId,
					category);
			keyList.add(key);
			aggregationService = (AggregationService<Object>) aggregationServiceFactoryImpl
					.getAggregationService(keyList, batchId, new Date(),
							category);
			Assert.assertNotNull(aggregationService);
			Assert.assertNotNull(aggregationServiceFactoryImpl
					.getAggregationServiceMap().get(key));
			aggregationServiceFactoryImpl.clearAggregationServiceFromMap(
					batchId, category);
		} catch (AggregationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertNull(aggregationServiceFactoryImpl
				.getAggregationServiceMap().get(key));
	}

	/**
	 * batchId=null, categoryName=null
	 */
	@Test
	public void clearAggregationServiceTestScenario2() {
		List<String> keyList = new ArrayList<String>();
		Long batchId = 3L;
		String category = "cardsMonthEndStep";
		try {
			String key = aggregationServiceFactoryImpl.getAggregationKey(
					batchId, category);
			keyList.add(key);
			aggregationService = (AggregationService<Object>) aggregationServiceFactoryImpl
					.getAggregationService(keyList, batchId, new Date(),
							category);
			Assert.assertNotNull(aggregationService);

			Assert.assertNotNull(aggregationServiceFactoryImpl
					.getAggregationServiceMap().get(key));
			batchId = null;
			category = null;
			key = aggregationServiceFactoryImpl.getAggregationKey(batchId,
					category);
			aggregationServiceFactoryImpl.clearAggregationServiceFromMap(
					batchId, category);
			Assert.assertNull(aggregationServiceFactoryImpl
					.getAggregationServiceMap().get(key));
		} catch (AggregationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Valid batchId, categoryName=null
	 */
	@Test
	public void clearAggregationServiceTestScenario3() {
		List<String> keyList = new ArrayList<String>();
		Long batchId = 3L;
		String category = "cardsMonthEndStep";
		try {
			String key = aggregationServiceFactoryImpl.getAggregationKey(
					batchId, category);
			keyList.add(key);
			aggregationService = (AggregationService<Object>) aggregationServiceFactoryImpl
					.getAggregationService(keyList, batchId, new Date(),
							category);
			Assert.assertNotNull(aggregationService);

			Assert.assertNotNull(aggregationServiceFactoryImpl
					.getAggregationServiceMap().get(key));

			category = null;
			key = aggregationServiceFactoryImpl.getAggregationKey(4L, category);
			aggregationServiceFactoryImpl.clearAggregationServiceFromMap(
					batchId, category);
			Assert.assertNull(aggregationServiceFactoryImpl
					.getAggregationServiceMap().get(key));
		} catch (AggregationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
