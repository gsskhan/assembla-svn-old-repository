create or replace
PROCEDURE         ORC_INTERNAL_MESSAGE_PROC(
  p_event_type	 CHAR,
  p_reqtr_id CHAR,
  p_message	     BLOB,
  p_priority NUMBER,
  p_org_message_id NUMBER,
  p_rept_prd VARCHAR,
  p_message_id OUT NUMBER,
  p_error_cd   OUT NUMBER,
  p_error_msg  OUT VARCHAR)
  
AS
  l_timestamp TIMESTAMP := sysdate;  
  l_message_log_seqNo NUMBER := ORC_MSG_LOG_SEQ.nextVal;
  l_msg_type_id number;
BEGIN

  p_error_cd := 0;
  p_error_msg := 'SUCCESS';

  BEGIN
	IF p_error_cd = 0 THEN
		SELECT ORC_MSG_TYP_ID
		INTO  l_msg_type_id
		FROM ORC_MSG_TYP
		WHERE EVNT_TYP = p_event_type ;
	END IF;
  EXCEPTION
	WHEN OTHERS THEN 
		p_error_cd := SQLCODE;
		p_error_msg := 'Error while selecting in ORC_MSG_TYP table for Event Type'||p_event_type;
  END; 

  BEGIN
	IF p_error_cd = 0 THEN
		INSERT INTO ORC_MSG_LOG(MSG_ID,ORC_MSG_TYP_ID,RECV_TS,REQR_ID,MSG,PRTY,RPT_PRD,CRTE_DT)
		VALUES (l_message_log_seqNo,l_msg_type_id,l_timestamp, p_reqtr_id, p_message, p_priority,to_date(p_rept_prd,'YYYY-MM-DD'),sysdate);
		
		INSERT INTO ORC_ORIG_MSG_MAP(MSG_ID,ORIG_MSG_ID)
		VALUES (l_message_log_seqNo,p_org_message_id);
	END IF;
  EXCEPTION
	WHEN OTHERS THEN 
		p_error_cd := SQLCODE;
		p_error_msg := 'Error while inserting Internal Message in ORC_MSG_LOG table '||SQLERRM;
  END; 
  
  p_message_id := l_message_log_seqNo;
  
END ORC_INTERNAL_MESSAGE_PROC;