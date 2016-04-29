package com.citi.retail.optima.batch.core.job.flow.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobInterruptedException;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.support.SimpleFlow;
import org.springframework.batch.core.job.flow.support.StateTransition;
import org.springframework.batch.core.job.flow.support.state.EndState;
import org.springframework.batch.core.job.flow.support.state.StepState;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;

import com.citi.retail.optima.batch.core.job.flow.OptimaRetailFlowStep;
import com.citi.retail.optima.batch.core.step.StepSupport;

/**
 * 
 */
public class OptimaRetailFlowStepTest {

	private JobRepository jobRepository;
	private JobExecution jobExecution;

	@Before
	public void setUp() throws Exception {
		this.jobRepository = new MapJobRepositoryFactoryBean()
				.getJobRepository();
		this.jobExecution = this.jobRepository.createJobExecution("job",
				new JobParameters());
	}

	/**
	 * Test method for
	 * {@link org.springframework.batch.core.job.flow.OptimaRetailFlowStep#afterPropertiesSet()}
	 * .
	 */
	@Test(expected = IllegalStateException.class)
	public void testAfterPropertiesSet() throws Exception {
		OptimaRetailFlowStep step = new OptimaRetailFlowStep();
		step.setJobRepository(this.jobRepository);
		step.afterPropertiesSet();
	}

	/**
	 * Test method for
	 * {@link org.springframework.batch.core.job.flow.OptimaRetailFlowStep#doExecute(org.springframework.batch.core.StepExecution)}
	 * .
	 */
	@Test
	public void testDoExecute() throws Exception {

		OptimaRetailFlowStep step = new OptimaRetailFlowStep();
		step.setJobRepository(this.jobRepository);

		SimpleFlow flow = new SimpleFlow("job");
		List<StateTransition> transitions = new ArrayList<StateTransition>();
		transitions.add(StateTransition.createStateTransition(new StepState(
				new StubStep("step1")), "step2"));
		StepState step2 = new StepState(new StubStep("step2"));
		transitions.add(StateTransition.createStateTransition(step2,
				ExitStatus.FAILED.getExitCode(), "end0"));
		transitions.add(StateTransition.createStateTransition(step2,
				ExitStatus.COMPLETED.getExitCode(), "end1"));
		transitions.add(StateTransition.createEndStateTransition(new EndState(
				FlowExecutionStatus.FAILED, "end0")));
		transitions.add(StateTransition.createEndStateTransition(new EndState(
				FlowExecutionStatus.COMPLETED, "end1")));
		flow.setStateTransitions(transitions);

		step.setFlow(flow);
		step.afterPropertiesSet();

		StepExecution stepExecution = this.jobExecution
				.createStepExecution("step:partition1");
		this.jobRepository.add(stepExecution);
		step.execute(stepExecution);

		stepExecution = getStepExecution(this.jobExecution, "step:partition1");
		assertEquals(ExitStatus.COMPLETED, stepExecution.getExitStatus());
		stepExecution = getStepExecution(this.jobExecution, "step2:partition1");
		assertEquals(ExitStatus.COMPLETED, stepExecution.getExitStatus());
		assertEquals(3, this.jobExecution.getStepExecutions().size());

	}
	
	
	@Test
	public void testDoExecutewithFlow() throws Exception {

		SimpleFlow flow = new SimpleFlow("job");
		List<StateTransition> transitions = new ArrayList<StateTransition>();
		transitions.add(StateTransition.createStateTransition(new StepState(
				new StubStep("step1")), "step2"));
		StepState step2 = new StepState(new StubStep("step2"));
		transitions.add(StateTransition.createStateTransition(step2,
				ExitStatus.FAILED.getExitCode(), "end0"));
		transitions.add(StateTransition.createStateTransition(step2,
				ExitStatus.COMPLETED.getExitCode(), "end1"));
		transitions.add(StateTransition.createEndStateTransition(new EndState(
				FlowExecutionStatus.FAILED, "end0")));
		transitions.add(StateTransition.createEndStateTransition(new EndState(
				FlowExecutionStatus.COMPLETED, "end1")));
		flow.setStateTransitions(transitions);

		OptimaRetailFlowStep step = new OptimaRetailFlowStep(flow);
		step.setJobRepository(this.jobRepository);
		step.afterPropertiesSet();

		StepExecution stepExecution = this.jobExecution
				.createStepExecution("step:partition1");
		this.jobRepository.add(stepExecution);
		step.execute(stepExecution);

		stepExecution = getStepExecution(this.jobExecution, "step:partition1");
		assertEquals(ExitStatus.COMPLETED, stepExecution.getExitStatus());
		stepExecution = getStepExecution(this.jobExecution, "step2:partition1");
		assertEquals(ExitStatus.COMPLETED, stepExecution.getExitStatus());
		assertEquals(3, this.jobExecution.getStepExecutions().size());
	}
	

