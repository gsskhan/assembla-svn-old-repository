package com.citi.retail.optima.etl.batch.job.writer;

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

import com.citi.retail.optima.etl.common.model.CommonBalanceMtgTRLRecord;
import com.citi.retail.optima.etl.common.model.OreoTRLRecord;

public class InMtgOreoConditionalItemWriter extends
		CompositeItemWriter<OreoTRLRecord> implements StepExecutionListener {

	private ItemWriter<? super OreoTRLRecord> excludeItemDelegate;

	private Long partitionWriteRecordCount = 0L;

	private StepExecution stepExecution;

	public void write(List<? extends OreoTRLRecord> item) throws Exception {
		
		List<OreoTRLRecord> includeList = new ArrayList<OreoTRLRecord>();

		for (OreoTRLRecord itemRecord : item) {
			if(itemRecord != null){
				includeList.add(itemRecord);
				saveCBResult(itemRecord);
			}
		}

		partitionWriteRecordCount = (long) includeList.size();
		super.write(includeList);
		saveWriteCount();
	}

	private void saveCBResult(OreoTRLRecord itemRecord) {
		ExecutionContext jobExecutionContext = stepExecution.getJobExecution()
				.getExecutionContext();
		  synchronized (jobExecutionContext) {
		Object balTypeSum = jobExecutionContext
				.get("commonBalanceSum");
		Long balType = 0L;
		if (balTypeSum != null) {
			balType = (Long) balTypeSum;
		}
		List<CommonBalanceMtgTRLRecord> commonBalanceList = itemRecord.geteCommonBalMtgTRLRecords();
		if(commonBalanceList != null && commonBalanceList.size() != 0){
			for(CommonBalanceMtgTRLRecord cbRecord : commonBalanceList){
				balType += cbRecord.geteBalType();
			}
			jobExecutionContext.putLong("commonBalanceSum", balType);
		}
		  }
	}

	public void setExcludeItemDelegate(
			ItemWriter<? super OreoTRLRecord> excludeItemDelegate) {
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
}

