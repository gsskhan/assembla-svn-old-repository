package com.citi.retail.optima.etl.batch.job.writer;

import java.util.List;

import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.beans.factory.InitializingBean;

import com.citi.retail.optima.etl.common.model.CardsTRLRecord;

public class CardsFileItemWriter extends FlatFileItemWriter<CardsTRLRecord> implements InitializingBean {

	
	@Override
	public void  write(List<? extends CardsTRLRecord> accList) throws Exception {
		
		super.write(accList);
	}
}