	@Test
	public void testDoExecuteAndFail() throws Exception {

		OptimaRetailFlowStep step = new OptimaRetailFlowStep();
		step.setJobRepository(this.jobRepository);

		SimpleFlow flow = new SimpleFlow("job");
		List<StateTransition> transitions = new ArrayList<StateTransition>();
		transitions.add(StateTransition.createStateTransition(new StepState(
				new StubStep("step1")), "step2"));
		StepState step2 = new StepState(new StubStep("step2", true));
		transitions.add(StateTransition.createStateTransition(step2,
				ExitStatus.FAILED.getExitCode(), "end0"));
		transitions.add(StateTransition.createStateTransition(step2,
				ExitStatus.COMPLETED.getExitCode(), "end1"));
		transitions.add(StateTransition.createEndStateTransition(new EndState(
				FlowExecutionStatus.FAILED, "end0")));
		transitions.add(StateTransition.createEndStateTransition(new EndState(
				FlowExecutionStatus.COMPLETED, "end1")));
		flow.setStateTransitions(transitions);

		step.setFlow(flow);
		step.afterPropertiesSet();

		StepExecution stepExecution = this.jobExecution
				.createStepExecution("step:partition1");
		this.jobRepository.add(stepExecution);
		step.execute(stepExecution);

		stepExecution = getStepExecution(this.jobExecution, "step1:partition1");
		assertEquals(ExitStatus.COMPLETED, stepExecution.getExitStatus());
		stepExecution = getStepExecution(this.jobExecution, "step2:partition1");
		assertEquals(ExitStatus.FAILED, stepExecution.getExitStatus());
		stepExecution = getStepExecution(this.jobExecution, "step:partition1");
		assertEquals(ExitStatus.FAILED, stepExecution.getExitStatus());
		assertEquals(3, this.jobExecution.getStepExecutions().size());

	}

	/**
	 * Test method for
	 * {@link org.springframework.batch.core.job.flow.OptimaRetailFlowStep#doExecute(org.springframework.batch.core.StepExecution)}
	 * .
	 */
	@Test
	public void testExecuteWithParentContext() throws Exception {

		OptimaRetailFlowStep step = new OptimaRetailFlowStep();
		step.setJobRepository(this.jobRepository);

		SimpleFlow flow = new SimpleFlow("job");
		List<StateTransition> transitions = new ArrayList<StateTransition>();
		transitions.add(StateTransition.createStateTransition(new StepState(
				new StubStep("step1")), "end0"));
		transitions.add(StateTransition.createEndStateTransition(new EndState(
				FlowExecutionStatus.COMPLETED, "end0")));
		flow.setStateTransitions(transitions);

		step.setFlow(flow);
		step.afterPropertiesSet();

		StepExecution stepExecution = this.jobExecution
				.createStepExecution("step:partition1");
		stepExecution.getExecutionContext().put("parentStep",
				"value set in parent Context");
		this.jobRepository.add(stepExecution);
		step.execute(stepExecution);

		stepExecution = getStepExecution(this.jobExecution, "step:partition1");
		assertEquals(ExitStatus.COMPLETED, stepExecution.getExitStatus());
		stepExecution = getStepExecution(this.jobExecution, "step1:partition1");
		assertEquals(ExitStatus.COMPLETED, stepExecution.getExitStatus());
		assertEquals("value set in parent Context", stepExecution
				.getExecutionContext().get("parentStep"));

	}

	/**
	 * 
	 * @author ms04453
	 * 
	 */
	private class StubStep extends StepSupport {

		private boolean fail;
		private boolean exception;

		private StubStep(String name) {
			this(name, false);
		}

		private StubStep(String name, boolean fail) {
			super(name);
			this.fail = fail;
		}
		
		private StubStep(String name, boolean fail, boolean exception) {
			super(name);
			this.fail = fail;
			this.exception = exception;
		}

		@Override
		public void execute(StepExecution stepExecution)
				throws JobInterruptedException {
			BatchStatus status = BatchStatus.COMPLETED;
			ExitStatus exitStatus = ExitStatus.COMPLETED;
			if (this.fail) {
				status = BatchStatus.FAILED;
				exitStatus = ExitStatus.FAILED;
			}
			if(exception == false){
				stepExecution.setStatus(status);
				stepExecution.setExitStatus(exitStatus);
			}
			OptimaRetailFlowStepTest.this.jobRepository.update(stepExecution);
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
