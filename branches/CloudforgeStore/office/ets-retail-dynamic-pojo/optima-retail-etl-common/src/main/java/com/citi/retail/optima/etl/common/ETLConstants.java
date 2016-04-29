package com.citi.retail.optima.etl.common;

/**
 * 
 * @author ms04453
 * 
 */
public interface ETLConstants {

	/* ENRICHMENT STATS */
	String ENRICHMENT_READ_COUNT = "enrichmentReadCnt";
	String ENRICHMENT_PROCESSED_COUNT = "enrichmentProcessedCnt";
	String ENRICHMENT_SKIPPED_COUNT = "enrichmentSkippedCnt";

	/* AGGREGATION STATS */
	String AGGREGATION_READ_COUNT = "aggregationReadCnt";
	String AGGREGATION_PROCESSED_COUNT = "aggregationProcessedCnt";
	String AGGREGATION_SKIPPED_COUNT = "aggregationSkippedCnt";

	/* JOB PARAMS */
	String BATCH_INSTANCE_ID = "batchInstanceId";
	String BATCH_ID = "batchId";
	String REPORT_DATE = "reportDate";
	String CURRENT_DATE = "currentDate";
	String REPORT_PERIOD_ID = "reportPeriodId";
	String REPORT_YEAR = "reportYear";
	String REPORT_QTR = "reportQtr";
	String SRC_SYS_ID = "src_sys_id";
	String SCHEDULE_ID_LIST = "scheduleIdList";
	String PROCESSING_UNIT_ID_LIST = "processingUnitIdList";
	String ROW_COUNT = "rowcount";
	String THRESHOLD = "threshold";
	String ORIGINAL_MSG_ID = "originalMessageId";
	String EVENT_TIMESTAMP = "eventTimestamp";
	String PRODUCT_LIST_STR = "productList";
	String HOME_EQUITY_PROD = "'RE_HE'";
	String HOME_LOAN_PROD = "'RE_HL'";
	String SMALL_BUSINESS_LINE_OF_CREDIT = "'SB_LC'";
	String SMALL_BUSINESS_TERM_LOAN = "'SB_TL'";
	String SMALL_BUSINESS_OTHER = "'SB_OT'";

	String SEPARATOR_COMMA = ",";

	String STATUS_REQUIRED = "REQUIRED";
	String STATUS_NOTREQUIRED = "NOTREQUIRED";

	String PARENT_STEP_NAME = "parentStepName";
	String CURRENT_STEP_NAME = "stepName";
	String PARTITION_KEY_SEPARATOR = ":";

	/* OTHER PARAMS */
	String PARTITION_ID = "partitionId";
	String PORTFOLIO_ID = "portfolioId";
	String VERSION_ID = "versionId";
	String APPROVER_ID = "approverId";

	String OLD_FDIC_FICO_EVENT = "O";
	String LATEST_FDIC_FICO_EVENT = "L";

	String TABLE_NAME = "tableName";
	String FILE_TYPE = "fileType";
	String FILE_READER = "fileReader";
	String FILE_ID = "fileId";
	String FILE_PATH = "filePath";

	String EXCLUDE_STEP_EXECUTION_KEY_ARRAY[] = new String[] { PARTITION_ID };
	String EXCLUDE_JOB_EXECUTION_KEY_ARRAY[] = new String[] { "mdcContextMap" };

	boolean METRICS = System.getProperty("metrics") != null
			&& System.getProperty("metrics").equals("true") ? true : false;
	String TIMER = "Timer";
	String ORETL_MANUAL_SUB = "ORETL_MANUAL_SUB";
	String SYS_PROC_ID = "sys_proc_id";
	String PROC_UNIT_D = "proc_unit_id";
	String FILE_AUDIT_FLD_TIME = "file_sub_time";
	String FILE_AUDIT_FLD_USER = "crte_user_id";
	String INTERNAL_DATE_FORMAT = "yyyyMMdd";
	
