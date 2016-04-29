package com.citi.retail.optima.etl.aggregation.exception;

import java.io.Serializable;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * This is a detail error class that holds detail error on aggregation.
 * It is a simple wrapper that wraps a hash map to allow service to 
 * add error of any type...
 * @author yh43239
 *
 */
public class AggregationExceptionItem implements Serializable {
	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(AggregationExceptionItem.class);
	private static final long serialVersionUID = -5315925267054880113L;
    private HashMap<String,HashMap<String,String>> exceptionsDetail = new HashMap<String,HashMap<String,String>>();
    //gives a range of possible known errors t
    //This approach also give the service the ability to have free range on the type of error
    //desired to expose.
    public enum KeyDefnition{
    	ROW_ID,
    	FIELD_NAME,
    	FIELD_POSITION,
    	USER_MESSAGE,
    	ERROR_MESSAGE,
    	STACKTRACE,
    	RULE_ID,
    	RULE,
    	EXCEPTION_TYPE,
    	EXCEPTION_SCOPE
    }
    /**
     * gets a hashmap of hashmap with gives one to many relations on errors
     * ie. a field with multiple error and each error has multiple stacktrace....
     * @return
     */
	public HashMap<String, HashMap<String, String>> getExceptionsDetail() {
		return exceptionsDetail;
	}
	
	/**
	 * Sets an error detail
	 * @param exceptionsDetail
	 */
	public void setExceptionsDetail(
			HashMap<String, HashMap<String, String>> exceptionsDetail) {
		this.exceptionsDetail = exceptionsDetail;
	}
	
	
}
