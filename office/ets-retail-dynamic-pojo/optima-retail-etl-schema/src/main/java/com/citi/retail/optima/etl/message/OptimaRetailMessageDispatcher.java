package com.citi.retail.optima.etl.message;

/**
 * This class is responsible to handle message dispatching
 * 
 * @author ns21567
 * 
 */
public interface OptimaRetailMessageDispatcher {

	/**
	 * Method providing functionality to dispatch event to a given queue.
	 * 
	 * @param queueName
	 * @param event
	 * @return
	 */
	void dispatchMessage(String queueName, Object event)
			throws Exception;

}
