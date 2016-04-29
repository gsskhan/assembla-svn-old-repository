package com.citi.ets.publisher.service.impl;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.citi.ets.publisher.common.GenerateXMLHelper;
import com.citi.ets.publisher.domain.AlertsView;
import com.citi.ets.publisher.service.XmlDataProcessor;
import com.citi.ets.publisher.vo.XmlDataHolder;

/**
 * 
 * @author gk85985
 *
 */


@Service("xmlDataProcessor")
public class XmlDataProcessorImpl implements XmlDataProcessor{
	
	private Logger log = Logger.getLogger(XmlDataProcessorImpl.class);
	
	/** 
	 * @return - list of Object containing xml and timestamp
	 * @param list - list of alerts
	 */
	public ArrayList<XmlDataHolder> generateXML(ArrayList<AlertsView> list) throws Exception {
		ArrayList<XmlDataHolder> xmlList = new ArrayList<XmlDataHolder>();
		GenerateXMLHelper helper = new GenerateXMLHelper();
		for (AlertsView alert : list) {
			String xml = new String();
			log.info("Processing record - "+ alert);
			xml =helper.createAlertsViewXML(alert);
			log.info("Created xml successfully - " + xml);
			xmlList.add(new XmlDataHolder(xml, alert.getEventTimestamp()));
		}
		return xmlList;		
	}

}
