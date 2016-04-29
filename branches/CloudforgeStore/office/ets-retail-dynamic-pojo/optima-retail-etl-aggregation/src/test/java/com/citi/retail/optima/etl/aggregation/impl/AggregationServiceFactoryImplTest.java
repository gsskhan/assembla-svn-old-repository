package com.citi.retail.optima.etl.aggregation.impl;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.test.context.ContextConfiguration;

import com.citi.retail.optima.etl.aggregation.AggregationService;
import com.citi.retail.optima.etl.aggregation.AggregationServiceFactory;
import com.citi.retail.optima.etl.aggregation.dao.AggregationDao;
import com.citi.retail.optima.etl.aggregation.dao.AggregationRuleSql;
import com.citi.retail.optima.etl.aggregation.exception.AggregationException;
import com.citi.retail.optima.etl.aggregation.exception.AggregationExceptionItem;
import com.citi.retail.optima.etl.aggregation.exception.ExceptionScope;
import com.citi.retail.optima.etl.aggregation.exception.ExceptionType;
import com.citi.retail.optima.etl.aggregation.model.AggregationRuleLookup;
import com.citi.retail.optima.etl.aggregation.model.AggregationType;

/**
 * Test case for AggregationServiceFactoryImpl.
 * 
 * @author mc56120
 * 
 */
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration({ "/optima.retail.aggregation.test.config.xml"})
public class AggregationServiceFactoryImplTest {
	private static final String INSERT_SQL = "insert into test_aggregation_table (key,matrics) values (?,?)";

	@Mock
	private AggregationRuleLookup aggregationRuleLookup;

	/*@Mock
	private AggregationSqlRuleLookup aggregationSqlRuleLookup;*/

	@Mock
	private SpelExpressionParser parser;

	@Mock
	private AggregationDao aggregationDao;

	private static final String KEY_ID = "MONTH:1";

	private final List<String> keyList = new ArrayList<String>();

	private List<AggregationExceptionItem> AggregationExpectionDtlList;

	@InjectMocks
	private final AggregationServiceFactory<Object> aggrServiceFactory = new AggregationServiceFactoryImpl<Object>();

	@Before
	public void setUp() throws Exception {
		keyList.add(KEY_ID);
		when(aggregationRuleLookup.getAggregationRuleType(keyList)).thenReturn(
				loadDummyAggregationRules()).thenCallRealMethod();
		when(aggregationRuleLookup.getAggregationSql(keyList)).thenReturn(
				loadDummyAggregationSqlRules()).thenCallRealMethod();
	}

	/**
	 * instantiate aggregation service with no exceptions.
	 * 
	 * @throws AggregationExpection
	 */
	@Test
	public void testGetAggregationService()
			throws AggregationException {
		AggregationService<Object> aggregationService = aggrServiceFactory
				.getAggregationService(keyList, new Long(12345), new Date(),
						"cardsMonthEndStep");
		Assert.assertNotNull(aggregationService);
	}

