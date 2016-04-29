package com.citi.retail.optima.etl.controller.message.handler;

import org.springframework.integration.Message;

import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.controller.model.MessageLog;

/**
 * @author hs73849
 *
 */
public interface MessageHandler {
	Message<MessageLog> handleMessage(Message<String> message) throws OptimaRetailApplicationException;
}
