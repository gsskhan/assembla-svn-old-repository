package com.citi.retail.optima.etl.fileintegrity.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.citi.retail.optima.etl.fileintegrity.FileIntegrityRulesLoader;
import com.citi.retail.optima.etl.fileintegrity.FileIntegrityService;
import com.citi.retail.optima.etl.fileintegrity.FileIntegrityServiceFactory;
import com.citi.retail.optima.etl.fileintegrity.exception.FileIntegrityException;

public class FileIntegrityServiceFactoryImpl implements FileIntegrityServiceFactory {

	private FileIntegrityRulesLoader fileIntegrityRulesLoader;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(FileIntegrityServiceFactoryImpl.class);
	

	/**
	 * Creates a File Scanner Service for each request
	 * @param lookupName
	 *            - is the lookup name for the rules for the service to load
	 *            exception message
	 */
	public FileIntegrityService createFileIntegrityService(String lookupName)
			throws FileIntegrityException {
		if (lookupName == null) {
			LOGGER.error("FileScannerServiceFactoryImpl.createFileScannerService() - Error: Lookupname '"
					+ lookupName + "' is invalid ");
			throw new FileIntegrityException("FileScannerServiceFactoryImpl.createFileScannerService() - Error: Lookupname '"
							+ lookupName + "' is invalid ");
		}
		return new FileIntegrityServiceImpl(
				this.fileIntegrityRulesLoader.getRulesList(lookupName));
	}

	public void setFileIntegrityRulesLoader(
			FileIntegrityRulesLoader fileIntegrityRulesLoader) {
		this.fileIntegrityRulesLoader = fileIntegrityRulesLoader;
	}
}
