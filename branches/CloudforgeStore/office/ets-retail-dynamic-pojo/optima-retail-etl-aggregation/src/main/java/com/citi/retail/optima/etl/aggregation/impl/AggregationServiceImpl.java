/**
 * 
 */
package com.citi.retail.optima.etl.aggregation.impl;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.LoggerFactory;
import org.springframework.expression.EvaluationException;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.util.StringUtils;

import ch.qos.logback.classic.Logger;

import com.citi.retail.optima.etl.aggregation.AggregationService;
import com.citi.retail.optima.etl.aggregation.dao.AggregationDao;
import com.citi.retail.optima.etl.aggregation.dao.AggregationRuleSql;
import com.citi.retail.optima.etl.aggregation.exception.AggregationException;
import com.citi.retail.optima.etl.aggregation.exception.AggregationExceptionItem;
import com.citi.retail.optima.etl.aggregation.exception.ExceptionScope;
import com.citi.retail.optima.etl.aggregation.exception.ExceptionType;
import com.citi.retail.optima.etl.aggregation.model.AggregationType;
import com.citi.retail.optima.etl.aggregation.model.AggregationVO;


/**
 * @author mc56120
 * 
 *         Aggregation Service class that handles aggregation of data and
 *         persisting aggregated data
 * 
 * @param <T>
 * 
 */
public class AggregationServiceImpl<T> implements AggregationService<T> {
	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(AggregationServiceImpl.class);
	private List<AggregationType> aggregationTypeList;
	private Map<String, Expression> expressionMap = null;
	private ExpressionParser parser;
	private static final String DELIMITER = ";;;";
	private Long batchInstanceId;
	private Date monthEndDate;
	private List<Map<String, Map<String, List<Number>>>> agrregationMapList;
	private final Map<String, Map<String, List<Number>>> aggregationResults;
	private AggregationDao aggregationDao;
	private Map<String,AggregationRuleSql> aggregationSqlMap = null;
	private static final int ZERO = 0;
	private String serviceKey;

	// results stored as per local partition eg :
	// map<p1,localAggrResultForPartition1> and so on
	// aggregation result map based on partition.

	private Map<String, Map<String, Map<String, List<Number>>>> agrregationResultMapPerPartition;

	/**
	 * 
	 * @param aggrTypeList
	 */
	public AggregationServiceImpl() {
		this.expressionMap = new HashMap<String, Expression>();
		this.agrregationMapList = new ArrayList<Map<String, Map<String, List<Number>>>>();
		this.aggregationResults = new HashMap<String, Map<String, List<Number>>>();
		this.agrregationResultMapPerPartition = new HashMap<String, Map<String, Map<String, List<Number>>>>();
	}

	/**
	 * @return the aggregationTypeList
	 */
	public List<AggregationType> getAggregationTypeList() {
		return this.aggregationTypeList;
	}

	/**
	 * @param aggregationTypeList
	 *            the aggregationTypeList to set
	 */
	public void setAggregationTypeList(List<AggregationType> aggregationTypeList) {
		this.aggregationTypeList = aggregationTypeList;
	}

	/**
	 * @return the agrregationMapList
	 */
	public List<Map<String, Map<String, List<Number>>>> getAgrregationMapList() {
		return this.agrregationMapList;
	}

	/**
	 * @param agrregationMapList
	 *            the agrregationMapList to set
	 */
	public void setAgrregationMapList(
			List<Map<String, Map<String, List<Number>>>> agrregationMapList) {
		this.agrregationMapList = agrregationMapList;
	}

	/**
	 * 
	 * @return agrregationResults
	 */
	public Map<String, Map<String, List<Number>>> getAggregationResults() {
		return aggregationResults;
	}

	/**
	 * @return the agrregationResultMapPerPartition
	 */
	public Map<String, Map<String, Map<String, List<Number>>>> getAgrregationResultMapPerPartition() {
		return this.agrregationResultMapPerPartition;
	}

