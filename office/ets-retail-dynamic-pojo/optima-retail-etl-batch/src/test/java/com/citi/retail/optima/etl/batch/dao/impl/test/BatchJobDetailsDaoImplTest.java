package com.citi.retail.optima.etl.batch.dao.impl.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.batch.dao.BatchJobDetailsDao;
import com.citi.retail.optima.etl.batch.vo.BatchDetailsVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/retail.optima.etl.batch.test.xml" })
public class BatchJobDetailsDaoImplTest {

	@Autowired
	BatchJobDetailsDao jobDetailsDao;

	@Test
	public void testFetchJobDetails() throws Exception {
		BatchDetailsVO detailsVO = this.jobDetailsDao.getBatchdetails(5019);
		Assert.assertNotNull(detailsVO);
		Assert.assertNull(this.jobDetailsDao.getBatchdetails(66666));
	}

	@Test
	public void getBatchIdTest() throws Exception {
		Assert.assertNotNull(this.jobDetailsDao.getBatchId(5019));
	}

}
