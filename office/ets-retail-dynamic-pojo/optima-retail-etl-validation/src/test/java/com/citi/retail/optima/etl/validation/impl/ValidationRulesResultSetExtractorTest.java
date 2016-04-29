package com.citi.retail.optima.etl.validation.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.expression.ParseException;

import com.citi.retail.optima.etl.validation.dao.impl.ValidationRulesResultSetExtractor;

@RunWith(MockitoJUnitRunner.class)
public class ValidationRulesResultSetExtractorTest {
	
	private ValidationRulesResultSetExtractor extractor;	
	private ResultSet rs = null;
	
	@Before
	public void init() throws Exception {
		extractor = new ValidationRulesResultSetExtractor();
		this.rs = Mockito.mock(ResultSet.class);
		Mockito.when(this.rs.next()).thenReturn(Boolean.TRUE);
		Mockito.when(this.rs.getString("KEY")).thenReturn("suppDataProcessStep:19");
		Mockito.when(this.rs.getInt("SYS_PROC_ID")).thenReturn(19);
		Mockito.when(this.rs.getInt("RULE_ID")).thenReturn(1);
		Mockito.when(this.rs.getString("RULE_TO_EXECUTE")).thenReturn("processingUnit<>=19");
		Mockito.when(this.rs.getInt("RULE_ATTRIBUTE_ID")).thenReturn(19);
		Mockito.when(this.rs.getString("RULE_ATTRIBUTE")).thenReturn("processingUnit");
		Mockito.when(this.rs.getString("ERR_MSG")).thenReturn("Invalid rule");
		Mockito.when(this.rs.getString("AUDIT_VALUES")).thenReturn("");		
	}
	
	@Test(expected = ParseException.class)
	public void testExtractData() throws DataAccessException, SQLException {
		extractor.extractData(rs);
	}
	
}
