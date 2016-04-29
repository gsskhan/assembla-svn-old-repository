/**
 * 
 */
package com.citi.retail.optima.etl.batch.job;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersIncrementer;

/**
 * @author sm59053
 *
 */
public class JobParamIncrementer implements JobParametersIncrementer {
	private static int counter=1;
	/* (non-Javadoc)
	 * @see org.springframework.batch.core.JobParametersIncrementer#getNext(org.springframework.batch.core.JobParameters)
	 */
	 public JobParameters getNext(JobParameters parameters) {
        if (parameters==null || parameters.isEmpty()) {
            return new JobParametersBuilder().addLong("run.id", 1L).toJobParameters();
        }
        long id = parameters.getLong("run.id",1L) + counter++;
        return new JobParametersBuilder().addLong("run.id", id).toJobParameters();
	 }

}
