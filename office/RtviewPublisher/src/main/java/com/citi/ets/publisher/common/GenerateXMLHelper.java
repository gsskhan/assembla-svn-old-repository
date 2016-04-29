package com.citi.ets.publisher.common;

import java.io.StringWriter;
import java.text.SimpleDateFormat;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.citi.ets.publisher.domain.AlertsView;

/**
 * 
 * @author gk85985
 * To generate XML. Sample xml -
 
 <?xml version="1.0" encoding="utf-8"?>
<p:ETSFeed xmlns:p="http://www.citi.com/ETSDashBoardResponse" 
		   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		   xsi:schemaLocation="http://www.citi.com/ETSDashBoardResponse ETSDashBoardResponse.xsd">
  <p:appdata>
    <p:csi>6684</p:csi>
    <p:appName>RAPID</p:appName>
  </p:appdata>
  <p:kpiDetail>
    <p:kpiName>FEEDS-LATE</p:kpiName>
    <p:kpiStatus statusCode="Feeds In">45</p:kpiStatus>
    <p:statusDesc>45 feeds have arrived late</p:statusDesc>
    <p:kpiparameter>fx_rates.out|Expected_Time-2014-01-15_00:00:00|Actual Arrival Time-2014-01-15_00:00:00,rapid_exchange_rates.out|Expected_Time-2014-01-15_00:00:00|Actual Arrival Time-2014-01-15_00:00:00,dolorr.dat|Expected_Time-2014-01-17_00:00:00|Actual Arrival Time-2014-01-17_00:00:00,ce_gfcid_citi_attributes.dat|Expected_Time-2014-01-17_00:00:00|Actual Arrival Time-2014-01-17_00:00:00,std_branches.out|Expected_Time-2014-01-17_00:00:00|Actual Arrival Time-2014-01-17_00:00:00,ce_gfcid_citi_attributes.dat|Expected_Time-2014-01-18_00:00:00|Actual Arrival Time-2014-01-18_00:00:00,gats.out|Expected_Time-2014-01-19_00:00:00|Actual Arrival Time-2014-01-19_00:00:00,ABC_CRMS_RAPID_20140119.psv|Expected_Time-2014-01-19_00:00:00|Actual Arrival Time-2014-01-19_00:00:00,REF_CTRY_CHOICE.TXT|Expected_Time-2014-01-16_00:00:00|Actual Arrival Time-2014-01-16_00:00:00,EERS008831.txt.1|Expected_Time-2014-01-16_00:00:00|Actual Arrival Time-2014-01-16_00:00:00,ABC_CRMS_RAPID_20140116.psv|Expected_Time-2014-01-16_00:00:00|Actual Arrival Time-2014-01-16_00:00:00,ABC_CRMS_RAPID_20140116.psv.GO|Expected_Time-2014-01-16_00:00:00|Actual Arrival Time-2014-01-16_00:00:00,fx_rates.out|Expected_Time-2014-01-16_00:00:00|Actual Arrival Time-2014-01-16_00:00:00,rapid_exchange_rates.out|Expected_Time-2014-01-16_00:00:00|Actual Arrival Time-2014-01-16_00:00:00,std_product_families.out|Expected_Time-2014-01-16_00:00:00|Actual Arrival Time-2014-01-16_00:00:00,std_branches.out|Expected_Time-2014-01-16_00:00:00|Actual Arrival Time-2014-01-16_00:00:00,ABC_CRMS_RAPID_20140117.psv|Expected_Time-2014-01-17_00:00:00|Actual Arrival Time-2014-01-17_00:00:00,ABC_CRMS_RAPID_20140117.psv.GO|Expected_Time-2014-01-17_00:00:00|Actual Arrival Time-2014-01-17_00:00:00,EERS008831.txt.1|Expected_Time-2014-01-17_00:00:00|Actual Arrival Time-2014-01-17_00:00:00,EERS006684.txt.1|Expected_Time-2014-01-16_00:00:00|Actual Arrival Time-2014-01-16_00:00:00,EERS006684.txt.1|Expected_Time-2014-01-17_00:00:00|Actual Arrival Time-2014-01-17_00:00:00,fx_rates.out|Expected_Time-2014-01-17_00:00:00|Actual Arrival Time-2014-01-17_00:00:00,std_product_families.out|Expected_Time-2014-01-18_00:00:00|Actual Arrival Time-2014-01-18_00:00:00,ABC_CRMS_RAPID_20140118.psv.GO|Expected_Time-2014-01-18_00:00:00|Actual Arrival Time-2014-01-18_00:00:00,ABC_CRMS_RAPID_20140118.psv|Expected_Time-2014-01-18_00:00:00|Actual Arrival Time-2014-01-18_00:00:00,SLS_CREDIT_LIMITS.TXT|Expected_Time-2014-01-18_00:00:00|Actual Arrival Time-2014-01-18_00:00:00,dolorr.dat|Expected_Time-2014-01-19_00:00:00|Actual Arrival Time-2014-01-19_00:00:00,SLS_CREDIT_LIMITS.TXT|Expected_Time-2014-01-19_00:00:00|Actual Arrival Time-2014-01-19_00:00:00,REF_CHOICE.TXT|Expected_Time-2014-01-19_00:00:00|Actual Arrival Time-2014-01-19_00:00:00,REF_CTRY_CHOICE.TXT|Expected_Time-2014-01-19_00:00:00|Actual Arrival Time-2014-01-19_00:00:00,ABC_CRMS_RAPID_20140119.psv.GO|Expected_Time-2014-01-19_00:00:00|Actual Arrival Time-2014-01-19_00:00:00,EERS008831.txt.1|Expected_Time-2014-01-19_00:00:00|Actual Arrival Time-2014-01-19_00:00:00,EERS006684.txt.1|Expected_Time-2014-01-19_00:00:00|Actual Arrival Time-2014-01-19_00:00:00,rapid_exchange_rates.out|Expected_Time-2014-01-19_00:00:00|Actual Arrival Time-2014-01-19_00:00:00,ce_gfcid_citi_attributes.dat|Expected_Time-2014-01-19_00:00:00|Actual Arrival Time-2014-01-19_00:00:00,std_branches.out|Expected_Time-2014-01-19_00:00:00|Actual Arrival Time-2014-01-19_00:00:00,ce_gfcid_citi_attributes.dat|Expected_Time-2014-01-15_00:00:00|Actual Arrival Time-2014-01-15_00:00:00,std_branches.out|Expected_Time-2014-01-15_00:00:00|Actual Arrival Time-2014-01-15_00:00:00,std_product_families.out|Expected_Time-2014-01-15_00:00:00|Actual Arrival Time-2014-01-15_00:00:00,ce_gfcid_citi_attributes.dat|Expected_Time-2014-01-16_00:00:00|Actual Arrival Time-2014-01-16_00:00:00,SLS_CREDIT_LIMITS.TXT|Expected_Time-2014-01-17_00:00:00|Actual Arrival Time-2014-01-17_00:00:00,REF_CHOICE.TXT|Expected_Time-2014-01-17_00:00:00|Actual Arrival Time-2014-01-17_00:00:00,REF_CTRY_CHOICE.TXT|Expected_Time-2014-01-17_00:00:00|Actual Arrival Time-2014-01-17_00:00:00,std_branches.out|Expected_Time-2014-01-18_00:00:00|Actual Arrival Time-2014-01-18_00:00:00,fx_rates.out|Expected_Time-2014-01-19_00:00:00|Actual Arrival Time-2014-01-19_00:00:00</p:kpiparameter>
    <p:eventtimestamp>2014-01-24_23:59:56</p:eventtimestamp>
  </p:kpiDetail>
 </p:ETSFeed> 
 */

