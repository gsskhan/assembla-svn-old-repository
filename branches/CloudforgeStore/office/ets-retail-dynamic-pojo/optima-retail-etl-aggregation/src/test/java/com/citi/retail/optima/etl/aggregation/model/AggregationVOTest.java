/**
 * 
 */
package com.citi.retail.optima.etl.aggregation.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.citi.retail.optima.etl.aggregation.model.AggregationVO;

/**
 * @author mc56120
 * 
 */

public class AggregationVOTest {

	@Test
	public void testSetJobInstanceId() {
		AggregationVO aggrVo = new AggregationVO();
		aggrVo.setJobInstanceId(new Long(1000));
		Assert.assertEquals(new Long(1000), aggrVo.getJobInstanceId());
	}

	@Test
	public void testSetProcessingUnitId() {
		AggregationVO aggrVo = new AggregationVO();
		aggrVo.setProcessingUnitId(2);
		Assert.assertTrue(aggrVo.getProcessingUnitId() == 2);
	}

	@Test
	public void testSetInsertSql() {
		AggregationVO aggrVo = new AggregationVO();
		String insertSql = "Test SQL";
		aggrVo.setInsertSql(insertSql);
		Assert.assertEquals(insertSql, aggrVo.getInsertSql());
	}

	@Test
	public void testSetMonthEndDate() {
		java.sql.Date endDate = new java.sql.Date(new Date().getTime());
		AggregationVO aggrVo = new AggregationVO();
		aggrVo.setMonthEndDate(endDate);
		Assert.assertEquals(endDate, aggrVo.getMonthEndDate());
	}

	@Test
	public void testSetAggregationType() {
		AggregationVO aggrVo = new AggregationVO();
		String aggrType = "Test Aggregation Type";
		aggrVo.setAggregationType(aggrType);
		Assert.assertEquals(aggrType, aggrVo.getAggregationType());
	}

	@Test
	public void testSetAggregationKey() {
		Map<String, List<String>> aggregationKey = new HashMap<String, List<String>>();
		AggregationVO aggrVo = new AggregationVO();
		aggrVo.setAggregationKey(aggregationKey);
		Assert.assertTrue(aggrVo.getAggregationKey().size() == 0);
	}

	@Test
	public void testSetAggregationValues() {
		Map<String, List<Number>> aggregationValues = new HashMap<String, List<Number>>();
		AggregationVO aggrVo = new AggregationVO();
		aggrVo.setAggregationValues(aggregationValues);
		Assert.assertTrue(aggrVo.getAggregationValues().size() == 0);
	}
}
