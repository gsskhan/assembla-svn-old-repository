package com.citi.retail.optima.etl.aggregation.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.aggregation.exception.AggregationException;
import com.citi.retail.optima.etl.aggregation.exception.AggregationExceptionItem;
import com.citi.retail.optima.etl.aggregation.exception.ExceptionScope;
import com.citi.retail.optima.etl.aggregation.impl.AggregationServiceFactoryImpl;
import com.citi.retail.optima.etl.aggregation.model.AggregationType;

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
@ContextConfiguration({ "/optima.retail.aggregation.test.config.xml"})
public class AggregationRulesLoaderTest {

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
		@SuppressWarnings("unchecked")
		List<AggregationType> aggregationTypeList = aggregationServiceFactoryImpl
				.loadAggregationRules(keyList);
		Assert.assertNotNull(aggregationTypeList);
		Assert.assertTrue(aggregationTypeList.size() > 0);
	}

	@Test
	public void testLoadAggrRuleFromAggrFactoryScenarioTest()
			throws AggregationException {
		List<String> keyList = new ArrayList<String>();
		String processingUnit = "3";
		String category = "USCCARProcessStep";
		String key = category + ":" + processingUnit;
		keyList.add(key);
		@SuppressWarnings("unchecked")
		List<AggregationType> aggregationTypeList = aggregationServiceFactoryImpl
				.loadAggregationRules(keyList);
		
		for(AggregationType aggregationType : aggregationTypeList){
			System.out.println("+++++++++++++++++++++++++++++++++");
			System.out.println(aggregationType.getName());
			System.out.println(aggregationType.getId());
			System.out.println(aggregationType.getSysProcId());
			System.out.println(aggregationType.getSysProcId());
			System.out.println("+++++++++++++++++++++++++++++++++");
		}
		
		
		Assert.assertNotNull(aggregationTypeList);
		Assert.assertTrue(aggregationTypeList.size() > 0);
	}
	
	
	
	
	/**
	 * 
	 * InValid PU and Valid Category
	 */
	@Test
	public void testLoadAggrRuleFromAggrFactoryScenario2()
			throws AggregationException {
		List<String> keyList = new ArrayList<String>();
		String processingUnit = "300000";
		String category = "cardsMonthEndStep";
		String key = category + ":" + processingUnit;
		keyList.add(key);
		@SuppressWarnings("unchecked")
		List<AggregationType> aggregationTypeList = null;
		String aggregation_error_msg = "Aggreagtion Service would not be loaded for "
				+ " ProcessingUnit: "
				+ keyList
				+ " as there are no Aggregation Rules Specified for the given criteria.";
		try {
			aggregationTypeList = aggregationServiceFactoryImpl
					.loadAggregationRules(keyList);
		} catch (AggregationException e) {
			Assert.assertEquals(aggregation_error_msg, e.getExceptionMessage());
		}
		Assert.assertNull(aggregationTypeList);
	}

	/**
	 * 
	 * Valid PU and InValid Category
	 */
	@Test
	public void testLoadAggrRuleFromAggrFactoryScenario3()
			throws AggregationException {
		List<String> keyList = new ArrayList<String>();
		String processingUnit = "3";
		String category = "";
		String key = category + ":" + processingUnit;
		keyList.add(key);
		@SuppressWarnings("unchecked")
		List<AggregationType> aggregationTypeList = null;
		String aggregation_error_msg = "Aggreagtion Service would not be loaded for "
				+ " ProcessingUnit: "
				+ keyList
				+ " as there are no Aggregation Rules Specified for the given criteria.";
		try {
			aggregationTypeList = aggregationServiceFactoryImpl
					.loadAggregationRules(keyList);
		} catch (AggregationException e) {
			Assert.assertEquals(aggregation_error_msg, e.getExceptionMessage());
		}
		Assert.assertNull(aggregationTypeList);
	}

	/**
	 * 
	 * InValid PU and InValid Category
	 */
	@Test
	public void testLoadAggrRuleFromAggrFactoryScenario4()
			throws AggregationException {
		List<String> keyList = new ArrayList<String>();
		String processingUnit = "300000";
		String category = "cardsMonthEndStepTest123";
		String key = category + ":" + processingUnit;
		keyList.add(key);
		@SuppressWarnings("unchecked")
		List<AggregationType> aggregationTypeList = null;
		String aggregation_error_msg = "Aggreagtion Service would not be loaded for "
				+ " ProcessingUnit: "
				+ keyList
				+ " as there are no Aggregation Rules Specified for the given criteria.";
		try {
			aggregationTypeList = aggregationServiceFactoryImpl
					.loadAggregationRules(keyList);
		} catch (AggregationException e) {
			Assert.assertEquals(aggregation_error_msg, e.getExceptionMessage());
		}
		Assert.assertNull(aggregationTypeList);
	}

}
