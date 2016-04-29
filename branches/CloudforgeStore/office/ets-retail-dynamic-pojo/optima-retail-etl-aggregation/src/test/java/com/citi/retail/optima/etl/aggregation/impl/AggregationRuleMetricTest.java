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
 *         Scenarios ---------- Case1 : All Aggr metrics are present in account
 *         obj model Case2 : Some Aggr metrics are not present in account obj
 *         model i.e key Test is not present in Acct obj model. Case3 : Some of
 *         the Aggr metrics have null values i.e values are null. Case4 : values
 *         for all Aggr metrics have null values.
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.aggregation.test.config.xml"})
public class AggregationRuleMetricTest {

	@Autowired
	private AggregationServiceImpl<CardsAccount> aggrServiceImpl;

	@Autowired
	private AggregationServiceFactoryImpl<?> aggregationServiceFactoryImpl;

	@Autowired
	private SpelExpressionParser spelParser;
	private CardsAccount ora;
	private final List<String> aggrKey = null;
	private List<String> aggrMetrics = null;
	private final String aggrWhereCriteria = null;

	/**
	 * Case1 : All Aggr metrics are present in account obj model
	 * 
	 * @throws AggregationExpection
	 */
	@Test
	public void testGetAggregationRuleKeyScenario1()
			throws AggregationException {
		ora = new CardsAccount();

		aggrMetrics = new ArrayList<String>();
		aggrMetrics.add("eNumAccounts");
		aggrMetrics.add("eOutstandingDPDOver30Amt");
		aggrMetrics.add("eNumAcctDPDOver30");
		aggrMetrics.add("eNumNewAccounts");
		aggrMetrics.add("eCommitmentAmt");
		aggrMetrics.add("eNewCommitmentAmt");
		aggrMetrics.add("eNumAccountChargeOff");
		aggrMetrics.add("eNetChargeOffReconAmt");

		ora.setAccountNumber("123456");
		ora.setENumAccounts(new Long(1));
		ora.setEOutstandingDPDOver30Amt(250.00d);
		ora.setENumAcctDPDOver30(new Long(1));
		ora.setENumNewAccounts(new Long(1));
		ora.setECommitmentAmt(260.00d);
		ora.setENewCommitmentAmt(130.00d);
		ora.setENumAccountChargeOff(new Long(1));
		ora.setENetChargeOffReconAmt(650.00d);

		List<Number> aggergationMetricsSpelResult = null;
		Assert.assertNull(aggergationMetricsSpelResult);
		aggergationMetricsSpelResult = aggrServiceImpl.getColumnsToAggregate(
				aggrMetrics, ora, "Test",
				new ArrayList<AggregationExceptionItem>());

		Assert.assertNotNull(aggergationMetricsSpelResult);
		Assert.assertEquals(aggrMetrics.size(),
				aggergationMetricsSpelResult.size());

	}

	/**
	 * Case2 : All Aggr metrics are not present in account obj model i.e key
	 * eOutstandingDPDOver30AmtTest is not present in Act obj model.
	 * 
	 * @throws AggregationExpection
	 */
	@Test
	public void testGetAggregationRuleKeyScenario2()
			throws AggregationException {
		ora = new CardsAccount();

		aggrMetrics = new ArrayList<String>();
		aggrMetrics.add("eNumAccounts");
		aggrMetrics.add("eOutstandingDPDOver30AmtTest");
		aggrMetrics.add("eNumAcctDPDOver30");
		aggrMetrics.add("eNumNewAccounts");
		aggrMetrics.add("eCommitmentAmt");
		aggrMetrics.add("eNewCommitmentAmt");
		aggrMetrics.add("eNumAccountChargeOff");
		aggrMetrics.add("eNetChargeOffReconAmt");

		ora.setAccountNumber("123456");
		ora.setENumAccounts(new Long(1));
		ora.setEOutstandingDPDOver30Amt(250.00d);
		ora.setENumAcctDPDOver30(new Long(1));
		ora.setENumNewAccounts(new Long(1));
		ora.setECommitmentAmt(260.00d);
		ora.setENewCommitmentAmt(130.00d);
		ora.setENumAccountChargeOff(new Long(1));
		ora.setENetChargeOffReconAmt(650.00d);

		List<Number> aggergationMetricsSpelResult = null;
		Assert.assertNull(aggergationMetricsSpelResult);
		List<AggregationExceptionItem> expList = new ArrayList<AggregationExceptionItem>();
		aggergationMetricsSpelResult = aggrServiceImpl.getColumnsToAggregate(
				aggrMetrics, ora, "Test", expList);
		Assert.assertNotNull(aggergationMetricsSpelResult);
		Assert.assertTrue(expList.size() > 0);
	}

