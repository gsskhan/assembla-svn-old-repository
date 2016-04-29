package com.citi.retail.optima.etl.fileintegrity.impl.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;

import com.citi.retail.optima.etl.fileintegrity.FileIntegrityService;
import com.citi.retail.optima.etl.fileintegrity.common.FileValidationRules;
import com.citi.retail.optima.etl.fileintegrity.exception.FileIntegrityDataException;
import com.citi.retail.optima.etl.fileintegrity.impl.FileIntegrityServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(locations = {"/optima.retail.fileintegritychecks.test.xml"})
public class FileIntegrityServiceImplFileTest {
	@Mock
	private FileIntegrityService fileIntegrityServiceCcar;
	
	@Mock
	private FileIntegrityService fileIntegrityServiceFdic;
	
	@Mock
	private FileIntegrityService fileIntegrityServiceSuppl;
	
	
	private static final String CCARFILE_NAME = "CCARFile.csv";
	private static final String CCARFILE_NAME_DUPLICATE = "CCARErrorFile.csv";
	private static final String FDICFILE_NAME = "FDICFile.csv";
	private static final String SUPPGOODFILE_NAME = "SupplementaryGoodFile.csv";
	private static final String SUPPBADFILE_NAME = "SupplementaryFile.csv";
	
	private Map<Integer, FileIntegrityDataException> errorCollection;
	
	@Before
	public void setUpFile() throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(FileValidationRules.class);			
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		FileValidationRules ccarRules = (FileValidationRules) jaxbUnmarshaller.unmarshal(ClassLoader.getSystemResource("rules/CCARrules.xml"));
		ccarRules.prepareObject();
		fileIntegrityServiceCcar = new FileIntegrityServiceImpl(ccarRules);
		FileValidationRules fdicRules = (FileValidationRules) jaxbUnmarshaller.unmarshal(ClassLoader.getSystemResource("rules/FDICrules.xml"));
		fdicRules.prepareObject();
		fileIntegrityServiceFdic = new FileIntegrityServiceImpl(fdicRules);
		FileValidationRules supplRules = (FileValidationRules) jaxbUnmarshaller.unmarshal(ClassLoader.getSystemResource("rules/SupplementaryRules.xml"));
		supplRules.prepareObject();
		fileIntegrityServiceSuppl = new FileIntegrityServiceImpl(supplRules);		
		errorCollection = new HashMap<Integer,FileIntegrityDataException>();
	}
	
	public FileIntegrityService getFileIntegrityServiceCcar() {
		return fileIntegrityServiceCcar;
	}

	public void setFileScannerServiceCcar(FileIntegrityService fileIntegrityServiceCcar) {
		this.fileIntegrityServiceCcar = fileIntegrityServiceCcar;
	}

	public FileIntegrityService getFileIntegrityServiceFdic() {
		return fileIntegrityServiceFdic;
	}

	public void setFileIntigerityServiceFdic(FileIntegrityService fileIntegrityServiceFdic) {
		this.fileIntegrityServiceFdic = fileIntegrityServiceFdic;
	}

	@Test
	public void testCCARFileRules(){
		Scanner scanner = new Scanner(ClassLoader.getSystemResourceAsStream(CCARFILE_NAME));
		String lineStr = "";
			int lineNum = 0;
			while (scanner.hasNextLine()) {
				try{
					lineStr = scanner.nextLine();
					Assert.assertTrue(fileIntegrityServiceCcar.validate(lineStr, lineNum));					
					lineNum++;
				}catch(FileIntegrityDataException dataExc){
					errorCollection.put(lineNum, dataExc);
					lineNum++;
				}
			}
		scanner.close();
		if(errorCollection.size()>0){
			Assert.fail();
		}
	}
	@Test
	public void testCCARFileRulesFurDuplicates(){
		Scanner scanner = new Scanner(ClassLoader.getSystemResourceAsStream(CCARFILE_NAME_DUPLICATE));
		String lineStr = "";
			int lineNum = 0;
			while (scanner.hasNextLine()) {
				try{
					lineStr = scanner.nextLine();
					Assert.assertTrue(fileIntegrityServiceCcar.validate(lineStr, lineNum));					
					lineNum++;
				}catch(FileIntegrityDataException dataExc){
					errorCollection.put(lineNum, dataExc);
					lineNum++;
				}
			}
		scanner.close();
		if(errorCollection.size()>0){
			Assert.assertNotNull(errorCollection.get(17));
			Assert.assertNotNull(errorCollection.get(70));
			Assert.assertNull(errorCollection.get(2));
		}
	}
	
	@Test
	public void testFDICFileRules(){
		Scanner scanner = new Scanner(ClassLoader.getSystemResourceAsStream(FDICFILE_NAME));
		String lineStr = "";
		int lineNum = 0;
		try{
			while (scanner.hasNextLine()) {
				lineStr = scanner.nextLine();
				Assert.assertTrue(fileIntegrityServiceFdic.validate(lineStr, lineNum));
				lineNum++;
			}				
		}catch(Exception e){
			Assert.fail();
		}finally{		
			scanner.close();
		}
	}
	
	@Test
	public void testSupplementaryGoodFileRules(){
		Scanner scanner = new Scanner(ClassLoader.getSystemResourceAsStream(SUPPGOODFILE_NAME));
		String lineStr = "";
		int lineNum = 0;
		while (scanner.hasNextLine()) {
			try{
				lineStr = scanner.nextLine();
				Assert.assertTrue(fileIntegrityServiceSuppl.validate(lineStr, lineNum));
				lineNum++;
			}catch(FileIntegrityDataException e){
				errorCollection.put(lineNum, e);
				lineNum++;
			}			
		}
		scanner.close();
		if(errorCollection.size()>0){
			Assert.fail();
		}
	}
	
	@Test
	public void testSupplementaryBadFileRules(){
		Scanner scanner = new Scanner(ClassLoader.getSystemResourceAsStream(SUPPBADFILE_NAME));
		String lineStr = "";
		int lineNum = 0;
		while (scanner.hasNextLine()) {
			try{
				lineStr = scanner.nextLine();
				Assert.assertTrue(fileIntegrityServiceSuppl.validate(lineStr, lineNum));
				lineNum++;
			}catch(FileIntegrityDataException e){
				errorCollection.put(lineNum, e);
				lineNum++;
			}			
		}
		scanner.close();
		if(errorCollection.size()>0){
			Assert.assertTrue(true);
		}
	}
}
