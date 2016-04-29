/**
 * 
 */
package com.citi.retail.optima.etl.batch.tasklet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;

import com.citi.optima.batch.job.jdbc.ETLQueryExecutor;
import com.citi.retail.optima.etl.common.ETLConstants;
import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.db.dao.JobConfigDao;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.OptimaRetailDataException;
import com.citi.retail.optima.etl.common.exception.OptimaRetailDataExceptionDetail;
import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;
import com.citi.retail.optima.etl.common.log.LoggingMarker;
import com.citi.retail.optima.etl.common.model.RainbowFileFooter;
import com.citi.retail.optima.etl.common.model.TRLArchiveDetailsCache;
import com.citi.retail.optima.etl.context.CustomMethodsProvider;
import com.citi.retail.optima.etl.controller.dao.JobMessageDao;
import com.citi.retail.optima.etl.controller.model.CheckSumDetailsCache;
import com.citi.retail.optima.etl.controller.model.CheckSumDetailsVO;

/**
 * @author sr67841
 * @param <T>
 * 
 */
public class FileMergeTasklet extends AggregationResultTasklet<T> {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(FileMergeTasklet.class);

	private String outputDirectory;
	private String inputDirectory;
	private String archiveDirectory;



	private String header;

	private String format;

	private List<RainbowFileFooter> footerItemList;
		
	private Boolean pl_rc_merge_flag = false;
	Timestamp startTime = new Timestamp(System.currentTimeMillis());;
	private String fileName = "filename";
	private ExecutionContext currentExecutionContext;
	private Long auditFileId;
	private JobMessageDao jobMessageDao;
	private String rainbowFileName;
	private static ETLQueryExecutor queryExec;
	private final static String OS = System.getProperty("os.name").toLowerCase();
	private String inputFileCount;

	private String enrOutputCheckSum;

	private String upbOutputCheckSum;

	private List<String> trlNamesList;
	
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
	
	/**
	 * @return the outputDirectory
	 */
	public String getOutputDirectory() {
		return outputDirectory;
	}

	/**
	 * @param outputDirectory the outputDirectory to set
	 */
	public void setOutputDirectory(String outputDirectory) {
		this.outputDirectory = outputDirectory;
	}
	
	public String getArchiveDirectory() {
		return archiveDirectory;
	}

	public void setArchiveDirectory(String archiveDirectory) {
		this.archiveDirectory = archiveDirectory;
	}
	
