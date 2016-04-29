package com.citi.retail.optima.etl.cache.helper;

import com.citi.retail.optima.etl.common.filescanner.FileValidationRules;

public class FileScannerCacheEntryHelper implements CacheEntryHelper<FileValidationRules, String, FileValidationRules> {
	
	@Override
	public String getKey(FileValidationRules entity) {	
		return entity.getFunctionName();
	}

	@Override
	public FileValidationRules getValue(FileValidationRules entity) {
		return entity;
	}
	
}
