package com.citi.ets.publisher.service;

import java.util.ArrayList;

import com.citi.ets.publisher.domain.AlertsView;
import com.citi.ets.publisher.vo.XmlDataHolder;

/**
 * 
 * @author gk85985
 *
 */

public interface XmlDataProcessor {
	
	public ArrayList<XmlDataHolder> generateXML(ArrayList<AlertsView> list) throws Exception;

}
