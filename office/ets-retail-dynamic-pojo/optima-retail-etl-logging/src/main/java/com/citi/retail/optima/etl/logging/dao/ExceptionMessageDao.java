package com.citi.retail.optima.etl.logging.dao;

import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;

/**
 * @author hs73849
 * Interface for Exception Message into Database
 */
public interface ExceptionMessageDao {
	boolean saveException(OptimaRetailApplicationException optimaRetailException,String exceptionJsonString) throws Exception;	
}
