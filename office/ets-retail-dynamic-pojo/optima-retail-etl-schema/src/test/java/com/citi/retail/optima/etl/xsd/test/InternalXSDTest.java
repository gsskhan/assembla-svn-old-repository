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

import com.citi.retail.optima.xsd.internal.OptimaRetailETLEvent;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/retail.optima.etl.schema.test.context.xml" })
public class InternalXSDTest {

	// Defined Internal XSD
	private OptimaRetailETLEvent optimaRetailEvent;

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
				"target\\test-classes\\Attest_Feed_Request.xml");

		InputStream is = new FileInputStream(this.fXmlFile);

		Assert.assertNotNull(this.fXmlFile);

		dbFactory = DocumentBuilderFactory.newInstance();
		dBuilder = dbFactory.newDocumentBuilder();
		doc = dBuilder.parse(this.fXmlFile);

		// normalizing the Sample XML
		doc.getDocumentElement().normalize();

		// extracting information from XML file using DOM parser
		NodeList eventTypeList = doc.getElementsByTagName("eventType");
		NodeList reportPeriodList = doc.getElementsByTagName("reportPeriod");
		NodeList jobInstanceIdList = doc
				.getElementsByTagName("batchInstanceId");
		NodeList eventTimestampList = doc
				.getElementsByTagName("eventTimestamp");
		NodeList requestIdList = doc.getElementsByTagName("requestID");
		NodeList referenceMsgIdList = doc.getElementsByTagName("originalMsgId");
		NodeList priorityList = doc.getElementsByTagName("priority");

		NodeList portfolioIdList = doc.getElementsByTagName("portfolioID");
		NodeList scheduleIdList = doc.getElementsByTagName("scheduleID");

		NodeList versionIdList = doc.getElementsByTagName("versionID");
		NodeList approverIdList = doc.getElementsByTagName("approverID");
		NodeList batchInstanceIdList = doc
				.getElementsByTagName("batchInstanceId");
		NodeList countryCodeList = doc.getElementsByTagName("countryCode");

		// XML parsing using JAXB
		JAXBContext jaxbContext = JAXBContext
				.newInstance("com.citi.retail.optima.xsd.internal");

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		this.optimaRetailEvent = (OptimaRetailETLEvent) jaxbUnmarshaller
				.unmarshal(is);

		// Checking equality of values between DOM and JAXB extraction (JAXB
		// using the generated XSD)
		Assert.assertEquals(eventTypeList.item(0).getFirstChild()
				.getNodeValue(), this.optimaRetailEvent.getEventType().value());
		Assert.assertEquals(reportPeriodList.item(0).getFirstChild()
				.getNodeValue(), this.optimaRetailEvent.getReportPeriod());
		Assert.assertEquals(jobInstanceIdList.item(0).getFirstChild()
				.getNodeValue(), this.optimaRetailEvent.getBatchInstanceId()
				.toString());
		Assert.assertEquals(eventTimestampList.item(0).getFirstChild()
				.getNodeValue(), this.optimaRetailEvent.getEventTimestamp());
		Assert.assertEquals(requestIdList.item(0).getFirstChild()
				.getNodeValue(), this.optimaRetailEvent.getRequestID());

		Assert.assertEquals(referenceMsgIdList.item(0).getFirstChild()
				.getNodeValue(), this.optimaRetailEvent.getOriginalMsgId()
				.toString());
		Assert.assertEquals(
				priorityList.item(0).getFirstChild().getNodeValue(),
				this.optimaRetailEvent.getPriority().toString());
		Assert.assertEquals(scheduleIdList.item(0).getFirstChild()
				.getNodeValue(), this.optimaRetailEvent.getScheduleID()
				.toString());
		Assert.assertEquals(portfolioIdList.item(0).getFirstChild()
				.getNodeValue(), this.optimaRetailEvent.getPortfolioID()
				.toString());
		Assert.assertEquals(versionIdList.item(0).getFirstChild()
				.getNodeValue(), this.optimaRetailEvent.getVersionID()
				.toString());
		Assert.assertEquals(approverIdList.item(0).getFirstChild()
				.getNodeValue(), this.optimaRetailEvent.getApproverID()
				.toString());
		Assert.assertEquals(batchInstanceIdList.item(0).getFirstChild()
				.getNodeValue(), this.optimaRetailEvent.getBatchInstanceId()
				.toString());
		Assert.assertEquals(countryCodeList.item(0).getFirstChild()
				.getNodeValue(), this.optimaRetailEvent.getCountryCode()
				.toString());
	}
}
