package com.citi.retail.optima.etl.batch.job;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import oracle.net.ns.DataDescriptorPacket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;

import com.citi.optima.batch.job.jdbc.ETLQueryExecutor;
import com.citi.retail.optima.etl.batch.vo.BatchDetailsVO;
import com.citi.retail.optima.etl.cache.lookup.ReferenceValueLookup;
import com.citi.retail.optima.etl.common.ETLConstants;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.model.FilePathDetailsCache;
import com.citi.retail.optima.etl.controller.file.handler.DataAcquisitionHandler;
import com.citi.retail.optima.etl.controller.model.CheckSumDetailsVO;
import com.citi.retail.optima.xsd.internal.OptimaRetailETLEvent;

/**
 * This class is used to launch the jobs for the requests received from the
 * controller module.
 * 
 * @author ns21567
 * 
 */
public class JobParamsService {


	private static final Logger logger = LoggerFactory.getLogger(JobParamsService.class);

	private static DateFormat dateFormat = new SimpleDateFormat(ETLConstants.JOB_STRT_TIME_FRMT);
	private static Date date = new Date();

	private static ETLQueryExecutor queryExec;
	private final static String OS = System.getProperty("os.name").toLowerCase();
	
	

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
	public static JobParameters populateJobParameters(String job,
			final BatchDetailsVO jobDetailsVo,
			final OptimaRetailETLEvent optimaRetailEvent,List<String> fileList,String controlFileName,String fileLocation,ReferenceValueLookup referenceValueLookup, ETLQueryExecutor queryExecutor) throws OptimaRetailApplicationException, IOException {

		queryExec = queryExecutor;
		if(job.contains("TW-MTG")){
			return populateMortgageJobParameters(jobDetailsVo,optimaRetailEvent,fileList,controlFileName,fileLocation,referenceValueLookup, false);
		} else if (job.contains("IN-CRD")) {
			return populateInCardsJobParameters(jobDetailsVo,optimaRetailEvent,fileList,controlFileName,fileLocation,referenceValueLookup);
		} else if (job.contains("IN-RC")) {
			return populateInReadyCreditJobParameters(jobDetailsVo,optimaRetailEvent,fileList,controlFileName,fileLocation,referenceValueLookup);
		}else if(job.contains("IN-PL")) {
			return populateInPLJobParameters(jobDetailsVo,optimaRetailEvent,fileList,controlFileName,fileLocation,referenceValueLookup);
		} else if(job.contains("IN-MTG")){
			return populateInMtgJobParameters(jobDetailsVo,optimaRetailEvent,fileList,controlFileName,fileLocation,referenceValueLookup);
		}else if(job.contains("HK-RC")){
			return populateHkRcJobParameters(jobDetailsVo,optimaRetailEvent,fileList,controlFileName,fileLocation,referenceValueLookup);
		}else if(job.contains("HK-MTG")){
			return populateHkMtgJobParameters(jobDetailsVo,optimaRetailEvent,fileList,controlFileName,fileLocation,referenceValueLookup);
		}else if(job.contains("HK-CRD")){
			return populateHkCardsJobParameters(jobDetailsVo,optimaRetailEvent,fileList,controlFileName,fileLocation,referenceValueLookup);
		}else if(job.contains("HK-PL")){
			return populateHKPLJobParameters(jobDetailsVo,optimaRetailEvent,fileList,controlFileName,fileLocation,referenceValueLookup);
		}else if(job.contains("TW-PL")){
			return populateMortgageJobParameters(jobDetailsVo,optimaRetailEvent,fileList,controlFileName,fileLocation,referenceValueLookup, true);
		}else if(job.contains("TW-RC")){
			return populateTwRcJobParameters(jobDetailsVo,optimaRetailEvent,fileList,controlFileName,fileLocation,referenceValueLookup);
		}else{
			return populateCardsJobParameters(jobDetailsVo,optimaRetailEvent,fileList,controlFileName,fileLocation,referenceValueLookup);
		}
	}

	public static JobParameters populateInMtgJobParameters(
			final BatchDetailsVO jobDetailsVo,
			final OptimaRetailETLEvent optimaRetailEvent,List<String> fileList,String controlFileName,String fileLocation,ReferenceValueLookup referenceValueLookup) throws OptimaRetailApplicationException, IOException {

		JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();

		jobParametersBuilder.addString("REQUEST_ID",
				"ORETL-" + System.currentTimeMillis());
		jobParametersBuilder.addDate(ETLConstants.REPORT_DATE,
				new Date());

		jobParametersBuilder.addLong(ETLConstants.BATCH_ID, new Long(
				jobDetailsVo.getBatchId()));
		jobParametersBuilder.addLong(ETLConstants.SYS_PROC_ID, new Long(jobDetailsVo.getSysProcId()));
		jobParametersBuilder.addLong(ETLConstants.BATCH_INSTANCE_ID, new Long(
				jobDetailsVo.getBatchInstanceId()));
		jobParametersBuilder.addLong(ETLConstants.ORIGINAL_MSG_ID, new Long(
				jobDetailsVo.getOriginalMessageId()));

		jobParametersBuilder.addString(ETLConstants.FILE_PATH,fileLocation);
		jobParametersBuilder.addString(ETLConstants.DA_CONTROL_FILE_NAME,controlFileName.substring(0,controlFileName.lastIndexOf("_")));
		jobParametersBuilder.addString(ETLConstants.JOB_NAME, jobDetailsVo.getBatchName());

		//Populate all the parameters for manual files here.

		Map<String,String> dataFileNames = getInMortgageDataFileDetails(fileList);
		jobParametersBuilder.addString(ETLConstants.DATA_FILE_LIST,getDataFilenameList(dataFileNames));
		
		jobParametersBuilder.addString(ETLConstants.DA_INPUT_COUNT, DataAcquisitionHandler.inMtgCount);
		jobParametersBuilder.addString(ETLConstants.DA_OREO_FILE_STR,dataFileNames.get(ETLConstants.DA_OREO_FILE_STR));
		jobParametersBuilder.addString(ETLConstants.DA_IN_MTG_GCBC_FILE,dataFileNames.get(ETLConstants.DA_IN_MTG_GCBC_FILE));
		jobParametersBuilder.addString(ETLConstants.DA_IN_MTG_GCL_FILE,dataFileNames.get(ETLConstants.DA_IN_MTG_GCL_FILE));

		
		String[] cntFileDetails = controlFileName.split(ETLConstants.SPLITDELIMITER);
		String country = cntFileDetails[2].toUpperCase();
		String product = cntFileDetails[1].toUpperCase();
		String countryProd = country+ETLConstants.DA_JOBNAME_SEP+product;
		
		jobParametersBuilder.addString(ETLConstants.PRODUCT_CODE,cntFileDetails[1]);
		jobParametersBuilder.addString(ETLConstants.COUNTRY_CODE,cntFileDetails[2]);
		jobParametersBuilder.addString("COUNTRYPRODUCT", cntFileDetails[2]+"-"+cntFileDetails[1]);
		
		jobParametersBuilder.addString(ETLConstants.PRODUCT_CODE_UPPER,cntFileDetails[1].toUpperCase());
		jobParametersBuilder.addString(ETLConstants.COUNTRY_CODE_UPPER,cntFileDetails[2].toUpperCase());
		
		//jobParametersBuilder.addString(ETLConstants.DA_INPUT_CKSUM, getInputCksum(dataFileNames.get(ETLConstants.DA_IN_MTG_GCBC_FILE), jobDetailsVo.getBatchName(), fileLocation, "RNBW"));
				jobParametersBuilder.addString(ETLConstants.DA_ENR_INPUT_CKSUM, getInputCksum(dataFileNames.get(ETLConstants.DA_IN_MTG_GCBC_FILE), countryProd, fileLocation, "RNBW", "ENR",cntFileDetails[4]));
				jobParametersBuilder.addString(ETLConstants.DA_UPB_INPUT_CKSUM, getInputCksum(dataFileNames.get(ETLConstants.DA_IN_MTG_GCBC_FILE), countryProd, fileLocation, "RNBW", "UPB",cntFileDetails[4]));

				try {
					jobParametersBuilder.addString(ETLConstants.REGION,referenceValueLookup.getRegionByCountry(cntFileDetails[1]));
					jobParametersBuilder.addString("CTLFILECREATIONDT",getFileCreationDate(FilePathDetailsCache.getProcessedFilePath(cntFileDetails[2].toUpperCase()+ETLConstants.DA_JOBNAME_SEP+cntFileDetails[1].toUpperCase())+ controlFileName));
				} catch (OptimaRetailApplicationException e1) {
					logger.error(" Erorr while getting the region for the coutry "+e1);
					throw e1;
				}catch(IOException ne){
					logger.error(" Erorr whilereading control file to get creation date "+ne);
					throw ne;
				}
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			jobParametersBuilder.addDate(ETLConstants.REPORT_DATE,
					simpleDateFormat.parse(cntFileDetails[4]));
			jobParametersBuilder.addString(ETLConstants.CURRENT_DATE,
					simpleDateFormat.format(new Date()));
			jobParametersBuilder.addString(ETLConstants.JOB_STRT_TIME,cntFileDetails[4] + "_" + dateFormat.format(new Date()));


			// Fx-Rate Changes
			jobParametersBuilder.addString(ETLConstants.DA_FXRATE_FILE_TYP,dataFileNames.get(ETLConstants.DA_FXRATE_FILE_TYP).replace(
					ETLConstants.DATADATE_REGEX, cntFileDetails[4]));

		} catch (ParseException e) {
			logger.error(" Erorr while converting month end date "+e);
		}

