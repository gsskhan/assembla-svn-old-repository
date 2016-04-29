/*
 * CSVDataContainer.java
 *
 * @author AC32649
 * 
 *	Change log
 *============================================================================
 *	Ver. Nbr.	Date			Modified by			Comments
 *============================================================================
 *	0.0.0.0		<Sep 20, 2010>		<AC32649>			File created and added to
 *											project <IPRRatingCron>
 */

package com.citi.sftp.fileupload;

import java.util.ArrayList;
import java.util.List;

import com.citi.sftp.vo.FilesMasterVO;

public class CSVDataContainer {
	private boolean isValidFile = false;
	private List<String[]> outputRecords = new ArrayList<String[]>();
	private int noOfTotalRecords = 0;
	private int noOfCleanRecords = 0;
	private int noOfRecordsProcessed = 0;
	private int blockSize = 10000;
	private String inputFileName = null;
	private String outputFileName = null;
	private String fileName = null;
	private boolean continueProcessing = true;
	private FilesMasterVO fileMasterVO = null;
	private int invalidDataColNo = 0;
	private int invalidDataRowNo = 0;
	private String invalidDataValue = null;
	private String invalidDataHeader = null;
	private String fileType = null;
	private List<String[]> inputRecords  = new ArrayList<String[]>();
	
	private List<Integer> encryptionPositions = new ArrayList<Integer>();
	private List<String> encryptionPositionsDataType = null;
	
	
	public List<Integer> getEncryptionPositions() {
		return encryptionPositions;
	}
	public void setEncryptionPositions(List<Integer> encryptionPositions) {
		this.encryptionPositions = encryptionPositions;
	}
	public List<String> getEncryptionPositionsDataType() {
		return encryptionPositionsDataType;
	}
	public void setEncryptionPositionsDataType(List<String> encryptionPositionsDataType) {
		this.encryptionPositionsDataType = encryptionPositionsDataType;
	}
	public FilesMasterVO getFileMasterVO() {
		return fileMasterVO;
	}
	public void setFileMasterVO(FilesMasterVO fileMasterVO) {
		this.fileMasterVO = fileMasterVO;
	}
	public List<String[]> getInputRecords() {
		return inputRecords;
	}
	public void setInputRecords(List<String[]> inputRecords) {
		this.inputRecords = inputRecords;
	}
	public int getNoOfCleanRecords() {
		return noOfCleanRecords;
	}
	public void setNoOfCleanRecords(int noOfCleanRecords) {
		this.noOfCleanRecords = noOfCleanRecords;
	}
	
	public List<String[]> getOutputRecords() {
		return outputRecords;
	}
	public void setOutputRecords(List<String[]> outputRecords) {
		this.outputRecords = outputRecords;
	}
	public boolean isContinueProcessing() {
		return continueProcessing;
	}
	public void setContinueProcessing(boolean continueProcessing) {
		this.continueProcessing = continueProcessing;
	}
	public int getNoOfTotalRecords() {
		return noOfTotalRecords;
	}
	public void setNoOfTotalRecords(int noOfTotalRecords) {
		this.noOfTotalRecords = noOfTotalRecords;
	}
	public String getInputFileName() {
		return inputFileName;
	}
	public void setInputFileName(String inputFileName) {
		this.inputFileName = inputFileName;
	}
	public String getOutputFileName() {
		return outputFileName;
	}
	public void setOutputFileName(String outputFileName) {
		this.outputFileName = outputFileName;
	}
	public int getBlockSize() {
		return blockSize;
	}
	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}
	public int getNoOfRecordsProcessed() {
		return noOfRecordsProcessed;
	}
	public void setNoOfRecordsProcessed(int noOfRecordsProcessed) {
		this.noOfRecordsProcessed = noOfRecordsProcessed;
	}
	
	public boolean isValidFile() {
		return isValidFile;
	}

	public void setValidFile(boolean isValidFile) {
		this.isValidFile = isValidFile;
	}
	
	public int getInvalidDataColNo() {
		return invalidDataColNo;
	}
	public void setInvalidDataColNo(int invalidDataColNo) {
		this.invalidDataColNo = invalidDataColNo;
	}
	
	public int getInvalidDataRowNo() {
		return invalidDataRowNo;
	}
	
	public void setInvalidDataRowNo(int invalidDataRowNo) {
		this.invalidDataRowNo = invalidDataRowNo;
	}
	
	public String getInvalidDataValue() {
		return invalidDataValue;
	}
	
	public void setInvalidDataValue(String invalidDataValue) {
		this.invalidDataValue = invalidDataValue;
	}
	
	public String getInvalidDataHeader() {
		return invalidDataHeader;
	}
	
	public void setInvalidDataHeader(String invalidDataHeader) {
		this.invalidDataHeader = invalidDataHeader;
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
	
}

