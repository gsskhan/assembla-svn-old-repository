package com.citi.retail.optima.etl.fileintegrity;

import com.citi.retail.optima.etl.fileintegrity.exception.FileIntegrityDataException;


public interface FileIntegrityService {
	boolean validate (String line,int rowNum) throws FileIntegrityDataException;
}
