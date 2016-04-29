/**
 * 
 */
package com.citi.retail.optima.etl.batch.tasklet;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import com.citi.retail.optima.etl.aggregation.AggregationService;
import com.citi.retail.optima.etl.aggregation.AggregationServiceFactory;
import com.citi.retail.optima.etl.aggregation.impl.AggregationServiceImpl;
import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.db.dao.JobConfigDao;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.OptimaRetailDataException;
import com.citi.retail.optima.etl.common.exception.OptimaRetailDataExceptionDetail;
import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;

/**
 * @author mc56120
 * @param <T>
 * 
 */
public class AggregationResultTasklet<T> implements Tasklet {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(AggregationResultTasklet.class);
	protected AggregationServiceFactory<T> aggregationServiceFactory;
	protected Long batchInstanceId;
	private Date monthEndDate;
	private List<String> keyList = new ArrayList<String>();
	private String processingUnitIdsString;
	protected String stepName;
	private JobConfigDao jobConfigDao;

	/**
	 * @return the processingUnitIdsString
	 */
	public String getProcessingUnitIdsString() {
		return this.processingUnitIdsString;
	}

	/**
	 * @param processingUnitIdsString
	 *            the processingUnitIdsString to set
	 */
	public void setProcessingUnitIdsString(String processingUnitIdsString) {
		this.processingUnitIdsString = processingUnitIdsString;
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

	/**
	 * @param batchInstanceId
	 *            the batchInstanceId to set
	 */
	public void setBatchInstanceId(Long batchInstanceId) {
		this.batchInstanceId = batchInstanceId;
	}

	/**
	 * @param keyList
	 *            the keyList to set
	 */
	public void setKeyList(List<String> keyList) {
		this.keyList = keyList;
	}


	@SuppressWarnings("unchecked")
	@Override
	public RepeatStatus execute(StepContribution stepContribution,
			ChunkContext chunkContext) throws Exception {
		try {

			long startTime = Calendar.getInstance().getTimeInMillis();
			LOGGER.debug(" Save Aggregation results started --------------------------- "
					+ startTime);
			AggregationService<T> aggrService =null;
			Set<String> aggregationServiceKeys = (Set)chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext().get("serviceKey");
			
			if(aggregationServiceKeys!=null && aggregationServiceKeys.size() >0 ){
				for(String serviceKey : aggregationServiceKeys){
					aggrService = this.aggregationServiceFactory.getAggregationServiceFromPool(serviceKey);
					((AggregationServiceImpl<T>) aggrService).saveAggregationResults();
				}
			}
			
			long endTime = Calendar.getInstance().getTimeInMillis();
			LOGGER.debug("Insertion of  aggregation records to database took ---  "
					+ (endTime - startTime) / 1000d + " Seconds");
		} catch (Exception e) {
			List<OptimaRetailDataExceptionDetail> optimaRetailSkippableList = new ArrayList<OptimaRetailDataExceptionDetail>();
			OptimaRetailDataExceptionDetail optimaRetailSkippable = new OptimaRetailDataExceptionDetail();
			optimaRetailSkippable
					.setUserErrorMessage("Error while saving aggregation results");
			optimaRetailSkippable
					.setExceptionMessage(e.getMessage() == null ? e.getClass()
							.getName() : e.getMessage());
			optimaRetailSkippable.setRule("");
			optimaRetailSkippable.setAttributeName("");
			optimaRetailSkippable.setExceptionType(ExceptionType.FATAL);
			optimaRetailSkippable.setStackTrace(OptimaRetailExceptionUtil
					.getStackTrace(e));
			optimaRetailSkippableList.add(optimaRetailSkippable);
			OptimaRetailDataException optimaRetailException = new OptimaRetailDataException(
					ServiceName.AGGREGATION, ExceptionType.FATAL,
					optimaRetailSkippableList);

			throw new OptimaRetailApplicationException(null, null,
					batchInstanceId, ServiceName.AGGREGATION,
					ExceptionType.ERROR,
					"Error when persisting records in aggregations",
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e),
					optimaRetailException,jobConfigDao);
		} finally {
			this.aggregationServiceFactory.clearAggregationServiceFromMap(
					this.batchInstanceId, this.stepName);
		}

		return RepeatStatus.FINISHED;
	}

	/**
	 * @return the stepName
	 */
	public String getStepName() {
		return this.stepName;
	}

	/**
	 * @param stepName
	 *            the stepName to set
	 */
	public void setStepName(String stepName) {
		this.stepName = stepName;
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
