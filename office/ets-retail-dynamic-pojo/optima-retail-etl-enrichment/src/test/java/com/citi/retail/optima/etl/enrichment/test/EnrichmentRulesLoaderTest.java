package com.citi.retail.optima.etl.enrichment.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.enrichment.EnrichmentRulesLoader;
import com.citi.retail.optima.etl.enrichment.common.EnrichmentRule;
import com.citi.retail.optima.etl.enrichment.exception.EnrichmentException;

/**
 * 
 * @author ms04453
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.enrichment.config.test.xml"})
public class EnrichmentRulesLoaderTest {

	@Autowired
	private EnrichmentRulesLoader enrichmentRulesHolder;
	
	private List<String> keyList;
	
	@Before
	public void setUp() {
		keyList = new ArrayList<String>(1); 	
		keyList.add("USCCARProcessStep:3");
		keyList.add("USCCARProcessStep:4");
		keyList.add("USCCARProcessStep:5");
	}
	
	
	@Test
	public void testGetRulesList() throws Exception {
		try {
			List<EnrichmentRule> rulesList = enrichmentRulesHolder.getRulesList(keyList);
			Assert.assertNotNull(rulesList);		
			Assert.assertNotEquals(0, rulesList.size());
			for(EnrichmentRule rule: rulesList) {
				Assert.assertNotNull(rule.getAttrName());
				Assert.assertNotNull(rule.getAttributeId());
				Assert.assertNotNull(rule.getRulesKey());
				Assert.assertNotNull(rule.getRuleToExecute());
				Assert.assertNotNull(rule.getSysProcId());
				Assert.assertNotNull(rule.getRule());
				Assert.assertNotNull(rule.getRuleOrder());
				
			}	
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}	


	@Test(expected = EnrichmentException.class)
	public void testGetRulesListWithSamekey() throws Exception {
		keyList.add("USCCARProcessStep:3");
		List<EnrichmentRule> rulesList = enrichmentRulesHolder.getRulesList(keyList);
		Assert.assertNotNull(rulesList);
	}
	
	@Test(expected = EnrichmentException.class)
	public void testEmptyRulesListWithInvalidKey() throws Exception {
		keyList = new ArrayList<String>(1); 	
		keyList.add("USCCARProcessStep:12525");
		try {
			Assert.assertTrue(enrichmentRulesHolder.getRulesList(keyList).isEmpty());
		} catch (EnrichmentException ex) {
			EnrichmentException exception = new EnrichmentException();
			exception.setExceptionMessage(ex.getExceptionMessage());
			exception.setExceptionTrace(ex.getExceptionTrace());
			exception.setExcetionDetailList(ex.getExcetionDetailList());
			exception.setRootException(ex.getRootException());
			throw exception;
		}
		
	}
	
	@Test()
	public void testAfterPropertiesSet() throws Exception {
		List<String> keyList = new ArrayList<String>();
		keyList.add("suppDataProcessStep:20");		
	}

}
