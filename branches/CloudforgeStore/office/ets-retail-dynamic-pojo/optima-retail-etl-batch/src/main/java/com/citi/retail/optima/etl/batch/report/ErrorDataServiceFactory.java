/**
 * 
 */
package com.citi.retail.optima.etl.batch.report;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author mc56120
 * 
 */
public class ErrorDataServiceFactory {

	private final Map<Long, ErrorReportDataService> preProcessorDataServiceMap = new ConcurrentHashMap<Long, ErrorReportDataService>();

	public ErrorReportDataService getErrorReportDataService(
			Long batchInstanceId, String serviceName)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		ErrorReportDataService preProcessService = preProcessorDataServiceMap
				.get(batchInstanceId);
		if (preProcessService == null) {
			synchronized (this) {
				if (preProcessService == null) {
					@SuppressWarnings("unchecked")
					Class<ErrorReportDataService> clazz = (Class<ErrorReportDataService>) Class
							.forName(serviceName);
					preProcessService = clazz.newInstance();
					preProcessorDataServiceMap.put(batchInstanceId,
							preProcessService);
				}
			}

		}
		return preProcessService;
	}

	public void clearErrorDataServiceMap(Long batchInstanceId) {
		preProcessorDataServiceMap.remove(batchInstanceId);
	}

	/**
	 * @return the preProcessorDataServiceMap
	 */
	public Map<Long, ErrorReportDataService> getPreProcessorDataServiceMap() {
		return preProcessorDataServiceMap;
	}

}
