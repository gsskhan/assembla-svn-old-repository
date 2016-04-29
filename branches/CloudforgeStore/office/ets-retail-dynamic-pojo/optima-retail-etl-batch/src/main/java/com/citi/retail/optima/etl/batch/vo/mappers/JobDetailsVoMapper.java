package com.citi.retail.optima.etl.batch.vo.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.citi.retail.optima.etl.batch.vo.BatchDetailsVO;

/**
 * 
 * @author ns21567
 * 
 */
public class JobDetailsVoMapper implements RowMapper<BatchDetailsVO> {

	@Override
	public BatchDetailsVO mapRow(ResultSet rs, int rowNum) throws SQLException {

		BatchDetailsVO jobDetailsVO = new BatchDetailsVO();
		
		jobDetailsVO.setBatchInstanceId(rs.getInt("BATCH_INST_ID"));
		jobDetailsVO.setBatchId(rs.getInt("BATCH_ID"));
		jobDetailsVO.setThreadCount(rs.getInt("THLD_CNT"));
		jobDetailsVO.setBatchName(rs.getString("JOB_NM"));
		jobDetailsVO.setThreshold(rs.getInt("THLD"));
		jobDetailsVO.setOriginalMessageId(rs.getLong("SRC_log_ID"));

		return jobDetailsVO;
	}

}
