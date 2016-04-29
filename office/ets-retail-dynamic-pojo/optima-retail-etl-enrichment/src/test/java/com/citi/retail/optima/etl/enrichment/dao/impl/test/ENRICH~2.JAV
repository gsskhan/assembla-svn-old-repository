package com.citi.retail.optima.etl.enrichment.dao.impl.test;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.dao.DataAccessException;
import org.springframework.expression.ParseException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.enrichment.dao.impl.EnrichmentRulesResultSetExtractor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.enrichment.config.test.xml"})
public class EnrichmentRulesResultSetExtractorTest {
	
	private EnrichmentRulesResultSetExtractor extractor;	
	
	
	private ResultSet rs = null;
	
	@Before
	public void init() throws Exception {	
		extractor = new EnrichmentRulesResultSetExtractor();
		this.rs = Mockito.mock(ResultSet.class);
		Mockito.when(this.rs.next()).thenReturn(Boolean.TRUE);
		Mockito.when(this.rs.getString("ruleToExecute")).thenReturn("processingUnit<>=19");
		Mockito.when(this.rs.getInt("ruleOrder")).thenReturn(1);
		Mockito.when(this.rs.getString("KEY")).thenReturn("suppDataProcessStep:19");
		Mockito.when(this.rs.getInt("SYS_PROC_ID")).thenReturn(19);
		Mockito.when(this.rs.getInt("ATTR_ID")).thenReturn(435);
		Mockito.when(this.rs.getString("ruleAttribute")).thenReturn("ePortfolioDefinition");	
	}
	
	@Test(expected = ParseException.class)
	public void testExtractData() throws DataAccessException, SQLException {
		extractor.extractData(rs);
	}
	
	
	
	
}
