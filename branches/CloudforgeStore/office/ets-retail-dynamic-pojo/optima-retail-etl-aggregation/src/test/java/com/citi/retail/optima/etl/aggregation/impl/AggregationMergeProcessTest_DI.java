/**
 * 
 */
package com.citi.retail.optima.etl.aggregation.impl;

import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.test.util.ReflectionTestUtils;

import com.citi.retail.optima.etl.aggregation.exception.AggregationException;
import com.citi.retail.optima.etl.aggregation.impl.AggregationServiceFactoryImpl;
import com.citi.retail.optima.etl.aggregation.impl.AggregationServiceImpl;

/**
 * @author mc56120
 * 
 *         This test verifies the aggregation merge process across partitions
 *         Case 1 : create 2 partitions and create same buckets/segments in each
 *         partition. Case 1 : create 2 partitions and create diff
 *         buckets/segments in each partition.
 */

/**
 * data issue  i.e. rule...EH
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.aggregation.test.config.xml"})
public class AggregationMergeProcessTest_DI {

	@Autowired
	private AggregationServiceFactoryImpl<?> aggregationServiceFactoryImpl;

	private AggregationServiceImpl<Object> aggregationService = null;

	@Autowired
	private SpelExpressionParser spelParser;
	private CardsAccount ora1;
	private CardsAccount ora2;
	private CardsAccount ora3;
	private final List<String> aggrKey = null;

	/**
	 * Case 1 : create 2 partitions and create same buckets/segments in each
	 * partition. Merge the results across partitions Verify the resultant map
	 * it should contain only one bucket/segment (after merge)
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testAggregationMergeScenario1() {
		List<String> keyList = new ArrayList<String>();
		Long batchId = 300L;
		String category = "cardsMonthEndStep";
		String processingUnit = "3";
		String key = category + ":" + processingUnit;

		try {
			keyList.add(key);
			// get the aggregation service for cards month end
			aggregationService = (AggregationServiceImpl<Object>) aggregationServiceFactoryImpl
					.getAggregationService(keyList, batchId, new Date(),
							category);
			Assert.assertNotNull(aggregationService);

			// partition 1
			Map<String, Map<String, List<Number>>> aggregationMap1 = aggregationService
					.getLocalAggregationMap(new Integer("1"));
			ora1 = populateAccountModel("123456", "Test", "02", "GB", "CARDS",
					"02", "01", "01");
			aggregationService.aggregate(ora1, aggregationMap1, true);

			// partition 2
			Map<String, Map<String, List<Number>>> aggregationMap2 = aggregationService
					.getLocalAggregationMap(new Integer("2"));
			ora2 = populateAccountModel("567890", "Test", "02", "GB", "CARDS",
					"02", "01", "01");
			aggregationService.aggregate(ora2, aggregationMap2, true);

			ReflectionTestUtils.invokeMethod(aggregationService,
					"mergeAggregationResults", null);
			Map<String, Map<String, List<Number>>> resultMap = (Map<String, Map<String, List<Number>>>) ReflectionTestUtils
					.getField(aggregationService, "aggregationResults");
			Map<String, List<Number>> finalMap = resultMap.get("2"); // aggr_rule_id=2
																		// -->
																		// CARDS
			Assert.assertEquals(1, finalMap.size());

			for (String str : finalMap.keySet()) {
				List<Number> metricList = finalMap.get(str);
				Assert.assertEquals(2.0, metricList.get(0));
				Assert.assertEquals(
						ora1.getGrossOutstandingPrinBal()
								+ ora2.getGrossOutstandingPrinBal(),
						metricList.get(1));

			}
		} catch (AggregationException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Case 2 : create 2 partitions and create diff buckets/segments in each
	 * partition. Merge the results across partitions Verify the resultant map
	 * it should contain two bucket/segment (after merge)
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testAggregationMergeScenario2() {
		List<String> keyList = new ArrayList<String>();
		Long batchId = 300L;
		String category = "cardsMonthEndStep";
		String processingUnit = "3";
		String key = category + ":" + processingUnit;

		try {
			keyList.add(key);
			aggregationService = (AggregationServiceImpl<Object>) aggregationServiceFactoryImpl
					.getAggregationService(keyList, batchId, new Date(),
							category);
			Assert.assertNotNull(aggregationService);
			// partition1
			Map<String, Map<String, List<Number>>> aggregationMap1 = aggregationService
					.getLocalAggregationMap(new Integer("1"));
			ora1 = populateAccountModel("123456", "Test", "02", "GB", "CARDS",
					"02", "01", "01");
			aggregationService.aggregate(ora1, aggregationMap1, true);

			// partition2
			Map<String, Map<String, List<Number>>> aggregationMap2 = aggregationService
					.getLocalAggregationMap(new Integer("2"));
			ora2 = populateAccountModel("567890", "Test", "01", "GB", "CARDS",
					"03", "02", "02");
			aggregationService.aggregate(ora2, aggregationMap2, true);

			// merge
			ReflectionTestUtils.invokeMethod(aggregationService,
					"mergeAggregationResults", null);
			Map<String, Map<String, List<Number>>> resultMap = (Map<String, Map<String, List<Number>>>) ReflectionTestUtils
					.getField(aggregationService, "aggregationResults");
			Map<String, List<Number>> finalMap = resultMap.get("2"); // aggr_rule_id=2
																		// -->
																		// CARDS
			Assert.assertEquals(2, finalMap.size()); // the result should
														// contain the segments
														// from both partitions
		} catch (AggregationException e) {
			e.printStackTrace();
		}
	}

	private CardsAccount populateAccountModel(String accountNumber,
			String baselPortfolioId, String region, String cntry,
			String prodType, String age, String delqStatus, String fico) {
		CardsAccount cardsAccount = new CardsAccount();
		cardsAccount.setAccountNumber(accountNumber);
		cardsAccount.setBaselPortfolioId(baselPortfolioId);
		cardsAccount.setERegion(region);
		cardsAccount.setManagedGeography(cntry);
		cardsAccount.setProductType(prodType);
		cardsAccount.setECcarAge(age);
		cardsAccount.setEDelinquencyStatus(delqStatus);
		cardsAccount.setEFicoEquivalent(fico);
		cardsAccount.setNaturalCcy("USD");
		cardsAccount.setENumAccounts(1L);
		cardsAccount.setGrossOutstandingPrinBal(450.00d);
		cardsAccount.setAccountEnr(2300.80);
		cardsAccount.setEOutstandingDPDOver30Amt(350.00d);
		cardsAccount.setENumAcctDPDOver30(1L);
		cardsAccount.setECommitmentAmt(600.00d);
		cardsAccount.setENewCommitmentAmt(453.00d);
		cardsAccount.setPrincipalContractualChargeOff(250.00d);
		cardsAccount.setPrincipalChargeOffBankruptcy(100.00d);
		cardsAccount.setRecovery(440.00d);
		cardsAccount.setENumAccountChargeOff(1L);
		cardsAccount.setPrincipalChargeOff(57.00d);
		cardsAccount.setENetChargeOffReconAmt(200.00d);
		Map<String, Boolean> includeAccount = new HashMap<String, Boolean>();
		includeAccount.put("3", Boolean.TRUE);
		cardsAccount.setIncludeAccount(includeAccount);
		return cardsAccount;
	}

}
