package org.dms.batch.main;

import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SyncDbDataTablesApp {
	
	private static Logger log = Logger.getLogger(SyncDbDataTablesApp.class);
	
	private static AbstractApplicationContext ctx = null;

	public static void main(String[] args) {
		log.info("starting to sync both mysql and mongo db datatables contents ...");
		
		try {			
			ctx = new ClassPathXmlApplicationContext("spring/applicationContext-batch-config.xml"
													,"spring/job/sync-db-job-config.xml");
			
			JobLauncher jobLauncher = ctx.getBean(JobLauncher.class);
			Job job = (Job) ctx.getBean("syncDbJob");
			JobParameters jobParameters = new JobParametersBuilder()
													.addLong("executionStartTime", System.currentTimeMillis())
													.toJobParameters();
			log.info("###################################################");
			JobExecution jobExecution = jobLauncher.run(job, jobParameters);
			log.info("Final batch status - "+ jobExecution.getStatus());
			log.info("###################################################");
			ctx.destroy();
			log.info("sync completed successfully ...");		
		} catch (Exception e) {
			log.error("Error in sync db datatables program.", e);
		}	
	}

}
