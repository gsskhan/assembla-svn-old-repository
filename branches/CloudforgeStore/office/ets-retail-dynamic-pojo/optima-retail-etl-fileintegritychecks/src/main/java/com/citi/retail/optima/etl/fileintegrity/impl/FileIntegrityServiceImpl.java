package com.citi.retail.optima.etl.fileintegrity.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


import com.citi.retail.optima.etl.fileintegrity.FileIntegrityService;
import com.citi.retail.optima.etl.fileintegrity.common.ColumnRules;
import com.citi.retail.optima.etl.fileintegrity.common.FileUtil;
import com.citi.retail.optima.etl.fileintegrity.common.FileValidationRules;
import com.citi.retail.optima.etl.fileintegrity.constants.FileIntegrityConstants;
import com.citi.retail.optima.etl.fileintegrity.exception.ExceptionType;
import com.citi.retail.optima.etl.fileintegrity.exception.FieldError;
import com.citi.retail.optima.etl.fileintegrity.exception.FileIntegrityDataException;

public class FileIntegrityServiceImpl implements FileIntegrityService{ 
	
	private FileValidationRules rules;	
	
	Set<String> duplicateRows; 
	
	public FileIntegrityServiceImpl() {
		duplicateRows = new HashSet<String>();
	}
	
	public FileIntegrityServiceImpl(FileValidationRules rules) {
		this.rules =rules;
		this.duplicateRows = new HashSet<String>();
		if(FileUtil.isEmpty(rules.getRegExString().toString())){
			rules.prepareObject();
		}
	}


	public boolean validate(String lineInput, int rowNum) throws FileIntegrityDataException {
		
		List<FieldError> fieldErrors = new ArrayList<FieldError>();
		boolean isValid = true;		
		if(rules==null){
			isValid = false;
			fieldErrors.add(createErrorForMsg("Rules not loaded properly",rowNum));
		}
		String line = removeSpacesAndQuotes(lineInput);
		if(line == null){
			isValid = false;
			fieldErrors.add(createErrorForMsg("Line cannot be null",rowNum));
		}else{
			if (validDelimiters(line)) {
				if (rowNum == 0) {
					if (!validHeaders(line)){
						isValid = false;					
						fieldErrors.add(createErrorForType(FileIntegrityConstants.ERROR_HEADER_INVALID,
								rowNum));
					}
				} else {
					try{
						if (isLineDuplicate(line,duplicateRows)) {
							isValid = false;
							fieldErrors.add(createErrorForType(FileIntegrityConstants.ERROR_DUPLICATE_ROW,
									 rowNum));
						}
					} catch (FileIntegrityDataException e){
						isValid = false;
						fieldErrors.add(createErrorForType(FileIntegrityConstants.ERROR_CLMN_COUNT,
								 rowNum));
					}
					if(!validDataType(line)){
						isValid = false;
						fieldErrors.addAll(createAllErrorsForDataType(line,rowNum));
					}
				}
			} else {
				isValid = false;
				fieldErrors.add(createErrorForType(FileIntegrityConstants.ERROR_CLMN_COUNT,rowNum));
			}
		}	
		if(!isValid){			
			throw new FileIntegrityDataException(fieldErrors);
		}
		return isValid;
	}
	
	private boolean validDelimiters(String line){	
		return FileUtil.noOfColumnsMatch(line, rules.getInternalDelimiter(),
				rules.getColumnCount());
	}
	
	private boolean validHeaders(String line){	
		return line.equalsIgnoreCase(rules.getHeaderString()
				.toString());
	}
	
	private boolean isLineDuplicate(String line,Set<String> duplicateSet) throws FileIntegrityDataException {	
		if(rules.isDupCheckReqd()){
			return !duplicateSet.add(FileUtil.getStringFromColumns(
					line, rules.getDuplicateColumnOrders(),
					rules.getInternalDelimiter()));
		}else{
			return false;
		}
		
	}
	
	private boolean validDataType(String line){	
		return FileUtil.isDataTypeMatching(line, rules.getRegExString().toString());
	}
	
	private FieldError createErrorForType(String errorType,int rowNum) {
		return createErrorForMsg(getErrorFromMap(rules.getErrorMessages(),errorType), rowNum);
	}
	
	private List<FieldError> createAllErrorsForDataType(String inputLine,int rowNum) {
		String value = null;
		List<FieldError> errorList = new ArrayList<FieldError>();
		String[] lineBreak = inputLine.split(this.rules.getInternalDelimiter(),this.rules.getColumnCount());
		int i=0;
		for(ColumnRules columnRule:this.rules.getInputColumn()){
			value = lineBreak[i];
			if(columnRule.isNotNull() && FileUtil.isEmpty(value)){
				errorList.add(createErrorForMsg(getErrorFromMap(columnRule.getErrorMessages(),FileIntegrityConstants.ERROR_NOT_NULL_INVALID), rowNum));
			}else if(FileUtil.exceedsMaxLength(value,columnRule.getMaxlength())){
				errorList.add(createErrorForMsg(getErrorFromMap(columnRule.getErrorMessages(),FileIntegrityConstants.ERROR_LENGTH_INVALID), rowNum));
			}
			else if(!FileUtil.isDataTypeMatching(value, columnRule.getRegex())){
				errorList.add(createErrorForMsg(getErrorFromMap(columnRule.getErrorMessages(),FileIntegrityConstants.ERROR_DATATYPE_INVALID), rowNum));
			}
			i++;
		}		
		return errorList;
	}
	
	private String getErrorFromMap(Map<String,String> rules, String errorType){ 
		if(rules!=null && rules.containsKey(errorType)){
			return (rules.get(errorType));
		}else if(this.rules.getErrorMessages()!=null && this.rules.getErrorMessages().containsKey(errorType)){
			return (this.rules.getErrorMessages().get(errorType));
		}
		return null;
	}
	
	private FieldError createErrorForMsg(String errorMsg,int rowNum) {
		String exceptionMsg = errorMsg;
		if (exceptionMsg == null) {
			exceptionMsg = "Error in row:{}";
		}
		exceptionMsg = exceptionMsg.replace("{}", ""+rowNum);
		
		FieldError detail = new FieldError();
		detail.setUserErrorMessage(exceptionMsg);		
		detail.setExceptionType(ExceptionType.SKIPPABLE);
		detail.setRule("");
		detail.setAttributeName("");
		detail.setExceptionMessage(exceptionMsg);
		
		return detail;
	}
	
	private String removeSpacesAndQuotes(String lineVal){
		String line =lineVal.trim();
		String repDelimiter = getReplacingDemiliter(rules.getDelimiter());
		line = line.toUpperCase();
		line = line.replaceAll(" "+repDelimiter, this.rules.getDelimiter());
		line = line.replaceAll(repDelimiter+" ", this.rules.getDelimiter());
		line = line.replaceAll("\""+repDelimiter, this.rules.getDelimiter());
		line = line.replaceAll(repDelimiter+"\"", this.rules.getDelimiter());
		if(line.startsWith("\"")){
			line = line.replaceFirst("\"", "");
		}
		if(line.endsWith("\"")){
			line= line.substring(0, line.length() - 1);
		}
		line = line.replaceAll(repDelimiter, rules.getInternalDelimiter());		
		return line;		
	}
	
	private String getReplacingDemiliter(String delimiter){
		if(delimiter!=null){
			return "\\"+delimiter;
		}
		return delimiter;
	}
}
