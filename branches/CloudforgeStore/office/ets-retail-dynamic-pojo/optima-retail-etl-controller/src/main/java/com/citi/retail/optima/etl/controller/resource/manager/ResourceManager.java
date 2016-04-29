package com.citi.retail.optima.etl.controller.resource.manager;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.MessageHandlingException;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.integration.handler.AbstractMessageHandler;
import org.springframework.integration.support.MessageBuilder;

import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.db.dao.JobConfigDao;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;
import com.citi.retail.optima.etl.controller.model.BatchInstance;
import com.citi.retail.optima.etl.controller.model.RequestMessageType;
import com.citi.retail.optima.etl.controller.model.ResourceManagerStatus;

/**
 * @author hs73849
 * 
 */
public class ResourceManager extends AbstractMessageHandler {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ResourceManager.class);

	private MessageChannel outputChannel;

	private final MessagingTemplate messagingTemplate;

	private JobInstanceLoader jobInstanceLoader;

	private JobInstanceHolder jobInstanceHolder;

	private JobRunningChecker jobRunningCheckerService;

	private JobDependancyChecker jobDependancyCheckerService;

	private ResourceChecker resourceCheckerService;

	private ResourceAllocator resourceAllocatorService;

	private ResourceManagerStatus resourceManagerStatus = ResourceManagerStatus.RESOURCE_AVAILABLE;
	private JobConfigDao jobConfigDao;

	public void setOutputChannel(MessageChannel outputChannel) {
		this.outputChannel = outputChannel;
	}

	public ResourceManager() {
		messagingTemplate = new MessagingTemplate();
	}

	@Override
	protected void handleMessageInternal(Message<?> message)
			throws OptimaRetailApplicationException {
		try {

			RequestMessageType requestType = (RequestMessageType) message
					.getPayload();

			boolean isJobAlreadyRunning;
			boolean isDependancyAvailable;
			boolean isResourceAvailable;
			List<BatchInstance> allocatedJobRequestList = new ArrayList<BatchInstance>();

			if (requestType == RequestMessageType.BATCH_COMPLETION) {
				resourceManagerStatus = ResourceManagerStatus.RESOURCE_AVAILABLE;
			}

			if (resourceManagerStatus == ResourceManagerStatus.RESOURCE_AVAILABLE) {
				jobInstanceLoader.loadJobInstances();
				for (BatchInstance batchInstance : jobInstanceHolder
						.getWaitingJobsList()) {
					
					// As per Andy (02/27/2014) two jobs of same type (eg: two supplementary jobs) can be executed simultaneously.
					// Below code checks if same type of job as incoming request is already running, hence commented out. 

/*					isJobAlreadyRunning = jobRunningCheckerService
							.checkJobRunningStatus(batchInstance);
					if (isJobAlreadyRunning) {
						LOGGER.debug("Job is Already Running for the following Batch Id :"
								+ batchInstance.getBatchId()
								+ " and Portfolio ID "
								+ batchInstance.getPortfolioId());
						continue;
					}*/

					isDependancyAvailable = jobDependancyCheckerService
							.checkJobDependancies(batchInstance,
									batchInstance.getJobId());
					if (!isDependancyAvailable) {
						LOGGER.debug("Dependency not met for the following Batch Id :"
								+ batchInstance.getBatchId()
								+ " Portfolio ID "
								+ batchInstance.getPortfolioId()
								+ " and Job Type Id : "
								+ batchInstance.getJobTypeId());
						continue;
					}

					isResourceAvailable = resourceCheckerService
							.checkResourceAvailability(batchInstance);
					if (!isResourceAvailable) {
						LOGGER.debug("Resources are not available for following Batch Instance Id :"
								+ batchInstance.getBatchInstanceId()
								+ " Portfolio ID "
								+ batchInstance.getPortfolioId()
								+ " and Job Type Id : "
								+ batchInstance.getJobTypeId());
						resourceManagerStatus = ResourceManagerStatus.RESOURCE_NOT_AVAILABLE;
						break;
					}

					resourceAllocatorService.allocateReources(batchInstance);
					allocatedJobRequestList.add(batchInstance);
				}
			}
			
			if (allocatedJobRequestList.size() != 0) {
				messagingTemplate.send(outputChannel, MessageBuilder
						.withPayload(allocatedJobRequestList)
						.copyHeadersIfAbsent(message.getHeaders()).build());
			}
		} catch (Exception e) {
			Long requestLogId=0L;
			if(e instanceof MessageHandlingException){
				requestLogId = ((OptimaRetailApplicationException)e.getCause()).getRequestLogId();
			}
			
			throw new OptimaRetailApplicationException(requestLogId,null,null,ServiceName.CONTROLLER,
					ExceptionType.ERROR, "Error in the resource manager ",
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e),jobConfigDao);
			
		}
	}

	public void setJobInstanceLoader(JobInstanceLoader jobInstanceLoader) {
		this.jobInstanceLoader = jobInstanceLoader;
	}

	public void setJobInstanceHolder(JobInstanceHolder jobInstanceHolder) {
		this.jobInstanceHolder = jobInstanceHolder;
	}

	public void setJobRunningCheckerService(
			JobRunningChecker jobRunningCheckerService) {
		this.jobRunningCheckerService = jobRunningCheckerService;
	}

	public void setJobDependancyCheckerService(
			JobDependancyChecker jobDependencyCheckerService) {
		jobDependancyCheckerService = jobDependencyCheckerService;
	}

	public void setResourceCheckerService(ResourceChecker resourceCheckerService) {
		this.resourceCheckerService = resourceCheckerService;
	}

	public void setResourceAllocatorService(
			ResourceAllocator resourceAllocatorService) {
		this.resourceAllocatorService = resourceAllocatorService;
	}

	public MessageChannel getOutputChannel() {
		return outputChannel;
	}

	public JobInstanceLoader getJobInstanceLoader() {
		return jobInstanceLoader;
	}

	public JobInstanceHolder getJobInstanceHolder() {
		return jobInstanceHolder;
	}

	public JobRunningChecker getJobRunningCheckerService() {
		return jobRunningCheckerService;
	}

	public JobDependancyChecker getJobDependancyCheckerService() {
		return jobDependancyCheckerService;
	}

	public ResourceChecker getResourceCheckerService() {
		return resourceCheckerService;
	}

	public ResourceAllocator getResourceAllocatorService() {
		return resourceAllocatorService;
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
