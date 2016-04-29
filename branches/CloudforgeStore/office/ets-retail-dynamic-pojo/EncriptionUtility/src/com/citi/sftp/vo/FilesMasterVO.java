package com.citi.sftp.vo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.citi.sftp.fileupload.EscapeChars;
import com.citi.sftp.fileupload.SFTPConstants;

public class FilesMasterVO {

	private Properties m_props = null;
	private static Logger logger = Logger.getLogger(FilesMasterVO.class
			.getName());
	private static FilesMasterVO m_fileMasterPropsInstance = null;
	private InputStream m_encryptionUtilPropertyFile = null;
	public static final String ENCRYPTION_UTIL_PROPERTIES = SFTPConstants.CONFIG_PATH
			//+ File.separator + SFTPConstants.PROPERTY_FILE_NAME;
			+ File.separator;
	private Map<String, List> fileNameColumnMap = new HashMap<String, List>();

	private FilesMasterVO(String configFilename) {
		m_props = new Properties();
		try {
			File file = new File(ENCRYPTION_UTIL_PROPERTIES + configFilename);
			m_encryptionUtilPropertyFile = new FileInputStream(file);
			m_props.load(m_encryptionUtilPropertyFile);
		} catch (IOException e) {
			logger.error("Error while reading property file ", e);
		}
	}

	public static FilesMasterVO getInstance(String configFilename) {
		if (m_fileMasterPropsInstance == null) {
			m_fileMasterPropsInstance = new FilesMasterVO(configFilename);
			m_fileMasterPropsInstance.getMaskFieldColumns();
		}
		return m_fileMasterPropsInstance;
	}

	public Map<String, List> getFileNameColumnMap() {
		return fileNameColumnMap;
	}

	private void getMaskFieldColumns() {
		String columns = m_props.getProperty(SFTPConstants.KEY_COLUMNS);
		String columns_types = m_props
				.getProperty(SFTPConstants.KEY_COLUMN_TYPES);
		String[] fileArr = columns.split(String.valueOf(EscapeChars.SEMICOLON
				.getEscapeChar()));
		String[] columnTypeArr = columns_types.split(String
				.valueOf(EscapeChars.SEMICOLON.getEscapeChar()));
		String[] indvArr = null;
		String[] indvTypeArr = null;
		List fileProperty = null;
		try {
			for (int i = 0; i < fileArr.length; i++) {
				indvArr = fileArr[i].split(SFTPConstants.DELIMETER_PIPE);
				indvTypeArr = columnTypeArr[i].split(SFTPConstants.DELIMETER_PIPE);
				if (indvArr.length != SFTPConstants.FILE_PROPERTY_COUNT) {
					throw new Exception("The column mapping is not right");
				} else {
					fileProperty = new ArrayList();
					fileProperty.add(indvArr[1].toString());
					fileProperty.add(indvArr[2].split(String
							.valueOf(EscapeChars.COMMA.getEscapeChar())));
					fileProperty.add(indvTypeArr[1].split(String
							.valueOf(EscapeChars.COMMA.getEscapeChar())));
					fileNameColumnMap.put(indvArr[0], fileProperty);
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	public String getInputDirName() {
		return m_props.getProperty(SFTPConstants.KEY_INPUT_DIR_NAME);
	}

	public String getOutputDirName() {
		return m_props.getProperty(SFTPConstants.KEY_OUTPUT_DIR_NAME);
	}

	public String getProcessedDirName() {
		return m_props.getProperty(SFTPConstants.KEY_PROCESSED_DIR_NAME);
	}

	public String getDelimiter() {
		return m_props.getProperty(SFTPConstants.KEY_DELIMITER);
	}
	
	public String getInputDelimiter() {
		return m_props.getProperty(SFTPConstants.KEY_INPUT_DELIMITER);
	}
	
	public boolean isInputFileDeleteRequired() {
		return Boolean.parseBoolean(m_props.getProperty(SFTPConstants.KEY_DELETE_INPUT_FILE));
	}
	
	public boolean isProcessedFileDeleteRequired() {
		return Boolean.parseBoolean(m_props.getProperty(SFTPConstants.KEY_DELETE_PROCESSED_FILE));
	}

	public String getEncriptonAlgorithm() {
		return m_props.getProperty(SFTPConstants.KEY_ENCRYPTION_ALGORITHM);
	}
	
	public int getLinesToSkip() {
		return Integer.valueOf(m_props.getProperty(SFTPConstants.LINES_TO_SKIP));
	}
	
	public boolean createOutputFile(){
		if(m_props.getProperty(SFTPConstants.KEY_CREATE_OUTPUT_FILE)!=null){
			return Boolean.parseBoolean(m_props.getProperty(SFTPConstants.KEY_CREATE_OUTPUT_FILE));
		}
		return true;
	}
}
