package com.citi.optima.retail.batch.report;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.citi.retail.optima.etl.batch.report.ErrorReportHandler;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailDataException;
import com.citi.retail.optima.etl.common.exception.OptimaRetailDataExceptionDetail;

public class ErrorReportHandlerTest {

	ErrorReportHandler errorReportHandler = new ErrorReportHandler();
	static Map<String, OptimaRetailDataException> detailException = new ConcurrentHashMap<String, OptimaRetailDataException>();

	@BeforeClass
	public static void testSetup() throws IOException {

		for (int j = 0; j < 10; j++) {
			OptimaRetailDataException data = new OptimaRetailDataException();
			List<OptimaRetailDataExceptionDetail> list = new ArrayList<OptimaRetailDataExceptionDetail>();
			for (int i = 0; i < 10; i++) {
				OptimaRetailDataExceptionDetail detail = new OptimaRetailDataExceptionDetail();
				detail.setAttributeId(1);
				detail.setAttributeName("Test Attribute");
				detail.setExceptionMessage("Sample Exception Message");
				detail.setExceptionType(ExceptionType.ERROR);
				detail.setUserErrorMessage("User exception");
				list.add(detail);
			}
			data.setOptimaRetailSkippableList(list);
			detailException.put("Col1" + j + ",Col2 " + j, data);
		}

	}

	@Test
	public void testCsvCreator() throws IOException {
		Assert.assertNotNull(errorReportHandler.createCSVErrorReport(
				detailException, "Test Error", "col1,col2"));
	}

	@Test
	public void testXLSCreator() throws IOException {
		Assert.assertNotNull(errorReportHandler.createXlsErrorReport(
				detailException, "col1,col2"));
	}

}
