package org.dms.web.test.json;

public class NavObject {
	
	private String firstapp;
	private String lastapp;
	public NavObject(String firstapp, String lastapp) {
		super();
		this.firstapp = firstapp;
		this.lastapp = lastapp;
	}
	public String getLastapp() {
		return lastapp;
	}
	public void setLastapp(String lastapp) {
		this.lastapp = lastapp;
	}
	public String getFirstapp() {
		return firstapp;
	}
	public void setFirstapp(String firstapp) {
		this.firstapp = firstapp;
	}

}
