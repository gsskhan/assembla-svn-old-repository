package com.citi.retail.optima.etl.batch.job.reader;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.InitializingBean;

import com.citi.optima.retail.batch.preprocess.PreProcessorDataService;

public class MapItemReader<T> implements ItemReader<T>,InitializingBean {
		
	private Map<String, Object> dataMap;
	
	int counter;
	
	private List<Object> itemList;
	
	private PreProcessorDataService dataService;

	private String preProcessMapName;

	@BeforeStep
	public void getData(StepExecution stepExecution) {
		itemList = new ArrayList<Object>(dataMap.values());
	}
	
	@Override
	public T read() throws UnexpectedInputException,
			ParseException, NonTransientResourceException, Exception {

		if (counter < itemList.size()) {
			T value = (T) itemList.get(counter++);
			return value;
		}
		return null;
	}
	
	@AfterStep
	public void resetCounter() {
		counter = 0;
	}


	/**
	 * @return the dataMap
	 */
	public Map<String, Object> getDataMap() {
		return dataMap;
	}


	/**
	 * @param dataMap the dataMap to set
	 */
	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
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
		dataMap = dataService.getLocalPreProcessorDataServiceMap(preProcessMapName);
		
	}
}
