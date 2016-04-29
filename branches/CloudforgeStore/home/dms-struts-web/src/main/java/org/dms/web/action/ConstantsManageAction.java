package org.dms.web.action;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.dms.web.bo.ConstantsService;
import org.dms.web.document.Constants;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

public class ConstantsManageAction extends ActionSupport implements ServletRequestAware {

	private static final long serialVersionUID = -7922651409954732630L;	
	private Logger log =  Logger.getLogger(ConstantsManageAction.class);
	
	private InputStream fileInputStream;
	
	// Fields primarily for adding/editing/deleting constants
	private String constantId;
	private String varname;
	private int varid;
	private String value;
	private int varparentid;
	
	@Autowired
	private ConstantsService constantsService;
	
	// For searching constants.
	private String searchkeyword;
	private List<Constants> searchResultList;

	private HttpServletRequest request;
	private String msg = "";
	
	public String addConstant(){
		this.clearErrorsAndMessages();	
		msg = constantsService.addNewConstant(varname, varid, value, varparentid);
		this.addActionMessage(msg);
		// clear the form.
		clearAdditionForm();
		return SUCCESS;
	}
	
	public String searchConstants(){
		searchResultList = constantsService.findAllConstantsForVariable(searchkeyword);
		return SUCCESS;
	}
	
	public String deleteConstant(){
		this.clearErrorsAndMessages();
		String tempConstantIdString = request.getParameter("constId"); // 'constId value is received from HttpServletRequest'
		msg = constantsService.removeConstant(tempConstantIdString);		
		this.addActionMessage(msg);
		log.info(msg);
		return SUCCESS;
	}

	public String setConstants(){
		try {
			this.clearErrorsAndMessages();
			// get the constId from HttpServletRequest
			String tempConstantId = request.getParameter("constId");
			Constants cons = constantsService.findConstants(tempConstantId);
			request.setAttribute("oldconstant", cons);
			msg = "Please edit required feilds and press 'Modify'.";
		} catch (Exception e) {
			msg ="Error in setting 'Constants' record to HttpServletRequest.";
			log.error(msg, e);
			this.addActionError(msg);
			return ERROR;
		}		
		this.addActionMessage(msg);
		return SUCCESS;
	}
	
	public String getPdfReportForAllConstants(){
		byte[] bytebuf = constantsService.buildPdfListOfAllConstants();
		fileInputStream = new ByteArrayInputStream(bytebuf);
		log.info("created and set to stream a report(.pdf) of all constants from db ...");
		return SUCCESS;
	}
	
	public String editConstants(){
		msg = constantsService.updateConstants(constantId, varname, varid, value, varparentid);
		this.addActionMessage(msg);
		log.info(msg);
		return SUCCESS;
	}
	
	private void clearAdditionForm(){
		this.varname="";
		this.varid=0;
		this.value="";
		this.varparentid=0;
	}
		
	@Override
	public void validate() {
		this.clearErrorsAndMessages();
		if (varname == null || varname.length() == 0) {
			this.addActionError("Variable name cannot be empty.");
		}
		if (varid <= 0 ){
			this.addActionError("Variable Id cannot be zero or negative");
		}
		if (value == null || value.length() == 0) {
			this.addActionError("Value cannot be empty.");
		}
		if (varparentid < 0 ){
			this.addActionError("Variable parent Id cannot be negative");
		}		
	}
	
	// getter - setters methods
	@Override
	public void setServletRequest(HttpServletRequest req) {
		this.request = req;		
	}
	public String getConstantId() {
		return constantId;
	}
	public void setConstantId(String constantId) {
		this.constantId = constantId;
	}	
	public String getVarname() {
		return varname;
	}
	public void setVarname(String varname) {
		this.varname = varname;
	}
	public int getVarid() {
		return varid;
	}
	public void setVarid(int varid) {
		this.varid = varid;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public int getVarparentid() {
		return varparentid;
	}
	public void setVarparentid(int varparentid) {
		this.varparentid = varparentid;
	}
	public String getSearchkeyword() {
		return searchkeyword;
	}
	public void setSearchkeyword(String searchkeyword) {
		this.searchkeyword = searchkeyword;
	}
	public List<Constants> getSearchResultList() {
		return searchResultList;
	}
	public void setSearchResultList(List<Constants> searchResultList) {
		this.searchResultList = searchResultList;
	}
	public ConstantsService getConstantsService() {
		return constantsService;
	}
	public void setConstantsService(ConstantsService constantsService) {
		this.constantsService = constantsService;
	}
	public InputStream getFileInputStream() {
		return fileInputStream;
	}
}
