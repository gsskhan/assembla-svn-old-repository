create or replace
PROCEDURE "ORC_EXCEPTION_PROC"(
    p_feed_run_id      NUMBER,
    p_error_typ        VARCHAR,
    p_acct_id          NUMBER,
    p_service_name     VARCHAR,
    p_json_obj     	   BLOB,
    p_exception_detail ORC_ACCT_LVL_EXCP_TYP_ARRAY)
AS
  l_timestamp           TIMESTAMP := SYSDATE; 
  l_orc_excp_typ_cd     VARCHAR2(100);
  l_acct_lvl_excp_seqNo NUMBER := ORC_ACCT_LVL_EXCP_SEQ.NEXTVAL;
  
BEGIN

	BEGIN
		SELECT ORC_EXCP_TYP_CD 
		  INTO l_orc_excp_typ_cd
		  FROM ORC_EXCP_TYP
		 WHERE ORC_EXCP_TYP_CD = p_error_typ;
	EXCEPTION
		WHEN OTHERS THEN 
			l_orc_excp_typ_cd := 'ERROR';
	END;   
   
	INSERT INTO ORC_ACCT_LVL_EXCP (ORC_ACCT_LVL_EXCP_ID,ORC_EXCP_TYP_CD,ORC_FEED_RUN_ID,ACCT_ID,JASON_OBJ,EXCP_TS,CRTE_DT)
    VALUES (l_acct_lvl_excp_seqNo,l_orc_excp_typ_cd,p_feed_run_id,p_acct_id,p_json_obj,l_timestamp,l_timestamp);
	
    IF p_exception_detail.COUNT > 0 THEN
	    FOR i IN 1..p_exception_detail.COUNT		  LOOP
		  
		    BEGIN
			
			 SELECT ORC_EXCP_TYP_CD 
              INTO l_orc_excp_typ_cd
              FROM ORC_EXCP_TYP
             WHERE ORC_EXCP_TYP_CD = p_exception_detail(i).error_typ;
			 
			EXCEPTION
			 WHEN OTHERS THEN 
			    l_orc_excp_typ_cd := 'ERROR';
			END;
		
            INSERT INTO ORC_ATTR_LVL_EXCP (ORC_ATTR_LVL_EXCP_ID,ORC_ACCT_LVL_EXCP_ID,ORC_EXCP_TYP_CD,ROOT_EXCP,ATTR_NM,EXCP_TS,CRTE_DT)
            VALUES (ORC_ATTR_LVL_EXCP_SEQ.NEXTVAL,l_acct_lvl_excp_seqNo,l_orc_excp_typ_cd,p_exception_detail(i).root_exception,
			p_exception_detail(i).attr_nm,l_timestamp,l_timestamp);
      END LOOP;
    END IF;
        
END ORC_EXCEPTION_PROC;