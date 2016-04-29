package com.citi.retail.optima.etl.common.model;

public class TRLArchiveDetailVO {
	
	private String cntryProd;
	private boolean isTRLArchiveRequied;
	
	public String getCntryProd() {
		return cntryProd;
	}
	
	public void setCntryProd(String cntryProd) {
		this.cntryProd = cntryProd;
	}
	
	public boolean isTRLArchiveRequied() {
		return isTRLArchiveRequied;
	}
	
	public void setTRLArchiveRequied(String isTRLArchiveRequied) {
		
		if(isTRLArchiveRequied.equalsIgnoreCase("Y")){
			this.isTRLArchiveRequied = true;
		}else{
			this.isTRLArchiveRequied = false;
		}
	}
}
