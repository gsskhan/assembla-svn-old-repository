package com.citi.retail.optima.etl.batch.filescanner.impl.test;

import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.fileintegrity.FileIntegrityService;
import com.citi.retail.optima.etl.fileintegrity.exception.FileIntegrityDataException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/retail.optima.etl.batch.fileintegrity.xml",
	"/retail.optima.etl.batch.fileintegrity.test.xml" })
public class FileIntegrityRainbowFileTest {
	@Autowired
	private FileIntegrityService fileIntegrityServiceRnbwFile;
	
	@Autowired
	private FileIntegrityService fileIntegrityServiceCntrlFile;
	
	@Autowired
	private FileIntegrityService fileIntegrityServiceEppFile;
	
	@Autowired
	private FileIntegrityService fileIntegrityServiceFicoFile;
	
	@Autowired
	private FileIntegrityService fileIntegrityServiceNtbFile;
	
	@Autowired
	private FileIntegrityService fileIntegrityServiceRecFile;
	
	@Autowired
	private FileIntegrityService fileIntegrityServiceTdrFile;
	
	@Autowired
	private FileIntegrityService fileIntegrityServiceWoFile;
	
	@Autowired
	private FileIntegrityService fileIntegrityServicePreRnbwFile;
	
	private FileIntegrityTestUtlity util; 

	public void setFileIntegrityServiceRnbw(
			FileIntegrityService fileIntegrityServiceRnbwFile) {
		this.fileIntegrityServiceRnbwFile = fileIntegrityServiceRnbwFile;
	}
	
	
	
	public void setFileIntegrityServiceRnbwFile(
			FileIntegrityService fileIntegrityServiceRnbwFile) {
		this.fileIntegrityServiceRnbwFile = fileIntegrityServiceRnbwFile;
	}



	public void setFileIntegrityServiceCntrlFile(
			FileIntegrityService fileIntegrityServiceCntrlFile) {
		this.fileIntegrityServiceCntrlFile = fileIntegrityServiceCntrlFile;
	}



	public void setFileIntegrityServiceEppFile(
			FileIntegrityService fileIntegrityServiceEppFile) {
		this.fileIntegrityServiceEppFile = fileIntegrityServiceEppFile;
	}



	public void setFileIntegrityServiceFicoFile(
			FileIntegrityService fileIntegrityServiceFicoFile) {
		this.fileIntegrityServiceFicoFile = fileIntegrityServiceFicoFile;
	}



	public void setFileIntegrityServiceNtbFile(
			FileIntegrityService fileIntegrityServiceNtbFile) {
		this.fileIntegrityServiceNtbFile = fileIntegrityServiceNtbFile;
	}



	public void setFileIntegrityServiceRecFile(
			FileIntegrityService fileIntegrityServiceRecFile) {
		this.fileIntegrityServiceRecFile = fileIntegrityServiceRecFile;
	}



	public void setFileIntegrityServiceTdrFile(
			FileIntegrityService fileIntegrityServiceTdrFile) {
		this.fileIntegrityServiceTdrFile = fileIntegrityServiceTdrFile;
	}



	public void setFileIntegrityServiceWoFile(
			FileIntegrityService fileIntegrityServiceWoFile) {
		this.fileIntegrityServiceWoFile = fileIntegrityServiceWoFile;
	}



	@Before
	public void setUp(){
		util = new FileIntegrityTestUtlity();
	}
	
	@Test
	public void testFileIntegrityServiceRnbw(){
		Assert.assertNotNull(fileIntegrityServiceRnbwFile);
		Assert.assertNotNull(fileIntegrityServiceCntrlFile);
		Assert.assertNotNull(fileIntegrityServiceFicoFile);
		Assert.assertNotNull(fileIntegrityServiceNtbFile);
		Assert.assertNotNull(fileIntegrityServiceRecFile);
		Assert.assertNotNull(fileIntegrityServiceTdrFile);
		Assert.assertNotNull(fileIntegrityServiceWoFile);
		Assert.assertNotNull(fileIntegrityServiceEppFile);
		Assert.assertNotNull(fileIntegrityServicePreRnbwFile);
	}
	
	@Test
	public void testFileIntegrityServicePostRnbwRules(){
		Map<Integer,FileIntegrityDataException> errors = null;
		errors = util.validateFiles(fileIntegrityServiceRnbwFile, "\\fileintegritytestfiles\\OR_CRD_TW_RSK_20130930_HIST_TW_RNBW1309_20140131_Data.v2.dat");
		Assert.assertNull(errors);
		errors = util.validateFiles(fileIntegrityServiceCntrlFile, "\\fileintegritytestfiles\\OR_CRD_TW_RSK_20130930_HIST_TW_20140131_Control_V2.dat");
		Assert.assertNull(errors);
		errors = util.validateFiles(fileIntegrityServiceFicoFile, "\\fileintegritytestfiles\\OR_CRD_TW_RSK_20130930_HIST_TW_ECS_FICO1309_20140131_Data.v2.dat");
		Assert.assertNull(errors);
		errors = util.validateFiles(fileIntegrityServiceNtbFile, "\\fileintegritytestfiles\\OR_CRD_TW_RSK_20130930_HIST_TW_ECS_NTB1309_20140131_Data.v2.dat");
		Assert.assertNull(errors);
		errors = util.validateFiles(fileIntegrityServiceRecFile, "\\fileintegritytestfiles\\OR_CRD_TW_RSK_20130930_HIST_TW_ECS_REC1309_20140131_Data.v2.dat");
		Assert.assertNull(errors);
		errors = util.validateFiles(fileIntegrityServiceTdrFile, "\\fileintegritytestfiles\\OR_CRD_TW_RSK_20130930_HIST_TW_ECS_TDR1309_20140131_Data.v2.dat");
		Assert.assertNull(errors);
		errors = util.validateFiles(fileIntegrityServiceWoFile, "\\fileintegritytestfiles\\OR_CRD_TW_RSK_20130930_HIST_TW_ECS_WO1309_20140131_Data.v2.dat");
		Assert.assertNull(errors);
		errors = util.validateFiles(fileIntegrityServiceEppFile, "\\fileintegritytestfiles\\OR_CRD_TW_RSK_20130930_HIST_TW_ECS_EPP1309_20140131_Data.v2.dat");
		Assert.assertNull(errors);
		errors = util.validateFiles(fileIntegrityServicePreRnbwFile, "\\fileintegritytestfiles\\tw_cpmb1207.dat");
		Assert.assertNull(errors);
	}
}
