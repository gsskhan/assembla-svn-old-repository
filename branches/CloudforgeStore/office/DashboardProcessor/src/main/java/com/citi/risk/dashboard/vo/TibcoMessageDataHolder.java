package com.citi.risk.dashboard.vo;

import java.util.Date;

public class TibcoMessageDataHolder {

    private String correlationID;
    private long timestamp;
    private String xmlString;
    private Date msgDateTime;

    public String getCorrelationID() {
        return correlationID;
    }

    public void setCorrelationID(String correlationID) {
        this.correlationID = correlationID;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getXmlString() {
        return xmlString;
    }

    public void setXmlString(String xmlString) {
        this.xmlString = xmlString;
    }

    public Date getMsgDateTime() {
        return msgDateTime;
    }

    public void setMsgDateTime(Date msgDateTime) {
        this.msgDateTime = msgDateTime;
    }

    @Override
    public String toString() {
        return "TibcoMessageDataHolder [correlationID=" + correlationID
                + ", timestamp=" + timestamp + ", xmlString=" + xmlString
                + ", msgDateTime=" + msgDateTime + "]";
    }
}
