package com.citi.retail.optima.etl.batch.report;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.citi.retail.optima.etl.common.ETLConstants;
import com.citi.retail.optima.etl.common.exception.OptimaRetailDataException;
import com.citi.retail.optima.etl.common.exception.OptimaRetailDataExceptionDetail;

public class ErrorReportHandler {

	public File createCSVErrorReport1(List<String> inputDataList,
			Map<String, OptimaRetailDataException> inputErrorCollection,
			String headerError, String headerString) throws IOException {

		BufferedWriter bufferedWriter = null;

		try {
			if (inputErrorCollection.size() != 0 || headerError != null) {

				File fileBlob = new File("error_file_"
						+ System.currentTimeMillis() + ".csv");

				bufferedWriter = new BufferedWriter(new FileWriter(fileBlob));

				inputErrorCollection.keySet();

				bufferedWriter.write(headerString);
				bufferedWriter.append(headerError != null
						&& !headerError.isEmpty() ? "," + headerError
						: ",Exception");
				bufferedWriter.newLine();

				int cnt = 0;
				for (int i = 0; i < inputDataList.size(); i++) {

					String inputRow = inputDataList.get(i);
					if (cnt == 0) {
						cnt++;
						continue;
					}
					cnt++;
					StringBuffer exceptionMessageBuilder = convertExceptionListToString(
							inputRow, inputErrorCollection);

					bufferedWriter.write(inputRow
							+ ","
							+ exceptionMessageBuilder.substring(0,
									exceptionMessageBuilder.length() - 1));
					bufferedWriter.newLine();
				}

				return fileBlob;
			}
		} finally {
			if (bufferedWriter != null) {
				bufferedWriter.close();
			}
		}
		return null;
	}

