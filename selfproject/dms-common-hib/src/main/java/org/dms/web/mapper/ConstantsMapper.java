package org.dms.web.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.dms.web.entity.Constants;
import org.springframework.jdbc.core.RowMapper;

public class ConstantsMapper implements RowMapper<Constants> {

	@Override
	public Constants mapRow(ResultSet rs, int rownum) throws SQLException {
		Constants cons = new Constants();
		cons.setConstantId(rs.getInt("CONSTANT_ID"));
		cons.setVariable(rs.getString("VARIABLE"));
		cons.setVariableId(rs.getInt("VARIABLE_ID"));
		cons.setValue(rs.getString("VALUE"));
		cons.setParentVariableId(rs.getInt("PARENT_VARIABLE_ID"));
		return cons;
	}

}
