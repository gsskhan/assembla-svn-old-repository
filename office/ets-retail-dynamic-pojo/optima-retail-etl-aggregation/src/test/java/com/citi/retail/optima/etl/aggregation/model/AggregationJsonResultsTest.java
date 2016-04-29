package com.citi.retail.optima.etl.aggregation.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobInstance;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.aggregation.util.AggregationJsonResultVO;
import com.citi.retail.optima.etl.aggregation.util.AggregationJsonResults;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.aggregation.test.config.xml"})
public class AggregationJsonResultsTest {


	@Test
	public void testAggregationJsonResults() throws Exception {
		 AggregationJsonResults.add("test",
					new AggregationJsonResultVO("test",JsonNodeFactory.instance.arrayNode()));
	}

	@Test
	public void testAdd() throws Exception {
	
		 AggregationJsonResults.add("test",
				new AggregationJsonResultVO("test",JsonNodeFactory.instance.arrayNode()));
		 Assert.assertEquals(1, AggregationJsonResults.getList("test").size());
		
	}

	@Test
	public void testGetList() throws Exception {
		 AggregationJsonResults.add("test",
				new AggregationJsonResultVO("test",JsonNodeFactory.instance.arrayNode()));
		 Assert.assertNotNull(AggregationJsonResults.getList("test"));
	}



	@Test
	public void testClearResults() throws Exception {
		AggregationJsonResults.add("test",
				new AggregationJsonResultVO("test",JsonNodeFactory.instance.arrayNode()));
		 Assert.assertNotNull(AggregationJsonResults.getList("test"));
		 AggregationJsonResults.clearResults("test");
		 Assert.assertNull(AggregationJsonResults.getList("test"));
	}

	@Test
	public void testDisplayJsonString() throws Exception {
		JobExecution je = new JobExecution(1L);
		je.setJobInstance(new JobInstance(1L,null,"jobName"));
		AggregationJsonResults.generateJobKey(je);
		AggregationJsonResults.add("test",
				new AggregationJsonResultVO("test",JsonNodeFactory.instance.arrayNode().add("test")));
		AggregationJsonResults.displayJsonString(new AggregationJsonResultVO("test",JsonNodeFactory.instance.arrayNode()));
		Assert.assertTrue(true);
		
	}

}
