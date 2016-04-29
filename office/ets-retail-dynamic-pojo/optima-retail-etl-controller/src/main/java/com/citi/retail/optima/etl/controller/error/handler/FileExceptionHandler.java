package com.citi.retail.optima.etl.controller.error.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.MessagingException;

import com.citi.retail.optima.etl.common.exception.ExceptionHandler;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.controller.file.mover.FileMoverUtility;

/**
 * This class handles moving of cntl and data files to error directory when any exception occurs in controller.
 * @author mc56120
 *
 */
public class FileExceptionHandler {
	
	private ExceptionHandler exceptionHandler;
	private FileMoverUtility fileMovementUtlity;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(FileExceptionHandler.class);
/*	private static final String APP_EXEP = "ApplicationException";
	private static final String DATA_EXEP = "DataException";
*/
	
	/**
	 * 
	 * @param optimaRetailApplicationException
	 */
	public void handleException(
			OptimaRetailApplicationException optimaRetailApplicationException)  {
		try {
			fileMovementUtlity.moveFileForRequestLog(optimaRetailApplicationException.getRequestLogId(), "FAILED");
		} catch (OptimaRetailApplicationException e) {
			exceptionHandler.handleException(e);	
		}
		exceptionHandler.handleException(optimaRetailApplicationException);		
	}

	/**
	 * 
	 * @param exceptionObject
	 */
	public void handleException(MessagingException exceptionObject) {
		handleException(((OptimaRetailApplicationException) exceptionObject
				.getCause()));	
	}

	/**
	 * 
	 * @param exceptionHandler the exceptionHandler to set
	 */
	public void setExceptionHandler(ExceptionHandler exceptionHandler) {
		this.exceptionHandler = exceptionHandler;
	}

	/**
	 * @param fileMovementUtlity the fileMovementUtlity to set
	 */
	public void setFileMovementUtlity(FileMoverUtility fileMovementUtlity) {
		this.fileMovementUtlity = fileMovementUtlity;
	}
	
}
