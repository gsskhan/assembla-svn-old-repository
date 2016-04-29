package org.dms.web.bo.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.dms.web.bo.ConstantsService;
import org.dms.web.core.PdfUtil;
import org.dms.web.dao.GenericDao;
import org.dms.web.entity.Constants;
import org.dms.web.exception.DmsRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

public class ConstantsServiceImpl implements ConstantsService {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private GenericDao genericDao;
	
	private Map<String, Object> hqlparam = new HashMap<String, Object>();
	private String msg = "";

	@Override
	public String addNewConstant(String variableName, int variableId, String value, int parentVariableId){		
		try {
			Constants cons = new Constants(variableName, variableId, value, parentVariableId);
			int retId = (Integer) genericDao.saveEntity(cons);	
			log.info("Saved ... "+ cons);
			msg = "New record saved successfully with id = "+ retId+".";
		} catch (Exception e){
			msg = "Error in saving. Message - " + e.getMessage();
			log.error(msg, e);			
		}				
		return msg;
	}
	

	@Override
	public List<Constants> findAllConstantsForVariable(String variable) {
		try {
			if (StringUtils.isEmpty(variable)) {
				log.warn("For finding constants, supplied variable is null or empty. [ "+variable+" ]");
			} else {
				List<Constants> tmpList = genericDao.getList(" from Constants where variable like '%"+variable+"%' ", null, 10000);
				if (tmpList != null && !tmpList.isEmpty()) {					
					return tmpList;
				}
			}			
		} catch (Exception e) {
			log.error("Error in finding constants.", e);
		}
		return new ArrayList<Constants>();		
	}
	

	@Override
	public List<Constants> findAllConstants() {
		try {
			List<Constants> tmpList = genericDao.getListWhereEq(Constants.class, null, 10000);
			return tmpList;
		} catch (DmsRuntimeException e) {
			log.error("Error in fetching all constants records from db.", e);
		}
		return new ArrayList<Constants>();	
	}

	
	
	@Override
	public List<String> findAllValuesForVariable(String variable) {
		List<String> tmpList = new ArrayList<String>();
		try {			
			hqlparam.clear();
			hqlparam.put("var", variable);
			tmpList = genericDao.getList("select distinct value from Constants where variable = :var ", hqlparam, 10000);
		} catch (Exception e) {
			log.error("Problem in getting value of Constants for variable = '"+variable+"' .", e);
		}
		return tmpList;
	}

	@Override
	public List<String> findAllVariableNames() {
		List<String> tmpList = new ArrayList<String>();
		try {
			tmpList = genericDao.getList("select distinct variable from Constants", null, 10000);
		} catch (Exception e) {
			log.error("Problem in getting all varaible names LOVs.",e);
		}
		return tmpList;
	}

	@Override
	public String removeConstant(int constantId){		
		try {
			hqlparam.clear();
			hqlparam.put("cid", constantId);
			int noOfRows = genericDao.delete(" delete from Constants where constantId =:cid ", hqlparam);
			msg = "Delete completed... No. of rows(s) affected = "+ noOfRows;
		} catch (Exception e) {
			msg = "Error in deleting constants, message - " +e.getMessage();
			log.error(msg, e);
		}
		return msg;
	}
	

	@Override
	public Constants findConstants(int constantId) {
		hqlparam.clear();
		hqlparam.put("constantId", constantId);
		Constants cons = genericDao.getEntityWhereEq(Constants.class, hqlparam ); 
		log.info("found ... " + cons);
		return cons;
	}
	
	@Override
	public String updateConstants(int constantId, String variableName,
			int variableId, String value, int parentVariableId) {
		try {
			Constants tempConstantObj = new Constants(variableName,variableId,value,parentVariableId);
			tempConstantObj.setConstantId(constantId);
			boolean status = genericDao.updateEntity(tempConstantObj);
			msg = (status==true) ? "Successfully updated modified record to db, "+ tempConstantObj+".":"Couldn't update modified record to db. ";
		} catch (Exception e) {
			msg = "Error in updating modified constant record to db. "+ e.getMessage();			
			log.error(msg, e);
		}
		return msg;
	}

	@Override
	public byte[] buildPdfListOfAllConstants() {
		try (ByteArrayOutputStream os = new ByteArrayOutputStream()){
			Document document = new Document(PageSize.LETTER, 50, 50, 50, 50);
			PdfWriter.getInstance(document, os);
			document.open();
			PdfUtil.addHeader(document);
			String[] tableColumnNames = {"ID","VARIABLE","VARIABLE ID","VALUE","PARENT VARIABLE ID"};
			List<ArrayList<Object>> tabdatalist = new LinkedList<ArrayList<Object>>();
			List<Constants> constList = findAllConstants();
			for (Constants con : constList) {
				ArrayList<Object> rowdata = new ArrayList<Object>();
				rowdata.add(con.getConstantId());
				rowdata.add(con.getVariable());
				rowdata.add(con.getVariableId());
				rowdata.add(con.getValue());
				rowdata.add(con.getParentVariableId());
				tabdatalist.add(rowdata);
			}						
			PdfUtil.addTable(document, "All constants", 5,tableColumnNames , tabdatalist);
			document.close();
			log.info("pdf built.");
			return os.toByteArray();
		} catch (DocumentException | IOException e) {
			log.error("error in creating pdf.", e);
		}		
		return null;
	}
	
	// getter-setter methods
	public GenericDao getGenericDao() {
		return genericDao;
	}
	public void setGenericDao(GenericDao genericDao) {
		this.genericDao = genericDao;
	}


}
