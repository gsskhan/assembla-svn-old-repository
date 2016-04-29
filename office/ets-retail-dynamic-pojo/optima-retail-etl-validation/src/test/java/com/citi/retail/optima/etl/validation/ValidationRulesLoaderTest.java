/**
 * 
 */
package com.citi.retail.optima.etl.validation;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.validation.constraint.RuleConstraint;

/**
 * @author TJ
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.validation.test.xml"})
public class ValidationRulesLoaderTest {

	@Autowired
	private ValidationRulesLoader validationRulesHolder;
	
	private List<String> keyList;
	
	@Before
	public void setUp() {
		keyList = new ArrayList<String>(1); 	
		keyList.add("USCCARProcessStep:3");
		keyList.add("USCCARProcessStep:4");
		keyList.add("USCCARProcessStep:5");
	}
	
	@Test()
	public void testGetRulesList() throws Exception {
		List<RuleConstraint> rulesList = validationRulesHolder.getRulesList(keyList);
		Assert.assertNotNull(rulesList);		
		Assert.assertNotEquals(0, rulesList.size());
	}
	
	@Test()
	public void testGetRulesListWithSameKey() throws Exception {
		keyList.add("USCCARProcessStep:3");
		List<RuleConstraint> rulesList = validationRulesHolder.getRulesList(keyList);
		Assert.assertNotNull(rulesList);		
	}

	
	@Test()
	public void testEmptyRulesList() throws Exception {
		List<RuleConstraint> rulesList = validationRulesHolder.getRulesList(new ArrayList<String>());
		Assert.assertNotNull(rulesList);
		Assert.assertEquals(0, rulesList.size());
	}

}
