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

import com.citi.retail.optima.etl.common.model.SplitFileReqDetailVO;
import com.citi.retail.optima.etl.common.model.TRLArchiveDetailVO;
import com.citi.retail.optima.etl.common.util.QueryConfigUtility;

public class TRLArchiveDaoImpl implements TRLArchiveDao {
	
	private JdbcTemplate jdbcTemplate;
	
	/*@Value("${query.get.trl.archive.details}")
	private String queryToGetFilePath;*/

	@Override
	public Map<String, TRLArchiveDetailVO> loadTRLArchiveDetails() {

		List<TRLArchiveDetailVO> trlArchivesList = jdbcTemplate.query(QueryConfigUtility.getValue("query.get.trl.archive.details"), new PreparedStatementSetter() {
			
			
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
			}
		},  new RowMapper<TRLArchiveDetailVO>(){

			@Override
			public TRLArchiveDetailVO mapRow(ResultSet rs, int rownum)
					throws SQLException {
				TRLArchiveDetailVO trlArchiveDetailVO = new TRLArchiveDetailVO();
				trlArchiveDetailVO.setCntryProd(rs.getString("CNTRY_PROD_NM"));
				trlArchiveDetailVO.setTRLArchiveRequied(rs.getString("TRL_ARCHIV_REQ"));
				return trlArchiveDetailVO;
			}
		});
		

		
		Map<String,TRLArchiveDetailVO> trlArchiveDetailsMap = new HashMap<String, TRLArchiveDetailVO>();
		for(TRLArchiveDetailVO fileVo: trlArchivesList){
			trlArchiveDetailsMap.put(fileVo.getCntryProd(), fileVo);
		}
		return trlArchiveDetailsMap;
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

	@Override
	public Map<String, SplitFileReqDetailVO> loadSplitFileReqDetails() {


		List<SplitFileReqDetailVO> splitFileReqsList = jdbcTemplate.query(QueryConfigUtility.getValue("query.get.trl.split.file.req.details"), new PreparedStatementSetter() {
			
			
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
			}
		},  new RowMapper<SplitFileReqDetailVO>(){

			@Override
			public SplitFileReqDetailVO mapRow(ResultSet rs, int rownum)
					throws SQLException {
				SplitFileReqDetailVO splitFileReqDetailVO = new SplitFileReqDetailVO();
				splitFileReqDetailVO.setCntryProd(rs.getString("CNTRY_PROD_NM"));
				splitFileReqDetailVO.setSplitFileRequired(rs.getString("SPLIT_FILE_REQ"));
				return splitFileReqDetailVO;
			}
		});
		

		
		Map<String,SplitFileReqDetailVO> splitFileReqDetailsMap = new HashMap<String, SplitFileReqDetailVO>();
		for(SplitFileReqDetailVO fileVo: splitFileReqsList){
			splitFileReqDetailsMap.put(fileVo.getCntryProd(), fileVo);
		}
		return splitFileReqDetailsMap;
	
	}
	
	

	

}
