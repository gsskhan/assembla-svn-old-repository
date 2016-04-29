/**
 * 
 */
package com.citi.retail.optima.etl.controller.dao.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;

/**
 * @author gv74035 This class to test all the DAO classes related to resource
 *         manager use case
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/retail.optima.etl.controller.dao.test.xml" })
public class JobInstanceLoaderDaoTest {

	@Autowired
	private JobInstanceLoaderDaoImpl jobInstanceLoaderDao;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	public void testJdbcTemplate() {
		Assert.assertEquals(jdbcTemplate,
				jobInstanceLoaderDao.getJdbcTemplate());
	}

	@Test
	public void testJobInstanceLoaderDao() throws Exception {
		Assert.assertEquals(jobInstanceLoaderDao.getAllJobs().size() >= 0, true);
	}

	@Test(expected = OptimaRetailApplicationException.class)
	public void testJobInstanceLoaderDaoException()
			throws OptimaRetailApplicationException {
		jobInstanceLoaderDao.setJdbcTemplate(null);
		Assert.assertEquals(jobInstanceLoaderDao.getAllJobs().size() >= 0, 0);
	}

}
