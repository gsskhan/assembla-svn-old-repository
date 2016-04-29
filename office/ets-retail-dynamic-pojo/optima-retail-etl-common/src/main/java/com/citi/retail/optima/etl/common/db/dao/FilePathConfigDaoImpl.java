package com.citi.retail.optima.etl.common.db.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import com.citi.retail.optima.etl.common.model.FilePathDetailVO;
import com.citi.retail.optima.etl.common.util.QueryConfigUtility;

public class FilePathConfigDaoImpl implements FilePathConfigDao {
	
	private JdbcTemplate jdbcTemplate;
	
	/*@Value("${query.get.file.path}")
	private String queryToGetFilePath;*/

	@Override
	public Map<String, FilePathDetailVO> loadFilePaths() {
		String env = null;
		if(System.getProperty("os.name").toLowerCase().indexOf("win") >= 0){
			env = "WINDOWS";
		} else{
			env = "UNIX";
		}
		final String dbEnv = env;
		List<FilePathDetailVO> filePathsList = jdbcTemplate.query(QueryConfigUtility.getValue("query.get.file.path"), new PreparedStatementSetter() {
			
			
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
					ps.setString(1, dbEnv);
				
			}
		},  new RowMapper<FilePathDetailVO>(){

			@Override
			public FilePathDetailVO mapRow(ResultSet rs, int rownum)
					throws SQLException {
				FilePathDetailVO filePathDetailVo = new FilePathDetailVO();
				filePathDetailVo.setCntryProd(rs.getString("CNTRY_PROD").trim().toLowerCase());
				filePathDetailVo.setInputFilePath(rs.getString("INPUT_DIR_PATH").trim());
				filePathDetailVo.setOutputPath(rs.getString("OUTPUT_DIR_PATH").trim());
				filePathDetailVo.setProcessedPath(rs.getString("PROCESS_DIR_PATH").trim());
				filePathDetailVo.setArchivePath(rs.getString("ARCHIVE_DIR_PATH").trim());
				return filePathDetailVo;
			}
		});
		
		/*jdbcTemplate.query(queryToGetFilePath, new RowMapper<FilePathDetailVO>(){

			@Override
			public FilePathDetailVO mapRow(ResultSet rs, int rownum)
					throws SQLException {
				FilePathDetailVO filePathDetailVo = new FilePathDetailVO();
				filePathDetailVo.setCntryProd(rs.getString("CNTRY_PROD").trim().toLowerCase());
				filePathDetailVo.setInputFilePath(rs.getString("INPUT_DIR_PATH").trim());
				filePathDetailVo.setOutputPath(rs.getString("OUTPUT_DIR_PATH").trim());
				filePathDetailVo.setProcessedPath(rs.getString("PROCESS_DIR_PATH").trim());
				filePathDetailVo.setArchivePath(rs.getString("ARCHIVE_DIR_PATH").trim());
				return filePathDetailVo;
			}
			
		});*/
		
		Map<String,FilePathDetailVO> filePathDetailsMap = new HashMap<String, FilePathDetailVO>();
		for(FilePathDetailVO fileVo: filePathsList){
			filePathDetailsMap.put(fileVo.getCntryProd(), fileVo);
		}
		return filePathDetailsMap;
	}

	/**
	 * @return the jdbcTemplate
	 */
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	/**
	 * @param jdbcTemplate the jdbcTemplate to set
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	

	

}
