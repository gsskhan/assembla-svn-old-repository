package com.citi.optima.retail.batch.listeners;

import static org.mockito.Mockito.when;

import javax.xml.bind.Marshaller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobInstance;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.core.MessagingTemplate;

import com.citi.retail.optima.etl.batch.dao.BatchJobInstanceDao;
import com.citi.retail.optima.etl.common.ETLBatchStatus;
import com.citi.retail.optima.etl.common.ETLConstants;

@RunWith(MockitoJUnitRunner.class)
public class DataAcqJobListenerTest {
	
	DataAcqJobListener dataAcqJobListener = new DataAcqJobListener();
	
	@Mock
	private BatchJobInstanceDao batchJobInstanceDao;

	@Mock
	private MessagingTemplate messagingTemplate;

	@Mock
	private MessageChannel messageChannel;

	@Mock
	private MessageChannel internalMessageChannel;

	@Mock
	private Marshaller jaxbMarshaller;
	
	JobExecution jobExecution;
	
	
	@Before
	public void testBeforeJob() {
		
		this.dataAcqJobListener.setBatchJobInstanceDao(this.batchJobInstanceDao);
		this.dataAcqJobListener.setInternalMessageChannel(this.internalMessageChannel);
		JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
		jobParametersBuilder.addLong(ETLConstants.BATCH_INSTANCE_ID, 1648l);
		jobParametersBuilder.addLong(ETLConstants.BATCH_ID, 9l);
		JobParameters jbs = jobParametersBuilder.toJobParameters();
		jobExecution = new JobExecution(new JobInstance(
				System.currentTimeMillis(), jbs, "Internal"));
		when(
				this.batchJobInstanceDao.updateBatchStatus(1648,
						ETLBatchStatus.JOB_COMP)).thenReturn(true);
		this.dataAcqJobListener.beforeJob(jobExecution);
	}
	
	@Test
	public void testBeforeJobException() {
		Assert.assertNotNull(this.batchJobInstanceDao);
		this.dataAcqJobListener.beforeJob(null);
	}
	
	@Test
	public void testAfterJob() {
		this.dataAcqJobListener.afterJob(jobExecution);
	}
	
}
