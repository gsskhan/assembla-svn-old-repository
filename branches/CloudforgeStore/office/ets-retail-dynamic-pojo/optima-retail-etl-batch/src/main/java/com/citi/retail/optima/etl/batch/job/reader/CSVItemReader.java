package com.citi.retail.optima.etl.batch.job.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.citi.retail.optima.etl.batch.dao.BatchJobInstanceDao;
import com.citi.retail.optima.etl.batch.report.ErrorDataServiceFactory;
import com.citi.retail.optima.etl.batch.report.ErrorReportDataService;
import com.citi.retail.optima.etl.batch.report.ErrorReportHandler;
import com.citi.retail.optima.etl.common.ETLConstants;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.OptimaRetailDataException;
import com.citi.retail.optima.etl.common.exception.OptimaRetailDataExceptionDetail;
import com.citi.retail.optima.etl.fileintegrity.FileIntegrityService;

public class CSVItemReader<T> implements ItemReader<T> {

	private BatchJobInstanceDao batchInstanceDao;
	private JdbcTemplate jdbcTemplate;

	private BufferedReader bufReader;

	private DefaultLineMapper lineMapper;
	private ErrorReportHandler errorReportHandler;

	private FileIntegrityService fileScannerService;

	private Map<String, OptimaRetailDataException> inputErrorCollection;

	private List<String> inputDataList;

	private ErrorDataServiceFactory preProcessorFactory;

	private String dataServiceName;

	private ErrorReportDataService errorReportService;

	private final StringBuffer headerString = new StringBuffer();
	private final StringBuffer headerError = new StringBuffer();

	private String sql;

	int i = 0;

	boolean readErrorFound = false;

	public void setPreProcessorFactory(
			ErrorDataServiceFactory preProcessorFactory) {
		this.preProcessorFactory = preProcessorFactory;
	}

	public void setErrorReportHandler(ErrorReportHandler errorReportHandler) {
		this.errorReportHandler = errorReportHandler;
	}

	@SuppressWarnings("unchecked")
	@BeforeStep
	public void getBlobData(StepExecution stepExecution) throws SQLException,
			ClassNotFoundException, InstantiationException,
			IllegalAccessException {

		if (stepExecution.getJobExecution().getExecutionContext()
				.get(ETLConstants.FILE_READER).toString()
				.equalsIgnoreCase("csvreader")) {

			initiateErrorReportService(stepExecution);

			List<Blob> bFile = jdbcTemplate.query(sql, new RowMapper<Blob>() {

				@Override
				public Blob mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					return rs.getBlob(1);
				}
			});

			if (bFile != null && bFile.size() > 0) {
				bufReader = new BufferedReader(new InputStreamReader(bFile.get(
						0).getBinaryStream()));
			}

		}

	}

	private void initiateErrorReportService(StepExecution stepExecution)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {

		errorReportService = preProcessorFactory.getErrorReportDataService(
				stepExecution.getJobParameters().getLong("batchInstanceId"),
				dataServiceName);

		inputErrorCollection = errorReportService
				.getLocalErrorDataServiceMap("csvReader");

		inputDataList = errorReportService
				.getLocalErrorDataServiceList("csvReader");

	}

	@Override
	public T read() throws OptimaRetailApplicationException,
			UnexpectedInputException, ParseException,
			NonTransientResourceException, Exception {

		T record = null;
		String lineStr = bufReader.readLine();

		try {
			if (i == 0) {
				headerString.append(lineStr);
				if (lineStr != null) {
					inputDataList.add(i, lineStr);
				}
				fileScannerService.validate(lineStr, i);
				lineStr = bufReader.readLine();
				i++;
			}

			if (lineStr == null || lineStr.equals("null")) {
				i++;
				record = null;
			} else {
				inputDataList.add(i, lineStr);
				fileScannerService.validate(lineStr, i);
				record = (T) lineMapper.mapLine(lineStr, 1);
				i++;
			}

		} catch (OptimaRetailDataException orException) {
			readErrorFound = true;
			if (i == 0) {
				for (OptimaRetailDataExceptionDetail exceptionDetail : orException
						.getOptimaRetailSkippableList()) {
					headerError.append(exceptionDetail.getExceptionMessage());
					headerError.append(";");
				}

				inputErrorCollection.put(lineStr, orException);
			} else {
				inputErrorCollection.put(lineStr, orException);
			}
			i++;

			throw orException;
		}
		return record;
	}

	@AfterStep
	public ExitStatus handleErrorBolbCreation(StepExecution stepExecution)
			throws Exception {
		if (stepExecution.getJobExecution().getExecutionContext()
				.get(ETLConstants.FILE_READER).toString()
				.equalsIgnoreCase("csvReader")) {
			if (inputErrorCollection != null
					&& inputErrorCollection.size() != 0
					&& readErrorFound == true) {
				File fileBlob = errorReportHandler.createCSVErrorReport1(
						inputDataList, inputErrorCollection,
						headerError.toString(), headerString.toString());
				inputErrorCollection.clear();
				return ExitStatus.FAILED;
			}
		}
		return ExitStatus.COMPLETED;
	}

	

	/**
	 * @return the fileScannerService
	 */
	public FileIntegrityService getFileScannerService() {
		return fileScannerService;
	}

	/**
	 * @param fileScannerService the fileScannerService to set
	 */
	public void setFileScannerService(FileIntegrityService fileScannerService) {
		this.fileScannerService = fileScannerService;
	}

	public DefaultLineMapper getLineMapper() {
		return lineMapper;
	}

	public void setLineMapper(DefaultLineMapper lineMapper) {
		this.lineMapper = lineMapper;
	}

	public Map<String, OptimaRetailDataException> getInputErrorCollection() {
		return inputErrorCollection;
	}

	public void setInputErrorCollection(
			Map<String, OptimaRetailDataException> inputErrorCollection) {
		this.inputErrorCollection = inputErrorCollection;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public void setBatchInstanceDao(BatchJobInstanceDao batchInstanceDao) {
		this.batchInstanceDao = batchInstanceDao;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setDataServiceName(String dataServiceName) {
		this.dataServiceName = dataServiceName;
	}

}