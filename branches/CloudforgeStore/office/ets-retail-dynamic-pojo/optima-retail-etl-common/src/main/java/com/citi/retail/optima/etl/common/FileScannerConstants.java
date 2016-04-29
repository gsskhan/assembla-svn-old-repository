package com.citi.retail.optima.etl.common;

public interface FileScannerConstants {
	String REGEX_STRING = "([0-9a-zA-Z_ ]*)";
	String REGEX_STRING_NOTNULL = "([0-9a-zA-Z_ ]+)";
	String REGEX_NUMBER = "([\\d]*)";
	String REGEX_NUMBER_NOTNULL = "([\\d]+)";
	String REGEX_NEGATIVENUMBER = "([[-/+][\\d]]*)";
	String REGEX_NEGATIVENUMBER_NOTNULL = "([[-/+][\\d]]+)";
	String REGEX_DECIMALNUMBER = "([[\\d]*[.][\\d]*]*)";
	String REGEX_DECIMALNUMBER_NOTNULL = "([[\\d]*[.][\\d]*]+)";
	String REGEX_NEGATIVEDECIMALNUMBER = "([[-/+][\\d]*[.][\\d]*]*)";
	String REGEX_NEGATIVEDECIMALNUMBER_NOTNULL = "([[-/+][\\d]*[.][\\d]*]+)";
	String REGEX_DATE = "((19|20)\\d\\d(0?[1-9]|1[012]))";
	String REGEX_DATE_NOTNULL = "((19|20)\\d\\d(0?[1-9]|1[012]))";
	String ERROR_CLMN_COUNT = "CLMN_COUNT_MISMATCH";
	String ERROR_HEADER_INVALID = "HEADER_INVALID";
	String ERROR_DUPLICATE_ROW = "DUPLICATE_ROW";
	String ERROR_DATATYPE_INVALID = "DATATYPE_INVALID";	
	String ERROR_NOT_NULL_INVALID = "NOT_NULL_INVALID";	
	String ERROR_LENGTH_INVALID = "LENGTH_INVALID";	
}