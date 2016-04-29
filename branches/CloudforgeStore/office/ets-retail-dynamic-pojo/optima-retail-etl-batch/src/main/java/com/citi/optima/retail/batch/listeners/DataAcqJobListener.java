package com.citi.optima.retail.batch.listeners;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.slf4j.MarkerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.annotation.AfterJob;
import org.springframework.batch.core.annotation.BeforeJob;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.integration.support.MessageBuilder;

import com.citi.optima.batch.job.jdbc.ETLQueryExecutor;
import com.citi.optima.retail.batch.preprocess.PreProcessorDataServiceFactory;
import com.citi.retail.optima.etl.batch.dao.BatchJobInstanceDao;
import com.citi.retail.optima.etl.batch.report.ErrorReportHandler;
import com.citi.retail.optima.etl.common.ETLBatchStatus;
import com.citi.retail.optima.etl.common.ETLConstants;
import com.citi.retail.optima.etl.common.ETLLoggingConstants;
import com.citi.retail.optima.etl.common.OptimaRetailETLLoggingUtil;
import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.db.dao.JobConfigDao;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.OptimaRetailBaseException;
import com.citi.retail.optima.etl.common.exception.OptimaRetailDataException;
import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;
import com.citi.retail.optima.etl.common.log.LoggingMarker;
import com.citi.retail.optima.etl.common.model.FilePathDetailsCache;
import com.citi.retail.optima.etl.common.model.RainbowFileFooter;
import com.citi.retail.optima.etl.common.model.TRLArchiveDetailsCache;
import com.citi.retail.optima.etl.controller.dao.impl.JobMessageDaoImpl;
import com.citi.retail.optima.etl.data.ErrorDataHolderService;
import com.citi.retail.optima.xsd.internal.OptimaRetailETLEvent;

/**
 * This class acts as a callback listener for all job related activities. Call
 * backs are registered in this class like BeforeJob,AfterJob etc
 * 
 * @author ns21567
 * 
 */
public class DataAcqJobListener {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(DataAcqJobListener.class);

	private BatchJobInstanceDao batchJobInstanceDao;
	private ErrorReportHandler errorReportHandler;
	private MessagingTemplate messagingTemplate;
	private MessageChannel internalMessageChannel;
	private ErrorDataHolderService dataHolderService;
	private String dataServiceName;
	private PreProcessorDataServiceFactory preProcessorFactory;
	private JobConfigDao jobConfigDao;
	

	private List<RainbowFileFooter> footerItemList;


	private final static String OS = System.getProperty("os.name").toLowerCase();
	
	public BatchJobInstanceDao getBatchJobInstanceDao() {
		return batchJobInstanceDao;
	}

	public void setBatchJobInstanceDao(BatchJobInstanceDao batchJobInstanceDao) {
		this.batchJobInstanceDao = batchJobInstanceDao;
	}

	public void setInternalMessageChannel(MessageChannel internalMessageChannel) {
		this.internalMessageChannel = internalMessageChannel;
	}

	public void setErrorReportHandler(ErrorReportHandler errorReportHandler) {
		this.errorReportHandler = errorReportHandler;
	}

	public void setDataServiceName(String dataServiceName) {
		this.dataServiceName = dataServiceName;
	}

	public void setPreProcessorFactory(
			PreProcessorDataServiceFactory lpreProcessorFactory) {
		preProcessorFactory = lpreProcessorFactory;
	}

	public List<RainbowFileFooter> getFooterItemList() {
		return footerItemList;
	}

	public void setFooterItemList(List<RainbowFileFooter> footerItemList) {
		this.footerItemList = footerItemList;
	}
	
	/**
	 * Invoked before the job begins. It is used to update the status of the job
	 * in the database.
	 */

