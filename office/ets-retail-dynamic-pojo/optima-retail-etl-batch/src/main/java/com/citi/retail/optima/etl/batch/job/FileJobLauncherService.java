package com.citi.retail.optima.etl.batch.job;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.integration.Message;

import com.citi.optima.batch.job.jdbc.ETLQueryExecutor;
import com.citi.retail.optima.etl.batch.dao.BatchJobDetailsDao;
import com.citi.retail.optima.etl.batch.dao.BatchJobInstanceDao;
import com.citi.retail.optima.etl.batch.dao.BatchMessageDao;
import com.citi.retail.optima.etl.batch.messaging.InternalMessageCreator;
import com.citi.retail.optima.etl.batch.vo.BatchDetailsVO;
import com.citi.retail.optima.etl.cache.lookup.ReferenceValueLookup;
import com.citi.retail.optima.etl.common.ETLBatchStatus;
import com.citi.retail.optima.etl.common.ETLConstants;
import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.db.dao.JobConfigDao;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.OptimaRetailBaseException;
import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;
import com.citi.retail.optima.etl.common.model.FilePathDetailsCache;
import com.citi.retail.optima.etl.controller.file.mover.FileMover;
import com.citi.retail.optima.etl.controller.file.mover.FileMoverBasicImpl;
import com.citi.retail.optima.xsd.internal.OptimaRetailETLEvent;

/**
 * This class is used to launch the jobs for the requests received from the
 * controller module.
 * 
 * @author ns21567
 * 
 */
public class FileJobLauncherService implements ApplicationContextAware {

	Logger logger = LoggerFactory.getLogger(FileJobLauncherService.class);

	private BatchJobLauncher batchjobLauncher;
	private ApplicationContext applicationContext;
	private BatchJobDetailsDao jobDetailsDao;
	private BatchJobInstanceDao jobInstanceDao;
	private BatchMessageDao batchDaoImpl;
	private InternalMessageCreator internalMessageCreator;
	private ReferenceValueLookup referenceValueLookup;
	private JobOperator jobOperator;
	private ETLQueryExecutor queryExecutor;
	private JobConfigDao jobConfigDao;

	/**
	 * @return the jobOperator
	 */
	public JobOperator getJobOperator() {
		return jobOperator;
	}

	/**
	 * @param jobOperator the jobOperator to set
	 */
	public void setJobOperator(JobOperator jobOperator) {
		this.jobOperator = jobOperator;
	}

	private String fileLocation;
	
	private String fileOutputLocation;

