package com.citi.retail.optima.etl.common.exception;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobInstance;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.test.MetaDataInstanceFactory;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.common.ETLConstants;
import com.citi.retail.optima.etl.common.OptimaRetailETLLoggingUtil;

/**
 * @author sr67841 This Junit Class is to OptimaRetailETLLoggingUtil
 */
@Ignore
@RunWith(SpringJUnit4ClassRunner.class)

public class OptimaRetailETLLoggingUtilTest {
	
	
	JobExecution jobExecution;
	
	ExecutionContext executionContext;
	
	@Before
	public void setUp()
	{
		JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();

		jobParametersBuilder.addString("REQUEST_ID",
				"ORETL-" + System.currentTimeMillis());
		jobParametersBuilder.addLong(ETLConstants.BATCH_INSTANCE_ID,100L);
		jobParametersBuilder.addString(ETLConstants.PORTFOLIO_ID,
				"CA012");
		jobParametersBuilder.addDate(ETLConstants.EVENT_TIMESTAMP,
				new Date());
		jobParametersBuilder.addString(ETLConstants.PROCESSING_UNIT_ID_LIST,
				"3,9");
		jobParametersBuilder.addLong(ETLConstants.ROW_COUNT, new Long(
				1000L));
		jobParametersBuilder.addLong(ETLConstants.THRESHOLD, new Long(
				100L));
		jobParametersBuilder.addLong(ETLConstants.ORIGINAL_MSG_ID, new Long(
				200L));
		jobParametersBuilder.addString(ETLConstants.PRODUCT_LIST_STR,
				"'CA_OC','CA_AB'");
		
		this.executionContext = MetaDataInstanceFactory
		.createStepExecution(jobParametersBuilder.toJobParameters()).getExecutionContext();

		this.executionContext.put(ETLConstants.BATCH_INSTANCE_ID, 1);
		this.executionContext.put(ETLConstants.PARTITION_ID, "P1");
		this.executionContext.put(ETLConstants.BATCH_INSTANCE_ID, "357");

		this.executionContext.put("validationReadCnt", new AtomicLong(20));
		this.executionContext.put("validationSkippedCnt", new AtomicLong(5));
		this.executionContext.put("validationProcessedCnt", new AtomicLong(10));

		this.executionContext.put(ETLConstants.ENRICHMENT_READ_COUNT,
				new AtomicLong(15));
		this.executionContext.put(ETLConstants.ENRICHMENT_SKIPPED_COUNT,
				new AtomicLong(5));
		this.executionContext.put(ETLConstants.ENRICHMENT_PROCESSED_COUNT,
				new AtomicLong(10));

		this.executionContext.put(ETLConstants.AGGREGATION_READ_COUNT,
				new AtomicLong(10));
		this.executionContext.put(ETLConstants.AGGREGATION_SKIPPED_COUNT,
				new AtomicLong(5));
		this.executionContext.put(ETLConstants.AGGREGATION_PROCESSED_COUNT,
				new AtomicLong(5));
		
		jobExecution = new JobExecution(new JobInstance(100L,jobParametersBuilder.toJobParameters(), "cardsJob"));
	}

	
	@Test
	public void testConvertJoParamToString() throws Exception {
		Assert.assertNull(OptimaRetailETLLoggingUtil.convertJoParamToString(jobExecution));
	}
	
	@Test
	public void testConvetStepExcutionContextToString() throws Exception {
		Assert.assertNull(OptimaRetailETLLoggingUtil.convetStepExcutionContextToString(executionContext));
	}
}