	// not used
	@Deprecated
	public File createCSVErrorReport(
			Map<String, OptimaRetailDataException> inputErrorCollection,
			String headerError, String headerString) throws IOException {
		if (inputErrorCollection.size() != 0 || headerError != null) {

			File fileBlob = new File("error_file_" + System.currentTimeMillis()
					+ ".csv");

			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(
					fileBlob));

			Set<String> inputRowSet = inputErrorCollection.keySet();

			bufferedWriter.write(headerString
					+ (headerError != null ? "," + headerError : ""));
			bufferedWriter.newLine();

			for (String inputRow : inputRowSet) {

				StringBuffer exceptionMessageBuilder = convertExceptionListToString(
						inputRow, inputErrorCollection);

				bufferedWriter.write(inputRow
						+ ","
						+ exceptionMessageBuilder.substring(0,
								exceptionMessageBuilder.length() - 1));
				bufferedWriter.newLine();
			}

			bufferedWriter.close();
			return fileBlob;
		}
		return null;
	}

	private StringBuffer convertExceptionListToString(String errorKey,
			Map<String, OptimaRetailDataException> inputErrorCollection) {
		OptimaRetailDataException optimaRetailException;
		StringBuffer exceptionMessageBuilder = new StringBuffer();
		if (errorKey != null) {
			optimaRetailException = inputErrorCollection.get(errorKey);

			if (optimaRetailException != null
					&& optimaRetailException.getOptimaRetailSkippableList() != null) {
				for (OptimaRetailDataExceptionDetail exceptionDetail : optimaRetailException
						.getOptimaRetailSkippableList()) {
					exceptionMessageBuilder.append(exceptionDetail
							.getUserErrorMessage());
					exceptionMessageBuilder.append(";");
				}
			} else {
				exceptionMessageBuilder.append(' ');
			}
		}
		return exceptionMessageBuilder.append(' ');
	}

	public Workbook createXlsErrorReport(Sheet sheet,
			Map<Integer, OptimaRetailDataException> inputErrorCollection,
			String headerString) {

		Workbook errorWorkbook = new XSSFWorkbook();
		Sheet errorSheet = errorWorkbook.createSheet();
		Integer rowCounter = 0;
		int cellCounter = 0;
		Row inputRow;
		Row errorRow;
		String errorString;
		Set<Integer> errorKeySet = inputErrorCollection.keySet();

		String[] header = headerString.split(",");

		errorRow = errorSheet.createRow(rowCounter);

		Cell headerCell;

		for (String hearderValue : header) {
			headerCell = errorRow.createCell(cellCounter);
			headerCell.setCellValue(hearderValue.toString());
			cellCounter++;
		}

		rowCounter++;

		for (Integer errorKey : errorKeySet) {

			errorRow = errorSheet.createRow(rowCounter);

			errorString = convertXLSExceptionToString(errorKey,
					inputErrorCollection);

			inputRow = sheet.getRow(errorKey);
			inputRow.iterator();

			cellCounter = 0;
			Cell inputCell;
			Cell outputCell;
			for (int cn = 0; cn < inputRow.getLastCellNum(); cn++) {
				inputCell = inputRow.getCell(cn, Row.RETURN_BLANK_AS_NULL);
				outputCell = errorRow.createCell(cellCounter);
				if (inputCell == null) {
					outputCell.setCellValue(" ");
				} else {
					outputCell.setCellValue(getCellValue(inputCell));
				}
				cellCounter++;
			}
			outputCell = errorRow.createCell(cellCounter);
			outputCell.setCellValue(errorString);

			rowCounter++;
		}
		return errorWorkbook;
	}

	public Workbook createXlsErrorReport(
			Map<String, OptimaRetailDataException> inputErrorCollection,
			String headerString) {

		Workbook errorWorkbook = new XSSFWorkbook();
		Sheet errorSheet = errorWorkbook.createSheet();
		Integer rowCounter = 0;
		String errorString;
		Set<String> errorKeySet = inputErrorCollection.keySet();

		String[] header = headerString.split(",");

		Row errorRow = errorSheet.createRow(rowCounter);

		int cellCounter = 0;
		Cell headerCell;

		for (String hearderValue : header) {
			headerCell = errorRow.createCell(cellCounter);
			headerCell.setCellValue(hearderValue.toString());
			cellCounter++;
		}

		rowCounter++;

		for (String errorKey : errorKeySet) {

			String[] errorInput = errorKey.toString().split(",");

			Cell inputCell;
			cellCounter = 0;

			errorRow = errorSheet.createRow(rowCounter);

			for (String cellValue : errorInput) {
				inputCell = errorRow.createCell(cellCounter);
				if (cellValue == null || cellValue.equalsIgnoreCase("null")) {
					inputCell.setCellValue(cellValue.toString());
				} else {
					inputCell.setCellValue(cellValue.toString());
				}

				cellCounter++;
			}

			errorString = convertXLSExceptionToString(errorKey,
					inputErrorCollection);

			inputCell = errorRow.createCell(cellCounter);
			inputCell.setCellValue(errorString);

			rowCounter++;
		}

		return errorWorkbook;
	}

	// called from xlsreader
	public Workbook createXlsErrorReport1(Sheet sheet,
			Map<String, OptimaRetailDataException> inputErrorCollection,
			String headerString, String headerError) {
		Workbook errorWorkbook = new XSSFWorkbook();
		Sheet errorSheet = errorWorkbook.createSheet();
		Integer rowCounter = 0;
		int cellCounter = 0;
		Row errorRow;
		String errorString;
		Set<String> errorKeySet = inputErrorCollection.keySet();

		String[] header = headerString.split(",");

		errorRow = errorSheet.createRow(rowCounter);

		Cell headerCell;

		for (String hearderValue : header) {
			headerCell = errorRow.createCell(cellCounter);
			headerCell.setCellValue(hearderValue.toString());
			cellCounter++;
		}
		headerCell = errorRow.createCell(cellCounter);
		if (headerError != null && !headerError.isEmpty()) {
			headerCell.setCellValue(headerError.toString());
		} else {
			headerCell.setCellValue("Exception");
		}

		rowCounter++;
		Iterator<Row> it = sheet.rowIterator();
		it.next();

		while (it.hasNext()) {
			Row row = it.next();
			cellCounter = 0;
			Cell inputCell;
			Cell outputCell;
			errorRow = errorSheet.createRow(rowCounter);
			for (int cn = 0; cn < row.getLastCellNum(); cn++) {
				inputCell = row.getCell(cn, Row.RETURN_BLANK_AS_NULL);
				outputCell = errorRow.createCell(cellCounter);
				if (inputCell == null) {
					outputCell.setCellValue(" ");
				} else {
					outputCell.setCellValue(getCellValue(inputCell));
				}
				cellCounter++;
			}
			if (errorKeySet.contains(String.valueOf(rowCounter))) {
				errorString = convertXLSExceptionToString(
						String.valueOf(rowCounter), inputErrorCollection);
				outputCell = errorRow.createCell(cellCounter);
				outputCell.setCellValue(errorString);
			}
			rowCounter++;
		}

		return errorWorkbook;

	}

	private String convertXLSExceptionToString(Integer errorKey,
			Map<Integer, OptimaRetailDataException> inputErrorCollection) {
		OptimaRetailDataException optimaRetailException;
		StringBuffer exceptionMessageBuilder = new StringBuffer();
		optimaRetailException = inputErrorCollection.get(errorKey);

		for (OptimaRetailDataExceptionDetail exceptionDetail : optimaRetailException
				.getOptimaRetailSkippableList()) {
			exceptionMessageBuilder.append(exceptionDetail
					.getUserErrorMessage());
			exceptionMessageBuilder.append(";");
		}
		return exceptionMessageBuilder.toString();
	}

	private String convertXLSExceptionToString(String errorKey,
			Map<String, OptimaRetailDataException> inputErrorCollection) {
		OptimaRetailDataException optimaRetailException;
		StringBuffer exceptionMessageBuilder = new StringBuffer();
		optimaRetailException = inputErrorCollection.get(errorKey.trim());
		if (optimaRetailException != null) {
			for (OptimaRetailDataExceptionDetail exceptionDetail : optimaRetailException
					.getOptimaRetailSkippableList()) {
				exceptionMessageBuilder.append(exceptionDetail
						.getUserErrorMessage());
				exceptionMessageBuilder.append(";");
			}
		}
		return exceptionMessageBuilder.toString();
	}

	public static String getCellValue(Cell cell) {
		if (cell == null) {
			return " ";
		}
		String val = "";
		BigDecimal dec = BigDecimal.ZERO;
		if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
			return cell.getStringCellValue().trim();
		} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			if (DateUtil.isCellDateFormatted(cell)) {
				DateFormat dateFormat = new SimpleDateFormat(
						ETLConstants.INTERNAL_DATE_FORMAT);

				Date internalDate = DateUtil.getJavaDate(
						cell.getNumericCellValue());
				String format = dateFormat.format(internalDate);

				return format;
			} else {
				val = cell.getNumericCellValue() + "";
				if (val.contains("E") || val.contains("e")) {
					dec = new BigDecimal(val);
					BigDecimal roundoff = dec.setScale(2,
							BigDecimal.ROUND_HALF_EVEN);
					return "" + roundoff;
				} else if (val.endsWith(".0")) {
					return val.replace(".0", "");
				} else {
					return val;
				}
			}

		} else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
			return cell.getBooleanCellValue() + "";
		} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
			return cell.getStringCellValue().trim();
		} else if (cell.getCellType() == Cell.CELL_TYPE_ERROR) {
			return cell.getErrorCellValue() + "";
		} else {
			return null;
		}
	}

	// called from listener
	public Workbook createXlsErrorReport2(List<String> inputData,
			Map<String, OptimaRetailDataException> inputErrorCollection,
			String headerString, String headerError) {

		Workbook errorWorkbook = new XSSFWorkbook();
		Sheet errorSheet = errorWorkbook.createSheet();
		Integer rowCounter = 0;
		String errorString;
		inputErrorCollection.keySet();

		String[] header = headerString.split(",");

		Row errorRow = errorSheet.createRow(rowCounter);

		int cellCounter = 0;
		Cell headerCell;

		for (String hearderValue : header) {
			headerCell = errorRow.createCell(cellCounter);
			headerCell.setCellValue(hearderValue.toString());
			cellCounter++;
		}
		headerCell = errorRow.createCell(cellCounter);
		if (headerError != null && !headerError.isEmpty()) {
			headerCell.setCellValue(headerError.toString());
		} else {
			headerCell.setCellValue("Exception");
		}

		rowCounter++;
		int cnt = 0;
		for (String errorKey : inputData) {
			if (cnt == 0) {
				cnt++;
				continue;
			}
			cnt++;
			String[] errorInput = errorKey.toString().split(",", header.length);

			Cell inputCell;
			cellCounter = 0;

			errorRow = errorSheet.createRow(rowCounter);

			for (String cellValue : errorInput) {
				inputCell = errorRow.createCell(cellCounter);
				if (cellValue == null || cellValue.equalsIgnoreCase("null")) {
					inputCell.setCellValue(cellValue.toString());
				} else {
					inputCell.setCellValue(cellValue.toString());
				}

				cellCounter++;
			}

			errorString = convertXLSExceptionToString(errorKey,
					inputErrorCollection);

			inputCell = errorRow.createCell(cellCounter);
			inputCell.setCellValue(errorString);

			rowCounter++;
		}

		return errorWorkbook;
	}

}
