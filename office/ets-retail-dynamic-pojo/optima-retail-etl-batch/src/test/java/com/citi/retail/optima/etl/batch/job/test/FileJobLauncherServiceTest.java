package com.citi.retail.optima.etl.batch.job.test;

import java.math.BigInteger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.integration.Message;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.batch.dao.BatchJobDetailsDao;
import com.citi.retail.optima.etl.batch.dao.BatchJobInstanceDao;
import com.citi.retail.optima.etl.batch.dao.BatchMessageDao;
import com.citi.retail.optima.etl.batch.job.BatchJobLauncher;
import com.citi.retail.optima.etl.batch.job.FileJobLauncherService;
import com.citi.retail.optima.etl.common.model.FileInformation;
import com.citi.retail.optima.xsd.internal.OptimaRetailETLEvent;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/retail.optima.etl.batch.test.xml" })
public class FileJobLauncherServiceTest implements ApplicationContextAware {

	@Autowired
	FileJobLauncherService jobLauncherService;

	@Autowired
	BatchJobLauncher batchjobLauncher;

	ApplicationContext applicationContext;

	@Autowired
	BatchMessageDao messageDao;

	@Autowired
	BatchJobDetailsDao batchDetailsDao;

	@Autowired
	BatchJobInstanceDao jobInstanceDao;

	@Autowired
	JobLauncher jobLauncher;

	@Test
	public void testGetBatchDetails() {

		this.jobLauncherService.setApplicationContext(this.applicationContext);
		this.jobLauncherService.setBatchDaoImpl(this.messageDao);
		this.jobLauncherService.setJobDetailsDao(this.batchDetailsDao);
		this.jobLauncherService.setJobInstanceDao(this.jobInstanceDao);
		this.jobLauncherService.setBatchjobLauncher(this.batchjobLauncher);
		testHandleMessage();
	}

	private void testHandleMessage() {

		OptimaRetailETLEvent etlEvent = new OptimaRetailETLEvent();

		etlEvent.setBatchInstanceId(new BigInteger("2234"));
		etlEvent.setOriginalMsgId(new BigInteger("4940"));
		etlEvent.setPriority(new BigInteger("2"));
		etlEvent.setReportPeriod("2012-12-31");
		
		FileInformation fileInformation = new FileInformation();
		
		fileInformation.setFileId(new Long(12));
		fileInformation.setFileType("CSV");

		Message<Object[]> message = MessageBuilder.withPayload(
				new Object[]{etlEvent,fileInformation}).build();
		try {
			this.jobLauncherService.handleMessage(message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;

	}
}
