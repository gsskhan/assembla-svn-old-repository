package com.citi.retail.optima.etl.controller.audit.dao;

public interface BatchAuditLogger {

	int logProcessAudit(String fileName, String type,boolean status,String comments);
	
	
}
