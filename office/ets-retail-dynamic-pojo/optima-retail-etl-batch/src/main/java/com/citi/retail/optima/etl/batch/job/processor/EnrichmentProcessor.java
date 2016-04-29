package com.citi.retail.optima.etl.batch.job.processor;

import java.io.File;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MarkerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.ItemProcessListener;
import org.springframework.batch.core.ItemReadListener;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemProcessor;

import com.citi.optima.batch.job.jdbc.ETLQueryExecutor;
import com.citi.optima.retail.batch.job.timer.TimeTracker;
import com.citi.retail.optima.etl.common.ETLConstants;
import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.db.dao.JobConfigDao;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.log.LoggingMarker;
import com.citi.retail.optima.etl.controller.dao.JobMessageDao;
import com.citi.retail.optima.etl.enrichment.EnrichmentService;
import com.citi.retail.optima.etl.enrichment.exception.EnrichmentException;

/**
 * 
 * @author ms04453 Enrichment Processor helps to process enrichments for the
 *         items passed on by calling process method. It is injected with
 *         enrichment service bean for processing enrichments and step execution
 *         context to maintain the number of records being read, processed,
 *         skipped during processing.
 * @param <T>
 */
public class EnrichmentProcessor<T> implements ItemProcessor<T, T>,
		StepExecutionListener,ItemReadListener<T>, ItemProcessListener<T, T> {

	private EnrichmentService<T> enrichmentServiceBean;
	private StepExecution stepExecution;
	private ExecutionContext currentExecutionContext;
	private static final Logger LOGGER = LoggerFactory
			.getLogger(EnrichmentProcessor.class);

	private Long batchInstanceId;
	private JobMessageDao jobMessageDao;
	private ETLQueryExecutor eTLQueryExecutor;

	private Long exectionTime = 0L;
	private TimeTracker timeTracker;
	
	private String jobName;
	private String fileName;
	private Long count;
	
	
	/**
	 * @return the eTLQueryExecutor
	 */
	public ETLQueryExecutor geteTLQueryExecutor() {
		return eTLQueryExecutor;
	}

	/**
	 * @param eTLQueryExecutor the eTLQueryExecutor to set
	 */
	public void seteTLQueryExecutor(ETLQueryExecutor eTLQueryExecutor) {
		this.eTLQueryExecutor = eTLQueryExecutor;
	}

	/**
	 * @return the ctlFileDt
	 */
	public String getCtlFileDt() {
		return ctlFileDt;
	}

	/**
	 * @param ctlFileDt the ctlFileDt to set
	 */
	public void setCtlFileDt(String ctlFileDt) {
		this.ctlFileDt = ctlFileDt;
	}

	private boolean enrichFlag;
	private Long auditFileId;
	private String auditFiles;
	private Timestamp startTime;
	private String ctlFileDt;
	private boolean isHeader;
	private JobConfigDao jobConfigDao;
	
	/**
	 * Bean Life cycle method called by Bean post processor during processor
	 * init. This checks whether the injected enrichment service is not null and
	 * throws exception stalling the job if it was not initialised properly.
	 * 
	 * @throws Exception
	 */
	public void afterPropertiesSet() throws Exception {

		if (this.enrichmentServiceBean == null) {
			LOGGER.error("Enrichment Service was not initialised. Job Would Terminate Now.");
			throw new OptimaRetailApplicationException(null, null,
					batchInstanceId, ServiceName.BATCH, ExceptionType.FATAL,
					"Enrichment Service was not initialised. Job Would Terminate Now for batch:"
							+ batchInstanceId, null, null,jobConfigDao);
		}
		LOGGER.debug("*****Enrichment Item Processor Started For BATCH: ***** "
				+ this.batchInstanceId);

	}

	/**
	 * Overrides the process method provided by Item Processor. It accepts
	 * objects, enriches them and returns back enriched object by calling
	 * enrichment service.
	 */
	@Override
	public T process(T item) throws Exception {
		Long startTime = 0L;
		if(enrichFlag == true){
			if (ETLConstants.METRICS) {
				startTime = System.currentTimeMillis();
			}
			((AtomicLong) this.currentExecutionContext
					.get(ETLConstants.ENRICHMENT_READ_COUNT)).incrementAndGet();
			try {
				this.enrichmentServiceBean.enrich(item);
				((AtomicLong) this.currentExecutionContext
						.get(ETLConstants.ENRICHMENT_PROCESSED_COUNT))
						.incrementAndGet();
			} catch (EnrichmentException optimaRetailException) {
				((AtomicLong) this.currentExecutionContext
						.get(ETLConstants.ENRICHMENT_SKIPPED_COUNT))
						.incrementAndGet();
				//optimaRetailException.printStackTrace();
				throw optimaRetailException;
			}
			if (ETLConstants.METRICS) {
				exectionTime += (System.currentTimeMillis() - startTime);
			}
			return item;
		}
		else{
			return null;
		}
	}

	/**
	 * 
	 * @return Enrichment Service Bean.
	 */
	public EnrichmentService<T> getEnrichmentServiceBean() {
		return this.enrichmentServiceBean;
	}

	/**
	 * Set Enrichment service Bean for this instance.
	 * 
	 * @param enrichmentServiceBean
	 */
	public void setEnrichmentServiceBean(
			EnrichmentService<T> enrichmentServiceBean) {
		this.enrichmentServiceBean = enrichmentServiceBean;
	}

	/**
	 * Called before the execution of the step registered. This gets the current
	 * execution context(a map of state variables) and initialised the counts
	 * for number of items being read, processed and skipped by the current
	 * instance of the processor.
	 */
	@SuppressWarnings("unused")
	@Override
	public void beforeStep(StepExecution stepExecution) {
		this.stepExecution = stepExecution;
		LOGGER.debug("Step Execution: " + stepExecution.toString());
		startTime=new Timestamp(System.currentTimeMillis());
		if (stepExecution == null) {
			LOGGER.error("Step Execution was NULL in Enrichment Processor");
		} else {
			this.currentExecutionContext = stepExecution.getExecutionContext();
			if (this.currentExecutionContext == null) {
				LOGGER.error("Execution Context was NULL");
			}
			if (this.currentExecutionContext
					.get(ETLConstants.ENRICHMENT_READ_COUNT) == null) {
				this.currentExecutionContext.put(
						ETLConstants.ENRICHMENT_READ_COUNT, new AtomicLong(0));
				this.currentExecutionContext.put(
						ETLConstants.ENRICHMENT_PROCESSED_COUNT,
						new AtomicLong(0));
				this.currentExecutionContext.put(
						ETLConstants.ENRICHMENT_SKIPPED_COUNT,
						new AtomicLong(0));
			} else if (this.currentExecutionContext
					.get(ETLConstants.ENRICHMENT_PROCESSED_COUNT) == null) {
				this.currentExecutionContext.put(
						ETLConstants.ENRICHMENT_PROCESSED_COUNT,
						new AtomicLong(0));
			} else if (this.currentExecutionContext
					.get(ETLConstants.ENRICHMENT_SKIPPED_COUNT) == null) {
				this.currentExecutionContext.put(
						ETLConstants.ENRICHMENT_SKIPPED_COUNT,
						new AtomicLong(0));
			}
			if (ETLConstants.METRICS) {
				timeTracker.initTimer(stepExecution, "Enrichment");
			}
		}

		LOGGER.debug("Current Step Execution Context: "
				+ this.currentExecutionContext.toString());
		
		/*Object obj = stepExecution.getJobExecution().getExecutionContext().get(fileName.substring(fileName.lastIndexOf("/"),fileName.lastIndexOf(".dat")));
		if(obj == null){
			count = 0L;
		}
		else{
			count = (Long) obj;
		}*/
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("RECORD STATS FOR THIS RUN START: ");
			LOGGER.debug("READ: "
					+ ((AtomicLong) this.currentExecutionContext
							.get(ETLConstants.ENRICHMENT_READ_COUNT))
							.toString());
			LOGGER.debug("PROCESSED: "
					+ ((AtomicLong) this.currentExecutionContext
							.get(ETLConstants.ENRICHMENT_PROCESSED_COUNT))
							.toString());
			LOGGER.debug("SKIPPED: "
					+ ((AtomicLong) this.currentExecutionContext
							.get(ETLConstants.ENRICHMENT_SKIPPED_COUNT))
							.toString());
			LOGGER.debug("RECORD STATS FOR THIS RUN END: ");
			if (fileName != null) {
				File file = new File(fileName);
				if (((AtomicLong) this.currentExecutionContext
						.get(ETLConstants.ENRICHMENT_READ_COUNT)).longValue() > 0) {
					LOGGER.info(
							MarkerFactory.getMarker("KPI"),
							"Total Number of records in "
									+ file.getName()
									+ ": "
									+ ((AtomicLong) this.currentExecutionContext
											.get(ETLConstants.ENRICHMENT_READ_COUNT))
											.toString());
				}
				if (((AtomicLong) this.currentExecutionContext
						.get(ETLConstants.ENRICHMENT_PROCESSED_COUNT))
						.longValue() > 0) {
					LOGGER.info(
							MarkerFactory.getMarker("KPI"),
							"Total Number of records PROCESSED in "
									+ file.getName()
									+ ": "
									+ ((AtomicLong) this.currentExecutionContext
											.get(ETLConstants.ENRICHMENT_PROCESSED_COUNT))
											.toString() + "\n");

				}
			}
		}
		if (ETLConstants.METRICS) {
			timeTracker.updateTimer(stepExecution, "Enrichment", exectionTime);
		}
//		boolean statusFlag=validateFileCount(auditFileId,auditFiles,((AtomicLong)this.currentExecutionContext.get(ETLConstants.ENRICHMENT_READ_COUNT)).longValue(),
//				fileName,startTime);
//		File file = new File(fileName);
//		if(!statusFlag){
			//LOGGER.error("MAIL-------------------------------EnrichmentPro-255");
//			try {
//				eTLQueryExecutor.logProcessAuditErrorStep(auditFileId.intValue(), file.getName(), "Input Record Count Validation", false, "Control file data count dosen't match with Input data file",ctlFileDt);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		jobMessageDao.poppulateEmailContent("INPUT_COUNT_FAILED",  file.getName(), null);
//			return ExitStatus.FAILED;
//		}else {
//			jobMessageDao.poppulateEmailContent("INPUT_COUNT_SUCCESS",  file.getName(), null);
//		}
			/*stepExecution.getJobExecution().getExecutionContext().putLong(fileName.substring(fileName.lastIndexOf("/"),fileName.lastIndexOf(".dat")), count);
			System.out.println("<<<<<<<<<<<<<<Count"+count);*/
		return null;
	}

	/**
	 * 
	 * @return Step Execution.
	 */
	public StepExecution getStepExecution() {
		return this.stepExecution;
	}

	/**
	 * Set Step Execution.
	 * 
	 * @param stepExecution
	 */
	public void setStepExecution(StepExecution stepExecution) {
		this.stepExecution = stepExecution;
	}

	/**
	 * Returns the current Execution Context.
	 * 
	 * @return
	 */
	public ExecutionContext getCurrentExecutionContext() {
		return this.currentExecutionContext;
	}

	/**
	 * Set Current Execution Context.
	 * 
	 * @param currentExecutionContext
	 */
	public void setCurrentExecutionContext(
			ExecutionContext currentExecutionContext) {
		this.currentExecutionContext = currentExecutionContext;
	}

	/**
	 * @param batchInstanceId
	 *            the batchInstanceId to set
	 */
	public void setBatchInstanceId(Long batchInstanceId) {
		this.batchInstanceId = batchInstanceId;
	}

	public TimeTracker getTimeTracker() {
		return timeTracker;
	}

	public void setTimeTracker(TimeTracker timeTracker) {
		this.timeTracker = timeTracker;
	}

	@Override
	public void beforeRead() {
		/**
		 * nothing to do for now
		 */
	}

	@Override
	public void afterRead(T item) {
		/**
		 * nothing to do for now
		 */
//		count = count.longValue() + 1;
	}

	@Override
	public void onReadError(Exception ex) {
		File file = new File(fileName);
		String rptDate = stepExecution.getJobExecution().getJobInstance().getJobParameters().getString(ETLConstants.REPORT_DATE);
		try {
			eTLQueryExecutor.logProcessAuditErrorStep(auditFileId.intValue(), file.getName(), "On Read exception", false, "input file validation failed as it has invalid number of column for a particular record ",ctlFileDt, rptDate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		LOGGER.error(LoggingMarker.KPI.getMarker(), "Input column mismatch error in file  :: "+file.getName());
		LOGGER.error(LoggingMarker.KPI.getMarker(), "Error details: "+ex.getMessage()+"\n");	
		
		
	}
	
	/*private boolean validateFileCount(Long auditFileId, String auditFiles, long longValue, String processedFiles,java.sql.Timestamp startTime){
		
		boolean flag = false; 
		try {
			flag = eTLQueryExecutor.logInputFileAudit(auditFileId,auditFiles,((AtomicLong)this.currentExecutionContext.get(ETLConstants.ENRICHMENT_READ_COUNT)).longValue(),
					fileName,startTime);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}*/

	/**
	 * @return the jobName
	 */
	public String getJobName() {
		return jobName;
	}

	/**
	 * @param jobName the jobName to set
	 */
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	@Override
	public void beforeProcess(T item) {
		//System.out.println("Enrichment Processor = "+item.getClass().getName());
		String className = item.getClass().getName();
		if("com.citi.retail.optima.etl.common.model.TwMtgAlsPOCRecord".equals(className)){
			Class  class1 = null;
			try {
				class1	= Class.forName("com.citi.retail.optima.etl.common.model.TwMtgAlsPOCRecord");
				Object o = class1.cast(item);
				Method m = class1.getMethod("getProdType", null);
				String prodType = (String) m.invoke(item, null);
			//	System.out.println("********************** product type=" + prodType);
				if(prodType == null){
					this.enrichFlag = true;
				}else{
					if(prodType.equalsIgnoreCase("HCMN") || prodType.equalsIgnoreCase("ML") || prodType.equalsIgnoreCase("MLSA") || prodType.equalsIgnoreCase("MLWO") || prodType.equalsIgnoreCase("MP") || prodType.equalsIgnoreCase("MPMN") || prodType.equalsIgnoreCase("MPWO")){
						this.enrichFlag = true;
					}else{
						this.enrichFlag = false;
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		} else if ("com.citi.retail.optima.etl.common.model.TwPlAlsPOCRecord".equals(className)){
			//LoansALSRecord loansRecord = (LoansALSRecord) item;
			Class class2 = null;
			
			try {
				class2  = Class.forName("com.citi.retail.optima.etl.common.model.TwPlAlsPOCRecord");
				Object o = class2.cast(item);
				Method m = class2.getMethod("getProdType", null);
				String prodType = (String) m.invoke(item, null);
			//	System.out.println("********************** product type=" + prodType);
				
				if(prodType == null){
					this.enrichFlag = true;
				} else{
					//AFTI, AUTO, IL, ILC ILA, ILCA, MSDT, ODF, PL, PLWO, RC, RCWO, TDR,NON TDR,TD:TDBB, TDP
					if(prodType.equalsIgnoreCase("AFTI") || prodType.equalsIgnoreCase("AUTO") || prodType.equalsIgnoreCase("IL") || prodType.equalsIgnoreCase("ILC") || prodType.equalsIgnoreCase("ILA") || prodType.equalsIgnoreCase("ILCA") || prodType.equalsIgnoreCase("MSDT") || prodType.equalsIgnoreCase("ODF") || prodType.equalsIgnoreCase("PL") || prodType.equalsIgnoreCase("PLWO") || prodType.equalsIgnoreCase("RC") || prodType.equalsIgnoreCase("RCWO") || prodType.equalsIgnoreCase("TDR") || prodType.equalsIgnoreCase("NON TDR") || prodType.equalsIgnoreCase("TD:TDBB") || prodType.equalsIgnoreCase("TDP") || prodType.equalsIgnoreCase("TDBB")){
						this.enrichFlag = true;
					}else{
						this.enrichFlag = false;
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}			
		} else{
			this.enrichFlag = true;
		}
		
	}

	/*@Override
	public void beforeProcess(T item) {
		if(item instanceof ALSRecord){
			ALSRecord alsRecord = (ALSRecord) item;
			String prodType = alsRecord.getProdType();
			if(prodType == null){
				this.enrichFlag = true;
			} else{
				if(prodType.equalsIgnoreCase("HCMN") || prodType.equalsIgnoreCase("ML") || prodType.equalsIgnoreCase("MLSA") || prodType.equalsIgnoreCase("MLWO") || prodType.equalsIgnoreCase("MP") || prodType.equalsIgnoreCase("MPMN") || prodType.equalsIgnoreCase("MPWO")){
					this.enrichFlag = true;
				}else{
					this.enrichFlag = false;
				}
			}
		} else if (item instanceof LoansALSRecord){
			LoansALSRecord loansRecord = (LoansALSRecord) item;
			String prodType = loansRecord.getProdType();
			if(prodType == null){
				this.enrichFlag = true;
			} else{
				//AFTI, AUTO, IL, ILC ILA, ILCA, MSDT, ODF, PL, PLWO, RC, RCWO, TDR,NON TDR,TD:TDBB, TDP
				if(prodType.equalsIgnoreCase("AFTI") || prodType.equalsIgnoreCase("AUTO") || prodType.equalsIgnoreCase("IL") || prodType.equalsIgnoreCase("ILC") || prodType.equalsIgnoreCase("ILA") || prodType.equalsIgnoreCase("ILCA") || prodType.equalsIgnoreCase("MSDT") || prodType.equalsIgnoreCase("ODF") || prodType.equalsIgnoreCase("PL") || prodType.equalsIgnoreCase("PLWO") || prodType.equalsIgnoreCase("RC") || prodType.equalsIgnoreCase("RCWO") || prodType.equalsIgnoreCase("TDR") || prodType.equalsIgnoreCase("NON TDR") || prodType.equalsIgnoreCase("TD:TDBB") || prodType.equalsIgnoreCase("TDP") || prodType.equalsIgnoreCase("TDBB")){
					this.enrichFlag = true;
				}else{
					this.enrichFlag = false;
				}
			}
		} else{
			this.enrichFlag = true;
		}
		
	}*/

	@Override
	public void afterProcess(T item, T result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProcessError(T item, Exception e) {
		// TODO Auto-generated method stub
		
	}

	public boolean isEnrichFlag() {
		return enrichFlag;
	}

	public void setEnrichFlag(boolean enrichFlag) {
		this.enrichFlag = enrichFlag;
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
	 * @return the auditFiles
	 */
	public String getAuditFiles() {
		return auditFiles;
	}

	/**
	 * @param auditFiles the auditFiles to set
	 */
	public void setAuditFiles(String auditFiles) {
		this.auditFiles = auditFiles;
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
