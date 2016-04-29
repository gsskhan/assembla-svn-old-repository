package com.citi.optima.retail.batch.listeners;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.core.annotation.OnProcessError;
import org.springframework.batch.core.annotation.OnReadError;
import org.springframework.batch.core.annotation.OnSkipInWrite;

import com.citi.retail.optima.etl.batch.report.ErrorReportHandler;
import com.citi.retail.optima.etl.common.ETLConstants;
import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.exception.ExceptionHandler;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.OptimaRetailDataException;
import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;
import com.citi.retail.optima.etl.common.model.UserSubmissionBaseRecord;
import com.citi.retail.optima.etl.common.model.UserSubmissionCCARRecord;
import com.citi.retail.optima.etl.data.ErrorDataHolderService;

public class ItemErrorListener {

	private ExceptionHandler exceptionHandler;
//	private Map<String, OptimaRetailDataException> errorCollection;
	private ErrorReportHandler errorReportHandler;
	private StepExecution lstepExecution;
	private Long batchInstId;
	private String srcId;
	private String fileReader;
	private ErrorDataHolderService dataHolderService;
	
	int i = 0;

	@BeforeStep
	public void stepExecutionSetter(StepExecution stepExecution) {

		lstepExecution = stepExecution;
		fileReader = stepExecution.getJobExecution().getExecutionContext()
				.getString("fileReader");
		batchInstId = stepExecution.getJobExecution().getJobInstance()
				.getJobParameters().getLong(ETLConstants.BATCH_INSTANCE_ID);
	}

	@OnReadError
	public void onReadError(Exception readException) {
		OptimaRetailDataException optimaRetailDataException = new OptimaRetailDataException(
				ServiceName.BATCH, ExceptionType.ERROR);

		handleException(new OptimaRetailApplicationException(null, batchInstId,
				null, ServiceName.BATCH, ExceptionType.FATAL,
				"Error in Item Reader", readException.getMessage(),
				OptimaRetailExceptionUtil.getStackTrace(readException),
				optimaRetailDataException,null));
	}

	@OnProcessError
	public void onProcessError(UserSubmissionCCARRecord item,
			OptimaRetailDataException exception) {
		i++;
		if (exception.getServiceName() != ServiceName.VALIDATION) {
			handleException(new OptimaRetailApplicationException(null,
					batchInstId, null, ServiceName.BATCH, ExceptionType.FATAL,
					"Error in Item Reader", exception.getMessage(),
					OptimaRetailExceptionUtil.getStackTrace(exception),
					exception,null));
		} else {
			if (fileReader.equalsIgnoreCase("csvReader")) {
				if (!lstepExecution.getJobExecution().getExecutionContext()
						.containsKey("header")) {
					lstepExecution.getJobExecution().getExecutionContext()
							.put("header", item.inputRecordHeader());
				}

				dataHolderService.getErrorMapByBatchInstanceId(batchInstId).put(item.inputRecordString(), exception);
			} else {
				if (!lstepExecution.getJobExecution().getExecutionContext()
						.containsKey("header")) {
					lstepExecution.getJobExecution().getExecutionContext()
							.put("header", item.inputRecordHeader());
				}
				dataHolderService.getErrorMapByBatchInstanceId(batchInstId).put(item.inputRecordString(), exception);
			}
		}
	}

	@AfterStep
	public synchronized ExitStatus handleErrorBolbCreation(
			StepExecution stepExecution) throws Exception {

		if (dataHolderService.getErrorMapByBatchInstanceId(batchInstId) != null && dataHolderService.getErrorMapByBatchInstanceId(batchInstId).size() != 0) {
			return ExitStatus.FAILED;
		}

		return ExitStatus.COMPLETED;
	}

	@OnSkipInWrite
	public void onSkipInWrite(Object item, Exception exception) {
		OptimaRetailDataException optimaRetailDataException = new OptimaRetailDataException(
				ServiceName.BATCH, ExceptionType.ERROR,
				((UserSubmissionBaseRecord) item).getRowId().longValue());
		handleException(new OptimaRetailApplicationException(null, batchInstId,
				null, ServiceName.BATCH, ExceptionType.FATAL,
				"Error in Item Reader", exception.getMessage(),
				OptimaRetailExceptionUtil.getStackTrace(exception),
				optimaRetailDataException,null));
	}

	private void handleException(OptimaRetailApplicationException exception) {
		exceptionHandler.handleException(exception);
	}

	/**
	 * @return the exceptionHandler
	 */
	public ExceptionHandler getExceptionHandler() {
		return exceptionHandler;
	}

	/**
	 * @param exceptionHandler
	 *            the exceptionHandler to set
	 */
	public void setExceptionHandler(ExceptionHandler exceptionHandler) {
		this.exceptionHandler = exceptionHandler;
	}

	/**
	 * @return the batchInstId
	 */
	public Long getBatchInstId() {
		return batchInstId;
	}

	/**
	 * @param batchInstId
	 *            the batchInstId to set
	 */
	public void setBatchInstId(Long batchInstId) {
		this.batchInstId = batchInstId;
	}

	/**
	 * @return the srcId
	 */
	public String getSrcId() {
		return srcId;
	}

	/**
	 * @param srcId
	 *            the srcId to set
	 */
	public void setSrcId(String srcId) {
		this.srcId = srcId;
	}

	public void setErrorReportHandler(ErrorReportHandler errorReportHandler) {
		this.errorReportHandler = errorReportHandler;
	}

/*	public void setErrorCollection(
			Map<String, OptimaRetailDataException> errorCollection) {
		this.errorCollection = errorCollection;
	}*/

	/**
	 * @param dataHolderService the dataHolderService to set
	 */
	public void setDataHolderService(ErrorDataHolderService dataHolderService) {
		this.dataHolderService = dataHolderService;
	}

}