	/**
	 * @param agrregationResultMapPerPartition
	 *            the agrregationResultMapPerPartition to set
	 */
	public void setAgrregationResultMapPerPartition(
			Map<String, Map<String, Map<String, List<Number>>>> agrregationResultMapPerPartition) {
		this.agrregationResultMapPerPartition = agrregationResultMapPerPartition;
	}

	/**
	 * @param batchInstanceId
	 *            the batchInstanceId to set
	 */
	public void setBatchInstanceId(Long batchInstanceId) {
		this.batchInstanceId = batchInstanceId;
	}

	/**
	 * @param monthEndDate
	 *            the monthEndDate to set
	 */
	public void setMonthEndDate(Date monthEndDate) {
		this.monthEndDate = monthEndDate;
	}

	/**
	 * @param aggregationDao
	 *            the aggregationDao to set
	 */
	public void setAggregationDao(AggregationDao aggregationDao) {
		this.aggregationDao = aggregationDao;
	}

	/**
	 * @param expressionMap
	 *            the expressionMap to set
	 */
	public void setExpressionMap(Map<String, Expression> expressionMap) {
		this.expressionMap = expressionMap;
	}

	/**
	 * @param parser
	 *            the parser to set
	 */
	public void setParser(ExpressionParser parser) {
		this.parser = parser;
	}

	
	/**
	 * @param aggregationSqlMap
	 *            the aggregationSqlMap to set
	 */
	public void setAggregationSqlMap(
			Map<String, AggregationRuleSql> aggregationSqlMap) {
		this.aggregationSqlMap = aggregationSqlMap;
	}

	/** 
	 * Gets aggregation list
	 */
	
	@Override
	public List<T> aggregateList(List<T> dataList,
			Map<String, Map<String, List<Number>>> aggregationMap,
			boolean accountTraceabilityRequired)
			throws AggregationException {
		for (T data : dataList) {
			data = aggregate(data, aggregationMap, accountTraceabilityRequired);
		}
		return dataList;
	}
	
	
	
    /**
     * Gets aggregation  
     */
	@Override
	public T aggregate(T data,
			Map<String, Map<String, List<Number>>> aggregationMap,
			boolean accountTraceabilityRequired)
			throws AggregationException {
		List<AggregationExceptionItem> aggregationExceptionItems = new ArrayList<AggregationExceptionItem>();
		
		for (AggregationType aggrType : this.aggregationTypeList) {
			  try{
				// Aggregation key
				String aggregationRuleKey = getAggregationRuleKey(data,
						aggrType.getAggregationRuleKeySpelExpr(),
						aggrType.getName(), aggregationExceptionItems);

				// whereCriteria
				String whereCriteriaExpr = aggrType.getWhereCriteriaSpelExpr();
				if (StringUtils.hasText(whereCriteriaExpr)) {
					Boolean meetsWhereCriteria = getWhereCriteria(data,
							whereCriteriaExpr, aggrType.getName(),
							aggregationExceptionItems);
					if (meetsWhereCriteria != null && !meetsWhereCriteria) {
						continue;
					}
				}

				// columns to aggregate
				List<Number> valueList = getColumnsToAggregate(
						aggrType.getColumnsToAggregateValueSpelExpr(), data,
						aggrType.getName(), aggregationExceptionItems);
				add(aggrType.getName(), aggregationRuleKey, valueList,
						aggregationMap,
						aggrType.getColumnsToAggregateValueSpelExpr(),
						aggregationExceptionItems, data);


				// account traceability
				//TODO: Commented out alternative To Be Implemented... per MC
			    /*List<AccountTraceabilityInfo> accountTraceInfoList = new ArrayList<AccountTraceabilityInfo>();*/
			   if (accountTraceabilityRequired) {
				 //TODO: Commented out alternative To Be Implemented... per MC
					/*AccountTraceabilityInfo acctTracebilityInfo = new AccountTraceabilityInfo();
					acctTracebilityInfo.setAggregationTypeId(aggrType.getId());
					acctTracebilityInfo.setAggregationTypeName(aggrType
							.getName());
					acctTracebilityInfo
							.setBatchInstanceId(this.batchInstanceId);
					acctTracebilityInfo
							.setAccountNumber(((RetailBaseAccount) data)
									.getAccountNumber());
					acctTracebilityInfo.setProcessingUnitId(aggrType
							.getProcessingUnitId());
					accountTraceInfoList.add(acctTracebilityInfo);*/
				}

			} catch (Exception e) {
				//add the error to aggregationExceptionItems list and continue to next record
				handleException(e, aggrType.getName(), null,
						"Error while aggregating data ", ExceptionType.FATAL,
						aggregationExceptionItems);
				
			}
		}
		if (aggregationExceptionItems.size() != ZERO) {
			//aggregationExceptionItems stores the entire set 
			//throw exception for this entire aggregation process
			AggregationException aggregationException = new AggregationException(ExceptionType.FATAL, ExceptionScope.RUNTIME, "Error while aggregating data AggregationServiceImpl.aggregate()");
			aggregationException.setExceptionItems(aggregationExceptionItems);
			throw aggregationException;
		    
		}

		//TODO: Commented out alternative To Be Implemented... per MC
		/*if (accountTraceabilityRequired) {
			((RetailBaseAccount) data)
					.setAccountTraceInfoList(accountTraceInfoList);
		}*/
		return data;
	}

