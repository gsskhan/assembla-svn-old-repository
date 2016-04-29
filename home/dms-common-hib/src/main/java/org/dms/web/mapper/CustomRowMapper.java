package org.dms.web.mapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

public class CustomRowMapper implements RowMapper<Map<String, ?>>{

	@Override
	public Map<String, ?> mapRow(ResultSet rs, int rowNum) throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();		
		Map<String, Object> result = new HashMap<String, Object>();
		for (int i = 1; i <= columnCount; i++) {
			result.put(rsmd.getColumnName(i), rs.getObject(i));			
		}
		return result;
	}
}
