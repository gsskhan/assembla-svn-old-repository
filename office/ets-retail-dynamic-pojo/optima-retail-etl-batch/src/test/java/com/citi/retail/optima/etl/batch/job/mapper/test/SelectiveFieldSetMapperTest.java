package com.citi.retail.optima.etl.batch.job.mapper.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.FieldSet;

import com.citi.retail.optima.etl.batch.job.mapper.SelectiveFieldSetMapper;
import com.citi.retail.optima.etl.common.model.RainbowRecord;

@RunWith(MockitoJUnitRunner.class)
public class SelectiveFieldSetMapperTest {

	@Mock
	private SelectiveFieldSetMapper<RainbowRecord> selectiveMapper;
	
	@Mock
	private DefaultLineMapper<RainbowRecord> lineMapper;

	@Mock
	FieldSet fieldSet;
	
	@Before
	private void setUp(){
		
	}
		
}
