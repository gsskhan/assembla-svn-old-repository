package com.citi.retail.optima.etl.fileintegrity.dao;

import java.util.Map;

import com.citi.retail.optima.etl.fileintegrity.common.FileValidationRules;
import com.citi.retail.optima.etl.fileintegrity.exception.FileIntegrityException;

public interface FileIntegrityRulesDao<E> {
	Map<String, FileValidationRules> getValidationRules(Object... args) throws FileIntegrityException;
}
