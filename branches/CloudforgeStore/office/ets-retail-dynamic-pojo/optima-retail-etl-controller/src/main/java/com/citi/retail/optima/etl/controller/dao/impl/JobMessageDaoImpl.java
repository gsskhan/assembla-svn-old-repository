package com.citi.retail.optima.etl.controller.dao.impl;

import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.citi.generic.base.util.MailUtil;
import com.citi.retail.optima.etl.common.ETLControllerConstants;
import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.db.dao.JobConfigDao;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;
import com.citi.retail.optima.etl.common.util.QueryConfigUtility;
import com.citi.retail.optima.etl.controller.dao.JobMessageDao;
import com.citi.retail.optima.etl.controller.model.EventFileMapVO;
import com.citi.retail.optima.etl.controller.model.MailDetailsVO;
import com.citi.retail.optima.etl.controller.model.MailServerVO;
import com.citi.retail.optima.etl.controller.model.MessageLog;
import com.citi.retail.optima.etl.controller.notification.impl.EmailGenerator;

/**
 * @author hs73849
 * 
 */
public class JobMessageDaoImpl implements JobMessageDao, InitializingBean {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(JobMessageDaoImpl.class);

	private JdbcTemplate jdbcTemplate;
	private JdbcTemplate genesisJdbcTemplate;
	private SimpleJdbcCall dataAcqusitionMessageJdbcCall;
	private Connection connection;
	private JobConfigDao jobConfigDao;
	
	private EmailGenerator mailNotifier;
	
	
	/**
	 * @return the mailNotifier
	 */
	public EmailGenerator getMailNotifier() {
		return mailNotifier;
	}

	/**
	 * @param mailNotifier the mailNotifier to set
	 */
	public void setMailNotifier(EmailGenerator mailNotifier) {
		this.mailNotifier = mailNotifier;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		dataAcqusitionMessageJdbcCall = new SimpleJdbcCall(
				jdbcTemplate.getDataSource())
				.withProcedureName("HDA_REQ_LOG_PROC")
				.declareParameters(
						new SqlParameter( ETLControllerConstants.P_EVENT_TYPE.getControllerConstant(),Types.CHAR),  
						new SqlParameter(ETLControllerConstants.P_REQUEST_ID.getControllerConstant(), Types.BIGINT),
						new SqlParameter(ETLControllerConstants.P_FILE_NAME.getControllerConstant(), Types.VARCHAR),
						new SqlParameter(ETLControllerConstants.P_FILE_TYPE.getControllerConstant(), Types.VARCHAR),
						new SqlParameter(ETLControllerConstants.P_REPT_PRD.getControllerConstant(), Types.NUMERIC),
						new SqlParameter(ETLControllerConstants.P_PRODUCT_CD.getControllerConstant(), Types.VARCHAR),
						new SqlParameter(ETLControllerConstants.P_COUNTRY_CD.getControllerConstant(), Types.VARCHAR),
						new SqlOutParameter(ETLControllerConstants.P_ERROR_CD
								.getControllerConstant(), Types.INTEGER),
						new SqlOutParameter(ETLControllerConstants.P_ERROR_MSG
								.getControllerConstant(), Types.VARCHAR));
		connection = jdbcTemplate.getDataSource().getConnection();
/*		arrayDescriptor = ArrayDescriptor.createDescriptor(PRODUCT_TYP_ARRAY,
				connection);
		structDescriptor = StructDescriptor.createDescriptor(
				PRODUCT_TYPE_STRUCT, connection);*/
	}

	//TODO delete
	@Override
	public Long saveInternalMessageDetails(MessageLog messageLog)
			throws OptimaRetailApplicationException {
		return null;
	}

	//TODO delete			
	@Override
	public void saveUserSubmissionMessageDetails(MessageLog messageLog)
			throws OptimaRetailApplicationException {
	}

