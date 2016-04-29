package com.citi.cawp.common;

import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.soap.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;

public class SoapCall {
	
	private Logger log = Logger.getLogger(this.getClass().getName());
	
	public HashMap<String, String>[]  getGDWProfile(String endpointUrl, String requestNamespace, String soapAction
			, List<String> soeidList , String firstName, String lastName){
		SOAPMessage reply = soapCallservice(endpointUrl, requestNamespace, soapAction, soeidList, firstName, lastName);
		if (reply != null) {
			return parseGDWserviceReply(reply);
		}
		return null;
	}
	
	private SOAPMessage soapCallservice(String endpointUrl, String requestNamespace, String soapAction,
			List<String> soeidList , String firstName, String lastName){
		SOAPMessage reply = null;
		try {
			SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();
            URL destination = new URL(endpointUrl);
            
         	MessageFactory messageFactory = MessageFactory.newInstance();
         	SOAPMessage message = messageFactory.createMessage();         	
         	SOAPPart soapPart = message.getSOAPPart();
			SOAPEnvelope soapEnvelope = soapPart.getEnvelope();			
            MimeHeaders mimeHeaders = message.getMimeHeaders();
            mimeHeaders.addHeader("Content-Type", "text/xml; charset=UTF-8");
            mimeHeaders.addHeader("SOAPAction", soapAction);
            SOAPHeader soapHeader = soapEnvelope.getHeader();
            soapHeader.detachNode();
            SOAPBody soapBody = soapEnvelope.getBody();
            SOAPElement bodyElement = soapBody.addChildElement("getProfile","ns1",requestNamespace);
            
            if (soeidList == null || soeidList.size() <=0 ) {
            	SOAPElement childElementWorkforceName = bodyElement.addChildElement("WorkForceName","ns1");
	        	SOAPElement childElementWorkforceFirstName = childElementWorkforceName.addChildElement("WorkForceFirstName","ns1");
	        	childElementWorkforceFirstName.addTextNode(firstName);
	        	SOAPElement childElementWorkforceLastName = childElementWorkforceName.addChildElement("WorkForceLastName","ns1");
	        	childElementWorkforceLastName.addTextNode(lastName);            	  			
    		} else {
    			for (String soeid : soeidList) {
            		SOAPElement childElementSoeIdList = bodyElement.addChildElement("SOEIDList","ns1");
            		childElementSoeIdList.addTextNode(soeid);
				} 
    		}
            message.saveChanges();            
            log.info("Request message: "+printSOAPMessageAsString(message));

            SLLUtil.doTrustCertificates(); //To be enabled for dev only
            reply = soapConnection.call(message, destination);
            log.info("Response message: "+printSOAPMessageAsString(reply));
			
            soapConnection.close();
		} catch (Exception e) {
			log.log(Level.SEVERE, "error in function callGDWservice.", e);
		}		
		return reply;		
	}
	
	public String printSOAPMessageAsString(SOAPMessage soapMessage) {
		try {
	         TransformerFactory tff = TransformerFactory.newInstance();
	         Transformer tf = tff.newTransformer();
	         String strMessage = "";
	         
	         Iterator<?> itr = soapMessage.getMimeHeaders().getAllHeaders();
	         while (itr.hasNext()) {
				MimeHeader mimeHeader = (MimeHeader) itr.next();
				strMessage = strMessage + mimeHeader.getName()+":"+mimeHeader.getValue()+"\n";				
	         } 

	         Source sc = soapMessage.getSOAPPart().getContent();
	         ByteArrayOutputStream streamOut = new ByteArrayOutputStream();
	         StreamResult result = new StreamResult(streamOut);
	         tf.transform(sc, result);
	         
	         strMessage = strMessage + streamOut.toString();
	         return strMessage;
	      } catch (Exception e) {
	    	 log.log(Level.SEVERE, "error in function printSOAPMessageAsString.", e);
	         return null;
	      } 
		
	}
	
	public String prettyPrintSOAPMessageAsString(SOAPMessage soapMessage) {
	      try {
	         TransformerFactory tff = TransformerFactory.newInstance();
	         Transformer tf = tff.newTransformer();
	         String strMessage = "";
	         
	         // Set formatting	        
	         tf.setOutputProperty(OutputKeys.INDENT, "yes");
	         tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
	         
	         Iterator<?> itr = soapMessage.getMimeHeaders().getAllHeaders();
	         while (itr.hasNext()) {
				MimeHeader mimeHeader = (MimeHeader) itr.next();
				strMessage = strMessage + mimeHeader.getName()+":"+mimeHeader.getValue()+"\n";				
	         } 

	         Source sc = soapMessage.getSOAPPart().getContent();

	         ByteArrayOutputStream streamOut = new ByteArrayOutputStream();
	         StreamResult result = new StreamResult(streamOut);
	         tf.transform(sc, result);

	         strMessage = strMessage + streamOut.toString();
	         return strMessage;
	      } catch (Exception e) {
	    	 log.log(Level.SEVERE, "error in function prettyPrintSOAPMessageAsString.", e);
	         return null;
	      }
	}
	