	/**
	 * populate aggregation rule keys.
	 * 
	 * @param data
	 * @param aggregationRuleKeySpelExpr
	 * @param aggregationRule
	 * @param optimaRetailSkippableList
	 * @return
	 */
	public String getAggregationRuleKey(T data,
			List<String> aggregationRuleKeySpelExpr, String aggregationRule,
			List<AggregationExceptionItem> optimaRetailSkippableList) {
		StringBuilder aggrKey = new StringBuilder();
		int i = 1;
		for (String aggregateKey : aggregationRuleKeySpelExpr) {
			try {
				Expression ruleExpr = this.expressionMap.get(aggregateKey);
				if (ruleExpr == null) {
					ruleExpr = this.parser.parseExpression(aggregateKey);
					this.expressionMap.put(aggregateKey, ruleExpr);
				}
				aggrKey.append(ruleExpr.getValue(data));
				if (i != aggregationRuleKeySpelExpr.size()) {
					aggrKey.append(DELIMITER);
				}
				i++;
			} catch (EvaluationException e) {
				handleException(e, aggregationRule, aggregateKey,
						"Error while parsing aggregation rule key",
						ExceptionType.WARNING, optimaRetailSkippableList);

			}
		}
		return aggrKey.toString();
	}

	/**
	 * populate aggregation metrics data from sPEL.
	 * 
	 * @param columnsToAggregateValueSpelExpr
	 * @param data
	 * @param aggregationRule
	 * @param optimaRetailSkippableList
	 * @return
	 */
	public List<Number> getColumnsToAggregate(
			List<String> columnsToAggregateValueSpelExpr, T data,
			String aggregationRule,
			List<AggregationExceptionItem> optimaRetailSkippableList) {
		List<Number> valueList = new ArrayList<Number>();
		for (String aggregateRuleValues : columnsToAggregateValueSpelExpr) {
			try {
				Expression valueExpr = this.expressionMap
						.get(aggregateRuleValues);
				if (valueExpr == null) {
					valueExpr = this.parser
							.parseExpression(aggregateRuleValues);
					this.expressionMap.put(aggregateRuleValues, valueExpr);
				}
				Number value = (Number) valueExpr.getValue(data);
				valueList.add(value);
			} catch (EvaluationException e) {
				handleException(e, aggregationRule, aggregateRuleValues,
						"Error while parsing aggregation metrics value",
						ExceptionType.WARNING, optimaRetailSkippableList);
			}
		}
		return valueList;
	}

