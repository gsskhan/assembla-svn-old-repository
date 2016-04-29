package com.citi.ets.publisher.vo;

import java.sql.Timestamp;

public class XmlDataHolder {
	
	private String xml;
	private Timestamp time;
	
	public XmlDataHolder(String xml, Timestamp time) {
		super();
		this.xml = xml;
		this.time = time;
	}
	public String getXml() {
		return xml;
	}
	public void setXml(String xml) {
		this.xml = xml;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}	

}
