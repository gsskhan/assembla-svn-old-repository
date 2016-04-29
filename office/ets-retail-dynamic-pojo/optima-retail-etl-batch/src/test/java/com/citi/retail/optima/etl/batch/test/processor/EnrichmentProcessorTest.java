package com.citi.retail.optima.etl.batch.test.processor;

import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobInstance;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.optima.retail.batch.job.timer.TimeTracker;
import com.citi.retail.optima.etl.batch.job.processor.EnrichmentProcessor;
import com.citi.retail.optima.etl.common.ETLConstants;
import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.OptimaRetailBaseException;
import com.citi.retail.optima.etl.common.model.SupplementaryDataRecord;
import com.citi.retail.optima.etl.enrichment.impl.EnrichmentServiceImpl;

/**
 * 
 * @author ms04453
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/batch.enrichment.config.test.xml" })
public class EnrichmentProcessorTest {
	@Autowired
	EnrichmentProcessor<SupplementaryDataRecord> enrichmentProcessor;

	@Autowired
	EnrichmentServiceImpl<SupplementaryDataRecord> enrichmentService;

	StepExecution stepExecution;

	SupplementaryDataRecord modelObj;

	@Before
	public void setUp() {
		JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
		jobParametersBuilder.addLong(ETLConstants.BATCH_INSTANCE_ID, 1648l);
		jobParametersBuilder.addLong(ETLConstants.BATCH_ID, 9l);
		
		JobParameters jbs = jobParametersBuilder.toJobParameters();		
		JobExecution jobExecution = new JobExecution(new JobInstance(
				System.currentTimeMillis(), jbs, "Internal"));	
		ExecutionContext jobContext = new ExecutionContext();
		Map<String,AtomicLong> map = new HashMap<String,AtomicLong>();
		map.put("Enrichment", new AtomicLong(121212) );
		jobContext.put(ETLConstants.TIMER, map);		
		jobExecution.setExecutionContext(jobContext);
		jobExecution.getExecutionContext().putString(ETLConstants.FILE_READER, "csvReader");
		stepExecution = new StepExecution("Enrichment:partition1", jobExecution);
		ExecutionContext executionContext = new ExecutionContext();	
		executionContext.put(ETLConstants.ENRICHMENT_READ_COUNT, new AtomicLong(0));
		executionContext.put("partitionId", "P1");
		executionContext.put(
				ETLConstants.ENRICHMENT_SKIPPED_COUNT,
				new AtomicLong(0));
		stepExecution.setExecutionContext(executionContext);
		
		modelObj = new SupplementaryDataRecord();

		enrichmentProcessor.setEnrichmentServiceBean(enrichmentService);
		TimeTracker timeTracker = new TimeTracker();
		timeTracker.initTimer(stepExecution, "");
		enrichmentProcessor.setTimeTracker(timeTracker);

	}

	@Test
	public void beforeStepWithoutPresetCountTest() {
		
		enrichmentProcessor.beforeStep(stepExecution);
		Assert.assertNotNull(enrichmentProcessor.getEnrichmentServiceBean());
		Assert.assertEquals(0,
				((AtomicLong) enrichmentProcessor.getCurrentExecutionContext()
						.get(ETLConstants.ENRICHMENT_READ_COUNT)).intValue());
	}

	@Test
	public void beforeStepWithPresetCountTest() {	
		ExecutionContext executionContext = new ExecutionContext();	
		executionContext.put(ETLConstants.ENRICHMENT_READ_COUNT, new AtomicLong(1));
		stepExecution.setExecutionContext(executionContext);
		enrichmentProcessor.beforeStep(stepExecution);
		Assert.assertEquals(1,
				((AtomicLong) enrichmentProcessor.getCurrentExecutionContext()
						.get(ETLConstants.ENRICHMENT_READ_COUNT)).intValue());
	}

	@Test
	public void processTest() throws Exception {		
		enrichmentProcessor.beforeStep(stepExecution);
		when(enrichmentService.enrich(modelObj)).thenReturn(modelObj);
		Assert.assertNotNull(enrichmentProcessor.process(modelObj));
		enrichmentProcessor.beforeStep(stepExecution);
		enrichmentProcessor.afterStep(stepExecution);
	}

	@Test(expected = OptimaRetailBaseException.class)
	public void processErrorTest() throws Exception {		
		enrichmentProcessor.beforeStep(stepExecution);
		when(enrichmentService.enrich(modelObj)).thenThrow(
				new OptimaRetailApplicationException(null, null, null,
						ServiceName.ENRICHMENT, ExceptionType.FATAL, null,
						null, null));
		Assert.assertNotNull(enrichmentProcessor.process(modelObj));

	}

	@Test
	public void processCountTest() throws Exception {
		enrichmentProcessor.beforeStep(stepExecution);		
		when(enrichmentService.enrich(modelObj)).thenReturn(modelObj);
		enrichmentProcessor.process(modelObj);
		enrichmentProcessor.process(modelObj);
		enrichmentProcessor.process(modelObj);
		Assert.assertEquals(3,
				((AtomicLong) enrichmentProcessor.getCurrentExecutionContext()
						.get(ETLConstants.ENRICHMENT_PROCESSED_COUNT))
						.intValue());
		enrichmentProcessor.beforeStep(stepExecution);
		enrichmentProcessor.afterStep(stepExecution);
	}

	@Test
	public void skipCountTest() throws Exception {		
		enrichmentProcessor.beforeStep(stepExecution);
		when(enrichmentService.enrich(modelObj)).thenReturn(modelObj);
		enrichmentProcessor.process(modelObj);
		enrichmentProcessor.process(modelObj);
		when(enrichmentService.enrich(modelObj)).thenThrow(
				new OptimaRetailApplicationException(ServiceName.ENRICHMENT,
						ExceptionType.ERROR, "skipCountTest()", null, null,
						null));
		try {
			enrichmentProcessor.beforeStep(stepExecution);
			enrichmentProcessor.process(modelObj);
		} catch (OptimaRetailBaseException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(1,
				((AtomicLong) enrichmentProcessor.getCurrentExecutionContext()
						.get(ETLConstants.ENRICHMENT_SKIPPED_COUNT)).intValue());
		enrichmentProcessor.afterStep(stepExecution);
	}

	public EnrichmentProcessor<SupplementaryDataRecord> getEnrichmentProcessor() {
		return enrichmentProcessor;
	}

	public void setEnrichmentProcessor(
			EnrichmentProcessor<SupplementaryDataRecord> enrichmentProcessor) {
		this.enrichmentProcessor = enrichmentProcessor;
	}

	public StepExecution getStepExecution() {
		return stepExecution;
	}

	public void setStepExecution(StepExecution stepExecution) {
		this.stepExecution = stepExecution;
	}

}