public class GenerateXMLHelper {
	
	private Logger log = Logger.getLogger(GenerateXMLHelper.class);
	
	public String createAlertsViewXML(AlertsView alerts) throws ParserConfigurationException, TransformerException {
		
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = docBuilderFactory.newDocumentBuilder();
		Document doc = documentBuilder.newDocument();
		doc.setXmlStandalone(true);
		
		Element root = doc.createElement("p:ETSFeed");
		root.setAttribute("xmlns:p", "http://www.citi.com/ETSDashBoardResponse");
		root.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
		root.setAttribute("xsi:schemaLocation", "http://www.citi.com/ETSDashBoardResponse ETSDashBoardResponse.xsd");
		doc.appendChild(root);
		
		Element appdataElement = doc.createElement("p:appdata");
		root.appendChild(appdataElement);
			Element appCsiElement = doc.createElement("p:csi");
			appCsiElement.appendChild(doc.createTextNode( Long.toString(alerts.getCsiId())));
			appdataElement.appendChild(appCsiElement);
			
			Element appNameElement = doc.createElement("p:appName");
			String appName = (alerts.getShortname() == null ) ? "":alerts.getShortname();
			appNameElement.appendChild(doc.createTextNode(appName));
			appdataElement.appendChild(appNameElement);
			
		Element kpiDetailElement = doc.createElement("p:kpiDetail");
		root.appendChild(kpiDetailElement);
			Element kpiNameElement = doc.createElement("p:kpiName");
			String kpiName = (alerts.getComponent() == null ) ? "":alerts.getComponent();
			kpiNameElement.appendChild(doc.createTextNode(kpiName));
			kpiDetailElement.appendChild(kpiNameElement);
			
			Element kpistatusElement = doc.createElement("p:kpiStatus");
			kpistatusElement.setAttribute("statusCode", "INFRASTRUCTURE");
			String value = (alerts.getAlertValue() == null ) ? "": alerts.getAlertValue();
			value = (alerts.getCleared() ==1)? "0": value;
			kpistatusElement.appendChild(doc.createTextNode(value));
			kpiDetailElement.appendChild(kpistatusElement);
			
			Element statusDescElement = doc.createElement("p:statusDesc");
			String desc = (alerts.getAppDescription() ==null) ? "": alerts.getAppDescription();
			desc = (alerts.getCleared() == 1) ? "Alert cleared.": desc;
			statusDescElement.appendChild(doc.createTextNode(desc));
			kpiDetailElement.appendChild(statusDescElement);
			
			Element kpiParamElement = doc.createElement("p:kpiparameter");
			String kpiParameter = (alerts.getKpi()==null)?"":alerts.getKpi();
			kpiParamElement.appendChild(doc.createTextNode(kpiParameter));
			kpiDetailElement.appendChild(kpiParamElement);
		
			Element eventTimestampElement = doc.createElement("p:eventtimestamp");
			String eventTimestamp = "";
			try {
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
				eventTimestamp  = df.format(alerts.getEventTimestamp());				
			} catch (Exception e) {
				log.warn("Couldn't parse EventTimestamp for creating xml, setting default value." + e.getMessage());
			}
			eventTimestampElement.appendChild(doc.createTextNode(eventTimestamp));
			kpiDetailElement.appendChild(eventTimestampElement);
			
		
		// write xml
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		//transformer.setOutputProperty(OutputKeys.INDENT ,"yes");
		DOMSource domSource = new DOMSource(doc);
		StringWriter outWriter = new StringWriter();
		StreamResult result = new StreamResult(outWriter);
		transformer.transform(domSource, result);
		String xmlout = outWriter.toString();
		return xmlout;
		
	}
	

}
