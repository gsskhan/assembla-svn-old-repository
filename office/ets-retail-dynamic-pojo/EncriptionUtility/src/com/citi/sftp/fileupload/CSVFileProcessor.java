package com.citi.sftp.fileupload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;

import javax.activation.UnsupportedDataTypeException;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.exception.NestableRuntimeException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import au.com.bytecode.opencsv.CSVWriter;

import com.citi.sftp.vo.FilesMasterVO;



public class CSVFileProcessor {
	
	private static Logger logger = Logger.getLogger(CSVFileProcessor.class.getName());
	
	public CSVFileProcessor() {
	}

	
	public void processFile(FilesMasterVO fileMasterVO, String fileName, String soeID) throws UnsupportedDataTypeException {
		Validate.notNull(fileMasterVO, "FileMaster VO is required in processFile()");
		Validate.notNull(fileName, "File Name is required in  processFile()");
		String mappingFilename = "";
		CSVWriter csvWriter = null;
		CSVDataContainer dataContainer = null;
		logger.info("--------------------------------------------------------");
		logger.info("Started processing file:" + fileName + " at:" + new Date());
		logger.info("--------------------------------------------------------");
		
		try{
			FileProcessor fileProcessor = new FileProcessor();
			
			//String outputDirName = SFTPConstants.OUTPUT_DIRECTORY;
			String outputDirName = fileMasterVO.getOutputDirName();
			dataContainer = new CSVDataContainer();
			/*if(fileName.contains("tw_ecs")){
				dataContainer.setFileType(fileType);
			}*/
			//initilize data container
			dataContainer.setBlockSize(new Integer(SFTPConstants.PROCESSING_BLOCK_SIZE));
			dataContainer.setInputFileName(fileMasterVO.getInputDirName() + fileName);
			//dataContainer.setOutputFileName(outputDirName + fileName.toUpperCase()); // make filename uppercase
			String outputFileName = fileName;
			if(fileName.endsWith(SFTPConstants.FILE_EXTENTION_EXCEL)|| fileName.endsWith(SFTPConstants.FILE_EXTENTION_EXCEL_XLSX)){
				outputFileName = fileName.substring(0, fileName.indexOf(SFTPConstants.FILE_EXTENTION_EXCEL)) + ".dat";
			}else if(fileName.endsWith(SFTPConstants.FILE_EXTENTION_DBF)){
				outputFileName = fileName.substring(0, fileName.indexOf(SFTPConstants.FILE_EXTENTION_DBF)) + ".dat";
			}
			dataContainer.setOutputFileName(outputDirName + outputFileName); // changed to remain input name as output name
			dataContainer.setFileName(fileName.substring(fileName.indexOf("\\")+1));
			dataContainer.setFileMasterVO(fileMasterVO);	
			
			String fileType = null; 
			Iterator<String> iterator = dataContainer.getFileMasterVO().getFileNameColumnMap().keySet().iterator();
			
			while (iterator.hasNext()) {
				fileType = iterator.next();
				if (dataContainer.getFileName().startsWith(fileType)) {
					dataContainer.setFileType(fileType);
					break;
				}
			}
			
			if(dataContainer.getFileType()==null) {
				throw new Exception("Invalid File Type !!!!");
			}
			
			if(dataContainer.getFileName().toUpperCase().endsWith(SFTPConstants.FILE_EXTENTION_DBF)){
				fileProcessor.readDbfFile(dataContainer);
			}else if(dataContainer.getFileName().endsWith(SFTPConstants.FILE_EXTENTION_EXCEL) || dataContainer.getFileName().endsWith(SFTPConstants.FILE_EXTENTION_EXCEL_XLSX)){
				fileProcessor.readFile(dataContainer);
			}else{
				while (dataContainer.isContinueProcessing()) {
						fileProcessor.execute(dataContainer);
				}
			}
			
			
			//message(logDate() + " : Total number of rows:" + dataContainer.getNoOfTotalRecords());
			//message(logDate() + " : Total number of data rows:" + dataContainer.getNoOfCleanRecords());
			//message(logDate() + " : Finished processing file:" + fileName);
			logger.info("Finished processing file:" + fileName + " at: " + new Date());
			logger.info("Total number of rows:" + dataContainer.getNoOfTotalRecords());
			logger.info("Total number of data rows:" + dataContainer.getNoOfCleanRecords());
			//logger.info("Moving file "+ fileMasterVO.getInputDirName() +  fileName + " to processed dir");
			
			logger.info("---------------------------------------------------------------");
			logger.info("Finished processing files at:" + new Date());
			logger.info("---------------------------------------------------------------");
				
		} catch (UnsupportedDataTypeException e) {
			//message(logDate() + " : Unable to process the files!");
			//message(logDate() + " : Invalid data found in File="+fileName+", Row="+dataContainer.getInvalidDataRowNo() +", Column="+dataContainer.getInvalidDataColNo()+", Value="+dataContainer.getInvalidDataValue()+", Column Name="+dataContainer.getInvalidDataHeader());
			logger.info("Unable to process the files! Invalid data found in File="+fileName+", Row="+dataContainer.getInvalidDataRowNo() +", Column="+dataContainer.getInvalidDataColNo()+", Value="+dataContainer.getInvalidDataValue()+", Column Name="+dataContainer.getInvalidDataHeader(), e);
			throw new UnsupportedDataTypeException("Unable to process the files! Invalid Data");
			//System.exit(-1);
		} catch (NestableRuntimeException e) {
			logger.fatal("Unable to process the files!", e);
			throw new NestableRuntimeException(e.getLocalizedMessage());
		}catch (Exception e) {
			logger.fatal("Unable to process the files!", e);
			//throw new NestableRuntimeException(e.getLocalizedMessage());
		} finally {
			try {
				if(csvWriter != null) csvWriter.close();
			} catch (Exception e) {
				logger.fatal("Unable to close output CSV Write for file : " + mappingFilename, e);
			}
		}
	}

