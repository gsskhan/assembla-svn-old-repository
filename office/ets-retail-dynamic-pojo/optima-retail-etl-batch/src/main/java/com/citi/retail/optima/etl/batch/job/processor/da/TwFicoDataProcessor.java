/**
 * 
 */
package com.citi.retail.optima.etl.batch.job.processor.da;

import java.io.File;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemReadListener;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.InitializingBean;

import com.citi.optima.retail.batch.preprocess.PreProcessorDataService;
import com.citi.retail.optima.etl.common.log.LoggingMarker;
import com.citi.retail.optima.etl.common.model.DataAcqCardsBaseRecord;
import com.citi.retail.optima.etl.common.model.FicoRecord;

/**
 * @author sr67841
 * 
 */
public class TwFicoDataProcessor implements ItemProcessor<FicoRecord, FicoRecord>, InitializingBean, ItemReadListener<FicoRecord> {


	private Map<String, Integer> preProcessdMap;

	private PreProcessorDataService dataService;

	private String preProcessMapName;

	private String jobName;
	
	private String fileName;
	
	private static final Logger LOGGER = LoggerFactory

            .getLogger(TwFicoDataProcessor.class);
	
	@Override
	public FicoRecord process(FicoRecord currentEvent) throws Exception {
		preProcessdMap.put(((DataAcqCardsBaseRecord)currentEvent).getCardNumber(), currentEvent.getAlignScore());
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
	public void afterRead(FicoRecord arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void beforeRead() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onReadError(Exception ex) {
		
		LOGGER.error(LoggingMarker.KPI.getMarker(), "READ Error in : "+new File(fileName).getName()+"\n");
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


	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}


	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
