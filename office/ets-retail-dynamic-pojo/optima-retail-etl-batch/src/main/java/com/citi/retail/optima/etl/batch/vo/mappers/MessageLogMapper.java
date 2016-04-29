package com.citi.retail.optima.etl.batch.vo.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.citi.retail.optima.etl.batch.vo.MessageLogVO;

public class MessageLogMapper implements RowMapper<MessageLogVO> {

	@Override
	public MessageLogVO mapRow(ResultSet rs, int rowNum) throws SQLException {

		MessageLogVO messageVo = new MessageLogVO();

		messageVo.setOriginalMessageId(rs.getInt("log_id"));
		messageVo.setEventTimestamp(rs.getTimestamp("recv_ts"));
		messageVo.setFileId(rs.getLong("file_id"));
		messageVo.setFileType(rs.getString("file_typ"));
		return messageVo;
	}

}
