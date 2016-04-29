package com.citi.optima.retail.batch.listeners;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.springframework.batch.core.ItemProcessListener;
import org.springframework.beans.factory.InitializingBean;

import com.citi.optima.retail.batch.preprocess.PreProcessorDataService;

public class DataAcqHkWoListener<T> implements ItemProcessListener<T, T> , InitializingBean{
	
	private Map<String, Object> dataMap;
	
	private PreProcessorDataService dataService;

	private String preProcessMapName;

	@Override
	public void beforeProcess(T item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterProcess(T item, T result) {
		String key = null;
		try {
			key = (String) item.getClass().getMethod("getAcctnumb").invoke(item);
		} catch (IllegalArgumentException | IllegalAccessException | SecurityException | InvocationTargetException | NoSuchMethodException e) {
			e.printStackTrace();
		}
		if(dataMap != null){
			if(item.getClass().getSimpleName().contains("HkMtg") && dataMap.containsKey(key)){
				dataMap.remove(key);
			}
			/*else if(item instanceof InMtgOreoRecord){
				dataMap.remove(key);
			}*/
		}
		/*if(dataMap != null){
			dataMap.remove(item.getAcctnumb());
		}*/
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

	@Override
	public void onProcessError(Object item, Exception e) {
		// TODO Auto-generated method stub
		
	}

}
