package com.citi.retail.optima.etl.batch.decider;

import java.util.Date;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;
import org.springframework.beans.factory.InitializingBean;

import com.citi.retail.optima.etl.common.ETLConstants;

public class RainbowproccrDecider implements JobExecutionDecider,InitializingBean{

	FlowExecutionStatus flowExe = new FlowExecutionStatus(null);
	private Date startDate;
	private Date endDate;
	
	@Override
	public FlowExecutionStatus decide(JobExecution jobExecution,
			StepExecution stepExecution) {
		Date reprtingDate = jobExecution.getJobInstance().getJobParameters().getDate(ETLConstants.REPORT_DATE);

		if (reprtingDate != null) {							
			if(reprtingDate.after(startDate) && reprtingDate.before(endDate)){
				flowExe = new FlowExecutionStatus("preRainbow");
			}else if (reprtingDate.after(endDate)) {
				flowExe = new FlowExecutionStatus("postRainbow");
			}
		}  	    	
		return flowExe;
	}
	
	
	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	@Override
	public void afterPropertiesSet() throws Exception {
		
	}
	
	
}
