package com.citi.retail.optima.etl.batch.job.processor;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

import com.citi.optima.retail.batch.job.timer.TimeTracker;
import com.citi.retail.optima.etl.common.ETLConstants;
import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.OptimaRetailBaseException;
import com.citi.retail.optima.etl.validation.ValidationService;
import com.citi.retail.optima.etl.validation.exception.ValidationException;

/**
 * This is an ItemProcess which invokes validation service in order to validate
 * the account data attributes, using set of predefined validation rules.
 * 
 * @author MK67854
 * 
 * @param <T>
 */
public class ValidationProcessor<T> implements ItemProcessor<T, T>,
		StepExecutionListener, InitializingBean {

	protected ValidationService<T> validationServiceBean;
	protected StepExecution stepExecution;
	private static final String VLD_CAT = "vld_cat";
	private ExecutionContext currentExecutionContext;
	private static final String VALID_COUNT = "validationSkippedCnt";
	private static final String VALID_PROS = "validationProcessedCnt";

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ValidationProcessor.class);

	private Long exectionTime = 0L;
	private TimeTracker timeTracker;

	@Override
	public void afterPropertiesSet() throws Exception {
		if (this.validationServiceBean == null) {
			LOGGER.error("Validation Service was not initialised. Job Would Terminate Now.");
			throw new OptimaRetailApplicationException(
					null,
					null,
					null,
					ServiceName.VALIDATION,
					ExceptionType.FATAL,
					"Validation Service was not initialised. Job Would Terminate Now",
					null, null,null);
		}

		LOGGER.debug("*****Validation Item Processor Started*****");

	}

	protected void setCategoryInStepExecutionContext(String category) {
		this.stepExecution.getExecutionContext().put(VLD_CAT, category);
	}

	@Override
	public T process(T item) throws Exception {
		Long startTime = 0L;
		if (ETLConstants.METRICS) {
			startTime = System.currentTimeMillis();
		}
		try {
			Assert.notNull(this.stepExecution, "StepExecution cannot be null");
			((AtomicLong) this.stepExecution.getExecutionContext().get(
					"validationReadCnt")).incrementAndGet();

			this.validationServiceBean.validate(item);
		} catch (ValidationException ore) {
			((AtomicLong) this.stepExecution.getExecutionContext().get(
					VALID_COUNT)).incrementAndGet();
			throw ore;
		}
		((AtomicLong) this.stepExecution.getExecutionContext().get(VALID_PROS))
				.incrementAndGet();
		if (ETLConstants.METRICS) {
			exectionTime += (System.currentTimeMillis() - startTime);
		}

		return item;
	}

	public ValidationService<T> getValidationServiceBean() {
		return this.validationServiceBean;
	}

	public void setValidationServiceBean(
			ValidationService<T> validationServiceBean) {
		this.validationServiceBean = validationServiceBean;
	}

	@Override
	public void beforeStep(StepExecution stepExec) {
		this.stepExecution = stepExec;

		if (this.stepExecution == null) {
			LOGGER.error("Step Execution was NULL in Validation Processor");
		} else {
			this.currentExecutionContext = this.stepExecution
					.getExecutionContext();
			if (this.currentExecutionContext == null) {
				LOGGER.error("Execution Context was NULL");
			}
			if (this.currentExecutionContext.get("validationReadCnt") == null) {

				this.currentExecutionContext.put("validationReadCnt",
						new AtomicLong(0));
				this.currentExecutionContext.put(VALID_PROS, new AtomicLong(0));
				this.currentExecutionContext
						.put(VALID_COUNT, new AtomicLong(0));
			} else if (this.currentExecutionContext.get(VALID_PROS) == null) {
				this.currentExecutionContext.put(VALID_PROS, new AtomicLong(0));
			} else if (this.currentExecutionContext.get(VALID_COUNT) == null) {
				this.currentExecutionContext
						.put(VALID_COUNT, new AtomicLong(0));
			}
			if (ETLConstants.METRICS) {
				timeTracker.initTimer(stepExec, "Validation");
			}
		}

	}

	/**
	 * @return the currentExecutionContext
	 */
	public ExecutionContext getCurrentExecutionContext() {
		return this.currentExecutionContext;
	}

	/**
	 * @param currentExecutionContext
	 *            the currentExecutionContext to set
	 */
	public void setCurrentExecutionContext(
			ExecutionContext currentExecutionContext) {
		this.currentExecutionContext = currentExecutionContext;
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExec) {
		if (ETLConstants.METRICS) {
			timeTracker.updateTimer(stepExec, "Validation", exectionTime);
		}
		return null;
	}

	public TimeTracker getTimeTracker() {
		return timeTracker;
	}

	public void setTimeTracker(TimeTracker timeTracker) {
		this.timeTracker = timeTracker;
	}
}
