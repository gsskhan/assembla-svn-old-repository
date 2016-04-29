package com.citi.cawp.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CitiUsersProfile {
	
	private Logger log = Logger.getLogger(this.getClass().getName());
	
	@SuppressWarnings("unchecked")
	public HashMap<String, String>[] getUserProfile(String endpointUrl, String requestNamespace, 
			String soapAction, String soeidList, String firstName, String lastName){		
		HashMap<String, String>[] errresult = new HashMap[1];
		String message ="";
		try {
			log.info("called getProfile with endpointurl="+ endpointUrl+",requestNamespace="+requestNamespace
					+",soapAction="+soapAction+",soeidList="+soeidList+",firstName="+firstName+",lastName="+lastName);
			if (!validateInParams(endpointUrl, requestNamespace, soapAction, buildList(soeidList), firstName, lastName)) {
				return null;
			}
			SoapCall soapCall = new SoapCall();
			return soapCall.getGDWProfile(endpointUrl, requestNamespace, soapAction, buildList(soeidList), firstName, lastName);
		} catch (Exception e) {
			message = "Error in getting GDW data. " + e.getMessage();	
			errresult[0] = new HashMap<String, String>();
			errresult[0].put("ERROR", message);
			log.log(Level.SEVERE, message, e);
		}
		return errresult;		
	}
	
	 private List<String> buildList(String soeids){
	    List<String> soeidList = new ArrayList<String>();
	    if (soeids == null) {
	      return soeidList;
	    }
	    StringTokenizer tokenizer = new StringTokenizer(soeids," ,");
	    while (tokenizer.hasMoreTokens()) {
	      soeidList.add(tokenizer.nextToken());
	    }
	    return soeidList;
	  }
	
	private boolean validateInParams(String endpointUrl, String requestNamespace, String soapAction, 
			List<String> soeidList, String firstName, String lastName){
		if (endpointUrl == null || endpointUrl.length() <=0 ) {
			log.severe("endpointUrl is null or empty.");
			return false;
		}
		if (requestNamespace == null || requestNamespace.length() <=0 ) {
			log.severe("requestNamespace is null or empty.");
			return false;
		}
		if (soapAction == null || soapAction.length() <=0 ) {
			log.severe("requestNamespace is null or empty.");
			return false;
		}
		if (soeidList == null || soeidList.size() <=0 ) {
			if((firstName == null || firstName.length() <= 0) || (lastName == null || lastName.length() <= 0)){
				log.severe("Either or all of soeidList, firstname and lastname is null or empty.");	
				return false;
			}
		} 
		return true;
	} 

}
