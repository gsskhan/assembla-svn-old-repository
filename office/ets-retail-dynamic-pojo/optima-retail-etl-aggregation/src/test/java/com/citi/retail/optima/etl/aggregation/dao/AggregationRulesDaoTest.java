package com.citi.retail.optima.etl.aggregation.dao;

import java.text.ParseException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ch.qos.logback.classic.Logger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.aggregation.test.config.xml" })

public class AggregationRulesDaoTest {
	private final static Logger LOGGER = (Logger) LoggerFactory
			.getLogger(AggregationRulesDaoTest.class);
	@Autowired
	private  AggregationRulesDao aggregationRulesDao;
   
	@BeforeClass 
	public static void setUp() throws ParseException {
		
		LOGGER.info("Testing AggregationRulesDao");
	}
      
	@Test
	public void getAggregationRulesTest() {
	
		Assert.assertNotNull("Unalbe to obtain an instance of AggregationRulesDao", aggregationRulesDao);
		Assert.assertNotEquals(0, aggregationRulesDao.getAggregationRules().size());
		LOGGER.info("Got aggregation rules... ");
      
	}
	
	@Test
	public void getAggregationRulesWithKeyTest() {
		Assert.assertNotNull("Unalbe to obtain an instance of AggregationRulesDao", aggregationRulesDao);
		Assert.assertNotEquals(0, aggregationRulesDao.getAggregationRulesWithKey().size());
		LOGGER.info("Got aggregation rules with key...");
	}
	
	@Test
	public void getAggregationSqlRulesWithKeyTest() {
		Assert.assertNotNull("Unalbe to obtain an instance of AggregationRulesDao", aggregationRulesDao);
		Assert.assertNotEquals(0, aggregationRulesDao.getAggregationSQLRuleRef().size());
		LOGGER.info("Got sql type aggregation rules with key...");
	}
}