	//TODO delete
	/**
	 * This method will invoke procedure to insert the gcbc portfolio definition request details. 
	 */
	public void saveGCBCPortfolioDefinationDetails(MessageLog messageLog)
			throws OptimaRetailApplicationException {
	}

	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Long getRequestLogId() throws OptimaRetailApplicationException {
		try {
			return jdbcTemplate.queryForLong(QueryConfigUtility.getValue("message.request.id.query"));
		} catch (DataAccessException e) {
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CONTROLLER, ExceptionType.ERROR,
					"exception occured for generating message id: ",
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e),jobConfigDao);
		}
	}

	//TODO delete
	@Override
	public void saveRequestLogId(final MessageLog messageLog)
			throws OptimaRetailApplicationException {
		//System.out.println("********************* JobMessageDaoImpl.saveRequestLogId() ****************** ");
		/*saveUserSubmissionMessageDetails(messageLog);*/
	}
	
	
	@Override
	public void saveDataAcquisitionMessageDetails(MessageLog messageLog)
			throws OptimaRetailApplicationException {
		try {
			//System.out.println("********************* JobMessageDaoImpl.saveDataAcquisitionMessageDetails() ****************** ");
			MapSqlParameterSource in = new MapSqlParameterSource();
			in.addValue(
					ETLControllerConstants.P_EVENT_TYPE.getControllerConstant(),
					messageLog.getEventType(), Types.CHAR);
			in.addValue(
					ETLControllerConstants.P_REQUEST_ID.getControllerConstant(),
					messageLog.getMessageId(), Types.BIGINT);
			
			in.addValue(
					ETLControllerConstants.P_FILE_NAME.getControllerConstant(),
					messageLog.getFileName(), Types.VARCHAR);
			
			in.addValue(
					ETLControllerConstants.P_FILE_TYPE.getControllerConstant(),
					messageLog.getFileType(), Types.VARCHAR);
			in.addValue(
					ETLControllerConstants.P_REPT_PRD.getControllerConstant(),
					messageLog.getReptPeriod(), Types.NUMERIC);
			in.addValue(
					ETLControllerConstants.P_PRODUCT_CD.getControllerConstant(),
					messageLog.getProductList().get(0), Types.VARCHAR);	
			
			in.addValue(
					ETLControllerConstants.P_COUNTRY_CD.getControllerConstant(),
					messageLog.getCountryCode(), Types.VARCHAR);						
			
			Map<String, Object> resultMap = dataAcqusitionMessageJdbcCall
					.execute(in);
			
			if ((Integer) resultMap.get(ETLControllerConstants.P_ERROR_CD
					.getControllerConstant()) != 0) {

				LOGGER.debug("RESULT Fail: " + resultMap);
				throw new OptimaRetailApplicationException(
						messageLog.getMessageId(), messageLog.getJobInstId()
								.longValue(), null, ServiceName.CONTROLLER,
						ExceptionType.ERROR,
						(String) resultMap
								.get(ETLControllerConstants.P_ERROR_MSG
										.getControllerConstant()),
						(String) resultMap
								.get(ETLControllerConstants.P_ERROR_CD
										.getControllerConstant()), null,jobConfigDao);
			}
		} catch (Exception e) {
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CONTROLLER, ExceptionType.ERROR,
					"exception occured for generating message id: ",
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e),jobConfigDao);
		}
	}
	
	@Override
	public List<EventFileMapVO> getAllControlFiles() throws OptimaRetailApplicationException {
		try {
			List<EventFileMapVO> reqEventList = jdbcTemplate
					.query(QueryConfigUtility.getValue("message.controlfile.query"), new RowMapper<EventFileMapVO>() {
						@Override
						public EventFileMapVO mapRow(ResultSet rs,
								int rowNum) throws SQLException {
							EventFileMapVO eventMap = new EventFileMapVO();
							eventMap.setReqEventId(rs.getLong("REQ_EVENT_ID"));
							eventMap.setCntrlFileFlag(rs.getString("CNTRL_FILE_FLG").equals("Y")?true:false);
							eventMap.setInputFileName(rs.getString("INPUT_FILE_NAME_EXP"));
							return eventMap;
						}
					});
			return reqEventList;
		} catch (Exception e) {
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CONTROLLER, ExceptionType.ERROR,
					"exception occured for getAllControlFiles() ",
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e),jobConfigDao);
		}		
	}
	
	
	@Override
	public List<EventFileMapVO> getSupportingFilesInfo(final Long reqEventId) throws OptimaRetailApplicationException {
		List<EventFileMapVO> eventVOList = jdbcTemplate.query(
				QueryConfigUtility.getValue("message.supportfile.query"), new PreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement ps)
							throws SQLException {
						ps.setLong(1, reqEventId);
					}
				}, new RowMapper<EventFileMapVO>() {
					@Override
					public EventFileMapVO mapRow(ResultSet rs,
							int rowNum) throws SQLException {
						EventFileMapVO eventMap = new EventFileMapVO();
						eventMap.setReqEventId(rs.getLong("REQ_EVENT_ID"));
						eventMap.setCntrlFileFlag(rs.getString("CNTRL_FILE_FLG").equals("Y")?true:false);
						eventMap.setInputFileName(rs.getString("INPUT_FILE_NAME_EXP"));
						return eventMap;
					}
				});
			return eventVOList;
		}	
	
	@Override
	public Integer updateReqLogStatus(final Long logId, final String status) throws OptimaRetailApplicationException {
		int updateCount = 0;
		try {
			updateCount = jdbcTemplate.update(QueryConfigUtility.getValue("message.update.reqlog.status"),
					new PreparedStatementSetter() {
						@Override
						public void setValues(PreparedStatement ps)
								throws SQLException {
							ps.setString(1, status);
							ps.setLong(2, logId);
						}
					});
		} catch (Exception e) {
			throw new OptimaRetailApplicationException(null, null,
					null, ServiceName.CONTROLLER, ExceptionType.ERROR,
					e.getMessage(), "Exception occured in updateReqLogStatus() for Log Id "
							+ logId,
					OptimaRetailExceptionUtil.getStackTrace(e),jobConfigDao);
		}
		return updateCount;
	}	
	
	
	@Override
	public Integer updateRequestEvent(final Long logId, final Long requestEvent) throws OptimaRetailApplicationException {
		int updateCount = 0;
		try {
			updateCount = jdbcTemplate.update(QueryConfigUtility.getValue("message.update.req.event.id"),
					new PreparedStatementSetter() {
						@Override
						public void setValues(PreparedStatement ps)
								throws SQLException {
							ps.setLong(1, requestEvent);
							ps.setLong(2, logId);
						}
					});
		} catch (Exception e) {
			throw new OptimaRetailApplicationException(null, null,
					null, ServiceName.CONTROLLER, ExceptionType.ERROR,
					e.getMessage(), "Exception occured in updateReqLogStatus() for Log Id "
							+ logId,
					OptimaRetailExceptionUtil.getStackTrace(e),jobConfigDao);
		}
		return updateCount;
	}	
	
	@Override
	public Integer insertIntoFileLog(final Long logId, final List<String> recdFileNameList) throws OptimaRetailApplicationException {
		//int updateCount = 0;
		int results[];
		try {
			results = jdbcTemplate.batchUpdate(QueryConfigUtility.getValue("message.filelog.query"),
					new BatchPreparedStatementSetter() {
						@Override
						public void setValues(PreparedStatement ps, int arg1)
								throws SQLException {
							ps.setLong(1,logId);
							ps.setString(2, recdFileNameList.get(arg1));
						}

						@Override
						public int getBatchSize() {
							return recdFileNameList.size();
						}
					});
		} catch (Exception e) {
			throw new OptimaRetailApplicationException(null, null,
					null, ServiceName.CONTROLLER, ExceptionType.ERROR,
					e.getMessage(), "Exception occured in insertIntoFileLog() for Log Id "
							+ logId,
					OptimaRetailExceptionUtil.getStackTrace(e),jobConfigDao);
		}
		return (results==null?0 :results.length);
		
	}		
	
	public JdbcTemplate getGenesisJdbcTemplate() {
		return genesisJdbcTemplate;
	}

	public void setGenesisJdbcTemplate(JdbcTemplate genesisJdbcTemplate) {
		this.genesisJdbcTemplate = genesisJdbcTemplate;
	}

	//TODO delete
	@Override
	public Long saveGenesisMessageDetails(MessageLog messageLog)
			throws OptimaRetailApplicationException {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.citi.retail.optima.etl.controller.dao.JobMessageDao#getAllFilesByBatchId(java.lang.Long)
	 * moved the logic of fetching the files based on req log to a separate method so that it can be used 
	 * in case of batch instance id is not available. For ex: if we dont receive all the data file, that case 
	 * we may want to move the files based on the req log id. 
	 */
	public List<String> getAllFilesByBatchId(Long batchInstanceId)
			throws OptimaRetailApplicationException {
		// TODO Auto-generated method stub
		
		Object [] args = {batchInstanceId};
		int [] argTypes = new int[]{Types.INTEGER};
		final Long reqLogId = jdbcTemplate.queryForLong(QueryConfigUtility.getValue("message.reqlog.query"), args, argTypes);
		return getAllFilesByReqLog(reqLogId);
		
	}
	
	public List<String> getAllFilesByReqLog(final Long reqLogId) throws OptimaRetailApplicationException {
		
		List<String> fileNameList = jdbcTemplate.query(
				QueryConfigUtility.getValue("message.filelist.query"), new PreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement ps)
							throws SQLException {
						ps.setLong(1, reqLogId);
					}
				}, new RowMapper<String>() {
					@Override
					public String mapRow(ResultSet rs,
							int rowNum) throws SQLException {
						return rs.getString("RECV_FILE_NAME");
					}
				});
		return fileNameList;
	}
	
	@Override
	public String getControlFileByBatch(Long batchInstanceId)
			throws OptimaRetailApplicationException {
		// TODO Auto-generated method stub
		
		Object [] args = {batchInstanceId};
		int [] argTypes = new int[]{Types.INTEGER};
		final Long reqLogId = jdbcTemplate.queryForLong(QueryConfigUtility.getValue("message.reqlog.query"), args, argTypes);		
	
		return getControlFileByReqLogId(reqLogId);
	}
	
	
	@Override
	public String getControlFileByReqLogId(final Long reqLogId)
			throws OptimaRetailApplicationException {
		List<String> fileNameList = jdbcTemplate.query(
				QueryConfigUtility.getValue("message.controlFile.query"), new PreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement ps)
							throws SQLException {
						ps.setLong(1, reqLogId);
					}
				}, new RowMapper<String>() {
					@Override
					public String mapRow(ResultSet rs,
							int rowNum) throws SQLException {
						return rs.getString("file_nm");
					}
				});
			//System.out.println(" file name list  "+ fileNameList.toArray().toString() + " for batch Instance Id:  "+ batchInstanceId);
		if(fileNameList!=null && fileNameList.size()>0){
			return fileNameList.get(0);
		}
		return null;
	}

	@Override
	public int logProcessAudit(final int fileId, final String fileName, final String type, final boolean status,
			final String comments, final String dateValue) {
		
		int dateOfInfoPos;
		if (fileName.startsWith("OR_MTG_IN")){
			dateOfInfoPos = 7;
		}else{
			dateOfInfoPos = 3;
		}
		//final String dateValue=fileName.split("_")[dateOfInfoPos];
		final int newFileId=getFileId( fileId,"CNTL_FILE_ID","HDA_AUDIT_PROCESS_DETS");
		/*Date dateCt=null;
		if(fileCreationDate==null){
			dateCt=null;
		} else if("".equals(fileCreationDate)){
			dateCt=new Date(System.currentTimeMillis());
		}else{
			dateCt=new Date(getDate(fileCreationDate).getTime());
		}
		*///final Date tmpDate=dateCt;
		KeyHolder keyHolder = new GeneratedKeyHolder();
		final Date sqldate ;
		if (getDate(dateValue) != null)
			sqldate = (new Date(getDate(dateValue).getTime()));
		else
			sqldate = null;
		
			jdbcTemplate.update(new PreparedStatementCreator() {  
			public PreparedStatement createPreparedStatement(Connection connection)      throws SQLException {    
				PreparedStatement ps = connection.prepareStatement(QueryConfigUtility.getValue("audit.update.process.query"), Statement.RETURN_GENERATED_KEYS); 
				ps.setInt(1, newFileId);
				ps.setString(2, fileName);
				ps.setString(3, type);
				ps.setInt(4, status?1:0);
				ps.setString(5, comments);
				//ps.setDate(6, tmpDate);
				ps.setDate(6, new java.sql.Date(System.currentTimeMillis()));
				ps.setDate(7, sqldate);
				return ps;  }
				}, keyHolder);
				//int generatedId = keyHolder.getKey().intValue();
			//poppulateEmailContent(type+(status?" Success":" Fail"),fileName);
		return newFileId;
	}
	

	
	@Override
	public int logProcessAuditErrorStep(final int fileId, final String fileName, final String type, final boolean status,
	final String comments) {
		
		//final String dateValue=fileName.split("_")[6];
		KeyHolder keyHolder = new GeneratedKeyHolder();
	
		jdbcTemplate.update(new PreparedStatementCreator() {  
			public PreparedStatement createPreparedStatement(Connection connection)      throws SQLException {    
				PreparedStatement ps = connection.prepareStatement(QueryConfigUtility.getValue("audit.update.process.query"), Statement.RETURN_GENERATED_KEYS); 
				ps.setInt(1, fileId);
				ps.setString(2, getCntFileName(fileId));
				ps.setString(3, type);
				ps.setInt(4, status?1:0);
				ps.setString(5, comments);
				ps.setDate(6, null);
				ps.setDate(7,null);
				return ps;  }
				}, keyHolder);
			
				//int generatedId = keyHolder.getKey().intValue();
		
			return fileId;
	}
	
	
	private java.util.Date getDate(String inputDate){
		DateFormat formatter ; 
		java.util.Date date = null ; 
		   formatter = new SimpleDateFormat("yyyyMMdd");
		   try {
			   if(inputDate != null && !inputDate.isEmpty()){
				   date = formatter.parse(inputDate);
			   } else{
				   date = null;
			   }
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	 return date;
	}

	private int getFileId(int fileId, String columName, String tableName) {
		int sequenceNumber=0;
		String fileIdQuery = QueryConfigUtility.getValue("audit.get.file.id.query").replaceAll("#COLUMN#", columName).replaceAll("#TABLE#", tableName);
		sequenceNumber=jdbcTemplate.queryForInt(fileIdQuery);
		if(fileId==0){
			sequenceNumber=sequenceNumber+1;
		}else{
			sequenceNumber=fileId;
		}
		return sequenceNumber;
	}
/*
	@Override
	public boolean logInputFileAudit(final Long auditFileId, String auditFiles,
			final long longValue, String processedFiles, final java.sql.Timestamp startTime) {
		final int fileId=auditFileId.intValue();
		String pFileName=new File(processedFiles).getName();
		String[] files=auditFiles.split("&&&&");
		for (int i = 0; i < files.length; i++) {
			boolean flag=false;
			final String[] fileDetails = files[i].split(":::");
			long countrolFileCount=Long.parseLong(fileDetails[1]);
			if(pFileName.equals(fileDetails[0])){
			if(countrolFileCount==longValue){
				flag=true;
		
			}
			final boolean flagValue=flag;
			final String dateValue=pFileName.split("_")[3];
			final int newFileId=getFileId( 0,"FILE_ID","HDA_AUDIT_INPUT_FILE_DETS");
			final String controlFileName=getCntFileName(fileId);
			KeyHolder keyHolder = new GeneratedKeyHolder();
				jdbcTemplate.update(new PreparedStatementCreator() {  
				public PreparedStatement createPreparedStatement(Connection connection)      throws SQLException {    
					PreparedStatement ps = connection.prepareStatement(QueryConfigUtility.getValue("audit.update.input.query"), Statement.RETURN_GENERATED_KEYS); 
					ps.setInt(1, newFileId);
					ps.setString(2, fileDetails[0]);
					ps.setString(3, dateValue);
					ps.setInt(4, Integer.parseInt(fileDetails[1]));
					ps.setLong(5, longValue);				
					ps.setTimestamp(6, new java.sql.Timestamp(getDate(fileDetails[2]).getTime()));					
					ps.setTimestamp(7, new java.sql.Timestamp(System.currentTimeMillis()));
					ps.setInt(8,flagValue?1:0);
					ps.setString(9, controlFileName);
					ps.setTimestamp(10, startTime);
					ps.setTimestamp(11,new java.sql.Timestamp(System.currentTimeMillis()));
					ps.setInt(12,fileId);
					return ps;  }
					}, keyHolder);
					//int generatedId = keyHolder.getKey().intValue();
				if(!flagValue){
					logProcessAudit(fileId,controlFileName,"Input Record Count Validation",false,"Given .cnt file count :"+countrolFileCount+" "
							+ "and data file count "+longValue +" is not same","");
					return false;
				}else {
					logProcessAudit(fileId,controlFileName,"Input Record Count Validation",true,"Given .cnt file count :"+countrolFileCount+" "
							+ "and data file count "+longValue +" is same","");
				}
			}
		}
		
	return true;
	}*/
	
	

	public boolean logs(final Long auditFileId, String auditFiles,String processedFiles, final java.sql.Timestamp startTime,long RecordCount) {
	
		String pFileName=new File(processedFiles).getName();
		final String output_TRL_Name = processedFiles;
		final String no_Of_Records= String.valueOf(RecordCount);
		String[] files=auditFiles.split("&&&&");
		for (int i = 0; i < files.length; i++) {
			boolean flag=false;
	
			final boolean flagValue=flag;
			final String dateValue=pFileName.split("_")[6];
			final int trlId=getFileId( 0,"TRL_ID","HDA_AUDIT_TRL_FILE_DETS");
			KeyHolder keyHolder = new GeneratedKeyHolder();
				jdbcTemplate.update(new PreparedStatementCreator() {  
				public PreparedStatement createPreparedStatement(Connection connection)      throws SQLException {    
					PreparedStatement ps = connection.prepareStatement(QueryConfigUtility.getValue("audit.update.output.query"), Statement.RETURN_GENERATED_KEYS); 
					ps.setInt(1, trlId);
					ps.setString(2, output_TRL_Name);
					ps.setString(3, dateValue);					
					ps.setTimestamp(4, startTime);
					ps.setString(5, no_Of_Records);
					ps.setInt(6, auditFileId.intValue());
				
					return ps;  }
					}, keyHolder);
					//int generatedId = keyHolder.getKey().intValue();
				if(!flagValue){
					return false;
				}
			
		}
		
	return true;
	}
	@Override
	public boolean logOutputFileAudit(final Long auditFileId, String trlFileName, final java.sql.Timestamp startTime, final long recordCount){
		final String pFileName=new File(trlFileName).getName();
		final String dateValue=pFileName.split("_")[6];
		final int trlId=getFileId( 0,"TRL_ID","HDA_AUDIT_TRL_FILE_DETS");
		KeyHolder keyHolder = new GeneratedKeyHolder();
			jdbcTemplate.update(new PreparedStatementCreator() {  
			public PreparedStatement createPreparedStatement(Connection connection)      throws SQLException {    
				PreparedStatement ps = connection.prepareStatement(QueryConfigUtility.getValue("audit.update.output.query"), Statement.RETURN_GENERATED_KEYS); 
				ps.setInt(1, trlId);
				ps.setString(2, pFileName);
				ps.setString(3, dateValue);					
				ps.setTimestamp(4, startTime);
				ps.setLong(5, recordCount);
				ps.setInt(6, auditFileId.intValue());
				return ps;  }}, keyHolder);
			
		return false;
	}
	
	
	private String getCntFileName(int cntFileId){
		Object[] params = new Object[] { cntFileId };
		int[] requiredTypes = new int[] { Types.INTEGER };
		return jdbcTemplate.queryForList(QueryConfigUtility.getValue("audit.get.cntl.file.name.query"), params,requiredTypes, String.class).get(0).toString();
	}
	@Override
	public void poppulateEmailContent(String validationType, String fileName,Map<String, String> argMap){
		String input = "";
		String act = "";
		String exp = "";
		String count="";
		String incksum="";
		String outcksum="";
		String country="";
		String product="";
		String cksum_field="";
		
		try {
			
			if(argMap != null) {
				input = argMap.get("#INPUT#")==null ? "" : argMap.get("#INPUT#");
				act = argMap.get("#ACT#")==null ? "" : argMap.get("#ACT#");
				exp = argMap.get("#EXP#")==null ? "" : argMap.get("#EXP#");
				count = argMap.get("#COUNT#")==null ? "" : argMap.get("#COUNT#");
				incksum = argMap.get("#IN_CKSUM#")==null ? "" : argMap.get("#IN_CKSUM#");
				outcksum = argMap.get("#OUT_CKSUM#")==null ? "" : argMap.get("#OUT_CKSUM#");
				country = argMap.get("#CNT#")==null ? "" : argMap.get("#CNT#");
				product = argMap.get("#PROD#")==null ? "" : argMap.get("#PROD#");
				cksum_field = argMap.get("#CKSUM_FIELD#")==null ? "" : argMap.get("#CKSUM_FIELD#");
				
			}
			String msgBody = null;
			Object[] params = new Object[] { validationType };
			int[] requiredTypes = new int[] { Types.VARCHAR };
			SqlRowSet rowSet = 	jdbcTemplate.queryForRowSet(QueryConfigUtility.getValue("audit.load.mail.detl.query"), params, requiredTypes);
			List<MailDetailsVO> mailList = new ArrayList<MailDetailsVO>();
			while(rowSet.next()) {
				MailDetailsVO mailDetailsVO =new MailDetailsVO();
				msgBody = rowSet.getString("MSG_DETAIL").toString().replaceAll("#FILE#", fileName)
						.replaceAll("#INPUT#", input).replaceAll("#COUNT#", count).replaceAll("#EXP#", exp).
						replaceAll("#ACT#", act).replaceAll("#IN_CKSUM#", incksum).replaceAll("#OUT_CKSUM#", outcksum).
						replaceAll("#CKSUM_FIELD#", cksum_field);
				mailDetailsVO.setMsgBody(msgBody);
				mailDetailsVO.setMsgSubject(rowSet.getString("MGS_SUB").toString().replaceAll("#FILE#", fileName).toString()
						.replaceAll("#CNT#", country).toString().replaceAll("#PROD#", product));
				mailDetailsVO.setMsgType(validationType);
				mailDetailsVO.setRecipient(rowSet.getString("RECIPIENT_ID"));
				mailDetailsVO.setSender(rowSet.getString("SENDER_ID"));
				mailDetailsVO.setCc(rowSet.getString("CC"));
				mailList.add(mailDetailsVO);
			}

			// Added
			List<MailServerVO> mailServerDetailList = jdbcTemplate
					.query(QueryConfigUtility.getValue("mail.server.details.qry"), new RowMapper<MailServerVO>() {
						@Override
						public MailServerVO mapRow(ResultSet rs,
								int rowNum) throws SQLException {
							MailServerVO mailServerVO = new MailServerVO();
							mailServerVO.setParamName(rs.getString("PARAM_NM"));
							mailServerVO.setParamVal(rs.getString("PARAM_VAL"));
							return mailServerVO;
						}
					});
			Map <String, String> mailServerMap = new HashMap<String, String>();
			for (MailServerVO mailServVo : mailServerDetailList) {
				mailServerMap.put(mailServVo.getParamName(), mailServVo.getParamVal());
			}


			if(!System.getProperty("os.name").contains("win")) {
				for(MailDetailsVO mailVo: mailList) {
					//mailNotifier.sendMail(mailVo);
					try {
                        MailUtil.sendEmail(mailServerMap.get("MAILHOST"), mailServerMap.get("MAILPORT"), mailVo.getSender(), mailServerMap.get("MAILPASS"), mailVo.getRecipient(), mailVo.getCc(), mailVo.getMsgSubject(), mailVo.getMsgBody(), null);
                 } catch (MessagingException e) {
                        e.printStackTrace();
                 }

				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			//throw e;
		}

	}

	@Override
	public int getCountForRunnableJobs() {
		//Object[] params = new Object[] { product.toUpperCase() };
		//int[] requiredTypes = new int[] { Types.VARCHAR };
		int count = jdbcTemplate.queryForInt(QueryConfigUtility.getValue("query.to.get.runnable.job"));
		return count;
	}

	@Override
	public int getCountForRunningJobs() {
		//Object[] params = new Object[] { product.toUpperCase() };
		//int[] requiredTypes = new int[] { Types.VARCHAR };
		Integer count = jdbcTemplate.queryForInt(QueryConfigUtility.getValue("query.to.get.running.job"));
		if(count == null){
			return 0;
		}
		return count;
	}

	@Override
	public void insertRunningJobs(final String product, final String fileName) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				PreparedStatement ps = con.prepareStatement(QueryConfigUtility.getValue("query.to.insert.running.job"));
				ps.setString(1, fileName);
				ps.setString(2, product.toUpperCase());
				return ps;
			}
		});
	}
	

	@Override
	public boolean isFileNameExists(final String fileName) {
		Object[] parameters = new Object[] { fileName };
		int[] requiredTypes = new int[] { Types.VARCHAR };
		Integer existedFileNameCount = jdbcTemplate.queryForInt(QueryConfigUtility.getValue("query.to.check.exist.file.name"), parameters,requiredTypes);
		if(existedFileNameCount != null && existedFileNameCount != 0){
			return true;
		}
		return false;
	}

	/**
	 * @return the jobConfigDao
	 */
	public JobConfigDao getJobConfigDao() {
		return jobConfigDao;
	}

	/**
	 * @param jobConfigDao the jobConfigDao to set
	 */
	public void setJobConfigDao(JobConfigDao jobConfigDao) {
		this.jobConfigDao = jobConfigDao;
	}

	
}	
	
