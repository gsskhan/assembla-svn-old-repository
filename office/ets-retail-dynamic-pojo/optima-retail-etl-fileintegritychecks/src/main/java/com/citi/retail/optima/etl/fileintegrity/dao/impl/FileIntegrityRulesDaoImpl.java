package com.citi.retail.optima.etl.fileintegrity.dao.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

import com.citi.retail.optima.etl.fileintegrity.common.FileValidationRules;
import com.citi.retail.optima.etl.fileintegrity.dao.FileIntegrityRulesDao;
import com.citi.retail.optima.etl.fileintegrity.exception.FileIntegrityException;

public class FileIntegrityRulesDaoImpl implements FileIntegrityRulesDao<Map<String, FileValidationRules>> { 

	private final Logger LOGGER = (Logger) LoggerFactory
			.getLogger(FileIntegrityRulesDaoImpl.class);

	private String ruleFileNames;
	
	public String getRuleFileNames() {
		return ruleFileNames;
	}

	public void setRuleFileNames(String ruleFileNames) {
		this.ruleFileNames = ruleFileNames;
	}

	private Map<String, FileValidationRules> getFileValitionRulesData()
			throws FileIntegrityException {
		try {
			Map<String, FileValidationRules> fileValiationRulesMap = new ConcurrentHashMap<String, FileValidationRules>();			
			JAXBContext jaxbContext = JAXBContext
					.newInstance(FileValidationRules.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			String[] fileList = ruleFileNames.split(",");
			if (fileList != null && fileList.length > 0) {
				for (int i = 0; i < fileList.length; i++) {
					FileValidationRules rules = (FileValidationRules) jaxbUnmarshaller
							.unmarshal(ClassLoader
									.getSystemResource(fileList[i]));
					rules.prepareObject();
					fileValiationRulesMap.put(rules.getFunctionName(), rules);					
				}
			}
			return fileValiationRulesMap;
		} catch (Exception e) {
			LOGGER.error(" Exception occured while loading File Scanner rules "
					+ e);
			throw new FileIntegrityException("Exception occured while loading File Scanner rules",
					e.getMessage(), e);
		}
	}
	
	public Map<String, FileValidationRules> getValidationRules(Object... args) throws FileIntegrityException {
		return this.getFileValitionRulesData();	
	}
	
}
