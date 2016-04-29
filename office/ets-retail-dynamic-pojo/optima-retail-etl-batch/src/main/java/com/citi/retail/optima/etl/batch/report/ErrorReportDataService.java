/**
 * 
 */
package com.citi.retail.optima.etl.batch.report;

import java.util.List;
import java.util.Map;

import com.citi.retail.optima.etl.common.exception.OptimaRetailDataException;

/**
 * @author mc56120
 * @param <T>
 * 
 */
public interface ErrorReportDataService {
	Map<String, OptimaRetailDataException> getLocalErrorDataServiceMap(
			String partitonInfo);

	List<String> getLocalErrorDataServiceList(String partitonInfo);

}
