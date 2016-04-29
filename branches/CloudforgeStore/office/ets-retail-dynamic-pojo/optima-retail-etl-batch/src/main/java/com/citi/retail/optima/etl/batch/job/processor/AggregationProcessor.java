/**
 * 
 */
package com.citi.retail.optima.etl.batch.job.processor;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.InitializingBean;

import com.citi.optima.retail.batch.job.timer.TimeTracker;
import com.citi.retail.optima.etl.aggregation.AggregationService;
import com.citi.retail.optima.etl.aggregation.AggregationServiceFactory;
import com.citi.retail.optima.etl.aggregation.exception.AggregationException;
import com.citi.retail.optima.etl.aggregation.impl.AggregationServiceImpl;
import com.citi.retail.optima.etl.common.ETLConstants;

/**
 * @author mc56120
 * @param <T>
 */
public class AggregationProcessor<T> implements ItemProcessor<T, T>,
		InitializingBean, StepExecutionListener {

	private AggregationService<T> aggregationService;
	private Map<String, Map<String, List<Number>>> aggregationMap;
	private StepExecution stepExecution;

	private AggregationServiceFactory<T> aggregationServiceFactory;
	private Long batchInstanceId;
	private Date monthEndDate;
	private List<String> keyList;
	private String processingUnitIdsString;
	private ExecutionContext currentExecutionContext;
	private String stepName;
	private boolean accountTraceabilityRequired;

	private Long exectionTime = 0L;
	private TimeTracker timeTracker;
	private Integer sysProcId;

	public String getProcessingUnitIdsString() {
		return this.processingUnitIdsString;
	}

	public void setProcessingUnitIdsString(String processingUnitIdsString) {
		this.processingUnitIdsString = processingUnitIdsString;
	}

	private static final Logger LOGGER = LoggerFactory
			.getLogger(AggregationProcessor.class);

	@Override
	public void afterPropertiesSet() throws Exception {
		LOGGER.debug("*****Aggreagtion Item Processor Started*****");
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void init() throws Exception {
		this.aggregationService = this.aggregationServiceFactory
				.getAggregationService(this.keyList, this.batchInstanceId,
						this.monthEndDate, this.stepName,this.sysProcId);
	}

	@Override
	public T process(T item) throws Exception {
		Long startTime = 0L;
		if (ETLConstants.METRICS) {
			startTime = System.currentTimeMillis();
		}
		try {
			((AtomicLong) this.stepExecution.getExecutionContext().get(
					ETLConstants.AGGREGATION_READ_COUNT)).incrementAndGet();
			this.aggregationService.aggregate(item, this.aggregationMap,
					this.accountTraceabilityRequired);
		} catch (AggregationException exception) {
			((AtomicLong) this.stepExecution.getExecutionContext().get(
					ETLConstants.AGGREGATION_SKIPPED_COUNT)).incrementAndGet();
			throw exception;
		}
		((AtomicLong) this.stepExecution.getExecutionContext().get(
				ETLConstants.AGGREGATION_PROCESSED_COUNT)).incrementAndGet();
		if (ETLConstants.METRICS) {
			exectionTime += (System.currentTimeMillis() - startTime);
		}

		return item;
	}

	/**
	 * @param aggregationServiceFactory
	 *            the aggregationServiceFactory to set
	 */
	public void setAggregationServiceFactory(
			AggregationServiceFactory<T> aggregationServiceFactory) {
		this.aggregationServiceFactory = aggregationServiceFactory;
	}

	/**
	 * @param monthEndDate
	 *            the monthEndDate to set
	 */
	public void setMonthEndDate(Date monthEndDate) {
		this.monthEndDate = monthEndDate;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void beforeStep(StepExecution stepExec) {
		this.stepExecution = stepExec;
		
		String serviceKey = ((AggregationServiceImpl<T>) aggregationService).getServiceKey();
		Object valSet =null;
		if (!this.stepExecution.getJobExecution().getExecutionContext().containsKey("serviceKey")){
			valSet = new HashSet<String>();
		}else{
			valSet= (Set<String>)this.stepExecution.getJobExecution().getExecutionContext().get("serviceKey");
		}
		((Set<String>)valSet).add(serviceKey);
		this.stepExecution.getJobExecution().getExecutionContext().put("serviceKey", valSet);
		
		
		if (this.stepExecution == null) {
			LOGGER.error("Step Execution was NULL in Aggregation Processor");
		} else {
			this.currentExecutionContext = this.stepExecution
					.getExecutionContext();
			if (this.currentExecutionContext == null) {
				LOGGER.error("Execution Context was NULL");
			}
			// TODO
			// Inject partionId as a parameter such that we can move the below
			// code to init method.
			// <property name="partitionId"
			// value="#{stepExecutionContext[partitionId]}" />
			Integer partitionId = (Integer) this.currentExecutionContext
					.get(ETLConstants.PARTITION_ID);
			if (this.aggregationMap == null) {
				this.aggregationMap = ((AggregationServiceImpl<T>) this.aggregationService)
						.getLocalAggregationMap(partitionId);
			}
			if (this.currentExecutionContext
					.get(ETLConstants.AGGREGATION_READ_COUNT) == null) {
				this.currentExecutionContext.put(
						ETLConstants.AGGREGATION_READ_COUNT, new AtomicLong(0));
				this.currentExecutionContext.put(
						ETLConstants.AGGREGATION_PROCESSED_COUNT,
						new AtomicLong(0));
				this.currentExecutionContext.put(
						ETLConstants.AGGREGATION_SKIPPED_COUNT, new AtomicLong(
								0));
			} else if (this.currentExecutionContext
					.get(ETLConstants.AGGREGATION_PROCESSED_COUNT) == null) {
				this.currentExecutionContext.put(
						ETLConstants.AGGREGATION_PROCESSED_COUNT,
						new AtomicLong(0));
			} else if (this.currentExecutionContext
					.get(ETLConstants.AGGREGATION_SKIPPED_COUNT) == null) {
				this.currentExecutionContext.put(
						ETLConstants.AGGREGATION_SKIPPED_COUNT, new AtomicLong(
								0));
			}
			if (ETLConstants.METRICS) {
				timeTracker.initTimer(stepExecution, "Aggregation");
			}
		}

	}

	/**
	 * @param batchInstanceId
	 *            the batchInstanceId to set
	 */
	public void setBatchInstanceId(Long batchInstanceId) {
		this.batchInstanceId = batchInstanceId;
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExec) {
		if (ETLConstants.METRICS) {
			timeTracker.updateTimer(stepExecution, "Aggregation", exectionTime);
		}
		return null;
	}

	/**
	 * @param keyList
	 *            the keyList to set
	 */
	public void setKeyList(List<String> keyList) {
		this.keyList = keyList;
	}

	/**
	 * @return the currentExecutionContext
	 */
	public ExecutionContext getCurrentExecutionContext() {
		return this.currentExecutionContext;
	}

	/**
	 * @param currentExecutionContext
	 *            the currentExecutionContext to set
	 */
	public void setCurrentExecutionContext(
			ExecutionContext currentExecutionContext) {
		this.currentExecutionContext = currentExecutionContext;
	}

	/**
	 * @return the stepName
	 */
	public String getStepName() {
		return stepName;
	}

	/**
	 * @param stepName
	 *            the stepName to set
	 */
	public void setStepName(String stepName) {
		this.stepName = stepName;
	}

	/**
	 * @return the accountTraceabilityRequired
	 */
	public boolean isAccountTraceabilityRequired() {
		return accountTraceabilityRequired;
	}

	/**
	 * @param accountTraceabilityRequired
	 *            the accountTraceabilityRequired to set
	 */
	public void setAccountTraceabilityRequired(
			boolean accountTraceabilityRequired) {
		this.accountTraceabilityRequired = accountTraceabilityRequired;
	}

	public TimeTracker getTimeTracker() {
		return timeTracker;
	}

	public void setTimeTracker(TimeTracker timeTracker) {
		this.timeTracker = timeTracker;
	}

	/**
	 * @param sysProcId the sysProcId to set
	 */
	public void setSysProcId(Integer sysProcId) {
		this.sysProcId = sysProcId;
	}

	
	
}
