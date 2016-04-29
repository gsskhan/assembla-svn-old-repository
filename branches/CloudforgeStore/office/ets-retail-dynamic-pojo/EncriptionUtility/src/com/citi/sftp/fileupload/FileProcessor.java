package com.citi.sftp.fileupload;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.activation.UnsupportedDataTypeException;

import nl.knaw.dans.common.dbflib.Table;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.NestableException;
import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;

import com.citi.sftp.vo.FilesMasterVO;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

public class FileProcessor {
	
	static Logger logger = Logger.getLogger(FileProcessor.class.getName());
	/*private FileInputStream file =  null;
	private Workbook workbook = null;
	private XSSFWorkbook xlsxWorkbook = null;
	private Sheet sheet = null;
	private XSSFSheet xlsxSheet = null;*/
	
	
	public void execute(CSVDataContainer dataContainer) throws NestableException,UnsupportedDataTypeException  {
		//logger.info("Start of ParseCSVRecords-execute()");
		CSVReader reader = null;
		RecordProcessor recordProcessor = new RecordProcessor(dataContainer); 
		try {
			
						
			char char_delimiter;
			if(dataContainer.getFileMasterVO().getInputDelimiter().equalsIgnoreCase("\\t")) {
			char_delimiter = EscapeChars.TAB.getEscapeChar();
			}
			else{
				char_delimiter = dataContainer.getFileMasterVO().getInputDelimiter().charAt(0);
			}
			//char char_delimiter = EscapeChars.PIPE.getEscapeChar();
//			new FileWriter (dataContainer.getFileMasterVO().getProcessedDirName() +mappingFilename),EscapeChars.TAB.getEscapeChar(), CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.NO_ESCAPE_CHARACTER
			reader = new CSVReader(new FileReader(dataContainer.getInputFileName()), char_delimiter, CSVWriter.DEFAULT_QUOTE_CHARACTER, dataContainer.getNoOfRecordsProcessed());
			String nextLine[] = null;	
			int cleanRecords=0;
			 int[] intArr = {0,0};
			int blockSize = dataContainer.getBlockSize();
			
			while (dataContainer.isContinueProcessing() && blockSize > intArr[0]) {
				nextLine = reader.readNext();
				recordProcessor.processData(nextLine,dataContainer,intArr);
//				if (nextLine == null || (nextLine.length == 1 && StringUtils.isEmpty(nextLine[0]))) {
//					dataContainer.setContinueProcessing(false);
//					skippedRecordsCounter++;
//				} else {
//					recordProcessor.execute(dataContainer,nextLine, counter);
//					counter++;
//				}
			}
			dataContainer.setNoOfRecordsProcessed(dataContainer.getNoOfTotalRecords() + intArr[0]);
			dataContainer.setNoOfTotalRecords(dataContainer.getNoOfTotalRecords() + intArr[0]);
			cleanRecords = dataContainer.getNoOfTotalRecords()-intArr[1];
			dataContainer.setNoOfCleanRecords(cleanRecords);
			
		} catch (UnsupportedDataTypeException e) {
			generateErrorLogFile(dataContainer);
			throw new UnsupportedDataTypeException("Unable to process the files! Invalid Data");
		} catch (Exception e) {
			logger.fatal("Unable to read csv file : " + dataContainer.getInputFileName(), e);
			throw new NestableException("Unable to read csv file : " + dataContainer.getInputFileName(), e);
		} finally {
			try {
				if (reader != null) {
					reader.close(); 
				}
				if(recordProcessor.csvWriter != null) recordProcessor.closeFileWriter();
				if(recordProcessor.mappingFileWriter != null) recordProcessor.closeMappingFileWriter();
				
			} catch (Exception e) {
				logger.fatal("Unable to close csv file : " + dataContainer.getInputFileName(), e);
			}
			
		}
	}
	
