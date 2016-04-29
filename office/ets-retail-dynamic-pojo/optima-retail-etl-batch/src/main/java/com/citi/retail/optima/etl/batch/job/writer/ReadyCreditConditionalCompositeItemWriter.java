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
import com.citi.retail.optima.etl.common.model.ArrangementTRLTwRcRecord;
import com.citi.retail.optima.etl.common.model.CardsTRLRecord;
import com.citi.retail.optima.etl.common.model.CommonBalanceRcTRLRecord;
import com.citi.retail.optima.etl.common.model.CommonBalanceTRLRecord;
import com.citi.retail.optima.etl.common.model.InRcTRLRecord;
import com.citi.retail.optima.etl.common.model.PreRainbowRecord;
import com.citi.retail.optima.etl.common.model.RainbowRecord;
import com.citi.retail.optima.etl.common.model.TwRcPostRainbowRecord;
import com.citi.retail.optima.etl.common.model.TwRcPreRainbowRecord;

public class ReadyCreditConditionalCompositeItemWriter extends
CompositeItemWriter<InRcTRLRecord> implements StepExecutionListener {

	private ItemWriter<? super InRcTRLRecord> excludeItemDelegate;

	private Long partitionWriteRecordCount = 0L;

	private StepExecution stepExecution;

	public void write(List<? extends InRcTRLRecord> item) throws Exception {
		
		List<InRcTRLRecord> includeList = new ArrayList<InRcTRLRecord>();

		for (InRcTRLRecord itemRecord : item) {
			includeList.add(itemRecord);
			saveCBResult(itemRecord);
			if(itemRecord instanceof  TwRcPreRainbowRecord|| itemRecord instanceof TwRcPostRainbowRecord){
				stepExecution.getJobExecution().getExecutionContext().putString("isAR", "yes");
				saveARResult((InRcTRLRecord)itemRecord);
				calculateEnrCkSum((InRcTRLRecord)itemRecord);
			}
		}

		partitionWriteRecordCount = (long) includeList.size();
		super.write(includeList);
		saveWriteCount();
	}

	public void setExcludeItemDelegate(
			ItemWriter<? super InRcTRLRecord> excludeItemDelegate) {
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

	public StepExecution getStepExecution() {
		return stepExecution;
	}

	public void setStepExecution(StepExecution stepExecution) {
		this.stepExecution = stepExecution;
	}	
	
	private void saveCBResult(InRcTRLRecord itemRecord) {
		ExecutionContext jobExecutionContext = stepExecution.getJobExecution()
				.getExecutionContext();
		synchronized (jobExecutionContext) {
		Object balTypeSum = jobExecutionContext
				.get("commonBalanceSum");
		
		Long balType = 0L;
		if (balTypeSum != null) {
			balType = (Long) balTypeSum;
		}
		List<CommonBalanceRcTRLRecord> commonBalanceList = itemRecord.geteCommonBalanceRcTRLRecords();
		if(commonBalanceList != null && commonBalanceList.size() != 0){
			for(CommonBalanceRcTRLRecord cbRecord : commonBalanceList){
				balType += cbRecord.geteBalType();
			}
		}
		jobExecutionContext.putLong("commonBalanceSum", balType);
		}
	}
	
	private void saveARResult(InRcTRLRecord itemRecord) {
		ExecutionContext jobExecutionContext = stepExecution.getJobExecution()
				.getExecutionContext();
		synchronized (jobExecutionContext) {
		Object arSum = jobExecutionContext
				.get("rateVarTypeIdSum");
		
		Long rateVarTypeSum = 0L;
		if (arSum != null) {
			rateVarTypeSum = (Long) arSum;
		}
		List<ArrangementTRLTwRcRecord> arrngRateList = itemRecord.geteArragnmntTRLRecords();
		if(arrngRateList != null && arrngRateList.size() != 0){
			for(ArrangementTRLTwRcRecord arRecord : arrngRateList){
				rateVarTypeSum += arRecord.geteRateVarTypeId();
			}
		}
		jobExecutionContext.putLong("rateVarTypeIdSum", rateVarTypeSum);
		}	
	}
	
	private void calculateEnrCkSum(InRcTRLRecord itemRecord){
		ExecutionContext jobExecutionContext = stepExecution.getJobExecution()
				.getExecutionContext();
		  synchronized (jobExecutionContext) {
		Object enrInputCheckSum = jobExecutionContext.get("twEnrInputCheckSum");
		BigDecimal twEnrCksumExisted = new BigDecimal(0);
		if(enrInputCheckSum != null){
			twEnrCksumExisted = (BigDecimal) enrInputCheckSum;
		}
		List<CommonBalanceRcTRLRecord> commonBalanceList = itemRecord.geteCommonBalanceRcTRLRecords();
		if(commonBalanceList != null && commonBalanceList.size() != 0){
			for(CommonBalanceRcTRLRecord cbRecord : commonBalanceList){
				
				if(cbRecord.geteBalType() == 265){
					twEnrCksumExisted = twEnrCksumExisted.add(cbRecord.geteTransAmt());
				}
			}
		}
		jobExecutionContext.put("twEnrInputCheckSum", twEnrCksumExisted);
		
		  }
	}
}
