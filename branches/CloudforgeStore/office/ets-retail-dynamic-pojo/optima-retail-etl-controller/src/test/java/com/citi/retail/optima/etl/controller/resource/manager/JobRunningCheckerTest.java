package com.citi.retail.optima.etl.controller.resource.manager;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.controller.model.BatchInstance;

/**
 * @author hs73849
 * 
 */
public class JobRunningCheckerTest {

	private JobRunningChecker jobRunningChecker;
	private JobInstanceHolder jobInstanceHolder;

	@Before
	public void setUp() {
		jobInstanceHolder = new JobInstanceHolder();
		jobRunningChecker = new JobRunningChecker();

		List<String> runningJobList = new ArrayList<String>();
		String runningJob1 = new String("1_1_PORT_ID");
		String runningJob2 = new String("1_PORT_ID");
		String runningJob5 = new String("1_1_");
		String runningJob3 = new String("1__");
		String runningJob4 = new String("1__PORT_ID");

		runningJobList.add(runningJob1);
		runningJobList.add(runningJob2);
		runningJobList.add(runningJob3);
		runningJobList.add(runningJob4);
		runningJobList.add(runningJob5);
		jobInstanceHolder.setRunningJobsList(runningJobList);
		jobRunningChecker.setJobInstanceHolder(jobInstanceHolder);
	}

	@Test
	public void testCheckJobRunningStatus()
			throws OptimaRetailApplicationException {
		BatchInstance batchInstance = new BatchInstance();
		batchInstance.setJobTypeId(1L);
		batchInstance.setBatchId(1L);
		batchInstance.setPortfolioId("PORT_ID");
		Assert.assertTrue(jobRunningChecker
				.checkJobRunningStatus(batchInstance));
		batchInstance.setPortfolioId(null);
		Assert.assertTrue(jobRunningChecker
				.checkJobRunningStatus(batchInstance));
		batchInstance.setBatchId(null);
		Assert.assertTrue(jobRunningChecker
				.checkJobRunningStatus(batchInstance));
		batchInstance.setPortfolioId("PORT_ID");
		Assert.assertTrue(jobRunningChecker
				.checkJobRunningStatus(batchInstance));
		batchInstance.setBatchId(null);
		Assert.assertTrue(jobRunningChecker
				.checkJobRunningStatus(batchInstance));
		batchInstance.setBatchId(2L);
		Assert.assertFalse(jobRunningChecker
				.checkJobRunningStatus(batchInstance));
	}
}