	/*private void populateEncryptionPositions(FilesMasterVO vo, CSVDataContainer dataContainer) {
		List<Integer> arlPosition = new ArrayList<Integer> ();
		if (vo.getMsk_fld1_pos() != null) {
			arlPosition.add(vo.getMsk_fld1_pos()-1);
		}
		if (vo.getMsk_fld2_pos() != null) {
			arlPosition.add(vo.getMsk_fld2_pos()-1);
		}
		if (vo.getMsk_fld3_pos() != null) {
			arlPosition.add(vo.getMsk_fld3_pos()-1);
		}
		if (vo.getMsk_fld4_pos() != null) {
			arlPosition.add(vo.getMsk_fld4_pos()-1);
		}
		if (vo.getMsk_fld5_pos() != null) {
			arlPosition.add(vo.getMsk_fld5_pos()-1);
		}
		dataContainer.setEncryptionPositions(arlPosition);
	}*/
	
//	private void populateEncryptionPositionsDataType(FilesMasterVO vo, CSVDataContainer dataContainer) {
//		List<String> arlPositionDataType = new ArrayList<String> ();
//		if (vo.getMsk_fld1_typ() != null) {
//			arlPositionDataType.add(vo.getMsk_fld1_typ());
//		}
//		if (vo.getMsk_fld2_typ() != null) {
//			arlPositionDataType.add(vo.getMsk_fld2_typ());
//		}
//		if (vo.getMsk_fld3_typ() != null) {
//			arlPositionDataType.add(vo.getMsk_fld3_typ());
//		}
//		if (vo.getMsk_fld4_typ() != null) {
//			arlPositionDataType.add(vo.getMsk_fld4_typ());
//		}
//		if (vo.getMsk_fld5_typ() != null) {
//			arlPositionDataType.add(vo.getMsk_fld5_typ());
//		}
//		dataContainer.setEncryptionPositionsDataType(arlPositionDataType);
//	}
	
	protected void message(final String str) {/*
		if (str != null) {
			Runnable runner = new Runnable() {
				public void run() {
					monitor.append(str + '\n');
					monitor.repaint();
				}
			};
			SwingUtilities.invokeLater(runner);
		}
	*/
		System.out.println(str);
		}
	
	private void logInit()
	{
		//final String LOG_FILE = "C:/eclipse_workspace/lib/log4j.properties"; 
		final String LOG_FILE = "config"+File.separator+"log4j.properties";
		Properties logProp = new Properties();      
		try     
		{      
			logProp.load(new FileInputStream (LOG_FILE));  
			PropertyConfigurator.configure(LOG_FILE);      
			//logger.info("Logging enabled");    
		}     
		catch(IOException e)                
		{       
			System.out.println("Logging not enabled");       
		}  
	}
		
	public static void main(String fileNameArray[]){
		CSVFileProcessor csvFileProcessor = new CSVFileProcessor();
		csvFileProcessor.logInit();
		FilesMasterVO filesMasterVO =  FilesMasterVO.getInstance(fileNameArray[1]);
		try {
			long time= System.currentTimeMillis(); 
			if(fileNameArray.length>1){
				String[] fileNameArr=fileNameArray[0].split(SFTPConstants.FILE_NAME_SEPERATOR);
				for(String fileName : fileNameArr){
					csvFileProcessor.processFile(filesMasterVO,fileName, null);
					
					/**
					 * this will check whether the outputfile is present and also 
					 */
					if(new File(filesMasterVO.getOutputDirName()+File.separator+fileName).exists() && filesMasterVO.isInputFileDeleteRequired()) {
						new File(filesMasterVO.getInputDirName() + File.separator + fileName).delete();
					}
				}				
			}else{
				System.out.println("Please enter the input filenames and property filename !!!");
			}
			logger.info("Time Taken to complete processing : "+String.valueOf(System.currentTimeMillis()-time)+" ms\n\n");
			
		} catch (UnsupportedDataTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
