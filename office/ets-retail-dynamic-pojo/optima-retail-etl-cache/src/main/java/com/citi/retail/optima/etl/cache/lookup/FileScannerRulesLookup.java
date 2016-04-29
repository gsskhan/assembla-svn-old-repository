package com.citi.retail.optima.etl.cache.lookup;

import net.sf.ehcache.Element;
import net.sf.ehcache.search.Attribute;

import org.springframework.cache.Cache;

import com.citi.retail.optima.etl.common.filescanner.FileValidationRules;

public class FileScannerRulesLookup extends SpringCacheBaseLookup {

	Attribute<String> functionName;

	public FileScannerRulesLookup(Cache cache) {
		super(cache);
	}

	public FileValidationRules getFileScannerRules(String functionName) {

		FileValidationRules fileValidationRules = null;

		Element valueWrapper = this.ehCache.get(functionName);

		if (valueWrapper != null){
			fileValidationRules = (FileValidationRules) valueWrapper.getObjectValue();
		}

		return fileValidationRules;
	}

}
