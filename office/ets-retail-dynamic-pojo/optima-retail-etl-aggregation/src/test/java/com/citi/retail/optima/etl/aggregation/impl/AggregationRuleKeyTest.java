/**
 * 
 */
package com.citi.retail.optima.etl.aggregation.impl;

import java.util.ArrayList;
import java.util.List;

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
 *         Scenarios ---------- Case1 : All Aggr keys are present in account obj
 *         model Case2 : All Aggr keys are not present in account obj model i.e
 *         key productTypeTest is not present in Acct obj model. Case3 : Some of
 *         the Aggr keys have null values i.e values are null. Case4 : values
 *         for all Aggr keys have null values.
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.aggregation.test.config.xml"})
public class AggregationRuleKeyTest {

	@Autowired
	private AggregationServiceImpl<CardsAccount> aggrServiceImpl;

	@Autowired
	private AggregationServiceFactoryImpl<?> aggregationServiceFactoryImpl;

	@Autowired
	private SpelExpressionParser spelParser;
	private CardsAccount ora;
	private List<String> aggrKey = null;

	/**
	 * Case1 : All Aggr keys are present in account obj model
	 * 
	 * @throws AggregationException
	 */
	@Test
	public void testGetAggregationRuleKeyScenario1()
			throws AggregationException {
		ora = new CardsAccount();

		aggrKey = new ArrayList<String>();
		aggrKey.add("productType");
		aggrKey.add("eRegion");
		aggrKey.add("eFicoEquivalent");
		aggrKey.add("eCcarAge");
		aggrKey.add("eDelinquencyStatus");

		ora.setAccountNumber("123456");
		ora.setProductType("Cards");
		ora.setERegion("BRA");
		ora.setEFicoEquivalent("03");
		ora.setECcarAge("02");
		ora.setEDelinquencyStatus("02");

		String aggregationSpelResult = null;
		Assert.assertNull(aggregationSpelResult);
		aggregationSpelResult = aggrServiceImpl.getAggregationRuleKey(ora,
				aggrKey, "TestRule",
				new ArrayList<AggregationExceptionItem>());
		Assert.assertNotNull(aggregationSpelResult);
		int numberOfKeys = aggregationSpelResult.split(";;;").length;
		Assert.assertEquals(aggrKey.size(), numberOfKeys);

	}

	/**
	 * Case2 : All Aggr keys are not present in account obj model i.e key
	 * productTypeTest is not present in Acct obj model.
	 * 
	 * @throws AggregationException
	 */
	@Test
	public void testGetAggregationRuleKeyScenario2()
			throws AggregationException {
		ora = new CardsAccount();

		aggrKey = new ArrayList<String>();
		aggrKey.add("productTypeTest");
		aggrKey.add("eRegion");
		aggrKey.add("eFicoEquivalent");
		aggrKey.add("eCcarAge");
		aggrKey.add("eDelinquencyStatus");

		ora.setAccountNumber("123456");
		ora.setProductType("Cards");
		ora.setERegion("BRA");
		ora.setEFicoEquivalent("03");
		ora.setECcarAge("02");
		ora.setEDelinquencyStatus("02");

		String aggregationSpelResult = null;
		Assert.assertNull(aggregationSpelResult);
		List<AggregationExceptionItem> expList = new ArrayList<AggregationExceptionItem>();
		aggregationSpelResult = aggrServiceImpl.getAggregationRuleKey(ora,
				aggrKey, "TestRule", expList);
		Assert.assertTrue(expList.size() > 0);
	}

	/**
	 * Case3 : Some of the Aggr keys have null values i.e values are null.
	 * 
	 * @throws AggregationException
	 */
	@Test
	public void testGetAggregationRuleKeyScenario3()
			throws AggregationException {
		ora = new CardsAccount();

		aggrKey = new ArrayList<String>();
		aggrKey.add("productType");
		aggrKey.add("eRegion");
		aggrKey.add("eFicoEquivalent");
		aggrKey.add("eCcarAge");
		aggrKey.add("eDelinquencyStatus");

		ora.setAccountNumber("123456");
		ora.setProductType(null);
		ora.setERegion("BRA");
		ora.setEFicoEquivalent("03");
		ora.setECcarAge("02");
		ora.setEDelinquencyStatus("02");

		String aggregationSpelResult = null;
		Assert.assertNull(aggregationSpelResult);
		List<AggregationExceptionItem> expList = new ArrayList<AggregationExceptionItem>();
		aggregationSpelResult = aggrServiceImpl.getAggregationRuleKey(ora,
				aggrKey, "TestRule", expList);
		Assert.assertNotNull(aggregationSpelResult);
		Assert.assertTrue(expList.size() == 0);
	}

	/**
	 * Case4 : values for all Aggr keys have null values.
	 * 
	 * @throws AggregationException
	 */
	@Test
	public void testGetAggregationRuleKeyScenario4()
			throws AggregationException {
		ora = new CardsAccount();

		aggrKey = new ArrayList<String>();
		aggrKey.add("productType");
		aggrKey.add("eRegion");
		aggrKey.add("eFicoEquivalent");
		aggrKey.add("eCcarAge");
		aggrKey.add("eDelinquencyStatus");

		ora.setAccountNumber("123456");
		ora.setProductType(null);
		ora.setERegion(null);
		ora.setEFicoEquivalent(null);
		ora.setECcarAge(null);
		ora.setEDelinquencyStatus(null);

		String aggregationSpelResult = null;
		Assert.assertNull(aggregationSpelResult);
		List<AggregationExceptionItem> expList = new ArrayList<AggregationExceptionItem>();
		aggregationSpelResult = aggrServiceImpl.getAggregationRuleKey(ora,
				aggrKey, "TestRule", expList);
		Assert.assertNotNull(aggregationSpelResult);
		Assert.assertTrue(expList.size() == 0);
	}

}
