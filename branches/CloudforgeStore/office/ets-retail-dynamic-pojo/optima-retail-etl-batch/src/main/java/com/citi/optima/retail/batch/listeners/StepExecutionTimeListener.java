package com.citi.optima.retail.batch.listeners;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.annotation.BeforeStep;

import com.citi.optima.retail.batch.job.timer.TimeTracker;
import com.citi.retail.optima.etl.common.ETLConstants;

/**
 * This is the listener class that is used to track the execution time of a step.
 * 
 * @author sr67841
 *
 */
public class StepExecutionTimeListener {

	private TimeTracker timeTracker;
	Long startTime;

	@BeforeStep
	public void beforeStep(StepExecution stepExecution) {
		if (ETLConstants.METRICS) {
			timeTracker.initTimer(stepExecution, "");
			startTime = System.currentTimeMillis();
		}
	}

	@AfterStep
	public void afterStep(StepExecution stepExecution) {
		if (ETLConstants.METRICS) {
			timeTracker.updateTimer(stepExecution, "",
					System.currentTimeMillis() - startTime);
		}
	}

	public TimeTracker getTimeTracker() {
		return timeTracker;
	}

	public void setTimeTracker(TimeTracker timeTracker) {
		this.timeTracker = timeTracker;
	}
}
