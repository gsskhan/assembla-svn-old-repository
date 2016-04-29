package com.citi.retail.optima.etl.batch.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.citi.retail.optima.etl.batch.dao.BatchMessageDao;
import com.citi.retail.optima.etl.batch.vo.MessageLogVO;
import com.citi.retail.optima.etl.batch.vo.mappers.MessageLogMapper;
import com.citi.retail.optima.etl.common.util.QueryConfigUtility;

/**
 * DAO class resposible for handling message log related queries.
 * 
 * @author ns21567
 * 
 */
public class BatchMessageDaoImpl implements BatchMessageDao, InitializingBean {

	private JdbcTemplate jdbcTemplate;


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public MessageLogVO getOriginalRequestMessage(final int jobinstanceId) {

		List<MessageLogVO> messageLogVo = this.jdbcTemplate.query(
				QueryConfigUtility.getValue("job.msg.query"), new PreparedStatementSetter() {

					@Override
					public void setValues(PreparedStatement ps)
							throws SQLException {
						ps.setInt(1, jobinstanceId);

					}
				}, new MessageLogMapper());

		return messageLogVo.size() > 0 ? messageLogVo.get(0) : null;

	}

	@Override
	public void afterPropertiesSet() throws Exception {

	}

}
