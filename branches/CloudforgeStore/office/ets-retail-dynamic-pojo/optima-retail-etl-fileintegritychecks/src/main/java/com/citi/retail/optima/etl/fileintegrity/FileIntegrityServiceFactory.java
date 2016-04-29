package com.citi.retail.optima.etl.fileintegrity;

import com.citi.retail.optima.etl.fileintegrity.exception.FileIntegrityException;

public interface FileIntegrityServiceFactory {

	FileIntegrityService createFileIntegrityService(
			String lookupName) throws FileIntegrityException ;
	
}