		jobParametersBuilder.addString(ETLConstants.DATE_OF_INFO,getLastDate(cntFileDetails[4]));
		jobParametersBuilder.addString(ETLConstants.DATE_OF_EXTRACT,cntFileDetails[7]);
		jobParametersBuilder.addString(ETLConstants.VERSION_ID,cntFileDetails[9].substring(0,cntFileDetails[9].indexOf(".")));
		jobParametersBuilder.addString(ETLConstants.DA_CB_FINANCE_FILE_TYP,dataFileNames.get(ETLConstants.DA_CB_FINANCE_FILE_TYP));
		setAuditParams(jobParametersBuilder,controlFileName.substring(0,controlFileName.lastIndexOf("_")));
		return jobParametersBuilder.toJobParameters();
	}

	public static JobParameters populateCardsJobParameters(
			final BatchDetailsVO jobDetailsVo,
			final OptimaRetailETLEvent optimaRetailEvent,List<String> fileList,String controlFileName,String fileLocation,ReferenceValueLookup referenceValueLookup) throws OptimaRetailApplicationException, IOException {

		JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();

		//GN_163186_CRD_Asia_SG_RSK_<Data DATE>_HIST_<File generated TIME>_CB_V2.dat

		jobParametersBuilder.addString("REQUEST_ID",
				"ORETL-" + System.currentTimeMillis());
		jobParametersBuilder.addDate(ETLConstants.REPORT_DATE,
				new Date());

		jobParametersBuilder.addLong(ETLConstants.BATCH_ID, new Long(
				jobDetailsVo.getBatchId()));
		jobParametersBuilder.addLong(ETLConstants.SYS_PROC_ID, new Long(jobDetailsVo.getSysProcId()));
		jobParametersBuilder.addLong(ETLConstants.BATCH_INSTANCE_ID, new Long(
				jobDetailsVo.getBatchInstanceId()));
		jobParametersBuilder.addLong(ETLConstants.ORIGINAL_MSG_ID, new Long(
				jobDetailsVo.getOriginalMessageId()));

		jobParametersBuilder.addString(ETLConstants.JOB_NAME, jobDetailsVo.getBatchName());

		jobParametersBuilder.addString(ETLConstants.FILE_PATH,fileLocation);
		jobParametersBuilder.addString(ETLConstants.DA_CONTROL_FILE_NAME,controlFileName.substring(0,controlFileName.lastIndexOf("_")));
		Map<String,String> dataFileNames = getCardsDataFileDetails(fileList);
		jobParametersBuilder.addString(ETLConstants.DATA_FILE_LIST,getDataFilenameList(dataFileNames));

		jobParametersBuilder.addString(ETLConstants.DA_RNBW_FILE,dataFileNames.get(ETLConstants.DA_RNBW_FILE));
		jobParametersBuilder.addString(ETLConstants.DA_EPP_FILE,dataFileNames.get(ETLConstants.DA_EPP_FILE));
		jobParametersBuilder.addString(ETLConstants.DA_WO_FILE,dataFileNames.get(ETLConstants.DA_WO_FILE));
		jobParametersBuilder.addString(ETLConstants.DA_TDR_FILE,dataFileNames.get(ETLConstants.DA_TDR_FILE));
		jobParametersBuilder.addString(ETLConstants.DA_REC_FILE,dataFileNames.get(ETLConstants.DA_REC_FILE));
		jobParametersBuilder.addString(ETLConstants.DA_NTB_FILE,dataFileNames.get(ETLConstants.DA_NTB_FILE));
		jobParametersBuilder.addString(ETLConstants.DA_FICO_FILE,dataFileNames.get(ETLConstants.DA_FICO_FILE));
		jobParametersBuilder.addString(ETLConstants.DA_BOOC_FILE,dataFileNames.get(ETLConstants.DA_BOOC_FILE));

		String[] cntFileDetails = controlFileName.split(ETLConstants.SPLITDELIMITER);
		String country = cntFileDetails[1].toUpperCase();
		String product = cntFileDetails[2].toUpperCase();
		String countryProd = country+ETLConstants.DA_JOBNAME_SEP+product;
		jobParametersBuilder.addString(ETLConstants.DA_UPB_INPUT_CKSUM, getInputCksum(dataFileNames.get(ETLConstants.DA_RNBW_FILE), countryProd, fileLocation, "RNBW", "UPB",cntFileDetails[4]));
		
		//ord_tw_crd_20140605_20130930_003145_v2.ctl
		jobParametersBuilder.addString(ETLConstants.PRODUCT_CODE,cntFileDetails[2]);
		jobParametersBuilder.addString(ETLConstants.COUNTRY_CODE,cntFileDetails[1]);
		jobParametersBuilder.addString("COUNTRYPRODUCT", cntFileDetails[1]+"-"+cntFileDetails[2]);
		
		jobParametersBuilder.addString(ETLConstants.PRODUCT_CODE_UPPER,cntFileDetails[2].toUpperCase());
		jobParametersBuilder.addString(ETLConstants.COUNTRY_CODE_UPPER,cntFileDetails[1].toUpperCase());
		try {
			jobParametersBuilder.addString(ETLConstants.REGION,referenceValueLookup.getRegionByCountry(cntFileDetails[1]));
			jobParametersBuilder.addString("CTLFILECREATIONDT",getFileCreationDate(FilePathDetailsCache.getProcessedFilePath(cntFileDetails[1].toUpperCase()+ETLConstants.DA_JOBNAME_SEP+cntFileDetails[2].toUpperCase())+ controlFileName));
		} catch (OptimaRetailApplicationException e1) {
			logger.error(" Erorr while getting the region for the coutry "+e1);
			throw e1;
		}catch(IOException ne){
			logger.error(" Erorr whilereading control file to get creation date "+ne);
			throw ne;
		}
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			jobParametersBuilder.addDate(ETLConstants.REPORT_DATE,
					simpleDateFormat.parse(cntFileDetails[4]));
			jobParametersBuilder.addString(ETLConstants.CURRENT_DATE,
					simpleDateFormat.format(new Date()));

			jobParametersBuilder.addString(ETLConstants.JOB_STRT_TIME,cntFileDetails[4] + "_" + dateFormat.format(new Date()));

			// Fx-Rate Changes
			jobParametersBuilder.addString(ETLConstants.DA_FXRATE_FILE_TYP,dataFileNames.get(ETLConstants.DA_FXRATE_FILE_TYP).replace(
					ETLConstants.DATADATE_REGEX, cntFileDetails[4]));
			jobParametersBuilder.addString(ETLConstants.DA_FXRATE_FILE_TYP,dataFileNames.get(ETLConstants.DA_FXRATE_FILE_TYP).replace(
					ETLConstants.DATADATE_REGEX, cntFileDetails[4]));

		} catch (ParseException e) {
			logger.error(" Erorr while converting month end date "+e);
		}

		jobParametersBuilder.addString(ETLConstants.DATE_OF_INFO,getLastDate(cntFileDetails[4]));
		jobParametersBuilder.addString(ETLConstants.DATE_OF_EXTRACT,cntFileDetails[3]);
		jobParametersBuilder.addString(ETLConstants.VERSION_ID,cntFileDetails[6].substring(0,cntFileDetails[6].indexOf(".")));
		jobParametersBuilder.addString(ETLConstants.DA_CB_FINANCE_FILE_TYP,dataFileNames.get(ETLConstants.DA_CB_FINANCE_FILE_TYP));
		setAuditParams(jobParametersBuilder,controlFileName.substring(0,controlFileName.lastIndexOf("_")));
		return jobParametersBuilder.toJobParameters();

	}

	public static JobParameters populateHkRcJobParameters(
			final BatchDetailsVO jobDetailsVo,
			final OptimaRetailETLEvent optimaRetailEvent,List<String> fileList,String controlFileName,String fileLocation,ReferenceValueLookup referenceValueLookup) throws OptimaRetailApplicationException, IOException {

		JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();

		jobParametersBuilder.addString("REQUEST_ID",
				"ORETL-" + System.currentTimeMillis());
		jobParametersBuilder.addDate(ETLConstants.REPORT_DATE,
				new Date());

		jobParametersBuilder.addLong(ETLConstants.BATCH_ID, new Long(
				jobDetailsVo.getBatchId()));
		jobParametersBuilder.addLong(ETLConstants.SYS_PROC_ID, new Long(jobDetailsVo.getSysProcId()));
		jobParametersBuilder.addLong(ETLConstants.BATCH_INSTANCE_ID, new Long(
				jobDetailsVo.getBatchInstanceId()));
		jobParametersBuilder.addLong(ETLConstants.ORIGINAL_MSG_ID, new Long(
				jobDetailsVo.getOriginalMessageId()));

		jobParametersBuilder.addString(ETLConstants.JOB_NAME, jobDetailsVo.getBatchName());

		jobParametersBuilder.addString(ETLConstants.FILE_PATH,fileLocation);
		jobParametersBuilder.addString(ETLConstants.DA_CONTROL_FILE_NAME,controlFileName.substring(0,controlFileName.lastIndexOf("_")));
		Map<String,String> dataFileNames = getHkRcDataFileDetails(fileList);
		jobParametersBuilder.addString(ETLConstants.DATA_FILE_LIST,getDataFilenameList(dataFileNames));

		jobParametersBuilder.addString(ETLConstants.DA_RNBW_FILE,dataFileNames.get(ETLConstants.DA_RNBW_FILE));
		jobParametersBuilder.addString(ETLConstants.DA_WO_FILE,dataFileNames.get(ETLConstants.DA_WO_FILE));
		jobParametersBuilder.addString(ETLConstants.DA_REC_FILE,dataFileNames.get(ETLConstants.DA_REC_FILE));
		jobParametersBuilder.addString(ETLConstants.DA_FICO_FILE,dataFileNames.get(ETLConstants.DA_FICO_FILE));
		jobParametersBuilder.addString(ETLConstants.DA_CRD_TRANS,dataFileNames.get(ETLConstants.DA_CRD_TRANS));
		jobParametersBuilder.addString(ETLConstants.DA_NEWCOMMITMENT_TYP,dataFileNames.get(ETLConstants.DA_NEWCOMMITMENT));
		jobParametersBuilder.addString(ETLConstants.DA_DELQ,dataFileNames.get(ETLConstants.DA_DELQ));
		jobParametersBuilder.addString(ETLConstants.DA_FXRATE_FILE_TYP,dataFileNames.get(ETLConstants.DA_FXRATE_FILE_TYP));

		String[] cntFileDetails = controlFileName.split(ETLConstants.SPLITDELIMITER);
		String country = cntFileDetails[1].toUpperCase();
		String product = cntFileDetails[2].toUpperCase();
		String countryProd = country+ETLConstants.DA_JOBNAME_SEP+product;
		jobParametersBuilder.addString(ETLConstants.DA_ENR_INPUT_CKSUM, getInputCksum(dataFileNames.get(ETLConstants.DA_RNBW_FILE), countryProd, fileLocation, "RNBW","ENR",cntFileDetails[4]));
		jobParametersBuilder.addString(ETLConstants.DA_UPB_INPUT_CKSUM, getInputCksum(dataFileNames.get(ETLConstants.DA_RNBW_FILE), countryProd, fileLocation, "RNBW","UPB",cntFileDetails[4]));
		
		jobParametersBuilder.addString(ETLConstants.PRODUCT_CODE,cntFileDetails[2]);
		jobParametersBuilder.addString(ETLConstants.COUNTRY_CODE,cntFileDetails[1]);
		jobParametersBuilder.addString("COUNTRYPRODUCT", cntFileDetails[1]+"-"+cntFileDetails[2]);
		
		jobParametersBuilder.addString(ETLConstants.PRODUCT_CODE_UPPER,cntFileDetails[2].toUpperCase());
		jobParametersBuilder.addString(ETLConstants.COUNTRY_CODE_UPPER,cntFileDetails[1].toUpperCase());
		
		try {
			jobParametersBuilder.addString(ETLConstants.REGION,referenceValueLookup.getRegionByCountry(cntFileDetails[1]));
			jobParametersBuilder.addString("CTLFILECREATIONDT",getFileCreationDate(FilePathDetailsCache.getProcessedFilePath(cntFileDetails[1].toUpperCase()+ETLConstants.DA_JOBNAME_SEP+cntFileDetails[2].toUpperCase())+ controlFileName));
		} catch (OptimaRetailApplicationException e1) {
			logger.error(" Erorr while getting the region for the coutry "+e1);
			throw e1;
		}catch(IOException ne){
			logger.error(" Erorr whilereading control file to get creation date "+ne);
			throw ne;
		}
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			jobParametersBuilder.addDate(ETLConstants.REPORT_DATE,
					simpleDateFormat.parse(cntFileDetails[4]));
			jobParametersBuilder.addString(ETLConstants.CURRENT_DATE,
					simpleDateFormat.format(new Date()));

			jobParametersBuilder.addString(ETLConstants.JOB_STRT_TIME,cntFileDetails[4] + "_" + dateFormat.format(new Date()));

			// Fx-Rate Changes
			jobParametersBuilder.addString(ETLConstants.DA_FXRATE_FILE_TYP,dataFileNames.get(ETLConstants.DA_FXRATE_FILE_TYP).replace(
					ETLConstants.DATADATE_REGEX, cntFileDetails[4]));

		} catch (ParseException e) {
			logger.error(" Erorr while converting month end date "+e);
		}

		jobParametersBuilder.addString(ETLConstants.DATE_OF_INFO,getLastDate(cntFileDetails[4]));
		jobParametersBuilder.addString(ETLConstants.DATE_OF_EXTRACT,cntFileDetails[3]);
		jobParametersBuilder.addString(ETLConstants.VERSION_ID,cntFileDetails[6].substring(0,cntFileDetails[6].indexOf(".")));
		jobParametersBuilder.addString(ETLConstants.DA_CB_FINANCE_FILE_TYP,dataFileNames.get(ETLConstants.DA_CB_FINANCE_FILE_TYP));
		setAuditParams(jobParametersBuilder,controlFileName.substring(0,controlFileName.lastIndexOf("_")));
		return jobParametersBuilder.toJobParameters();

	}

	public static JobParameters populateHkCardsJobParameters(
			final BatchDetailsVO jobDetailsVo,
			final OptimaRetailETLEvent optimaRetailEvent,List<String> fileList,String controlFileName,String fileLocation,ReferenceValueLookup referenceValueLookup) throws OptimaRetailApplicationException, IOException {

		JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();

		//GN_163186_CRD_Asia_SG_RSK_<Data DATE>_HIST_<File generated TIME>_CB_V2.dat

		jobParametersBuilder.addString("REQUEST_ID",
				"ORETL-" + System.currentTimeMillis());
		jobParametersBuilder.addDate(ETLConstants.REPORT_DATE,
				new Date());

		jobParametersBuilder.addLong(ETLConstants.BATCH_ID, new Long(
				jobDetailsVo.getBatchId()));
		jobParametersBuilder.addLong(ETLConstants.SYS_PROC_ID, new Long(jobDetailsVo.getSysProcId()));
		jobParametersBuilder.addLong(ETLConstants.BATCH_INSTANCE_ID, new Long(
				jobDetailsVo.getBatchInstanceId()));
		jobParametersBuilder.addLong(ETLConstants.ORIGINAL_MSG_ID, new Long(
				jobDetailsVo.getOriginalMessageId()));

		jobParametersBuilder.addString(ETLConstants.JOB_NAME, jobDetailsVo.getBatchName());

		jobParametersBuilder.addString(ETLConstants.FILE_PATH,fileLocation);
		jobParametersBuilder.addString(ETLConstants.DA_CONTROL_FILE_NAME,controlFileName.substring(0,controlFileName.lastIndexOf("_")));
		Map<String,String> dataFileNames = getHkCardsDataFileDetails(fileList);
		jobParametersBuilder.addString(ETLConstants.DATA_FILE_LIST,getDataFilenameList(dataFileNames));

		jobParametersBuilder.addString(ETLConstants.DA_RNBW_BC_FILE,dataFileNames.get(ETLConstants.DA_RNBW_BC_FILE));
		jobParametersBuilder.addString(ETLConstants.DA_RNBW_DC_FILE,dataFileNames.get(ETLConstants.DA_RNBW_DC_FILE));
		jobParametersBuilder.addString(ETLConstants.DA_WO_BC_FILE,dataFileNames.get(ETLConstants.DA_WO_BC_FILE));
		jobParametersBuilder.addString(ETLConstants.DA_WO_DC_FILE,dataFileNames.get(ETLConstants.DA_WO_DC_FILE));
		jobParametersBuilder.addString(ETLConstants.DA_FICO_BC_FILE,dataFileNames.get(ETLConstants.DA_FICO_BC_FILE));
		jobParametersBuilder.addString(ETLConstants.DA_FICO_DC_FILE,dataFileNames.get(ETLConstants.DA_FICO_DC_FILE));
		jobParametersBuilder.addString(ETLConstants.DA_DELQ_DC_FILE,dataFileNames.get(ETLConstants.DA_DELQ_DC_FILE));
		jobParametersBuilder.addString(ETLConstants.DA_DELQ_BC_FILE,dataFileNames.get(ETLConstants.DA_DELQ_BC_FILE));
		jobParametersBuilder.addString(ETLConstants.DA_NEW_BC_FILE,dataFileNames.get(ETLConstants.DA_NEW_BC_FILE));
		jobParametersBuilder.addString(ETLConstants.DA_NEW_DC_FILE,dataFileNames.get(ETLConstants.DA_NEW_DC_FILE));
		jobParametersBuilder.addString(ETLConstants.DA_CRD_TRANS_FILE,dataFileNames.get(ETLConstants.DA_CRD_TRANS_FILE));
		jobParametersBuilder.addString(ETLConstants.DA_REC_FILE,dataFileNames.get(ETLConstants.DA_REC_FILE));
		//jobParametersBuilder.addString(ETLConstants.DA_WO_REC_FILE,dataFileNames.get(ETLConstants.DA_WO_REC_FILE));

		
		String[] cntFileDetails = controlFileName.split(ETLConstants.SPLITDELIMITER);
		String country = cntFileDetails[1].toUpperCase();
		String product = cntFileDetails[2].toUpperCase();
		String countryProd = country+ETLConstants.DA_JOBNAME_SEP+product;
		jobParametersBuilder.addString(ETLConstants.PRODUCT_CODE,cntFileDetails[2]);
		jobParametersBuilder.addString(ETLConstants.COUNTRY_CODE,cntFileDetails[1]);
		jobParametersBuilder.addString("COUNTRYPRODUCT", cntFileDetails[1]+"-"+cntFileDetails[2]);
		
		
		jobParametersBuilder.addString(ETLConstants.PRODUCT_CODE_UPPER,cntFileDetails[2].toUpperCase());
		jobParametersBuilder.addString(ETLConstants.COUNTRY_CODE_UPPER,cntFileDetails[1].toUpperCase());
		
		try {
			jobParametersBuilder.addString(ETLConstants.REGION,referenceValueLookup.getRegionByCountry(cntFileDetails[1]));
			jobParametersBuilder.addString("CTLFILECREATIONDT",getFileCreationDate(FilePathDetailsCache.getProcessedFilePath(cntFileDetails[1].toUpperCase()+ETLConstants.DA_JOBNAME_SEP+cntFileDetails[2].toUpperCase())+ controlFileName));
		} catch (OptimaRetailApplicationException e1) {
			logger.error(" Erorr while getting the region for the coutry "+e1);
			throw e1;
		}catch(IOException ne){
			logger.error(" Erorr whilereading control file to get creation date "+ne);
			throw ne;
		}
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			jobParametersBuilder.addDate(ETLConstants.REPORT_DATE,
					simpleDateFormat.parse(cntFileDetails[4]));
			jobParametersBuilder.addString(ETLConstants.CURRENT_DATE,
					simpleDateFormat.format(new Date()));

			jobParametersBuilder.addString(ETLConstants.JOB_STRT_TIME,cntFileDetails[4] + "_" + dateFormat.format(new Date()));

			// Fx-Rate Changes
			jobParametersBuilder.addString(ETLConstants.DA_FXRATE_FILE_TYP,dataFileNames.get(ETLConstants.DA_FXRATE_FILE_TYP).replace(
					ETLConstants.DATADATE_REGEX, cntFileDetails[4]));
			
				
				Double enrInputCksum = Double.valueOf((getInputCksum(dataFileNames.get(ETLConstants.DA_RNBW_BC_FILE), countryProd, fileLocation, "RNBW","ENR",cntFileDetails[4])));
				Double enrInputCksum1 = enrInputCksum + Double.valueOf((getInputCksum(dataFileNames.get(ETLConstants.DA_RNBW_DC_FILE), countryProd, fileLocation, "RNBW","ENR",cntFileDetails[4])));
				jobParametersBuilder.addString(ETLConstants.DA_ENR_INPUT_CKSUM, enrInputCksum1.toString());

				Double upbInputCksum = Double.valueOf((getInputCksum(dataFileNames.get(ETLConstants.DA_RNBW_BC_FILE), countryProd, fileLocation, "RNBW","UPB",cntFileDetails[4])));
				Double upbInputCksum1 = upbInputCksum + Double.valueOf((getInputCksum(dataFileNames.get(ETLConstants.DA_RNBW_DC_FILE), countryProd, fileLocation, "RNBW","UPB", cntFileDetails[4])));
				jobParametersBuilder.addString(ETLConstants.DA_UPB_INPUT_CKSUM, upbInputCksum1.toString());

		} catch (ParseException e) {
			logger.error(" Erorr while converting month end date "+e);
		}

		jobParametersBuilder.addString(ETLConstants.DATE_OF_INFO,getLastDate(cntFileDetails[4]));
		jobParametersBuilder.addString(ETLConstants.DATE_OF_EXTRACT,cntFileDetails[3]);
		jobParametersBuilder.addString(ETLConstants.VERSION_ID,cntFileDetails[6].substring(0,cntFileDetails[6].indexOf(".")));
		jobParametersBuilder.addString(ETLConstants.DA_CB_FINANCE_FILE_TYP,dataFileNames.get(ETLConstants.DA_CB_FINANCE_FILE_TYP));
		setAuditParams(jobParametersBuilder,controlFileName.substring(0,controlFileName.lastIndexOf("_")));;
		return jobParametersBuilder.toJobParameters();

	}


	public static JobParameters populateInPLJobParameters(
			final BatchDetailsVO jobDetailsVo,
			final OptimaRetailETLEvent optimaRetailEvent,List<String> fileList,String controlFileName,String fileLocation,ReferenceValueLookup referenceValueLookup) throws OptimaRetailApplicationException, IOException {

		JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();

		jobParametersBuilder.addString("REQUEST_ID",
				"ORETL-" + System.currentTimeMillis());
		jobParametersBuilder.addDate(ETLConstants.REPORT_DATE,
				new Date());

		jobParametersBuilder.addLong(ETLConstants.BATCH_ID, new Long(
				jobDetailsVo.getBatchId()));
		jobParametersBuilder.addLong(ETLConstants.SYS_PROC_ID, new Long(jobDetailsVo.getSysProcId()));
		jobParametersBuilder.addLong(ETLConstants.BATCH_INSTANCE_ID, new Long(
				jobDetailsVo.getBatchInstanceId()));
		jobParametersBuilder.addLong(ETLConstants.ORIGINAL_MSG_ID, new Long(
				jobDetailsVo.getOriginalMessageId()));

		jobParametersBuilder.addString(ETLConstants.JOB_NAME, jobDetailsVo.getBatchName());

		jobParametersBuilder.addString(ETLConstants.FILE_PATH,fileLocation);
		jobParametersBuilder.addString(ETLConstants.DA_CONTROL_FILE_NAME,controlFileName.substring(0,controlFileName.lastIndexOf("_")));

		Map<String,String> dataFileNames = getInPLDataFileDetails(fileList);
		jobParametersBuilder.addString(ETLConstants.DATA_FILE_LIST,getDataFilenameList(dataFileNames));

		jobParametersBuilder.addString(ETLConstants.DA_IN_PL_FILE,dataFileNames.get(ETLConstants.DA_IN_PL_FILE));

		
		String[] cntFileDetails = controlFileName.split(ETLConstants.SPLITDELIMITER);
		String country = cntFileDetails[1].toUpperCase();
		String product = cntFileDetails[2].toUpperCase();
		String countryProd = country+ETLConstants.DA_JOBNAME_SEP+product;
		//jobParametersBuilder.addString(ETLConstants.DA_INPUT_CKSUM, getInputCksum(dataFileNames.get(ETLConstants.DA_IN_PL_FILE), jobDetailsVo.getBatchName(), fileLocation, "RNBW"));
				jobParametersBuilder.addString(ETLConstants.DA_ENR_INPUT_CKSUM, getInputCksum(dataFileNames.get(ETLConstants.DA_IN_PL_FILE), countryProd, fileLocation, "RNBW", "ENR", cntFileDetails[4]));
				jobParametersBuilder.addString(ETLConstants.DA_UPB_INPUT_CKSUM, getInputCksum(dataFileNames.get(ETLConstants.DA_IN_PL_FILE), countryProd, fileLocation, "RNBW", "UPB",  cntFileDetails[4]));
//				
		jobParametersBuilder.addString(ETLConstants.PRODUCT_CODE,cntFileDetails[2]);
		jobParametersBuilder.addString(ETLConstants.COUNTRY_CODE,cntFileDetails[1]);
		jobParametersBuilder.addString("COUNTRYPRODUCT", cntFileDetails[1]+"-"+cntFileDetails[2]);
		
		jobParametersBuilder.addString(ETLConstants.PRODUCT_CODE_UPPER,cntFileDetails[2].toUpperCase());
		jobParametersBuilder.addString(ETLConstants.COUNTRY_CODE_UPPER,cntFileDetails[1].toUpperCase());
		
		try {
			jobParametersBuilder.addString(ETLConstants.REGION,referenceValueLookup.getRegionByCountry(cntFileDetails[1]));
			jobParametersBuilder.addString("CTLFILECREATIONDT",getFileCreationDate(FilePathDetailsCache.getProcessedFilePath(cntFileDetails[1].toUpperCase()+ETLConstants.DA_JOBNAME_SEP+cntFileDetails[2].toUpperCase())+ controlFileName));
		} catch (OptimaRetailApplicationException e1) {
			logger.error(" Erorr while getting the region for the coutry "+e1);
			throw e1;
		}catch(IOException ne){
			logger.error(" Erorr whilereading control file to get creation date "+ne);
			throw ne;
		}
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			jobParametersBuilder.addDate(ETLConstants.REPORT_DATE,
					simpleDateFormat.parse(cntFileDetails[4]));
			jobParametersBuilder.addString(ETLConstants.CURRENT_DATE,
					simpleDateFormat.format(new Date()));

			jobParametersBuilder.addString(ETLConstants.JOB_STRT_TIME,cntFileDetails[4] + "_" + dateFormat.format(new Date()));

			// Fx-Rate Changes
			jobParametersBuilder.addString(ETLConstants.DA_FXRATE_FILE_TYP,dataFileNames.get(ETLConstants.DA_FXRATE_FILE_TYP).replace(
					ETLConstants.DATADATE_REGEX, cntFileDetails[4]));
		} catch (ParseException e) {
			logger.error(" Erorr while converting month end date "+e);
		}

		jobParametersBuilder.addString(ETLConstants.DATE_OF_INFO,getLastDate(cntFileDetails[4]));
		jobParametersBuilder.addString(ETLConstants.DATE_OF_EXTRACT,cntFileDetails[3]);
		jobParametersBuilder.addString(ETLConstants.VERSION_ID,cntFileDetails[6].substring(0,cntFileDetails[6].indexOf(".")));
		jobParametersBuilder.addString(ETLConstants.DA_CB_FINANCE_FILE_TYP,dataFileNames.get(ETLConstants.DA_CB_FINANCE_FILE_TYP));
		setAuditParams(jobParametersBuilder,controlFileName.substring(0,controlFileName.lastIndexOf("_")));
		return jobParametersBuilder.toJobParameters();

	}

	public static JobParameters populateHKPLJobParameters(
			final BatchDetailsVO jobDetailsVo,
			final OptimaRetailETLEvent optimaRetailEvent,List<String> fileList,String controlFileName,String fileLocation,ReferenceValueLookup referenceValueLookup) throws OptimaRetailApplicationException, IOException {

		JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();

		jobParametersBuilder.addString("REQUEST_ID",
				"ORETL-" + System.currentTimeMillis());
		jobParametersBuilder.addDate(ETLConstants.REPORT_DATE,
				new Date());

		jobParametersBuilder.addLong(ETLConstants.BATCH_ID, new Long(
				jobDetailsVo.getBatchId()));
		jobParametersBuilder.addLong(ETLConstants.SYS_PROC_ID, new Long(jobDetailsVo.getSysProcId()));
		jobParametersBuilder.addLong(ETLConstants.BATCH_INSTANCE_ID, new Long(
				jobDetailsVo.getBatchInstanceId()));
		jobParametersBuilder.addLong(ETLConstants.ORIGINAL_MSG_ID, new Long(
				jobDetailsVo.getOriginalMessageId()));

		jobParametersBuilder.addString(ETLConstants.JOB_NAME, jobDetailsVo.getBatchName());

		jobParametersBuilder.addString(ETLConstants.FILE_PATH,fileLocation);
		jobParametersBuilder.addString(ETLConstants.DA_CONTROL_FILE_NAME,controlFileName.substring(0,controlFileName.lastIndexOf("_")));
		Map<String,String> dataFileNames = getHKPLDataFileDetails(fileList);
		jobParametersBuilder.addString(ETLConstants.DATA_FILE_LIST,getDataFilenameList(dataFileNames));

		jobParametersBuilder.addString(ETLConstants.DA_RNBW_FILE,dataFileNames.get(ETLConstants.DA_RNBW_FILE));			
		jobParametersBuilder.addString(ETLConstants.DA_WO_FILE,dataFileNames.get(ETLConstants.DA_WO_FILE));			
		jobParametersBuilder.addString(ETLConstants.DA_REC_FILE,dataFileNames.get(ETLConstants.DA_REC_FILE));			
		jobParametersBuilder.addString(ETLConstants.DA_FICO_FILE,dataFileNames.get(ETLConstants.DA_FICO_FILE));

		
		String[] cntFileDetails = controlFileName.split(ETLConstants.SPLITDELIMITER);
		String country = cntFileDetails[1].toUpperCase();
		String product = cntFileDetails[2].toUpperCase();
		String countryProd = country+ETLConstants.DA_JOBNAME_SEP+product;
		jobParametersBuilder.addString(ETLConstants.DA_ENR_INPUT_CKSUM, getInputCksum(dataFileNames.get(ETLConstants.DA_RNBW_FILE), countryProd, fileLocation, "RNBW","ENR", cntFileDetails[4]));

		jobParametersBuilder.addString(ETLConstants.PRODUCT_CODE,cntFileDetails[2]);
		jobParametersBuilder.addString(ETLConstants.PRODUCT_CODE+"2",cntFileDetails[2]);
		//jobParametersBuilder.addString(ETLConstants.PRODUCT_CODE+"2","LOANS");
		jobParametersBuilder.addString(ETLConstants.COUNTRY_CODE,cntFileDetails[1]);
		jobParametersBuilder.addString("COUNTRYPRODUCT", cntFileDetails[1]+"-"+cntFileDetails[2]);
		
		jobParametersBuilder.addString(ETLConstants.PRODUCT_CODE_UPPER,cntFileDetails[2].toUpperCase());
		jobParametersBuilder.addString(ETLConstants.COUNTRY_CODE_UPPER,cntFileDetails[1].toUpperCase());

		try {
			jobParametersBuilder.addString(ETLConstants.REGION,referenceValueLookup.getRegionByCountry(cntFileDetails[1]));
			jobParametersBuilder.addString("CTLFILECREATIONDT",getFileCreationDate(FilePathDetailsCache.getProcessedFilePath(cntFileDetails[1].toUpperCase()+ETLConstants.DA_JOBNAME_SEP+cntFileDetails[2].toUpperCase())+ controlFileName));
		} catch (OptimaRetailApplicationException e1) {
			logger.error(" Erorr while getting the region for the coutry "+e1);
			throw e1;
		}catch(IOException ne){
			logger.error(" Erorr whilereading control file to get creation date "+ne);
			throw ne;
		}
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			jobParametersBuilder.addDate(ETLConstants.REPORT_DATE,
					simpleDateFormat.parse(cntFileDetails[4]));
			jobParametersBuilder.addString(ETLConstants.CURRENT_DATE,
					simpleDateFormat.format(new Date()));

			jobParametersBuilder.addString(ETLConstants.JOB_STRT_TIME,cntFileDetails[4] + "_" + dateFormat.format(new Date()));

			// Fx-Rate Changes
			jobParametersBuilder.addString(ETLConstants.DA_FXRATE_FILE_TYP,dataFileNames.get(ETLConstants.DA_FXRATE_FILE_TYP).replace(
					ETLConstants.DATADATE_REGEX, cntFileDetails[4]));
		} catch (ParseException e) {
			logger.error(" Erorr while converting month end date "+e);
		}

		jobParametersBuilder.addString(ETLConstants.DATE_OF_INFO,getLastDate(cntFileDetails[4]));
		jobParametersBuilder.addString(ETLConstants.DATE_OF_EXTRACT,cntFileDetails[3]);
		jobParametersBuilder.addString(ETLConstants.VERSION_ID,cntFileDetails[6].substring(0,cntFileDetails[6].indexOf(".")));
		jobParametersBuilder.addString(ETLConstants.DA_CB_FINANCE_FILE_TYP,dataFileNames.get(ETLConstants.DA_CB_FINANCE_FILE_TYP));
		setAuditParams(jobParametersBuilder,controlFileName.substring(0,controlFileName.lastIndexOf("_")));
		return jobParametersBuilder.toJobParameters();

	}

	public static JobParameters populateMortgageJobParameters(
			final BatchDetailsVO jobDetailsVo,
			final OptimaRetailETLEvent optimaRetailEvent,List<String> fileList,String controlFileName,String fileLocation,ReferenceValueLookup referenceValueLookup, boolean isPl) throws OptimaRetailApplicationException, IOException {

		JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();

		jobParametersBuilder.addString("REQUEST_ID",
				"ORETL-" + System.currentTimeMillis());
		jobParametersBuilder.addDate(ETLConstants.REPORT_DATE,
				new Date());

		jobParametersBuilder.addLong(ETLConstants.BATCH_ID, new Long(
				jobDetailsVo.getBatchId()));
		jobParametersBuilder.addLong(ETLConstants.SYS_PROC_ID, new Long(jobDetailsVo.getSysProcId()));
		jobParametersBuilder.addLong(ETLConstants.BATCH_INSTANCE_ID, new Long(
				jobDetailsVo.getBatchInstanceId()));
		jobParametersBuilder.addLong(ETLConstants.ORIGINAL_MSG_ID, new Long(
				jobDetailsVo.getOriginalMessageId()));

		jobParametersBuilder.addString(ETLConstants.JOB_NAME, jobDetailsVo.getBatchName());

		jobParametersBuilder.addString(ETLConstants.FILE_PATH,fileLocation);
		jobParametersBuilder.addString(ETLConstants.DA_CONTROL_FILE_NAME,controlFileName.substring(0,controlFileName.lastIndexOf("_")));

		//Populate all the parameters for manual files here.

		Map<String,String> dataFileNames = getMortgageDataFileDetails(fileList);
		jobParametersBuilder.addString(ETLConstants.DATA_FILE_LIST,getDataFilenameList(dataFileNames));


		jobParametersBuilder.addString("OREO",dataFileNames.get("OREO"));
		jobParametersBuilder.addString("BAUIMP",dataFileNames.get("BAUIMP"));
		jobParametersBuilder.addString("FICO",dataFileNames.get("FICO"));
		jobParametersBuilder.addString("FIP",dataFileNames.get("FIP"));
		jobParametersBuilder.addString("MEMO",dataFileNames.get("MEMO"));
		jobParametersBuilder.addString("MUTCOL",dataFileNames.get("MUTCOL"));
		jobParametersBuilder.addString("TDR",dataFileNames.get("TDR"));
		jobParametersBuilder.addString("TEASER",dataFileNames.get("TEASER"));
		jobParametersBuilder.addString("ALS",dataFileNames.get("ALS"));
		jobParametersBuilder.addString("LOANS",dataFileNames.get("LOANS"));
		

		String[] cntFileDetails = controlFileName.split(ETLConstants.SPLITDELIMITER);
		String country = cntFileDetails[1].toUpperCase();
		String product = cntFileDetails[2].toUpperCase();
		String countryProd = country+ETLConstants.DA_JOBNAME_SEP+product;
		
		if(isPl){
			jobParametersBuilder.addString(ETLConstants.DA_INPUT_CKSUM, "");
			jobParametersBuilder.addString(ETLConstants.DA_UPB_INPUT_CKSUM, getInputCksum(dataFileNames.get("LOANS"), countryProd, fileLocation, "RNBW","UPB", cntFileDetails[4]));
		}else{
			jobParametersBuilder.addString(ETLConstants.DA_ENR_INPUT_CKSUM, getInputCksum(dataFileNames.get("ALS"), countryProd, fileLocation, "RNBW","ENR", cntFileDetails[4]));
			jobParametersBuilder.addString(ETLConstants.DA_UPB_INPUT_CKSUM, getInputCksum(dataFileNames.get("ALS"), countryProd, fileLocation, "RNBW","UPB", cntFileDetails[4]));
		}

		jobParametersBuilder.addString(ETLConstants.PRODUCT_CODE,cntFileDetails[2]);
		jobParametersBuilder.addString(ETLConstants.PRODUCT_CODE+"2","pcl");
		jobParametersBuilder.addString(ETLConstants.COUNTRY_CODE,cntFileDetails[1]);
		jobParametersBuilder.addString("COUNTRYPRODUCT", cntFileDetails[1]+"-"+cntFileDetails[2]);
		
		jobParametersBuilder.addString(ETLConstants.PRODUCT_CODE_UPPER,cntFileDetails[2].toUpperCase());
		jobParametersBuilder.addString(ETLConstants.COUNTRY_CODE_UPPER,cntFileDetails[1].toUpperCase());

		try {
			jobParametersBuilder.addString(ETLConstants.REGION,referenceValueLookup.getRegionByCountry(cntFileDetails[1]));
			jobParametersBuilder.addString("CTLFILECREATIONDT",getFileCreationDate(FilePathDetailsCache.getProcessedFilePath(cntFileDetails[1].toUpperCase()+ETLConstants.DA_JOBNAME_SEP+cntFileDetails[2].toUpperCase())+ controlFileName));
		} catch (OptimaRetailApplicationException e1) {
			logger.error(" Erorr while getting the region for the coutry "+e1);
			throw e1;
		}catch(IOException ne){
			logger.error(" Erorr whilereading control file to get creation date "+ne);
			throw ne;
		}
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			jobParametersBuilder.addDate(ETLConstants.REPORT_DATE,
					simpleDateFormat.parse(cntFileDetails[4]));
			jobParametersBuilder.addString(ETLConstants.CURRENT_DATE,
					simpleDateFormat.format(new Date()));

			jobParametersBuilder.addString(ETLConstants.JOB_STRT_TIME,cntFileDetails[4] + "_" + dateFormat.format(new Date()));

			// Fx-Rate Changes
			jobParametersBuilder.addString(ETLConstants.DA_FXRATE_FILE_TYP,dataFileNames.get(ETLConstants.DA_FXRATE_FILE_TYP).replace(
					ETLConstants.DATADATE_REGEX, cntFileDetails[4]));
		} catch (ParseException e) {
			logger.error(" Erorr while converting month end date "+e);
		}

		jobParametersBuilder.addString(ETLConstants.DATE_OF_INFO,getLastDate(cntFileDetails[4]));
		jobParametersBuilder.addString(ETLConstants.DATE_OF_EXTRACT,cntFileDetails[3]);
		jobParametersBuilder.addString(ETLConstants.VERSION_ID,cntFileDetails[6].substring(0,cntFileDetails[6].indexOf(".")));
		jobParametersBuilder.addString(ETLConstants.DA_CB_FINANCE_FILE_TYP,dataFileNames.get(ETLConstants.DA_CB_FINANCE_FILE_TYP));	
		
		
		setAuditParams(jobParametersBuilder,controlFileName.substring(0,controlFileName.lastIndexOf("_")));
		return jobParametersBuilder.toJobParameters();

	}

	public static JobParameters populateInCardsJobParameters(
			final BatchDetailsVO jobDetailsVo,
			final OptimaRetailETLEvent optimaRetailEvent,List<String> fileList,String controlFileName,String fileLocation,ReferenceValueLookup referenceValueLookup) throws OptimaRetailApplicationException, IOException {

		JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();

		//GN_163186_CRD_Asia_SG_RSK_<Data DATE>_HIST_<File generated TIME>_CB_V2.dat

		jobParametersBuilder.addString("REQUEST_ID",
				"ORETL-" + System.currentTimeMillis());
		jobParametersBuilder.addDate(ETLConstants.REPORT_DATE,
				new Date());

		jobParametersBuilder.addLong(ETLConstants.BATCH_ID, new Long(
				jobDetailsVo.getBatchId()));
		jobParametersBuilder.addLong(ETLConstants.SYS_PROC_ID, new Long(jobDetailsVo.getSysProcId()));
		jobParametersBuilder.addLong(ETLConstants.BATCH_INSTANCE_ID, new Long(
				jobDetailsVo.getBatchInstanceId()));
		jobParametersBuilder.addLong(ETLConstants.ORIGINAL_MSG_ID, new Long(
				jobDetailsVo.getOriginalMessageId()));

		jobParametersBuilder.addString(ETLConstants.JOB_NAME, jobDetailsVo.getBatchName());

		jobParametersBuilder.addString(ETLConstants.FILE_PATH,fileLocation);

		Map<String,String> dataFileNames = getInCardsDataFileDetails(fileList);
		jobParametersBuilder.addString(ETLConstants.DATA_FILE_LIST,getDataFilenameList(dataFileNames));
		
		jobParametersBuilder.addString(ETLConstants.DA_IN_CRD_FILE,dataFileNames.get(ETLConstants.DA_IN_CRD_FILE));
		jobParametersBuilder.addString(ETLConstants.DA_CONTROL_FILE_NAME,controlFileName.substring(0,controlFileName.lastIndexOf("_")));

		//jobParametersBuilder.addString(ETLConstants.DA_INPUT_CKSUM, getInputCksum(dataFileNames.get(ETLConstants.DA_IN_CRD_FILE), jobDetailsVo.getBatchName(), fileLocation, "RNBW"));
		//new code
		
//		jobParametersBuilder.addString(ETLConstants.DA_ARFINSTATTYPID_INPUT_CKSUM, getInputCksum(dataFileNames.get(ETLConstants.DA_IN_CRD_FILE), jobDetailsVo.getBatchName(), fileLocation, "RNBW"));
//		jobParametersBuilder.addString(ETLConstants.DA_ARPASTDUECLASS_INPUT_CKSUM, getInputCksum(dataFileNames.get(ETLConstants.DA_IN_CRD_FILE), jobDetailsVo.getBatchName(), fileLocation, "RNBW"));
		String[] cntFileDetails = controlFileName.split(ETLConstants.SPLITDELIMITER);
		String country = cntFileDetails[1].toUpperCase();
		String product = cntFileDetails[2].toUpperCase();
		String countryProd = country+ETLConstants.DA_JOBNAME_SEP+product;
		jobParametersBuilder.addString(ETLConstants.DA_ENR_INPUT_CKSUM, getInputCksum(dataFileNames.get(ETLConstants.DA_IN_CRD_FILE), countryProd, fileLocation, "RNBW", "ENR",  cntFileDetails[4]));
		jobParametersBuilder.addString(ETLConstants.DA_UPB_INPUT_CKSUM, getInputCksum(dataFileNames.get(ETLConstants.DA_IN_CRD_FILE), countryProd, fileLocation, "RNBW", "UPB",  cntFileDetails[4]));
		
		jobParametersBuilder.addString(ETLConstants.PRODUCT_CODE,cntFileDetails[2]);
		jobParametersBuilder.addString(ETLConstants.COUNTRY_CODE,cntFileDetails[1]);
		jobParametersBuilder.addString("COUNTRYPRODUCT", cntFileDetails[1]+"-"+cntFileDetails[2]);
		
		jobParametersBuilder.addString(ETLConstants.PRODUCT_CODE_UPPER,cntFileDetails[2].toUpperCase());
		jobParametersBuilder.addString(ETLConstants.COUNTRY_CODE_UPPER,cntFileDetails[1].toUpperCase());
		
		try {
			jobParametersBuilder.addString(ETLConstants.REGION,referenceValueLookup.getRegionByCountry(cntFileDetails[1]));
			jobParametersBuilder.addString("CTLFILECREATIONDT",getFileCreationDate(FilePathDetailsCache.getProcessedFilePath(cntFileDetails[1].toUpperCase()+ETLConstants.DA_JOBNAME_SEP+cntFileDetails[2].toUpperCase())+ controlFileName));
		} catch (OptimaRetailApplicationException e1) {
			logger.error(" Erorr while getting the region for the coutry "+e1);
			throw e1;
		}catch(IOException ne){
			logger.error(" Erorr whilereading control file to get creation date "+ne);
			throw ne;
		}
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			jobParametersBuilder.addDate(ETLConstants.REPORT_DATE,
					simpleDateFormat.parse(cntFileDetails[4]));
			jobParametersBuilder.addString(ETLConstants.CURRENT_DATE,
					simpleDateFormat.format(new Date()));

			jobParametersBuilder.addString(ETLConstants.JOB_STRT_TIME,cntFileDetails[4] + "_" + dateFormat.format(new Date()));
			
			// Fx-Rate Changes
			jobParametersBuilder.addString(ETLConstants.DA_FXRATE_FILE_TYP,dataFileNames.get(ETLConstants.DA_FXRATE_FILE_TYP).replace(
					ETLConstants.DATADATE_REGEX, cntFileDetails[4]));
		} catch (ParseException e) {
			logger.error(" Erorr while converting month end date "+e);
		}

		jobParametersBuilder.addString(ETLConstants.DATE_OF_INFO,getLastDate(cntFileDetails[4]));
		jobParametersBuilder.addString(ETLConstants.DATE_OF_EXTRACT,cntFileDetails[3]);
		jobParametersBuilder.addString(ETLConstants.VERSION_ID,cntFileDetails[6].substring(0,cntFileDetails[6].indexOf(".")));
		jobParametersBuilder.addString(ETLConstants.DA_CB_FINANCE_FILE_TYP,dataFileNames.get(ETLConstants.DA_CB_FINANCE_FILE_TYP));
		
		setAuditParams(jobParametersBuilder,controlFileName.substring(0,controlFileName.lastIndexOf("_")));
		
		return jobParametersBuilder.toJobParameters();

	}



	public static JobParameters populateInReadyCreditJobParameters(
			final BatchDetailsVO jobDetailsVo,
			final OptimaRetailETLEvent optimaRetailEvent,List<String> fileList,String controlFileName,String fileLocation,ReferenceValueLookup referenceValueLookup) throws OptimaRetailApplicationException, IOException {

		JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();

		//		OR_RC_IN_20131030_HIST_IN_RWMAST_20140131_Data.v2.dat
		//		OR_RC_IN_20131030_HIST_IN_RETMAST_20140131_Data.v2.dat
		//		OR_RC_IN_20131030_HIST_IN_CORPMAST_20140131_Data.v2.dat

		jobParametersBuilder.addString("REQUEST_ID",
				"ORETL-" + System.currentTimeMillis());
		jobParametersBuilder.addDate(ETLConstants.REPORT_DATE,
				new Date());

		jobParametersBuilder.addLong(ETLConstants.BATCH_ID, new Long(
				jobDetailsVo.getBatchId()));
		jobParametersBuilder.addLong(ETLConstants.SYS_PROC_ID, new Long(jobDetailsVo.getSysProcId()));
		jobParametersBuilder.addLong(ETLConstants.BATCH_INSTANCE_ID, new Long(
				jobDetailsVo.getBatchInstanceId()));
		jobParametersBuilder.addLong(ETLConstants.ORIGINAL_MSG_ID, new Long(
				jobDetailsVo.getOriginalMessageId()));

		jobParametersBuilder.addString(ETLConstants.JOB_NAME, jobDetailsVo.getBatchName());

		jobParametersBuilder.addString(ETLConstants.FILE_PATH,fileLocation);
		jobParametersBuilder.addString(ETLConstants.DA_CONTROL_FILE_NAME,controlFileName.substring(0,controlFileName.lastIndexOf("_")));

		Map<String,String> dataFileNames = getInReadyCreditDataFileDetails(fileList);
		jobParametersBuilder.addString(ETLConstants.DATA_FILE_LIST,getDataFilenameList(dataFileNames));

		jobParametersBuilder.addString(ETLConstants.DA_IN_CORPMAST_FILE_TYP,dataFileNames.get(ETLConstants.DA_IN_CORPMAST_FILE_TYP));
		jobParametersBuilder.addString(ETLConstants.DA_IN_RETMAST_FILE_TYP,dataFileNames.get(ETLConstants.DA_IN_RETMAST_FILE_TYP));
		jobParametersBuilder.addString(ETLConstants.DA_IN_RWMAST_FILE_TYP,dataFileNames.get(ETLConstants.DA_IN_RWMAST_FILE_TYP));

		String[] cntFileDetails = controlFileName.split(ETLConstants.SPLITDELIMITER);
		String country = cntFileDetails[1].toUpperCase();
		String product = cntFileDetails[2].toUpperCase();
		String countryProd = country+ETLConstants.DA_JOBNAME_SEP+product;
		 Double enrInputCksum = Double.valueOf(getInputCksum(dataFileNames.get(ETLConstants.DA_IN_CORPMAST_FILE_TYP), countryProd, fileLocation, "RNBW", "ENR",cntFileDetails[4]));
	       Double enrInputCksum1 = enrInputCksum + Double.valueOf(getInputCksum(dataFileNames.get(ETLConstants.DA_IN_RETMAST_FILE_TYP), countryProd, fileLocation, "RE", "ENR", cntFileDetails[4]));
	       Double enrInputCksum2 = enrInputCksum1 + Double.valueOf(getInputCksum(dataFileNames.get(ETLConstants.DA_IN_RWMAST_FILE_TYP), countryProd, fileLocation, "RW", "ENR", cntFileDetails[4]));
	        
	        jobParametersBuilder.addString(ETLConstants.DA_ENR_INPUT_CKSUM, enrInputCksum2+"");
	        logger.debug("Input checksuem is :"+enrInputCksum2);
	        
	        Double upbInputCksum = Double.valueOf(getInputCksum(dataFileNames.get(ETLConstants.DA_IN_CORPMAST_FILE_TYP), countryProd, fileLocation, "RNBW", "UPB",cntFileDetails[4]));
	        Double upbInputCksum1 = upbInputCksum + Double.valueOf(getInputCksum(dataFileNames.get(ETLConstants.DA_IN_RETMAST_FILE_TYP), countryProd, fileLocation, "RE", "UPB", cntFileDetails[4]));
	        Double upbInputCksum2 = upbInputCksum1 + Double.valueOf(getInputCksum(dataFileNames.get(ETLConstants.DA_IN_RWMAST_FILE_TYP), countryProd, fileLocation, "RW", "UPB", cntFileDetails[4]));
	         
	         jobParametersBuilder.addString(ETLConstants.DA_UPB_INPUT_CKSUM, upbInputCksum2+"");
	         logger.debug("Input checksuem is :"+upbInputCksum2);
		
		jobParametersBuilder.addString(ETLConstants.PRODUCT_CODE,cntFileDetails[2]);
		jobParametersBuilder.addString(ETLConstants.COUNTRY_CODE,cntFileDetails[1]);
		jobParametersBuilder.addString("COUNTRYPRODUCT", cntFileDetails[1]+"-"+cntFileDetails[2]);
		
		jobParametersBuilder.addString(ETLConstants.PRODUCT_CODE_UPPER,cntFileDetails[2].toUpperCase());
		jobParametersBuilder.addString(ETLConstants.COUNTRY_CODE_UPPER,cntFileDetails[1].toUpperCase());
		
		try {
			jobParametersBuilder.addString(ETLConstants.REGION,referenceValueLookup.getRegionByCountry(cntFileDetails[1]));
			jobParametersBuilder.addString("CTLFILECREATIONDT",getFileCreationDate(FilePathDetailsCache.getProcessedFilePath(cntFileDetails[1].toUpperCase()+ETLConstants.DA_JOBNAME_SEP+cntFileDetails[2].toUpperCase())+ controlFileName));
		} catch (OptimaRetailApplicationException e1) {
			logger.error(" Erorr while getting the region for the coutry "+e1);
			throw e1;
		}catch(IOException ne){
			logger.error(" Erorr whilereading control file to get creation date "+ne);
			throw ne;
		}
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			jobParametersBuilder.addDate(ETLConstants.REPORT_DATE,
					simpleDateFormat.parse(cntFileDetails[4]));
			jobParametersBuilder.addString(ETLConstants.CURRENT_DATE,
					simpleDateFormat.format(new Date()));

			jobParametersBuilder.addString(ETLConstants.JOB_STRT_TIME,cntFileDetails[4] + "_" + dateFormat.format(new Date()));

			// Fx-Rate Changes
			jobParametersBuilder.addString(ETLConstants.DA_FXRATE_FILE_TYP,dataFileNames.get(ETLConstants.DA_FXRATE_FILE_TYP).replace(
					ETLConstants.DATADATE_REGEX, cntFileDetails[4]));
		} catch (ParseException e) {
			logger.error(" Erorr while converting month end date "+e);
		}

		jobParametersBuilder.addString(ETLConstants.DATE_OF_INFO,getLastDate(cntFileDetails[4]));
		jobParametersBuilder.addString(ETLConstants.DATE_OF_EXTRACT,cntFileDetails[3]);
		jobParametersBuilder.addString(ETLConstants.VERSION_ID,cntFileDetails[6].substring(0,cntFileDetails[6].indexOf(".")));
		jobParametersBuilder.addString(ETLConstants.DA_CB_FINANCE_FILE_TYP,dataFileNames.get(ETLConstants.DA_CB_FINANCE_FILE_TYP));
		setAuditParams(jobParametersBuilder,controlFileName.substring(0,controlFileName.lastIndexOf("_")));
		return jobParametersBuilder.toJobParameters();

	}

	private static Map<String, String> getCardsDataFileDetails(List<String> dataFileNames) {
		Map<String, String> dataFileDetails = new HashMap<String, String>();

		for (String dataFileName : dataFileNames) {
			if (dataFileName.contains("rnbw")) {
				dataFileDetails.put(ETLConstants.DA_RNBW_FILE, dataFileName);
			} else if (dataFileName.contains("cpmb")) {
				dataFileDetails.put("RNBW", dataFileName);
			} else if (dataFileName.contains("epp")) {
				dataFileDetails.put(ETLConstants.DA_EPP_FILE, dataFileName);
			} else if (dataFileName.contains("wo")) {
				dataFileDetails.put(ETLConstants.DA_WO_FILE, dataFileName);
			} else if (dataFileName.contains("tdr")) {
				dataFileDetails.put(ETLConstants.DA_TDR_FILE, dataFileName);
			} else if (dataFileName.contains("rec")) {
				dataFileDetails.put(ETLConstants.DA_REC_FILE, dataFileName);
			} else if (dataFileName.contains("ntb")) {
				dataFileDetails.put(ETLConstants.DA_NTB_FILE, dataFileName);
			} else if (dataFileName.contains("fico")) {
				dataFileDetails.put(ETLConstants.DA_FICO_FILE, dataFileName);
			}else if (dataFileName.contains(ETLConstants.DA_FXRATE_FILE_TYP)) {
				dataFileDetails.put(ETLConstants.DA_FXRATE_FILE_TYP, dataFileName);
			}else if (dataFileName.contains(ETLConstants.DA_CB_FINANCE_FILE_TYP)) {
				dataFileDetails.put(ETLConstants.DA_CB_FINANCE_FILE_TYP, dataFileName);
			} else if(dataFileName.contains("booc")){
				dataFileDetails.put(ETLConstants.DA_BOOC_FILE, dataFileName);
			}
		}
		return dataFileDetails;
	}

	private static Map<String, String> getHkRcDataFileDetails(List<String> dataFileNames) {
		Map<String, String> dataFileDetails = new HashMap<String, String>();

		for (String dataFileName : dataFileNames) {
			if (dataFileName.contains(ETLConstants.DA_RNBW_FILE_STR)) {
				dataFileDetails.put(ETLConstants.DA_RNBW_FILE, dataFileName);
			} else if (dataFileName.contains(ETLConstants.DA_WO_FILE_STR)) {
				dataFileDetails.put(ETLConstants.DA_WO_FILE, dataFileName);
			} else if (dataFileName.contains(ETLConstants.DA_REC_FILE_STR)) {
				dataFileDetails.put(ETLConstants.DA_REC_FILE, dataFileName);
			} else if (dataFileName.contains(ETLConstants.DA_FICO_FILE_STR)) {
				dataFileDetails.put(ETLConstants.DA_FICO_FILE, dataFileName);
			}else if (dataFileName.contains(ETLConstants.DA_NEWCOMMITMENT_STR)) {
				dataFileDetails.put(ETLConstants.DA_NEWCOMMITMENT, dataFileName);
			}else if (dataFileName.contains(ETLConstants.DA_DELQ_STR)) {
				dataFileDetails.put(ETLConstants.DA_DELQ, dataFileName);
			}else if (dataFileName.contains(ETLConstants.DA_CRD_TRANS_STR)) {
				dataFileDetails.put(ETLConstants.DA_CRD_TRANS, dataFileName);
			}else if (dataFileName.contains(ETLConstants.DA_FXRATE_FILE_TYP)) {
				dataFileDetails.put(ETLConstants.DA_FXRATE_FILE_TYP, dataFileName);
			}else if (dataFileName.contains(ETLConstants.DA_CB_FINANCE_FILE_TYP)) {
				dataFileDetails.put(ETLConstants.DA_CB_FINANCE_FILE_TYP, dataFileName);
			}
		}
		return dataFileDetails;
	}

	private static Map<String, String> getHkCardsDataFileDetails(List<String> dataFileNames) {
		Map<String, String> dataFileDetails = new HashMap<String, String>();

		for (String dataFileName : dataFileNames) {
			if (dataFileName.contains(ETLConstants.DA_RNBW_DC_FILE_STR)) {
				dataFileDetails.put(ETLConstants.DA_RNBW_DC_FILE, dataFileName);
			} else if (dataFileName.contains(ETLConstants.DA_RNBW_BC_FILE_STR)) {
				dataFileDetails.put(ETLConstants.DA_RNBW_BC_FILE, dataFileName);
			} else if (dataFileName.contains(ETLConstants.DA_WO_FILE_STR) && dataFileName.contains(ETLConstants.DA_WO_BC_FILE_STR)) {
				dataFileDetails.put(ETLConstants.DA_WO_BC_FILE, dataFileName);
			} else if (dataFileName.contains(ETLConstants.DA_WO_FILE_STR) && dataFileName.contains(ETLConstants.DA_WO_DC_FILE_STR)) {
				dataFileDetails.put(ETLConstants.DA_WO_DC_FILE, dataFileName);
			} else if (dataFileName.contains(ETLConstants.DA_REC_FILE_STR)) {
				dataFileDetails.put(ETLConstants.DA_REC_FILE, dataFileName);
			} else if (dataFileName.contains(ETLConstants.DA_FICO_DC_FILE_STR)) {
				dataFileDetails.put(ETLConstants.DA_FICO_DC_FILE, dataFileName);
			} else if (dataFileName.contains(ETLConstants.DA_FICO_BC_FILE_STR)) {
				dataFileDetails.put(ETLConstants.DA_FICO_BC_FILE ,dataFileName);
			} else if (dataFileName.contains(ETLConstants.DA_DELQ_BC_FILE_STR)) {
				dataFileDetails.put(ETLConstants.DA_DELQ_BC_FILE, dataFileName);
				/*	} else if (dataFileName.contains(ETLConstants.DA_WO_REC_FILE)) {
					dataFileDetails.put(ETLConstants.DA_WO_REC_FILE, dataFileName);*/
			} else if (dataFileName.contains(ETLConstants.DA_DELQ_DC_FILE_STR)) {
				dataFileDetails.put(ETLConstants.DA_DELQ_DC_FILE, dataFileName);
			} else if (dataFileName.contains(ETLConstants.DA_NEW_DC_FILE_STR)) {
				dataFileDetails.put(ETLConstants.DA_NEW_DC_FILE, dataFileName);
			} else if (dataFileName.contains(ETLConstants.DA_NEW_BC_FILE_STR)) {
				dataFileDetails.put(ETLConstants.DA_NEW_BC_FILE, dataFileName);
			} else if (dataFileName.contains(ETLConstants.DA_CRD_TRANS_FILE_STR)) {
				dataFileDetails.put(ETLConstants.DA_CRD_TRANS_FILE, dataFileName);
			}else if (dataFileName.contains(ETLConstants.DA_FXRATE_FILE_TYP)) {
				dataFileDetails.put(ETLConstants.DA_FXRATE_FILE_TYP, dataFileName);
			}else if (dataFileName.contains(ETLConstants.DA_CB_FINANCE_FILE_TYP)) {
				dataFileDetails.put(ETLConstants.DA_CB_FINANCE_FILE_TYP, dataFileName);
			}
		}
		return dataFileDetails;
	}

	private static Map<String, String> getInCardsDataFileDetails(List<String> dataFileNames) {
		Map<String, String> dataFileDetails = new HashMap<String, String>();

		for (String dataFileName : dataFileNames) {
			if (dataFileName.contains(ETLConstants.DA_IN_CRD_FILE_STR)) {
				dataFileDetails.put(ETLConstants.DA_IN_CRD_FILE, dataFileName);
			}else if (dataFileName.contains(ETLConstants.DA_FXRATE_FILE_TYP)) {
				dataFileDetails.put(ETLConstants.DA_FXRATE_FILE_TYP, dataFileName);
			}else if (dataFileName.contains(ETLConstants.DA_CB_FINANCE_FILE_TYP)) {
				dataFileDetails.put(ETLConstants.DA_CB_FINANCE_FILE_TYP, dataFileName);
			}

		}
		return dataFileDetails;
	}

	private static Map<String, String> getInPLDataFileDetails(List<String> dataFileNames) {
		Map<String, String> dataFileDetails = new HashMap<String, String>();


		for (String dataFileName : dataFileNames) {
			if (dataFileName.contains(ETLConstants.DA_IN_PL_FILE_STR)) {
				dataFileDetails.put(ETLConstants.DA_IN_PL_FILE, dataFileName);
			} else if (dataFileName.contains(ETLConstants.DA_FXRATE_FILE_TYP)) {
				dataFileDetails.put(ETLConstants.DA_FXRATE_FILE_TYP, dataFileName);
			}else if (dataFileName.contains(ETLConstants.DA_CB_FINANCE_FILE_TYP)) {
				dataFileDetails.put(ETLConstants.DA_CB_FINANCE_FILE_TYP, dataFileName);
			}

		}
		return dataFileDetails;
	}

	private static Map<String, String> getMortgageDataFileDetails(List<String> dataFileNames) {
		Map<String, String> dataFileDetails = new HashMap<String, String>();

		for (String dataFileName : dataFileNames) {
			if (dataFileName.contains(ETLConstants.DA_OREO_FILE)) {
				dataFileDetails.put("OREO", dataFileName);
			} else if (dataFileName.contains(ETLConstants.DA_BAUIMP_FILE)) {
				dataFileDetails.put("BAUIMP", dataFileName);
			} else if (dataFileName.contains(ETLConstants.DA_FICO_FILE_MTG)) {
				dataFileDetails.put("FICO", dataFileName);
			} else if (dataFileName.contains(ETLConstants.DA_FIP_FILE)) {
				dataFileDetails.put("FIP", dataFileName);
			} else if (dataFileName.contains(ETLConstants.DA_MEMO_FILE)) {
				dataFileDetails.put("MEMO", dataFileName);
			} else if (dataFileName.contains(ETLConstants.DA_MUTCOL_FILE)) {
				dataFileDetails.put("MUTCOL", dataFileName);
			} else if (dataFileName.contains(ETLConstants.DA_TDR_FILE_MTG)) {
				dataFileDetails.put("TDR", dataFileName);
			} else if (dataFileName.contains(ETLConstants.DA_TEASER_FILE)) {
				dataFileDetails.put("TEASER", dataFileName);
			}else if (dataFileName.contains(ETLConstants.DA_ALS_FILE)) {
				dataFileDetails.put("ALS", dataFileName);
				dataFileDetails.put("LOANS", dataFileName);
				/*}else if (dataFileName.contains(ETLConstants.DA_LOANS_FILE)) {
					dataFileDetails.put("LOANS", dataFileName);*/
			}else if (dataFileName.contains(ETLConstants.DA_FXRATE_FILE_TYP)) {
				dataFileDetails.put(ETLConstants.DA_FXRATE_FILE_TYP, dataFileName);
			}else if (dataFileName.contains(ETLConstants.DA_CB_FINANCE_FILE_TYP)) {
				dataFileDetails.put(ETLConstants.DA_CB_FINANCE_FILE_TYP, dataFileName);
			}

		}
		return dataFileDetails;
	}

	private static Map<String, String> getInReadyCreditDataFileDetails(List<String> dataFileNames) {
		Map<String, String> dataFileDetails = new HashMap<String, String>();

		for (String dataFileName : dataFileNames) {
			if (dataFileName.contains(ETLConstants.DA_IN_CORPMAST_FILE_TYP_STR)) {
				dataFileDetails.put(ETLConstants.DA_IN_CORPMAST_FILE_TYP, dataFileName);
			} else if (dataFileName.contains(ETLConstants.DA_IN_RETMAST_FILE_TYP_STR)) {
				dataFileDetails.put(ETLConstants.DA_IN_RETMAST_FILE_TYP, dataFileName);
			} else if (dataFileName.contains(ETLConstants.DA_IN_RWMAST_FILE_TYP_STR)) {
				dataFileDetails.put(ETLConstants.DA_IN_RWMAST_FILE_TYP, dataFileName);
			} else if (dataFileName.contains(ETLConstants.DA_FXRATE_FILE_TYP)) {
				dataFileDetails.put(ETLConstants.DA_FXRATE_FILE_TYP, dataFileName);
			} else if (dataFileName.contains(ETLConstants.DA_CB_FINANCE_FILE_TYP)) {
				dataFileDetails.put(ETLConstants.DA_CB_FINANCE_FILE_TYP, dataFileName);
			}
		}
		return dataFileDetails;
	}

	private static Map<String, String> getInMortgageDataFileDetails(List<String> dataFileNames) {
		Map<String, String> dataFileDetails = new HashMap<String, String>();


		for (String dataFileName : dataFileNames) {
			if (dataFileName.contains(ETLConstants.DA_OREO_FILE_STR)) {
				dataFileDetails.put(ETLConstants.DA_OREO_FILE_STR, dataFileName);
			} else if (dataFileName.contains(ETLConstants.DA_IN_MTG_GCBC_FILE_STR)) {
				dataFileDetails.put(ETLConstants.DA_IN_MTG_GCBC_FILE, dataFileName);
			} else if (dataFileName.contains(ETLConstants.DA_IN_MTG_GCL_FILE_STR)) {
				dataFileDetails.put(ETLConstants.DA_IN_MTG_GCL_FILE, dataFileName);
			} else if (dataFileName.contains(ETLConstants.DA_FXRATE_FILE_TYP)) {
				dataFileDetails.put(ETLConstants.DA_FXRATE_FILE_TYP, dataFileName);
			}/*else if (dataFileName.contains(ETLConstants.DA_IN_MTG_STFMTG_FILE)) {
					dataFileDetails.put(ETLConstants.DA_IN_MTG_STFMTG_FILE, dataFileName);} */
			else if (dataFileName.contains(ETLConstants.DA_CB_FINANCE_FILE_TYP)) {
				dataFileDetails.put(ETLConstants.DA_CB_FINANCE_FILE_TYP, dataFileName);
			}

		}
		return dataFileDetails;
	}

	private static JobParameters populateHkMtgJobParameters(
			final BatchDetailsVO jobDetailsVo,
			final OptimaRetailETLEvent optimaRetailEvent,List<String> fileList,String controlFileName,String fileLocation,ReferenceValueLookup referenceValueLookup) throws OptimaRetailApplicationException, IOException {

		JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();

		jobParametersBuilder.addString("REQUEST_ID",
				"ORETL-" + System.currentTimeMillis());
		jobParametersBuilder.addDate(ETLConstants.REPORT_DATE,
				new Date());

		jobParametersBuilder.addLong(ETLConstants.BATCH_ID, new Long(
				jobDetailsVo.getBatchId()));
		jobParametersBuilder.addLong(ETLConstants.SYS_PROC_ID, new Long(jobDetailsVo.getSysProcId()));
		jobParametersBuilder.addLong(ETLConstants.BATCH_INSTANCE_ID, new Long(
				jobDetailsVo.getBatchInstanceId()));
		jobParametersBuilder.addLong(ETLConstants.ORIGINAL_MSG_ID, new Long(
				jobDetailsVo.getOriginalMessageId()));

		jobParametersBuilder.addString(ETLConstants.JOB_NAME, jobDetailsVo.getBatchName());

		jobParametersBuilder.addString(ETLConstants.FILE_PATH,fileLocation);
		jobParametersBuilder.addString(ETLConstants.DA_CONTROL_FILE_NAME,controlFileName.substring(0,controlFileName.lastIndexOf("_")));
		jobParametersBuilder.addString(ETLConstants.DA_INPUT_COUNT, DataAcquisitionHandler.inMtgCount);
		//Populate all the parameters for manual files here.

		Map<String,String> dataFileNames = getHkMortgageDataFileDetails(fileList);
		jobParametersBuilder.addString(ETLConstants.DATA_FILE_LIST,getDataFilenameList(dataFileNames));
		
		jobParametersBuilder.addString(ETLConstants.DA_HK_MTG_HKSi009_RAW_FILE,dataFileNames.get(ETLConstants.DA_HK_MTG_HKSi009_RAW_FILE));
		jobParametersBuilder.addString(ETLConstants.DA_HK_MTG_HKSi011_RAW_FILE,dataFileNames.get(ETLConstants.DA_HK_MTG_HKSi011_RAW_FILE));
		jobParametersBuilder.addString(ETLConstants.DA_HK_MTG_HKSi012_RAW_FILE,dataFileNames.get(ETLConstants.DA_HK_MTG_HKSi012_RAW_FILE));
		jobParametersBuilder.addString(ETLConstants.DA_HK_MTG_HKSi013_RAW_FILE,dataFileNames.get(ETLConstants.DA_HK_MTG_HKSi013_RAW_FILE));
		jobParametersBuilder.addString(ETLConstants.DA_HK_MTG_HKSi016_RAW_FILE,dataFileNames.get(ETLConstants.DA_HK_MTG_HKSi016_RAW_FILE));
		//jobParametersBuilder.addString(ETLConstants.DA_HK_MTG_RNBW_FILE,dataFileNames.get(ETLConstants.DA_HK_MTG_RNBW_FILE));
		jobParametersBuilder.addString(ETLConstants.DA_HK_MTG_RECOVERY_MANUAL_FILE,dataFileNames.get(ETLConstants.DA_HK_MTG_RECOVERY_MANUAL_FILE));
		jobParametersBuilder.addString(ETLConstants.DA_HK_MTG_FORCLS_FILE,dataFileNames.get(ETLConstants.DA_HK_MTG_FORCLS_FILE));
		jobParametersBuilder.addString(ETLConstants.DA_HK_MTG_WRITE_OFF_FILE,dataFileNames.get(ETLConstants.DA_HK_MTG_WRITE_OFF_FILE));
		jobParametersBuilder.addString(ETLConstants.DA_HK_MTG_REWRITE_ACCT_FILE,dataFileNames.get(ETLConstants.DA_HK_MTG_REWRITE_ACCT_FILE));

		
		String[] cntFileDetails = controlFileName.split(ETLConstants.SPLITDELIMITER);
		String country = cntFileDetails[1].toUpperCase();
		String product = cntFileDetails[2].toUpperCase();
		String countryProd = country+ETLConstants.DA_JOBNAME_SEP+product;
		Double enrInputCksum1 = Double.valueOf(getInputCksum(dataFileNames.get(ETLConstants.DA_HK_MTG_HKSi009_RAW_FILE), countryProd, fileLocation, "RNBW", "ENR", cntFileDetails[4]));
		Double enrInputCksum2 = enrInputCksum1 + Double.valueOf(getInputCksum(dataFileNames.get(ETLConstants.DA_HK_MTG_HKSi011_RAW_FILE),countryProd, fileLocation, "hksi011","ENR",  cntFileDetails[4]));
		Double enrInputCksum3 = enrInputCksum2 + Double.valueOf(getInputCksum(dataFileNames.get(ETLConstants.DA_HK_MTG_HKSi012_RAW_FILE), countryProd, fileLocation, "hksi012","ENR",  cntFileDetails[4]));
		Double enrInputCksum4 = enrInputCksum3 + Double.valueOf(getInputCksum(dataFileNames.get(ETLConstants.DA_HK_MTG_HKSi013_RAW_FILE), countryProd, fileLocation, "hksi013","ENR",  cntFileDetails[4]));
		Double enrIinputCksum5 = enrInputCksum4 + Double.valueOf(getInputCksum(dataFileNames.get(ETLConstants.DA_HK_MTG_HKSi016_RAW_FILE), countryProd, fileLocation, "hksi016","ENR",  cntFileDetails[4]));
		jobParametersBuilder.addString(ETLConstants.DA_ENR_INPUT_CKSUM, enrIinputCksum5.toString());
		
		Double upbInputCksum1 = Double.valueOf(getInputCksum(dataFileNames.get(ETLConstants.DA_HK_MTG_HKSi009_RAW_FILE), countryProd, fileLocation, "RNBW", "UPB", cntFileDetails[4]));
		Double upbInputCksum2 = upbInputCksum1 + Double.valueOf(getInputCksum(dataFileNames.get(ETLConstants.DA_HK_MTG_HKSi011_RAW_FILE), countryProd, fileLocation, "hksi011","UPB",  cntFileDetails[4]));
		Double upbInputCksum3 = upbInputCksum2 + Double.valueOf(getInputCksum(dataFileNames.get(ETLConstants.DA_HK_MTG_HKSi012_RAW_FILE), countryProd, fileLocation, "hksi012","UPB", cntFileDetails[4]));
		Double upbInputCksum4 = upbInputCksum3 + Double.valueOf(getInputCksum(dataFileNames.get(ETLConstants.DA_HK_MTG_HKSi013_RAW_FILE), countryProd, fileLocation, "hksi013","UPB",  cntFileDetails[4]));
		Double upbIinputCksum5 = upbInputCksum4 + Double.valueOf(getInputCksum(dataFileNames.get(ETLConstants.DA_HK_MTG_HKSi016_RAW_FILE), countryProd, fileLocation, "hksi016","UPB",  cntFileDetails[4]));
		jobParametersBuilder.addString(ETLConstants.DA_UPB_INPUT_CKSUM, upbIinputCksum5.toString());
		
		
		jobParametersBuilder.addString(ETLConstants.PRODUCT_CODE,cntFileDetails[2]);
		jobParametersBuilder.addString(ETLConstants.COUNTRY_CODE,cntFileDetails[1]);
		jobParametersBuilder.addString("COUNTRYPRODUCT", cntFileDetails[1]+"-"+cntFileDetails[2]);
		
		jobParametersBuilder.addString(ETLConstants.PRODUCT_CODE_UPPER,cntFileDetails[2].toUpperCase());
		jobParametersBuilder.addString(ETLConstants.COUNTRY_CODE_UPPER,cntFileDetails[1].toUpperCase());
		
		try {
			jobParametersBuilder.addString(ETLConstants.REGION,referenceValueLookup.getRegionByCountry(cntFileDetails[1]));
			jobParametersBuilder.addString("CTLFILECREATIONDT",getFileCreationDate(FilePathDetailsCache.getProcessedFilePath(cntFileDetails[1].toUpperCase()+ETLConstants.DA_JOBNAME_SEP+cntFileDetails[2].toUpperCase())+ controlFileName));
		} catch (OptimaRetailApplicationException e1) {
			logger.error(" Erorr while getting the region for the coutry "+e1);
			throw e1;
		}catch(IOException ne){
			logger.error(" Erorr whilereading control file to get creation date "+ne);
			throw ne;
		}
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			jobParametersBuilder.addDate(ETLConstants.REPORT_DATE,
					simpleDateFormat.parse(cntFileDetails[4]));
			jobParametersBuilder.addString(ETLConstants.CURRENT_DATE,
					simpleDateFormat.format(new Date()));

			jobParametersBuilder.addString(ETLConstants.JOB_STRT_TIME,cntFileDetails[4] + "_" + dateFormat.format(new Date()));
			jobParametersBuilder.addString(ETLConstants.DA_FXRATE_FILE_TYP,dataFileNames.get(ETLConstants.DA_FXRATE_FILE_TYP).replace(
					ETLConstants.DATADATE_REGEX, cntFileDetails[4]));
		} catch (ParseException e) {
			logger.error(" Erorr while converting month end date "+e);
		}

		jobParametersBuilder.addString(ETLConstants.DATE_OF_INFO,getLastDate(cntFileDetails[4]));
		jobParametersBuilder.addString(ETLConstants.DATE_OF_EXTRACT,cntFileDetails[3]);
		jobParametersBuilder.addString(ETLConstants.VERSION_ID,cntFileDetails[6].substring(0,cntFileDetails[6].indexOf(".")));
		jobParametersBuilder.addString(ETLConstants.DA_CB_FINANCE_FILE_TYP,dataFileNames.get(ETLConstants.DA_CB_FINANCE_FILE_TYP));
		setAuditParams(jobParametersBuilder,controlFileName.substring(0,controlFileName.lastIndexOf("_")));
		return jobParametersBuilder.toJobParameters();
	}

	private static Map<String, String> getHkMortgageDataFileDetails(List<String> dataFileNames) {
		Map<String, String> dataFileDetails = new HashMap<String, String>();


		for (String dataFileName : dataFileNames) {
//			if (dataFileName.contains(ETLConstants.DA_HK_MTG_RNBW_FILE_STR)) {
//				dataFileDetails.put(ETLConstants.DA_HK_MTG_RNBW_FILE,dataFileName);
//			}else 
			if (dataFileName.contains(ETLConstants.DA_HK_MTG_HKSi009_RAW_FILE )) {
				dataFileDetails.put(ETLConstants.DA_HK_MTG_HKSi009_RAW_FILE ,dataFileName);
			}else if (dataFileName.contains(ETLConstants.DA_HK_MTG_HKSi011_RAW_FILE )) {
				dataFileDetails.put(ETLConstants.DA_HK_MTG_HKSi011_RAW_FILE ,dataFileName);
			}else if (dataFileName.contains(ETLConstants.DA_HK_MTG_HKSi012_RAW_FILE )) {
				dataFileDetails.put(ETLConstants.DA_HK_MTG_HKSi012_RAW_FILE ,dataFileName);
			}else if (dataFileName.contains(ETLConstants.DA_HK_MTG_HKSi013_RAW_FILE )) {
				dataFileDetails.put(ETLConstants.DA_HK_MTG_HKSi013_RAW_FILE ,dataFileName);
			}else if (dataFileName.contains(ETLConstants.DA_HK_MTG_HKSi016_RAW_FILE )) {
				dataFileDetails.put(ETLConstants.DA_HK_MTG_HKSi016_RAW_FILE ,dataFileName);
			}else if (dataFileName.contains(ETLConstants.DA_HK_MTG_RECOVERY_MANUAL_FILE_STR)) {
				dataFileDetails.put(ETLConstants.DA_HK_MTG_RECOVERY_MANUAL_FILE,dataFileName);
			} else if (dataFileName.contains(ETLConstants.DA_HK_MTG_FORCLS_FILE_STR)) {
				dataFileDetails.put(ETLConstants.DA_HK_MTG_FORCLS_FILE, dataFileName);
			} else if (dataFileName.contains(ETLConstants.DA_HK_MTG_WRITE_OFF_FILE_STR)) {
				dataFileDetails.put(ETLConstants.DA_HK_MTG_WRITE_OFF_FILE, dataFileName);
			} else if (dataFileName.contains(ETLConstants.DA_HK_MTG_REWRITE_ACCT_FILE_STR)) {
				dataFileDetails.put(ETLConstants.DA_HK_MTG_REWRITE_ACCT_FILE, dataFileName);
			}/*else if (dataFileName.contains(ETLConstants.DA_IN_MTG_STFMTG_FILE)) {
					dataFileDetails.put(ETLConstants.DA_IN_MTG_STFMTG_FILE,dataFileName);} */
			else if (dataFileName.contains(ETLConstants.DA_CB_FINANCE_FILE_TYP)) {
				dataFileDetails.put(ETLConstants.DA_CB_FINANCE_FILE_TYP,dataFileName);
			}else if (dataFileName.contains(ETLConstants.DA_FXRATE_FILE_TYP)) {
				dataFileDetails.put(ETLConstants.DA_FXRATE_FILE_TYP,dataFileName);
			}

		}
		return dataFileDetails;
	}

	private static Map<String, String> getHKPLDataFileDetails(List<String> dataFileNames) {
		Map<String, String> dataFileDetails = new HashMap<String, String>();


		for (String dataFileName : dataFileNames) {
			if (dataFileName.contains(ETLConstants.DA_HK_PL_RNBW_FILE_STR)) {
				dataFileDetails.put(ETLConstants.DA_RNBW_FILE, dataFileName);
			} else if (dataFileName.contains(ETLConstants.DA_FICO_FILE_STR)) {
				dataFileDetails.put(ETLConstants.DA_FICO_FILE, dataFileName);
			} else if (dataFileName.contains(ETLConstants.DA_WO_FILE_STR)) {
				dataFileDetails.put(ETLConstants.DA_WO_FILE, dataFileName);
			} else if (dataFileName.contains(ETLConstants.DA_FXRATE_FILE_TYP)) {
				dataFileDetails.put(ETLConstants.DA_FXRATE_FILE_TYP, dataFileName);
			}else if (dataFileName.contains(ETLConstants.DA_REC_FILE_STR)) {
				dataFileDetails.put(ETLConstants.DA_REC_FILE, dataFileName);
			} else if (dataFileName.contains(ETLConstants.DA_CB_FINANCE_FILE_TYP)) {
				dataFileDetails.put(ETLConstants.DA_CB_FINANCE_FILE_TYP, dataFileName);
			}
		}
		return dataFileDetails;
	}

	private static JobParameters populateTwRcJobParameters(final BatchDetailsVO jobDetailsVo,
			final OptimaRetailETLEvent optimaRetailEvent,List<String> fileList,String controlFileName,String fileLocation,ReferenceValueLookup referenceValueLookup) throws OptimaRetailApplicationException, IOException{


		JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();


		jobParametersBuilder.addString("REQUEST_ID","ORETL-" + System.currentTimeMillis());
		jobParametersBuilder.addDate(ETLConstants.REPORT_DATE,new Date());

		jobParametersBuilder.addLong(ETLConstants.BATCH_ID, new Long(jobDetailsVo.getBatchId()));
		jobParametersBuilder.addLong(ETLConstants.SYS_PROC_ID, new Long(jobDetailsVo.getSysProcId()));
		jobParametersBuilder.addLong(ETLConstants.BATCH_INSTANCE_ID, new Long(jobDetailsVo.getBatchInstanceId()));
		jobParametersBuilder.addLong(ETLConstants.ORIGINAL_MSG_ID, new Long(jobDetailsVo.getOriginalMessageId()));

		jobParametersBuilder.addString(ETLConstants.JOB_NAME, jobDetailsVo.getBatchName());

		jobParametersBuilder.addString(ETLConstants.FILE_PATH,fileLocation);
		jobParametersBuilder.addString(ETLConstants.DA_CONTROL_FILE_NAME,controlFileName.substring(0,controlFileName.lastIndexOf("_")));
		Map<String,String> dataFileNames = getTwRcDataFileDetails(fileList);
		jobParametersBuilder.addString(ETLConstants.DATA_FILE_LIST,getDataFilenameList(dataFileNames));
		
		jobParametersBuilder.addString(ETLConstants.DA_RNBW_FILE,dataFileNames.get(ETLConstants.DA_RNBW_FILE));			
		jobParametersBuilder.addString(ETLConstants.DA_FICO_FILE,dataFileNames.get(ETLConstants.DA_FICO_FILE));			
		jobParametersBuilder.addString(ETLConstants.DA_EPP_FILE,dataFileNames.get(ETLConstants.DA_EPP_FILE));			
		jobParametersBuilder.addString(ETLConstants.DA_WO_FILE,dataFileNames.get(ETLConstants.DA_WO_FILE));
		jobParametersBuilder.addString(ETLConstants.DA_NTB_FILE,dataFileNames.get(ETLConstants.DA_NTB_FILE));			
		jobParametersBuilder.addString(ETLConstants.DA_REC_FILE,dataFileNames.get(ETLConstants.DA_REC_FILE));			
		jobParametersBuilder.addString(ETLConstants.DA_TDR_FILE,dataFileNames.get(ETLConstants.DA_TDR_FILE));
		jobParametersBuilder.addString(ETLConstants.DA_INT_FILE,dataFileNames.get(ETLConstants.DA_INT_FILE));	
		jobParametersBuilder.addString(ETLConstants.DA_BOOC_FILE,dataFileNames.get(ETLConstants.DA_BOOC_FILE));

		String[] cntFileDetails = controlFileName.split(ETLConstants.SPLITDELIMITER);
		String country = cntFileDetails[1].toUpperCase();
		String product = cntFileDetails[2].toUpperCase();
		String countryProd = country+ETLConstants.DA_JOBNAME_SEP+product;
		jobParametersBuilder.addString(ETLConstants.DA_UPB_INPUT_CKSUM, getInputCksum(dataFileNames.get(ETLConstants.DA_RNBW_FILE), countryProd, fileLocation, "RNBW", "UPB",cntFileDetails[4]));
		
		jobParametersBuilder.addString(ETLConstants.PRODUCT_CODE,cntFileDetails[2]);
		//jobParametersBuilder.addString(ETLConstants.PRODUCT_CODE+"2",cntFileDetails[1]);
		jobParametersBuilder.addString(ETLConstants.COUNTRY_CODE,cntFileDetails[1]);
		jobParametersBuilder.addString("COUNTRYPRODUCT", cntFileDetails[1]+"-"+cntFileDetails[2]);
		
		jobParametersBuilder.addString(ETLConstants.PRODUCT_CODE_UPPER,cntFileDetails[2].toUpperCase());
		jobParametersBuilder.addString(ETLConstants.COUNTRY_CODE_UPPER,cntFileDetails[1].toUpperCase());

		try {
			jobParametersBuilder.addString(ETLConstants.REGION,referenceValueLookup.getRegionByCountry(cntFileDetails[1]));
			jobParametersBuilder.addString("CTLFILECREATIONDT",getFileCreationDate(FilePathDetailsCache.getProcessedFilePath(cntFileDetails[1].toUpperCase()+ETLConstants.DA_JOBNAME_SEP+cntFileDetails[2].toUpperCase())+ controlFileName));
		} catch (OptimaRetailApplicationException e1) {
			logger.error(" Erorr while getting the region for the coutry "+e1);
			throw e1;
		}catch(IOException ne){
			logger.error(" Erorr whilereading control file to get creation date "+ne);
			throw ne;
		}
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			jobParametersBuilder.addDate(ETLConstants.REPORT_DATE,
					simpleDateFormat.parse(cntFileDetails[4]));
			jobParametersBuilder.addString(ETLConstants.CURRENT_DATE,
					simpleDateFormat.format(new Date()));

			jobParametersBuilder.addString(ETLConstants.JOB_STRT_TIME,cntFileDetails[4] + "_" + dateFormat.format(new Date()));

			// Fx-Rate Changes
			jobParametersBuilder.addString(ETLConstants.DA_FXRATE_FILE_TYP,dataFileNames.get(ETLConstants.DA_FXRATE_FILE_TYP).replace(
					ETLConstants.DATADATE_REGEX, cntFileDetails[4]));
		} catch (ParseException e) {
			logger.error(" Erorr while converting month end date "+e);
		}

		jobParametersBuilder.addString(ETLConstants.DATE_OF_INFO,getLastDate(cntFileDetails[4]));
		jobParametersBuilder.addString(ETLConstants.DATE_OF_EXTRACT,cntFileDetails[3]);
		jobParametersBuilder.addString(ETLConstants.VERSION_ID,cntFileDetails[6].substring(0,cntFileDetails[6].indexOf(".")));
		jobParametersBuilder.addString(ETLConstants.DA_CB_FINANCE_FILE_TYP,dataFileNames.get(ETLConstants.DA_CB_FINANCE_FILE_TYP));
		setAuditParams(jobParametersBuilder,controlFileName.substring(0,controlFileName.lastIndexOf("_")));
		return jobParametersBuilder.toJobParameters();
	}

	private static Map<String, String> getTwRcDataFileDetails(List<String> dataFileNames) {
		Map<String, String> dataFileDetails = new HashMap<String, String>();		

		for (String dataFileName : dataFileNames) {
			if (dataFileName.contains("rnbw")) {
				dataFileDetails.put(ETLConstants.DA_RNBW_FILE, dataFileName);
			}else if (dataFileName.contains("cpmb")) {
				dataFileDetails.put(ETLConstants.DA_RNBW_FILE, dataFileName);
			}else if (dataFileName.contains("fico")) {
				dataFileDetails.put(ETLConstants.DA_FICO_FILE, dataFileName);
			} else if (dataFileName.contains("wo")) {
				dataFileDetails.put(ETLConstants.DA_WO_FILE, dataFileName);
			} else if (dataFileName.contains("ntb")) {
				dataFileDetails.put(ETLConstants.DA_NTB_FILE, dataFileName);
			} else if (dataFileName.contains("rec")) {
				dataFileDetails.put(ETLConstants.DA_REC_FILE, dataFileName);
			}else if (dataFileName.contains("tdr")) {
				dataFileDetails.put(ETLConstants.DA_TDR_FILE,dataFileName);
			}else if (dataFileName.contains("int")) {
				dataFileDetails.put(ETLConstants.DA_INT_FILE, dataFileName);
			}else if (dataFileName.contains("epp")) {
				dataFileDetails.put(ETLConstants.DA_EPP_FILE, dataFileName);
			}else if (dataFileName.contains(ETLConstants.DA_FXRATE_FILE_TYP)) {
				dataFileDetails.put(ETLConstants.DA_FXRATE_FILE_TYP, dataFileName);
			}else if (dataFileName.contains(ETLConstants.DA_CB_FINANCE_FILE_TYP)) {
				dataFileDetails.put(ETLConstants.DA_CB_FINANCE_FILE_TYP, dataFileName);
			}else if(dataFileName.contains("booc")){
				dataFileDetails.put(ETLConstants.DA_BOOC_FILE, dataFileName);
			}
		}
		return dataFileDetails;
	}

	public static String getLastDate(String rptMonth){
		String date = null;
		String input = rptMonth.toString();
		String year = rptMonth.substring(0,4);
		String month = input.substring(4,6);
		int Curmonth = Integer.parseInt(month);
		int CurYear = Integer.parseInt(year);

		Calendar calendar = new GregorianCalendar();
		calendar.set(Calendar.YEAR, CurYear);
		calendar.set(Calendar.MONTH, Curmonth-1);
		calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DATE));
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		try{
			date = dateFormat.format(calendar.getTime());
		} catch(Exception e){
			logger.error("Exception occured while parsing the date" + rptMonth + e);
		}
		return date;
	}	
	
	private static void setAuditParams(JobParametersBuilder jobParametersBuilder, String controlFileName){
		
		jobParametersBuilder.addLong("AUDITFILEID",queryExec.getControlFIleIdByName(controlFileName));
		
	}
	
	private static  String getInputCksum(String fileName, String cntProdCd, String filePath, String fileTyp, String checkSumFieldName, String reportingDate)
	{
		CheckSumDetailsVO checkSumDetailsVO = new CheckSumDetailsVO();
		String count = ETLConstants.EMPTY_STR;
		checkSumDetailsVO = queryExec.getInputCheckSumDetailsMap(cntProdCd, fileTyp, checkSumFieldName, reportingDate);
		
		if(!(OS.indexOf(ETLConstants.WIN_OS) >= 0)){
			Process p;
			try {
				if(checkSumDetailsVO != null){
					String mergeCommand = null;
					if(cntProdCd.equalsIgnoreCase("IN-MTG") && checkSumFieldName.equalsIgnoreCase(ETLConstants.ENR_CKSUM_FIELDNAME)){
						mergeCommand = "./InputCksum.sh "  +  filePath+fileName 
								+ ETLConstants.SPACE_STR + checkSumDetailsVO.getInputFieldPos() + ETLConstants.SPACE_STR + cntProdCd.toUpperCase();
					} else{
						mergeCommand = "./InputCksum.sh "  +  filePath+fileName 
								+ ETLConstants.SPACE_STR + checkSumDetailsVO.getInputFieldPos();
					}
					
					logger.info(" Input checksum command "+mergeCommand);
					p = Runtime.getRuntime().exec(mergeCommand);
					p.waitFor();
					BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
					count = reader.readLine();
					logger.info(" Input checksum command is Successfull");
				}
				
			} catch (InterruptedException e) {
				logger.error("ERROR while geting input check sum"+e);
			} catch (IOException e) {
				logger.error("ERROR while geting input check sum"+e);
			}
		}
		return count;
	}
	
	/**
	private static  String getInputCksum(String fileName, String JobNames, String filePath, String fileTyp)
    {
          CheckSumDetailsVO checkSumDetailsVO = new CheckSumDetailsVO();
          BigDecimal count = new BigDecimal(0);
          String []jobName = JobNames.split(ETLConstants.DA_JOBNAME_SEP);
          String cntProdCd = jobName[1] + ETLConstants.DA_JOBNAME_SEP + jobName[2];
          checkSumDetailsVO = queryExec.getCheckSumDetailsMap(cntProdCd, fileTyp);

          if(!(OS.indexOf("win") >= 0)){
                Process p;
                File checkSumFile = null;
                try {
                      String mergeCommand = "";
                      checkSumFile = new File(filePath+fileName.substring(0, fileName.lastIndexOf("."))+"checksum.dat");
                      if(!checkSumFile.exists()){
                    	  checkSumFile.createNewFile();
                      }
                      if (JobNames.contains("IN-MTG")){
                    	  mergeCommand = "./InputCksum.sh "  +  filePath + fileName +" " + checkSumDetailsVO.getInputFieldPos()+" 2 "+filePath+checkSumFile.getName();
                      }else{
                    	  mergeCommand = "./InputCksum.sh "  +  filePath + fileName +" " + checkSumDetailsVO.getInputFieldPos()+" 1 "+filePath+checkSumFile.getName();
                      }
                      logger.info(" Input checksum command "+mergeCommand);
                      p = Runtime.getRuntime().exec(mergeCommand);
                      p.waitFor();
                     // BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
                      count = reader.readLine();
                      count = CheckSumReader.calculateCheckSum(filePath+checkSumFile.getName());
                      logger.info(" Input checksum command is Successfull");
                } catch (InterruptedException e) {
                      logger.error("ERROR while geting input check suem"+e);
                } catch (IOException e) {
                      logger.error("ERROR while geting input check suem"+e);
                } finally{
                	if(checkSumFile != null){
                		checkSumFile.delete();
                	}
                }
          }

          return count.toString();
    }**/

	private static String getDataFilenameList(Map<String, String> dataFileNames) {
		String DataFileList = "";
		int count = 0;
		Iterator<Entry<String, String>> it = dataFileNames.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> entry = (Map.Entry<String, String>)it.next();
			if (!(entry.getValue().toString().contains(ETLConstants.DA_FXRATE_FILE_TYP)) && !(entry.getValue().toString().contains(ETLConstants.DA_CB_FINANCE_FILE_TYP))){
				if (count == 0){
					DataFileList = entry.getValue().toString();
				}else{
					DataFileList =  DataFileList + "," + entry.getValue().toString();
				}
				count ++;
			}
		}
		return DataFileList;
	}
	
	private static String getFileCreationDate(String filePath) throws IOException{
		Path file =Paths.get(filePath);
        BasicFileAttributes attributes = null;
        attributes = Files.readAttributes(file, BasicFileAttributes.class);
         FileTime creationTime = attributes.creationTime();
        String creationTimeat = String.valueOf(creationTime);
        String creationTimeTrim = creationTimeat.substring(0, 10);
   
		return creationTimeTrim;
	}

}