	@SuppressWarnings("unchecked")
	private HashMap<String, String>[] parseGDWserviceReply(SOAPMessage replyMessage){		
		try {
			SOAPBody body = replyMessage.getSOAPBody();			 
			if (body.hasFault()) {
				HashMap<String, String>[] resultMap = new HashMap[1];
				SOAPFault fault = body.getFault();				
				Iterator<SOAPElement> itr = fault.getChildElements();
				HashMap<String, String> tempMap = new HashMap<String, String>();
				String errorString = "";
				while (itr.hasNext()) {
					SOAPElement element = itr.next();
					errorString = errorString +"{"+ element.getElementName().getLocalName()+":"+element.getTextContent()+"}";				
				}
				tempMap.put("ERROR", errorString);
				resultMap[0] = tempMap;
				return resultMap;
			} else { // No fault
				Iterator<SOAPElement> itrOne = body.getChildElements();
				SOAPElement profileResponseElement = (SOAPElement)itrOne.next();
				Iterator<SOAPElement> itrTwo = profileResponseElement.getChildElements();
				SOAPElement profileElement = (SOAPElement)itrTwo.next();			

				int noOfRecords = profileElement.getChildNodes().getLength();				
				HashMap<String, String>[] resultMap = new HashMap[noOfRecords];
				
				Iterator<SOAPElement> itrFour= profileElement.getChildElements();
				int tmpNoOfRecords = 0;
				while (itrFour.hasNext()) {
					SOAPElement workforceElement = (SOAPElement) itrFour.next();
					HashMap<String, String> tmpMap = new HashMap<String, String>();
					if (workforceElement.getLocalName().equalsIgnoreCase("WorkforceDetail")) {
						tmpMap = parseWorkforceDetail(workforceElement);
						resultMap[tmpNoOfRecords] = tmpMap;
						tmpNoOfRecords ++;
					} else if (workforceElement.getLocalName().equalsIgnoreCase("WorkForceSummaryInfo")){
						tmpMap = parseWorkForceSummaryInfo(workforceElement);		
						resultMap[tmpNoOfRecords] = tmpMap;
						tmpNoOfRecords ++;
					}					
				}				
				return resultMap;
			}
		} catch (Exception e) {
			log.log(Level.SEVERE, "error in function parseGDWserviceReply.", e);
		}		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	private HashMap<String, String> parseWorkForceSummaryInfo(SOAPElement workForceSummaryInfoElement) {
		HashMap<String, String> tempMap = new HashMap<String, String>();
		Iterator<SOAPElement> itr = workForceSummaryInfoElement.getChildElements();
		while (itr.hasNext()) {
			SOAPElement soapElement = (SOAPElement) itr.next();
			tempMap.put(soapElement.getLocalName().toUpperCase(), soapElement.getTextContent());
		}
		return tempMap;
	}
	
	@SuppressWarnings("unchecked")
	private HashMap<String, String> parseWorkforceDetail(SOAPElement workforceDetailElement) {
		HashMap<String, String> tempMap = new HashMap<String, String>();
		Iterator<SOAPElement> itrOne = workforceDetailElement.getChildElements();
		while (itrOne.hasNext()) {
			SOAPElement element = (SOAPElement) itrOne.next();
			
			if (element.getLocalName().equalsIgnoreCase("PersonName")) {
				Iterator<SOAPElement> itrTwo = element.getChildElements();
				SOAPElement childOne = itrTwo.next();
				String childOneText = childOne.getTextContent();
				SOAPElement childTwo = itrTwo.next();
				String childTwoText = childTwo.getTextContent();
				tempMap.put(childOneText.toUpperCase(), childTwoText.toUpperCase());
			} else if (element.getLocalName().equalsIgnoreCase("Address")) {
				Iterator<SOAPElement> itrTwo = element.getChildElements();
				String address = "";
				while (itrTwo.hasNext()) {
					SOAPElement child = (SOAPElement) itrTwo.next();
					address = address + child.getTextContent() +" ";
				}
				tempMap.put(element.getLocalName().toUpperCase(), address.trim());
			} else if (element.getLocalName().equalsIgnoreCase("Phone")) {
				Iterator<SOAPElement> itrTwo = element.getChildElements();
				String phone = "";
				while (itrTwo.hasNext()) {
					SOAPElement child = (SOAPElement) itrTwo.next();
					phone = phone + child.getTextContent() +" ";
				}
				tempMap.put(element.getLocalName().toUpperCase(), phone.trim());
			} else if (element.getLocalName().equalsIgnoreCase("EmpRitsId")) {
				tempMap.put(element.getLocalName().toUpperCase(), element.getTextContent());
			} else if (element.getLocalName().equalsIgnoreCase("EmpGEID")) {
				tempMap.put(element.getLocalName().toUpperCase(), element.getTextContent());
			} else if (element.getLocalName().equalsIgnoreCase("MgrGEID")) {
				tempMap.put(element.getLocalName().toUpperCase(), element.getTextContent());
			} else if (element.getLocalName().equalsIgnoreCase("EmpSOEId")) {
				tempMap.put(element.getLocalName().toUpperCase(), element.getTextContent());
			} else if (element.getLocalName().equalsIgnoreCase("DeptCompany")) {
				tempMap.put(element.getLocalName().toUpperCase(), element.getTextContent());
			} else if (element.getLocalName().equalsIgnoreCase("ApexpCode")) {
				tempMap.put(element.getLocalName().toUpperCase(), element.getTextContent());
			} else if (element.getLocalName().equalsIgnoreCase("Department")) {
				tempMap.put(element.getLocalName().toUpperCase(), element.getTextContent());
			} else if (element.getLocalName().equalsIgnoreCase("DepartmentName")) {
				tempMap.put(element.getLocalName().toUpperCase(), element.getTextContent());
			} else if (element.getLocalName().equalsIgnoreCase("EmployeeType")) {
				tempMap.put(element.getLocalName().toUpperCase(), element.getTextContent());
			} else if (element.getLocalName().equalsIgnoreCase("EmployeeStatus")) {
				tempMap.put(element.getLocalName().toUpperCase(), element.getTextContent());
			} else if (element.getLocalName().equalsIgnoreCase("SourceSystem")) {
				tempMap.put(element.getLocalName().toUpperCase(), element.getTextContent());
			} else if (element.getLocalName().equalsIgnoreCase("BusinessCategory")) {
				tempMap.put(element.getLocalName().toUpperCase(), element.getTextContent());
			} else if (element.getLocalName().equalsIgnoreCase("PrimaryLoginID")) {
				tempMap.put(element.getLocalName().toUpperCase(), element.getTextContent());
			} else if (element.getLocalName().equalsIgnoreCase("Title")) {
				tempMap.put(element.getLocalName().toUpperCase(), element.getTextContent());
			} else if (element.getLocalName().equalsIgnoreCase("TerminationDate")) {
				tempMap.put(element.getLocalName().toUpperCase(), element.getTextContent());
			} else if (element.getLocalName().equalsIgnoreCase("LocationCode")) {
				tempMap.put(element.getLocalName().toUpperCase(), element.getTextContent());
			} else if (element.getLocalName().equalsIgnoreCase("EmpSAID")) {
				tempMap.put(element.getLocalName().toUpperCase(), element.getTextContent());
			} else if (element.getLocalName().equalsIgnoreCase("GOC")) {
				tempMap.put(element.getLocalName().toUpperCase(), element.getTextContent());
			} else if (element.getLocalName().equalsIgnoreCase("FCID")) {
				tempMap.put(element.getLocalName().toUpperCase(), element.getTextContent());
			} else if (element.getLocalName().equalsIgnoreCase("Email")) {
				tempMap.put(element.getLocalName().toUpperCase(), element.getTextContent());
			}		
		}		
		String extjsRadioHtml = getHTMLRadioButton(tempMap);
		String extjsCheckBoxHtml = getHTMLCheckBox(tempMap);
		tempMap.put("RADIO_HTML", extjsRadioHtml);
		tempMap.put("CHECKBOX_HTML", extjsCheckBoxHtml);
		return tempMap;
	}
	
	private String getHTMLRadioButton(HashMap<String, String> map){
		if (map == null || map.size() <=0) {
			return null;
		}
		String soeid = map.get("EmpSOEId".toUpperCase());
		if (soeid == null || soeid.length() <= 0 ) {
			return null;
		}
		String formattedText = "";
		for (String key : map.keySet()) {
			formattedText = formattedText + key +"~"+ map.get(key)+"|";
		}
		String radio = "<input name=\"selectcheck\" class=\"clsRadio\" type=\"radio\" id=\""+soeid+"\" value=\""+soeid+"\" "
				+ " onClick=\"chkRadioChange('"+formattedText+"',this)\"></input>";
		return radio;
	}

	private String getHTMLCheckBox(HashMap<String, String> map){
		if (map == null || map.size() <=0) {
			return null;
		}
		String soeid = map.get("EmpSOEId".toUpperCase());
		if (soeid == null || soeid.length() <= 0 ) {
			return null;
		}
		String formattedText = "";
		for (String key : map.keySet()) {
			formattedText = formattedText + key +"~"+ map.get(key)+"|";
		}
		String checkbox ="<input name=\"selectcheck\" class=\"clsCheckbox\" type=\"checkbox\" id=\""+soeid+"\" value=\""+soeid+"\" "
		+ " onClick=\"chkCheckboxChange('"+formattedText+"',this)\"></input>";
		return checkbox;
	}
		

}
