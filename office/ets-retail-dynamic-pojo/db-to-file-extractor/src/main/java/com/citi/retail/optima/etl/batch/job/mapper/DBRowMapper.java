package com.citi.retail.optima.etl.batch.job.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DBRowMapper implements RowMapper {
	
	private int count = 0;

	@Override
	public String[] mapRow(ResultSet rs, int rowNum) throws SQLException {

		/*if(count == 0){
			for(int i =1 ;i < rs.getMetaData().getColumnCount();i++){
				System.out.println("column name is--->>>"
						+rs.getMetaData().getColumnName(i));
			}
			count ++;
		}*/
		
		int colCnt = rs.getMetaData().getColumnCount() - 1;
		String[] item = new String[colCnt];

		for(int i = 0; i< colCnt ; i++){
			//System.out.println("before====>");
			item[i] = rs.getString(i+1);
			//System.out.println("after====>");
		}
		return item;
	}

}