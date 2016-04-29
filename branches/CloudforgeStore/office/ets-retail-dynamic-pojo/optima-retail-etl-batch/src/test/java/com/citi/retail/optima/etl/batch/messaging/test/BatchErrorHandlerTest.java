package com.citi.retail.optima.etl.batch.messaging.test;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.batch.messaging.BatchErrorHandler;
import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/retail.optima.etl.batch.test.xml" })
public class BatchErrorHandlerTest {

	@Autowired
	BatchErrorHandler errorHandler;

	@Test
	public void testErrorHandler() {
		Assert.assertNotNull(errorHandler.getJmsTemplate());
		errorHandler.handleError(new OptimaRetailApplicationException(1l, 1l,
				1l, ServiceName.BATCH, ExceptionType.ERROR, "Test error",
				"Test error", null));
	}
}
