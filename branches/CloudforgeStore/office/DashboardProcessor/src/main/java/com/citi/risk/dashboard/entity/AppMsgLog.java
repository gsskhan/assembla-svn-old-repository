package com.citi.risk.dashboard.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author gk85985 Hibernate annotated class for db table -
 *         ETS_DSHBD_APP_MSG_LOG
 * 
 */
@Entity
@Table(name = "ETS_DSHBD_APP_MSG_LOG", schema = "CLOUDAPP")
public class AppMsgLog implements Serializable {

    private static final long serialVersionUID = -1817586726935870688L;
    private long serialNo;
    private String correlationId;
    private long timestamp;
    private String xmlFile;
    private Date lastUpdate;
    private String lastUpdatedBy;

    public AppMsgLog() {
    }

    public AppMsgLog(String correlationId, long timestamp, String xmlFile,
            Date lastUpdate, String lastUpdatedBy) {
        super();
        this.correlationId = correlationId;
        this.timestamp = timestamp;
        this.xmlFile = xmlFile;
        this.lastUpdate = lastUpdate;
        this.lastUpdatedBy = lastUpdatedBy;
    }

    @Id
    @Column(name = "SERIALNO", unique = true)
    @GeneratedValue(generator = "msg_log_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "msg_log_seq", sequenceName = "ETS_DASHBOARD_MSG_LOG_SEQ", allocationSize = 1, initialValue = 1)
    public long getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(long serialNo) {
        this.serialNo = serialNo;
    }

    @Column(name = "CORRELATION_ID")
    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    @Column(name = "TIMESTAMP")
    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Column(name = "XMLFILE")
    @Lob
    public String getXmlFile() {
        return xmlFile;
    }

    public void setXmlFile(String xmlFile) {
        this.xmlFile = xmlFile;
    }

    @Column(name = "LAST_UPDATE")
    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Column(name = "LAST_UPDATEDBY")
    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    @Override
    public String toString() {
        return "EtsDshbdAppMsgLog [serialNo=" + serialNo + ", correlationId="
                + correlationId + ", timestamp=" + timestamp + ", xmlFile="
                + xmlFile + ", lastUpdate=" + lastUpdate + ", lastUpdatedBy="
                + lastUpdatedBy + "]";
    }
}
