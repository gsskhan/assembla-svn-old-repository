/**
 * 
 */
package com.citi.retail.optima.etl.common.db.dao.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.citi.retail.optima.etl.common.db.dao.RuleInfo;

/**
 * @author hs73849
 * 
 */
public class RuleInfoTest {

	private RuleInfo ruleInfo, ruleInfo1, ruleInfo2;

	@Before
	public void testSetUp() {
		ruleInfo = new RuleInfo("ruleName", 1, 1, "TestClassName");
		ruleInfo2 = new RuleInfo("ruleName", 1, 1, "TestClassName",
				"paramName1|paramName2", "paramValue1|paramValue2");
	}

	@Test
	public void testName() {
		Assert.assertEquals(ruleInfo.getName(), "ruleName");
	}

	@Test
	public void testId() {
		Assert.assertEquals(ruleInfo.getId(), new Integer(1));
	}
	
	@Test
	public void testExecOrder() {
		Assert.assertEquals(ruleInfo.getExecOrder(), new Integer(1));
	}
	
	@Test
	public void testClassName() {
		Assert.assertEquals(ruleInfo.getClassName(), "TestClassName");
	}
	
	@Test
	public void testParamName() {
		Assert.assertEquals(ruleInfo2.getParamsName().length, 2);
	}
	
	@Test
	public void testProperties() {
		Assert.assertEquals(ruleInfo2.getProperties().isEmpty(), true);
	}
	
	@Test
	public void testParamValues() {
		Assert.assertEquals(ruleInfo2.getParamsValue().length, 2);
	}

	@Test
	public void testEqualsMethod() {
		ruleInfo1 = ruleInfo;
		Assert.assertEquals(true, ruleInfo.equals(ruleInfo1));
	}

	@Test
	public void testCompareToMethod() {
		ruleInfo1 = ruleInfo;
		Assert.assertEquals(0, ruleInfo.compareTo(ruleInfo1));
		Assert.assertEquals(-1, ruleInfo.compareTo(null));
	}

	@Test
	public void testEquals() {
		RuleInfo ruleInfo = new RuleInfo("ruleName", 1, 1, "TestClassName");
		Assert.assertEquals(763276167, ruleInfo.hashCode());
	}

}