	/**
	 * evaluate where criteria from SPEL
	 * 
	 * @param data
	 * @param whereCriteriaExpr
	 * @param aggregationRule
	 * @param optimaRetailSkippableList
	 * @return
	 */
	public Boolean getWhereCriteria(T data, String whereCriteriaExpr,
			String aggregationRule,
			List<AggregationExceptionItem> optimaRetailSkippableList) {
		Boolean meetsWhereCriteria = Boolean.FALSE;
		try {
			Expression criteriaExpr = this.expressionMap.get(whereCriteriaExpr);
			if (criteriaExpr == null) {
				criteriaExpr = this.parser.parseExpression(whereCriteriaExpr);
				this.expressionMap.put(whereCriteriaExpr, criteriaExpr);
			}
			meetsWhereCriteria = (Boolean) criteriaExpr.getValue(data);
		} catch (EvaluationException e) {
			handleException(e, aggregationRule, whereCriteriaExpr,
					"Error while parsing where Criteria rule key",
					ExceptionType.WARNING, optimaRetailSkippableList);

		}

		return meetsWhereCriteria;
	}

	/**
	 * save aggregation output.
	 */
	@Override
	public boolean saveAggregationResults()
			throws AggregationException {
		boolean savedAggregationResults = false;
		try {
			List<AggregationVO> aggregationVOList = new ArrayList<AggregationVO>();
			//endDate is currently not used.... should be fix later to allow dynamic population
			java.sql.Date endDate = new java.sql.Date(012013);
			mergeAggregationResults();
			for (String aggrType : this.aggregationResults.keySet()) {
				Map<String, List<Number>> aggrValueMap = this.aggregationResults
						.get(aggrType);
				AggregationRuleSql aggrSqlRef = this.aggregationSqlMap
						.get(aggrType);
				AggregationVO aggregationVO = new AggregationVO();
				aggregationVO.setJobInstanceId(this.batchInstanceId);
				aggregationVO.setMonthEndDate(endDate);
				String[] keys = aggrType.split(":");
				aggregationVO.setSysProcId(Integer.valueOf(keys[0]));
				aggregationVO.setAggregationType(keys[1]);
				aggregationVO.setAggregationValues(aggrValueMap);
				aggregationVO.setInsertSql(aggrSqlRef != null ? aggrSqlRef.getInsertSql() : null);
				aggregationVO.setProcessingUnitId(aggrSqlRef
						.getProcessingUnitId());
				aggregationVOList.add(aggregationVO);
			}

			savedAggregationResults = this.aggregationDao
					.saveAggregationResults(aggregationVOList);
			
		} catch (Exception e) {
         
			List<AggregationExceptionItem> optimaRetailSkippableList = new ArrayList<AggregationExceptionItem>();
			handleException(e, null, null,
					"Error while saving aggregation results",
					ExceptionType.FATAL, optimaRetailSkippableList);

			AggregationException aggregationException = new AggregationException(ExceptionType.FATAL, ExceptionScope.SERVICE,"Error");
			aggregationException.setStackTrace(e.getStackTrace());
			aggregationException.setExceptionItems(optimaRetailSkippableList);
		
			throw aggregationException;
		}
		return savedAggregationResults;
	}

