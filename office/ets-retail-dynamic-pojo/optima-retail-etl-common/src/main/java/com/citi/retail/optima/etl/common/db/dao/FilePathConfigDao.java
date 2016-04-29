package com.citi.retail.optima.etl.common.db.dao;

import java.util.Map;

import com.citi.retail.optima.etl.common.model.FilePathDetailVO;

public interface FilePathConfigDao {
	Map<String, FilePathDetailVO> loadFilePaths();
	
}
