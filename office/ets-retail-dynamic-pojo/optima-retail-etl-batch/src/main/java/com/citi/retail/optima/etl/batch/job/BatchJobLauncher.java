package com.citi.retail.optima.etl.batch.job;

import java.math.BigInteger;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;

import com.citi.retail.optima.etl.batch.dao.BatchJobInstanceDao;
import com.citi.retail.optima.etl.batch.messaging.InternalMessageCreator;
import com.citi.retail.optima.etl.common.ETLBatchStatus;
import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.db.dao.JobConfigDao;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.OptimaRetailBaseException;
import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;

/**
 * This class is used to launch the jobs for the requests received from the
 * controller module.
 * 
 * @author ns21567
 * 
 */
public class BatchJobLauncher {

	private JobLauncher jobLauncher;
	private BatchJobInstanceDao jobInstanceDao;
	private InternalMessageCreator internalMessageCreator;
	private static final String JOB_LAUNCH_ERR = "Error in Batch Job Launcher ";
	private JobConfigDao jobConfigDao;
	public void launchJob(BigInteger batchInstId, Job job,
			JobParameters jobParameters) throws OptimaRetailBaseException {

		try {
			jobLauncher.run(job, jobParameters);
		} catch (JobExecutionAlreadyRunningException e1) {
			internalMessageCreator
					.createAndOutgoingCompletionMessage(batchInstId.intValue());
			jobInstanceDao.updateBatchStatus(batchInstId.intValue(),
					ETLBatchStatus.BTH_FAIL);
			throw new OptimaRetailApplicationException(null, null,
					batchInstId.longValue(), ServiceName.BATCH,
					ExceptionType.FATAL, JOB_LAUNCH_ERR
							+ batchInstId, e1.getMessage(),
					OptimaRetailExceptionUtil.getStackTrace(e1),jobConfigDao);

		} catch (JobRestartException e2) {
			internalMessageCreator
					.createAndOutgoingCompletionMessage(batchInstId.intValue());
			jobInstanceDao.updateBatchStatus(batchInstId.intValue(),
					ETLBatchStatus.BTH_FAIL);
			throw new OptimaRetailApplicationException(null, null,
					batchInstId.longValue(), ServiceName.BATCH,
					ExceptionType.FATAL, JOB_LAUNCH_ERR
							+ batchInstId, e2.getMessage(),
					OptimaRetailExceptionUtil.getStackTrace(e2),jobConfigDao);
		} catch (JobInstanceAlreadyCompleteException e3) {
			internalMessageCreator
					.createAndOutgoingCompletionMessage(batchInstId.intValue());
			jobInstanceDao.updateBatchStatus(batchInstId.intValue(),
					ETLBatchStatus.BTH_FAIL);
			throw new OptimaRetailApplicationException(null, null,
					batchInstId.longValue(), ServiceName.BATCH,
					ExceptionType.FATAL, JOB_LAUNCH_ERR
							+ batchInstId, e3.getMessage(),
					OptimaRetailExceptionUtil.getStackTrace(e3),jobConfigDao);
		} catch (JobParametersInvalidException e4) {
			internalMessageCreator
					.createAndOutgoingCompletionMessage(batchInstId.intValue());
			jobInstanceDao.updateBatchStatus(batchInstId.intValue(),
					ETLBatchStatus.BTH_FAIL);
			throw new OptimaRetailApplicationException(null, null,
					batchInstId.longValue(), ServiceName.BATCH,
					ExceptionType.FATAL, JOB_LAUNCH_ERR
							+ batchInstId, e4.getMessage(),
					OptimaRetailExceptionUtil.getStackTrace(e4),jobConfigDao);
		}
	}

	public JobLauncher getJobLauncher() {
		return jobLauncher;
	}

	public void setJobLauncher(JobLauncher jobLauncher) {
		this.jobLauncher = jobLauncher;
	}

	public BatchJobInstanceDao getJobInstanceDao() {
		return jobInstanceDao;
	}

	public void setJobInstanceDao(BatchJobInstanceDao jobInstanceDao) {
		this.jobInstanceDao = jobInstanceDao;
	}

	public InternalMessageCreator getInternalMessageCreator() {
		return internalMessageCreator;
	}

	public void setInternalMessageCreator(
			InternalMessageCreator internalMessageCreator) {
		this.internalMessageCreator = internalMessageCreator;
	}

	/**
	 * @return the jobConfigDao
	 */
	public JobConfigDao getJobConfigDao() {
		return jobConfigDao;
	}

	/**
	 * @param jobConfigDao the jobConfigDao to set
	 */
	public void setJobConfigDao(JobConfigDao jobConfigDao) {
		this.jobConfigDao = jobConfigDao;
	}

}
