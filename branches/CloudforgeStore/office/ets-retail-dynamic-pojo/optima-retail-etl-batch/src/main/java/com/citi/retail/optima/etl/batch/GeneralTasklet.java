package com.citi.retail.optima.etl.batch;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

/**
 * Tasklet class used as a placeholder for step configuration. Is not used for
 * real processing steps.
 * 
 * @author ns21567
 * 
 */
public class GeneralTasklet implements Tasklet {

	static final Logger LOGGER = LoggerFactory.getLogger(GeneralTasklet.class);

	private String message;

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public RepeatStatus execute(StepContribution arg0, ChunkContext arg1)
			throws Exception {
		SimpleDateFormat smD = new SimpleDateFormat("hh:mm:ss");
		String df = smD.format(new Date(System.currentTimeMillis()));

		this.LOGGER.info(this.message + df);
		this.LOGGER.debug(this.message + df);

		return RepeatStatus.FINISHED;
	}

}
