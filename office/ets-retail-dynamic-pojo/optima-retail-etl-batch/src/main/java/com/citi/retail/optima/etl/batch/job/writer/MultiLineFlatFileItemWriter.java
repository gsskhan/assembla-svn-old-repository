package com.citi.retail.optima.etl.batch.job.writer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import com.citi.retail.optima.etl.common.model.GclTRLRecord;
import com.citi.retail.optima.etl.common.model.OreoTRLRecord;

public class MultiLineFlatFileItemWriter<T> extends FlatFileItemWriter<T> implements StepExecutionListener{
	
	private String attrName;
	
	private Long partitionWriteRecordCount = 0L;

	private StepExecution stepExecution;
	
	private String inMtgProduct;

	
	public MultiLineFlatFileItemWriter(){
		super();
	}
	
	public String getAttrName() {
		return attrName;
	}

	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}

	@Override
	public void write(List<? extends T> items) throws Exception {
		List internalItems = new ArrayList();;
		for(T item:items){			
			final BeanWrapper bw = new BeanWrapperImpl(item);
			List listValue = (List)bw.getPropertyValue(attrName);
			if(listValue != null && listValue.size() > 0) {
				internalItems.addAll(listValue);
			}
			if((item instanceof OreoTRLRecord) || (item.getClass().getSimpleName().contains("InMtg")) || (item instanceof GclTRLRecord)){
				this.inMtgProduct = "IN-MTG";
			}
		}
		partitionWriteRecordCount = ((Integer)internalItems.size()).longValue();
		super.write(internalItems);
		if(attrName != null && attrName.equalsIgnoreCase("eArragnmntTRLRecords")){
			saveARWriteCount();
		}
		else{
			saveCbWriteCount();
		}
	}

	private void saveCbWriteCount() {
		if(stepExecution != null){
			ExecutionContext jobExecutionContext = stepExecution.getJobExecution()
					.getExecutionContext();
			synchronized(jobExecutionContext){
				Long cbWriteRecordCount = 0L;
				if(inMtgProduct != null && inMtgProduct.equalsIgnoreCase("IN-MTG")){
					Object inMtgCbWriteRecordCount = jobExecutionContext
							.get("inMtgCbWriteRecordCount");
					if (inMtgCbWriteRecordCount != null) {
						cbWriteRecordCount = (Long) inMtgCbWriteRecordCount;
					}
				}
				else{
					Object objWriteRecordCount = jobExecutionContext
							.get("cbWriteRecordCount");
					if (objWriteRecordCount != null) {
						cbWriteRecordCount = (Long) objWriteRecordCount;
					}
				}
					cbWriteRecordCount += partitionWriteRecordCount;
					jobExecutionContext.putLong("cbWriteRecordCount", cbWriteRecordCount);
					jobExecutionContext.putLong("inMtgCbWriteRecordCount", cbWriteRecordCount);
			}
		}
		
	}
	
	private void saveARWriteCount() {
		if(stepExecution != null){
			ExecutionContext jobExecutionContext = stepExecution.getJobExecution()
					.getExecutionContext();
			synchronized(jobExecutionContext){
				Long arWriteRecordCount = 0L;
					Object objWriteRecordCount = jobExecutionContext
							.get("arWriteRecordCount");
					if (objWriteRecordCount != null) {
						arWriteRecordCount = (Long) objWriteRecordCount;
					}
					arWriteRecordCount += partitionWriteRecordCount;
					jobExecutionContext.putLong("arWriteRecordCount", arWriteRecordCount);
		}
		}
		
	}


	public StepExecution getStepExecution() {
		return stepExecution;
	}

	public void setStepExecution(StepExecution stepExecution) {
		this.stepExecution = stepExecution;
	}

	@BeforeStep
	public void beforeStep(StepExecution stepExecution) {
		this.stepExecution = stepExecution;
	}

	@AfterStep
	public ExitStatus afterStep(StepExecution stepExecution) {
		return null;
	}

	public String getInMtgProduct() {
		return inMtgProduct;
	}

	public void setInMtgProduct(String inMtgProduct) {
		this.inMtgProduct = inMtgProduct;
	}
	
	
}
