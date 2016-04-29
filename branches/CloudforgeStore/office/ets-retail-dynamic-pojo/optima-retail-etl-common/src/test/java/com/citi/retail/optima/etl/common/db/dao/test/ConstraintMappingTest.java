/**
 * 
 */
package com.citi.retail.optima.etl.common.db.dao.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.citi.retail.optima.etl.common.db.dao.ConstraintMapping;
import com.citi.retail.optima.etl.common.db.dao.RuleInfo;

/**
 * @author mc56120
 * 
 */
public class ConstraintMappingTest {

	private ConstraintMapping mapping;

	@Before
	public void testSetUp() {
		mapping = new ConstraintMapping("TestFieldName", "TestValidationType",
				1, "TestValidationCategory","TestRuleKey");
	}

	@Test
	public void testSetClassName() {
		mapping.setClassName("TestClassName");
		Assert.assertEquals("TestClassName", mapping.getClassName());
	}

	@Test
	public void testSetFieldName() {
		mapping.setFieldName("TestFieldName");
		Assert.assertEquals("TestFieldName", mapping.getFieldName());
	}

	@Test
	public void testSetValidationType() {
		mapping.setValidationType("TestValidationType");
		Assert.assertEquals("TestValidationType", mapping.getValidationType());
	}

	@Test
	public void testSetRules() {
		List<RuleInfo> rules = new ArrayList<RuleInfo>();
		mapping.setRules(rules);
		Assert.assertTrue(mapping.getRules() != null);
	}

	@Test
	public void testSetProcessingUnitId() {
		mapping.setProcessingUnitId(new Integer("1"));
		Assert.assertEquals(new Integer("1"), mapping.getProcessingUnitId());
	}

	@Test
	public void testSetValidationCategory() {
		mapping.setValidationCategory("TestValidationCategory");
		Assert.assertEquals("TestValidationCategory",
				mapping.getValidationCategory());
	}

	@Test
	public void testSetCheckOnlyField() {
		mapping.setCheckOnlyField(true);
	}

	@Test
	public void testEquals() {
		ConstraintMapping newMapping = new ConstraintMapping("TestFieldName",
				"TestValidationType", 1, "TestValidationCategory","TestRuleKey");
		Assert.assertTrue(mapping.equals(newMapping));
	}

	@Test
	public void testHashCode() {
		ConstraintMapping newMapping = new ConstraintMapping("TestFieldName",
				"TestValidationType", 1, "TestValidationCategory","TestRuleKey");
		//Assert.assertEquals(2091871483, newMapping.hashCode());

	}

}
