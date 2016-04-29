package com.citi.retail.optima.etl.integration.test.message.handler;

import org.springframework.integration.Message;

import com.citi.retail.optima.etl.integration.test.model.MessageLog;

/**
 * @author hs73849
 *
 */
public interface MessageHandler {
	
	Message<MessageLog>  handleMessage(Message<String> message) throws Exception;
	
	void handleRequestMessage(Message<MessageLog> requestMessage) throws Exception;
	
	void newJobRequestMessage(Message<MessageLog> requestMessage) throws Exception;
}
