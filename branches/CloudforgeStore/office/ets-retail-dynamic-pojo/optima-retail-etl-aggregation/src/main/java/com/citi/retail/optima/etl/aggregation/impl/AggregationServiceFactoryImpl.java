/**
 * 
 */
package com.citi.retail.optima.etl.aggregation.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.ExpressionParser;

import com.citi.retail.optima.etl.aggregation.AggregationService;
import com.citi.retail.optima.etl.aggregation.AggregationServiceFactory;
import com.citi.retail.optima.etl.aggregation.dao.AggregationDao;
import com.citi.retail.optima.etl.aggregation.dao.AggregationRuleSql;
import com.citi.retail.optima.etl.aggregation.exception.AggregationException;
import com.citi.retail.optima.etl.aggregation.exception.AggregationExceptionItem;
import com.citi.retail.optima.etl.aggregation.exception.ExceptionScope;
import com.citi.retail.optima.etl.aggregation.exception.ExceptionType;
/*import com.citi.retail.optima.etl.aggregation.exception.OptimaRetailAggregationDataExceptionDetail;
import com.citi.retail.optima.etl.aggregation.exception.OptimaRetailAggregationException;*/
import com.citi.retail.optima.etl.aggregation.model.AggregationRuleLookup;
import com.citi.retail.optima.etl.aggregation.model.AggregationType;

/**
 * Aggregation Service Factory to get aggregation service based on specific
 * criteria and load aggregation rules.
 * 
 * @author mc56120
 * 
 */
