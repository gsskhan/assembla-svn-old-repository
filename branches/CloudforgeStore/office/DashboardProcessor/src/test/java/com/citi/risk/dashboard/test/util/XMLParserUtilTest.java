package com.citi.risk.dashboard.test.util;

import java.io.BufferedReader;
import java.io.FileReader;

import org.junit.Ignore;
import org.junit.Test;

import com.citi.risk.dashboard.util.XMLParserUtility;
import com.citi.risk.dashboard.vo.DashboardXMLBean;

public class XMLParserUtilTest {
	
	@Test
	@Ignore
	public void parsedXMLTest()  throws Exception{
		XMLParserUtility parserUtility = new XMLParserUtility();
		DashboardXMLBean xmlBean = parserUtility.parsedXML(getXmlAsString());
		System.out.println(xmlBean);
		if (! parserUtility.validateParsedXml(xmlBean)) {
			System.out.println("One/more required fields in xml was null or empty, skipped message processing service for this XML. Please check log.");
			}
		System.out.println("ended.");
	}
	
	public static String getXmlAsString(){
		String xmlString = "";
		try {
			FileReader fr = new FileReader("src/main/resources/sample/Response.xml");
			BufferedReader br  = new BufferedReader(fr);
			StringBuilder strbuilder = new StringBuilder();
			String line ="";
			while ((line = br.readLine()) != null) {
				strbuilder.append(line);
			}
			xmlString = strbuilder.toString();
			br.close();
			fr.close();
			
		} catch (Exception e) {
			System.err.println("Error in reading file.");
			e.printStackTrace();
		}
		return xmlString;
	}

}
