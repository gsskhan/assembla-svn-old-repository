package com.citi.retail.optima.etl.batch.job.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class DummyItemWriter<T> implements ItemWriter<T> {

	@Override
	public void write(List<? extends T> items) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
