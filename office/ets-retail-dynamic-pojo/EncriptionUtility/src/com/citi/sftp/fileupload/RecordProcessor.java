/*
 * CSVRecordProcessor.java
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

import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.activation.UnsupportedDataTypeException;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.NestableException;
import org.apache.log4j.Logger;

import com.citi.sftp.vo.FilesMasterVO;

import au.com.bytecode.opencsv.CSVWriter;

public class RecordProcessor {
	static Logger logger = Logger.getLogger(RecordProcessor.class.getName());
	List<String[]> mappingValues = new ArrayList<String[]>();
	MessageDigest md = null;
	CSVWriter csvWriter = null;
	CSVWriter mappingFileWriter = null;
	String[] headerRecord = null;
	
	public RecordProcessor(CSVDataContainer dataContainer) {
		try {
			//md = MessageDigest.getInstance(SFTPConstants.ENCRYPTION_ALGORITHM);
			md = MessageDigest.getInstance(FilesMasterVO.getInstance(null).getEncriptonAlgorithm());
			//String delimiter = dataContainer.getFileMasterVO().getDelimiter();
			//char char_delimiter = EscapeChars.TAB.getEscapeChar();
			char char_delimiter = EscapeChars.PIPE.getEscapeChar();
			if(FilesMasterVO.getInstance(null).createOutputFile()){
				csvWriter = new CSVWriter(new FileWriter (dataContainer.getOutputFileName()),char_delimiter, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.NO_ESCAPE_CHARACTER);
			}
		    
		    /**
		     * this will check whether mapping file creation is required or not based on property file value
		     */
		    if(!dataContainer.getFileMasterVO().isProcessedFileDeleteRequired()) {
		    	String mappingFilename = "Mapping_"+dataContainer.getFileName().substring(0,dataContainer.getFileName().lastIndexOf("."))+".dat";
			    //mappingFileWriter = new CSVWriter(new FileWriter (SFTPConstants.PROCESSED_DIRECTORY+mappingFilename),EscapeChars.TAB.getEscapeChar(), CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.NO_ESCAPE_CHARACTER);
		    	mappingFileWriter = new CSVWriter(new FileWriter (dataContainer.getFileMasterVO().getProcessedDirName() +mappingFilename),EscapeChars.TAB.getEscapeChar(), CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.NO_ESCAPE_CHARACTER);
		    }
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void processData(String[] nextLine,CSVDataContainer dataContainer, int intArr[]) throws NestableException {
		// TODO Auto-generated method stub
		try {
		if (nextLine == null || (nextLine.length == 1 && StringUtils.isEmpty(nextLine[0]))||nextLine.length == 0) {
			dataContainer.setContinueProcessing(false);
			intArr[1]++;
		} else {
			execute(dataContainer,nextLine, intArr[0]);
			intArr[0]++;
		} 
		}catch (Exception e){
			e.printStackTrace();
			logger.error("Exception in process data", e);
			throw new NestableException(e);
		}
		
	}
	
	/**
	 * Process the records
	 * 
	 * @param dataContainer
	 * @throws NestableException
	 */
	public void execute(CSVDataContainer dataContainer, String[] line, int counter) throws NestableException,UnsupportedDataTypeException {
		
		//logger.info("Start of CSVRecordProcessor-execute()");
		try {
			
			List columnHeaderList = null;
			
			//skipping the header
			List columnDetails = dataContainer.getFileMasterVO().getFileNameColumnMap().get(dataContainer.getFileType());
				if(counter< FilesMasterVO.getInstance(null).getLinesToSkip() && StringUtils.equalsIgnoreCase(columnDetails.get(0).toString(), SFTPConstants.HEADER_FLAG)) {
					if(csvWriter != null){
						csvWriter.writeNext(line);
					}
					
					 // first header record from input file
					String[] columnNameArr = (String[]) columnDetails.get(1);
					if(columnNameArr != null){
						columnHeaderList = Arrays.asList(line);
						for(String columnName : columnNameArr){
							
							// Added for Casesensitive changes
							int index = -1;
				            for (int i = 0; i < columnHeaderList.size(); i++) {
				                if(columnName.equalsIgnoreCase((String) columnHeaderList.get(i))){
				                	headerRecord = line;
				                	index=i;
				                    break;
				                }
				            }
							//int index = columnHeaderList.indexOf(columnName);
							if(index != -1){
								dataContainer.getEncryptionPositions().add(index);
							}
						}
					}
					
					// mapping file header process
					/**
				     * this will check whether mapping file creation is required or not based on property file value
				     */
					if(!dataContainer.getFileMasterVO().isProcessedFileDeleteRequired()) {
						List<Integer> arlPosition = dataContainer.getEncryptionPositions();
						Iterator<Integer> itr = arlPosition.iterator();
						
						if(headerRecord != null ){
							int size = headerRecord.length;
							int headerColumn = 0;
							String[] mappingHeader = new String[arlPosition.size()*2];
							while (itr.hasNext()) {
								int position = itr.next().intValue();
								if (position >=0 && position < size) {
									mappingHeader[headerColumn++] = headerRecord[position];
									mappingHeader[headerColumn++] = "MASKED_"+headerRecord[position];
								}
							}
							// mapping file header
							mappingFileWriter.writeNext(mappingHeader);
						}
						
					}
					
				}
				else {
					try {
							if(dataContainer.getEncryptionPositions().isEmpty() && StringUtils.equalsIgnoreCase(columnDetails.get(0).toString(), SFTPConstants.NO_HEADER_FLAG)){
								String[] columnIndexArr = (String[]) columnDetails.get(1);
								for(String columnIndex : columnIndexArr){
									dataContainer.getEncryptionPositions().add(Integer.parseInt(columnIndex)-1);
								}
							}
							
							if(dataContainer.getEncryptionPositions().isEmpty() || 
									dataContainer.getEncryptionPositions().size() != ((String[])columnDetails.get(1)).length){
								throw new Exception("One of the columns provided for masking is incorrect");
							}
							
							if(dataContainer.getEncryptionPositionsDataType()==null){
								dataContainer.setEncryptionPositionsDataType(new ArrayList<String>(Arrays.asList((String[])columnDetails.get(2))));
							}						
												
						String[] dt = encryptData(dataContainer, line);
						if(csvWriter != null){
							csvWriter.writeNext(dt);
						}
						
						//if(String.valueOf(counter).contains("00000")) logger.info("Finished up to "+counter+" records");
					} catch (UnsupportedDataTypeException e) {
						dataContainer.setInvalidDataRowNo(counter+1);
						dataContainer.setInvalidDataHeader(headerRecord[dataContainer.getInvalidDataColNo()-1]);
						throw new UnsupportedDataTypeException("Unable to process the files! Invalid Data");
					} catch (Exception e) {
						logger.fatal("Unable to Process record from EOD file : " + dataContainer.getInputFileName(), e);
						throw e;
					}
				}
		} catch (UnsupportedDataTypeException e) {
			throw new UnsupportedDataTypeException("Unable to process the files! Invalid Data");
		} catch (Exception e) {
			logger.fatal("Unable to Write/Process EOD file : " + dataContainer.getInputFileName(), e);
			throw new NestableException("Unable to Write/Process EOD file : " + dataContainer.getInputFileName(), e);
		} /*finally {
			
		}*/
		//logger.info("End of CSVRecordProcessor-execute()");
	}

	private String[] encryptData(CSVDataContainer dataContainer, String[] nextRecord) throws UnsupportedDataTypeException {
		try {
			String delimiter = dataContainer.getFileMasterVO().getDelimiter();
			int size = nextRecord.length;
			List<Integer> arlPosition = dataContainer.getEncryptionPositions();
			List<String> arlPositionDataType = dataContainer.getEncryptionPositionsDataType();
			Iterator<Integer> itr = arlPosition.iterator();
			String data, byteString, encryptedData, positionDataType;
			int mappingRecordPos = 0;
			String[] mappingRecord = new String[arlPosition.size()*2];
			byte[] digest;
			int itrCount = 0;
			while (itr.hasNext()) {
				int position = itr.next().intValue();
				if (position >=0 && position < size) {
					data = nextRecord[position];
					//logger.info("data "+ data);
					positionDataType = arlPositionDataType.get(itrCount) != null ? arlPositionDataType.get(itrCount).toString() : SFTPConstants.NUM_DATATYPE;
					if( (positionDataType.equals(SFTPConstants.NUM_DATATYPE) && (data == null || data.equals("") || !StringUtils.isNumeric(data)))) {
						dataContainer.setInvalidDataColNo(position+1);
						dataContainer.setInvalidDataValue(data);
						logger.info("Invalid numeric data found : "+data);
						throw new UnsupportedDataTypeException("Exception while validationg data");
					}else if( (positionDataType.equals(SFTPConstants.ALPHANUM_DATATYPE) && (data == null || data.equals("") || !StringUtils.isAlphanumeric(data)))) {
						dataContainer.setInvalidDataColNo(position+1);
						dataContainer.setInvalidDataValue(data);
						logger.info("Invalid numeric data found : "+data);
						throw new UnsupportedDataTypeException("Exception while validationg data");
					}
					encryptedData = "";
					if (StringUtils.isNotEmpty(data)) { // encrypt data
						md.reset();
						md.update(data.getBytes());
						digest = md.digest();
						StringBuffer hexString = new StringBuffer();
				    	for (int i=0;i<digest.length;i++) {
				    		String hex=Integer.toHexString(0xff & digest[i]);
				   	     	if(hex.length()==1) hexString.append('0');
				   	     	hexString.append(hex);
				    	}
						byteString = new String(hexString);
						encryptedData = escapeDelimiters(byteString,delimiter);
						nextRecord[position] = encryptedData;
					}
					/**
				     * this will check whether mapping file creation is required or not based on property file value
				     */
					if(!dataContainer.getFileMasterVO().isProcessedFileDeleteRequired()) {
						mappingRecord[mappingRecordPos++] = data;
						mappingRecord[mappingRecordPos++] = encryptedData;
					}
				}
				itrCount++;
			}
			/**
		     * this will check whether mapping file creation is required or not based on property file value
		     */
			if(!dataContainer.getFileMasterVO().isProcessedFileDeleteRequired()) {
				mappingFileWriter.writeNext(mappingRecord);
			}
			
			return nextRecord;
			
		} catch (UnsupportedDataTypeException ue) {
			throw new UnsupportedDataTypeException("Exception while validationg data");
		} catch (Exception e) {
			logger.error("Exception while encrypt Data", e);
		}
		
		return null;
	}
	
	private String escapeDelimiters(String data, String delimiter){
		String escapedData="";
		if(delimiter.equalsIgnoreCase("\\t")) {
			delimiter = "\t";
		}
		EscapeChars.CARRIAGE_RETURN.getEscapeChar();
		escapedData = StringUtils.replace(data, delimiter, SFTPConstants.ENCRYPTION_ESCAPE_STR);
		escapedData = StringUtils.replace(escapedData, Character.toString(EscapeChars.CARRIAGE_RETURN.getEscapeChar()), SFTPConstants.ENCRYPTION_ESCAPE_STR);
		escapedData = StringUtils.replace(escapedData, Character.toString(EscapeChars.NEW_LINE.getEscapeChar()), SFTPConstants.ENCRYPTION_ESCAPE_STR);
		return escapedData;
	}
	
	
	public List<String[]> getMappingValues() {
		return mappingValues;
	}

	public void setMappingValues(List<String[]> mappingValues) {
		this.mappingValues = mappingValues;
	}
	
	public void clearMappingValues() {
		this.mappingValues.clear();
	}
	
	public void addRecordToMappingValues(String[] record) {
		mappingValues.add(record);
	}
	
	public void addHeaderToMappingValues(String[] record) {
		mappingValues.add(0, record);
	}

	public void closeFileWriter() {
		try {
			if(csvWriter != null) csvWriter.close();
		} catch (Exception e) {
			logger.fatal("Unable to close output CSV Writer", e);
		}
	}
	
	public void closeMappingFileWriter() {
		try {
			if(mappingFileWriter != null) mappingFileWriter.close();
		} catch (Exception e) {
			logger.fatal("Unable to close output CSV Writer", e);
		}
	}
}

