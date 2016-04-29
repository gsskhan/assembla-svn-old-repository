package com.citi.retail.optima.etl.aggregation.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration({ "/optima.retail.aggregation.test.config.xml"})
public class AggregationExceptionTest {




	@Test
	public void testSetGetExceptionScope() throws Exception {
		AggregationException  exception = new AggregationException(ExceptionType.FATAL, ExceptionScope.SERVICE, "test message");
		Assert.assertEquals(ExceptionScope.SERVICE.name(), exception.getExceptionScope().name());
	}

	@Test
	public void testSetGetExceptionType() throws Exception {
		AggregationException  exception = new AggregationException(ExceptionType.FATAL, ExceptionScope.SERVICE, "test message");
		Assert.assertEquals(ExceptionType.FATAL.name(), exception.getExceptionType().name());
	}

	
	@Test
	public void testSetGetExceptionMessage() throws Exception {
		AggregationException  exception = new AggregationException(ExceptionType.FATAL, ExceptionScope.SERVICE, "test message");
		Assert.assertEquals("test message", exception.getExceptionMessage());
	}

	

	@Test
	public void testSetGetExceptionItems() throws Exception {
		
		AggregationException  exception =  new AggregationException(ExceptionType.FATAL, ExceptionScope.SERVICE, "test message");
		List<AggregationExceptionItem> items = new ArrayList<AggregationExceptionItem>(10);
		items.add(new AggregationExceptionItem());
		items.get(0).getExceptionsDetail().put("groupName", new HashMap<String,String>(10));
		Assert.assertNotNull(items.get(0).getExceptionsDetail().get("groupName"));
	}

	

}
