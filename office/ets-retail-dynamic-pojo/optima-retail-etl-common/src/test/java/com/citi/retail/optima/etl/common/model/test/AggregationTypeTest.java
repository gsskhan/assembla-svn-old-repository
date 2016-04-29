/**
 * 
 */
package com.citi.retail.optima.etl.common.model.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.citi.retail.optima.etl.common.model.AggregationType;

/**
 * @author hs73849
 * 
 */
public class AggregationTypeTest {

	private AggregationType acct;

	@Before
	public void setUp() {
		acct = new AggregationType();
	}

	@Test
	public void testAccountTraceObj() {
		acct.setId(1L);
		Assert.assertEquals(acct.getId(), new Long(1L));

		acct.setName("NAME");
		Assert.assertEquals(acct.getName(), "NAME");

		List<String> aggreList = new ArrayList<String>();
		aggreList.add("AGGR_RULE_SPEL");
		acct.setAggregationRuleKeySpelExpr(aggreList);

		Assert.assertEquals(acct.getAggregationRuleKeySpelExpr().size(), 1);

		aggreList.add("AGGR_COLUMN_SPEL");
		acct.setColumnsToAggregateValueSpelExpr(aggreList);

		Assert.assertEquals(acct.getColumnsToAggregateValueSpelExpr().size(), 2);

		acct.setWhereCriteriaSpelExpr("WHERE_CRITERIA");
		Assert.assertEquals(acct.getWhereCriteriaSpelExpr(), "WHERE_CRITERIA");

		acct.setProcessingUnitId(1);
		Assert.assertEquals(acct.getProcessingUnitId(), new Integer(1));

		Assert.assertEquals(acct.toString().length() > 0, true);
		Assert.assertNotNull(acct.toString());

	}
}
