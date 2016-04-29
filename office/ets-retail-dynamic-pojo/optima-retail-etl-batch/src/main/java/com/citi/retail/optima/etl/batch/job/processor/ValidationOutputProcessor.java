package com.citi.retail.optima.etl.batch.job.processor;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.batch.core.StepExecution;

/**
 * This is an ItemProcess which invokes validation service in order to validate
 * the account output data attributes, using set of predefined validation rules.
 * 
 * @author rs70128
 * 
 * @param <T>
 */
public class ValidationOutputProcessor<T> extends ValidationProcessor<T> {

	@Override
	public void beforeStep(StepExecution stepExec) {
		this.stepExecution = stepExec;
		setCategoryInStepExecutionContext("HISTORY");
		stepExec.getExecutionContext().put("validationReadCnt",
				new AtomicLong(0));
		stepExec.getExecutionContext().put("validationSkippedCnt",
				new AtomicLong(0));
		stepExec.getExecutionContext().put("validationProcessedCnt",
				new AtomicLong(0));
	}

}