	@Override
	public RepeatStatus execute(StepContribution stepContribution,
			ChunkContext chunkContext) throws Exception {
		
		
		ExecutionContext jobExecutionContext_dup = chunkContext
				.getStepContext().getStepExecution().getJobExecution()
				.getExecutionContext();	
		
		String itemsToDelete = null;
		for(RainbowFileFooter footer : footerItemList){
			if(itemsToDelete == null){
				itemsToDelete = footer.getOutputFileResourceName()+ETLConstants.DAT;
			} else{
				itemsToDelete = itemsToDelete+","+footer.getOutputFileResourceName()+ETLConstants.DAT;
			}
		}
		chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext().putString("ITEM_TO_DELETE", itemsToDelete);
			
		Long contFileCount=0L;	
		String footer = "---";
		Long cbRecCount = 0L;
		Long arRecCount = 0L;
		Long auditTrlRecordCount=0L;
		Long checkCount= 0L;
		String currentJobName = "";
		try {

			long startTime = Calendar.getInstance().getTimeInMillis();
			LOGGER.debug(" Merging started --------------------------- "
					+ startTime);

			ExecutionContext jobExecutionContext = chunkContext
					.getStepContext().getStepExecution().getJobExecution()
					.getExecutionContext();
			if(jobExecutionContext.get("writeRecordCount") != null){
				
			Long writeRecordCount = jobExecutionContext
					.getLong("writeRecordCount");

			if (writeRecordCount != null) {
				jobExecutionContext.remove("writeRecordCount");
			}
			boolean terminationFlag=false;
			String trlIndFileName="";
			String trlCBFileName="";
			for (RainbowFileFooter footerItem : footerItemList) {
				
				// This is for not writing for Exclude Records
				
				if (!footerItem.getHashField().isEmpty()){
					if(footerItem.getHashFileType().equalsIgnoreCase("BAL_TYP")){
						trlCBFileName=footerItem.getOutputFileResourceName()+ETLConstants.DAT;
						if(jobExecutionContext.get("cbWriteRecordCount") != null){
							cbRecCount = jobExecutionContext
									.getLong("cbWriteRecordCount");
							if (cbRecCount != null) {
									jobExecutionContext.remove("cbWriteRecordCount");
							}
						}
							if(jobExecutionContext.get("commonBalanceSum") != null){
								if(jobExecutionContext
										.getLong("commonBalanceSum") > 0) {
									footer = String.format(format, "TRL", cbRecCount,
											footerItem.getHashFileType(), jobExecutionContext
													.getLong("commonBalanceSum"));
									auditTrlRecordCount=cbRecCount;
									
//									LOGGER.info(LoggingMarker.KPI.getMarker(),"Write count for CB: "+cbRecCount);
								} else {
									footer = String.format(format, "TRL", 0,
											footerItem.getHashFileType(), jobExecutionContext
													.getLong("commonBalanceSum"));
									auditTrlRecordCount=0L;
//									LOGGER.info(LoggingMarker.KPI.getMarker(),"Write count for CB: "+0);
								}
								if((Long)jobExecutionContext.getLong("commonBalanceSum") != null){
									jobExecutionContext.remove("commonBalanceSum");
								}
							}
						
					}
					else if(jobExecutionContext.get("isAR") != null && jobExecutionContext.getString("isAR").equalsIgnoreCase("yes")  && footerItem.getHashFileType().equalsIgnoreCase("RTE_VARTYP")){
						if(jobExecutionContext.get("arWriteRecordCount") != null){
							arRecCount = jobExecutionContext
									.getLong("arWriteRecordCount");
							if (arRecCount != null) {
									jobExecutionContext.remove("arWriteRecordCount");
							}
						}
						if(jobExecutionContext.get("rateVarTypeIdSum") != null){
							if(jobExecutionContext
									.getLong("rateVarTypeIdSum") > 0 ) {
							footer = String.format(format, "TRL", arRecCount,
									footerItem.getHashFileType(), jobExecutionContext
											.getLong("rateVarTypeIdSum"));
							auditTrlRecordCount=arRecCount;
//							LOGGER.info(LoggingMarker.KPI.getMarker(),"Write count for AR: "+arRecCount);
							} else {
								footer = String.format(format, "TRL", 0,
										footerItem.getHashFileType(), jobExecutionContext
												.getLong("rateVarTypeIdSum"));
								auditTrlRecordCount=0L;
//								LOGGER.info(LoggingMarker.KPI.getMarker(),"Write count for AR: "+0);
							}
							if((Long)jobExecutionContext.getLong("rateVarTypeIdSum") != null){
								jobExecutionContext.remove("rateVarTypeIdSum");
							}
						}
					
					}
					else{
						
						if(jobExecutionContext
								.getLong(footerItem.getHashField()) > 0) {
							footer = String.format(format, "TRL", writeRecordCount,
									footerItem.getHashFileType(), jobExecutionContext
											.getLong(footerItem.getHashField()));
							auditTrlRecordCount=writeRecordCount;
//							LOGGER.info(LoggingMarker.KPI.getMarker(),"Write count for "+footerItem.getOutputFileResourceName().split("_")[9]+": "+writeRecordCount);
						} else {
							footer = String.format(format, "TRL", 0,
									footerItem.getHashFileType(), jobExecutionContext
											.getLong(footerItem.getHashField()));
							auditTrlRecordCount=0L;
//							LOGGER.info(LoggingMarker.KPI.getMarker(),"Write count for "+footerItem.getOutputFileResourceName().split("_")[9]+": "+0);
						}
						/**
						 * Audit Indicative check required
						 */
						if(footerItem.getHashFileType().equalsIgnoreCase("FINSERVTYP")){
							trlIndFileName=footerItem.getOutputFileResourceName()+ETLConstants.DAT;
							JobParameters jobParams = chunkContext.getStepContext().getStepExecution().getJobExecution().getJobInstance().getJobParameters();
                            String jobNames = jobParams.getString(ETLConstants.JOB_NAME);
                            currentJobName = jobNames;
                            Map<String, Long> inputFilesCountMap = queryExec.getInputFilesCountMap(auditFileId);
                            if (jobNames.contains("IN-RC")){
                                  contFileCount = 0L;
//                                  contFileCount = contFileCount+inputFilesCountMap.get(ETLConstants.DA_IN_CORPMAST_FILE_TYP);
//                                  contFileCount = contFileCount+ inputFilesCountMap.get(ETLConstants.DA_IN_RETMAST_FILE_TYP);
//                                  contFileCount = contFileCount+ inputFilesCountMap.get(ETLConstants.DA_IN_RWMAST_FILE_TYP);

                            }else if(jobNames.contains("HK-CRD")) {
                            	for(String key : inputFilesCountMap.keySet()){
                            		if(key.contains("merge_data_limit")){
                            			contFileCount = contFileCount + inputFilesCountMap.get(key);
                            		}
                            	}
                            	
                            }else if (jobNames.contains("HK-MTG")){
                            	contFileCount = (long) Integer.parseInt(getInputFileCount());
                            	
                            }else if (jobNames.contains("IN-MTG")){
                            	contFileCount = (long) Integer.parseInt(getInputFileCount());
                            }
                            	else{
                            		contFileCount = inputFilesCountMap.get(rainbowFileName);
                            }
                          		if(contFileCount.longValue()==auditTrlRecordCount.longValue()){
									terminationFlag=true;
									checkCount=auditTrlRecordCount;
									Map<String, String> argMap = new HashMap<String, String>();
									argMap.put("#COUNT#", contFileCount.toString());
									queryExec.logProcessAuditErrorStep(auditFileId.intValue(),trlIndFileName , "Output Record Count Validation", true, "Output Record Count Validation success, Input count :"+contFileCount.longValue()+", Output count :"+auditTrlRecordCount.longValue(),queryExec.getCntFileName(auditFileId.intValue()).split("_")[4], null);
									 jobMessageDao.poppulateEmailContent("OUTPUT_COUNT_SUCCESS", trlIndFileName, argMap);
									} else{
										Map<String, String> argMap = new HashMap<String, String>();
										checkCount=auditTrlRecordCount;
										argMap.put("#INPUT#", rainbowFileName);
										argMap.put("#EXP#", contFileCount.toString());
										argMap.put("#ACT#", checkCount.toString());
										jobMessageDao.poppulateEmailContent("OUTPUT_COUNT_FAILED", trlIndFileName,argMap);
										queryExec.logProcessAuditErrorStep(auditFileId.intValue(),trlIndFileName , "Output TRL Record Match", false, "Processed TRL file record count is not matched with cnt file count"
												,queryExec.getCntFileName(auditFileId.intValue()).split("_")[4], null);
										//deletePartiallyCreatedFiles();
										LOGGER.error(LoggingMarker.KPI.getMarker(), "Indicative Trl record dosen't match with Input Recore  :: "+trlIndFileName);		
									throw new Exception("Processed TRL file record count is not matched with cnt file count");
									}
						}
					}
					/**
					 * Audit Logging
					 */
					String auditFileName=footerItem.getOutputFileResourceName();
					int trlId=queryExec.getFileId( 0,"TRL_ID","HDA_AUDIT_TRL_FILE_DETS");
					queryExec.logOutputFileAudit(auditFileId, auditFileName+ETLConstants.DAT, new Timestamp(System.currentTimeMillis()), auditTrlRecordCount,trlId);
					
				}else {
					if(jobExecutionContext.get("eWriteRejectCount") != null && jobExecutionContext.getLong("eWriteRejectCount")>0){
						LOGGER.info(LoggingMarker.KPI.getMarker(),"Write count for "+footerItem.getOutputFileResourceName().split("_")[9]+": "+jobExecutionContext.get("eWriteRejectCount")+"\n");
					}
//					LOGGER.info(LoggingMarker.KPI.getMarker(),"Write count for "+footerItem.getOutputFileResourceName().split("_")[9]+": "+0+"\n");
				}
				try {
					
					createHeaderAndFooterFiles(footer,footerItem.getOutputFileResourceName()+ETLConstants.DAT);
					
					LOGGER.debug("File sent for merger" + footerItem.getOutputFileResourceName()+ETLConstants.DAT);
					if(!(OS.indexOf("win") >= 0)){
						String mergeCommand = "./FileMerger.ksh "  +  outputDirectory + " " + footerItem.getOutputFileResourceName()+ETLConstants.DAT;
						 LOGGER.info(" Merge Command "+mergeCommand);
						 Process p = Runtime.getRuntime().exec(mergeCommand);
						 p.waitFor();
						 LOGGER.info(" Merge Command is Successfull");	
					// checksum check
					 //getOutputCksum()
					/*if (!footerItem.getHashField().isEmpty()){
                         if(footerItem.getHashFileType().equalsIgnoreCase("BAL_TYP")){
                             String fileName = footerItem.getOutputFileResourceName()+ETLConstants.DAT;
                             //String []jobNames = jobExecutionContext.getString(key)
                                         //chunkContext.getStepContext().getJobParameters();
                             
                        }
                         if(footerItem.getHashFileType().equalsIgnoreCase("FINSERVTYP")){
                        	String arFinStatTypeIdInputCkSum = CustomMethodsProvider.arFinStatTypIDCkSum.toString();
                        	String arPastDueAgeClassInputCkSum = CustomMethodsProvider.arPastDueAgeClassCkSum.toString();
                        	 String fileName = footerItem.getOutputFileResourceName()+ETLConstants.DAT;
                        	 String jobNames = chunkContext.getStepContext().getStepExecution().getJobExecution().getJobInstance().getJobParameters().getString(ETLConstants.JOB_NAME);
                        	String arFinStatTypeIdOutputCkSum = getIndFileCksum(fileName, jobNames, "ARFINSTATTYPID");
                        	String arPastDueAgeClassOutCkSum = getIndFileCksum(fileName, jobNames, "ARPASTDUECLASS");
                        	isCheckSumSuccess(arFinStatTypeIdInputCkSum,arFinStatTypeIdOutputCkSum,jobNames,"ARFINSTATTYPID",fileName);
                            isCheckSumSuccess(arPastDueAgeClassInputCkSum,arPastDueAgeClassOutCkSum,jobNames,"ARPASTDUECLASS",fileName);
                         }
                         
}*/
						 //new changes on aug20
						 String country= chunkContext.getStepContext().getStepExecution().getJobExecution().getJobInstance().getJobParameters().getString(ETLConstants.COUNTRY_CODE_UPPER);
						 String product = chunkContext.getStepContext().getStepExecution().getJobExecution().getJobInstance().getJobParameters().getString(ETLConstants.PRODUCT_CODE_UPPER);
						 String cntryProd = country + ETLConstants.DA_JOBNAME_SEP + product;
						trlNamesList = queryExec.getTRLNamesOnCntryProd(cntryProd);
						//for(String trlName : trlNamesList){
						if(trlNamesList.contains(ETLConstants.DA_CB_FILE_NM) && footerItem.getOutputFileResourceName().split(ETLConstants.FILE_SEPR)[9].equals(ETLConstants.DA_CB_FILE_NM)){
							List<CheckSumDetailsVO> outputCkSumDetailsLis = CheckSumDetailsCache.getCheckSumDetailsListWithCntrProd(cntryProd+ETLConstants.FILE_SEPR+footerItem.getOutputFileResourceName().split(ETLConstants.FILE_SEPR)[9]);
							
							for(CheckSumDetailsVO checkSumDetials : outputCkSumDetailsLis){
								
									String trlFileName = footerItem.getOutputFileResourceName()+ETLConstants.DAT;
									
									//queryExec.insertTRLCheckSumDetails(chunkContext.getStepContext().getStepExecution().getJobExecution().getJobInstance().getJobParameters().getString(ETLConstants.DA_CONTROL_FILE_NAME),trlFileName,checkSumDetials,checkSum);
									if(checkSumDetials.getCksumBalType() != null && checkSumDetials.getCksumBalType().equals(ETLConstants.ENR_VALUE)){
										enrOutputCheckSum = getOutputCksum(trlFileName, cntryProd,checkSumDetials);
										String enrInputCksum="";
			                             if(cntryProd.contains("TW-CRD") || cntryProd.contains("TW-RCL") || cntryProd.contains("TW-PCL")){
			                            	 enrInputCksum = chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext().get("twEnrInputCheckSum").toString();
			                            	 LOGGER.error("Calculated TW CRD/RC Product Input checksum value is :"+enrInputCksum);
			                            	 
			                             }else {
			                            	 enrInputCksum = chunkContext.getStepContext().getStepExecution().getJobExecution().getJobInstance().getJobParameters().getString(ETLConstants.DA_ENR_INPUT_CKSUM);
			                             }
			                             
			                             isCheckSumSuccess(enrInputCksum,enrOutputCheckSum,cntryProd,checkSumDetials.getCksumBalType(),trlFileName,checkSumDetials.getCksumFieldName());
									} else if(checkSumDetials.getCksumBalType() != null && checkSumDetials.getCksumBalType().equals(ETLConstants.UPB_VALUE)){
										upbOutputCheckSum = getOutputCksum(trlFileName, cntryProd,checkSumDetials);
										 String upbInputCksum = "";
										 if(cntryProd.toUpperCase().contains("HK-PCL")){
											 upbInputCksum = chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext().get("hkUpbInputCheckSum").toString();
										 } else{
											 upbInputCksum = chunkContext.getStepContext().getStepExecution().getJobExecution().getJobInstance().getJobParameters().getString(ETLConstants.DA_UPB_INPUT_CKSUM);
										 }
										 isCheckSumSuccess(upbInputCksum,upbOutputCheckSum,cntryProd,checkSumDetials.getCksumBalType(),trlFileName,checkSumDetials.getCksumFieldName());
									}
								}
								
							}
							
						}
					 
				} catch (Exception e) {
					e.printStackTrace();
					LOGGER.error(" Error while merging "+e);
					OptimaRetailDataException optimaRetailException = new OptimaRetailDataException(
							ServiceName.BATCH, ExceptionType.FATAL,
							new ArrayList());
					throw new OptimaRetailApplicationException(null, null,
							batchInstanceId, ServiceName.BATCH,
							ExceptionType.ERROR, "Error merging files", e.getMessage(),
							OptimaRetailExceptionUtil.getStackTrace(e),
							optimaRetailException,jobConfigDao);
				}
				

			}
			/** Audit CNT file Validation 
			 * 
			 */
			/*if(!terminationFlag){
				Map<String, String> argMap = new HashMap<String, String>();
				argMap.put("#INPUT#", rainbowFileName);
				argMap.put("#EXP#", contFileCount.toString());
				argMap.put("#ACT#", checkCount.toString());
				jobMessageDao.poppulateEmailContent("OUTPUT_COUNT_FAILED", trlIndFileName,argMap);
				queryExec.logProcessAuditErrorStep(auditFileId.intValue(),trlIndFileName , "Output TRL Record Match", false, "Processed TRL file record count is not matched with cnt file count"
						,queryExec.getCntFileName(auditFileId.intValue()).split("_")[4]);
				//jobMessageDao.poppulateEmailContent("Output Record Count Validation Fail", trlIndFileName);
				LOGGER.error(LoggingMarker.KPI.getMarker(), "Indicative Trl record dosen't match with Input Recore  :: "+trlIndFileName);		
			throw new Exception("Processed TRL file record count is not matched with cnt file count");
			//return null;	
			}*/
			
			try{
				 String filename = (String) footerItemList.get(0).getOutputFileResourceName();
				 String[] prodFind_split = filename.split("_");				 				
				 String prodFind =prodFind_split[2] ;
				 
				 String prodType ;
				 if(prodFind.equalsIgnoreCase("pcl"))
				 {
					 prodType="LOANS";
				 }
				 else if(prodFind.equalsIgnoreCase("rcl"))
				 {
					 prodType="RC";
				 }
				 else if(prodFind.equalsIgnoreCase("mtg"))
				 {
					 prodType="MTG";
				 }
				 else
				 {
					 prodType="CARDS";
				 }
				 
				 if (prodType.equals("CARDS") || prodType.equals("MTG"))
				 {
					 createAckFile(false,chunkContext.getStepContext().getStepExecution().getJobExecution().getJobInstance().getJobParameters().getString(ETLConstants.DA_CONTROL_FILE_NAME));
//					 for (RainbowFileFooter footerItem : footerItemList) {
//						 if (!footerItem.getHashField().isEmpty())
//							 new File(outputDirectory
//									 + footerItem.getOutputFileResourceName()
//									 + ETLConstants.ACK).createNewFile();
//
//					 }
				 }
				 
				 
				 if(prodType.equals("LOANS"))
				 {
					 final String pattern = ".dat";
				     GenericExtFilter filter  = new GenericExtFilter(pattern);					   
				     
				     File outputDir = new File(outputDirectory);
					 String[] filesinOutputDir = outputDir.list(filter);	
					 String[] file1_parts;
		
						for(int i =0; i<footerItemList.size();i++)
						{
							String file1 = (String) footerItemList.get(i).getOutputFileResourceName()+ETLConstants.DAT;
							
							file1_parts = file1.split("_");
							
							for(String file2 : filesinOutputDir)
							{
								if(containsIgnoreCase(file2,"_rcl") && file2.contains(file1_parts[3]) && file2.contains(file1_parts[4]) && file2.contains(file1_parts[6]) && file2.contains(file1_parts[9]+"_"))
								{
									 LOGGER.info(" Merge for PL RC files Started");
									 String merge_PL_RC_files = "./FileAppender.sh "  + outputDirectory + file1 + " " + outputDirectory + file2;
									 LOGGER.info(" Merge Command "+merge_PL_RC_files);
									 Process p2 = Runtime.getRuntime().exec(merge_PL_RC_files);
									 p2.waitFor();
									 LOGGER.info("PL RC File  Merge  is Successfull");
									 pl_rc_merge_flag = true;
									
								}
							}
							
							
						}		
						if(pl_rc_merge_flag){
							createAckFile(false, chunkContext.getStepContext().getStepExecution().getJobExecution().getJobInstance().getJobParameters().getString(ETLConstants.DA_CONTROL_FILE_NAME));
//							 for (RainbowFileFooter footerItem : footerItemList) {
//								 if (!footerItem.getHashField().isEmpty())
//										new File(outputDirectory
//												+ footerItem.getOutputFileResourceName()
//												+ ETLConstants.ACK).createNewFile();
//								 
//								 }
						}
				 }
				 
				 if(prodType.equals("RC"))
				 {
					 final String pattern = ".dat";
				     GenericExtFilter filter  = new GenericExtFilter(pattern);
				   
				     
				     File outputDir = new File(outputDirectory);
					 String[] filesinOutputDir = outputDir.list(filter);					 
					 String[] file1_parts;
					 
						for(int i =0; i<footerItemList.size();i++)
						{
							String file1 = (String) footerItemList.get(i).getOutputFileResourceName()+ETLConstants.DAT;
							file1_parts = file1.split("_");
							
							for(String file2 : filesinOutputDir)
							{
								if(containsIgnoreCase(file2,"_pcl") && file2.contains(file1_parts[3]) && file2.contains(file1_parts[4]) && file2.contains(file1_parts[6]) && file2.contains(file1_parts[9]+"_"))
								{
									 LOGGER.info(" Merge for PL RC files Started");
									 String merge_PL_RC_files = "./FileAppender.sh "  + outputDirectory + file2 + " " + outputDirectory + file1;
									 LOGGER.info(" Merge Command "+merge_PL_RC_files);
									 Process p2 = Runtime.getRuntime().exec(merge_PL_RC_files);
									 p2.waitFor();
									 LOGGER.info("PL RC File  Merge  is Successfull");
									 pl_rc_merge_flag = true;
								}
							}		
						}
						if(pl_rc_merge_flag){
							createAckFile(true,chunkContext.getStepContext().getStepExecution().getJobExecution().getJobInstance().getJobParameters().getString(ETLConstants.DA_CONTROL_FILE_NAME));
							
//							 for (RainbowFileFooter footerItem : footerItemList) {
//								 if (!footerItem.getHashField().isEmpty())
//								 {
//									 String orig_rc_ack_file_name = footerItem.getOutputFileResourceName();
//									 String rc_ack_replace_to_loans = orig_rc_ack_file_name.replace("RCL", "PCL");
//										new File(outputDirectory
//												+ rc_ack_replace_to_loans
//												+ ETLConstants.ACK).createNewFile();
//								 }
//								 
//								 }
							}
				 }
				 
				// Added for SPLIT file removal
			 if(!(OS.indexOf("win") >= 0)){
					 String removeSplitFilesCommand = "./SplitFileRemover.sh "  + inputDirectory +  " " + chunkContext.getStepContext().getStepExecution().getJobExecution().getJobInstance().getJobParameters().getString(ETLConstants.DATA_FILE_LIST);
					 LOGGER.info(" Split File Removal Command "+removeSplitFilesCommand);
					 Process p2 = Runtime.getRuntime().exec(removeSplitFilesCommand);
					 p2.waitFor();
					 LOGGER.info(" Split File Removal is Successfull");
				 }
			}
			
			catch (Exception e) {
				e.printStackTrace();
				throw new Exception(" Error while merging PL - RC Files"+e);
			}					

			long endTime = Calendar.getInstance().getTimeInMillis();
			LOGGER.debug("Mergning took ---  "
					+ (endTime - startTime) / 1000d + " Seconds");
			}
		} catch (Exception e) {
			List<OptimaRetailDataExceptionDetail> optimaRetailSkippableList = new ArrayList<OptimaRetailDataExceptionDetail>();
			OptimaRetailDataExceptionDetail optimaRetailSkippable = new OptimaRetailDataExceptionDetail();
			optimaRetailSkippable.setUserErrorMessage("Error while merging files");
			optimaRetailSkippable
					.setExceptionMessage(e.getMessage() == null ? e.getClass()
							.getName() : e.getMessage());
			optimaRetailSkippable.setRule("");
			optimaRetailSkippable.setAttributeName("");
			optimaRetailSkippable.setExceptionType(ExceptionType.FATAL);
			optimaRetailSkippable.setStackTrace(OptimaRetailExceptionUtil
					.getStackTrace(e));
			optimaRetailSkippableList.add(optimaRetailSkippable);
			OptimaRetailDataException optimaRetailException = new OptimaRetailDataException(
					ServiceName.BATCH, ExceptionType.FATAL,
					optimaRetailSkippableList);

			throw new OptimaRetailApplicationException(null, null,
					batchInstanceId, ServiceName.AGGREGATION,
					ExceptionType.ERROR, "Error merging files", e.getMessage(),
					OptimaRetailExceptionUtil.getStackTrace(e),
					optimaRetailException,jobConfigDao);
		}

		return RepeatStatus.FINISHED;
	}

//	private void deletePartiallyCreatedFiles() {
//		String itemsToDelete = null;
//		for(RainbowFileFooter footer : footerItemList){
//			if(itemsToDelete == null){
//				itemsToDelete = footer.getOutputFileResourceName()+ETLConstants.DAT;
//			} else{
//				itemsToDelete = itemsToDelete+","+footer.getOutputFileResourceName()+ETLConstants.DAT;
//			}
//		}
//		if (!System.getProperty("os.name").toLowerCase().contains("win")) {
//			
//			try {
//				Runtime.getRuntime().exec("./FileRemover.sh " + outputDirectory+ETLConstants.SPACE_STR+itemsToDelete);
//				LOGGER.info("Command to delete files :: "+"./FileRemover.sh " + outputDirectory+ETLConstants.SPACE_STR+itemsToDelete );
//			} catch (IOException e) {
//				LOGGER.error("Error occued while deleting partially created files:: "+ e.getMessage());
//			}
//		}
//			
//	}

