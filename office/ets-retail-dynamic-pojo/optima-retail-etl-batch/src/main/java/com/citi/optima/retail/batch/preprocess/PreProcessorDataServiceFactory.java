/**
 * 
 */
package com.citi.optima.retail.batch.preprocess;

/**
 * @author mc56120
 * 
 */
public interface PreProcessorDataServiceFactory {

	PreProcessorDataService getPreProcessorDataService(Long batchInstanceId,
			String serviceName) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException;

	void clearPreProcessorDataServiceMap(Long preProcessingName);

}
