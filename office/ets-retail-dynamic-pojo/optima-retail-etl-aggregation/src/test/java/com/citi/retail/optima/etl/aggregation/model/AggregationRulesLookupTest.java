package com.citi.retail.optima.etl.aggregation.model;

import java.text.ParseException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ch.qos.logback.classic.Logger;

import com.citi.retail.optima.etl.aggregation.exception.AggregationException;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.aggregation.test.config.xml" })

public class AggregationRulesLookupTest {
	private final static Logger LOGGER = (Logger) LoggerFactory
			.getLogger(AggregationRulesLookupTest.class);
	@Autowired
	private  AggregationRuleLookup aggregationRuleLookup;
   
	@BeforeClass 
	public static void setUp() throws ParseException {
		
		LOGGER.info("Testing AggregationRuleLookup");
		
	}

	@Test
	public void testGetAggregationRuleType() {
	
		Assert.assertNotNull("Unalbe to obtain an instance of AggregationRuleLookup", aggregationRuleLookup);
		ArrayList<String> keyList= new ArrayList<String>(10);
		keyList.add("USCCARProcessStep:3");
		keyList.add("USCCARProcessStep:2");
		keyList.add("USCCARProcessStep:1");
		
		Assert.assertNotEquals(0, aggregationRuleLookup.getAggregationRuleType(keyList).size());
		LOGGER.info("Got aggregation rules using key list...");
      
	}
	
	@Test
	public void testGetAggregationSql() throws AggregationException {
	
		Assert.assertNotNull("Unalbe to obtain an instance of AggregationRuleLookup", aggregationRuleLookup);
		ArrayList<String> keyList= new ArrayList<String>(10);
		keyList.add("USCCARProcessStep:3");
		keyList.add("USCCARProcessStep:2");
		keyList.add("USCCARProcessStep:1");
		Assert.assertNotEquals(0, aggregationRuleLookup.getAggregationSql(keyList).size());
		LOGGER.info("Got sql type aggregation rules using key list...");
      
	}
	@Test
	public void testGetAggregationSqlDeprecated() throws AggregationException {
		ArrayList<Integer> keyList= new ArrayList<Integer>(10);
		keyList.add(3);
		keyList.add(2);
		keyList.add(1);
		Assert.assertNotNull("Unalbe to obtain an instance of AggregationRuleLookup", aggregationRuleLookup);
		Assert.assertNotEquals(0, aggregationRuleLookup.getAggregationSqlDeprecated(keyList).size());
		LOGGER.info("Got sql type aggregation rules using pu...");
      
	}
	
}
