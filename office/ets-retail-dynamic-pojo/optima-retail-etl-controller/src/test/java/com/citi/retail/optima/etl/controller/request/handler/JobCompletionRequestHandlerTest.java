package com.citi.retail.optima.etl.controller.request.handler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.Message;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.controller.dao.JobInstanceDao;
import com.citi.retail.optima.etl.controller.model.BatchInstance;
import com.citi.retail.optima.etl.controller.model.MessageLog;
import com.citi.retail.optima.etl.controller.model.RequestMessageType;
import com.citi.retail.optima.xsd.internal.OptimaRetailETLEvent;

/**
 * @author hs73849
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/retail.optima.etl.controller.test.xml" })
public class JobCompletionRequestHandlerTest {

	@Autowired
	private JobCompletionRequestHandler batchCompletionHandlerService;

	@Autowired
	private JobInstanceDao jobInstanceDao;

	@Test
	public void testUpdateJobCompletionStatus()
			throws OptimaRetailApplicationException {
		batchCompletionHandlerService.setJobInstanceDao(jobInstanceDao);
		testHandleMessage();
	}

	private void testHandleMessage() throws OptimaRetailApplicationException {
		OptimaRetailETLEvent oae = new OptimaRetailETLEvent();
		oae.setBatchInstanceId(new BigInteger("642"));
		Message<OptimaRetailETLEvent> message = MessageBuilder.withPayload(oae).build();
//		Assert.assertEquals(RequestMessageType.BATCH_COMPLETION,
//				batchCompletionHandlerService.handleRequest(message));
	}

}
