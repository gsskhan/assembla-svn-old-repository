package com.citi.retail.optima.etl.batch.job.reader;

import java.util.List;
import java.util.Map;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class ListItemReader<T> implements ItemReader<T> {
		
	private Map<Integer, List<List<Object>>> puToAccountDataMap;
	
	Integer processingUnit;
	Integer indexCount;

	public void setPuToAccountDataMap(Map<Integer, List<List<Object>>> puToAccountDataMap) {
		this.puToAccountDataMap = puToAccountDataMap;
	}


	public Map<Integer, List<List<Object>>> getPuToAccountDataMap() {
		return puToAccountDataMap;
	}

	private List<Object> itemList;

	@SuppressWarnings("unchecked")
	@BeforeStep
	public void getPatitionData(StepExecution stepExecution) {
		itemList = ((List<List<Object>>)getPuToAccountDataMap().get(processingUnit)).get(indexCount);
	}

	@Override
	public T read() throws UnexpectedInputException,
			ParseException, NonTransientResourceException, Exception {

		if (!itemList.isEmpty()) {
			return (T)itemList.remove(0);
		}
		return null;
	}


	public Integer getProcessingUnit() {
		return processingUnit;
	}


	public void setProcessingUnit(Integer processingUnit) {
		this.processingUnit = processingUnit;
	}


	public Integer getIndexCount() {
		return indexCount;
	}


	public void setIndexCount(Integer indexCount) {
		this.indexCount = indexCount;
	}
}
