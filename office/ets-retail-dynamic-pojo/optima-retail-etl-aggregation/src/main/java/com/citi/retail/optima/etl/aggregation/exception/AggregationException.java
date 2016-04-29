package com.citi.retail.optima.etl.aggregation.exception;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Aggregation exception is the parent (container) exception for the aggregation service.
 * 
 * @author yh43239
 *
 */
public class AggregationException extends Exception implements Serializable {
	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(AggregationException.class);
	private static final long serialVersionUID = -5315925267054880113L;
	public static final String SERVICE_NAME = "AGGREGATION";
	
	private ExceptionScope exceptionScope;
	private ExceptionType exceptionType;
	private String exceptionMessage;
	private List<AggregationExceptionItem> exceptionItems;
	
	/**
	 * Exception Type determines the type of error i.e. fatal, warning...
	 * Exception Scope determies logically where the error occurs i.e. Configuration, Runtime, Service...
	 * @param exceptionType
	 * @param exceptionScope
	 * @param exceptionMessage
	 */
	public AggregationException(ExceptionType exceptionType,ExceptionScope exceptionScope, String exceptionMessage){
		super(exceptionMessage, new Throwable(exceptionMessage));
		setExceptionType(exceptionType);
		setExceptionScope(exceptionScope);
		setExceptionMessage(exceptionMessage);
	}
	
	/**
	 * Accessor for getting the exception scope
	 * @return
	 */
	public ExceptionScope getExceptionScope() {
		return exceptionScope;
	}
	
	/**
	 * Sets the exception scope
	 * @param exceptionScope
	 */
	public void setExceptionScope(ExceptionScope exceptionScope) {
		this.exceptionScope = exceptionScope;
	}
	
	/**
	 * Gets exception type associated to the error
	 * @return
	 */
	public ExceptionType getExceptionType() {
		return exceptionType;
	}
	
	/**
	 * Sets the exception type for the error
	 * @param exceptionType
	 */
	public void setExceptionType(ExceptionType exceptionType) {
		this.exceptionType = exceptionType;
	}
	
	/**
	 * Gets the exception message
	 * @return
	 */
	public String getExceptionMessage() {
		return exceptionMessage;
	}
	
	/**
	 * Sets exception message
	 * @param exceptionMessage
	 */
	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
	
	/**
	 * This get detail information on aggregation processing 
	 * AggregationExceptionItem is used for detail aggregation processing ... 
	 * Each AggregationExceptionItem stores an exception information 
	 * @return
	 */
	public List<AggregationExceptionItem> getExceptionItems() {
		return exceptionItems;
	}
	/**
	 * Sets detail information in a whole list.
	 * @param exceptionItems
	 */
	public void setExceptionItems(List<AggregationExceptionItem> exceptionItems) {
		this.exceptionItems = exceptionItems;
	}
	
	/**
	 * Add detail exception item
	 * @param exceptionItem
	 */
	public void addExcettionItem(AggregationExceptionItem exceptionItem){
		getExceptionItems().add(exceptionItem);
	}

}
