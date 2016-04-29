package com.citi.retail.optima.etl.batch.job.reader;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.rowset.serial.SerialBlob;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.citi.retail.optima.etl.batch.dao.BatchJobInstanceDao;
import com.citi.retail.optima.etl.batch.report.ErrorDataServiceFactory;
import com.citi.retail.optima.etl.batch.report.ErrorReportHandler;
import com.citi.retail.optima.etl.common.ETLConstants;
import com.citi.retail.optima.etl.common.exception.OptimaRetailDataException;
import com.citi.retail.optima.etl.common.exception.OptimaRetailDataExceptionDetail;
import com.citi.retail.optima.etl.fileintegrity.FileIntegrityService;
import com.citi.retail.optima.etl.fileintegrity.exception.FileIntegrityDataException;

@RunWith(MockitoJUnitRunner.class)
public class CSVItemReaderTest {
	@Mock
	private BatchJobInstanceDao batchInstanceDao;
	
	
	private ErrorDataServiceFactory preProcessorFactory;

	@InjectMocks
	private CSVItemReader<String> cSVItemReader;

	
	private ErrorReportHandler errorReportHandler;

	@Mock
	private FileIntegrityService fileScannerService;


	
	private Map<String, OptimaRetailDataException> inputErrorCollection;

	@Mock
	private JdbcTemplate jdbcTemplate;
	
	@Mock
	private StepExecution stepExecution;

	@Mock
	private DefaultLineMapper lineMapper;

	List<Blob>  result;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		result = new ArrayList<Blob>(2);
		MockitoAnnotations.initMocks(this) ;
		Mockito.when(jdbcTemplate.query(Mockito.anyString(),(RowMapper<Blob>)Mockito.anyObject())).thenReturn(result);
		
		JobExecution jobExecution = new JobExecution(1L);
		jobExecution.getExecutionContext().put(ETLConstants.FILE_READER, "csvreader");
		
		
		lineMapper = new DefaultLineMapper<String>(){
			public String mapLine(String string, int linNumber){
				return string;
				
			}
		};
		
