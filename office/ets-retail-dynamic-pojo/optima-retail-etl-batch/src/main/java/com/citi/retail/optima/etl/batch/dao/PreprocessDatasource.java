package com.citi.retail.optima.etl.batch.dao;

import java.util.List;
/**
 * 
 * @author mc56120
 *
 * @param <T>
 */

public interface PreprocessDatasource<T> {
	
	List<T> getData() throws Exception;

}