	/*public void readFile(CSVDataContainer dataContainer) throws OpenXML4JException {
		RecordProcessor recordProcessor = null;
	    try {

	        file = new FileInputStream(new File(dataContainer.getInputFileName()));
	        recordProcessor = new RecordProcessor(dataContainer); 
	        if(dataContainer.getInputFileName().endsWith(SFTPConstants.FILE_EXTENTION_EXCEL)){
		        // Get the workbook instance for XLS file
		        workbook = new HSSFWorkbook(file);
		        // Get first sheet from the workbook
		        sheet = workbook.getSheetAt(0);
	        } else if(dataContainer.getInputFileName().endsWith(SFTPConstants.FILE_EXTENTION_EXCEL_XLSX)){
	        	
	        	OPCPackage pkg = OPCPackage.open(dataContainer.getInputFileName());
	        	XSSFReader r = new XSSFReader( pkg );
	        	
	        	// Get the workbook instance for XLS file
		        workbook = new XSSFWorkbook(file);
		        // Get first sheet from the workbook
		        sheet = workbook.getSheetAt(0);
	        }

	        // Iterate through each rows from first sheet
	        Iterator<Row> rowIterator = sheet.iterator();
	        Integer counter=new Integer(0);
	        Integer skippedRecordsCounter = new Integer(0);
	        int[] intArr = {0,0};
	        while (rowIterator.hasNext()) {
	            Row row = rowIterator.next();
	            // For each row, iterate through each columns
	            Iterator<Cell> cellIterator = row.cellIterator();
	            List<String> cellList=new ArrayList<String>();
	            
	            while (cellIterator.hasNext()) {

	                Cell cell = cellIterator.next();
	                //cellList.add(cell.getStringCellValue());
	                switch (cell.getCellType()) {
	                case Cell.CELL_TYPE_BOOLEAN:
	                	cellList.add((String.valueOf(cell.getBooleanCellValue())));
	                    break;
	                case Cell.CELL_TYPE_NUMERIC:
	                	if(DateUtil.isCellDateFormatted(cell)) {
	                		SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
	                		cellList.add(dateFormat.format(cell.getDateCellValue()));
	                		//cellList.add(new DataFormatter().formatCellValue(cell));
	                	}else {
	                		cellList.add(new DataFormatter().formatCellValue(cell));
	                	}
	                    break;
	                case Cell.CELL_TYPE_STRING:
	                	cellList.add((cell.getStringCellValue() + ""));
	                    break;
	                
	                }
	            }
	           
	            processData(cellList.toArray(new String[0]), dataContainer, intArr , recordProcessor);
	        }
	        dataContainer.setNoOfRecordsProcessed(dataContainer.getNoOfTotalRecords() + intArr[0]);
			dataContainer.setNoOfTotalRecords(dataContainer.getNoOfTotalRecords() + intArr[0]);
			int cleanRecords = dataContainer.getNoOfTotalRecords()-intArr[1];
			dataContainer.setNoOfCleanRecords(cleanRecords);
	        file.close();
	        

	    } catch (FileNotFoundException e1) {
	        e1.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }finally {
			try {
				if(recordProcessor.csvWriter != null) recordProcessor.closeFileWriter();
				if(recordProcessor.mappingFileWriter != null) recordProcessor.closeMappingFileWriter();
				
			} catch (Exception e) {
				logger.fatal("Unable to close csv file : " + dataContainer.getInputFileName(), e);
			}
			
		}
	}*/
	
	public void readFile(CSVDataContainer dataContainer) throws OpenXML4JException {
		
		OPCPackage p = OPCPackage.open(dataContainer.getInputFileName(), PackageAccess.READ);
        int[] intArr = {0,0};
        RecordProcessor recordProcessor = new RecordProcessor(dataContainer); 
        XLSX2CSV xlsx2csv = new XLSX2CSV(p,dataContainer, intArr , recordProcessor);
		try {
			xlsx2csv.process();
			dataContainer.setNoOfRecordsProcessed(dataContainer.getNoOfTotalRecords() + intArr[0]);
			dataContainer.setNoOfTotalRecords(dataContainer.getNoOfTotalRecords() + intArr[0]);
			int cleanRecords = dataContainer.getNoOfTotalRecords()- FilesMasterVO.getInstance(null).getLinesToSkip();
			dataContainer.setNoOfCleanRecords(cleanRecords);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(recordProcessor.csvWriter != null) recordProcessor.closeFileWriter();
				if(recordProcessor.mappingFileWriter != null) recordProcessor.closeMappingFileWriter();
				
			} catch (Exception e) {
				logger.fatal("Unable to close csv file : " + dataContainer.getInputFileName(), e);
			}
			
		}
	}
	