	private void isCheckSumSuccess(String inputCksum, String outputCksum, String cntryProd, String cksumFieldType, String fileName, String ckFieldName) throws Exception {
		String roundOffInputCkSum = "";
		String roundOffOutputCkSum = "";
		//try{
		LOGGER.debug("Inputchecksum in filemerger : " + inputCksum);
			if(inputCksum == null){
				roundOffInputCkSum ="0.0";
			} else if(inputCksum.equals(ETLConstants.EMPTY_STR)){
				roundOffInputCkSum ="0.0";
			}else{
				inputCksum = new BigDecimal(inputCksum).setScale(5, BigDecimal.ROUND_HALF_UP).toString();
				LOGGER.debug("Calculated Input checksum value for fiedl type "+cksumFieldType+"is : "+inputCksum);
				roundOffInputCkSum = new BigDecimal(inputCksum).setScale(0, BigDecimal.ROUND_UP).toString();
			}
			if( outputCksum == null){
				roundOffOutputCkSum= "0.0";
			} else if( outputCksum.equals(ETLConstants.EMPTY_STR)){
				roundOffOutputCkSum= "0.0";
			} else{
				outputCksum = new BigDecimal(outputCksum).setScale(5, BigDecimal.ROUND_HALF_UP).toString();
		        LOGGER.debug("Calculated Output checksum value for fiedl type "+cksumFieldType+"is : "+outputCksum);
		        roundOffOutputCkSum = new BigDecimal(outputCksum).setScale(0, BigDecimal.ROUND_UP).toString();
			}
			
	        LOGGER.debug(" Round off Input checksum : "+roundOffInputCkSum+"("+inputCksum+")");
	        LOGGER.debug(" Round off Output checksum : "+roundOffOutputCkSum+"("+outputCksum+")");
	        Map<String, String> messageMap = new HashMap<String, String>();
	        messageMap.put("#IN_CKSUM#", roundOffInputCkSum+"("+inputCksum+")");
	        messageMap.put("#OUT_CKSUM#", roundOffOutputCkSum+"("+outputCksum+")");
			 String []cntryProdDetails = cntryProd.split(ETLConstants.DA_JOBNAME_SEP);
	        messageMap.put("#CNT#", cntryProdDetails[0]);
	        messageMap.put("#PROD#", cntryProdDetails[1]);
	        messageMap.put("#CKSUM_FIELD#", ckFieldName);
	        
	        if (roundOffInputCkSum.equals(roundOffOutputCkSum)){
	       	 LOGGER.debug("Checksum success");
	              queryExec.logProcessAuditErrorStep(auditFileId.intValue(),fileName , "Checksum Validation", true, "Checksum Validation success for "+cksumFieldType+" field, Input checksum :"+roundOffInputCkSum+"("+inputCksum+")"+", Output checksum :"+roundOffOutputCkSum+"("+outputCksum+")",queryExec.getCntFileName(auditFileId.intValue()).split("_")[4], null);
	              jobMessageDao.poppulateEmailContent("CKSUM_SUCCESS", fileName, messageMap);

	        }else{
	              queryExec.logProcessAuditErrorStep(auditFileId.intValue(),fileName , "Checksum Validation", false, "Checksum Validation failed for "+cksumFieldType+" field, Input checksum :"+roundOffInputCkSum+"("+inputCksum+")"+", Output checksum :"+roundOffOutputCkSum+"("+outputCksum+")",queryExec.getCntFileName(auditFileId.intValue()).split("_")[4], null);
	              jobMessageDao.poppulateEmailContent("CKSUM_FAILED", fileName, messageMap);
	              //deletePartiallyCreatedFiles();
	              throw new Exception("Checksum Validation failed between Input and TRL file");
	              
	         }
		//}
		//catch(Exception e){
		//	e.printStackTrace();
		//	throw new Exception("Checksum Validation failed between Input and TRL file");
		//}
		
	}

