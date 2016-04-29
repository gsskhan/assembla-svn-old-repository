package com.citi.risk.dashboard.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import com.citi.risk.dashboard.exception.ProcessorException;
import com.citi.risk.dashboard.vo.DashboardKPIBean;
import com.citi.risk.dashboard.vo.DashboardXMLBean;

/**
 * @author gc63735
 * 
 */
public class DashboardResponseXmlParserHandler extends DefaultHandler {

    private Logger log = Logger
            .getLogger(DashboardResponseXmlParserHandler.class);
    private DashboardXMLBean responseBean;
    private List<DashboardKPIBean> kpiDetailList;
    private DashboardKPIBean kpiBean;
    private StringBuilder characters = new StringBuilder(64);

    public DashboardXMLBean getResponseBean() {
        return responseBean;
    }

    @Override
    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("p:ETSFeed")) {
            responseBean = new DashboardXMLBean();
            kpiDetailList = new ArrayList<DashboardKPIBean>();
        }
        if (qName.equalsIgnoreCase("p:kpiDetail")) {
            kpiBean = new DashboardKPIBean();
        }
        if (qName.equalsIgnoreCase("p:kpiStatus")) {
            kpiBean.setKpiStatusCode(attributes.getValue("statusCode"));
        }
    }

    @Override
    public void characters(char[] value, int start, int end)
            throws SAXException {
        characters.append(new String(value, start, end));
    }

    @Override
    public void endElement(String arg0, String arg1, String element)
            throws SAXException {
        final String content = characters.toString();
        characters.setLength(0);
        // general app data
        try {
            if (element.equalsIgnoreCase("p:csi")) {
                responseBean.setApplicationCsi(content);
            }
            if (element.equalsIgnoreCase("p:appName")) {
                responseBean.setApplicationFullName(content);
            }
            // kpi details data
            if (element.equalsIgnoreCase("p:kpiName")) {
                kpiBean.setKpiName(content);
            }
            if (element.equalsIgnoreCase("p:statusDesc")) {
                kpiBean.setKpiDescription(content);
            }
            if (element.equalsIgnoreCase("p:kpiStatus")) {
                kpiBean.setKpiValue(content);
            }
            if (element.equalsIgnoreCase("p:kpiparameter")) {
                kpiBean.setKpiParameter(content);
            }
            if (element.equalsIgnoreCase("p:eventtimestamp")) {
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
                Date eventTimestamp;
                try {
                    eventTimestamp = df.parse(content);
                    String newDateString = df.format(eventTimestamp);
                    log.debug("Formatted Date obj value of the string <p:eventtimestamp>"
                            + newDateString);
                    kpiBean.setEventTimestamp(eventTimestamp);
                } catch (ParseException e) {
                    log.debug("EventTimestamp parsing error inside 'DashboardResponseXmlParserHandler' class... "
                            + e);
                }
            }
            if (element.equalsIgnoreCase("p:kpiDetail")) {
                kpiDetailList.add(kpiBean);
            }
            if (element.equalsIgnoreCase("p:ETSFeed")) {
                responseBean.setKpiList(kpiDetailList);
            }
        } catch (ProcessorException e) {
            log.error("Unable to parse the xml message due to bad xml format data with no <p:ETSFeed> or no <p:appdata>"
                    + " or no <p:kpiDetail>. Please check the xml text message!");
        }
    }
}
