package com.citi.sftp.fileupload;

import java.text.SimpleDateFormat;

public class SFTPConstants {
	public static final String ENCRYPTION_ALGORITHM = "SHA-512";
	public static final String KEY_ENCRYPTION_ALGORITHM = "encryption_algorithm";
	public static final String ENCRYPTION_ESCAPE_STR = "$$^$$";
	/*char COMMA_DELIMITER = ',';
	char TAB_DELIMITER = '\t';*/
	public static final String APP_ID="162000";
	public static String USER_DRIVE = "C:/"; 
	public static String SHARED_DRIVE = "C:/"; // if user has shared drive then value dynamically updated at runtime
	public static String OUTPUT_PATH = "SFTPUtility_Files/output/";
	public static String PROCESSED_PATH = "SFTPUtility_Files/processed/";
	public static String ARCHIVE_PATH = "SFTPUtility_Files/archive";
	
	//public static String INPUT_DIRECTORY = USER_DRIVE+INPUT_PATH;
	public static String OUTPUT_DIRECTORY = USER_DRIVE+OUTPUT_PATH;
	public static String PROCESSED_DIRECTORY = USER_DRIVE+PROCESSED_PATH;
	public static String ARCHIVE_DIRECTORY = USER_DRIVE+ARCHIVE_PATH;
	//String PRIVATE_KEY = "C:/SFTPClientService/bin/cst_id_dsa";
	//String SFTP_SERVER = "gcswsas1d.nam.nsroot.net";
	//String SFTP_SERVER = "corpai100d.nam.nsroot.net";
	//String SFTP_SERVER = "ccrsai101d.nam.nsroot.net";
	//String SFTP_USER = "gcdvsftp";
	//String SFTP_REMOTE_DIR = "/home/pst_d/cst/inbound";
	//String SFTP_REMOTE_DIR = "/home/gcdvsftp";
	//String SFTP_REMOTE_DIR = "/tmp";
	public static final SimpleDateFormat LOG_DATE_FORMAT = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
	public static final String KEY_STRING = "GCRRSftp";
	//int PROCESSING_BLOCK_SIZE = 5000;
	public static final int PROCESSING_BLOCK_SIZE = Integer.MAX_VALUE;
	public static final String LDAP_DISCONNECT_CMD = "XPS";
	public static final String LDAP_CONNECT_CMD = "CON";
	public static final String CALENDAR_OPEN = "Y";
	public static final String TEN_Q = "10Q";
	public static final String CTL_FILE_ENROL_NAME =  "ENROLCNTL";
	public static final String CTL_FILE_MUPD_NAME =  "MUPDCNTL";
	public static final String ACTUAL_FILE_ENROL_NAME =  "ENROLV1";
	public static final String ACTUAL_FILE_MUPD_NAME =  "MUPDV1";
	//constants for sftp utility layout 
	 public static int LENGTH = 740;
	 public static int WIDTH = 580;
	 public static int FILEFLDWIDTH = 38;
	 public static final String LBLAPPWRKGRP = "Application-Workgroup:";
	 public static final String LBLSUBMISSIONCYCLE = "Submission Cycle:";
	 public static final String LBLFILETYPE = "File Type:";
	 
	//workunit status
	public static final int PENDING_SUBMISSION = 1;
	public static final int FILE_REJECT = 6;
	public static final int RESUBMIT = 7;
	public static final int REVIEW_REJECT = 9;
	public static final int ATTESTATION_REJECT = 11;
	public static final int PENDING_CLIENT_VALIDATION = 30;
	public static final int FILE_TRANSFER_IN_PROGRESS = 31;
	public static final String FILE_NAME_SEPERATOR = ";";
	
	public static final String NUM_DATATYPE = "NUM";
	public static final String CHAR_DATATYPE = "CHAR";
	public static final String DECIMAL_DATATYPE = "DECIMAL";
	public static final String ALPHANUM_DATATYPE = "ALPHANUM";
	
	public static final String WORKUNIT_STS_PENDING_VALIDATION = "File has been received and is currently under validation process. Please validate submission summary and exception reports after receiving \"File Processed\" notification from system";	
	public static final String WORKUNIT_STS_PENDING_SUBMISSION = "File has already been processed. Please validate submission summary and exception report";	
	public static final String WORKUNIT_STS_PENDING_REVIEW = "File is pending with Reviewer and can be uploaded again only if rejected by Reviewer";	
	public static final String WORKUNIT_STS_PENDING_ATTESTATION = "File is pending with Attester and can be uploaded again only if rejected by Attester";	
	public static final String WORKUNIT_STS_ATTESTED = "Workgroup has successfully completed the submission process. Please contact Operations team to re-open the workgroup for submission process";	
	public static final String WORKUNIT_STS_TERMINATION = "Work unit has been Terminated. No further action can be performed on this workgroup";
	public static final String WORKUNIT_STS_DISABLED = "The deadline has passed and your workgroup has been disabled. Please send an explanation for the delay to the Admin team, along with your request to have the workgroup re-enabled. Upon approval from the Admin team, GC20 OPS will re-enable the workgroup";
	
	
	public static final String HEADER_FLAG = "Y";
	public static final String NO_HEADER_FLAG = "N";
	public static final String DELIMETER_PIPE = "\\|";
	public static final String KEY_COLUMNS = "msk_fld_columns";
	public static final String KEY_COLUMN_TYPES = "msk_fld_types";
	
	public static final String KEY_INPUT_DIR_NAME = "input_dir_name";
	public static final String KEY_OUTPUT_DIR_NAME = "output_dir_name";
	public static final String KEY_PROCESSED_DIR_NAME = "processed_dir_name";
	public static final String KEY_HEADER = "header";
	public static final String KEY_DELIMITER = "delimiter";
	public static final String KEY_DELETE_INPUT_FILE = "delete_input_file";
	public static final String KEY_DELETE_PROCESSED_FILE = "delete_processed_file";
	public static final String KEY_CREATE_OUTPUT_FILE = "create_output_file";
	public static final int FILE_PROPERTY_COUNT = 3;
	public static final String PROPERTY_FILE_NAME = "encription_util.properties";
	public static final String CONFIG_PATH = "config";
	public static final String SHEET_NAME = "customer";
	public static final String FILE_EXTENTION_EXCEL = ".xls";
	public static final String FILE_EXTENTION_EXCEL_XLSX = ".xlsx";
	public static final String FILE_EXTENTION_DBF = ".DBF";
	
	public static final String LINES_TO_SKIP = "lines_to_skip";
	public static final String KEY_INPUT_DELIMITER = "input_delimiter";
	
	public static void setUSER_DRIVE(String uSER_DRIVE) {
		//USER_DRIVE = uSER_DRIVE;
		SHARED_DRIVE = uSER_DRIVE;
		//OUTPUT_DIRECTORY = uSER_DRIVE+OUTPUT_PATH;
		//PROCESSED_DIRECTORY = uSER_DRIVE+PROCESSED_PATH;
		//ARCHIVE_DIRECTORY = uSER_DRIVE+ARCHIVE_PATH;
	}

	public static String getUSER_DRIVE() {
		return SHARED_DRIVE;
	}
	
	
}
