package com.citi.retail.optima.etl.cache.ehcache;

import com.citi.retail.optima.etl.common.filescanner.FileValidationRules;
import com.citi.retail.optima.etl.cache.ehcache.OptimaCacheDataLoader;;

public class FileScannerCacheDataLoader 
	extends OptimaCacheDataLoader<FileValidationRules , String, FileValidationRules> {
	
	@Override
	public void afterPropertiesSet() throws Exception {
		if (preloadCache) {
			loadCache();
		}
	}
}