	String DA_RNBW_FILE = "RNBW";
	String DA_FICO_FILE = "FICO";
	String DA_EPP_FILE = "EPP";
	String DA_WO_FILE = "WO";
	String DA_NTB_FILE = "NTB";
	String DA_REC_FILE = "REC";
	String DA_TDR_FILE = "TDR";
	String DA_INT_FILE = "INT";
	String DA_PRE_RNBW_FILE = "CPMB";
	
//	String DA_RNBW_FILE = "rnbw";
//	String DA_FICO_FILE = "fico";
//	String DA_EPP_FILE = "epp";
//	String DA_WO_FILE = "wo";
//	String DA_NTB_FILE = "ntb";
//	String DA_REC_FILE = "rec";
//	String DA_TDR_FILE = "tdr";
//	String DA_INT_FILE = "int";
//	String DA_PRE_RNBW_FILE = "cpmb";
	
//	String DA_ALS_FILE="ALS";
//	String DA_MEMO_FILE="MEMO";
//	String DA_FIP_FILE="FIP";
//	String DA_OREO_FILE="OREO";
//	String DA_BAUIMP_FILE="BAUIMP";
//	String DA_MUTCOL_FILE="MUTCOL";
//	String DA_TEASER_FILE="TEASER";


	
	String DA_ALS_FILE="alsl";
	String DA_MEMO_FILE="memo";
	String DA_FIP_FILE="fip";
	String DA_OREO_FILE="oreo";
	String DA_BAUIMP_FILE="bauimp";
	String DA_MUTCOL_FILE="mut_col";
	String DA_TEASER_FILE="teaser";
	String DA_FICO_FILE_MTG="fico";
	String DA_TDR_FILE_MTG="tdr";
	String DA_LOANS_FILE="alsl";
	
	String DA_NEWCOMMITMENT = "NEW";
	String DA_NEWCOMMITMENT_TYP = "COMMIT";
	String DA_DELQ = "DELQ";
	String DA_CRD_TRANS = "TRANS";
	
	String PRODUCT_CODE = "productCode";
	String COUNTRY_CODE = "countryCode";
	String REGION = "region";
	String DATE_OF_EXTRACT = "dateOfExtract";
	String DATE_OF_INFO = "dateOfInfo";

	String DAT="dat";
	//String CNTL="cnt";
	String CNTL="ctl";
	String ACK="ack";
	String SPLITDELIMITER="_";
	String DA_IN_CRD_FILE = "IN_CARDS";
	
	String DA_IN_CORPMAST_FILE = "IN_CORPMAST";
	String DA_IN_RETMAST_FILE = "IN_RETMAST";
	String DA_IN_RWMAST_FILE = "IN_RWMAST";
	
	String DA_IN_CORPMAST_FILE_TYP = "CORPMAST";
	String DA_IN_RETMAST_FILE_TYP = "RETMAST";
	String DA_IN_RWMAST_FILE_TYP = "RWMAST";

	
	String DA_FXRATE_FILE_TYP = "FXRATE";
	String DATADATE_REGEX = "#DATADATE#";
	String DA_IN_PL_FILE = "IN_LOANS"; 
		
	String DA_IN_MTG_GCBC_FILE = "IN_GCBC";
	String DA_IN_MTG_GCL_FILE = "IN_GCL";
	String DA_IN_MTG_STFMTG_FILE = "IN_MTG_STFMTG";
	
	String DA_WO_REC_FILE = "WO_REC";
	String DA_NEW_BC_FILE = "NEW_COMMIT_BC";
	String DA_NEW_DC_FILE = "NEW_COMMIT_DC";
	String DA_CRD_TRANS_FILE = "CRD_TRANS";
	String DA_DELQ_BC_FILE = "DELQ_BC";
	String DA_DELQ_DC_FILE = "DELQ_DC";
	String DA_WO_BC_FILE = "WO_BC";
	String DA_WO_DC_FILE = "WO_DC";
	String DA_FICO_DC_FILE = "FICO_DC";
	String DA_FICO_BC_FILE = "FICO_BC";
	String DA_RNBW_BC_FILE = "RNBW_BC";
	String DA_RNBW_DC_FILE = "RNBW_DC";
	
	
	// Added for HK MTG
	String DA_HK_MTG_RECOVERY_MANUAL_FILE = "REC";
	String DA_HK_MTG_FORCLS_FILE = "FIP";
	String DA_HK_MTG_WRITE_OFF_FILE = "WO";
	String DA_HK_MTG_REWRITE_ACCT_FILE = "RW";
	String DA_HK_MTG_RNBW_FILE = "RNBW";
	String DA_DF_ddMMMyyyy_HH_mm_ss = "ddMMMyyyy";
	String DA_DF_yyyy = "yyyy";
	String DA_DF_yymmdd = "yymmdd";
	String DA_DF_yyyymmdd = "yyyymmdd";
	String DA_DF_yyyymm = "yyyymm";
	String JOB_NAME="JOB_NAME";
	
	String JOB_STRT_TIME = "STRT_TIME";
	String JOB_STRT_TIME_FRMT = "ddMMyyyy_HHmmss";
	
	String DA_CB_FINANCE_FILE_TYP = "CB_FINANCE";
	
