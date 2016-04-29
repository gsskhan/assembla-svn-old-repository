package com.citi.retail.optima.etl.controller.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.citi.retail.optima.etl.common.ETLBatchStatus;
import com.citi.retail.optima.etl.common.ETLControllerConstants;
import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.db.dao.JobConfigDao;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;
import com.citi.retail.optima.etl.common.util.QueryConfigUtility;
import com.citi.retail.optima.etl.controller.dao.JobInstanceDao;
import com.citi.retail.optima.etl.controller.model.BatchInstance;
import com.citi.retail.optima.etl.controller.model.MessageLog;
import com.citi.retail.optima.xsd.internal.OptimaRetailETLEvent;

/**
 * @author hs73849
 * 
 */
public class JobInstanceDaoImpl implements JobInstanceDao {

	private SimpleJdbcCall userSubmissionjdbcCall;
	private JdbcTemplate jdbcTemplate;
	private JobConfigDao jobConfigDao;
	
	private static final String P_MSG_ID = "P_MESSAGE_ID";
	private static final String P_ERR_CD = "P_ERROR_CD";
	private static final String P_ERR_MSG = "P_ERROR_MSG";
	private static final String P_BATCH_INSTANCE_ID = "P_BATCH_INSTANCE_ID";
	private static final String JOB_PROCESS_STATUS = "JOB_PROCESS_STATUS";
	private static final String SUCCESS = "TRUE";

	public void init() throws Exception {

		userSubmissionjdbcCall = new SimpleJdbcCall(
				jdbcTemplate.getDataSource())
				.withProcedureName("HDA_LOAD_BATCH_JOB_INST_PROC")
				.declareParameters(
						new SqlParameter(
								ETLControllerConstants.P_REQUEST_ID
										.getControllerConstant(),
								Types.BIGINT),
						new SqlParameter(ETLControllerConstants.P_PRIORITY
								.getControllerConstant(), Types.BIGINT),
						new SqlOutParameter("P_JOB_INST_ID", Types.BIGINT),
						new SqlOutParameter(P_ERR_CD, Types.INTEGER),
						new SqlOutParameter(P_ERR_MSG, Types.VARCHAR));

	}// init

	/**
	 * 
	 * @param batchInstanceId
	 * @return
	 * @throws OptimaRetailApplicationException
	 */
	@Override
	public Long getRequestLogId(Long batchInstanceId) throws OptimaRetailApplicationException{
		Object [] args = {batchInstanceId};
		int [] argTypes = new int[]{Types.INTEGER};
		Long reqLogId = jdbcTemplate.queryForLong(QueryConfigUtility.getValue("message.reqlog.query"), args, argTypes);		
		return reqLogId;
	}
	
	//TODO delete
	@Override
	public BatchInstance getJobInstanceDetails(Long jobInstanceId)
			throws OptimaRetailApplicationException {
		BatchInstance batchInstanceVO = null;
		return batchInstanceVO;
	}

	@Override
	public Integer updateJobRunningStatus(Long jobInstanceId, Long jobId,
			ETLBatchStatus jobStatus) throws OptimaRetailApplicationException {
		int count = 0;
		//System.out.println("********************* JobInstanceDaoImpl.updateJobRunningStatus() ****************** ");
		try {
			count = jdbcTemplate.update(QueryConfigUtility.getValue("batch.running.status.query"), new Object[] {
					jobStatus.name(), new Date(), jobInstanceId });
			if (count > 0) {
				count = jdbcTemplate.update(QueryConfigUtility.getValue("job.running.status.query"),
						new Object[] { jobStatus.name(), new Date(), jobId });
			}

		} catch (Exception e) {
			throw new OptimaRetailApplicationException(null, jobInstanceId,
					null, ServiceName.CONTROLLER, ExceptionType.ERROR,
					e.getMessage(), "Exception occured for JobInstance Id "
							+ jobInstanceId,
					OptimaRetailExceptionUtil.getStackTrace(e),jobConfigDao);
		}
		return count;
	}

