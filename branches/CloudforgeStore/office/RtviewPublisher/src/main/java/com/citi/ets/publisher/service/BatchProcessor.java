package com.citi.ets.publisher.service;

import java.util.ArrayList;

import com.citi.ets.publisher.domain.AlertsView;

/**
 * 
 * @author gk85985
 *
 */

public interface BatchProcessor {
	
	public ArrayList<AlertsView> process() throws Exception;	


}
