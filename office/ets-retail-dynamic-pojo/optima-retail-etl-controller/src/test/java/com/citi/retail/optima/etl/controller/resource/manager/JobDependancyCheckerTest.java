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
import com.citi.retail.optima.etl.controller.dao.impl.JobDependancyDaoImpl;
import com.citi.retail.optima.etl.controller.model.BatchInstance;

/**
 * @author hs73849
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/retail.optima.etl.controller.test.xml" })
public class JobDependancyCheckerTest {

	@Autowired
	private JobDependancyChecker jobDependancyCheckerService;

	@Autowired
	private JobDependancyDaoImpl jobDependancyDao;

	@Test
	public void testDependencyDao() {
		Assert.assertEquals(jobDependancyDao,
				jobDependancyCheckerService.getJobDependancyDao());
	}

	@Test
	public void testJobDependencyDao() throws Exception {
		Assert.assertEquals(
				jobDependancyDao.isJobTypeDependencyAvailable(1L, 1l), true);
	}

	@Test
	public void testGetDependency() throws OptimaRetailApplicationException {
		BatchInstance batchInstance = new BatchInstance();
		batchInstance.setJobId(1l);
		Assert.assertEquals(true, jobDependancyCheckerService
				.checkJobDependancies(batchInstance, 1l));
	}
}
