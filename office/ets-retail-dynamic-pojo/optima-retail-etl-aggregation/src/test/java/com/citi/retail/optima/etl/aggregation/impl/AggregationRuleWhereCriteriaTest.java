package com.citi.retail.optima.etl.aggregation.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.aggregation.exception.AggregationException;
import com.citi.retail.optima.etl.aggregation.exception.AggregationExceptionItem;
import com.citi.retail.optima.etl.aggregation.impl.AggregationServiceFactoryImpl;
import com.citi.retail.optima.etl.aggregation.impl.AggregationServiceImpl;

/**
 * @author mc56120
 * 
 *         Verify the aggregation rule keys different scenarios
 * 
 *         Scenarios ---------- Case1 : All Aggr where criteria fields are
 *         present in account obj model Case2 : Some Aggr whereCriteria fields
 *         are not present in account obj model i.e key is not present in Acct
 *         obj model. Case3 : Some of the Aggr whereCriteria fields have null
 *         values i.e values are null. Case4 : values for all Aggr whereCriteria
 *         fields have null values.
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.aggregation.test.config.xml"})
public class AggregationRuleWhereCriteriaTest {

	@Autowired
	private AggregationServiceImpl<CardsAccount> aggrServiceImpl;

	@Autowired
	private AggregationServiceFactoryImpl<?> aggregationServiceFactoryImpl;

	@Autowired
	private SpelExpressionParser spelParser;
	private CardsAccount ora;
	private String aggrWhereCriteria = null;

	/**
	 * Case 1 : All Aggr metrics are present in account obj model
	 * 
	 * @throws AggregationExpection
	 */
	@Test
	public void testGetAggregationRuleKeyScenario1()
			throws AggregationException {
		ora = new CardsAccount();

		aggrWhereCriteria = "includeAccount[3]";
		Map<String, Boolean> includeAccount = new HashMap<String, Boolean>();
		includeAccount.put("3", Boolean.TRUE);
		ora.setIncludeAccount(includeAccount);
		Boolean whereCriteriaResult = Boolean.FALSE;
		Assert.assertFalse(whereCriteriaResult);
		List<AggregationExceptionItem> expList = new ArrayList<AggregationExceptionItem>();
		whereCriteriaResult = aggrServiceImpl.getWhereCriteria(ora,
				aggrWhereCriteria, "Test", expList);
		Assert.assertTrue(whereCriteriaResult);
		Assert.assertTrue(expList.size() == 0);
	}

	/**
	 * Case2 : Some Aggr whereCriteria fields are not present in account obj
	 * model i.e key is not present in Acct obj model.
	 * 
	 * @throws AggregationExpection
	 */
	@Test
	public void testGetAggregationRuleKeyScenario2()
			throws AggregationException {
		ora = new CardsAccount();

		aggrWhereCriteria = "includeAccounts[3]";
		Map<String, Boolean> includeAccount = new HashMap<String, Boolean>();
		includeAccount.put("3", Boolean.TRUE);
		ora.setIncludeAccount(includeAccount);
		Boolean whereCriteriaResult = Boolean.FALSE;
		Assert.assertFalse(whereCriteriaResult);
		List<AggregationExceptionItem> expList = new ArrayList<AggregationExceptionItem>();
		whereCriteriaResult = aggrServiceImpl.getWhereCriteria(ora,
				aggrWhereCriteria, "Test", expList);
		Assert.assertFalse(whereCriteriaResult);
		Assert.assertTrue(expList.size() > 0);
	}

	/**
	 * Case3 : Some of the Aggr whereCriteria fields have null values i.e values
	 * are null..
	 * 
	 * @throws AggregationExpection
	 */
	@Test
	public void testGetAggregationRuleKeyScenario3()
			throws AggregationException {
		ora = new CardsAccount();

		aggrWhereCriteria = "includeAccount[3]";
		Map<String, Boolean> includeAccount = new HashMap<String, Boolean>();
		includeAccount.put("3", null);
		ora.setIncludeAccount(includeAccount);
		Boolean whereCriteriaResult = Boolean.FALSE;
		Assert.assertFalse(whereCriteriaResult);
		List<AggregationExceptionItem> expList = new ArrayList<AggregationExceptionItem>();
		whereCriteriaResult = aggrServiceImpl.getWhereCriteria(ora,
				aggrWhereCriteria, "Test", expList);
		Assert.assertNull(whereCriteriaResult);
		Assert.assertTrue(expList.size() == 0);
	}

}
