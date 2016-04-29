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
import com.citi.retail.optima.etl.controller.dao.impl.JobInstanceLoaderDaoImpl;

/**
 * @author hs73849
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/retail.optima.etl.controller.test.xml" })
public class JobInstanceLoaderTest {

	@Autowired
	private JobInstanceLoader jobInstanceLoader;

	@Autowired
	private JobInstanceHolder jobInstanceHolder;

	@Autowired
	private JobInstanceLoaderDaoImpl jobInstanceLoaderDao;

	@Test
	public void testInstanceLoaderDao() {
		Assert.assertEquals(jobInstanceLoaderDao,
				jobInstanceLoader.getJobInstanceLoaderDao());
	}

	@Test
	public void testInstanceHolder() {
		Assert.assertEquals(jobInstanceHolder,
				jobInstanceLoader.getJobInstanceHolder());
	}

	@Test
	public void testLoadJobInstances() throws OptimaRetailApplicationException {
		testInstanceLoaderDao();
		Assert.assertNotNull(jobInstanceLoader.loadJobInstances()
				.getWaitingJobsList());
		Assert.assertEquals(jobInstanceLoader.loadJobInstances()
				.getWaitingJobsList().size() >= 0, true);
	}

	/*
	 * @Test(expected = NullPointerException.class) public void
	 * testLoadJobInstancesException() throws NullPointerException {
	 * jobInstanceLoader.setJobInstanceLoaderDao(null); try {
	 * Assert.assertEquals(jobInstanceLoader.loadJobInstances()
	 * .getCompletedJobsList().size() > 0, true); } catch
	 * (OptimaControllerException e) { throw new NullPointerException(); } }
	 */
}
