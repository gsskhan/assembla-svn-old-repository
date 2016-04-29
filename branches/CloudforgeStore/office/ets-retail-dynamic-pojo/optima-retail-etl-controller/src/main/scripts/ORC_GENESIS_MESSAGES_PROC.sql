create or replace
PROCEDURE         ORC_GENESIS_MESSAGES_PROC(
  p_event_type	 CHAR,
  p_reqtr_id CHAR,
  p_message	     BLOB,
  p_country VARCHAR,
  p_product VARCHAR,
  p_row_count NUMBER,
  p_rept_prd VARCHAR,
  p_message_id OUT NUMBER,
  p_error_cd   OUT NUMBER,
  p_error_msg  OUT VARCHAR)
  
AS
  l_timestamp TIMESTAMP := sysdate;  
  l_message_log_seqNo NUMBER ;
  l_msg_type_id NUMBER;
  l_country_code CHAR(2);
  l_product_code NUMBER;
  
BEGIN
  
  p_error_cd := 0;
  p_error_msg := 'SUCCESS';
  
BEGIN
	SELECT ORC_MSG_TYP_ID
	  INTO  l_msg_type_id
	  FROM ORC_MSG_TYP
	 WHERE EVNT_TYP = p_event_type ;
 
EXCEPTION
	WHEN OTHERS THEN 
	p_error_cd := sqlcode;
	p_error_msg := 'Error while selecting in ORC_MSG_TYP table for Event Type'||p_event_type;
END; 
	

BEGIN
	IF p_error_cd = 0 THEN
	 SELECT CNTRY_CD
	   INTO l_country_code
	   FROM ORR_COUNTRY
	  WHERE CNTRY_DESC = p_country;
	END IF;
EXCEPTION
	WHEN OTHERS THEN 
	p_error_cd := sqlcode;
	p_error_msg := 'Error while selecting  in ORR_COUNTRY table for CNTRY_DESC'||p_country;
END;
 
BEGIN
	IF p_error_cd =0 THEN
		SELECT PROD_ID
		  INTO l_product_code
		  FROM ORR_PRODUCT
		 WHERE PROD_NM = p_product ;
	END IF;
EXCEPTION
	WHEN OTHERS THEN 
	p_error_cd := sqlcode;
	p_error_msg := 'Error while selecting  in ORR_PRODUCT table for PROD_NM'||p_product;
END;

BEGIN
	IF p_error_cd =0 THEN
		l_message_log_seqNo := ORC_MSG_LOG_SEQ.nextVal;

		INSERT INTO ORC_MSG_LOG(MSG_ID,ORC_MSG_TYP_ID,CNTRY_CD,PROD_ID,RECV_TS,REQR_ID,MSG,ROWCNT_RECV,RPT_PRD,CRTE_DT)
		VALUES (l_message_log_seqNo,l_msg_type_id,l_country_code,l_product_code,l_timestamp, p_reqtr_id,p_message, p_row_count,to_date(p_rept_prd,'YYYY-MM-DD'),sysdate);

		INSERT INTO ORC_ORIG_MSG_MAP(MSG_ID,ORIG_MSG_ID)
		VALUES (l_message_log_seqNo,l_message_log_seqNo);
  	END IF;
EXCEPTION
	WHEN OTHERS THEN 
	p_error_cd := sqlcode;
	p_error_msg := 'Error while inserting records in ORC_MSG_LOG table '||sqlerrm;
END;  
  
p_message_id:=l_message_log_seqNo;
  
END ORC_GENESIS_MESSAGES_PROC;