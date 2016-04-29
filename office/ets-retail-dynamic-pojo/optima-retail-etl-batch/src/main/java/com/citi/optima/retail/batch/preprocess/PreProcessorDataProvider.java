package com.citi.optima.retail.batch.preprocess;

import java.util.Map;

import com.citi.retail.optima.etl.common.model.FicoRecord;
/**
 * 
 * @author mc56120
 *
 * @param <T>
 * PreProcessor Data provider interface defining the contract to get and set a preProcessMap from Preprocessors.
 */

public interface PreProcessorDataProvider<T> {

	void setPreprocessMap(Map<String, Object> preprocessMap);

	Object getValue(String key);

	Map<String, Object> getPreprocessMap();

	Boolean contains(String key);


}