public void readDbfFile(CSVDataContainer dataContainer) throws OpenXML4JException {
		
        int[] intArr = {0,0};
        RecordProcessor recordProcessor = new RecordProcessor(dataContainer); 
        Table table = new Table(new File(dataContainer.getInputFileName()));
        DBFProcessor dbfProcessor = new DBFProcessor();
		try {
			dbfProcessor.getTableData(table,dataContainer, intArr , recordProcessor);
			dataContainer.setNoOfRecordsProcessed(dataContainer.getNoOfTotalRecords() + intArr[0]);
			dataContainer.setNoOfTotalRecords(dataContainer.getNoOfTotalRecords() + intArr[0]);
			int cleanRecords = dataContainer.getNoOfTotalRecords()-intArr[1];
			dataContainer.setNoOfCleanRecords(cleanRecords);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(recordProcessor.csvWriter != null) recordProcessor.closeFileWriter();
				if(recordProcessor.mappingFileWriter != null) recordProcessor.closeMappingFileWriter();
				
			} catch (Exception e) {
				logger.fatal("Unable to close csv file : " + dataContainer.getInputFileName(), e);
			}
			
		}
	}
	
	public void generateErrorLogFile(CSVDataContainer dataContainer) {
		CSVReader reader = null;
		CSVWriter errorWriter=null;
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MMddyyyy-HHmm");
		try {
			String header = dataContainer.getFileMasterVO().getFileNameColumnMap().get(dataContainer.getFileType()).get(0).toString();
			String inputFileName = StringUtils.substringBeforeLast(StringUtils.substringAfterLast(dataContainer.getInputFileName() , "/"), ".");
			//String errFileName = SFTPConstants.PROCESSED_DIRECTORY+"Err"+DATE_FORMAT.format(new Date())+"_"+inputFileName+".csv";
			String errFileName = dataContainer.getFileMasterVO().getProcessedDirName()+"Err"+DATE_FORMAT.format(new Date())+"_"+inputFileName+".csv";
			reader = new CSVReader(new FileReader(dataContainer.getInputFileName()), EscapeChars.TAB.getEscapeChar(), CSVWriter.NO_QUOTE_CHARACTER, dataContainer.getNoOfRecordsProcessed());
			//ErrorFileName.errorFileName = errFileName;
			errorWriter = new CSVWriter(new FileWriter(errFileName),EscapeChars.COMMA.getEscapeChar(), CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.NO_ESCAPE_CHARACTER);
			errorWriter.writeNext(new String[] {"Row number ", "Column number=Invalid data "});
			String nextLine[] = null;	
			int counter = 0, totalErrRec=0;
			List<Integer> arlPosition = dataContainer.getEncryptionPositions();
			List<String> arlPositionDataType = dataContainer.getEncryptionPositionsDataType();
			boolean loop = true;
			while (loop) {
				nextLine = reader.readNext();
				if (nextLine == null || (nextLine.length == 1 && StringUtils.isEmpty(nextLine[0]))) {
					loop = false;
				} else {
					if(counter==0 && StringUtils.equalsIgnoreCase(header, "Y")) {
						counter++;
						continue;
					}
					String data, positionDataType;
					int size = nextLine.length;
					int itrCount = 0;
					String errData = "";
					Iterator<Integer> itr = arlPosition.iterator();
					while (itr.hasNext()) {
						int position = itr.next().intValue();
						if (position >=0 && position < size) {
							data = nextLine[position];
							positionDataType = arlPositionDataType.get(itrCount) != null ? arlPositionDataType.get(itrCount).toString() : SFTPConstants.NUM_DATATYPE;
							if( (positionDataType.equals(SFTPConstants.NUM_DATATYPE) && (data == null || data.equals("") || !StringUtils.isNumeric(data)))) {
								if(!errData.equals("")) errData += " | ";
								errData += String.valueOf(position+1)+"="+data;
							}
							else if( (positionDataType.equals(SFTPConstants.ALPHANUM_DATATYPE) && (data == null || data.equals("") || !StringUtils.isAlphanumeric(data)))) {
								if(!errData.equals("")) errData += " | ";
								errData += String.valueOf(position+1)+"="+data;
							}
						}
						itrCount++;
					}
					if(!errData.equals("")) { // write to error file
						errorWriter.writeNext(new String[] {String.valueOf(counter+1), errData});
						totalErrRec++;
					}
					counter++;
				}
				//ErrorFileName.totalErrorRecords = totalErrRec;
			}
		 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (reader != null) {
					reader.close(); 
				}
				if(errorWriter != null) {
					errorWriter.close();
				}
				
			} catch (Exception e) {
				logger.fatal("Unable to close csv file : " + dataContainer.getInputFileName(), e);
			}
		}
		return;
	}
//	public static void main(String[] args) {
//		FileProcessor processor = new FileProcessor();
//		processor.readFile(null, null);
//	}
}
