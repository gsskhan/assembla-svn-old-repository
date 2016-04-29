package com.citi.ets.publisher.common;

import java.sql.Timestamp;

/**
 * 
 * @author gk85985
 *
 */

public class ProcessInstance {
	
	private static Timestamp timeLastProcessed;
	
	public static Timestamp getTimeLastProcessed() {
		return timeLastProcessed;
	}
	public static void setTimeLastProcessed(Timestamp timeLastProcessed) {
		ProcessInstance.timeLastProcessed = timeLastProcessed;
	}

}
