/**
 * 
 */
package com.citi.retail.optima.etl.controller.file.handler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.integration.Message;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.util.StringUtils;

import com.citi.optima.batch.job.jdbc.ETLQueryExecutor;
import com.citi.retail.optima.etl.common.ETLConstants;
import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.db.dao.JobConfigDao;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;
import com.citi.retail.optima.etl.controller.audit.dao.BatchAuditLogger;
import com.citi.retail.optima.etl.controller.audit.dao.BatchAuditLoggerImpl;
import com.citi.retail.optima.etl.common.model.FilePathDetailsCache;
import com.citi.retail.optima.etl.controller.dao.JobMessageDao;
import com.citi.retail.optima.etl.controller.file.mover.FileMoverUtility;
import com.citi.retail.optima.etl.controller.model.EventFileMapVO;
import com.citi.retail.optima.etl.controller.model.MessageLog;
import com.citi.retail.optima.etl.controller.model.RequestMessageType;
import com.citi.retail.optima.xsd.internal.EventTypes;

/**
 * @author gv74035
 * 
 *         This class will be invoked from the file watcher component. Currently
 *         only event type , request id are being saved into request log table
 *         as there will not be file id, file type for data acquisition.
 */
public class DataAcquisitionHandler implements InitializingBean {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(DataAcquisitionHandler.class);

	private FileMoverUtility fileMovementUtlity;
	private JobMessageDao jobMessageDao;

	private static final String MESSAGE_TYPE = "MESSAGE_TYPE";
	
	private String fileLocation;
	
	private List<String> dataFileList;

	private Paths dataFileNames;
	public static int auditFileId;
	//public static Map<String, List<String>> fileAuditDetails;
	public static Map<String, String> inputCountMap;
	public static String ctlFileCreationDt;
	public static String inMtgCount;
	private ETLQueryExecutor queryExec;
	private JobConfigDao jobConfigDao;
	/**
	 * @return the queryExec
	 */
	public ETLQueryExecutor getQueryExec() {
		return queryExec;
	}

	/**
	 * @param queryExec the queryExec to set
	 */
	public void setQueryExec(ETLQueryExecutor queryExec) {
		this.queryExec = queryExec;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub

	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	public Message<MessageLog> receiveFilePayload(Message<File> message)
			throws OptimaRetailApplicationException {

		LOGGER.info(" Data Acquisition - File PayLoad");
		Message<MessageLog> msg = null;
		MessageLog messageLog = new MessageLog();
		List<String> dataFileList = null;
		Long requestLogId=0L;

		try {

			requestLogId=jobMessageDao.getRequestLogId();
			messageLog.setMessageId(requestLogId);
			messageLog.setEventType(EventTypes.DATA_ACQUISITION.value());
			messageLog.setFileType("dat");
			messageLog.setFileName(message.getPayload().getName());

			//below three fields needs to be parsed from control file
			String[] cntFileDetails = message.getPayload().getName().split(ETLConstants.SPLITDELIMITER);
			List<String> product = new ArrayList<String>();
			if(cntFileDetails!=null){
				//product.add(cntFileDetails[1]);
				if (cntFileDetails[1].equalsIgnoreCase("MTG") && cntFileDetails[2].equalsIgnoreCase("IN")){
					product.add(cntFileDetails[1]);
					messageLog.setProductList(product);
					messageLog.setCountryCode(cntFileDetails[2]);
				}else{
					product.add(cntFileDetails[2]);
					messageLog.setProductList(product);
					//messageLog.setCountryCode(cntFileDetails[2]);
					messageLog.setCountryCode(cntFileDetails[1]);
				}
				messageLog.setReptPeriod(cntFileDetails[4].substring(0, 6));
			}
			for(String productName:product){
				if(checkForRunningJobs(productName, message.getPayload().getName())){
					jobMessageDao.saveDataAcquisitionMessageDetails(messageLog);
					validateControlAndManualFiles(message, messageLog, requestLogId);
					LOGGER.debug("Validation Completed !!!");
					// Added for updating the request id
					jobMessageDao.updateRequestEvent(requestLogId,messageLog.getReqtEventId());
					//insert into RRC_FILE_LOG all the data file names.
					jobMessageDao.insertIntoFileLog(requestLogId,getDataFileList());
					
					Map<String, String> messageHeader = new HashMap<String, String>();
					messageHeader.put(MESSAGE_TYPE,
							RequestMessageType.DATA_ACQUISITION.toString());

					msg = MessageBuilder.withPayload(messageLog)
							.copyHeadersIfAbsent(messageHeader).build();
					return msg;
				} else{
					LOGGER.info("Another Job for this product "+productName+" is already in running state.. Please wait..");
					return msg;
				}
			}

		} catch (Exception e) {
			//jobMessageDao.saveRequestLogId(messageLog);
			//fileMovementUtlity.moveFileForRequestLog(requestLogId, "FAILED");
			jobMessageDao.updateReqLogStatus(requestLogId,"FAILED");
			throw new OptimaRetailApplicationException(requestLogId, null, null,
					ServiceName.CONTROLLER, ExceptionType.ERROR,
					" Exception occured in DataAcquisitionHandler.receiveFilePayload() for " + messageLog.getMessageId(),
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e),jobConfigDao);
		}
		return msg;
		
	}

