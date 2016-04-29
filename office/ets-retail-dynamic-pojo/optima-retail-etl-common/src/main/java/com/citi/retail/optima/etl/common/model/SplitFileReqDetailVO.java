package com.citi.retail.optima.etl.common.model;

public class SplitFileReqDetailVO {
	
	private String cntryProd;
	private boolean isSplitFileRequied;
	
	public String getCntryProd() {
		return cntryProd;
	}
	
	public void setCntryProd(String cntryProd) {
		this.cntryProd = cntryProd;
	}
	
	public boolean isSplitFileRequired() {
		return isSplitFileRequied;
	}
	
	public void setSplitFileRequired(String isSplitFileRequired) {
		
		if(isSplitFileRequired.equalsIgnoreCase("Y")){
			this.isSplitFileRequied = true;
		}else{
			this.isSplitFileRequied = false;
		}
	}
}
