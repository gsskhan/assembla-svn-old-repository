create or replace
PROCEDURE ORC_JOBINSTANCE_PROC(
  p_message_id		 NUMBER,
  p_job_priority     NUMBER,
  p_job_inst_id  OUT NUMBER,
  p_error_cd     OUT NUMBER,
  p_error_msg    OUT VARCHAR)
  
AS

  l_priority 	NUMBER;
  l_job_id      NUMBER;
  l_row_count   NUMBER;
  l_thread_cnt 	NUMBER;
  l_status_cd 	VARCHAR2(10);
  l_timestamp 	TIMESTAMP := SYSDATE;  
  l_job_inst_id NUMBER := ORC_JOB_INST_SEQ.nextVal;
  
BEGIN

	p_error_cd := 0;
	p_error_msg := 'SUCCESS';
  
	BEGIN
	SELECT STS_CD 
	  INTO l_status_cd
	  FROM ORC_JOB_STS 
	 WHERE TRIM(STS_NM) = 'JOB_WAITING';
	EXCEPTION
	WHEN OTHERS THEN 
		p_error_cd := SQLCODE;
		p_error_msg := 'Error while selecting in ORC_JOB_STS table for Staus Name JOB_WAITING'||SQLERRM;
	END; 
	
	 
	BEGIN
		IF p_error_cd = 0 THEN	
			SELECT B.JOB_ID , ROWCNT_RECV  , C.PRTY  
			  INTO l_job_id , l_row_count, l_priority 
			  FROM ORC_MSG_LOG A , ORC_JOB_MSG_MAP B, ORC_JOB_DETL C , ORC_JOB_FEED_DETL D , ORC_ORIG_MSG_MAP E
			 WHERE A.ORC_MSG_TYP_ID = B.ORC_MSG_TYP_ID 
			   AND C.JOB_ID = B.JOB_ID  
			   AND A.CNTRY_CD = D.CNTRY_CD
			   AND A.PROD_ID = D.PROD_ID
			   AND A.MSG_ID = E.ORIG_MSG_ID
			AND E.MSG_ID =  p_message_id;
		END IF;
	EXCEPTION WHEN OTHERS THEN 
		p_error_cd := SQLCODE;
		p_error_msg := 'Error while fetching job_id , Row Count , Priority from Job Details Table'||SQLERRM;
	END; 
	
	BEGIN 
		IF p_error_cd = 0 THEN
			IF p_job_priority is NOT NULL THEN
				l_priority := p_job_priority;
			END IF;

			IF p_job_priority is NOT NULL THEN	 
				IF l_row_count <= 1000000 THEN
					l_thread_cnt := 1;
				ELSIF l_row_count <= 50000000 THEN
					l_thread_cnt := 8;
				ELSE
					l_thread_cnt := 12;
				END IF;	 
			ELSE 
				l_thread_cnt := 1;
			END IF;

			INSERT INTO ORC_JOB_INST(ORC_JOB_INST_ID, JOB_ID, MSG_ID, STS_CD, CURR_PRTY, THRD_CNT , STRT_TS, RPT_PRD)
			VALUES (l_job_inst_id, l_job_id, p_message_id, l_status_cd, l_priority, l_thread_cnt, l_timestamp, l_timestamp);
		END IF;
	EXCEPTION WHEN OTHERS THEN 
		p_error_cd := SQLCODE;
		p_error_msg := 'Error while inserting into ORC_JOB_INST Table '||SQLERRM;
	END;
		
	P_JOB_INST_ID := l_job_inst_id;
	
END ORC_JOBINSTANCE_PROC;