	/**
	 * This method is invoked when a message is recieved by the job launcher
	 * queue. It receives the batch request as OptimaRetailEvent and launches
	 * the job corresponding to the details retrieved for the job from the
	 * database.
	 * 
	 * @param optimaRetailEvent
	 *            - the incoming batch request message.
	 * @return - returns the result(outgoing) event of the launched job.
	 * @throws OptimaRetailException
	 *             - throws optima retail exception if job files to launch
	 */
	public void handleMessage(Message<Object[]> optimaRetailEventMsg)
			throws OptimaRetailBaseException {

		Job job;
		Map<String, Object> fileInformation = null;
		OptimaRetailETLEvent optimaRetailEvent;
		BigInteger batchInstId;
		BatchDetailsVO batchDetailsVo;
		String cntrlFilename =null;

		Object[] messageArray = optimaRetailEventMsg.getPayload();
		optimaRetailEvent = (OptimaRetailETLEvent) messageArray[0];

		fileInformation = (Map<String, Object>) messageArray[1];

//		Map<String, String> dataFileDetails = getDataFileDetails((List<String>) fileInformation
//				.get("dataFileNames"));

		batchInstId = optimaRetailEvent.getBatchInstanceId();
		batchDetailsVo = getBatchDetails(optimaRetailEvent);
		
		// FX RATE changes
		String fxRateFile = "FXRATE_#DATADATE#_Data.v2.dat";
		((List<String>)fileInformation.get("dataFileNames")).add(fxRateFile);
		
		String cbFinanceFile = "CB_FINANCE_ATTR_LIST.dat";
		((List<String>)fileInformation.get("dataFileNames")).add(cbFinanceFile);
		
		FileMover fileMover = new FileMoverBasicImpl();
		
		try {
			job = getJob(batchDetailsVo);
			if (job != null) {
				batchDetailsVo.setBatchInstanceId(batchInstId.intValue());
				 cntrlFilename = (String) fileInformation.get("controlFileName");
				String cntryProd = null;
				if(job.getName().contains("IN-MTG")){
					cntryProd = "IN-MTG";
				} else{
					cntryProd = cntrlFilename.split("_")[1]+"-"+cntrlFilename.split("_")[2];
				}
				fileMover.moveFile(FilePathDetailsCache.getInputFilePath(cntryProd), FilePathDetailsCache.getProcessedFilePath(cntryProd), (String) fileInformation.get("controlFileName"), (String) fileInformation.get("controlFileName")+"_moved");
				JobParameters jobParameters = JobParamsService
						.populateJobParameters(
								batchDetailsVo.getBatchName(),
								batchDetailsVo,
								optimaRetailEvent,
								(List<String>) fileInformation
										.get("dataFileNames"),
										cntrlFilename+"_moved",
										FilePathDetailsCache.getInputFilePath(cntryProd), referenceValueLookup, queryExecutor);
				
				if (!System.getProperty("os.name").toLowerCase().contains("win")) {
					// Added for adding control file in archive file 
					addControlFileInArchive(FilePathDetailsCache.getProcessedFilePath(cntryProd), 
							FilePathDetailsCache.getArchiveFilePath(cntryProd),
							jobParameters.getString(ETLConstants.DA_CONTROL_FILE_NAME),
							jobParameters.getString(ETLConstants.JOB_NAME),
							jobParameters.getString(ETLConstants.JOB_STRT_TIME));
				}
				
				try
				{
//					if(jobOperator.getExecutions(batchInstId.longValue()).size() > 0){//RunningExecutions(job.getName()).size() > 1){
//						jobOperator.startNextInstance(job.getName());
//					}
					batchjobLauncher.launchJob(batchInstId, job, jobParameters);
				}catch(Exception e){
					
				}
			} else {
				jobInstanceDao.updateBatchStatus(optimaRetailEvent
						.getBatchInstanceId().intValue(),
						ETLBatchStatus.BTH_FAIL);
				throw new OptimaRetailApplicationException(
						null,
						null,
						optimaRetailEvent.getBatchInstanceId().longValue(),
						ServiceName.BATCH,
						ExceptionType.ERROR,
						"Error Populating parameters. Job is null. No job found.",
						"NullPointer.", null,jobConfigDao);
			}

		} catch (Exception e) {
			internalMessageCreator
					.createAndOutgoingCompletionMessage(optimaRetailEvent
							.getBatchInstanceId().intValue());
			jobInstanceDao.updateBatchStatus(optimaRetailEvent
					.getBatchInstanceId().intValue(), ETLBatchStatus.BTH_FAIL);
			throw new OptimaRetailApplicationException(null, null,
					optimaRetailEvent.getBatchInstanceId().longValue(),
					ServiceName.BATCH, ExceptionType.FATAL,
					"Error in File Job Launcher "
							+ optimaRetailEvent.getBatchInstanceId(),
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e),jobConfigDao);
		}

	}

	private BatchDetailsVO getBatchDetails(
			OptimaRetailETLEvent optimaRetailEvent) {

		BatchDetailsVO batchDetailsVo = jobDetailsDao
				.getBatchdetails(optimaRetailEvent.getBatchInstanceId()
						.intValue());
		int orgMessageId = jobInstanceDao.getOriginalMessageId(batchDetailsVo
				.getBatchInstanceId());
		batchDetailsVo.setFileId((batchDaoImpl
				.getOriginalRequestMessage(orgMessageId).getFileId()));
		batchDetailsVo.setFileType((batchDaoImpl
				.getOriginalRequestMessage(orgMessageId).getFileType()));
		batchDetailsVo.setSysProcId(jobInstanceDao.getSysProcId(batchDetailsVo
				.getBatchId()));
		return batchDetailsVo;
	}

	private Job getJob(BatchDetailsVO jobDetailsVo) {
		Job job = (Job) applicationContext.getBean(jobDetailsVo.getBatchName());

		return job;
	}

	public void setBatchjobLauncher(BatchJobLauncher batchjobLauncher) {
		this.batchjobLauncher = batchjobLauncher;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	public void setJobDetailsDao(BatchJobDetailsDao jobDetailsDao) {
		this.jobDetailsDao = jobDetailsDao;
	}

	public void setJobInstanceDao(BatchJobInstanceDao jobInstanceDao) {
		this.jobInstanceDao = jobInstanceDao;
	}

	/**
	 * @param batchDaoImpl
	 *            the batchDaoImpl to set
	 */
	public void setBatchDaoImpl(BatchMessageDao batchDaoImpl) {
		this.batchDaoImpl = batchDaoImpl;
	}

	public void setInternalMessageCreator(
			InternalMessageCreator internalMessageCreator) {
		this.internalMessageCreator = internalMessageCreator;
	}

	public void setReferenceValueLookup(
			ReferenceValueLookup referenceValueLookup) {
		this.referenceValueLookup = referenceValueLookup;
	}

	public ETLQueryExecutor getQueryExecutor() {
		return queryExecutor;
	}

	public void setQueryExecutor(ETLQueryExecutor queryExecutor) {
		this.queryExecutor = queryExecutor;
	}
	
	/**
	 * 
	 * @param processedDir
	 * @param archiveDir
	 * @param jobName
	 * @param startTime
	 * @throws Exception
	 */
	public void addControlFileInArchive(String processedDir, String archiveDir, String cntFileName, String jobName, String startTime) throws Exception {

		logger.info(" Adding Control file in Archive File Started ");
		
		String addCntFileCommand = "sh ./AddCntFile.sh " + processedDir + ETLConstants.SPACE_STR 
				+ archiveDir + ETLConstants.SPACE_STR + cntFileName + "_moved" + ETLConstants.SPACE_STR 
				+ jobName + ETLConstants.SPACE_STR + startTime;
		Process p = Runtime.getRuntime().exec(addCntFileCommand);
		p.waitFor();

		logger.info(" Adding Control file in Archive File Successfull " + addCntFileCommand);
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
