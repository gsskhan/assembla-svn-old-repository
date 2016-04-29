package com.citi.retail.optima.etl.fileintegrity.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.fileintegrity.FileIntegrityService;
import com.citi.retail.optima.etl.fileintegrity.exception.FileIntegrityDataException;
import com.citi.retail.optima.etl.fileintegrity.exception.FileIntegrityException;
import com.citi.retail.optima.etl.fileintegrity.impl.FileIntegrityServiceFactoryImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/optima.retail.fileintegritychecks.test.xml"})
public class FileIntegrityServiceFactoryTest {

	@Autowired
	FileIntegrityServiceFactoryImpl fileIntegrityServiceFactory;
	
	FileIntegrityService fileIntegrityService;

	@Test
	public void testFileScannerServiceforCCAR() {
		try {
			String line = "201304,VNUR002,nv54287,ec56273,1,4,VN,CO_UR,-1,1,-1,-1,-1,1,3,5240,1744577,1769634,1047,7,0,0,756,0,7610754,873790,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,VND,0.000048,1";
			int rowNum = 2;
			fileIntegrityService = fileIntegrityServiceFactory.createFileIntegrityService("CCAR");
			Assert.assertTrue(fileIntegrityService.validate(line, rowNum));
		} catch (FileIntegrityException e) {
			Assert.fail();
		}  catch (FileIntegrityDataException e) {
			Assert.fail();
		}
	}

	@Test
	public void testFileScannerServiceforFDIC() {
		try {
			String line = "201303,APAC,MY,APAC_GCG,CO_LO,Citi FICO Alignment,Citi FICO Alignment,511,3,0,MYR,3.0905,LW76731,LW76731";
			int rowNum = 2;
			fileIntegrityService = fileIntegrityServiceFactory
					.createFileIntegrityService("FDIC");
			Assert.assertTrue(fileIntegrityService.validate(line, rowNum));
		} catch (FileIntegrityException e) {
			Assert.fail();
		}  catch (FileIntegrityDataException e) {
			Assert.fail();
		}
	}
}
