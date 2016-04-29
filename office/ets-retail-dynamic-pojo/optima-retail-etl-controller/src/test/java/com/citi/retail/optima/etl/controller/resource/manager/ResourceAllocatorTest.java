/**
 * 
 */
package com.citi.retail.optima.etl.controller.resource.manager;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.controller.dao.JobInstanceDao;
import com.citi.retail.optima.etl.controller.model.BatchInstance;

/**
 * @author hs73849
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/retail.optima.etl.controller.test.xml" })
public class ResourceAllocatorTest {

	@Autowired
	private ResourceAllocator resourceAllocatorService;

	@Autowired
	private JobInstanceHolder jobInstanceHolder;

	@Autowired
	private JobInstanceDao jobInstanceDao;

	@Test
	public void testDependencyDao() throws Exception {
		Assert.assertEquals(jobInstanceDao,
				resourceAllocatorService.getJobInstanceDao());
		Assert.assertEquals(jobInstanceHolder,
				resourceAllocatorService.getJobInstanceHolder());

		BatchInstance batchInstance = new BatchInstance();
		batchInstance.setJobTypeId(1L);
		batchInstance.setBatchId(1L);
		batchInstance.setPortfolioId("PORT_ID");
		batchInstance.setThreadCount(8);
		resourceAllocatorService.allocateReources(batchInstance);
		resourceAllocatorService.getJobInstanceHolder()
				.getAllocatedResourceCount();
		resourceAllocatorService.getJobInstanceHolder()
				.getRunningJobsList().size();
	}

	@Test(expected = Exception.class)
	public void testAllocateResources() throws Exception {
		resourceAllocatorService.allocateReources(null);
	}
}