	/**
	 * perform the read/write operation on collection.
	 */
	protected void add(String aggregationTypeName, String aggregationRuleKey,
			List<Number> valueResult,
			Map<String, Map<String, List<Number>>> storeMap,
			List<String> aggregationValueExpr,
			List<AggregationExceptionItem> optimaRetailSkippableList,
			T data) throws AggregationException {
		Map<String, List<Number>> aggregationTypeBucket = null;
		int errorCnt = ZERO;
		List<Number> localValueResultList = new ArrayList<Number>(
				valueResult.size());
		aggregationTypeBucket = get(aggregationTypeName, aggregationRuleKey,
				storeMap);
		try {
			if (aggregationTypeBucket != null
					&& aggregationTypeBucket.get(aggregationRuleKey).size() == ZERO) {
				aggregationTypeBucket.put(aggregationRuleKey, valueResult);
			} else {
				for (int i = ZERO; i < valueResult.size(); i++) {
					try {
						Number value = aggregationTypeBucket.get(
								aggregationRuleKey).get(i) == null ? 0.0
								: aggregationTypeBucket.get(aggregationRuleKey)
										.get(i).doubleValue()
										+ (valueResult.get(i) == null ? 0.0
												: valueResult.get(i)
														.doubleValue());

						localValueResultList.add(i, value);
					} catch (Exception e) {
						errorCnt++;
						localValueResultList.add(i, null);
						handleException(e, aggregationTypeName,
								aggregationValueExpr.get(i),
								"Error while aggregating data",
								ExceptionType.FATAL, optimaRetailSkippableList);
					}
				}
				if (errorCnt == ZERO) {
					// add to store if there is no exception
					aggregationTypeBucket.put(aggregationRuleKey,
							localValueResultList);
				}
			}
		} catch (Exception e) {
			errorCnt++;
			handleException(e, aggregationTypeName, aggregationRuleKey,
					"Error while aggregating data", ExceptionType.FATAL,
					optimaRetailSkippableList);
		}
		if (errorCnt == ZERO) {
			// add to store if there is no exception
			storeMap.put(aggregationTypeName, aggregationTypeBucket);
		}
	}

	/**
	 * fetch details from local map
	 * 
	 * @param aggregationTypeName
	 * @param aggregationRuleKey
	 * @param storeMap
	 * @return
	 * @throws AggregationExpection
	 */
	protected Map<String, List<Number>> get(String aggregationTypeName,
			String aggregationRuleKey,
			Map<String, Map<String, List<Number>>> storeMap)
			throws AggregationException {
		Map<String, List<Number>> aggregationTypeBucket = storeMap
				.get(aggregationTypeName);
		if (aggregationTypeBucket == null) {
			aggregationTypeBucket = new HashMap<String, List<Number>>();
			storeMap.put(aggregationTypeName, aggregationTypeBucket);
		}
		if (aggregationTypeBucket != null
				&& !aggregationTypeBucket.containsKey(aggregationRuleKey)) {
			List<Number> aggregationValueList = new ArrayList<Number>();
			aggregationTypeBucket.put(aggregationRuleKey, aggregationValueList);
		}
		return aggregationTypeBucket;
	}

	/**
	 * get a instance of local map per partition and add the handle to a List
	 */
	public Map<String, Map<String, List<Number>>> getLocalAggregationMap(
			Integer partitonId) {
		Map<String, Map<String, List<Number>>> aggregationMap = new HashMap<String, Map<String, List<Number>>>();
		this.agrregationMapList.add(aggregationMap);
		if (partitonId != null) {
			this.agrregationResultMapPerPartition.put(partitonId.toString(),
					aggregationMap);
		}
		return aggregationMap;
	}

	/**
	 * merge local maps from each partition
	 */
	public void mergeAggregationResults()
			throws AggregationException {
		Map<String, Map<String, List<Number>>> aggregationTypeMap = null;
		Map<String, List<Number>> aggregationValueMap = null;
		// loop through all buckets
		for (String key : getAgrregationKeySet()) {
			for (int cntr = ZERO; cntr < getAgrregationMapList().size(); cntr++) {
				aggregationTypeMap = getAgrregationMapList().get(cntr);
				// each aggregationType
				for (String aggrKey : aggregationTypeMap.keySet()) {
					aggregationValueMap = aggregationTypeMap.get(aggrKey);
					List<Number> valueResult = aggregationValueMap.get(key);
					if (aggregationValueMap.containsKey(key)) {
						merge(aggrKey, key, valueResult,
								this.aggregationResults);
					}
				}
			}
		}
	}

	/**
	 * get keys from all local maps and add to a Set.
	 */
	protected Set<String> getAgrregationKeySet() {
		Set<String> agrregationKeySet = new HashSet<String>();
		for (Map<String, Map<String, List<Number>>> agrregationMap : this.agrregationMapList) {
			for (Map<String, List<Number>> bucketMap : agrregationMap.values()) {
				agrregationKeySet.addAll(bucketMap.keySet());
			}
		}
		return agrregationKeySet;
	}

