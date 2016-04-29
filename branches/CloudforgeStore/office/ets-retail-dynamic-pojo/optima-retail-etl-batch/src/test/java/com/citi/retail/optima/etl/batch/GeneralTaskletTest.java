/**
 * 
 */
package com.citi.retail.optima.etl.batch;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.scope.context.StepContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.batch.test.MetaDataInstanceFactory;

/**
 * @author mc56120
 * 
 */
@RunWith(MockitoJUnitRunner.class)
public class GeneralTaskletTest {

	private GeneralTasklet generalTasklet;

	private StepExecution stepExecution = MetaDataInstanceFactory
			.createStepExecution();
	private StepContext stepContext = new StepContext(stepExecution);
	private ChunkContext chunkContext = new ChunkContext(stepContext);
	private StepContribution stepContribution = new StepContribution(
			stepExecution);

	@Before
	public void setUp() throws Exception {
		generalTasklet = new GeneralTasklet();
		generalTasklet.setMessage("Test");
	}

	@Test
	public void testExecute() throws Exception {
		Assert.assertEquals(RepeatStatus.FINISHED,
				generalTasklet.execute(stepContribution, chunkContext));
	}
}
