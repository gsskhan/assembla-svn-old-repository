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

/**
 * @author gv74035 This class to test all the DAO classes related to resource
 *         manager use case
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/retail.optima.etl.controller.dao.test.xml" })
public class JobDependancyDaoTest {

	@Autowired
	private JobDependancyDaoImpl jobDependancyDao;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	public void testJdbcTemplate() {
		Assert.assertEquals(jdbcTemplate, jobDependancyDao.getJdbcTemplate());
	}

	@Test
	public void testJobDependencyDao() throws Exception {
		Assert.assertEquals(
				jobDependancyDao.isJobTypeDependencyAvailable(1L, 1l), true);
	}
}
