package org.dms.web.core;

public enum SystemConstants {
	
	ROLE_ADMIN("ADMINISTRATOR"),
	ROLE_STUDENT("STUDENT"),
	ROLE_PRINCIPAL("PRINCIPAL"),
	ROLE_TEACHER("TEACHER"),
	PAPER_STATUS_CREATED("CREATED"),
	PAPER_STATUS_PEND_AUTH("PENDING AUTHORIZATION"),
	PAPER_STATUS_AUTH("AUTHORIZED"),
	PAPER_STATUS__PEND_APPROVAL("PENDING APPROVAL"),
	PAPER_STATUS_APPROVED("APPROVED"),
	PAPER_STATUS_REJECTED("REJECTED"); 
	
	private String value;
	
	SystemConstants(String val){
		this.value = val;
	}
	
	public String getValue(){
		return value;
	}
}
