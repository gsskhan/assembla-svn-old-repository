package com.citi.retail.optima.etl.batch.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DbToFileExtractor {

	public static void main(String[] args) {

		if(args.length != 2 ){
			System.err.println("Invalid input parameters !!!. Expected values 1) country product value " +
					"2) Reporting period");
			System.exit(1);
		}
		DbToFileExtractor obj = new DbToFileExtractor();
	 	obj.run(args);

	}

	private void run(String[] args) {

		String[] springConfig = { "retail.optima.batch.db.dat.extractor.xml" };

		ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);

		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		Job job = (Job) context.getBean("DATA-EXTRACTOR-Batch");

		try {

			JobParameters param = new JobParametersBuilder().addString("cntryProd", args[0])
					.addString("rptPrd", args[1]).toJobParameters();

			JobExecution execution = jobLauncher.run(job, param);
			System.out.println("Exit Status : " + execution.getStatus());
			System.out.println("Exit Status : " + execution.getAllFailureExceptions());

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		}

		System.out.println("Done");
		//System.exit(0);

	}

}
