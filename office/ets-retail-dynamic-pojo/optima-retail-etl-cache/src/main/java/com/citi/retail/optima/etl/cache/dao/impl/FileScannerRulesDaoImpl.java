package com.citi.retail.optima.etl.cache.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

import com.citi.retail.optima.etl.cache.dao.CacheLoaderDao;
import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;
import com.citi.retail.optima.etl.common.filescanner.FileValidationRules;

public class FileScannerRulesDaoImpl implements
		CacheLoaderDao<FileValidationRules> {

	private final Logger LOGGER = (Logger) LoggerFactory
			.getLogger(SpelValidationRulesDaoImpl.class);

	private String ruleFileNames;

	public String getRuleFileNames() {
		return ruleFileNames;
	}

	public void setRuleFileNames(String ruleFileNames) {
		this.ruleFileNames = ruleFileNames;
	}

	private List<FileValidationRules> getFileValitionRulesData()
			throws OptimaRetailApplicationException {
		try {
			List<FileValidationRules> mappingList = new ArrayList<FileValidationRules>();
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
					mappingList.add(rules);
				}
			}
			return mappingList;
		} catch (Exception e) {
			LOGGER.error(" Exception occured while loading File Scanner rules "
					+ e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					"Exception occured while loading File Scanner rules",
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));
		}
	}

	@Override
	public Collection<FileValidationRules> getCacheData(Object... args)
			throws Exception {
		// TODO Auto-generated method stub
		return this.getFileValitionRulesData();
	}

}
