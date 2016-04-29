package com.citi.retail.optima.etl.aggregation.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ch.qos.logback.classic.Logger;

import com.citi.retail.optima.etl.aggregation.dao.AggregationRuleSql;
import com.citi.retail.optima.etl.aggregation.exception.AggregationException;
import com.citi.retail.optima.etl.aggregation.exception.AggregationExceptionItem;
import com.citi.retail.optima.etl.aggregation.exception.ExceptionScope;

/**
 * @author mc56120
 * 
 *         Verify the aggregation rules load from aggregation service factory
 * 
 *         Scenarios ----------
 * 
 *         Valid PU & Valid Category Invalid PU & Valid Category Valid PU &
 *         Invalid Category Invalid PU & Invalid Category
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.aggregation.test.config.xml" })
public class AggregationSqlRulesLoaderTest {
	private final static Logger LOGGER = (Logger) LoggerFactory
			.getLogger(AggregationSqlRulesLoaderTest.class);
	@Autowired
	private AggregationServiceFactoryImpl<?> aggregationServiceFactoryImpl;

	/**
	 * Valid PU and Valid Category
	 */
	@Test
	public void testLoadAggrRuleFromAggrFactoryScenario1()
			throws AggregationException {
		List<String> keyList = new ArrayList<String>();
		String processingUnit = "3";
		String category = "USCCARProcessStep";
		String key = category + ":" + processingUnit;
		keyList.add(key);
		Map<String, AggregationRuleSql> aggrSqlMap = aggregationServiceFactoryImpl
				.loadAggregationInsertSqlRules(keyList);
		Assert.assertNotNull(aggrSqlMap);
		Assert.assertTrue(aggrSqlMap.keySet().size() > 0);
		
		LOGGER.info("Got Aggregation Rule with Valid PU and Valid Category... Pass ");
	}

	/**
	 * InValid PU and Valid Category
	 */
	@Test
	public void testLoadAggrRuleFromAggrFactoryScenario2()
			throws AggregationException {
		List<String> keyList = new ArrayList<String>();
		String processingUnit = "342342424";
		String category = "cardsMonthEndStep";
		String key = category + ":" + processingUnit;
		keyList.add(key);
		Map<String,  AggregationRuleSql> aggrSqlMap = null;
		String aggregation_error_msg = "Aggreagtion Service would not be loaded for "
				+ " ProcessingUnit: "
				+ keyList
				+ " as there are no Aggregation Output Insert SQL Specified for the given criteria.";
		try {
			aggrSqlMap = aggregationServiceFactoryImpl
					.loadAggregationInsertSqlRules(keyList);
		} catch (AggregationException e) {
			
			
			Assert.assertEquals(aggregation_error_msg, e.getExceptionItems().get(0).
					getExceptionsDetail().
					get(ExceptionScope.SERVICE.name()).
					get(AggregationExceptionItem.KeyDefnition.USER_MESSAGE));

		}
		Assert.assertNull(aggrSqlMap);
		LOGGER.info("No Aggregation Rule with Invalid PU... Pass ");
	}

	/**
	 * Valid PU and InValid Category
	 */
	@Test
	public void testLoadAggrRuleFromAggrFactoryScenario3()
			throws AggregationException {
		List<String> keyList = new ArrayList<String>();
		String processingUnit = "3";
		String category = "cardsMonthEndStepTest12334";
		String key = category + ":" + processingUnit;
		keyList.add(key);
		Map<String,  AggregationRuleSql> aggrSqlMap = null;
		String aggregation_error_msg = "Aggreagtion Service would not be loaded for "
				+ " ProcessingUnit: "
				+ keyList
				+ " as there are no Aggregation Output Insert SQL Specified for the given criteria.";
		try {
			aggrSqlMap = aggregationServiceFactoryImpl
					.loadAggregationInsertSqlRules(keyList);
		} catch (AggregationException e) {
			Assert.assertEquals(aggregation_error_msg, e.getExceptionItems().get(0).
					getExceptionsDetail().
					get(ExceptionScope.SERVICE.name()).
					get(AggregationExceptionItem.KeyDefnition.USER_MESSAGE));
		}
		Assert.assertNull(aggrSqlMap);
		LOGGER.info("No Aggregation Rule with PU and Invalid Category... Pass ");
	}

	/**
	 * InValid PU and InValid Category
	 */
	@Test
	public void testLoadAggrRuleFromAggrFactoryScenario4()
			throws AggregationException {
		List<String> keyList = new ArrayList<String>();
		String processingUnit = "342342424";
		String category = "cardsMonthEndStepTest121243";
		String key = category + ":" + processingUnit;
		keyList.add(key);
		Map<String, AggregationRuleSql> aggrSqlMap = null;
		String aggregation_error_msg = "Aggreagtion Service would not be loaded for "
				+ " ProcessingUnit: "
				+ keyList
				+ " as there are no Aggregation Output Insert SQL Specified for the given criteria.";
		try {
			aggrSqlMap = aggregationServiceFactoryImpl
					.loadAggregationInsertSqlRules(keyList);
		} catch (AggregationException e) {
			Assert.assertEquals(aggregation_error_msg, e.getExceptionItems().get(0).
					getExceptionsDetail().
					get(ExceptionScope.SERVICE.name()).
					get(AggregationExceptionItem.KeyDefnition.USER_MESSAGE));

		}
		Assert.assertNull(aggrSqlMap);
		LOGGER.info("No Aggregation Rule with Invalid PU and Invalid Category... Pass ");
	}

}