	/**
	 * aggregation rules lookup with exception
	 */
	@Test
	public void testLoadAggregationRuleLookupWithException() {
		String processingUnitId = "2";
		String aggregation_error_msg = "Aggreagtion Service would not be loaded for "
				+ " ProcessingUnit: "
				+ processingUnitId
				+ " as there are no Aggregation Rules Specified for the given criteria.";
		try {
			aggrServiceFactory.loadAggregationRules(keyList);
		} catch (AggregationException e) {
			Assert.assertEquals(aggregation_error_msg, e.getExceptionItems().get(0).
					getExceptionsDetail().
					get(ExceptionScope.SERVICE.name()).
					get(AggregationExceptionItem.KeyDefnition.USER_MESSAGE));
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
		List<AggregationType> aggregationTypeList = aggrServiceFactory
				.loadAggregationRules(keyList);
		Assert.assertNotNull(aggregationTypeList);
		Assert.assertTrue(aggregationTypeList.size() > 0);
	}

	/**
	 * aggregation rule insert sql lookup with exception.
	 */
	@Test
	public void testLoadAggregationInsertSqlRulesLookupWithException() {
		String processingUnitId = "2";
		String aggregation_error_msg = "Aggreagtion Service would not be loaded for "
				+ " ProcessingUnit: "
				+ processingUnitId
				+ " as there are no Aggregation Output Insert SQL Specified for the given criteria.";
		try {
			aggrServiceFactory.loadAggregationRules(keyList);
		} catch (AggregationException e) {
			Assert.assertEquals(aggregation_error_msg,e.getExceptionItems().get(0).
					getExceptionsDetail().
					get(ExceptionScope.SERVICE.name()).
					get(AggregationExceptionItem.KeyDefnition.USER_MESSAGE));
		}
	}

	/**
	 * aggregation rule insert sql lookup without exception.
	 * 
	 * @throws AggregationExpection
	 */
	@Test
	public void testLoadAggregationInsertSqlRulesLookupWithoutException()
			throws AggregationException {
		Map<String, AggregationRuleSql> aggrSqlMap = aggrServiceFactory
				.loadAggregationInsertSqlRules(keyList);
		Assert.assertNotNull(aggrSqlMap);
		Assert.assertTrue(aggrSqlMap.keySet().size() > 0);
	}

	@Test
	public void testAggregationServiceInstance()
			throws AggregationException {

		AggregationService<Object> aggregationService = aggrServiceFactory
				.getAggregationService(keyList, new Long(12345), new Date(),
						"cardsMonthEndStep");
		keyList.clear();
		keyList.add("cardsMonthEndStep:1");

		AggregationService<Object> aggregationService1 = aggrServiceFactory
				.getAggregationService(keyList, new Long(12345), new Date(),
						"cardsMonthEndStep");
		Assert.assertEquals(aggregationService, aggregationService1);
	}

	/**
	 * load dummy aggregation rules
	 * 
	 * @return
	 */
	private List<AggregationType> loadDummyAggregationRules() {
		List<AggregationType> aggregationTypeList = new ArrayList<AggregationType>();
		AggregationType aggrType = new AggregationType();
		aggrType.setId(new Long(12345));
		aggrType.setName("Test Aggregation");
		aggrType.setAggregationRuleKeySpelExpr(new ArrayList<String>(Arrays
				.asList("testKey1", "testKey2")));
		aggrType.setAggregationRuleKeySpelExpr(new ArrayList<String>(Arrays
				.asList("testMetrics1", "testMetrics2", "testMetrics3")));
		aggrType.setWhereCriteriaSpelExpr(null);
		// aggrType.setProcessingUnitId(KEY_ID);
		aggregationTypeList.add(aggrType);

		return aggregationTypeList;
	}

	/**
	 * load dummy aggregation insert SQL
	 * 
	 * @return
	 */
	private Map<String, AggregationRuleSql> loadDummyAggregationSqlRules() {
		Map<String, AggregationRuleSql> ruleLookupMap = new HashMap<String, AggregationRuleSql>();
		AggregationRuleSql aggrSqlRef = new AggregationRuleSql(12345);
		aggrSqlRef.setAggregationName("Test Aggregation");
		aggrSqlRef.setInsertSql(INSERT_SQL);
		aggrSqlRef.setProductName("CARDS");
		//aggrSqlRef.setFunctionName("CCAR");
		aggrSqlRef.setProcessingUnitId(1);
		ruleLookupMap.put(aggrSqlRef.getAggregationName(), aggrSqlRef);
		return ruleLookupMap;
	}

	@Test
	public void testHandleMessage() {
		((AggregationServiceFactoryImpl<Object>) aggrServiceFactory)
				.handleExceptions(ExceptionType.FATAL,ExceptionScope.SERVICE ,"Test Aggregation Error");
	}

	

	@SuppressWarnings("rawtypes")
	@Test
	public void testClearAggregationServiceFromMapLongString() throws Exception {
		AggregationService<Object> aggregationService = aggrServiceFactory
				.getAggregationService(keyList, new Long(12345), new Date(),
						"cardsMonthEndStep");
		Assert.assertNotNull(aggrServiceFactory.getAggregationServiceFromPool(((AggregationServiceFactoryImpl)aggrServiceFactory).getAggregationKey(new Long(12345),"cardsMonthEndStep")));
		aggrServiceFactory.clearAggregationServiceFromMap(new Long(12345),"cardsMonthEndStep");
		Assert.assertNull(aggrServiceFactory.getAggregationServiceFromPool(((AggregationServiceFactoryImpl)aggrServiceFactory).getAggregationKey(new Long(12345),"cardsMonthEndStep")));

	}

	
}
