/**
 * 
 */
package com.citi.retail.optima.etl.batch.job.processor.da;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemReadListener;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.InitializingBean;

import com.citi.optima.retail.batch.preprocess.PreProcessorDataService;
import com.citi.retail.optima.etl.common.log.LoggingMarker;
import com.citi.retail.optima.etl.common.model.DataAcqCardsBaseRecord;
import com.citi.retail.optima.etl.common.model.DataAcqMtgBaseRecord;
import com.citi.retail.optima.etl.common.model.FxRateRecord;
/**
 * @author gg48714
 * 
 */
public class FxRateSupportingDataProcessor<T> implements ItemProcessor<T, T>,InitializingBean, ItemReadListener<T> {


	private Map<String, T> preProcessdMap;

	private PreProcessorDataService dataService;
	
	

	private String preProcessMapName;

	private String jobName;
	
	private static final Logger LOGGER = LoggerFactory

            .getLogger(FxRateSupportingDataProcessor.class);
	


	@Override
	public T process(T currentEvent) throws Exception {
		preProcessdMap.put(((FxRateRecord)currentEvent).getCurrency(), currentEvent);
		return currentEvent;
	}


	/**
	 * @param dataService the dataService to set
	 */
	public void setDataService(PreProcessorDataService dataService) {
		this.dataService = dataService;
	}

	/**
	 * @param preProcessMapName the preProcessMapName to set
	 */
	public void setPreProcessMapName(String preProcessMapName) {
		this.preProcessMapName = preProcessMapName;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		preProcessdMap = dataService.getLocalPreProcessorDataServiceMap(preProcessMapName);
		
	}


	@Override
	public void afterRead(T arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void beforeRead() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onReadError(Exception ex) {
		
		LOGGER.error(LoggingMarker.KPI.getMarker(), "JOB NAME: "+jobName+"\n");

        LOGGER.error(LoggingMarker.KPI.getMarker(), "ERROR: "+ex.getClass().getName());

        LOGGER.error(LoggingMarker.KPI.getMarker(), "ERROR Detail: "+ex.getMessage());
	}


	/**
	 * @return the jobName
	 */
	public String getJobName() {
		return jobName;
	}


	/**
	 * @param jobName the jobName to set
	 */
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	
}
