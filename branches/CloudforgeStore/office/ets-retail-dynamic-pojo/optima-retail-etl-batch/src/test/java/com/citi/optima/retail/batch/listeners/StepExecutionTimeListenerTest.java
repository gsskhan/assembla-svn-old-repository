package com.citi.optima.retail.batch.listeners;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.test.MetaDataInstanceFactory;

import com.citi.optima.retail.batch.job.timer.TimeTracker;
import com.citi.retail.optima.etl.common.ETLConstants;

@RunWith(MockitoJUnitRunner.class)
@Ignore
public class StepExecutionTimeListenerTest {

	Long startTime;
	
	@Mock
	StepExecution stepExecution;
	
	@InjectMocks
	TimeTracker timeTracker;
	
	StepExecutionTimeListener stepExecutionTimeListener = new StepExecutionTimeListener();
	
	@Before
	public void setUp() {
		this.stepExecution = MetaDataInstanceFactory.createStepExecution();
		this.stepExecution.getJobExecution().getExecutionContext().put(ETLConstants.TIMER,
				new LinkedHashMap<String, AtomicLong>());
	}
	
	@Test
	public void testBeforeJobException() {
		Assert.assertNotNull(this.stepExecutionTimeListener);
		this.stepExecutionTimeListener.beforeStep(stepExecution);
	}
	
	@Test
	public void testAfterJob() {
		Assert.assertNotNull(this.stepExecutionTimeListener);
		this.stepExecutionTimeListener.afterStep(stepExecution);
	}
	
	@Test
	public void updateTimerTest() throws Exception {
		timeTracker.initTimer(stepExecution, "test");
		timeTracker.updateTimer(stepExecution, "test", 100L);
		this.stepExecutionTimeListener.setTimeTracker(timeTracker);
		Assert.assertNotNull(this.stepExecutionTimeListener.getTimeTracker());
	}
}