	private void createHeaderAndFooterFiles(String footer, String fileName) throws FileNotFoundException,
			IOException {
		
		OutputStream headerWriter = null;
		OutputStream footerWriter = null;
		
		try{
			File headerFile = new File(outputDirectory+"HEAD_"+fileName);
			headerWriter = new FileOutputStream(headerFile);
			headerWriter.write((header+"\n").getBytes());
			
			File footerFile = new File(outputDirectory+"Footer_"+fileName);
			footerWriter = new FileOutputStream(footerFile);
			footerWriter.write(footer.getBytes());
			
		}finally{
			if(headerWriter!=null)
				headerWriter.close();
			if(footerWriter!=null)
				footerWriter.close();
		}
		
		
		
	}

	public List<RainbowFileFooter> getFooterItemList() {
		return footerItemList;
	}

	public void setFooterItemList(List<RainbowFileFooter> footerItemList) {
		this.footerItemList = footerItemList;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public void setHeader(String header) {
		this.header = header;
	}
	
	 public static boolean containsIgnoreCase(String str, String searchStr) {
	        if (str == null || searchStr == null) {
	            return false;
	        }
	        int len = searchStr.length();
	        int max = str.length() - len;
	        for (int i = 0; i <= max; i++) {
	            if (str.regionMatches(true, i, searchStr, 0, len)) {
	                return true;
	            }
	        }
	        return false;
	    }
	
	
	
	
	 // inner class, generic extension filter
    public class GenericExtFilter implements FilenameFilter {

        private String ext;

        public GenericExtFilter(String ext) {
            this.ext = ext;
        }

        public boolean accept(File dir, String name) {
            return (name.endsWith(ext));
        }
    }

	/**
	 * @return the auditFileId
	 */
	public Long getAuditFileId() {
		return auditFileId;
	}

	/**
	 * @param auditFileId the auditFileId to set
	 */
	public void setAuditFileId(Long auditFileId) {
		this.auditFileId = auditFileId;
	}

	/**
	 * @return the jobMessageDao
	 */
	public JobMessageDao getJobMessageDao() {
		return jobMessageDao;
	}

	/**
	 * @param jobMessageDao the jobMessageDao to set
	 */
	public void setJobMessageDao(JobMessageDao jobMessageDao) {
		this.jobMessageDao = jobMessageDao;
	}

	public String getRainbowFileName() {
		return rainbowFileName;
	}

	public void setRainbowFileName(String rainbowFileName) {
		this.rainbowFileName = rainbowFileName;
	}
	
	private String getOutputCksum(String fileName, String cntProdCd, CheckSumDetailsVO checkSumDetailsVO)
	{
		String count = ETLConstants.EMPTY_STR;
		LOGGER.info("Inside getOutputChecksum():");
		LOGGER.info("checkSumDetails "+ checkSumDetailsVO.getOutputBalTypFieldPos() + " "+checkSumDetailsVO.getOutputBalValFieldPos()+ checkSumDetailsVO.getCksumBalType());
		if(!(OS.indexOf("win") >= 0)){
			Process p;
			String mergeCommand = null;
			try {
				if(checkSumDetailsVO != null){
					if(checkSumDetailsVO.getCksumBalType() != null){
						mergeCommand = "./OutputCksum.sh "  +  outputDirectory+fileName + ETLConstants.SPACE_STR 
								+ checkSumDetailsVO.getOutputBalTypFieldPos() + ETLConstants.SPACE_STR  
								+ checkSumDetailsVO.getOutputBalValFieldPos() + ETLConstants.SPACE_STR + checkSumDetailsVO.getCksumBalType();
					} else{
						mergeCommand = "./OutputCksum.sh "  +  outputDirectory+fileName + ETLConstants.SPACE_STR + checkSumDetailsVO.getOutputBalValFieldPos();
					}
					
					LOGGER.info(" Output checksum command "+mergeCommand);
					p = Runtime.getRuntime().exec(mergeCommand);
					p.waitFor();
					BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
					count = reader.readLine();
					LOGGER.info(" Output checksum command is Successfull");
				}
			} catch (InterruptedException e) {
				LOGGER.error("ERROR while geting output check sum"+e);
			} catch (IOException e) {
				LOGGER.error("ERROR while geting output check sum"+e);
			}
		}
		return count;
	}
	
	
	/**
	private String getOutputCksum(String fileName, String JobNames)
    {
          CheckSumDetailsVO checkSumDetailsVO = new CheckSumDetailsVO();
          BigDecimal count = new BigDecimal(0);
          String []jobName = JobNames.split(ETLConstants.DA_JOBNAME_SEP);
          String cntProdCd = jobName[1] + ETLConstants.DA_JOBNAME_SEP + jobName[2];
          checkSumDetailsVO = queryExec.getCheckSumDetailsMap(cntProdCd, "RNBW");
          
          if(!(OS.indexOf("win") >= 0)){
                Process p;
                File outputCheckSumFile = null;
                try {
                	outputCheckSumFile = new File(outputDirectory+fileName.substring(0, fileName.lastIndexOf("."))+"checksum.dat");
                	if(!outputCheckSumFile.exists()){
                		outputCheckSumFile.createNewFile();
                	}
                      String mergeCommand = "./OutputCksum.sh "  +  outputDirectory + fileName +" " + checkSumDetailsVO.getOutputBalTypFieldPos() + " " + checkSumDetailsVO.getOutputBalValFieldPos() +" "+outputCheckSumFile;
                      LOGGER.info(" Output checksum command "+mergeCommand);
                      p = Runtime.getRuntime().exec(mergeCommand);
                      p.waitFor();
                      /*BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
                      count = reader.readLine();
                      count = CheckSumReader.calculateOutputCheckSum(outputDirectory+outputCheckSumFile.getName());
                      LOGGER.info(" Output checksum command is Successfull");
                } catch (IOException e) {
                      // TODO Auto-generated catch block
                      LOGGER.error("ERROR while geting output check suem"+e);
                } catch (InterruptedException e) {
                      // TODO Auto-generated catch block
                      LOGGER.error("ERROR while geting output check suem"+e);
                } finally{
                	if(outputCheckSumFile != null){
                		outputCheckSumFile.delete();
                	}
                }
          }

          return count.toString();
    }**/
	
	
	/**
	 * 
	 * @param isRcFile
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	private void createAckFile(boolean isRcFile, String controlFileName) throws IOException, InterruptedException
	{
		StringBuffer fileNameList = null;
		String TRLArchiveFilename = null;
		String cntProd = null;
		for (RainbowFileFooter footerItem : footerItemList) {
			if (!footerItem.getHashField().isEmpty())
			{
				String fileName = footerItem.getOutputFileResourceName();
				if (isRcFile){
					fileName = footerItem.getOutputFileResourceName().replace(ETLConstants.DA_RCL_PROD, ETLConstants.DA_PCL_PROD);
				}
				String[] filenameSplit = fileName.split(ETLConstants.FILE_SEPR);
				cntProd = filenameSplit[4].toUpperCase() + ETLConstants.DA_JOBNAME_SEP + filenameSplit[2].toUpperCase();
				String trlFileName = fileName + ETLConstants.DAT;
				if(trlNamesList.contains(footerItem.getOutputFileResourceName().split(ETLConstants.FILE_SEPR)[9])){

					List<CheckSumDetailsVO> outputCkSumDetailsLis = CheckSumDetailsCache.getCheckSumDetailsListWithCntrProd(cntProd+"_"+footerItem.getOutputFileResourceName().split("_")[9]);
					for(CheckSumDetailsVO checkSumDetials : outputCkSumDetailsLis){
						String checkSumValue = null;
						if(cntProd.contains(ETLConstants.DA_PCL_PROD)){
							checkSumValue = getOutputCksum(trlFileName, cntProd,checkSumDetials);
						}
						else{
							if(checkSumDetials.getCksumBalType() != null && checkSumDetials.getCksumBalType().equalsIgnoreCase(ETLConstants.UPB_VALUE)){
								checkSumValue = upbOutputCheckSum;
							} else if(checkSumDetials.getCksumBalType() != null && checkSumDetials.getCksumBalType().equalsIgnoreCase(ETLConstants.ENR_VALUE)){
								checkSumValue = enrOutputCheckSum;
							} else{
								checkSumValue = getOutputCksum(trlFileName, cntProd,checkSumDetials);
							}
						}
						queryExec.insertTRLCheckSumDetails(controlFileName,trlFileName,checkSumDetials,checkSumValue,auditFileId);
						
					}
				}
				new File(outputDirectory
						+ fileName
						+ ETLConstants.ACK).createNewFile();
				
				if (null == fileNameList){
					fileNameList = new StringBuffer();
					fileNameList.append(fileName);
					TRLArchiveFilename = filenameSplit[4] + ETLConstants.FILE_SEPR 
							+ filenameSplit[2] + ETLConstants.FILE_SEPR 
							+ filenameSplit[6] + ETLConstants.FILE_SEPR 
							+ new SimpleDateFormat(ETLConstants.JOB_STRT_TIME_FRMT).format(new Date());
					
				}else{
					fileNameList.append(ETLConstants.SEPARATOR_COMMA + fileName);	
				}
			}
		}
		
		if (TRLArchiveDetailsCache.getInputTRLArchive(cntProd)){
			LOGGER.debug("TRL Archive enabled for "+cntProd);
			if(!(OS.indexOf("win") >= 0)){
				String mergeCommand = "./ArchiveTRL.sh "  +  outputDirectory 
						+ ETLConstants.SPACE_STR + archiveDirectory 
						+ ETLConstants.SPACE_STR + fileNameList.toString() 
						+ ETLConstants.SPACE_STR + TRLArchiveFilename;

				LOGGER.info(" Archive TRL Command "+mergeCommand);
				Process p = Runtime.getRuntime().exec(mergeCommand);
				p.waitFor();
				LOGGER.info(" Archive TRL Command is Successfull");	
			}
		}else{
			LOGGER.debug("TRL Archive disableed for "+cntProd);
		}
	}

	public String getInputFileCount() {
		return inputFileCount;
	}

	public void setInputFileCount(String inputFileCount) {
		this.inputFileCount = inputFileCount;
	}

	public String getInputDirectory() {
		return inputDirectory;
	}

	public void setInputDirectory(String inputDirectory) {
		this.inputDirectory = inputDirectory;
	}

		


}
