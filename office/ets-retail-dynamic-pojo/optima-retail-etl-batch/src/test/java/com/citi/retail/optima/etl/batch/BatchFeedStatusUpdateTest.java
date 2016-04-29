package com.citi.retail.optima.etl.batch;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.optima.retail.batch.listeners.DataAcqJobListener;
import com.citi.retail.optima.etl.batch.dao.impl.BatchJobInstanceDaoImpl;
import com.citi.retail.optima.etl.common.ETLBatchStatus;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/retail.optima.etl.batch.test.xml" })
public class BatchFeedStatusUpdateTest {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(BatchFeedStatusUpdateTest.class);

	@Autowired
	private BatchJobInstanceDaoImpl jobInstanceDao;

	@Autowired
	private DataAcqJobListener ccarJobListener;

	@Test
	public void testUpdateFeedAndStatus() {

		Assert.assertNotNull(this.jobInstanceDao);

		this.jobInstanceDao.updateBatchStatus(5019, ETLBatchStatus.BTH_STRT);
		this.jobInstanceDao.updateBatchStatus(5019, ETLBatchStatus.BTH_COMP);
		Assert.assertTrue(this.jobInstanceDao.updateBatchStatus(5019, ETLBatchStatus.BTH_STRT));
	}

}
