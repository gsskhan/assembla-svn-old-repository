package com.citi.retail.optima.etl.aggregation.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.aggregation.dao.AggregationRuleSql;
import com.citi.retail.optima.etl.aggregation.exception.AggregationException;
import com.citi.retail.optima.etl.aggregation.model.AggregationRuleLookup;
import com.citi.retail.optima.etl.aggregation.model.AggregationType;

/**
 * @author mc56120
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.aggregation.test.config.xml"})
public class AggregationServiceFactoryTest {
	private final List<Integer> processingUnitIdList = new ArrayList<Integer>();

	@Autowired
	private AggregationRuleLookup aggregationRuleLookup;

	

	@Autowired
	private AggregationServiceFactoryImpl aggregationServiceFactoryImpl;

	private Map<String, AggregationServiceImpl> aggrServiceMap = null;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Before
	public void setUp() throws AggregationException {
		aggrServiceMap = aggregationServiceFactoryImpl
				.getAggregationServiceMap();
		aggrServiceMap.put(aggregationServiceFactoryImpl.getAggregationKey(
				new Long(101), "cardsMonthEndStep"),
				new AggregationServiceImpl());

	}

	/**
	 * instantiate aggregation service with no exceptions.
	 * 
	 * @throws AggregationExpection
	 */
	@Test
	public void testGetAggregationService() {
		// processingUnitIdList.add(1);
		List<String> keyList = new ArrayList<String>();
		keyList.add("USCCARProcessStep:3");
		try {
			aggregationServiceFactoryImpl.getAggregationService(keyList,
					new Long(12345), new Date(), "USCCARProcessStep");
		} catch (AggregationException e) {
			e.printStackTrace();
		}
	}

	/**
	 * aggregation rules lookup with exception
	 */
	@Test
	public void testLoadAggregationRuleLookupWithException()  {
		processingUnitIdList.clear();
		// processingUnitIdList.add(2000);
		List<String> keyList = new ArrayList<String>();
		keyList.add("cardsMonthEndStep:20000");
		String aggregation_error_msg = "Aggreagtion Service would not be loaded for "
				+ " ProcessingUnit: "
				+ keyList
				+ " as there are no Aggregation Rules Specified for the given criteria.";
		try {
			aggregationServiceFactoryImpl.loadAggregationRules(keyList);
			
		} catch (AggregationException e) {
			Assert.assertEquals(aggregation_error_msg, e.getExceptionMessage());
			
		}
		
	}

	/**
	 * aggregation rules lookup without exception.
	 * 
	 * @throws AggregationExpection
	 */
	@Test
	public void testLoadAggregationRuleLookupWithoutException()
			throws AggregationException {
		// processingUnitIdList.clear();
		// processingUnitIdList.add(1);
		List<String> keyList = new ArrayList<String>();
		keyList.add("USCCARProcessStep:3");
		@SuppressWarnings("unchecked")
		List<AggregationType> aggregationTypeList = aggregationServiceFactoryImpl
				.loadAggregationRules(keyList);
		Assert.assertNotNull(aggregationTypeList);
		Assert.assertTrue(aggregationTypeList.size() > 0);
	}

	/**
	 * aggregation rule insert sql lookup with exception.
	 */
	@Test
	public void testLoadAggregationInsertSqlRulesLookupWithException() {
		
		 /* processingUnitIdList.clear(); processingUnitIdList.add(2); String
		 * aggregation_error_msg =
		 * "Aggreagtion Service would not be loaded for " + " ProcessingUnit: "
		 * + processingUnitIdList.get(0) +
		 * " as there are no Aggregation Output Insert SQL Specified for the given criteria."
		 * ; try {
		 * aggregationServiceFactoryImpl.loadAggregationRules(processingUnitIdList
		 * ); } catch (AggregationExpection e) {
		 * Assert.assertEquals(aggregation_error_msg, e
		 * .getOptimaRetailSkippableList().get(0) .getUserErrorMessage()); }*/
		 
	}

	/**
	 * aggregation rule insert sql lookup without exception.
	 * 
	 * @throws AggregationExpection
	 */
	@Test
	public void testLoadAggregationInsertSqlRulesLookupWithoutException()
			throws AggregationException {
		// processingUnitIdList.clear();
		// processingUnitIdList.add(1);
		List<String> keyList = new ArrayList<String>();
		keyList.add("USCCARProcessStep:3");

		@SuppressWarnings("unchecked")
		Map<String, AggregationRuleSql> aggrSqlMap = aggregationServiceFactoryImpl
				.loadAggregationInsertSqlRules(keyList);
		Assert.assertNotNull(aggrSqlMap);
		// Assert.assertTrue(aggrSqlMap.keySet().size() > 0);
	}

	/**
	 * clear aggregation service map after job is done
	 */
	@Test
	public void clearAggregationServiceTest() {
		Assert.assertTrue(aggregationServiceFactoryImpl
				.getAggregationServiceMap().size() > 0);
		aggregationServiceFactoryImpl.clearAggregationServiceFromMap(new Long(
				101), "cardsMonthEndStep");
		
		  Assert.assertTrue(aggregationServiceFactoryImpl
		  .getAggregationServiceMap().isEmpty());
		 
	}

}
