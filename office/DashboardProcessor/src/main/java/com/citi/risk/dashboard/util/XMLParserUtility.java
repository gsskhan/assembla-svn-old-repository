package com.citi.risk.dashboard.util;

import java.io.IOException;
import java.io.StringReader;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.apache.log4j.Logger;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import com.citi.risk.dashboard.vo.DashboardKPIBean;
import com.citi.risk.dashboard.vo.DashboardXMLBean;

/**
 * @author gc63735,gk85985 To parse the XML from jms message. To validate the
 *         contents of parsed XML
 */
public class XMLParserUtility {

    private Logger log = Logger.getLogger(XMLParserUtility.class);

    public DashboardXMLBean parsedXML(String xmlData)
            throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        DashboardResponseXmlParserHandler handler = new DashboardResponseXmlParserHandler();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        saxParser.parse(new InputSource(new StringReader(xmlData)), handler);
        log.info("KPI details from XMLBean == "
                + handler.getResponseBean().getKpiList());
        return handler.getResponseBean();
    }

    /**
     * To validate the contents of parsed xml.
     * 
     * @param dashboardXMLBean
     * @return boolean
     */
    public boolean validateParsedXml(DashboardXMLBean dashboardXMLBean) {
        if (dashboardXMLBean == null) {
            log.error("Parsed xml equivalent java bean 'DashboardXMLBean' class is null or empty. Please check contents of xml received.");
            return false;
        } else if (dashboardXMLBean.getApplicationCsi() == null
                || dashboardXMLBean.getApplicationCsi().trim().isEmpty()) {
            log.error("Application CSI ID is null or empty in XML. Please check contents of xml received.");
            return false;
        } else if (dashboardXMLBean.getApplicationFullName() == null
                || dashboardXMLBean.getApplicationFullName().trim().isEmpty()) {
            log.error("Application Name is null or empty in XML. Please check contents of xml received.");
            return false;
        }
        for (DashboardKPIBean kpiBean : dashboardXMLBean.getKpiList()) {
            if (kpiBean.getKpiName() == null
                    || kpiBean.getKpiName().trim().isEmpty()) {
                log.error("KpiName is null or empty in XML. Please check contents of xml received.");
                return false;
            } else if (kpiBean.getKpiStatusCode() == null
                    || kpiBean.getKpiStatusCode().trim().isEmpty()) {
                log.error("KpiStatusCode is null or empty in XML. Please check contents of xml received.");
                return false;
            } else if (kpiBean.getKpiDescription() == null
                    || kpiBean.getKpiDescription().trim().isEmpty()) {
                log.error("kpiDescription is null or empty in XML. Please check contents of xml received.");
                return false;
            } else if (kpiBean.getKpivalue() == null
                    || kpiBean.getKpivalue().trim().isEmpty()) {
                log.error("Kpivalue is null or empty in XML. Please check contents of xml received.");
                return false;
            } else if (kpiBean.getKpiParameter() == null
                    || kpiBean.getKpiParameter().trim().isEmpty()) {
                log.error("KpiParameter is null or empty in XML. Please check contents of xml received.");
                return false;
            } else if (kpiBean.getEventTimestamp() == null) {
                log.error("EventTimestamp is null or empty in XML. Please check contents of xml received.");
                return false;
            }
        }
        return true;
    }
}
