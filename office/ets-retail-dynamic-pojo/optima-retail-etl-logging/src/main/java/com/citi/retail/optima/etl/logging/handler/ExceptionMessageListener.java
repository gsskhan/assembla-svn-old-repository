package com.citi.retail.optima.etl.logging.handler;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import ch.qos.logback.classic.spi.LoggingEventVO;

import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;
import com.citi.retail.optima.etl.common.log.LoggingMarker;
import com.citi.retail.optima.etl.logging.dao.ExceptionMessageDao;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author hs73849 Listener for Receiving the Exception Message from Broker
 */
public class ExceptionMessageListener {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ExceptionMessageListener.class);

	private ExceptionMessageDao exceptionMessageDao;
	private ObjectMapper mapper = new ObjectMapper();

	public boolean exceptionHandler(
			OptimaRetailApplicationException optimaRetailException,
			String exceptionJsonString) {
		MDC.put("LogFileName", "ExceptionHandler");
		try {
			if (optimaRetailException == null) {
				LOGGER.info("Exception should not be null");
				throw new Exception("Exception should not be null");
			}
			if (optimaRetailException.getExceptionType() == null) {
				LOGGER.info(" Exception Type should not be null");

				optimaRetailException.setExceptionType(ExceptionType.ERROR);
			}

			handleExceptionType(optimaRetailException, exceptionJsonString);
		} catch (Exception e) {
			LOGGER.info("Error in Exception Handler "
					+ OptimaRetailExceptionUtil.getStackTrace(e));
			return false;
		}
		return true;
	}

	public boolean exceptionHandler(LoggingEventVO loggingEventVO) {

		OptimaRetailApplicationException optimaRetailException = null;

		try {
			if (loggingEventVO.getArgumentArray()[0].toString().endsWith(
					"DataException")) {
				optimaRetailException = mapper.readValue(
						loggingEventVO.getMessage(),
						OptimaRetailApplicationException.class);
			} else if (loggingEventVO.getArgumentArray()[0].toString()
					.endsWith("ApplicationException")) {
				optimaRetailException = mapper.readValue(
						loggingEventVO.getMessage(),
						OptimaRetailApplicationException.class);
			}

		} catch (JsonParseException e) {
			LOGGER.info("Error while Json Parsing "
					+ OptimaRetailExceptionUtil.getStackTrace(e));
		} catch (JsonMappingException e) {
			LOGGER.info("Error while Json Mapping "
					+ OptimaRetailExceptionUtil.getStackTrace(e));
		} catch (IOException e) {
			LOGGER.info("Error in IO "
					+ OptimaRetailExceptionUtil.getStackTrace(e));
		}
		return exceptionHandler(optimaRetailException,
				loggingEventVO.getMessage());
	}

	private void handleExceptionType(
			OptimaRetailApplicationException optimaRetailException,
			String exceptionJsonString) throws Exception {
		ExceptionType exceptionType = optimaRetailException.getExceptionType();

		switch (exceptionType) {
		case FATAL:
			saveException(optimaRetailException, exceptionJsonString);
			sendSmtp(exceptionJsonString);
			break;
		case SKIPPABLE:
			saveException(optimaRetailException, exceptionJsonString);
			break;
		case ERROR:
			saveException(optimaRetailException, exceptionJsonString);
			break;
		case WARNING:
			saveException(optimaRetailException, exceptionJsonString);
			break;
		default:
			saveException(optimaRetailException, exceptionJsonString);
			break;
		}

	}

	private void saveException(OptimaRetailApplicationException optimaRetailException,
			String exceptionJsonString) throws Exception {
		exceptionMessageDao.saveException(optimaRetailException,
				exceptionJsonString);
	}

	private void sendSmtp(String exceptionJsonString) {
		LOGGER.error(LoggingMarker.SMTP.getMarker(), exceptionJsonString);
	}

	public void setExceptionMessageDao(ExceptionMessageDao exceptionMessageDao) {
		this.exceptionMessageDao = exceptionMessageDao;
	}

	public ExceptionMessageDao getExceptionMessageDao() {
		return exceptionMessageDao;
	}
}
