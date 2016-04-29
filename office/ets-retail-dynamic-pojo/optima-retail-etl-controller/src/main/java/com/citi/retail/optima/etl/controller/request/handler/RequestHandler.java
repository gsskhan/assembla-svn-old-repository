package com.citi.retail.optima.etl.controller.request.handler;

import org.springframework.integration.Message;

import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.controller.model.MessageLog;
import com.citi.retail.optima.etl.controller.model.RequestMessageType;
import com.citi.retail.optima.xsd.internal.OptimaRetailETLEvent;

/**
 * @author hs73849
 *
 */
public interface RequestHandler<T> {
	RequestMessageType handleRequest(Message<T> message) throws OptimaRetailApplicationException;
}
