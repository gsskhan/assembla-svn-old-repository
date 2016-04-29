package com.citi.retail.optima.etl.fileintegrity.impl.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.fileintegrity.exception.FileIntegrityException;
import com.citi.retail.optima.etl.fileintegrity.impl.FileIntegrityServiceFactoryImpl;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/optima.retail.fileintegritychecks.test.xml"})
public class FileIntegrityServiceFactoryImplTest {
	
	@Autowired
	private FileIntegrityServiceFactoryImpl fileIntegrityServiceFactory;
	
	@Test(expected = FileIntegrityException.class)
	public void testCreateFileIntegrityService() throws FileIntegrityException {
		try {			
			Assert.assertNull(fileIntegrityServiceFactory.createFileIntegrityService(null));	
		} catch (FileIntegrityException ex) {
			FileIntegrityException exception = new FileIntegrityException("rule not loaded", "FileIntegrityException", ex);
			System.out.println(exception.getExceptionMessage());
			System.out.println(exception.getExceptionTrace());
			System.out.println(exception.getRootException());
			System.out.println(exception.getExceptionMessage());
			throw exception;
		}
					
	}
}
