/**
 * 
 */
package com.citi.retail.optima.etl.batch.tasklet;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import com.citi.optima.retail.batch.preprocess.PreProcessorDataProvider;
import com.citi.optima.retail.batch.preprocess.PreProcessorDataService;

/**
 * @author mc56120
 * @param <T>
 * 
 */
public class PreprocessRegister<T> implements Tasklet {

	private PreProcessorDataService<T> preprocessDataService;
	@SuppressWarnings("rawtypes")
	private List<PreProcessorDataProvider> providerList;
	private List<String> keyList;
	
	public void init(){
		registerProviders();
	}
	

	/**
	 * register all the providers to be used
	 */
	@SuppressWarnings("rawtypes")
	private void registerProviders() {
		for( PreProcessorDataProvider provider : providerList){
			provider.getPreprocessMap();
		}
	}

	@Override
	public RepeatStatus execute(StepContribution stepContribution,
			ChunkContext chunkContext) throws Exception {
		for(String key : keyList){
			preprocessDataService.getLocalPreProcessorDataServiceMap(key);
		}
		return RepeatStatus.FINISHED;
	}

	/**
	 * @param preprocessDataService the preprocessDataService to set
	 */
	public void setPreprocessDataService(
			PreProcessorDataService<T> preprocessDataService) {
		this.preprocessDataService = preprocessDataService;
	}


	/**
	 * @param providerList the providerList to set
	 */
	@SuppressWarnings("rawtypes")
	public void setProviderList(List<PreProcessorDataProvider> providerList) {
		this.providerList = providerList;
	}


	/**
	 * @param keyList the keyList to set
	 */
	public void setKeyList(List<String> keyList) {
		this.keyList = keyList;
	}

}
