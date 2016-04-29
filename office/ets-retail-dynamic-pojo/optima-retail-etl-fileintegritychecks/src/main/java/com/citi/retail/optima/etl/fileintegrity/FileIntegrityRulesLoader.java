/**
 * 
 */
package com.citi.retail.optima.etl.fileintegrity;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.expression.ParseException;

import com.citi.retail.optima.etl.fileintegrity.common.FileValidationRules;
import com.citi.retail.optima.etl.fileintegrity.dao.FileIntegrityRulesDao;
import com.citi.retail.optima.etl.fileintegrity.exception.FileIntegrityException;

/**
 * @author TJ
 * 
 */
public class FileIntegrityRulesLoader implements InitializingBean {
	
	private static final Logger LOGGER = LoggerFactory
			.getLogger(FileIntegrityRulesLoader.class);

	private Map<String, FileValidationRules> fileIntegrityRulesMap;	
	
	private FileIntegrityRulesDao<Map<String, FileValidationRules>> fileIntegrityRulesDao;
	
	
	/**
	 * This method would get the validation rules from map and returns to caller.
	 * 
	 * @param keyList
	 * @return
	 * @throws OptimaRetailApplicationException
	 */
	public FileValidationRules getRulesList(String functionName)	throws FileIntegrityException {
		return fileIntegrityRulesMap !=null ? fileIntegrityRulesMap.get(functionName):null;
	}
	


	/**
	 * This method will load all validation rules from database.
	 */
	public void afterPropertiesSet() throws Exception {	
		try {
			this.fileIntegrityRulesMap = fileIntegrityRulesDao.getValidationRules();
		} catch (ParseException e) {	
			LOGGER.info("ValidationRulesLoader | Exception Occured while loading the rules");
			throw new FileIntegrityException(
					"ValidationRulesLoader | Exception Occured while loading the rules");
		}			
	}
	
	public void setFileIntegrityRulesDao(
			FileIntegrityRulesDao<Map<String, FileValidationRules>> fileIntegrityRulesDao) {
		this.fileIntegrityRulesDao = fileIntegrityRulesDao;
	}
	
}