	@Override
	public Boolean updateJobCompletionStatus(Long batchInstanceId)
			throws OptimaRetailApplicationException {
		
		//System.out.println("********************* JobInstanceDaoImpl.updateJobCompletionStatus() ****************** ");
		boolean isJobComplted = false;
		try {
			

			 SqlParameterSource in = new MapSqlParameterSource().
                     addValue(P_BATCH_INSTANCE_ID, batchInstanceId);

			 SimpleJdbcCall  jdbcCall =  new SimpleJdbcCall(jdbcTemplate.getDataSource()).
                     withProcedureName("HDA_JOB_COMPLETE_UPDATE_PROC");
			 
			 Map<String, Object> out = jdbcCall.execute(in); 
			 isJobComplted =  ((String)out.get(JOB_PROCESS_STATUS)).equalsIgnoreCase(SUCCESS);
			
			 
		} catch (Exception e) {
			throw new OptimaRetailApplicationException(null, batchInstanceId,
					null, ServiceName.CONTROLLER, ExceptionType.ERROR,
					e.getMessage(), "Exception occured in updateJobCompletionStatus() for batchInstance Id "
							+ batchInstanceId,
					OptimaRetailExceptionUtil.getStackTrace(e),jobConfigDao);
		}
		return isJobComplted;
	}

	@Override
	public OptimaRetailETLEvent getJobRequestDetails(Long batchInstanceId)
			throws OptimaRetailApplicationException {
		OptimaRetailETLEvent jobRequestEvnt = null;
		//System.out.println("********************* JobInstanceDaoImpl.getJobRequestDetails() ****************** ");
		try {
			jobRequestEvnt = jdbcTemplate.queryForObject(QueryConfigUtility.getValue("job.request.query"),
					new Object[] { batchInstanceId },
					new RowMapper<OptimaRetailETLEvent>() {
						@Override
						public OptimaRetailETLEvent mapRow(ResultSet rs,
								int rowNum) throws SQLException {
							OptimaRetailETLEvent jobRequstEvent = new OptimaRetailETLEvent();
							jobRequstEvent.setEventTimestamp(rs
									.getString("EVENT_TIME"));
							jobRequstEvent.setRequestID(rs.getString("REQR_ID"));
							jobRequstEvent.setReportPeriod(rs
									.getString("RTPR_PRD"));
							return jobRequstEvent;
						}
					});
		} catch (Exception e) {
			throw new OptimaRetailApplicationException(null, null,
					batchInstanceId, ServiceName.CONTROLLER,
					ExceptionType.ERROR, e.getMessage(),
					"Exception occured for Batch Instance Id "
							+ batchInstanceId,
					OptimaRetailExceptionUtil.getStackTrace(e),jobConfigDao);
		}

		return jobRequestEvnt;
	}

	//TODO delete
	@Override
	public Map<String, Object> createUserSubmissionJobInstance(
			MessageLog messageLogVO) throws OptimaRetailApplicationException {
		return null;
	}
	
	
	@Override
	public Map<String, Object> createDataAcquisitionJobInstance(
			MessageLog messageLogVO) throws OptimaRetailApplicationException {
		try {
			//System.out.println("********************* JobInstanceDaoImpl.createDataAcquisitionJobInstance() ****************** ");

			MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
			sqlParameterSource
					.addValue(ETLControllerConstants.P_REQUEST_ID
							.getControllerConstant(), messageLogVO
							.getMessageId(), Types.BIGINT);
			sqlParameterSource.addValue(
					ETLControllerConstants.P_PRIORITY.getControllerConstant(),
					messageLogVO.getPriority(), Types.BIGINT);

			Map<String, Object> resultMap = userSubmissionjdbcCall
					.execute(sqlParameterSource);

			if ((Integer) resultMap.get(P_ERR_CD) != 0) {

				throw new OptimaRetailApplicationException(
						messageLogVO.getMessageId(), messageLogVO
								.getJobInstId().longValue(), null,
						ServiceName.CONTROLLER, ExceptionType.ERROR, P_ERR_MSG,
						resultMap.get(P_ERR_CD).toString(), null,jobConfigDao);
			}
			return resultMap;
		} catch (Exception e) {
			throw new OptimaRetailApplicationException(
					messageLogVO.getMessageId(), null, null,
					ServiceName.CONTROLLER, ExceptionType.ERROR,
					e.getMessage(), "Exception occured for MessageId "
							+ messageLogVO.getMessageId(),
					OptimaRetailExceptionUtil.getStackTrace(e),jobConfigDao);
		}
	}

	@Override
	public String getEventTypeForBatchInstance(Long batchInstanceId)
			throws OptimaRetailApplicationException {
		Object[] params = new Object[] { batchInstanceId };
		int[] requiredTypes = new int[] { Types.BIGINT };
		return jdbcTemplate.queryForObject(QueryConfigUtility.getValue("batch.event.type.query"), params,
				requiredTypes, String.class);
	}
	
	//TODO should be at one place only presently its in both DAO
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

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
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
