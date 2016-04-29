package com.citi.retail.optima.etl.aggregation.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.aggregation.AggregationService;
import com.citi.retail.optima.etl.aggregation.dao.AggregationRuleSql;
import com.citi.retail.optima.etl.aggregation.exception.AggregationException;
import com.citi.retail.optima.etl.aggregation.exception.AggregationExceptionItem;
import com.citi.retail.optima.etl.aggregation.model.AggregationType;

/**
 * 
 * @author mc56120
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.aggregation.test.config.xml"})
public class AggregationServiceImplTest {
	@Autowired
	private AggregationServiceImpl<CardsAccount> aggrServiceImpl;

	@Autowired
	private AggregationServiceFactoryImpl aggregationServiceFactoryImpl;
	
	private Map<String, Map<String, List<Number>>> aggregationMap = null;
	private final List<Integer> processingUnitIdList = new ArrayList<Integer>();
	/**
	 * test aggregation metric.
	 */

	private final String[] aggregationKey = { "productType", "eCcarAge",
			"eDelinquencyStatus", "eFicoEquivalent" };
	/**
	 * test aggregation keys.
	 */
	private final String[] aggregationMetrics = { "eNumAccounts",
			"principalContractualChargeOff", "eOutstandingDPDOver30Amt",
			"grossOutstandingPrinBal" };
	private ExpressionParser parser;
	private Map<String, AggregationRuleSql> aggregationSqlMap;
	private AggregationRuleSql aggregationSqlRef;
	List<Map<String, Map<String, List<Number>>>> aggregationMapList;
	Map<String, Map<String, Map<String, List<Number>>>> aggregationMapPerPartition;

	@Before
	public void init() throws ParseException {
		parser = new SpelExpressionParser();
		aggregationSqlMap = new HashMap<String, AggregationRuleSql>();
		aggregationMapList = new ArrayList<Map<String, Map<String, List<Number>>>>();
		aggregationMapPerPartition = new HashMap<String, Map<String, Map<String, List<Number>>>>();
		aggregationSqlMap.put("Test", aggregationSqlRef);

		aggrServiceImpl
				.setAggregationTypeList(populateAggregationTypeTestData());
		SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
		Long batchInstanceId = 1234L;
		Date monthEndDate = sdf.parse("07/29/2013");
		aggrServiceImpl.setBatchInstanceId(batchInstanceId);
		aggrServiceImpl.setMonthEndDate(monthEndDate);
		aggrServiceImpl.setParser(parser);
		aggrServiceImpl.setAggregationSqlMap(aggregationSqlMap);
		aggrServiceImpl.setAgrregationMapList(aggregationMapList);
		aggrServiceImpl
				.setAgrregationResultMapPerPartition(aggregationMapPerPartition);
	}

	@Test
	public void testAggregationTypeList() {
		Assert.assertNotNull(aggrServiceImpl.getAggregationTypeList());
		Assert.assertTrue(aggrServiceImpl.getAggregationTypeList().size() > 0);
	}

	@Test
	public void testSetAgrregationMapList() {
		Assert.assertNotNull(aggrServiceImpl.getAgrregationMapList());
	}

	@Test
	public void testAggregateData() throws AggregationException {
		aggregationMap = new HashMap<String, Map<String, List<Number>>>();
		Assert.assertTrue(aggregationMap.size() == 0);
		aggrServiceImpl.aggregate(populateMockAccountData(), aggregationMap,
				true);
		aggrServiceImpl.aggregate(populateMockAccountData(), aggregationMap,
				true);
		// 2 accounts are loaded with same segments/buckets when aggregated it
		// should produce only 1 segment
		Assert.assertTrue(aggregationMap.size() == 1);
		// Assert.assertNotNull(aggrServiceImpl.getLocalAggregationMap());
	}

	@Test
	public void testAggregateDataList() throws AggregationException {
		aggregationMap = new HashMap<String, Map<String, List<Number>>>();
		List<CardsAccount> dataList = new ArrayList<CardsAccount>();
		dataList.add(populateMockAccountData());
		Assert.assertTrue(aggregationMap.size() == 0);
	}

	/**
	 * populate test aggregation type.
	 */
	private List<AggregationType> populateAggregationTypeTestData() {
		List<AggregationType> aggrTypeList = new ArrayList<AggregationType>();
		AggregationType aggrType = new AggregationType();
		aggrType.setAggregationRuleKeySpelExpr(new ArrayList<String>(Arrays
				.asList(aggregationKey)));
		// aggrType.setWhereCriteriaSpelExpr(" ccarUnpaidPrinBal > 900");
		aggrType.setColumnsToAggregateValueSpelExpr(new ArrayList<String>(
				Arrays.asList(aggregationMetrics)));
		aggrType.setId(new Long(12345));
		aggrType.setName("Test Aggregation");
		aggrTypeList.add(aggrType);
		return aggrTypeList;
	}

	/**
	 * This tests the process not the actual persist of Aggregation Results.
	 * So a better approach is needed for testing purpose. 
	 * No aggregationVO set in this test default behavior is return true if persist 
	 * successfully or no persistent at all
	 */
	@Test
	public void testSaveAggregationResults() {
		// processingUnitIdList.add(3);
		List<String> keyList = new ArrayList<String>();
		keyList.add("USCCARProcessStep:3");
		try {
			//This shall generate a AggregationDao instance in the service 
			@SuppressWarnings("unchecked")
			AggregationService<CardsAccount> aggregationService = aggregationServiceFactoryImpl
					.getAggregationService(keyList, new Long(1122334455),
							new Date(), "USCCARProcessStep");
			
			Assert.assertNotNull(aggregationService);
			aggregationMap = new HashMap<String, Map<String, List<Number>>>();
			Assert.assertTrue(aggregationMap.size() == 0);
			aggrServiceImpl.aggregate(populateMockAccountData(),
					aggregationMap, true);
			//this return true always because there aggregationVO is always empty in this test 
			//and default behavior is return true if persist successfully or no persistent at all
			boolean saveAggregationResults = aggregationService
					.saveAggregationResults();
			Assert.assertTrue(saveAggregationResults);
		} catch (AggregationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * populate mock account data.
	 */
	private CardsAccount populateMockAccountData() {
		CardsAccount data = new CardsAccount();
		data.setAccountNumber("123456");
		data.setProductType("Cards");
		data.setECcarAge("Greater than 2");
		data.setEDelinquencyStatus("Test");
		data.setEFicoEquivalent("540");
		data.setENumAccounts(null);
		data.setPrincipalChargeOff(300.00d);
		data.setEOutstandingDPDOver30Amt(300.00d);
		data.setGrossOutstandingPrinBal(20.00d);
		return data;
	}

	@Test
	public void testExceptionHandle() {
		Boolean result = Boolean.FALSE;
		try {
			result = aggrServiceImpl.getWhereCriteria(
					populateMockAccountData(), "Test", "Test",
					new ArrayList<AggregationExceptionItem>());
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertFalse(result);

	}

	@Test
	public void testAggregateList() throws Exception {
		List<CardsAccount> dataList = new ArrayList<CardsAccount>();
		dataList.add(populateMockAccountData());
		aggregationMap = new HashMap<String, Map<String, List<Number>>>();
		Assert.assertNotNull(aggrServiceImpl.aggregateList(dataList,
				aggregationMap,
				false));
	}

	@Test
	public void testGetAggregationResults() throws Exception {
		Assert.assertNotNull(aggrServiceImpl.getAggregationResults());
		
	}

	@Test
	public void testGetAgrregationKeySet() throws Exception {  
		 List<CardsAccount> dataList = new ArrayList<CardsAccount>();
		dataList.add(populateMockAccountData());
		aggregationMap = new HashMap<String, Map<String, List<Number>>>();
		Assert.assertNotNull(aggrServiceImpl.getAgrregationKeySet());
	
	}

	@Test
	public void testGetLocalAggregationMap() throws Exception {
		Assert.assertNotNull(aggrServiceImpl.getLocalAggregationMap(1));
	}


}
