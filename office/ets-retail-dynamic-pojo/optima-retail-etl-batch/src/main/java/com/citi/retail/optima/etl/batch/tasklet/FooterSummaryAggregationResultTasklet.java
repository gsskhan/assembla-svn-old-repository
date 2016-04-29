/**
 * 
 */
package com.citi.retail.optima.etl.batch.tasklet;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.util.Assert;

import com.citi.retail.optima.etl.aggregation.AggregationService;
import com.citi.retail.optima.etl.aggregation.model.AggregationType;
import com.citi.retail.optima.etl.common.ETLConstants;
import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.db.dao.JobConfigDao;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.OptimaRetailDataException;
import com.citi.retail.optima.etl.common.exception.OptimaRetailDataExceptionDetail;
import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;
import com.citi.retail.optima.etl.common.model.RainbowFileFooter;

/**
 * @author TJ
 * @param <T>
 * 
 */
public class FooterSummaryAggregationResultTasklet extends
		AggregationResultTasklet<T> {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(FooterSummaryAggregationResultTasklet.class);

	private Integer sysProcId;

	private Integer footerAggrRuleId;

	private List<RainbowFileFooter> footerItemList;

	private FlatFileItemWriter<RainbowFileFooter> aggrFooterWriter;

	private String FOOTER_AGGR_KEY = "1";

	private JobConfigDao jobConfigDao;

	
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

	@SuppressWarnings("unchecked")
	@Override
	public RepeatStatus execute(StepContribution stepContribution,
			ChunkContext chunkContext) throws Exception {
		try {

			long startTime = Calendar.getInstance().getTimeInMillis();
			LOGGER.debug(" Write footer summary started --------------------------- "
					+ startTime);
			AggregationService<T> aggrService = null;
			ExecutionContext jobExecutionContext = chunkContext
					.getStepContext().getStepExecution().getJobExecution()
					.getExecutionContext();
			Set<String> aggregationServiceKeys = (Set<String>) jobExecutionContext
					.get("serviceKey");

			if (aggregationServiceKeys != null
					&& aggregationServiceKeys.size() > 0) {
				for (String serviceKey : aggregationServiceKeys) {
					aggrService = this.aggregationServiceFactory
							.getAggregationServiceFromPool(serviceKey);
					aggrService.mergeAggregationResults();

				}
			}
			Map<String, Map<String, List<Number>>> aggregationResults = aggrService
					.getAggregationResults();
			Assert.notEmpty(aggregationResults,
					"Footer Aggregation Results are empty");
			List<AggregationType> aggregationTypeList = aggrService
					.getAggregationTypeList();

			Assert.notEmpty(aggregationTypeList,
					"Footer Aggregation Keys are empty");

			Map<String, Long> footerHashValuesMap = null;

			if (aggregationTypeList.size() == 1
					&& aggregationResults.size() == 1) {
				AggregationType aggregationType = aggregationTypeList.get(0);
				Map<String, List<Number>> puAggrResults = aggregationResults
						.get(sysProcId + ":" + footerAggrRuleId);
				List<Number> aggrMetricsValues = puAggrResults
						.get(FOOTER_AGGR_KEY);

				String[] metricsKeys = aggregationType
						.getColumnsToAggregateValueSpelExpr().toArray(
								new String[] {});
			//	footerHashValuesMap = new ConcurrentHashMap<String, Long>();
				for (int idx = 0; idx < metricsKeys.length; idx++) {
				//	footerHashValuesMap.put(metricsKeys[idx], aggrMetricsValues
				//			.get(idx).longValue());
					jobExecutionContext.putLong(metricsKeys[idx], aggrMetricsValues
							.get(idx).longValue());
				}

			} else {
				LOGGER.error("Illegal Aggregation Configuration for footer");
				throw new IllegalStateException(
						"Illegal Footer Aggregation Rule Configuration");

			}
			/*	Long writeRecordCount = jobExecutionContext
					.getLong("writeRecordCount");

			if (writeRecordCount != null) {
				jobExecutionContext.remove("writeRecordCount");
			}

			if (footerItemList != null && !footerItemList.isEmpty()
					&& !footerHashValuesMap.isEmpty()) {
				int idx = 0;
				for (RainbowFileFooter footerItem : footerItemList) {
					footerItem.setWriteCount(writeRecordCount);
					footerItem.setAggregatedHashValue(footerHashValuesMap
							.get(footerItem.getHashField()));
					Resource r = new UrlResource(
							footerItem.getOutputFileResourceName()+ETLConstants.DAT);
					if (r.exists()) {
						aggrFooterWriter.setResource(new UrlResource(footerItem
								.getOutputFileResourceName()+ETLConstants.DAT));
						aggrFooterWriter.open(chunkContext.getStepContext()
								.getStepExecution().getExecutionContext());
						aggrFooterWriter.write(footerItemList.subList(idx,
								idx + 1));
						aggrFooterWriter.close();
						
						aggrFooterWriter.setResource(new UrlResource(footerItem
								.getOutputFileResourceName()+ETLConstants.ACK));
						aggrFooterWriter.open(chunkContext.getStepContext()
								.getStepExecution().getExecutionContext());
						aggrFooterWriter.close();
					}
					idx++;
				}
			}
*/
			long endTime = Calendar.getInstance().getTimeInMillis();
			LOGGER.debug("Insertion of  aggregated footer took ---  "
					+ (endTime - startTime) / 1000d + " Seconds");
		} catch (Exception e) {
			List<OptimaRetailDataExceptionDetail> optimaRetailSkippableList = new ArrayList<OptimaRetailDataExceptionDetail>();
			OptimaRetailDataExceptionDetail optimaRetailSkippable = new OptimaRetailDataExceptionDetail();
			optimaRetailSkippable
					.setUserErrorMessage("Error writing footer aggregation results");
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
					"Error writing footer record in aggregations",
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e),
					optimaRetailException,jobConfigDao);
		} finally {
			this.aggregationServiceFactory.clearAggregationServiceFromMap(
					this.batchInstanceId, this.stepName);
		}

		return RepeatStatus.FINISHED;
	}

	public Integer getSysProcId() {
		return sysProcId;
	}

	public void setSysProcId(Integer sysProcId) {
		this.sysProcId = sysProcId;
	}

	public List<RainbowFileFooter> getFooterItemList() {
		return footerItemList;
	}

	public void setFooterItemList(List<RainbowFileFooter> footerItemList) {
		this.footerItemList = footerItemList;
	}

	public FlatFileItemWriter<RainbowFileFooter> getAggrFooterWriter() {
		return aggrFooterWriter;
	}

	public void setAggrFooterWriter(
			FlatFileItemWriter<RainbowFileFooter> aggrFooterWriter) {
		this.aggrFooterWriter = aggrFooterWriter;
	}

	public Integer getFooterAggrRuleId() {
		return footerAggrRuleId;
	}

	public void setFooterAggrRuleId(Integer footerAggrRuleId) {
		this.footerAggrRuleId = footerAggrRuleId;
	}

}
