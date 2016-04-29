package com.citi.retail.optima.etl.batch.filescanner.impl.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.junit.Assert;

import com.citi.retail.optima.etl.fileintegrity.FileIntegrityService;
import com.citi.retail.optima.etl.fileintegrity.exception.FileIntegrityDataException;

public class FileIntegrityTestUtlity {
	
	public Map<Integer,FileIntegrityDataException> validateFiles(FileIntegrityService service,String fileName){
		Map<Integer,FileIntegrityDataException> errorCollection=null;
		Scanner scanner = new Scanner(ClassLoader.getSystemResourceAsStream(fileName));
		String lineStr = "";
		int lineNum = 0;
		while (scanner.hasNextLine()) {
			try{
				lineStr = scanner.nextLine();
				Assert.assertTrue(service.validate(lineStr, lineNum));
				lineNum++;
			}catch(FileIntegrityDataException e){
				if(errorCollection==null){
					errorCollection = new HashMap<Integer,FileIntegrityDataException>();
				}
				errorCollection.put(lineNum, e);
				lineNum++;
			}			
		}
		scanner.close();
		return errorCollection;		
	}
}