	@BeforeJob
	public void beforeJob(JobExecution jobExecution) {
		try {
			setupLoggerForReport(jobExecution);
			LOGGER.info(LoggingMarker.KPI.getMarker(),"JOB Execution Status for "+jobExecution.getJobInstance().getJobName()+"\n\n Date: "+(new Date()).toString()+"\n");
			setupLoggerForJob(jobExecution);
			//setupLoggerForReport(jobExecution);
			messagingTemplate = new MessagingTemplate();

			LOGGER.info("##beforeJob##");
			
/*			String itemsToDelete = null;
			for(RainbowFileFooter footer : footerItemList){
				if(itemsToDelete == null){
					itemsToDelete = footer.getOutputFileResourceName()+ETLConstants.DAT;
				} else{
					itemsToDelete = itemsToDelete+","+footer.getOutputFileResourceName()+ETLConstants.DAT;
				}
			}
			jobExecution.getExecutionContext().putString(
					"ITEM_TO_DELETE", itemsToDelete);*/

			Long batchInstanceId = jobExecution.getJobInstance()
					.getJobParameters().getLong(ETLConstants.BATCH_INSTANCE_ID);

			setFileParameters(jobExecution);
			setBatchStatus(batchInstanceId);
			initiatePreprocessDataService(jobExecution);

			// START OF - Logging Parameters in the jobexecution

			LOGGER.debug(LoggingMarker.CHECKPOINTS.getMarker(),
					OptimaRetailETLLoggingUtil.createLoggingMessage(
							jobExecution.getStatus(),
							batchInstanceId.longValue(),
							ETLLoggingConstants.JOB_STATUS_AT_START));

			// END OF - Logging Parameters in the jobexecution
			
			if (ETLConstants.METRICS) {
				jobExecution.getExecutionContext().put(ETLConstants.TIMER,
						new LinkedHashMap<String, AtomicLong>());
			}
			LOGGER.info(LoggingMarker.KPI.getMarker(),"***************************************************************");
			LOGGER.info(LoggingMarker.KPI.getMarker(),"JOB Execution Status for "+jobExecution.getJobInstance().getJobName()+" Date: "+(new Date()).toString());
		} catch (Exception e) {
			LOGGER.error("Exception occured while loading JobUpdateStatusListener "
					+ e);
		}
	}

