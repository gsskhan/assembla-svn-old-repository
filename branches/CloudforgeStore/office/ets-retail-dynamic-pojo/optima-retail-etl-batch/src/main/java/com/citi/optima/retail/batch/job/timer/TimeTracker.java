package com.citi.optima.retail.batch.job.timer;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.batch.core.StepExecution;

import com.citi.retail.optima.etl.common.ETLConstants;

/**
 * It is the class that is used to initialize and update the execution time of the step/module in the job execution context  
 * 
 * @author sr67841
 *
 */
public class TimeTracker {

	public void initTimer(StepExecution stepExecution, String moduleName){
		
		String paritionStepName = stepExecution.getStepName();
		String stepName = paritionStepName;
		if(paritionStepName.indexOf(':') > -1){
			stepName = paritionStepName.substring(0,paritionStepName.indexOf(':'));
		}
		if(!moduleName.isEmpty()){
			stepName +="-"+moduleName;
		}
		Map<String,AtomicLong> timerMap = (Map<String,AtomicLong>)stepExecution.getJobExecution().getExecutionContext().get(ETLConstants.TIMER);
		if(timerMap.get(stepName) == null)
		{
			timerMap.put(stepName, new AtomicLong(0) );
		}
	}
	
	public void updateTimer(StepExecution stepExecution, String moduleName,Long exectionTime){
		
		String paritionStepName = stepExecution.getStepName();
		String stepName = paritionStepName;
		if(paritionStepName.indexOf(':') > -1){
			stepName = paritionStepName.substring(0,paritionStepName.indexOf(':'));
		}
		if(!moduleName.isEmpty()){
			stepName +="-"+moduleName;
		}
		Map<String,AtomicLong> timerMap = (Map<String,AtomicLong>)stepExecution.getJobExecution().getExecutionContext().get(ETLConstants.TIMER);
		((AtomicLong)timerMap.get(stepName)).addAndGet(exectionTime);
	}
}
