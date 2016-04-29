/**
 * 
 */
package com.citi.optima.retail.batch.preprocess;

import java.util.Map;

/**
 * @author mc56120
 * @param <T>
 * 
 */
public interface PreProcessorDataService<T> {
	Map<String, T> getLocalPreProcessorDataServiceMap(String partitonInfo);

}