	/**
	 * Case3 : Some of the Aggr metrics have null values i.e values are null.
	 * 
	 * @throws AggregationExpection
	 */
	@Test
	public void testGetAggregationRuleKeyScenario3()
			throws AggregationException {
		ora = new CardsAccount();

		aggrMetrics = new ArrayList<String>();
		aggrMetrics.add("eNumAccounts");
		aggrMetrics.add("eOutstandingDPDOver30Amt");
		aggrMetrics.add("eNumAcctDPDOver30");
		aggrMetrics.add("eNumNewAccounts");
		aggrMetrics.add("eCommitmentAmt");
		aggrMetrics.add("eNewCommitmentAmt");
		aggrMetrics.add("eNumAccountChargeOff");
		aggrMetrics.add("eNetChargeOffReconAmt");

		ora.setAccountNumber("123456");
		ora.setENumAccounts(new Long(1));
		ora.setEOutstandingDPDOver30Amt(null); // null value
		ora.setENumAcctDPDOver30(new Long(1));
		ora.setENumNewAccounts(new Long(1));
		ora.setECommitmentAmt(null); // null value
		ora.setENewCommitmentAmt(130.00d);
		ora.setENumAccountChargeOff(new Long(1));
		ora.setENetChargeOffReconAmt(650.00d);

		List<Number> aggergationMetricsSpelResult = null;
		Assert.assertNull(aggergationMetricsSpelResult);
		List<AggregationExceptionItem> expList = new ArrayList<AggregationExceptionItem>();
		aggergationMetricsSpelResult = aggrServiceImpl.getColumnsToAggregate(
				aggrMetrics, ora, "Test", expList);
		Assert.assertNotNull(aggergationMetricsSpelResult);
		Assert.assertTrue(expList.size() == 0);
	}

	/**
	 * Case4 : values for all Aggr keys have null values.
	 * 
	 * @throws AggregationExpection
	 */
	@Test
	public void testGetAggregationRuleKeyScenario4()
			throws AggregationException {
		ora = new CardsAccount();

		aggrMetrics = new ArrayList<String>();
		aggrMetrics.add("eNumAccounts");
		aggrMetrics.add("eOutstandingDPDOver30Amt");
		aggrMetrics.add("eNumAcctDPDOver30");
		aggrMetrics.add("eNumNewAccounts");
		aggrMetrics.add("eCommitmentAmt");
		aggrMetrics.add("eNewCommitmentAmt");
		aggrMetrics.add("eNumAccountChargeOff");
		aggrMetrics.add("eNetChargeOffReconAmt");

		ora.setAccountNumber("123456");
		ora.setENumAccounts(null);
		ora.setEOutstandingDPDOver30Amt(null);
		ora.setENumAcctDPDOver30(null);
		ora.setENumNewAccounts(new Long(1));
		ora.setECommitmentAmt(null);
		ora.setENewCommitmentAmt(null);
		ora.setENumAccountChargeOff(null);
		ora.setENetChargeOffReconAmt(null);

		List<Number> aggergationMetricsSpelResult = null;
		Assert.assertNull(aggergationMetricsSpelResult);
		List<AggregationExceptionItem> expList = new ArrayList<AggregationExceptionItem>();
		aggergationMetricsSpelResult = aggrServiceImpl.getColumnsToAggregate(
				aggrMetrics, ora, "Test", expList);
		Assert.assertNotNull(aggergationMetricsSpelResult);
		Assert.assertTrue(expList.size() == 0);
	}

}