	String DA_RNBW_FILE_STR = "merge_data_limit";
	String DA_WO_FILE_STR = "wo";
	String DA_REC_FILE_STR = "recovery";
	String DA_FICO_FILE_STR = "fico";
	String DA_NEWCOMMITMENT_STR = "new";
	String DA_DELQ_STR = "delinq";
	String DA_CRD_TRANS_STR = "card_transfer";
	
	String DA_HK_MTG_RNBW_FILE_STR = "hksi";
	String DA_HK_MTG_RECOVERY_MANUAL_FILE_STR = "rec";
	String DA_HK_MTG_FORCLS_FILE_STR = "fip";
	String DA_HK_MTG_WRITE_OFF_FILE_STR = "wo";
	String DA_HK_MTG_REWRITE_ACCT_FILE_STR = "rewrite";
	
	String DA_RNBW_DC_FILE_STR = "merge_data_limit_dc";
	String DA_RNBW_BC_FILE_STR = "merge_data_limit_bc";
	String DA_FICO_DC_FILE_STR = "dc_fico_score";
	String DA_FICO_BC_FILE_STR = "bc_fico_score";
	String DA_DELQ_BC_FILE_STR = "delinq_base_bc";
	String DA_DELQ_DC_FILE_STR = "delinq_base_dc";
	String DA_NEW_DC_FILE_STR = "dc_new";
	String DA_NEW_BC_FILE_STR = "bc_new";
	String DA_CRD_TRANS_FILE_STR = "card_transfer";
	String DA_WO_DC_FILE_STR = "dc";
	String DA_WO_BC_FILE_STR = "bc";
	
	String DA_HK_PL_RNBW_FILE_STR = "ccar_history_file";
	
	String DA_IN_PL_FILE_STR = "pil_ccar";
	
	String DA_IN_CORPMAST_FILE_TYP_STR = "co";
	String DA_IN_RETMAST_FILE_TYP_STR = "re";
	String DA_IN_RWMAST_FILE_TYP_STR = "rw";
	
	String DA_IN_MTG_GCBC_FILE_STR = "GCBC";
	String DA_IN_MTG_GCL_FILE_STR = "GCL";
	String DA_OREO_FILE_STR = "OREO";
	//String DA_IN_MTG_STFMTG_FILE_STR = "IN_MTG_STFMTG";
	
	String DA_IN_CRD_FILE_STR = "in_cards_ccar";
	
	String DA_HK_MTG_HKSi009_RAW_FILE = "hksi009_raw";
	String DA_HK_MTG_HKSi011_RAW_FILE = "hksi011_raw";
	String DA_HK_MTG_HKSi012_RAW_FILE = "hksi012_raw";
	String DA_HK_MTG_HKSi013_RAW_FILE = "hksi013_raw";
	String DA_HK_MTG_HKSi016_RAW_FILE = "hksi016_raw";
	
	String DA_MAIN_FILE = "MAIN_FILE";
	String DA_JOBNAME_SEP = "-";
	String DA_INPUT_CKSUM = "DA_INPUT_CKSUM";
	//new code
	String DA_ENR_INPUT_CKSUM = "DA_ENR_INPUT_CKSUM";
	String DA_UPB_INPUT_CKSUM = "DA_UPB_INPUT_CKSUM";
	String DA_ARFINSTATTYPID_INPUT_CKSUM = "DA_ARFINSTATTYPID_INPUT_CKSUM";
	String DA_ARPASTDUECLASS_INPUT_CKSUM = "DA_ARPASTDUECLASS_INPUT_CKSUM";
	String DA_INPUT_COUNT = "DA_INPUT_COUNT";
	
	String PRODUCT_CODE_UPPER = "productCodeUpper";
	String COUNTRY_CODE_UPPER = "countryCodeUpper";
	
	String DATA_FILE_LIST = "DATA_FILE_LIST";
	String FILE_SEPR = "_";
	String ENR_VALUE = "265";
	String ENR_CKSUM_FIELDNAME = "ENR";
	String UPB_VALUE = "1";
	String UPB_CKSUM_FIELDNAME = "UPB";
	String CKSUM_FILENAME = "RNBW";
	String SPACE_STR = " ";
	String EMPTY_STR = "";
	String WIN_OS = "win";
	String CTL_MOVED_FILE_STR="_moved";
	String DA_BOOC_FILE = "BOOC";
	String DA_CONTROL_FILE_NAME = "DA_CONTROL_FILE_NAME";
	String DA_PCL_PROD = "PCL";
	String DA_RCL_PROD = "RCL";
	String DA_CB_FILE_NM = "CB";
}