	   fileScannerService = new FileIntegrityService(){

		@Override
		public boolean validate(String line, int rowNum)
				throws FileIntegrityDataException {
			return true;
		}
			
		};
		cSVItemReader.setFileScannerService(fileScannerService);
		cSVItemReader.setLineMapper(lineMapper);
		stepExecution = new StepExecution("test", jobExecution);
		cSVItemReader.setPreProcessorFactory(new ErrorDataServiceFactory());
		cSVItemReader.setDataServiceName("com.citi.retail.optima.etl.batch.report.BatchErrorReportServiceImpl");
	}
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSetPreProcessorFactory() throws Exception {
		cSVItemReader.setPreProcessorFactory(preProcessorFactory);
	}

	@Test
	public void testSetBatchInstanceDao() throws Exception {
		cSVItemReader.setBatchInstanceDao(batchInstanceDao);
	}

	@Test
	public void testSetDataServiceName() throws Exception {
		cSVItemReader.setDataServiceName("Aggregatin");
	
	}
	@Test
	public void testSetErrorReportHandler() throws Exception {

		cSVItemReader.setErrorReportHandler(new ErrorReportHandler());
	}

	@Test
	public void testGetBlobData() throws Exception {
		result.add(new SerialBlob("test,test1,test2\ntest3,test4,test5\n".getBytes()));
		cSVItemReader.getBlobData(stepExecution);
		
	}

	@Test
	public void testRead() throws Exception {
		result.add(new SerialBlob("test,test1,test2\ntest3,test4,test5\n".getBytes()));
		cSVItemReader.getBlobData(stepExecution);
		Assert.assertEquals("test3,test4,test5", cSVItemReader.read());		
	}
	@Test
	public void testBatRead() throws Exception {
		result.add(new SerialBlob("".getBytes()));
		cSVItemReader.getBlobData(stepExecution);
		Assert.assertNull(cSVItemReader.read());		
	}
	
	@Test(expected=OptimaRetailDataException.class)
	public void testBadReadWitException() throws Exception {
		FileIntegrityService fileScannerServiceX = new FileIntegrityService(){

			@Override
			public boolean validate(String line, int rowNum)
					throws FileIntegrityDataException {
				
				FileIntegrityDataException orException =new FileIntegrityDataException();
				/*FieldError detailExceptionr = new FieldError();
				OptimaRetailDataExceptionDetail detailException = new OptimaRetailDataExceptionDetail();
				detailException.setExceptionMessage("YES I GOT ERROR");
				orException.setOptimaRetailSkippableList(new ArrayList<OptimaRetailDataExceptionDetail>());
				orException.add(detailException);*/
				throw orException;
			}
			};
		
	    cSVItemReader.setFileScannerService(fileScannerServiceX);
		result.add(new SerialBlob("test,test1,test2\ntest3,test4,test5\ntest3,test4,test5\n".getBytes()));
		cSVItemReader.getBlobData(stepExecution);
		
		Assert.assertNull(cSVItemReader.read());		
		cSVItemReader.setFileScannerService(fileScannerService);
	}
	
	@Test(expected=OptimaRetailDataException.class)
	public void testBadTitleReadWitException() throws Exception {
		FileIntegrityService fileScannerServiceX = new FileIntegrityService(){

			@Override
			public boolean validate(String line, int rowNum)
					throws FileIntegrityDataException {
				
				FileIntegrityDataException orException =new FileIntegrityDataException();
				/*OptimaRetailDataExceptionDetail detailException = new OptimaRetailDataExceptionDetail();
				detailException.setExceptionMessage("YES I GOT ERROR");
				orException.setOptimaRetailSkippableList(new ArrayList<OptimaRetailDataExceptionDetail>());
				orException.add(detailException);*/
				throw orException;
			}
			};
			
		
	    cSVItemReader.setFileScannerService(fileScannerServiceX);
		result.add(new SerialBlob("test,test1,test2\n\n".getBytes()));
		cSVItemReader.getBlobData(stepExecution);
		
		Assert.assertNull(cSVItemReader.read());		
		cSVItemReader.setFileScannerService(fileScannerService);
	}
	
	

	@Test
	public void testHandleErrorBolbCreation() throws Exception {

			OptimaRetailDataException orException =new OptimaRetailDataException();
			OptimaRetailDataExceptionDetail detailException = new OptimaRetailDataExceptionDetail();
			detailException.setExceptionMessage("YES I GOT ERROR");
			orException.setOptimaRetailSkippableList(new ArrayList<OptimaRetailDataExceptionDetail>());
			orException.add(detailException);
			HashMap<String, OptimaRetailDataException> inputErrorCollection = new HashMap<String, OptimaRetailDataException>();
			inputErrorCollection.put("Hello", orException);
		
		
			result.add(new SerialBlob("test,test1,test2\n\n".getBytes()));
			cSVItemReader.readErrorFound=true;
			cSVItemReader.getBlobData(stepExecution);
			cSVItemReader.read();
			cSVItemReader.setInputErrorCollection(inputErrorCollection);
			cSVItemReader.setErrorReportHandler(new ErrorReportHandler());
			cSVItemReader.handleErrorBolbCreation(stepExecution);
		
			
	}


	@Test
	public void testNoHandleErrorBolbCreation() throws Exception {

			OptimaRetailDataException orException =new OptimaRetailDataException();
			OptimaRetailDataExceptionDetail detailException = new OptimaRetailDataExceptionDetail();
			detailException.setExceptionMessage("YES I GOT ERROR");
			orException.setOptimaRetailSkippableList(new ArrayList<OptimaRetailDataExceptionDetail>());
			orException.add(detailException);
			HashMap<String, OptimaRetailDataException> inputErrorCollection = new HashMap<String, OptimaRetailDataException>();
			inputErrorCollection.put("Hello", orException);
		
		
			result.add(new SerialBlob("test,test1,test2\n\n".getBytes()));
			cSVItemReader.readErrorFound=false;
			cSVItemReader.getBlobData(stepExecution);
			cSVItemReader.read();
			cSVItemReader.setInputErrorCollection(inputErrorCollection);
			cSVItemReader.setErrorReportHandler(new ErrorReportHandler());
			cSVItemReader.handleErrorBolbCreation(stepExecution);
		
			
	}
	

	@Test
	public void testSetGetFileScannerService() throws Exception {
		Assert.assertTrue(fileScannerService==cSVItemReader.getFileScannerService());
	}

	

	@Test
	public void testSetGetJdbcTemplate() throws Exception {
		cSVItemReader.setJdbcTemplate(jdbcTemplate);
		
	}

	@Test
	public void testSetGetLineMapper() throws Exception {
		cSVItemReader.setLineMapper(lineMapper);
		Assert.assertTrue(lineMapper==cSVItemReader.getLineMapper());
	}



	@Test
	public void testSetGetSql() throws Exception {
		cSVItemReader.setSql("select 1 from dual");
		Assert.assertEquals("select 1 from dual", cSVItemReader.getSql());
	}

	@Test
	public void testSetGetInputErrorCollection() throws Exception {
		OptimaRetailDataException orException =new OptimaRetailDataException();
		OptimaRetailDataExceptionDetail detailException = new OptimaRetailDataExceptionDetail();
		detailException.setExceptionMessage("YES I GOT ERROR");
		orException.setOptimaRetailSkippableList(new ArrayList<OptimaRetailDataExceptionDetail>());
		orException.add(detailException);
		HashMap<String, OptimaRetailDataException> inputErrorCollection = new HashMap<String, OptimaRetailDataException>();
		inputErrorCollection.put("Hello", orException);
		cSVItemReader.setInputErrorCollection(inputErrorCollection);
		Assert.assertTrue(inputErrorCollection==cSVItemReader.getInputErrorCollection());
		
		
	}
}