	/**
	 * merge aggregated result.
	 * 
	 * @param aggregationTypeName
	 * @param aggregationRuleKey
	 * @param valueResult
	 * @param storeMap
	 * @throws AggregationExpection
	 */
	protected void merge(String aggregationTypeName, String aggregationRuleKey,
			List<Number> valueResult,
			Map<String, Map<String, List<Number>>> storeMap)
			throws AggregationException {
		Map<String, List<Number>> aggregationTypeBucket = null;
		aggregationTypeBucket = get(aggregationTypeName, aggregationRuleKey,
				storeMap);
		if (aggregationTypeBucket != null
				&& aggregationTypeBucket.get(aggregationRuleKey).size() == ZERO) {
			aggregationTypeBucket.put(aggregationRuleKey, valueResult);
		} else {
			for (int i = ZERO; i < valueResult.size(); i++) {
				Number value = aggregationTypeBucket.get(aggregationRuleKey)
						.get(i) == null ? 0.0 : aggregationTypeBucket
						.get(aggregationRuleKey).get(i).doubleValue()
						+ (valueResult.get(i) == null ? 0.0 : valueResult
								.get(i).doubleValue());
				aggregationTypeBucket.get(aggregationRuleKey).set(i, value);
			}
		}
		storeMap.put(aggregationTypeName, aggregationTypeBucket);
	}

	/**
	 * Handles and adds the thrown exception in to Optima Retail Exception
	 * Detail.
	 * 
	 * @param exception
	 * @param rule
	 * @param attribute
	 * @param message
	 * @param exceptionType
	 * @param optimaRetailSkippableList
	 */
	private void handleException(Exception exception, String rule,
			String attribute, String message, ExceptionType exceptionType,
			List<AggregationExceptionItem> optimaRetailSkippableList) {
		AggregationExceptionItem optimaRetailSkippable = new AggregationExceptionItem();
		optimaRetailSkippable.getExceptionsDetail().put("errorMessages", new HashMap<String,String>());
		
		optimaRetailSkippable.getExceptionsDetail().get("errorMessages").put("userErrorMessage",message);
		optimaRetailSkippable.getExceptionsDetail().get("errorMessages").put("ExceptionErrorMessage",exception.getMessage() == null ? exception
				.getClass().getName() : exception.getMessage());
		
		optimaRetailSkippable.getExceptionsDetail().put("rule", new HashMap<String,String>());
		optimaRetailSkippable.getExceptionsDetail().get("rule").put("id",rule);
		optimaRetailSkippable.getExceptionsDetail().get("rule").put("attribute",attribute);
		optimaRetailSkippable.getExceptionsDetail().put("exception", new HashMap<String,String>());
		optimaRetailSkippable.getExceptionsDetail().get("exception").put("exceptionType",exceptionType.name());
		optimaRetailSkippable.getExceptionsDetail().get("exception").put("stackTracke",getStackTrace(exception));
		optimaRetailSkippableList.add(optimaRetailSkippable);
	}

	/**
	 * @return the serviceKey
	 */
	public String getServiceKey() {
		return serviceKey;
	}

	/**
	 * @param serviceKey
	 *            the serviceKey to set
	 */
	public void setServiceKey(String serviceKey) {
		this.serviceKey = serviceKey;
	}
	
	/**
	 * Convert stack trace in to string
	 * @param e
	 * @return
	 */

	public  String getStackTrace(Exception e) {
		final Writer result = new StringWriter();
		final PrintWriter printWriter = new PrintWriter(result);
		e.printStackTrace(printWriter);
		String s = result.toString().replace("\n", "\\n");
		String s1 = s.replace("\r", "\\r");
		String s2 = s1.replace("\t", "\\t");
		return s2.replace("\"", "\\\"");
	}
}
