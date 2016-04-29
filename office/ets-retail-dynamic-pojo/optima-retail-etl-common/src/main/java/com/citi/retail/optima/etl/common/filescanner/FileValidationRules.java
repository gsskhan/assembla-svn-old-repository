package com.citi.retail.optima.etl.common.filescanner;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.citi.retail.optima.etl.common.FileScannerConstants;

@XmlRootElement
public class FileValidationRules implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String delimiter=",";
	private String internalDelimiter="#";
	private String allowedExtentions ="";
	private String functionName;
	private SortedSet<ColumnRules> inputColumn;
	private StringBuffer headerString = new StringBuffer("");
	private Set<Integer> duplicateColumnOrders;
	private StringBuffer regExString = new StringBuffer("");
	private String acceptedValues;
	private Integer rowCount;
	private Integer columnCount;
	private Map<String, String> errorMessages = new HashMap<String, String>();
	private boolean dupCheckReqd = true;
	
	public boolean isDupCheckReqd() {
		return dupCheckReqd;
	}
	public void setDupCheckReqd(boolean dupCheckReqd) {
		this.dupCheckReqd = dupCheckReqd;
	}
	@XmlJavaTypeAdapter(MapAdapter.class)
	@XmlElement(required=false)
	public Map<String, String> getErrorMessages() {
		return errorMessages;
	}	
	public void setErrorMessages(Map<String, String> errorMessages) {
		this.errorMessages = errorMessages;
	}
	
	@XmlAttribute
	public String getFunctionName() {
		return functionName;
	}
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	public StringBuffer getRegExString() {
		return regExString;
	}
	public void setRegExString(StringBuffer regExString) {
		this.regExString = regExString;
	}
	@XmlAttribute
	public Integer getColumnCount() {
		return columnCount;
	}
	public void setColumnCount(Integer columnCount) {
		this.columnCount = columnCount;
	}
	public String getInternalDelimiter() {
		return internalDelimiter;
	}
	public void setInternalDelimiter(String internalDelimiter) {
		this.internalDelimiter = internalDelimiter;
	}
	@XmlAttribute(required=false)
	public String getDelimiter() {
		return delimiter;
	}
	public void setDelimiter(String delimiter) {
		this.delimiter = delimiter;
	}
	@XmlAttribute
	public String getAllowedExtentions() {
		return allowedExtentions;
	}
	public void setAllowedExtentions(String allowedExtentions) {
		this.allowedExtentions = allowedExtentions;
	}
	public SortedSet<ColumnRules> getInputColumn() {
		return inputColumn;
	}
	@XmlElement
	public void setInputColumn(SortedSet<ColumnRules> inputColumn) {
		this.inputColumn = inputColumn;
	}		
	public StringBuffer getHeaderString() {
		return headerString;
	}
	public void setHeaderString(StringBuffer headerString) {
		this.headerString = headerString;
	}	
	public Set<Integer> getDuplicateColumnOrders() {
		return duplicateColumnOrders;
	}
	public void setDuplicateColumnOrders(Set<Integer> duplicateColumnOrders) {
		this.duplicateColumnOrders = duplicateColumnOrders;
	}	
	@XmlAttribute(required=false)
	public String getAcceptedValues() {
		return acceptedValues;
	}
	public void setAcceptedValues(String acceptedValues) {
		this.acceptedValues = acceptedValues;
	}	
	@XmlAttribute(required=false)
	public Integer getRowCount() {
		return rowCount;
	}
	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}	
	public void prepareObject(){		
		if(this.getDelimiter().equals("")){
			this.setDelimiter(",");
		}
		if(this.inputColumn!=null){
			formHeaderAndRegex();
			if(duplicateColumnOrders==null){
				duplicateColumnOrders = new HashSet<Integer>();
			}
			for(ColumnRules inpFileColumn: this.inputColumn){
				if(inpFileColumn.isDuplicate()){
					duplicateColumnOrders.add(inpFileColumn.getOrder());
				}
			}	
		}
		if(duplicateColumnOrders!=null && duplicateColumnOrders.size()==0){
			this.dupCheckReqd =false;
		}
	}
	
	private void formHeaderAndRegex(){
		int count = 1;
		for(ColumnRules fileColumn:inputColumn){
			if(count!=inputColumn.size()){
				headerString = headerString.append(fileColumn.getColumnName().trim()).append(internalDelimiter);
				regExString = regExString.append(getRegexForDatatype(fileColumn)).append(internalDelimiter);
			}else{				
				headerString = headerString.append(fileColumn.getColumnName());
				if(fileColumn.getDataType()==null || fileColumn.getDataType().equals("")){
					regExString = regExString.append("NA");
				}else{
					regExString = regExString.append(getRegexForDatatype(fileColumn));
				}					
			}
			count++;
		}
	}
	private String getRegexForDatatype(ColumnRules column){
		if(column.getRegex()==null){
			if(column.isNotNull()){
				column.setRegex(getRegexForNotNullDataType(column));
			}else{
				column.setRegex(getRegexForNullDataType(column));				
			}
		}		
		return column.getRegex();
	}
	
	private String getRegexForNotNullDataType(ColumnRules column){
		if("String".equalsIgnoreCase(column.getDataType())){
			return FileScannerConstants.REGEX_STRING_NOTNULL;
		}else if("Integer".equalsIgnoreCase(column.getDataType())){
			return FileScannerConstants.REGEX_NUMBER_NOTNULL;
		}else if("NegativeInteger".equalsIgnoreCase(column.getDataType())){
			return FileScannerConstants.REGEX_NEGATIVENUMBER_NOTNULL;
		}else if("Decimal".equalsIgnoreCase(column.getDataType())){
			return FileScannerConstants.REGEX_DECIMALNUMBER_NOTNULL;
		}else if("NegativeDecimal".equalsIgnoreCase(column.getDataType())){
			return FileScannerConstants.REGEX_NEGATIVEDECIMALNUMBER_NOTNULL;
		}else if("Date".equalsIgnoreCase(column.getDataType())){
			return FileScannerConstants.REGEX_DATE_NOTNULL;
		}else{
			return null;
		}
	}
	
	private String getRegexForNullDataType(ColumnRules column){
		if("String".equalsIgnoreCase(column.getDataType())){
			return FileScannerConstants.REGEX_STRING;
		}else if("Integer".equalsIgnoreCase(column.getDataType())){
			return FileScannerConstants.REGEX_NUMBER;
		}else if("NegativeInteger".equalsIgnoreCase(column.getDataType())){
			return FileScannerConstants.REGEX_NEGATIVENUMBER;
		}else if("Decimal".equalsIgnoreCase(column.getDataType())){
			return FileScannerConstants.REGEX_DECIMALNUMBER;
		}else if("NegativeDecimal".equalsIgnoreCase(column.getDataType())){
			return FileScannerConstants.REGEX_NEGATIVEDECIMALNUMBER;
		}else if("Date".equalsIgnoreCase(column.getDataType())){
			return FileScannerConstants.REGEX_DATE;
		}else{
			return null;
		}
	}
	
}