	private boolean checkForRunningJobs(String product, String fileName) {
		int availablecount = jobMessageDao.getCountForRunnableJobs();
		int existedCount = jobMessageDao.getCountForRunningJobs();
		if(availablecount > existedCount){
			if(jobMessageDao.isFileNameExists(fileName)){
				return false;
			} else{
				jobMessageDao.insertRunningJobs(product, fileName);
				return true;
			}
		}
		else {
			return false;
		}
			
	}

	/**
	 * This method verifies 
	 * 	1. received COntrol file is valid file
	 *  2. manual files included in control file are valid one
	 *  3. manual files included in control file are available at some defined file location (physical location on disk)
	 *  On any failure we update the RRC_REQ_LOG status column to "FAILED" status and if no failures continues to job and batch creation
	 *  and update status colmn to "SUCCESS"
	 * @param message
	 * @param messageLog
	 * @param requestLogId
	 * @throws OptimaRetailApplicationException
	 */
	private void validateControlAndManualFiles(Message<File> message,
			MessageLog messageLog, Long requestLogId)
					throws Exception {
		//verify the control name is proper
		List<EventFileMapVO> controlFileEventDetails = jobMessageDao.getAllControlFiles();
		int fileId=0;
		String rptPerd = "";
		boolean controlFileValid= false;
		for(EventFileMapVO event : controlFileEventDetails){
			//verify control file is valid
			
			if(Pattern.matches(event.getInputFileName(), message.getPayload().getName())){
				controlFileValid = true;
				jobMessageDao.poppulateEmailContent("CTRL_FILE_NAME_VALID", message.getPayload().getName(), null);
				Map<String, List<String>> controlFileDetailsMap=getControlFileDetails(message.getPayload().getName(),messageLog.getCountryCode()+"-"+messageLog.getProductList().toArray()[0]);
				List<EventFileMapVO> dataFileDetailsFromDB = jobMessageDao.getSupportingFilesInfo(event.getReqEventId());
				List<String> dataFileList = controlFileDetailsMap.get("datafile");
				setDataFileList(dataFileList);
				String regex = getConcatenatedRegex(dataFileDetailsFromDB);
				messageLog.setReqtEventId(event.getReqEventId());
				rptPerd = message.getPayload().getName().split("_")[4];
				fileId=jobMessageDao.logProcessAudit(fileId,message.getPayload().getName(), "Control File Name Validation",true,"Found Valid Control File Name", rptPerd);
				auditFileId = fileId;
				// Need to add the Zip file implementation
				
//				jobMessageDao.poppulateEmailContent("CTRL_FILE_NAME_VALID", message.getPayload().getName(), null);
				if (dataFileList!=null) {
					//verify manual files present in control file are valid files 
					
					//verify manual files present in control file are present
					if(!checkAllFileAvailable(dataFileList, messageLog.getCountryCode()+"-"+(messageLog.getProductList().toArray()[0]),fileId)){
						LOGGER.debug("All required files are not found in the directory.");
						//jobMessageDao.updateReqLogStatus(requestLogId, "FAILED");
						fileId=jobMessageDao.logProcessAudit(fileId,message.getPayload().getName(), "Data File Availability",false,"Missing Data files mentioned in the Control file", rptPerd);
						jobMessageDao.poppulateEmailContent("DATA_FILE_NOT_FOUND", message.getPayload().getName(), null);
						queryExec.updateJobStatusAudit(getBatchJobName(messageLog.getCountryCode(), messageLog.getProductList().toArray()[0].toString()), "FAILED", "Missing Data files mentioned in the Control file", getDateFromString(rptPerd));
						throw new OptimaRetailApplicationException(
								null,null,null,	ServiceName.CONTROLLER,
								ExceptionType.ERROR,
								" Exception occured for " + messageLog.getMessageId(),
								"All required  files are not found in the directory.", null,jobConfigDao);						
					}else{
						jobMessageDao.logProcessAudit(fileId,message.getPayload().getName(), "Data File Availability",true,"Found all required data files mentioned in the Control file", rptPerd);
						jobMessageDao.poppulateEmailContent("DATA_FILE_FOUND", message.getPayload().getName(), null);
						
					}
					for (String manualFileName : dataFileList) {
						boolean matches = Pattern
								.matches(regex, manualFileName);
						if (!matches) {
							LOGGER.error("Manual File entry "
									+ manualFileName
									+ " in the Control file not matching the file name in DB");
							fileId=jobMessageDao.logProcessAudit(fileId,message.getPayload().getName(), "Data File Name Validation",false,"Data file name is not matching the file name in Database record", rptPerd);
							jobMessageDao.poppulateEmailContent("DATA_FILE_NAME_NOT_MATCHING", message.getPayload().getName(), null);
							//jobMessageDao.updateReqLogStatus(requestLogId,"FAILED");
							queryExec.updateJobStatusAudit(getBatchJobName(messageLog.getCountryCode(), messageLog.getProductList().toArray()[0].toString()), "FAILED", "Dat File Name Validation Failed", getDateFromString(rptPerd));
							throw new OptimaRetailApplicationException(
									requestLogId,
									null,
									null,
									ServiceName.CONTROLLER,
									ExceptionType.ERROR,
									" Exception occured for "
											+ messageLog.getMessageId(),
											"Manual File entry name in the Control file not matching the file name in DB",
											null,jobConfigDao);
						}
						checkLineCount(manualFileName, Long.valueOf(inputCountMap.get(manualFileName)),messageLog,rptPerd);
					}

					/**
					 * In Mtg Count
					 */
					String contFileName=message.getPayload().getName();
					String dataFileLocation=FilePathDetailsCache.getInputFilePath(messageLog.getCountryCode()+"-"+(messageLog.getProductList().toArray()[0]));
					if(contFileName.contains("OR_MTG_IN")|| contFileName.contains("ord_in_mtg")){
						setInMtgInputFileCount(dataFileLocation, 1, "IN-MTG");
					}else if (contFileName.contains("ord_hk_mtg")){
						setInMtgInputFileCount(dataFileLocation, 2, "HK-MTG");
					}
				}
				
			}
		}
		if(!controlFileValid) {
			LOGGER.debug("Control file is not a valid file.");
			//jobMessageDao.updateReqLogStatus(requestLogId, "FAILED");
			fileId=jobMessageDao.logProcessAudit(fileId,message.getPayload().getName(), "Control File Name Validation",false,"Valid Control file is not found in the path", rptPerd);
			jobMessageDao.poppulateEmailContent("CTRL_FILE_NAME_INVALID", message.getPayload().getName(), null);
			throw new OptimaRetailApplicationException(
					requestLogId,null,null,	ServiceName.CONTROLLER,
					ExceptionType.ERROR,
					" Exception occured for " + messageLog.getMessageId(),
					"Control file is not a valid file.", null,jobConfigDao);	
		}
		
		messageLog.setAuditFileId(fileId);
		auditFileId=fileId;
	}
	
