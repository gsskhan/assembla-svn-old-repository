package org.dms.batch.listners;

import org.apache.log4j.Logger;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;


public class CommonStepExecutionListner implements StepExecutionListener{
	
	private Logger log = Logger.getLogger(this.getClass());

	@Override
	public ExitStatus afterStep(StepExecution se) {
		ExitStatus status = se.getExitStatus();
		log.info("finished step [" + se.getStepName() + "] with ExitCode ["+ status.getExitCode()+ "]");
		return status;
	}

	@Override
	public void beforeStep(StepExecution se) {
		log.info("starting step [" + se.getStepName()+"] with job execution id [" 
				+ se.getJobExecutionId() +"] and id [" + se.getId()+ "]" );
	}

}
