/**
 * 
 */
package com.citi.retail.optima.etl.aggregation.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.aggregation.exception.AggregationException;
import com.citi.retail.optima.etl.aggregation.impl.AggregationServiceFactoryImpl;
import com.citi.retail.optima.etl.aggregation.impl.AggregationServiceImpl;

/**
 * @author mc56120
 * 
 *         This test verifies the aggregation results save to DB
 */

/**
 * 
 * Note: missing partent constraint => bad data test... need to devise new testing approache. EH
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.aggregation.test.config.xml"})
public class AggregationResultSaveTest_DI {

	@Autowired
	private AggregationServiceFactoryImpl<?> aggregationServiceFactoryImpl;

	private AggregationServiceImpl<Object> aggregationService = null;

	@Autowired
	private SpelExpressionParser spelParser;
	private SupplementaryDataRecord supplRecord1;
	private SupplementaryDataRecord supplRecord2;
	private final List<String> aggrKey = null;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private Connection connection;

	@Before
	public void setUp() {
		try {
			connection = jdbcTemplate.getDataSource().getConnection();
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			System.out.println("Exception in Init " + "Method while Loading");
		}
	}

	/**
	 * Case 1 : Save aggregation results to DB.
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testAggregationSaveScenario1() {
		List<String> keyList = new ArrayList<String>();
		final Long batchId = 10002L;
		String category = "suppDataProcessStep";
		Integer sysProcId = 19;
		String key = category + ":" + sysProcId;

		try {
			keyList.add(key);
			aggregationService = (AggregationServiceImpl<Object>) aggregationServiceFactoryImpl
					.getAggregationService(keyList,batchId, new Date(),category, sysProcId);
			Assert.assertNotNull(aggregationService);
			Map<String, Map<String, List<Number>>> aggregationMap1 = aggregationService
					.getLocalAggregationMap(new Integer("1"));
			supplRecord1=populateSupplObjectModel("IN", 2,201401, new Double(100.0));
			supplRecord2=populateSupplObjectModel("IN", 3,201402, new Double(200.0));
			aggregationService.aggregate(supplRecord1, aggregationMap1, false);
			aggregationService.aggregate(supplRecord2, aggregationMap1, false);

			boolean savedResult = aggregationService.saveAggregationResults();
			Assert.assertTrue(savedResult);

		} catch (AggregationException e) {

		} finally {
			try {
				connection.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * Case 2 : Save aggregation results to DB. Data length for country
	 * is tooo large than whats defined in database. we get exception ORA-12899:
	 * value too large for column ORDS.RRD.RPT_RPT_OUTPUT.CNTRY_CD
	 * (actual: 22, maximum: 2) aggregation result save to DB fails.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testAggregationSaveScenario2() {
		List<String> keyList = new ArrayList<String>();
		final Long batchId = 10002L;
		String category = "suppDataProcessStep";
		Integer sysProcId = 19;
		String key = category + ":" + sysProcId;

		try {
			keyList.add(key);
			aggregationService = (AggregationServiceImpl<Object>) aggregationServiceFactoryImpl
					.getAggregationService(keyList,batchId, new Date(),category, sysProcId);
			Assert.assertNotNull(aggregationService);
			Map<String, Map<String, List<Number>>> aggregationMap1 = aggregationService
					.getLocalAggregationMap(new Integer("1"));
			supplRecord1=populateSupplObjectModel("More than 2 Characters", 2,201401, new Double(100.0));
			
			aggregationService.aggregate(supplRecord1, aggregationMap1, false);
						
			boolean savedResult = aggregationService.saveAggregationResults();
			Assert.assertFalse(savedResult);
		} catch (Exception e) {
			e.printStackTrace();
			//Assert.fail("ORA-12899: value too large for column ??? (actual: 22, maximum: 2)");

		} finally {
			try {
				connection.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Case 3 : Save aggregation results to DB. Data for setCumLifeGrossChargeOffAmt
	 * is tooo large than whats defined in database. aggregation result save to
	 * DB fails. we get a FATAL exception Caused by:
	 * SQL state [99999]; error code [17001]; Internal Error: Overflow Exception trying
	 * to bind 4.51E143
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testAggregationSaveScenario3() {
		List<String> keyList = new ArrayList<String>();
		final Long batchId = 10002L;
		String category = "suppDataProcessStep";
		Integer sysProcId = 19;
		String key = category + ":" + sysProcId;

		try {
			keyList.add(key);
			aggregationService = (AggregationServiceImpl<Object>) aggregationServiceFactoryImpl
					.getAggregationService(keyList,batchId, new Date(),category, sysProcId);
			Assert.assertNotNull(aggregationService);
			Map<String, Map<String, List<Number>>> aggregationMap1 = aggregationService
					.getLocalAggregationMap(new Integer("1"));
			supplRecord1=populateSupplObjectModel("IN", 2,201401, new Double(450999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999.00d));
			
			aggregationService.aggregate(supplRecord1, aggregationMap1, false);
						
			boolean savedResult = aggregationService.saveAggregationResults();    //overflow exception
			Assert.assertFalse(savedResult);
	
		} catch (AggregationException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private SupplementaryDataRecord populateSupplObjectModel(String countryCd, Integer regionId, Integer rptPeriod,  Double cumLifeGrossChargeOffAmt){
		SupplementaryDataRecord record = new SupplementaryDataRecord();
		record.setRptPeriod(rptPeriod);
		record.setRegionId(regionId);
		record.setCountry(countryCd);
		record.setBusinessUnit("ASIA GCB");
		record.setProductType("SU_NLS");
		record.setCumLifeGrossChargeOffAmt(cumLifeGrossChargeOffAmt);
		record.setCumLifePurcImprFairValAdj(new Double(20.0));
		record.setAutoLeaseRepY14QSch(new Double(30.0));
		record.setNonAutoLeaseRepY14QSch(new Double(40.0));
		record.setNonPurSecBasLoaRep(new Double(50.0));
		record.setSmeCorpCardLoaRepComIndUs(new Double(60.0));
		record.setSmeCorpCardLoaRepComIndOutUs(new Double(70.0));
		record.setSmeCorpCardLoaIndFamOtCard(new Double(80.0));
		record.setSmeCorpCardLoaIndFamOthers(new Double(90.0));
		record.setSubmitterId("PJ58187");
		
		record.setERegionId(regionId);
		record.setEBusinessUnitId(12);
		record.setEProductId(4);
		record.setEFedProductId(regionId);
		record.setEFedProductId(40);
		record.setProcessingUnit(19);
		record.setEFedRegionSegmentId(regionId);
		
		return record;
		
	}
	
	

}
