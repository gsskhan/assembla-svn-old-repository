package com.citi.retail.optima.etl.batch.job.reader;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.file.FlatFileItemReader;

import com.citi.retail.optima.etl.common.ETLConstants;

public class CustomItemReader<T> extends FlatFileItemReader<T> implements StepExecutionListener{
	
	private String fileName;
	private StepExecution stepExecution;
	
	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the stepExecution
	 */
	public StepExecution getStepExecution() {
		return stepExecution;
	}

	/**
	 * @param stepExecution the stepExecution to set
	 */
	public void setStepExecution(StepExecution stepExecution) {
		this.stepExecution = stepExecution;
	}

	@Override
	public void beforeStep(StepExecution stepExecution) {
		this.stepExecution = stepExecution;
		if(!System.getProperty("os.name").toLowerCase().contains("win")){
			if(fileName.contains("SPLIT_00")){
				if(stepExecution.getJobParameters().getString(ETLConstants.COUNTRY_CODE).equalsIgnoreCase("in") && stepExecution.getJobParameters().getString(ETLConstants.PRODUCT_CODE).equalsIgnoreCase("mtg")){
					this.setLinesToSkip(2);
				}
				else{
					this.setLinesToSkip(1);
				}
			}
		}
		else{
				if(stepExecution.getJobParameters().getString(ETLConstants.COUNTRY_CODE).equalsIgnoreCase("in") && stepExecution.getJobParameters().getString(ETLConstants.PRODUCT_CODE).equalsIgnoreCase("mtg")){
					this.setLinesToSkip(2);
				}
				else{
					this.setLinesToSkip(1);
				}
			}
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		// TODO Auto-generated method stub
		return null;
	}

}
