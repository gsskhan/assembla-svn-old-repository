/**
 * 
 */
package com.citi.retail.optima.etl.controller.resource.manager;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.citi.retail.optima.etl.controller.model.BatchInstance;

/**
 * @author hs73849
 * 
 */
public class JobInstanceHolderTest {

	private JobInstanceHolder jobInstanceHolder;

	@Before
	public void setUp() {
		jobInstanceHolder = new JobInstanceHolder();
	}

	@Test
	public void testWaitingJobList() {
		List<BatchInstance> waitingJobList = new ArrayList<BatchInstance>();
		BatchInstance batchInstance = new BatchInstance();
		batchInstance.setBatchId(1L);
		waitingJobList.add(batchInstance);
		jobInstanceHolder.setWaitingJobsList(waitingJobList);
		Assert.assertEquals(waitingJobList.size(), jobInstanceHolder
				.getWaitingJobsList().size());
	}

	@Test
	public void testRunningJobList() {
		List<String> runningJobList = new ArrayList<String>();
		String runningJob1 = new String("job1");
		String runningJob2 = new String("job2");

		runningJobList.add(runningJob1);
		runningJobList.add(runningJob2);
		jobInstanceHolder.setRunningJobsList(runningJobList);
		Assert.assertEquals(runningJobList.size(), jobInstanceHolder
				.getRunningJobsList().size());

	}

	@Test
	public void testCompletedJobList() {

		List<Long> completedJobList = new ArrayList<Long>();
		Long completedJob1 = new Long(1);
		Long completedJob2 = new Long(2);

		completedJobList.add(completedJob1);
		completedJobList.add(completedJob2);
		jobInstanceHolder.setCompletedJobsList(completedJobList);
		Assert.assertEquals(completedJobList.size(), jobInstanceHolder
				.getCompletedJobsList().size());
	}

	@Test
	public void testAllocatedResourceCount() {
		int allocatedCount = 0;
		jobInstanceHolder.setAllocatedResourceCount(allocatedCount);
		Assert.assertEquals(allocatedCount,
				jobInstanceHolder.getAllocatedResourceCount());
	}

}
