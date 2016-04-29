package com.citi.retail.optima.etl.common.model;

import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

import com.citi.retail.optima.etl.common.db.dao.FilePathConfigDao;

public class FilePathDetailsCache implements InitializingBean{
	
	private static Map<String, FilePathDetailVO> fileDetailsMap;
	private FilePathConfigDao fileConfigDao;
	
	public static FilePathDetailVO getFilePathVO(String key){
		return fileDetailsMap.get(key);
	}
	
	/**
	 * @return the fileDetailsMap
	 */
	public static Map<String, FilePathDetailVO> getFileDetailsMap() {
		return fileDetailsMap;
	}

	/**
	 * @param fileDetailsMap the fileDetailsMap to set
	 */
	public static void setFileDetailsMap(Map<String, FilePathDetailVO> fileDetailsMap) {
		FilePathDetailsCache.fileDetailsMap = fileDetailsMap;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		fileDetailsMap = fileConfigDao.loadFilePaths();
		
	}

	/**
	 * @return the fileConfigDao
	 */
	public FilePathConfigDao getFileConfigDao() {
		return fileConfigDao;
	}

	/**
	 * @param fileConfigDao the fileConfigDao to set
	 */
	public void setFileConfigDao(FilePathConfigDao fileConfigDao) {
		this.fileConfigDao = fileConfigDao;
	}
	
	public static String getInputFilePath(String cntryProd){
		return fileDetailsMap.get(cntryProd.toLowerCase()).getInputFilePath();
	}
	
	public static String getOutputFilePath(String cntryProd){
		return fileDetailsMap.get(cntryProd.toLowerCase()).getOutputPath();
	}
	
	public static String getArchiveFilePath(String cntryProd){
		return fileDetailsMap.get(cntryProd.toLowerCase()).getArchivePath();
	}
	
	public static String getProcessedFilePath(String cntryProd){
		return fileDetailsMap.get(cntryProd.toLowerCase()).getProcessedPath();
	}
	/*public static void getInputFilePath(){
		System.out.println("enterd");
	}*/
}
