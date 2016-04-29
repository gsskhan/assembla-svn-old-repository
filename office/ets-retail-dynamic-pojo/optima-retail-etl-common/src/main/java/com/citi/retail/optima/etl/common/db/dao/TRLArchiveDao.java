package com.citi.retail.optima.etl.common.db.dao;

import java.util.Map;

import com.citi.retail.optima.etl.common.model.FilePathDetailVO;
import com.citi.retail.optima.etl.common.model.SplitFileReqDetailVO;
import com.citi.retail.optima.etl.common.model.TRLArchiveDetailVO;

public interface TRLArchiveDao {
	Map<String, TRLArchiveDetailVO> loadTRLArchiveDetails();
	Map<String, SplitFileReqDetailVO> loadSplitFileReqDetails();
	
}
