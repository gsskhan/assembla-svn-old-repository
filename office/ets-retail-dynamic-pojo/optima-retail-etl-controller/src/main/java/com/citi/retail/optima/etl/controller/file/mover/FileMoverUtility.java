package com.citi.retail.optima.etl.controller.file.mover;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.util.StringUtils;

import com.citi.retail.optima.etl.common.ETLConstants;
import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.db.dao.JobConfigDao;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.model.FilePathDetailsCache;
import com.citi.retail.optima.etl.controller.dao.JobMessageDao;

public class FileMoverUtility {
	private FileMover filemover;
	private JobMessageDao jobMessageDao;
	private String inputLocation;
	private String outputLocation;
	private JobConfigDao jobConfigDao;

	
	/**
	 * @return the jobConfigDao
	 */
	public JobConfigDao getJobConfigDao() {
		return jobConfigDao;
	}

	/**
	 * @param jobConfigDao the jobConfigDao to set
	 */
	public void setJobConfigDao(JobConfigDao jobConfigDao) {
		this.jobConfigDao = jobConfigDao;
	}

	public void setFilemover(FileMover filemover) {
		this.filemover = filemover;
	}	
	
	public FileMover getFilemover() {
		return filemover;
	}
	public void setJobMessageDao(JobMessageDao jobMessageDao) {
		this.jobMessageDao = jobMessageDao;
	}
	public void setInputLocation(String inputLocation) {
		this.inputLocation = inputLocation;
	}
	public void setOutputLocation(String outputLocation) {
		this.outputLocation = outputLocation;
	}
	
	public boolean moveFileForBatch(Long batchInstId,String status) throws OptimaRetailApplicationException{
		boolean isMoved = false;
		try {			
			String controlFile = jobMessageDao.getControlFileByBatch(batchInstId);
			String cntryProd = null;
			if(controlFile.contains("IN") && controlFile.contains("MTG")){
				cntryProd = "IN-MTG";
			} else{
				cntryProd = controlFile.split("_")[1]+"-"+controlFile.split("_")[2];
			}
			inputLocation = FilePathDetailsCache.getInputFilePath(cntryProd);
			outputLocation = FilePathDetailsCache.getProcessedFilePath(cntryProd);
			List<String> fileNames = getControlFileDetails(controlFile);
			if(controlFile!=null){
				if(fileNames==null){
					fileNames=new ArrayList<String>();
				}
				fileNames.add(controlFile);
			}
			if(fileNames!=null){
				for(String name:fileNames){
					filemover.moveFile(inputLocation, outputLocation, name, name+getFileAppender(status));
				}
				isMoved = true;
			}			
		}catch(Exception e){
			throw new OptimaRetailApplicationException(
					null,null,batchInstId,	ServiceName.CONTROLLER,
					ExceptionType.ERROR,
					" Exception occured for Batch Inst " + batchInstId,
					"Unable to move files in FileMoverUtility", null,jobConfigDao);		
		}
		return isMoved;
	}
	
	public boolean moveFileForRequestLog(Long requestLogId,String status) throws OptimaRetailApplicationException{
		boolean isMoved = false;
		try {			
			String controlFile = jobMessageDao.getControlFileByReqLogId(requestLogId);
			String cntryProd = null;
			if(controlFile.contains("IN") && controlFile.contains("MTG")){
				cntryProd = "IN-MTG";
			} else{
				cntryProd = controlFile.split("_")[1]+"-"+controlFile.split("_")[2];
			}
			inputLocation = FilePathDetailsCache.getInputFilePath(cntryProd);
			outputLocation = FilePathDetailsCache.getProcessedFilePath(cntryProd);
			List<String> fileNames = getControlFileDetails(controlFile);
			if(controlFile!=null){
				if(fileNames==null){
					fileNames=new ArrayList<String>();
				}
				fileNames.add(controlFile);
			}
			if(fileNames!=null){
				for(String name:fileNames){
					filemover.moveFile(inputLocation, outputLocation, name, name+getFileAppender(status));
				}
				isMoved = true;
			}			
		}catch(Exception e){
			throw new OptimaRetailApplicationException(
					requestLogId,null,null,	ServiceName.CONTROLLER,
					ExceptionType.ERROR,
					" Exception occured for RequestLog Id " + requestLogId,
					"Unable to move files in FileMoverUtility", null,jobConfigDao);	
		}
		return isMoved;
	}
	
	private String getFileAppender(String status){
		SimpleDateFormat smD = new SimpleDateFormat("hhmm:ss");
		String df = smD.format(new Date(System.currentTimeMillis()));
		
		if("Success".equalsIgnoreCase(status)){
			return "." + System.currentTimeMillis() + ".processed";
		}else{
			return "." + System.currentTimeMillis() + ".failed";
		}
	}
	
	/**
	 * get manual file details from control files
	 * @param inputFileName
	 * @return
	 */
	private List<String> getControlFileDetails(String inputFileName) throws IOException,FileNotFoundException{		
		List<String> rptDateList = new ArrayList<String>();
		BufferedReader br = null;
		if(inputFileName==null){return rptDateList;}
		try {
			File controlFile = new File(inputLocation  + inputFileName);
			//br = new BufferedReader(new FileReader(controlFile));
			if(controlFile.exists()) {
				br = new BufferedReader(new FileReader(controlFile));
			} else if(new File(outputLocation  + inputFileName + ETLConstants.CTL_MOVED_FILE_STR).exists()) {
				br = new BufferedReader(new FileReader(new File(outputLocation  + inputFileName + ETLConstants.CTL_MOVED_FILE_STR)));
			}
			String lineStr;
			String[] strArray = null;
			br.readLine();//to skip header
			while ((lineStr = br.readLine()) != null) {
				strArray = StringUtils.delimitedListToStringArray(lineStr, "|");		
				rptDateList.add(strArray[0]);
			}
			br.close();
		} catch (FileNotFoundException fnfEx){
			throw fnfEx;
		} catch (IOException ioEx) {
			throw ioEx;
		}finally{
			if(br!=null){
				br.close();
			}
		}
		return rptDateList;
	}
	
}
