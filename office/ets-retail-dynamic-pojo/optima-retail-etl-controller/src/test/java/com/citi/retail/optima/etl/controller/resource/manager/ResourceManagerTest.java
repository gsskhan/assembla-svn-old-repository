/**
 * 
 */
package com.citi.retail.optima.etl.controller.resource.manager;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.Message;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.controller.model.RequestMessageType;
import com.citi.retail.optima.etl.controller.model.ResourceManagerStatus;

/**
 * @author hs73849
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/retail.optima.etl.controller.test.xml" })
public class ResourceManagerTest {

	@Autowired
	private ResourceManager resourceManager;

	@Autowired
	private ResourceAllocator resourceAllocatorService;

	@Autowired
	private JobInstanceLoader jobInstanceLoader;

	@Autowired
	private JobInstanceHolder jobInstanceHolder;

	@Autowired
	private JobRunningChecker jobRunningCheckerService;

	@Autowired
	private JobDependancyChecker jobDependancyCheckerService;

	@Autowired
	private ResourceChecker resourceCheckerService;

	@Test
	public void testInjection() {
		Assert.assertEquals(resourceAllocatorService,
				resourceManager.getResourceAllocatorService());
		Assert.assertEquals(jobInstanceLoader,
				resourceManager.getJobInstanceLoader());
		Assert.assertEquals(jobInstanceHolder,
				resourceManager.getJobInstanceHolder());
		Assert.assertEquals(jobRunningCheckerService,
				resourceManager.getJobRunningCheckerService());
		Assert.assertEquals(jobDependancyCheckerService,
				resourceManager.getJobDependancyCheckerService());
		Assert.assertEquals(resourceCheckerService,
				resourceManager.getResourceCheckerService());
		Assert.assertNotNull(resourceManager.getOutputChannel());
	}

	@Test
	public void testHandleMessageInternal()
			throws OptimaRetailApplicationException {
		Message<?> message = MessageBuilder.withPayload(
				RequestMessageType.NEW_REQUEST).build();
		resourceManager.handleMessageInternal(message);
	}

	@Test(expected = OptimaRetailApplicationException.class)
	public void testHandleMessageInternalException()
			throws OptimaRetailApplicationException {
		Message<?> message = MessageBuilder.withPayload(
				ResourceManagerStatus.COMPLETED).build();
		resourceManager.handleMessageInternal(message);
	}

}
