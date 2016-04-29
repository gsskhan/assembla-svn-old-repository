package com.citi.retail.optima.etl.batch.job.writer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStream;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.CompositeItemWriter;



import com.citi.retail.optima.etl.common.model.ArrangementTRLRecord;
import com.citi.retail.optima.etl.common.model.CardsTRLRecord;
import com.citi.retail.optima.etl.common.model.CommonBalanceTRLRecord;
import com.citi.retail.optima.etl.common.model.ExcludableRecord;
import com.citi.retail.optima.etl.common.model.PreRainbowRecord;
import com.citi.retail.optima.etl.common.model.RainbowRecord;


public class ConditionalCompositeItemWriter extends
		CompositeItemWriter<ExcludableRecord> implements StepExecutionListener {

	private ItemWriter<? super ExcludableRecord> excludeItemDelegate;

	private Long partitionWriteRecordCount = 0L;
	private Long partitionRejectWriteRecordCount = 0L;
	private StepExecution stepExecution;

	public void write(List<? extends ExcludableRecord> item) throws Exception {
		
		List<ExcludableRecord> excludeList = new ArrayList<ExcludableRecord>();
		List<ExcludableRecord> includeList = new ArrayList<ExcludableRecord>();

		for (ExcludableRecord itemRecord : item) {
			if (itemRecord.geteWriteRecordsToRejects())
				excludeList.add(itemRecord);
			else{
				includeList.add(itemRecord);
				if(itemRecord instanceof CardsTRLRecord){
					saveCBResult((CardsTRLRecord)itemRecord);
				}
				if(itemRecord instanceof RainbowRecord || itemRecord instanceof PreRainbowRecord){
					stepExecution.getJobExecution().getExecutionContext().putString("isAR", "yes");
					saveARResult((CardsTRLRecord)itemRecord);
					calculateEnrCkSum((CardsTRLRecord)itemRecord);
				}
			}
		}

		partitionWriteRecordCount = (long) includeList.size();
		partitionRejectWriteRecordCount = (long) excludeList.size();
		if (excludeItemDelegate != null)
			excludeItemDelegate.write(excludeList);
		super.write(includeList);
		saveWriteCount();
		saveExcludedWriteCount();
	}

	private void saveARResult(CardsTRLRecord itemRecord) {
		ExecutionContext jobExecutionContext = stepExecution.getJobExecution()
				.getExecutionContext();
		  synchronized (jobExecutionContext) {

		Object arSum = jobExecutionContext
				.get("rateVarTypeIdSum");
		Long rateVarTypeSum = 0L;
		if (arSum != null) {
			rateVarTypeSum = (Long) arSum;
		}
		List<ArrangementTRLRecord> arrngRateList = itemRecord.geteArragnmntTRLRecords();
		if(arrngRateList != null && arrngRateList.size() != 0){
			for(ArrangementTRLRecord arRecord : arrngRateList){
				rateVarTypeSum += arRecord.geteRateVarTypId();				
			}
		}
		jobExecutionContext.putLong("rateVarTypeIdSum", rateVarTypeSum);
		  }
	}

	public void setExcludeItemDelegate(
			ItemWriter<? super ExcludableRecord> excludeItemDelegate) {
		this.excludeItemDelegate = excludeItemDelegate;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		super.afterPropertiesSet();
	}

	@Override
	public void open(ExecutionContext executionContext)
			throws ItemStreamException {
		super.open(executionContext);
		if (excludeItemDelegate != null)
			((ItemStream) excludeItemDelegate).open(executionContext);
	}

	@Override
	public void close() throws ItemStreamException {
		super.close();
		if (excludeItemDelegate != null)
			((ItemStream) excludeItemDelegate).close();
	}

	@BeforeStep
	public void beforeStep(StepExecution stepExecution) {
		this.stepExecution = stepExecution;
	}

	@AfterStep
	public ExitStatus afterStep(StepExecution stepExecution) {
		return null;
	}

	private void saveWriteCount() {
		ExecutionContext jobExecutionContext = stepExecution.getJobExecution()
				.getExecutionContext();
		synchronized(jobExecutionContext){
			Object objWriteRecordCount = jobExecutionContext
					.get("writeRecordCount");
			Long writeRecordCount = 0L;
			if (objWriteRecordCount != null) {
				writeRecordCount = (Long) objWriteRecordCount;
			}
			writeRecordCount += partitionWriteRecordCount;
			jobExecutionContext.putLong("writeRecordCount", writeRecordCount);
		}
	}
	private void saveExcludedWriteCount() {
		ExecutionContext jobExecutionContext = stepExecution.getJobExecution()
				.getExecutionContext();
		Object objWriteRecordCount = jobExecutionContext
				.get("eWriteRejectCount");
		Long writeRecordCount = 0L;
		if (objWriteRecordCount != null) {
			writeRecordCount = (Long) objWriteRecordCount;
		}
		writeRecordCount += partitionRejectWriteRecordCount;
		jobExecutionContext.putLong("eWriteRejectCount", writeRecordCount);
	}
	public StepExecution getStepExecution() {
		return stepExecution;
	}

	public void setStepExecution(StepExecution stepExecution) {
		this.stepExecution = stepExecution;
	}
	
	private void saveCBResult(CardsTRLRecord itemRecord) {
		ExecutionContext jobExecutionContext = stepExecution.getJobExecution()
				.getExecutionContext();
		  synchronized (jobExecutionContext) {

		Object balTypeSum = jobExecutionContext
				.get("commonBalanceSum");
		
		Long balType = 0L;
		if (balTypeSum != null) {
			balType = (Long) balTypeSum;			
		}
		List<CommonBalanceTRLRecord> commonBalanceList = itemRecord.geteCommonBalTRLRecords();
		if(commonBalanceList != null && commonBalanceList.size() != 0){
			for(CommonBalanceTRLRecord cbRecord : commonBalanceList){
				balType += cbRecord.geteBalType();	
			}
		}
		jobExecutionContext.putLong("commonBalanceSum", balType);
		
		  }
	}
	
	private void calculateEnrCkSum(CardsTRLRecord itemRecord){
		ExecutionContext jobExecutionContext = stepExecution.getJobExecution()
				.getExecutionContext();
		  synchronized (jobExecutionContext) {
		Object enrInputCheckSum = jobExecutionContext.get("twEnrInputCheckSum");
		BigDecimal twPlEnrCksumExisted = new BigDecimal(0);
		if(enrInputCheckSum != null){
			twPlEnrCksumExisted = (BigDecimal) enrInputCheckSum;
		}
		List<CommonBalanceTRLRecord> commonBalanceList = itemRecord.geteCommonBalTRLRecords();
		if(commonBalanceList != null && commonBalanceList.size() != 0){
			for(CommonBalanceTRLRecord cbRecord : commonBalanceList){
				
				if(cbRecord.geteBalType() == 265){
					twPlEnrCksumExisted = twPlEnrCksumExisted.add(cbRecord.geteTxnAmt());
				}
			}
		}
		jobExecutionContext.put("twEnrInputCheckSum", twPlEnrCksumExisted);
		
		  }
	}
}
