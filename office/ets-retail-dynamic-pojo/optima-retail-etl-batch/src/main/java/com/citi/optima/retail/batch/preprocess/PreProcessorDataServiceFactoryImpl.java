/**
 * 
 */
package com.citi.optima.retail.batch.preprocess;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author mc56120
 * 
 */
public class PreProcessorDataServiceFactoryImpl implements
		PreProcessorDataServiceFactory {

	private final Map<Long, PreProcessorDataService> preProcessorDataServiceMap = new ConcurrentHashMap<Long, PreProcessorDataService>();

	@Override
	public PreProcessorDataService getPreProcessorDataService(
			Long batchInstanceId, String serviceName)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		PreProcessorDataService preProcessService = preProcessorDataServiceMap
				.get(batchInstanceId);
		if (preProcessService == null) {
			synchronized (this) {
				if (preProcessService == null) {
					@SuppressWarnings("unchecked")
					Class<PreProcessorDataService> clazz = (Class<PreProcessorDataService>) Class
							.forName(serviceName);
					preProcessService = clazz.newInstance();
					preProcessorDataServiceMap.put(batchInstanceId,
							preProcessService);
				}
			}

		}
		return preProcessService;
	}

	@Override
	public void clearPreProcessorDataServiceMap(Long batchInstanceId) {
		preProcessorDataServiceMap.remove(batchInstanceId);
	}

	/**
	 * @return the preProcessorDataServiceMap
	 */
	public Map<Long, PreProcessorDataService> getPreProcessorDataServiceMap() {
		return preProcessorDataServiceMap;
	}

}
