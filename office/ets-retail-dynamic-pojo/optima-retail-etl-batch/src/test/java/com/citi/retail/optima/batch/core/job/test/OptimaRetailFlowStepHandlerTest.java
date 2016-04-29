/*
 * Copyright 2006-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.citi.retail.optima.batch.core.job.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobInterruptedException;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.SimpleStepHandler;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;

import com.citi.retail.optima.batch.core.job.OptimaRetailFlowStepHandler;
import com.citi.retail.optima.batch.core.step.StepSupport;
import com.citi.retail.optima.etl.common.ETLConstants;

/**
 * @author MS04453
 * 
 */
public class OptimaRetailFlowStepHandlerTest {

	private JobRepository jobRepository;

	private JobExecution jobExecution;

	private OptimaRetailFlowStepHandler stepHandler;

	@Before
	public void setUp() throws Exception {
		MapJobRepositoryFactoryBean jobRepositoryFactoryBean = new MapJobRepositoryFactoryBean();
		this.jobRepository = jobRepositoryFactoryBean.getJobRepository();
		this.jobExecution = this.jobRepository.createJobExecution("job",
				new JobParameters());
		StepExecution stepExecution = this.jobExecution
				.createStepExecution("step:partition1");
		this.jobRepository.add(stepExecution);
		this.stepHandler = new OptimaRetailFlowStepHandler(this.jobRepository,
				stepExecution.getExecutionContext());
		this.stepHandler.afterPropertiesSet();
	}

	/**
	 * Test method for {@link SimpleStepHandler#afterPropertiesSet()}.
	 */
	@Test(expected = IllegalStateException.class)
	public void testAfterPropertiesSet() throws Exception {
		OptimaRetailFlowStepHandler stepHandler = new OptimaRetailFlowStepHandler();
		stepHandler.afterPropertiesSet();
	}

	/**
	 * Test method for
	 * {@link SimpleStepHandler#handleStep(org.springframework.batch.core.Step, org.springframework.batch.core.JobExecution)}
	 * .
	 */
	@Test
	public void testHandleStep() throws Exception {
		StepExecution flowStepExecution = getStepExecution(this.jobExecution,
				"step:partition1");
		flowStepExecution.getExecutionContext().putString(
				ETLConstants.PARENT_STEP_NAME, "step:partition1");
		StepExecution stepExecution = this.stepHandler.handleStep(new StubStep(
				"step:partition1"), this.jobExecution);
		assertEquals(BatchStatus.COMPLETED, stepExecution.getStatus());
	}

	private class StubStep extends StepSupport {

		private StubStep(String name) {
			super(name);
		}

		@Override
		public void execute(StepExecution stepExecution)
				throws JobInterruptedException {
			stepExecution.setStatus(BatchStatus.COMPLETED);
			stepExecution.setExitStatus(ExitStatus.COMPLETED);
			OptimaRetailFlowStepHandlerTest.this.jobRepository
					.update(stepExecution);
		}

	}

	/**
	 * @param jobExecution
	 * @param stepName
	 * @return the StepExecution corresponding to the specified step
	 */
	private StepExecution getStepExecution(JobExecution jobExecution,
			String stepName) {
		for (StepExecution stepExecution : jobExecution.getStepExecutions()) {
			if (stepExecution.getStepName().equals(stepName)) {
				return stepExecution;
			}
		}
		fail("No stepExecution found with name: [" + stepName + "]");
		return null;
	}

}
