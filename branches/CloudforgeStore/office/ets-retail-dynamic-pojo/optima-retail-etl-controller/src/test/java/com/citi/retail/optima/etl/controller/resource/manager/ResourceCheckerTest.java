/**
 * 
 */
package com.citi.retail.optima.etl.controller.resource.manager;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.controller.model.BatchInstance;

/**
 * @author hs73849
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/retail.optima.etl.controller.test.xml" })
public class ResourceCheckerTest {

	@Autowired
	private ResourceChecker resourceCheckerService;

	@Autowired
	private JobInstanceHolder jobInstanceHolder;

	@Test
	public void testInstanceHolder() {
		Assert.assertEquals(jobInstanceHolder,
				resourceCheckerService.getJobInstanceHolder());
	}

	@Test
	public void testResourceAvailablity()
			throws OptimaRetailApplicationException {
		BatchInstance batchInstance = new BatchInstance();
		batchInstance.setThreadCount(5);
		int availableResourceCount = 10;

		resourceCheckerService
				.setAvailableResourceCount(availableResourceCount);
		Assert.assertEquals(availableResourceCount,
				resourceCheckerService.getAvailableResourceCount());

/*		Assert.assertEquals(
				resourceCheckerService.checkResourceAvailability(batchInstance),
				true);*/
		batchInstance.setThreadCount(15);
		Assert.assertEquals(
				resourceCheckerService.checkResourceAvailability(batchInstance),
				false);
	}

	@Test(expected = OptimaRetailApplicationException.class)
	public void testResourceAvailablityException()
			throws OptimaRetailApplicationException {
		BatchInstance batchInstance = new BatchInstance();
		batchInstance.setThreadCount(5);
		resourceCheckerService.setJobInstanceHolder(null);
		resourceCheckerService.checkResourceAvailability(batchInstance);
	}
}
