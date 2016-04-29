package com.citi.retail.optima.batch.core.job.flow;

import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.StepHandler;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.core.job.flow.FlowExecutionException;
import org.springframework.batch.core.job.flow.FlowExecutor;
import org.springframework.batch.core.job.flow.JobFlowExecutor;
import org.springframework.batch.core.step.AbstractStep;
import org.springframework.util.Assert;

import com.citi.retail.optima.batch.core.job.OptimaRetailFlowStepHandler;
import com.citi.retail.optima.etl.common.ETLConstants;

/**
 * A {@link Step} implementation that delegates to a {@link Flow}. Useful for
 * logical grouping of different event steps, and especially for partitioning
 * with multiple
 * steps per execution. If the flow has steps then when the
 * {@link OptimaRetailFlowStep} executes, all steps including the parent
 * {@link OptimaRetailFlowStep} will have
 * executions in the {@link JobRepository} (one for the parent and one each for
 * the flow steps).
 * 
 * @author MS04453
 * 
 */
@SuppressWarnings("restriction")
public class OptimaRetailFlowStep extends AbstractStep {

	private Flow flow;

	/**
	 * Default constructor convenient for configuration purposes.
	 */
	public OptimaRetailFlowStep() {
		super(null);
	}

	/**
	 * Constructor for a {@link OptimaRetailFlowStep} that sets the flow and of
	 * the step
	 * explicitly.
	 */
	public OptimaRetailFlowStep(Flow flow) {
		super(flow.getName());
		this.flow = flow;
	}

	/**
	 * Public setter for the flow.
	 * 
	 * @param flow
	 *            the flow to set
	 */
	public void setFlow(Flow flow) {
		this.flow = flow;
	}

	/**
	 * Ensure that the flow is set.
	 * 
	 * @see AbstractStep#afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		super.afterPropertiesSet();
		Assert.state(this.flow != null, "A Flow must be provided");
	}

	/**
	 * Delegate to the flow provided for the execution of the step.
	 * Gets the step name from parent step of the flow ( including the partition
	 * key) and sets it in the current step execution context.
	 * The values from this execution context are passed on to the individual
	 * steps that constitutes the flow.
	 * 
	 * @see AbstractStep#doExecute(StepExecution)
	 */
	@Override
	protected void doExecute(StepExecution stepExecution) throws Exception {
		try {
			stepExecution.getExecutionContext().put(
					ETLConstants.PARENT_STEP_NAME, stepExecution.getStepName());
			StepHandler stepHandler = new OptimaRetailFlowStepHandler(
					getJobRepository(), stepExecution.getExecutionContext());
			FlowExecutor executor = new JobFlowExecutor(getJobRepository(),
					stepHandler, stepExecution.getJobExecution());
			executor.updateJobExecutionStatus(this.flow.start(executor)
					.getStatus());
			stepExecution.upgradeStatus(executor.getJobExecution().getStatus());
			stepExecution.setExitStatus(executor.getJobExecution()
					.getExitStatus());
		} catch (FlowExecutionException e) {
			if (e.getCause() instanceof JobExecutionException) {
				throw (JobExecutionException) e.getCause();
			}
			throw new JobExecutionException(
					"Flow execution ended unexpectedly", e);
		}
	}

}
