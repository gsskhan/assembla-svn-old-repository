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

/**
 * @author hs73849
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/retail.optima.etl.controller.test.xml" })
public class JobDependancyCheckerExceptionTest {

	@Autowired
	private JobDependancyChecker jobDependancyCheckerService;

	@Autowired
	private JobDependancyDaoImpl jobDependancyDao;

	@Test
	public void testDependencyDao() {
		Assert.assertEquals(jobDependancyDao,
				jobDependancyCheckerService.getJobDependancyDao());
	}

	@Test(expected = OptimaRetailApplicationException.class)
	public void testJobDependencyDaoException()
			throws OptimaRetailApplicationException {
		jobDependancyDao.setJdbcTemplate(null);
		jobDependancyCheckerService.setJobDependancyDao(jobDependancyDao);
		Assert.assertEquals(
				jobDependancyDao.isJobTypeDependencyAvailable(null, null), true);
	}

}
