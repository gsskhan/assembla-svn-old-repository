/**
 * 
 */
package com.citi.retail.optima.etl.common.log;

/**
 * To publish the exception as message to JMS queue. Currently only Exception
 * object can be published as message.
 * 
 * @author gv74035
 * 
 */
public interface LoggingPublisher<T> {

	void publish(T data);
}
