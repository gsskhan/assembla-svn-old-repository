package com.citi.retail.optima.etl.controller.request.dispatcher;

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
import com.citi.retail.optima.etl.controller.model.BatchInstance;

/**
 * @author sv16441
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/retail.optima.etl.controller.test.xml" })
public class JobRequestDispatcherTest {

	@Autowired
	private JobRequestDispatcher jobRequestDispatcher;

	@Test
	public void testdispatchRequest() {
		testDispatchMessage();
	}

	private void testDispatchMessage() {

		List<BatchInstance> batchinstanceLst = new ArrayList<BatchInstance>();

		BatchInstance batchInstance = null;
		batchInstance = new BatchInstance();
		batchInstance.setBatchId(new Long(2625));
		batchinstanceLst.add(batchInstance);
		batchInstance = new BatchInstance();
		batchInstance.setBatchId(new Long(2624));
		batchinstanceLst.add(batchInstance);
		Message<List<BatchInstance>> message = MessageBuilder.withPayload(
				batchinstanceLst).build();
		try {
			List<String> dispatchRequest = null;
			Assert.assertEquals(dispatchRequest,
					jobRequestDispatcher.dispatchRequest(message));
		} catch (OptimaRetailApplicationException e) {
			System.out.println("Error in handle Message" + e);
		}
	}

}