	private Date getDateFromString(String rptPerd) {
		if(rptPerd != null){
			Calendar cal = new GregorianCalendar();
			cal.set(Integer.parseInt(rptPerd.substring(0,4)), Integer.parseInt(rptPerd.substring(4,6))-1, Integer.parseInt(rptPerd.substring(6,8)));
			return cal.getTime();
		}
		return null;
	}

	/**
	 * verify all the manual files) are present on disk.
	 * @param fileInformation
	 * @return
	 */
	private boolean checkAllFileAvailable(List<String> fileInformation, String cntryProd,int fileId) {
		File folder = new File(FilePathDetailsCache.getInputFilePath(cntryProd));
		File[] fileArray;
		if(folder.isDirectory()){

			fileArray = folder.listFiles();
			for(String fileName:fileInformation){
				boolean fileFound = false;
				for(File file:fileArray){
					if(ETLConstants.CNTL.equals(getExtension(file))){
						continue;
					}
					if(ETLConstants.DAT.equals(getExtension(file)) && !fileFound){
						if(fileName.contains(file.getName())){
							fileFound=true;
							break;
						}
					}
				}
				if(!fileFound){
					return false;
				}
			}
		}
		return true;
	}	
	
	/**
	 * Get the file extension
	 * @param f
	 * @return
	 */
	 private  String getExtension(File f) {
	        String ext = null;
	        String s = f.getName();
	        int i = s.lastIndexOf('.');

	        if (i > 0 &&  i < s.length() - 1) {
	            ext = s.substring(i+1).toLowerCase();
	        }
	        return ext;
	    }
	
