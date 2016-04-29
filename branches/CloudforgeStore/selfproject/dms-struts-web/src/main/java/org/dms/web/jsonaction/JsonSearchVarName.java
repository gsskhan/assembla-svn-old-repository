package org.dms.web.jsonaction;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.dms.web.bo.ConstantsService;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;


public class JsonSearchVarName extends ActionSupport{

	private static final long serialVersionUID = -6533942340403604575L;
	private Logger log = Logger.getLogger(JsonSearchVarName.class);
	
	private List<String> varNamesList;
	
	@Autowired
	private ConstantsService constantsService;
	
	public String execute() {
		log.info("Begin finding all VARIABLE NAMES");
		this.clearErrorsAndMessages();
		
		List<String> tempList = new ArrayList<String>();
		try {
			tempList = constantsService.findAllVariableNames();
			this.varNamesList = tempList;	
			log.info("Returned VariableList = " + varNamesList);
		} catch (Exception e) {
			this.addActionError("Problem getting data for search. MESSAGE:- "+ e.getMessage());
			log.error("Error in JsonSearchVarName.class -> execute() method.", e);
			return ERROR;
		}
		log.info("Finished finding all VARIABLE NAMES, list = " + tempList);		
		return SUCCESS;
	}
	
	public String getJSON() {
    	log.info("Processing getJSON() method in JsonSearchVarName class.");
    	return execute();		
    }
	
	// getter-setter methods
	
	public List<String> getVarNamesList() {
		return varNamesList;
	}
	public void setVarNamesList(List<String> varNamesList) {
		this.varNamesList = varNamesList;
	}
}
