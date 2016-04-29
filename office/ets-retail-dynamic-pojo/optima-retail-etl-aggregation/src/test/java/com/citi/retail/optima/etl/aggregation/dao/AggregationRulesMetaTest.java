package com.citi.retail.optima.etl.aggregation.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.aggregation.model.AggregationRuleLookup;

import ch.qos.logback.classic.Logger;

/**
 * 
 * Aggregation DAO Impl save for Supplementary schedule
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.aggregation.test.config.xml" })

public class AggregationRulesMetaTest {
	private final static Logger LOGGER = (Logger) LoggerFactory
			.getLogger(AggregationRulesMetaTest.class);
	@Autowired
	private  AggregationRuleLookup aggregationRulesLookup;
   
	@BeforeClass
	public  static void setUp() throws ParseException {
		
		LOGGER.info("Testing AggregationRulesRef");
	}

	@Test
	public void sortTest() {
	
		Assert.assertNotNull("Unalbe to obtain an instance of AggregationRuleLookup", aggregationRulesLookup);
		LOGGER.info("Testing AggregationRulesRef Sort Function");
		ArrayList<AggregationRuleMeta> rules= new ArrayList<AggregationRuleMeta>(aggregationRulesLookup.getRuleMap().values());
	
		Collections.sort(rules);
		/*System.out.println("\n\n");
		for(AggregationRuleRef<NoneSqlRuleRef> aggregationRuleRef: rules){
			System.out.print(aggregationRuleRef.getRuleReference().getAggregationRuleOrder()+",");
		}
	   */
		for(int i=0; i<rules.size()-1;i++){
			if(((AggregationRuleMeta)rules.get(i)).getAggregationRuleOrder()>((AggregationRuleMeta)rules.get(i+1)).getAggregationRuleOrder())
			Assert.fail("Rules are not sorted by rule order");			
		}	
		Assert.assertTrue("Rules are sorted by rule order",true);	
	}
	
	
}
