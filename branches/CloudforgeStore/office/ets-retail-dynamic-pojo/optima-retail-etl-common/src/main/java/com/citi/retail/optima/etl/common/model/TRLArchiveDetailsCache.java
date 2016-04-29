package com.citi.retail.optima.etl.common.model;

import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

import com.citi.retail.optima.etl.common.db.dao.TRLArchiveDao;

public class TRLArchiveDetailsCache implements InitializingBean{
	
	private static Map<String, TRLArchiveDetailVO> trlArchiveDetailsMap;
	private static Map<String, SplitFileReqDetailVO> trlSplitFileReqDetailsMap;
	private TRLArchiveDao trlArchiveDao;
	
	public static TRLArchiveDetailVO getTRLArchiveVO(String key){
		return trlArchiveDetailsMap.get(key);
	}
	
	/**
	 * @return the fileDetailsMap
	 */
	public static Map<String, TRLArchiveDetailVO> getFileDetailsMap() {
		return trlArchiveDetailsMap;
	}

	/**
	 * @param fileDetailsMap the fileDetailsMap to set
	 */
	public static void setFileDetailsMap(Map<String, TRLArchiveDetailVO> fileDetailsMap) {
		TRLArchiveDetailsCache.trlArchiveDetailsMap = fileDetailsMap;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		trlArchiveDetailsMap = trlArchiveDao.loadTRLArchiveDetails();
		trlSplitFileReqDetailsMap = trlArchiveDao.loadSplitFileReqDetails();
		
	}

	/**
	 * @return the trlArchiveDao
	 */
	public TRLArchiveDao getFileConfigDao() {
		return trlArchiveDao;
	}

	/**
	 * @param trlArchiveDao the trlArchiveDao to set
	 */
	public void setFileConfigDao(TRLArchiveDao trlArchiveDao) {
		this.trlArchiveDao = trlArchiveDao;
	}
	
	public static boolean getInputTRLArchive(String cntryProd){
		return trlArchiveDetailsMap.get(cntryProd).isTRLArchiveRequied();
	}

	public static Map<String, SplitFileReqDetailVO> getTrlSplitFileReqDetailsMap() {
		return trlSplitFileReqDetailsMap;
	}

	public static void setTrlSplitFileReqDetailsMap(
			Map<String, SplitFileReqDetailVO> trlSplitFileReqDetailsMap) {
		TRLArchiveDetailsCache.trlSplitFileReqDetailsMap = trlSplitFileReqDetailsMap;
	}
	
	public static boolean getSplitFileReq(String cntryProd){
		return trlSplitFileReqDetailsMap.get(cntryProd).isSplitFileRequired();
	}
	
}
