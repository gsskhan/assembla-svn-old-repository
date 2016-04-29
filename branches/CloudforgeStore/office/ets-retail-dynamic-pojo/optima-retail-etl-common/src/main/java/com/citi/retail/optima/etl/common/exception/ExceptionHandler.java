package com.citi.retail.optima.etl.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.MessagingException;

public class ExceptionHandler {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ExceptionHandler.class);
	private static final String APP_EXEP = "ApplicationException";
	private static final String DATA_EXEP = "DataException";

	public void handleException(
			OptimaRetailApplicationException optimaRetailApplicationException) {
		LOGGER.info(optimaRetailApplicationException.toString(), APP_EXEP);
	}

	public void handleException(
			OptimaRetailDataException optimaRetailDataException) {
		LOGGER.info(optimaRetailDataException.toString(), DATA_EXEP);
	}

	public void handleException(MessagingException exceptionObject) {
		LOGGER.error(((OptimaRetailApplicationException) exceptionObject
				.getCause()).toString(), APP_EXEP);
	}
}
