/**
 * 
 */
package com.citi.retail.optima.etl.common;

/**
 * @author gv74035
 *
 */
public enum ETLControllerConstants{
	
	P_EVENT_TYPE("p_event_type"),
	P_MSG("p_message"),
	P_FILE_ID("p_file_id"),
	P_FILE_TYPE("p_file_type"),
	P_REPT_PRD("p_rept_prd"),
	P_REPORT_YEAR("p_report_year"),
	P_REPORT_QTR("p_report_qtr"),
	P_MSG_ID("p_message_id"),
	P_ERROR_CD("p_error_cd"),
	P_ERROR_MSG("p_error_msg"),
	P_REQTR_ID("p_reqtr_id"),
	
	P_REQUEST("p_request"),
	P_REQUEST_ID("p_request_id"),
	P_PRIORITY("p_job_priority"),
	P_FILE_NAME("p_file_nm"),
	P_PRODUCT_CD("p_product_cd"),
	P_COUNTRY_CD("p_country_cd");
	
	private String controllerConstant;
	
	private ETLControllerConstants(String constant){
		
		this.controllerConstant = constant;
	}
	
	public String getControllerConstant(){
		return controllerConstant;
	}
	
	
}
