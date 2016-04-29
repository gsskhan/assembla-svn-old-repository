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
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ch.qos.logback.classic.Logger;

import com.citi.retail.optima.etl.aggregation.AggregationService;
import com.citi.retail.optima.etl.aggregation.exception.AggregationException;
import com.citi.retail.optima.etl.aggregation.exception.AggregationExceptionItem;
import com.citi.retail.optima.etl.aggregation.exception.ExceptionScope;
import com.citi.retail.optima.etl.aggregation.impl.AggregationServiceFactoryImpl;

/**
 * @author mc56120
 * 
 *         Verify the aggregation service is loaded properly
 * 
 *         Scenarios ----------
 * 
 *         Valid BatchId & Valid PU & Valid Category Valid BatchId & Valid PU &
 *         Category =null BatchId=null & Valid PU & Valid Category Valid BatchId
 *         & PU = null & Valid Category
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.aggregation.test.config.xml"})
public class AggregationServiceInstanceTest {
	
	private final static Logger LOGGER = (Logger) LoggerFactory
			.getLogger(AggregationServiceInstanceTest.class);
	@Autowired
	private AggregationServiceFactoryImpl<?> aggregationServiceFactoryImpl;

	private AggregationService<Object> aggregationService = null;

	/**
	 * Valid BatchId & Valid PU & Valid Category
	 * 
	 * @throws AggregationExpection
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testGetAggregationServiceScenario1() {
		List<String> keyList = new ArrayList<String>();
		Long batchId = 3L;
		String category = "USCCARProcessStep";
		String processingUnit = "3";
		String key = category + ":" + processingUnit;
	
		try {
			keyList.add(key);
			aggregationService = (AggregationService<Object>) aggregationServiceFactoryImpl
					.getAggregationService(keyList, batchId, new Date(),
							category);
			Assert.assertNotNull(aggregationService);
			LOGGER.info("Got Aggregation Service Instance... Pass ");
		} catch (AggregationException e) {
			e.printStackTrace();}

	}

	/**
	 * Valid BatchId, Valid PU & Category =null --> throws exception
	 * 
	 * @throws AggregationExpection
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testGetAggregationServiceScenario2()
			throws AggregationException {
		List<String> keyList = new ArrayList<String>();
		Long batchId = 3L;
		String processingUnit = "3";
		String category = "";
		String key = category + ":" + processingUnit;
		keyList.add(key);
		try {
			aggregationService = (AggregationService<Object>) aggregationServiceFactoryImpl
					.getAggregationService(keyList, batchId, new Date(),
							category);
		} catch (AggregationException e) {
			
			Assert.assertNotNull(e.getExceptionMessage());
		}
		Assert.assertNull(aggregationService);
	}

	/**
	 * BatchId = null & Valid PU & Valid Category --> throws exception
	 * 
	 * @throws AggregationExpection
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testGetAggregationServiceScenario3()
			throws AggregationException {
		List<String> keyList = new ArrayList<String>();
		Long batchId = null;
		String processingUnit = "3";
		String category = "cardsMonthEndStep";
		String key = category + ":" + processingUnit;
		keyList.add(key);
		try {
			aggregationService = (AggregationService<Object>) aggregationServiceFactoryImpl
					.getAggregationService(keyList, batchId, new Date(),
							category);
		} catch (AggregationException e) {
			Assert.assertNotNull(e.getExceptionMessage());
		}
		Assert.assertNull(aggregationService);
	}

	/**
	 * Valid BatchId & PU = null & Valid Category --> throws exception
	 * 
	 * @throws AggregationExpection
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testGetAggregationServiceScenario4()
			throws AggregationException {
		List<String> keyList = new ArrayList<String>();
		Long batchId = 5L;
		String processingUnit = null;
		String category = "cardsMonthEndStep";
		String key = category + ":" + processingUnit;
		keyList.add(key);
		try {
			aggregationService = (AggregationService<Object>) aggregationServiceFactoryImpl
					.getAggregationService(keyList, batchId, new Date(),
							category);
		} catch (AggregationException e) {
			Assert.assertNotNull(e.getExceptionMessage());
		}
		Assert.assertNull(aggregationService);
	}

	/**
	 * BatchId=null & PU = null & Category=null --> throws exception
	 * 
	 * @throws AggregationExpection
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testGetAggregationServiceScenario5()
			throws AggregationException {
		List<String> keyList = new ArrayList<String>();
		Long batchId = null;
		String processingUnit = null;
		String category = null;
		String key = category + ":" + processingUnit;
		keyList.add(key);
		try {
			aggregationService = (AggregationService<Object>) aggregationServiceFactoryImpl
					.getAggregationService(keyList, batchId, new Date(),
							category);
		} catch (AggregationException e) {
			Assert.assertNotNull(e.getExceptionMessage());
		}
		Assert.assertNull(aggregationService);
	}

}
