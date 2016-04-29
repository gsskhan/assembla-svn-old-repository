package com.citi.retail.optima.etl.aggregation.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.aggregation.dao.AggregationDao;
import com.citi.retail.optima.etl.aggregation.exception.AggregationException;
import com.citi.retail.optima.etl.aggregation.model.AggregationVO;

/**
 * @author mc56120
 * 
 * Aggregation DAO Impl save for Supplementary schedule
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.aggregation.test.config.xml" })
public class AggregationDaoImplTest {
	
	@Autowired
	private AggregationDao aggregationDao;
	private final Map<String, List<Number>> aggrMetricsMap = new HashMap<String, List<Number>>();

	private List<AggregationVO> aggregationVoList = null;
	private static final String AGGRKEY = "1;;;IN;;;11;;;4;;;201401;;;PJ58187;;;19";
    //TODO: this SQL no longer valid... needs to find out the correct one
	private static final String SQL = "INSERT into RRD_RPT_OUTPUT (BATCH_INST_ID,AGGR_RULE_ID,SYS_PROC_ID, RGN_ID, CNTRY_CD, BSUNIT_ID, PROD_TYP_BND_ID,RPT_PRD,SUBMT_ID,PROC_UNIT_ID,D_GROSS_CONTRACTUAL_CO, YD_PURC_IMPR_FAIR_VAL_ADJ, YD_AUTO_LEAS_RPTD_14Q, YD_NON_AUTO_LEAS_RPTD_14Q, YD_NON_PURP_SEC_LOAN_RPTD_BHCK, YD_SME_CORP_CRD_LOAN_RPTD_US, YD_SME_CORP_CRD_LOAN_RPTD_NONU, YD_SME_CORP_CRD_CONS_LOAN_RPTD, YD_SME_CORP_CRD_LOAN_OTH_REV_R,EFF_DT) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSTIMESTAMP)";

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private Connection connection;
	@Before
	public void setUp() throws ParseException {

		try {
			connection = jdbcTemplate.getDataSource().getConnection();
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		aggregationVoList = new ArrayList<AggregationVO>();
		AggregationVO aggrVO = new AggregationVO();
		populateAggrMetrics();
		aggrVO.setAggregationType("19"); 
		aggrVO.setSysProcId(19);
		aggrVO.setAggregationValues(aggrMetricsMap);
		aggrVO.setJobInstanceId(new Long("10002"));
		aggrVO.setInsertSql(SQL);
		aggregationVoList.add(aggrVO);
	}

	/**
	 * populate aggregation metrics data
	 */
	private void populateAggrMetrics() {
		List<Number> aggrList = new ArrayList<Number>();
		aggrList.add(new Float(100.00));
		aggrList.add(new Float(800.00));
		aggrList.add(new Float(200.00));
		aggrList.add(new Float(900.00));
		aggrList.add(new Float(300.00));
		aggrList.add(new Float(100.00));
		aggrList.add(new Float(800.00));
		aggrList.add(new Float(200.00));
		aggrList.add(new Float(900.00));
		aggrMetricsMap.put(AGGRKEY, aggrList);
	}

	@Test
	public void saveAggregationResultTest()
			throws AggregationException {
		boolean saveAggrResults = false;
		Assert.assertFalse(saveAggrResults);
		try {
			saveAggrResults = aggregationDao.saveAggregationResults(aggregationVoList);
			Assert.assertTrue(saveAggrResults);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(saveAggrResults);
		} finally {
			try {
				connection.rollback();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