	// Initiates the preprocess data services which provides collections for all
	// the steps for preprocess requirements.
	private void initiatePreprocessDataService(JobExecution jobExecution)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		preProcessorFactory.getPreProcessorDataService(
				jobExecution.getJobInstance().getJobParameters()
						.getLong("batchInstanceId"), dataServiceName);
	}

	private void setupLoggerForJob(JobExecution jobExecution) {
		MDC.put("LogFileName",
				"Job-Log-"
						+ jobExecution.getJobInstance().getJobParameters()
								.getString("batchInstanceId"));
		jobExecution.getExecutionContext().put("mdcContextMap",
				MDC.getCopyOfContextMap());
	}
	private void setupLoggerForReport(JobExecution jobExecution) {
		MDC.put("ReportFileName",
				"ExecutionReport-"
						+jobExecution.getJobInstance().getJobParameters()
								.getString(ETLConstants.JOB_NAME)+"-"
						+jobExecution.getJobInstance().getJobParameters()
								.getString(ETLConstants.DATE_OF_INFO)+"-"
						+ jobExecution.getJobInstance().getJobParameters()
								.getString("batchInstanceId"));
		jobExecution.getExecutionContext().put("mdcContextMap",
				MDC.getCopyOfContextMap());
	}
	private void setBatchStatus(Long batchInstanceId) {
		if (!batchJobInstanceDao.updateBatchStatus(batchInstanceId.intValue(),
				ETLBatchStatus.BTH_STRT)) {
			batchJobInstanceDao.updateBatchStatus(batchInstanceId.intValue(),
					ETLBatchStatus.BTH_FAIL);
		}
	}

	private void setFileParameters(JobExecution jobExecution) {
		if (jobExecution.getJobInstance().getJobParameters()
				.getString(ETLConstants.FILE_TYPE) != null) {
			if (jobExecution.getJobInstance().getJobParameters()
					.getString(ETLConstants.FILE_TYPE).equalsIgnoreCase("CSV")) {
				jobExecution.getExecutionContext().putString(
						ETLConstants.FILE_READER, "csvReader");
			} else if (jobExecution.getJobInstance().getJobParameters()
					.getString(ETLConstants.FILE_TYPE).equalsIgnoreCase("XLS")
					|| jobExecution.getJobInstance().getJobParameters()
							.getString(ETLConstants.FILE_TYPE)
							.equalsIgnoreCase("XLSX")) {
				jobExecution.getExecutionContext().putString(
						ETLConstants.FILE_READER, "xlsxReader");
			}
		}
	}

	/**
	 * This method is invoked after the completion of all the job steps. This
	 * functioned is used to update the status of the job as well as for doing
	 * clean ups before termination of the job.
	 */
	@AfterJob
	public void afterJob(JobExecution jobExecution) {

		try {

			Long batchInstanceId = new Long(jobExecution.getJobInstance()
					.getJobParameters().getLong(ETLConstants.BATCH_INSTANCE_ID));
//			Map<String, OptimaRetailDataException> errorCollection = dataHolderService
//					.getErrorMapByBatchInstanceId(batchInstanceId);

			if (ExitStatus.COMPLETED.compareTo(jobExecution.getExitStatus()) == 0){
//					&& errorCollection.size() == 0) {
				batchJobInstanceDao.updateJobStatusAudit(jobExecution.getJobInstance().getJobName(), jobExecution.getExitStatus().getExitCode(), "JOB COMPLETED SUCCESSFULLY", jobExecution.getJobInstance()
						.getJobParameters().getDate(ETLConstants.REPORT_DATE));
				jobConfigDao.clearRunningEntries(jobExecution.getJobInstance().getJobParameters().getString(ETLConstants.DA_CONTROL_FILE_NAME));
				handlebatchSucess(batchInstanceId);
			} else {
				removeSplitFile(jobExecution, batchInstanceId,
						null);
				batchJobInstanceDao.updateJobStatusAudit(jobExecution.getJobInstance().getJobName(), jobExecution.getExitStatus().getExitCode(), "JOB FAILED", jobExecution.getJobInstance()
						.getJobParameters().getDate(ETLConstants.REPORT_DATE));
				jobConfigDao.clearRunningEntries(jobExecution.getJobInstance().getJobParameters().getString(ETLConstants.DA_CONTROL_FILE_NAME));
				handleBatchFailure(jobExecution, batchInstanceId,
						null);
			}
			createOutgoingMessage(jobExecution);
			LOGGER.info(LoggingMarker.KPI.getMarker(),"JOB Execution Status for "+jobExecution.getJobInstance().getJobName()+": "+jobExecution.getExitStatus().getExitCode());
			LOGGER.info(LoggingMarker.KPI.getMarker(),"***************************************************************");
		} catch (Exception e) {
			LOGGER.error("Exception occured while loading JobUpdateStatusListener "
					+ e);
		}
		
	}

	private void removeSplitFile(JobExecution jobExecution,
			Long batchInstanceId,
			Map<String, OptimaRetailDataException> errorCollection)
			throws IOException, FileNotFoundException {
		
		// Added for SPLIT file removal
		String cntProd = jobExecution.getJobInstance().getJobParameters().getString("COUNTRYPRODUCT").toUpperCase();
		if (!TRLArchiveDetailsCache.getSplitFileReq(cntProd)){
			if(!(OS.indexOf("win") >= 0)){
				String inputDirectory = jobExecution.getJobInstance().getJobParameters().getString(ETLConstants.FILE_PATH);
				String dataFileList = jobExecution.getJobInstance().getJobParameters().getString(ETLConstants.DATA_FILE_LIST);
				String removeSplitFilesCommand = "./SplitFileRemover.sh "  + inputDirectory +  " " + dataFileList;
				LOGGER.info(" Split File Removal Command "+removeSplitFilesCommand);
				Process p2 = Runtime.getRuntime().exec(removeSplitFilesCommand);
				try {
					p2.waitFor();
				} catch (InterruptedException e) {
					LOGGER.error("Error occured while removing split file"+e);
					e.printStackTrace();
				}
				LOGGER.info(" Split File Removal is Successfull");

				// Remove Partially created TRL files
				String itemsToDelete = jobExecution.getExecutionContext().getString("ITEM_TO_DELETE");
				try {
					LOGGER.info("Command to delete files :: "+"./FileRemover.sh " + FilePathDetailsCache.getOutputFilePath(cntProd) + ETLConstants.SPACE_STR + itemsToDelete );
					Runtime.getRuntime().exec("./FileRemover.sh " + FilePathDetailsCache.getOutputFilePath(cntProd) + ETLConstants.SPACE_STR + itemsToDelete);
					
				} catch (IOException e) {
					LOGGER.error("Error occued while deleting partially created files:: "+ e.getMessage());
				}
			}
		}else{
			LOGGER.info("SPLIT file Removal diabled, Skipping the same");
		}
			

	}
	
	private void handleBatchFailure(JobExecution jobExecution,
			Long batchInstanceId,
			Map<String, OptimaRetailDataException> errorCollection)
			throws IOException, FileNotFoundException {
		/*if (errorCollection.size() != 0) {
			if (jobExecution.getExecutionContext().getString("fileReader")
					.equalsIgnoreCase("csvReader")) {
				errorReportHandler.createCSVErrorReport(errorCollection, null,
						jobExecution.getExecutionContext().getString("header"));
			} else {
				Workbook errorWorkbook = errorReportHandler
						.createXlsErrorReport(errorCollection, jobExecution
								.getExecutionContext().getString("header"));
				errorWorkbook.write(new FileOutputStream("error_file_"
						+ System.currentTimeMillis() + ".xlsx"));
			}
		}*/

	
		batchJobInstanceDao.updateBatchStatus(batchInstanceId.intValue(),
				ETLBatchStatus.BTH_FAIL);
	}

	private void handlebatchSucess(Long batchInstanceId) {
		if (!batchJobInstanceDao.updateBatchStatus(batchInstanceId.intValue(),
				ETLBatchStatus.BTH_COMP)) {
			batchJobInstanceDao.updateBatchStatus(batchInstanceId.intValue(),
					ETLBatchStatus.BTH_FAIL);
		} else {
			batchJobInstanceDao.updateBatchStatus(batchInstanceId.intValue(),
					ETLBatchStatus.BTH_COMP);
		}
	}

	/**
	 * This method creates the outgoing message for the completed/failed job
	 * which to be sent to the controller.
	 * 
	 * @param jobExecution
	 *            - needs the details of the job launched which sent in the
	 *            jobExecution object
	 * @return - outgoing message
	 * @throws OptimaRetailException
	 *             - exception while creating the outgoing message
	 */
	private void createOutgoingMessage(JobExecution jobExecution)
			throws OptimaRetailBaseException {

		OptimaRetailETLEvent outgoingMessage;
		try {
			outgoingMessage = new OptimaRetailETLEvent();
			Long jobId = jobExecution.getJobInstance().getJobParameters()
					.getLong(ETLConstants.BATCH_INSTANCE_ID);
			outgoingMessage
					.setBatchInstanceId(new BigInteger(jobId.toString()));
			outgoingMessage.setEventTimestamp("2013-03-14 17:37:52");
			outgoingMessage.setRequestID("ORETL-" + Math.random());
			outgoingMessage
					.setEventType(com.citi.retail.optima.xsd.internal.EventTypes.ORETL_JOB_COMPLETE);

			Long origMessageLong = jobExecution.getJobInstance()
					.getJobParameters().getLong(ETLConstants.ORIGINAL_MSG_ID);

			BigInteger originalMessageId = new BigInteger(
					origMessageLong.toString());
			outgoingMessage.setOriginalMsgId(originalMessageId);
		} catch (Exception e) {
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.BATCH, ExceptionType.FATAL,
					"Error in Item Reader", e.getMessage(),
					OptimaRetailExceptionUtil.getStackTrace(e),jobConfigDao);

		}

		messagingTemplate.convertAndSend(internalMessageChannel, MessageBuilder
				.withPayload(outgoingMessage).build());

	}

	/**
	 * @param dataHolderService
	 *            the dataHolderService to set
	 */
	public void setDataHolderService(ErrorDataHolderService dataHolderService) {
		this.dataHolderService = dataHolderService;
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