public class AggregationServiceFactoryImpl<T> implements
		AggregationServiceFactory<T> {
	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(AggregationServiceFactoryImpl.class);
	private AggregationRuleLookup aggregationRuleLookup;
	private ExpressionParser parser;
	private AggregationDao aggregationDao;
	
	private List<AggregationExceptionItem> aggregationExceptionItemList;


	/**
	 * this map will contain instance of aggregation service for a
	 * feedJobInstanceId
	 */
	private final Map<String, AggregationService<T>> aggregationServiceMap = new HashMap<String, AggregationService<T>>();


	/**
	 * gets an aggregation servcie based on a key set of value
	 * i.e. batchinstance id, monthEndDate and stepname
	 * @param keyList
	 * @param batchInstanceId
	 * @param monthEndDate
	 * @param stepName
	 * @throws AggregationExpection
	 */
	@Override
	public AggregationService<T> getAggregationService(List<String> keyList,
			Long batchInstanceId, Date monthEndDate, String stepName) throws AggregationException
			{
		
		String key = getAggregationKey(batchInstanceId, stepName);
		
		AggregationService<T> aggregationService = this.aggregationServiceMap
				.get(key);
		if (aggregationService == null) {
			synchronized (this) {
				if (aggregationService == null) {
					List<AggregationType> aggregationTypeList = null;
					aggregationTypeList = loadAggregationRules(keyList);                 
					Map<String, AggregationRuleSql> aggrSqlMap = loadAggregationInsertSqlRules(keyList);
					if (this.aggregationExceptionItemList != null
							&& this.aggregationExceptionItemList.size() > 0) {

						AggregationException exception = new AggregationException(ExceptionType.FATAL, ExceptionScope.SERVICE, "Encounter Fatal Errors");
						exception.setExceptionItems(aggregationExceptionItemList);
						throw exception;
					}

					aggregationService = new AggregationServiceImpl<T>();
					((AggregationServiceImpl<T>) aggregationService)
							.setAggregationTypeList(aggregationTypeList);
					((AggregationServiceImpl<T>) aggregationService)
							.setParser(getParser());
					((AggregationServiceImpl<T>) aggregationService)
							.setBatchInstanceId(batchInstanceId);
					((AggregationServiceImpl<T>) aggregationService)
							.setMonthEndDate(monthEndDate);
					((AggregationServiceImpl<T>) aggregationService)
							.setAggregationDao(getAggregationDao());
					((AggregationServiceImpl<T>) aggregationService)
							.setAggregationSqlMap(aggrSqlMap);
				}
			}
			this.aggregationServiceMap.put(key, aggregationService);
		}

		return aggregationService;
	}
	
	/**
	 * Gets the Aggregation service associated to key list, batchInstanceId, MonthEndDate, stepName and sysprocId
	 */
	@Override
	public AggregationService<T> getAggregationService(List<String> keyList,
			Long batchInstanceId, Date monthEndDate, String stepName, Integer sysProcId)
			throws AggregationException {
		String key = getAggregationKey(batchInstanceId, sysProcId);
		AggregationService<T> aggregationService = this.aggregationServiceMap
				.get(key);
		if (aggregationService == null) {
			synchronized (this) {
				if (aggregationService == null) {
					List<AggregationType> aggregationTypeList = loadAggregationRules(getConcatenatedKeys(sysProcId, stepName));

					Map<String, AggregationRuleSql> aggrSqlMap = loadAggregationInsertSqlRules(getConcatenatedKeys(sysProcId, stepName));

					if (this.aggregationExceptionItemList != null
							&& this.aggregationExceptionItemList.size() > 0) {
						AggregationException exception = new AggregationException(ExceptionType.FATAL, ExceptionScope.SERVICE, "Encounter Fatal Errors");
						exception.setExceptionItems(aggregationExceptionItemList);
						throw exception;
					}

					aggregationService = new AggregationServiceImpl<T>();
					((AggregationServiceImpl<T>) aggregationService)
							.setAggregationTypeList(aggregationTypeList);
					((AggregationServiceImpl<T>) aggregationService)
							.setParser(getParser());
					((AggregationServiceImpl<T>) aggregationService)
							.setBatchInstanceId(batchInstanceId);
					((AggregationServiceImpl<T>) aggregationService)
							.setMonthEndDate(monthEndDate);
					((AggregationServiceImpl<T>) aggregationService)
							.setAggregationDao(getAggregationDao());
					((AggregationServiceImpl<T>) aggregationService)
							.setAggregationSqlMap(aggrSqlMap);
					((AggregationServiceImpl<T>) aggregationService)
					.setServiceKey(key);
				}
			}
			this.aggregationServiceMap.put(key, aggregationService);
		}

		return aggregationService;
	}	

	/**
	 * load aggregation rules.
	 * 
	 * @param keyList
	 * @return
	 * @throws AggregationExpection
	 */
	@Override
	public List<AggregationType> loadAggregationRules(List<String> keyList) throws AggregationException
			 {
		List<AggregationType> aggregationTypeList = getAggregationRuleLookup().getAggregationRuleType(keyList);

		if (aggregationTypeList == null
				|| (aggregationTypeList != null && aggregationTypeList.size() == 0)) {
			String aggregationErrorMsg = "Aggreagtion Service would not be loaded for "
					+ " ProcessingUnit: "
					+ keyList
					+ " as there are no Aggregation Rules Specified for the given criteria.";
			LOGGER.error(aggregationErrorMsg);
			handleExceptions(ExceptionType.FATAL,ExceptionScope.SERVICE,aggregationErrorMsg);
			throw new AggregationException(ExceptionType.FATAL,ExceptionScope.SERVICE,aggregationErrorMsg);
		}
		return aggregationTypeList;
	}

	/**
	 * load aggregation output insert sql.
	 * 
	 * @param processingUnitId
	 * @return
	 * @throws AggregationExpection
	 */
	@Override
	public Map<String, AggregationRuleSql>  loadAggregationInsertSqlRules(List<String> keyList) throws AggregationException {
		Map<String, AggregationRuleSql> aggrSqlMap = null;
		try {
			aggrSqlMap = getAggregationRuleLookup().getAggregationSql(keyList);
		} catch (AggregationException e) {
			AggregationException exception = new AggregationException(ExceptionType.FATAL, ExceptionScope.SERVICE, e.getMessage());
			exception.setStackTrace(e.getStackTrace());
			throw exception;
		}
		
		if (aggrSqlMap == null || aggrSqlMap.isEmpty()) {
			String aggregationErrorMsg = "Aggreagtion Service would not be loaded for "
					+ " keyList: "
					+ keyList
					+ " as there are no Aggregation Output Insert SQL Specified for the given criteria.";
			LOGGER.error(aggregationErrorMsg);
			handleExceptions(ExceptionType.FATAL,ExceptionScope.SERVICE,aggregationErrorMsg);
		}
		return aggrSqlMap;
	}

	/**
	 * Handles and adds the thrown exception in to Optima Retail Exception
	 * Detail.
	 * 
	 * @param message
	 *            exception message
	 */
	public void handleExceptions(ExceptionType exceptionType, ExceptionScope exceptionScope,String message) {
		
		if (this.aggregationExceptionItemList == null) {
			this.aggregationExceptionItemList = new ArrayList<AggregationExceptionItem>();
		}
		
		AggregationExceptionItem aggregationExcpetionItem = new AggregationExceptionItem();
		aggregationExcpetionItem.getExceptionsDetail().put(exceptionScope.name(), new HashMap<String,String>());
		
		aggregationExcpetionItem.getExceptionsDetail().get(exceptionScope.name()).put(AggregationExceptionItem.KeyDefnition.EXCEPTION_TYPE.name(),exceptionType.name());
		aggregationExcpetionItem.getExceptionsDetail().get(exceptionScope.name()).put(AggregationExceptionItem.KeyDefnition.USER_MESSAGE.name(), message);
		aggregationExcpetionItem.getExceptionsDetail().get(exceptionScope.name()).put(AggregationExceptionItem.KeyDefnition.ERROR_MESSAGE.name(),"Error:: while loading Aggregation rules : "
				+ message);
		
		this.aggregationExceptionItemList.add(aggregationExcpetionItem);
	}

	/**
	 * clear aggregation service after job completion
	 * 
	 * @param batchInstanceId
	 * @param stepName
	 */
	@Override
	public void clearAggregationServiceFromMap(Long batchInstanceId,
			String stepName) {
		try {
			String key = getAggregationKey(batchInstanceId, stepName);
			if (this.aggregationServiceMap.containsKey(key)) {
				this.aggregationServiceMap.remove(key);
			}
		} catch (AggregationException e) {
			LOGGER.error("Error while clearing aggregation service for batchInstanceId = "
					+ batchInstanceId + " , stepName = " + stepName);
		}
	}
	/**
	 * Remove Aggreation Service from the pool based on batchInstance id and sysProcid
	 */
	
	@Override
	public void clearAggregationServiceFromMap(Long batchInstanceId,
			Integer sysProcId) {
		try {
			String key = getAggregationKey(batchInstanceId, sysProcId);
			if (this.aggregationServiceMap.containsKey(key)) {
				this.aggregationServiceMap.remove(key);
			}
		} catch (AggregationException e) {
			LOGGER.error("Error while clearing aggregation service for batchInstanceId = "
					+ batchInstanceId + " , sysProcId = " + sysProcId);
		}
	}

	/**
	 * Generated a unique key for the AggressionService Pool batch instance id and stepname
	 * @param batchInstanceId
	 * @param stepName
	 * @return
	 */
	public String getAggregationKey(Long batchInstanceId, String stepName)
			throws AggregationException {
		String aggregationKey = "";
		if (batchInstanceId == null) {
			String aggregationErrorMsg = "Aggreagtion Service would not be loaded as batchInstanceId is null. ";
			LOGGER.error(aggregationErrorMsg);
			handleExceptions(ExceptionType.FATAL,ExceptionScope.SERVICE,aggregationErrorMsg);
			return aggregationKey;
		}

		if (stepName == null || stepName != null && stepName.length() == 0) {
			aggregationKey = batchInstanceId.toString();
		} else {
			aggregationKey = stepName + ":" + batchInstanceId.toString();
		}
		return aggregationKey;
	}
	
	/**
	 * Generated a unique key for the AggressionService Pool batch instance id and sysProcId
	 * @param batchInstanceId
	 * @param sysProcId
	 * @return
	 * @throws AggregationException
	 */
	public String getAggregationKey(Long batchInstanceId, Integer sysProcId)
			throws AggregationException {
		String aggregationKey = "";
		if (batchInstanceId == null) {
			String aggregationErrorMsg = "Aggregation Service would not be loaded as batchInstanceId is null. ";
			LOGGER.error(aggregationErrorMsg);
			handleExceptions(ExceptionType.FATAL,ExceptionScope.SERVICE,aggregationErrorMsg);
			return aggregationKey;
		}

		if (sysProcId == null) {
			aggregationKey = batchInstanceId.toString();
		} else {
			aggregationKey = sysProcId + ":" + batchInstanceId.toString();
		}
		return aggregationKey;
	}	
	
	/**
	 * Gets keylist by  categoryName and sysprocid 
	 * @param sysProcId
	 * @param categoryName
	 * @return
	 */
	private List<String> getConcatenatedKeys(
			Integer sysProcId, String categoryName) {
		List<String> keyList = new ArrayList<String>();
		String concatenatedStr = null;
		concatenatedStr = "";
		if (categoryName != null && categoryName.length() > 0) {
			concatenatedStr = categoryName + ":";
		}
		
		if (sysProcId != null) {
			concatenatedStr = concatenatedStr + sysProcId;
		}

		keyList.add(concatenatedStr);
		return keyList;
	}	
	
	/**
	 * Gets aggreation servcie instance from pool by key...
	 * 
	 */
	@Override
	public AggregationService<T> getAggregationServiceFromPool(String key) throws AggregationException {
		return this.aggregationServiceMap.get(key);
	}
	
	/**
	 * Gets aggregation rule lookup
	 * @return
	 */
	public AggregationRuleLookup getAggregationRuleLookup() {
		return aggregationRuleLookup;
	}

	/**
	 * Sets aggregation rule lookup object if needed to
	 * @param aggregationRuleLookup
	 */
	public void setAggregationRuleLookup(AggregationRuleLookup aggregationRuleLookup) {
		this.aggregationRuleLookup = aggregationRuleLookup;
	}
	
	/**
	 * @return the parser
	 */
	public ExpressionParser getParser() {
		return this.parser;
	}
	/**
	 * @param parser
	 *            the parser to set
	 */
	public void setParser(ExpressionParser parser) {
		this.parser = parser;
	}

	/**
	 * @return the aggregationDao
	 */
	public AggregationDao getAggregationDao() {
		return this.aggregationDao;
	}

	

	/**
	 * @param aggregationDao
	 *            the aggregationDao to set
	 */
	public void setAggregationDao(AggregationDao aggregationDao) {
		this.aggregationDao = aggregationDao;
	}

	/**
	 * @return the aggregationServiceMap
	 */
	public Map<String, AggregationService<T>> getAggregationServiceMap() {
		return this.aggregationServiceMap;
	}

}
