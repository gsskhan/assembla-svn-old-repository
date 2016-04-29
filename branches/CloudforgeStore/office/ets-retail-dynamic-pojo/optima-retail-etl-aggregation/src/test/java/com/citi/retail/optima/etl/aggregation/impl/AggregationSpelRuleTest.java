package com.citi.retail.optima.etl.aggregation.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ch.qos.logback.classic.Logger;

import com.citi.retail.optima.etl.aggregation.exception.AggregationException;
import com.citi.retail.optima.etl.aggregation.exception.AggregationExceptionItem;

/**
 * test to verify the spel exprpession evaluation for aggregation keys, metrics
 * and whereCriteria
 */



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.aggregation.test.config.xml"})
public class AggregationSpelRuleTest {
	private final static Logger LOGGER = (Logger) LoggerFactory
			.getLogger(AggregationSpelRuleTest.class);
	@Autowired
	private AggregationServiceImpl<CardsAccount> aggrServiceImpl;
	@Autowired
	private SpelExpressionParser spelParser;
	private CardsAccount ora;
	private List<String> aggrKey = null;
	private List<String> aggrMetrics = null;
	private String aggrWhereCriteria = null;

	@Before
	public void init() {
		ora = new CardsAccount();
		populateMockKeys();
		populateMockMetrics();
		populateWhereCriteria();
		// keys
		aggrKey = new ArrayList<String>();
		aggrKey.add("productType");
		aggrKey.add("eRegion");
		aggrKey.add("eFicoEquivalent");
		aggrKey.add("eCcarAge");
		aggrKey.add("eDelinquencyStatus");

		// metrics
		aggrMetrics = new ArrayList<String>();
		aggrMetrics.add("eNumAccounts");
		// aggrMetrics.add("eUnpaidPrinBal");
		// aggrMetrics.add("eReceivableAmt");
		aggrMetrics.add("eOutstandingDPDOver30Amt");
		aggrMetrics.add("eNumAcctDPDOver30");
		aggrMetrics.add("eNumNewAccounts");
		aggrMetrics.add("eCommitmentAmt");
		aggrMetrics.add("eNewCommitmentAmt");
		// aggrMetrics.add("eGrossContractChargeOffAmt");
		// aggrMetrics.add("eBankruptcyChargeOffAmt");
		// aggrMetrics.add("eRecoveriesAmt");
		aggrMetrics.add("eNumAccountChargeOff");
		// aggrMetrics.add("eNetChargeOffAmt");
		aggrMetrics.add("eNetChargeOffReconAmt");

		// whereCriteria
		aggrWhereCriteria = "includeAccount[2]";
	}

	// populate mock aggregation keys
	private void populateMockKeys() {
		ora.setAccountNumber("123456");
		ora.setProductType("Cards");
		ora.setERegion("BRA");
		ora.setEFicoEquivalent("03");
		ora.setECcarAge("02");
		ora.setEDelinquencyStatus("02");
	}

	// populate mock aggregation metrics
	private void populateMockMetrics() {
		ora.setENumAccounts(new Long(1));
		// ora.setEUnpaidPrinBal(100.00);
		// ora.setEReceivableAmt(200.00);
		ora.setEOutstandingDPDOver30Amt(250.00);
		ora.setENumAcctDPDOver30(new Long(1));
		ora.setENumNewAccounts(new Long(1));
		ora.setECommitmentAmt(260.00);
		ora.setENewCommitmentAmt(130.00);
		// ora.setEGrossContractChargeOffAmt(300.00);
		// ora.setEBankruptcyChargeOffAmt(0.00);
		// ora.setERecoveriesAmt(10.00);
		ora.setENumAccountChargeOff(new Long(1));
		// ora.setENetChargeOffAmt(500.00);
		ora.setENetChargeOffReconAmt(650.00);
	}

	// populate mock aggregation whereCriteria
	private void populateWhereCriteria() {
		Map<String, Boolean> includeAccount = new HashMap<String, Boolean>();
		includeAccount.put("2", Boolean.TRUE);
		ora.setIncludeAccount(includeAccount);
	}

	@Test
	public void testGetAggregationRuleKey()
			throws AggregationException {
		String aggregationSpelResult = null;
		Assert.assertNull(aggregationSpelResult);
		aggregationSpelResult = aggrServiceImpl.getAggregationRuleKey(ora,
				aggrKey, "Test",
				new ArrayList<AggregationExceptionItem>());
		Assert.assertNotNull(aggregationSpelResult);
		int numberOfKeys = aggregationSpelResult.split(";;;").length;
		// System.out.println(numberOfKeys);
		Assert.assertEquals(aggrKey.size(), numberOfKeys);
		LOGGER.info("Get AggregationRuleKey Pass...");
	}

	@Test
	public void testGetAggregationMetricsEvaluation()
			throws AggregationException {
		List<Number> aggergationMetricsSpelResult = null;
		Assert.assertNull(aggergationMetricsSpelResult);
		aggergationMetricsSpelResult = aggrServiceImpl.getColumnsToAggregate(
				aggrMetrics, ora, "Test",
				new ArrayList<AggregationExceptionItem>());
		Assert.assertNotNull(aggergationMetricsSpelResult);
		Assert.assertEquals(aggrMetrics.size(),
				aggergationMetricsSpelResult.size());
		LOGGER.info("Aggregation Metric Evaluation Pass...");
	}

	@Test
	public void testWhereCriteriaEvaluation()
			throws AggregationException {
		Boolean whereCriteriaResult = Boolean.FALSE;
		Assert.assertFalse(whereCriteriaResult);
		whereCriteriaResult = aggrServiceImpl.getWhereCriteria(ora,
				aggrWhereCriteria, "Test",
				new ArrayList<AggregationExceptionItem>());
		Assert.assertTrue(whereCriteriaResult);
		LOGGER.info("Aggregation Criteria Evaluation Pass...");
	}

}
