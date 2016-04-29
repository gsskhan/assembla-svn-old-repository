package com.citi.retail.optima.etl.batch.job.timer.test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.test.MetaDataInstanceFactory;
import org.springframework.util.Assert;

import com.citi.optima.retail.batch.job.timer.TimeTracker;
import com.citi.retail.optima.etl.common.ETLConstants;

/**
 * @author sr67841
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class TimeTrackerTest {

	@InjectMocks
	TimeTracker timeTracker;
	
	private StepExecution stepExecution;

	
	@Before
	public void setUp() {
		this.stepExecution = MetaDataInstanceFactory.createStepExecution();
		this.stepExecution.getJobExecution().getExecutionContext().put(ETLConstants.TIMER,
				new LinkedHashMap<String, AtomicLong>());
	}
	
	@Test
	public void initTimerTest() throws Exception {
		timeTracker.initTimer(stepExecution, "test");
		Assert.notNull(((Map<String,AtomicLong>)stepExecution.getJobExecution().getExecutionContext().get(ETLConstants.TIMER)).get(stepExecution.getStepName()+"-test"));
	}
	
	@Test
	public void updateTimerTest() throws Exception {
		timeTracker.initTimer(stepExecution, "test");
		timeTracker.updateTimer(stepExecution, "test", 100L);
		Assert.notNull(((Map<String,AtomicLong>)stepExecution.getJobExecution().getExecutionContext().get(ETLConstants.TIMER)).get(stepExecution.getStepName()+"-test"));
	}
}