	 /**
	  *Manual file names in control file are delimited with a delimiter to be used with REGEX.
	  * @param eventList
	  * @return
	  */
	private String getConcatenatedRegex(List<EventFileMapVO> eventList){
		StringBuffer sb = new StringBuffer();
		int cnt=0;
		for(EventFileMapVO event : eventList){
		
			sb.append(event.getInputFileName());
			if(cnt!=eventList.size()-1){
				sb.append("|");	
			}
			cnt++;
		}
		return sb.toString();
	}


	
	/**
	 * get manual file details from control files
	 * @param inputFileName
	 * @return
	 */
	private Map<String, List<String>> getControlFileDetails(String inputFileName, String cntryProd) throws Exception {
		Map<String, List<String>> controlFileDetails = new HashMap<String, List<String>>();
		BufferedReader br = null;
		try {
			File controlFile = new File(FilePathDetailsCache.getInputFilePath(cntryProd)  + inputFileName);
			br = new BufferedReader(new FileReader(controlFile));
			LOGGER.info(" controlFile path "+controlFile.getAbsolutePath());
				//fileAuditDetails=new HashMap<String, List<String>>();
				inputCountMap = new HashMap<String, String>();
				
				String lineStr;
				String[] strArray = null;
				List<String> manualFilesList=null;
				List<String> auditFileList=new ArrayList<String>();
				br.readLine();//to skip header
				while ((lineStr = br.readLine()) != null) {
					strArray = StringUtils.delimitedListToStringArray(lineStr, "|");
					
					if(controlFileDetails.get("datafile")==null){
						manualFilesList=new ArrayList<String>();
						controlFileDetails.put("datafile", manualFilesList);
					}
					manualFilesList.add(strArray[0]);
					inputCountMap.put(strArray[0], strArray[3]);
					auditFileList.add(strArray[0]+":::" +strArray[3]+":::"+getFileCreationDate(FilePathDetailsCache.getInputFilePath(cntryProd)+strArray[0]));
				} 
				br.close();
				//fileAuditDetails.put(inputFileName,auditFileList);
				if (lineStr == null) {
					List<String> rptDateList = new ArrayList<String>();
					rptDateList.add(strArray[2]);
					controlFileDetails.put(ETLConstants.REPORT_DATE, rptDateList);
				}
		} catch (FileNotFoundException exception) {
		} catch (IOException e) {
			
		}catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally{
			try{
				if(br!=null){
					br.close();
				}
			}catch(IOException e1){
				
			}
		}

		return controlFileDetails;
	}	
	
