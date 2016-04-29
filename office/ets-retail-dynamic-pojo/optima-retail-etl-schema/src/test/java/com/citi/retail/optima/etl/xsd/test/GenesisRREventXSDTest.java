package com.citi.retail.optima.etl.xsd.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.citi.retail.optima.etl.xsd.genesis.GenesisRREvent;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/retail.optima.etl.schema.test.context.xml" })
public class GenesisRREventXSDTest {

	// Defined Internal XSD
	private GenesisRREvent genesisRREvent;

	// Sample XML File
	private File fXmlFile;

	/**
	 * Method to test the internal XSD created using JAXB
	 * 
	 * @throws FileNotFoundException
	 */
	@Test
	public void testInternalXsd() throws Exception {

		// DOM parser variables
		Document doc;
		DocumentBuilderFactory dbFactory;
		DocumentBuilder dBuilder;

		// this.fXmlFile = new File("target\\test-classes\\Internal-Test.xml");
		this.fXmlFile = new File(
				"target\\test-classes\\Genesis_Feed_Request.xml");

		InputStream is = new FileInputStream(this.fXmlFile);

		Assert.assertNotNull(this.fXmlFile);

		dbFactory = DocumentBuilderFactory.newInstance();
		dBuilder = dbFactory.newDocumentBuilder();
		doc = dBuilder.parse(this.fXmlFile);

		// normalizing the Sample XML
		doc.getDocumentElement().normalize();

		// extracting information from XML file using DOM parser
		NodeList eventTypeList = doc.getElementsByTagName("eventType");
		NodeList eventTimestampList = doc
				.getElementsByTagName("eventTimestamp");
		NodeList requestIdList = doc.getElementsByTagName("requestID");
		NodeList portfolioIdList = doc.getElementsByTagName("portfolioID");
		NodeList dailyMonthlyIndicatorList = doc
				.getElementsByTagName("dailyMonthlyIndicator");
		NodeList asOfBusinessDateList = doc
				.getElementsByTagName("asOfBusinessDate");
		NodeList tableNameList = doc.getElementsByTagName("tableName");
		NodeList rowCountList = doc.getElementsByTagName("rowCount");

		NodeList versionIdList = doc.getElementsByTagName("versionID");
		NodeList approverIdList = doc.getElementsByTagName("approverID");
		NodeList countryCodeList = doc.getElementsByTagName("countryCode");

		// XML parsing using JAXB
		JAXBContext jaxbContext = JAXBContext
				.newInstance("com.citi.retail.optima.etl.xsd.genesis");

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		this.genesisRREvent = (GenesisRREvent) jaxbUnmarshaller.unmarshal(is);

		Assert.assertEquals(eventTypeList.item(0).getFirstChild()
				.getNodeValue(), this.genesisRREvent.getEventType().value());
		Assert.assertEquals(eventTimestampList.item(0).getFirstChild()
				.getNodeValue(), this.genesisRREvent.getEventTimestamp());
		Assert.assertEquals(requestIdList.item(0).getFirstChild()
				.getNodeValue(), this.genesisRREvent.getRequestID());

		Assert.assertEquals(dailyMonthlyIndicatorList.item(0).getFirstChild()
				.getNodeValue(), this.genesisRREvent.getDailyMonthlyIndicator()
				.value());
		Assert.assertEquals(asOfBusinessDateList.item(0).getFirstChild()
				.getNodeValue(), this.genesisRREvent.getAsOfBusinessDate());
		Assert.assertEquals(tableNameList.item(0).getFirstChild()
				.getNodeValue(), this.genesisRREvent.getTableName());
		Assert.assertEquals(
				rowCountList.item(0).getFirstChild().getNodeValue(),
				this.genesisRREvent.getRowCount());

		Assert.assertEquals(portfolioIdList.item(0).getFirstChild()
				.getNodeValue(), this.genesisRREvent.getPortfolioID()
				.toString());
		Assert.assertEquals(versionIdList.item(0).getFirstChild()
				.getNodeValue(), this.genesisRREvent.getVersionID().toString());
		Assert.assertEquals(approverIdList.item(0).getFirstChild()
				.getNodeValue(), this.genesisRREvent.getApproverID().toString());
		Assert.assertEquals(countryCodeList.item(0).getFirstChild()
				.getNodeValue(), this.genesisRREvent.getCountryCode()
				.toString());
	}
}