	private String getFileCreationDate(String filePath) throws IOException{
		Path file =Paths.get(filePath);
        BasicFileAttributes attributes = null;
        attributes = Files.readAttributes(file, BasicFileAttributes.class);
         FileTime creationTime = attributes.creationTime();
        String creationTimeat = String.valueOf(creationTime);
        String creationTimeTrim = creationTimeat.substring(0, 10);
   
		return creationTimeTrim;
	}
	
	
	public JobMessageDao getJobMessageDao() {
		return jobMessageDao;
	}

	public void setJobMessageDao(JobMessageDao jobMessageDao) {
		this.jobMessageDao = jobMessageDao;
	}

	/**
	 * @return the dataFileList
	 */
	public List<String> getDataFileList() {
		return dataFileList;
	}

	/**
	 * @param dataFileList the dataFileList to set
	 */
	public void setDataFileList(List<String> dataFileList) {
		this.dataFileList = dataFileList;
	}

	public void setFileMovementUtlity(FileMoverUtility fileMovementUtlity) {
		this.fileMovementUtlity = fileMovementUtlity;
	}
	
	private void checkLineCount(String inputFile,Long count, MessageLog messageLog, String rptPerd) throws Exception{
		// TODO Auto-generated method stub
		int skipLines  = 0;
		String contFileName = messageLog.getFileName();
		if(contFileName.contains("OR_MTG_IN")|| contFileName.contains("ord_in_mtg")){
			skipLines = 2;
		}else{
			skipLines = 1;
		}
		
		fileLocation = FilePathDetailsCache.getInputFilePath(messageLog.getCountryCode()+"-"+(messageLog.getProductList().toArray()[0]));
		if (!System.getProperty("os.name").toLowerCase().contains("win")) {
//			BufferedReader reader,ackReader = null;
			
			try(BufferedReader reader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("wc -l "+fileLocation+inputFile).getInputStream()))){
					
					Long datLineCount = Long.parseLong(reader.readLine().split(" ")[0]);
					LOGGER.debug("dat line count is--->>>>"+(datLineCount-skipLines));
					LOGGER.debug("ack line count is----->>>>"+count);
					if(datLineCount.longValue()-skipLines == count.longValue()) {
						jobMessageDao.poppulateEmailContent("INPUT_COUNT_SUCCESS", inputFile, null);
						queryExec.logInputFileAudit(DataAcquisitionHandler.auditFileId,inputFile,
								count.longValue(),datLineCount.longValue()-skipLines,true, new Date());
						queryExec.logProcessAuditErrorStep(DataAcquisitionHandler.auditFileId, inputFile, "Input Record Count Validation", true, "Control file data count matches the Input data file",DataAcquisitionHandler.ctlFileCreationDt,rptPerd);
					} else {
						jobMessageDao.poppulateEmailContent("INPUT_COUNT_FAILED", inputFile, null);
						fileMovementUtlity.moveFileForRequestLog(messageLog.getMessageId(), "FAILED");
						queryExec.logInputFileAudit(DataAcquisitionHandler.auditFileId,inputFile,
								count.longValue(),datLineCount.longValue()-skipLines,false, new Date());
						queryExec.logProcessAuditErrorStep(DataAcquisitionHandler.auditFileId, inputFile, "Input Record Count Validation", false, "Control file data count dosen't match with Input data file",DataAcquisitionHandler.ctlFileCreationDt,rptPerd);
						queryExec.updateJobStatusAudit(getBatchJobName(messageLog.getCountryCode(), messageLog.getProductList().toArray()[0].toString()), "FAILED", "Control file data count dosen't match with Input data file", getDateFromString(rptPerd));
						throw new Exception("line Count mismatch in File: "+inputFile);
					}
				
			}
			catch(Exception e) {
				e.printStackTrace();
				LOGGER.error("Line count mismatch between control and input files"+e.getMessage());
				throw e;
			}
		}
	}
	
	/*private void checkLineCount(String inputFile,Long count, MessageLog messageLog) throws Exception{
		// TODO Auto-generated method stub
		int skipLines  = 0;
		String contFileName = messageLog.getFileName();
		if(contFileName.contains("OR_MTG_IN")|| contFileName.contains("ord_in_mtg")){
			skipLines = 2;
		}else{
			skipLines = 1;
		}
		
		fileLocation = FilePathDetailsCache.getInputFilePath(messageLog.getCountryCode()+"-"+(messageLog.getProductList().toArray()[0]));
		if (System.getProperty("os.name").toLowerCase().contains("win")) {
//			BufferedReader reader,ackReader = null;
			
			//try(BufferedReader reader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("wc -l "+fileLocation+inputFile).getInputStream()))){
					System.out.println("control file nae is--->>>>"+contFileName);
					System.out.println("skip lines value is----->>>>"+skipLines);
					
					Long datLineCount = Long.parseLong("20");
					LOGGER.debug("dat line count is--->>>>"+(datLineCount-skipLines));
					LOGGER.debug("ack line count is----->>>>"+count);
					if(datLineCount.longValue()-skipLines == count.longValue()) {
						jobMessageDao.poppulateEmailContent("INPUT_COUNT_SUCCESS", inputFile, null);
						queryExec.logInputFileAudit(DataAcquisitionHandler.auditFileId,inputFile,
								count.longValue(),datLineCount.longValue()-skipLines,true, new Date());
						queryExec.logProcessAuditErrorStep(DataAcquisitionHandler.auditFileId, inputFile, "Input Record Count Validation", true, "Control file data count matches the Input data file",DataAcquisitionHandler.ctlFileCreationDt);
					} else {
						jobMessageDao.poppulateEmailContent("INPUT_COUNT_FAILED", inputFile, null);
						fileMovementUtlity.moveFileForRequestLog(messageLog.getMessageId(), "FAILED");
						queryExec.logInputFileAudit(DataAcquisitionHandler.auditFileId,inputFile,
								count.longValue(),datLineCount.longValue()-skipLines,false, new Date());
						queryExec.logProcessAuditErrorStep(DataAcquisitionHandler.auditFileId, inputFile, "Input Record Count Validation", false, "Control file data count dosen't match with Input data file",DataAcquisitionHandler.ctlFileCreationDt);
						throw new Exception("line Count mismatch in File: "+inputFile);
					}
				
			}
			catch(Exception e) {
				e.printStackTrace();
				LOGGER.error("EEEEEEEEEEEEEEEEEEEERRRRRRRRRRRROR---"+e.getMessage());
				throw e;
			}
		}
	}*/
	
	private void setInMtgInputFileCount(String filePath, int i, String type){
		if(inputCountMap!=null){
			StringBuilder fileArguments=new StringBuilder("./FindRecCount.sh "+ type +" ");
			for (String fileName : inputCountMap.keySet()) {
				if (fileName.contains("_rec_") || fileName.contains("_hksi") || fileName.contains("GCBC") || fileName.contains("GCL") ||fileName.contains("OREO")){
					fileArguments.append(filePath);
					fileArguments.append(fileName);
					fileArguments.append(",");
					fileArguments.append(i);
					fileArguments.append(" ");
				}
			}
			Process p;
			try {
				LOGGER.debug("IN Mtg Input file record count process starts : Executing the script file path ="+fileArguments.toString());
				p = Runtime.getRuntime().exec(fileArguments.toString());
				p.waitFor();
				BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
				inMtgCount = reader.readLine();
				LOGGER.debug("IN Mtg Input file record count getting process Finished successfully and the record count is "+inMtgCount);
			} catch (InterruptedException e) {
				LOGGER.error("ERROR Process failed IN Mtg file record count process :"+e);
			} catch (IOException e) {
				LOGGER.error("ERROR Process failed IN Mtg file record count process :"+e);
			}

		}

	}
	
	private String getBatchJobName(String country, String product){
		List<String> batchNameDetl = queryExec.getBatchNamesList();
		for(String batchName : batchNameDetl){
			if(batchName != null){
				if(batchName.toLowerCase().contains(country.toLowerCase()) && batchName.toLowerCase().contains(product.toLowerCase())){
					return batchName;
				}
			}
		}
		return null;
	}
	
	private void moveZipFile(String cntFileName)
	{
		
	}

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
}
