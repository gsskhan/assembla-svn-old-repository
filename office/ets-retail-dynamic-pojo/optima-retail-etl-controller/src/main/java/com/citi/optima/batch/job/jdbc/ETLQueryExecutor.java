
package com.citi.optima.batch.job.jdbc;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.core.RowMapper;

import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.util.QueryConfigUtility;
import com.citi.retail.optima.etl.controller.model.CheckSumDetailsVO;



/** Class for executing SQL queries
 * 
 * @author ab53470
 *
 */
public class ETLQueryExecutor {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(ETLQueryExecutor.class);
	
	private ConnectionManager connectionManager;
	private JdbcTemplate jdbcTemplate;
	
	
	/** Gets the db connection
	 * 
	 * @param autoCommit
	 * @return
	 * @throws Exception
	 */
	public Connection getConnection(boolean autoCommit) throws  Exception {
		Connection con=null;
		con = connectionManager.getConnection();
		if(con==null) {
			LOGGER.error("Could not get database the connection");
			throw new Exception("Could not get database the connection");
		}
		con.setAutoCommit(autoCommit);		
		return con;
	}
	
	private void cleanResources(Connection con, Statement stmt) throws SQLException{
		if (stmt != null) {
			stmt.close();
		}
		if (con != null && !con.isClosed()) {
			con.close();
		}    
	 }
	
	/** Executes update query
	 * 
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public boolean executeUpdate(String query) throws Exception {
		LOGGER.info("executeUpdate(String query)");
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			con = getConnection(true);
			pstmt = con.prepareStatement(query);
			return pstmt.execute();
		} catch (Exception ex) {
			LOGGER.error("Exception in executeUpdate(String query)",ex);
			throw ex;
		} finally {
			this.cleanResources(con, pstmt);
		}
	}
	
	/** Executes query and returns RowSetDynaClass
	 * 
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public void executeQuery(String query) throws Exception {
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			con = getConnection(true);
			pstmt = con.prepareStatement(query);
			pstmt.executeQuery();
		} catch (Exception ex) {
			LOGGER.error("Exception while executing query",ex);
			throw ex;
		} finally {
			this.cleanResources(con, pstmt);
		}
	}
	
	public void logProcessAuditErrorStep(final int fileId, final String fileName, final String type, final boolean status,
	final String comments,final String ctlFileDate, String rptDate) throws Exception {
        
        PreparedStatement pstmt = null;
        Connection con = null;
        try {
               con = getConnection(true);
               pstmt = con.prepareStatement(QueryConfigUtility.getValue("audit.update.process.query"), Statement.RETURN_GENERATED_KEYS); 
               pstmt.setInt(1, fileId);
               pstmt.setString(2,fileName);
               pstmt.setString(3, type);
               pstmt.setInt(4, status?1:0);
               pstmt.setString(5, comments);
               //pstmt.setDate(6, new java.sql.Date(getDate(ctlFileDate).getTime()));
               pstmt.setDate(6, new java.sql.Date(System.currentTimeMillis()));
/*               if(fileName.startsWith("OR_MTG_IN"))
                            {
                     pstmt.setDate(7,new java.sql.Date(getDate(fileName.split("_")[7]).getTime()));
                            }
               else if(fileName.contains("GCBC.dat") || fileName.contains("GCL.dat") || fileName.contains("OREO.dat"))
                            {
                     pstmt.setDate(7,null);
               }
               
               else*/
               if (fileName.startsWith("GN")){
            	   pstmt.setDate(7,new java.sql.Date(getDate(fileName.split("_")[6]).getTime()));
               }else{
                   pstmt.setDate(7,new java.sql.Date(getDate(rptDate).getTime()));       
               }
                     
               
               pstmt.executeQuery();
        } catch (Exception ex) {
               LOGGER.error("Exception while executing query",ex);
        } finally {
               this.cleanResources(con, pstmt);
        }
        
}
	
	public boolean logInputFileAudit(final int auditFileId,final String pFileName,
			final long ctlCount, final long datCount, boolean status, final Date startTime) throws Exception  {
		
		
		/*String pFileName=new File(processedFiles).getName();
		String[] files=auditFiles.split("&&&&");
		for (int i = 0; i < files.length; i++) {
			boolean flag=false;
			final String[] fileDetails = files[i].split(":::");
			long countrolFileCount=Long.parseLong(fileDetails[1]);
			if(pFileName.equals(fileDetails[0])){
			if(countrolFileCount==longValue){
				flag=true;
		
			}
			final boolean flagValue=flag;*/
//			final String dateValue=pFileName.split("_")[3];
			final int newFileId=getFileId( 0,"FILE_ID","HDA_AUDIT_INPUT_FILE_DETS");
			final String controlFileName=getCntFileName(auditFileId);
			int dateOfInfoPos;
			if (controlFileName.startsWith("OR_MTG_IN")){
				dateOfInfoPos = 7;
			}else{
				dateOfInfoPos = 3;
			}
			final String dateValue=controlFileName.split("_")[dateOfInfoPos];		
			
			
			PreparedStatement ps = null;
			Connection con = null;
			try {
				con = getConnection(true);
				ps = con.prepareStatement(QueryConfigUtility.getValue("audit.update.input.query"), Statement.RETURN_GENERATED_KEYS); 
				ps.setInt(1, newFileId);
				ps.setString(2, pFileName);
				ps.setString(3, dateValue);
				ps.setLong(4, ctlCount);
				ps.setLong(5, datCount);				
				ps.setTimestamp(6, new java.sql.Timestamp(getDate(dateValue).getTime()));					
				ps.setTimestamp(7, new java.sql.Timestamp(System.currentTimeMillis()));
				ps.setInt(8,status?1:0);
				ps.setString(9, controlFileName);
				ps.setTimestamp(10, new Timestamp(startTime.getTime()));
				ps.setTimestamp(11,new java.sql.Timestamp(System.currentTimeMillis()));
				ps.setInt(12,auditFileId);
				ps.executeQuery();
			} catch (Exception ex) {
				LOGGER.error("Exception while executing query",ex);
			} finally {
				this.cleanResources(con, ps);
			}
			
					
				/*if(!flagValue){
					logProcessAuditErrorStep(fileId,controlFileName,"Input Record Count Validation",false,"Given .cnt file count :"+countrolFileCount+" "
							+ "and data file count "+longValue +" is not same",fileDetails[2]);
					return false;
				}else {
					logProcessAuditErrorStep(fileId,controlFileName,"Input Record Count Validation",true,"Given .cnt file count :"+countrolFileCount+" "
							+ "and data file count "+longValue +" is same",fileDetails[2]);
				}*/
			/*}*/
		/*}*/
		
	return true;
	}
	
	
	private java.util.Date getDate(String inputDate){
		DateFormat formatter ; 
		java.util.Date date = null ; 
		   formatter = new SimpleDateFormat("yyyyMMdd");
		   try {
			date = formatter.parse(inputDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	 return date;
	}

	public int getFileId(int fileId, String columName, String tableName) {
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
	
	public String getCntFileName(int cntFileId){
		Object[] params = new Object[] { cntFileId };
		int[] requiredTypes = new int[] { Types.INTEGER };
		return jdbcTemplate.queryForList(QueryConfigUtility.getValue("audit.get.cntl.file.name.query"), params,requiredTypes, String.class).get(0).toString();
	}
	
	
	
	
	
	public void logOutputFileAudit(final Long auditFileId, String trlFileName, final java.sql.Timestamp startTime, 
			final long recordCount,final int trlId) throws SQLException{
		
		
		final String pFileName=new File(trlFileName).getName();
		final String dateValue=pFileName.split("_")[6];
		
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = getConnection(true);
			ps = con.prepareStatement(QueryConfigUtility.getValue("audit.update.output.query"), Statement.RETURN_GENERATED_KEYS); 
						ps.setInt(1, trlId);
						ps.setString(2, pFileName);
						ps.setString(3, dateValue);					
						ps.setTimestamp(4, startTime);
						ps.setLong(5, recordCount);
						ps.setInt(6, auditFileId.intValue());
			ps.executeQuery();
		} catch (Exception ex) {
			LOGGER.error("Exception while executing query",ex);
		} finally {
			this.cleanResources(con, ps);
		}
		
	}

	public ConnectionManager getConnectionManager() {
		return connectionManager;
	}

	public void setConnectionManager(ConnectionManager connectionManager) {
		this.connectionManager = connectionManager;
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
		/*public CheckSumDetailsVO getCheckSumDetailsMap(
			String countryProdCd, String fileTyp, String checkSumFieldName, String reportingDate) {
		
		Map<String, CheckSumDetailsVO> map = new HashMap<String, CheckSumDetailsVO>();
		CheckSumDetailsVO checkSumDetailsVO = new CheckSumDetailsVO();
		
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rowSet = null;
		try {
			con = getConnection(true);
			String startDate =null;
			String endDate = null;
			ps = con.prepareStatement(QueryConfigUtility.getValue("query.get.rainbow.details.with.prod.key"));
			ps.setString(1, countryProdCd);
			ResultSet dateDets = ps.executeQuery();
			if(dateDets != null && dateDets.next()){
				startDate = dateDets.getString(1);
				endDate = dateDets.getString(2);
			}
			String rainbowName = getRainbowDeciderFileName(reportingDate, startDate, endDate);
			if(rainbowName != null){
				if(ps != null){
					ps.close();
				}
				ps = con.prepareStatement(QueryConfigUtility.getValue("audit.get.checksum.detl.query.with.rainbow.key"));
				ps.setString(1, countryProdCd);
				ps.setString(2, fileTyp);
				ps.setString(3, checkSumFieldName);
				ps.setString(4, rainbowName);
				rowSet =ps.executeQuery();
			} else{
				if(ps != null){
					ps.close();
				}
				ps = con.prepareStatement(QueryConfigUtility.getValue("audit.get.checksum.detl.query"));
				ps.setString(1, countryProdCd);
				ps.setString(2, fileTyp);
				ps.setString(3, checkSumFieldName);
				rowSet =ps.executeQuery();
			}
			
		if(rowSet != null && rowSet.next()) {
			//checkSumDetailsVO = new CheckSumDetailsVO();
			checkSumDetailsVO.setCountryProdCd(rowSet.getString(1));
			checkSumDetailsVO.setInputFieldPos(rowSet.getString(2));
			checkSumDetailsVO.setOutputBalTypFieldPos(rowSet.getString(3));
			checkSumDetailsVO.setOutputBalValFieldPos(rowSet.getString(4));
			checkSumDetailsVO.setCksumFieldName(rowSet.getString(5));
			checkSumDetailsVO.setCksumBalType(rowSet.getString(6));
			//map.put(checkSumDetailsVO.getCountryProdCd(), checkSumDetailsVO);
		}
		} catch (Exception ex) {
			LOGGER.error("Exception while executing query",ex);
		} finally {
			try {
				this.cleanResources(con, ps);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return checkSumDetailsVO;
	}*/
		
		private static String getRainbowDeciderFileName(String reportingDate, String startDate, String endDate) throws ParseException {
			String rainbowDecider = null;
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			if(startDate != null && endDate != null){
				if(simpleDateFormat.parse(reportingDate).after(simpleDateFormat.parse(startDate)) && simpleDateFormat.parse(reportingDate).before(simpleDateFormat.parse(endDate))){
					rainbowDecider = "PRERNBW";
				}else if (simpleDateFormat.parse(reportingDate).after(simpleDateFormat.parse(endDate))) {
					rainbowDecider ="POSTRNBW";
				}
			}
			return rainbowDecider;
		}
	
		public void updateJobStatusAudit(final String batchNm, final String status,
				final String comments, final java.util.Date rptPrd) {
			jdbcTemplate.update(QueryConfigUtility.getValue("job.audit.query"),
					new PreparedStatementSetter() {
						@Override
						public void setValues(PreparedStatement ps)
								throws SQLException {
							ps.setString(1, batchNm);
							ps.setString(2, status);
							ps.setString(3, comments);
							ps.setDate(4, new java.sql.Date(rptPrd.getTime()));
							ps.setTimestamp(5,new java.sql.Timestamp(System.currentTimeMillis()));
						}
					});

		}
		
		public List<String> getBatchNamesList(){
		List<String> batchNamesList = jdbcTemplate.query(QueryConfigUtility.getValue("batch.name.query"), new RowMapper<String>(){

			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				String s = rs.getString("JOB_NM");
				return s;
			}
			 
		});
			return batchNamesList;
			
		}
		
		public CheckSumDetailsVO getInputCheckSumDetailsMap(
				String countryProdCd, String fileTyp, String checkSumFieldName, String reportingDate) {
			
			CheckSumDetailsVO checkSumDetailsVO = new CheckSumDetailsVO();
			
			PreparedStatement ps = null;
			Connection con = null;
			ResultSet rowSet = null;
			try {
				con = getConnection(true);
				String startDate =null;
				String endDate = null;
				ps = con.prepareStatement(QueryConfigUtility.getValue("query.get.rainbow.details.with.prod.key"));
				ps.setString(1, countryProdCd);
				ResultSet dateDets = ps.executeQuery();
				if(dateDets != null){
					while( dateDets.next()){
					startDate = dateDets.getString(1);
					endDate = dateDets.getString(2);
					}
				}
				String rainbowName = getRainbowDeciderFileName(reportingDate, startDate, endDate);
				if(rainbowName != null){
					if(ps != null){
						ps.close();
					}
					ps = con.prepareStatement(QueryConfigUtility.getValue("audit.get.checksum.detl.query.with.rainbow.key"));
					ps.setString(1, countryProdCd);
					ps.setString(2, fileTyp);
					ps.setString(3, checkSumFieldName);
					ps.setString(4, rainbowName);
					rowSet =ps.executeQuery();
				} else{
					if(ps != null){
						ps.close();
					}
					ps = con.prepareStatement(QueryConfigUtility.getValue("audit.get.checksum.detl.query"));
					ps.setString(1, countryProdCd);
					ps.setString(2, fileTyp);
					ps.setString(3, checkSumFieldName);
					rowSet =ps.executeQuery();
				}
				
			if(rowSet != null) {
				while(rowSet.next()){
				checkSumDetailsVO.setCountryProdCd(countryProdCd);
				checkSumDetailsVO.setInputFieldPos(rowSet.getString(1));
				}
			}
			} catch (Exception ex) {
				LOGGER.error("Exception while executing query",ex);
			} finally {
				try {
					this.cleanResources(con, ps);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return checkSumDetailsVO;
		}
		
		public Map<String, List<CheckSumDetailsVO>> getOutputChecksumDetails(){
			PreparedStatement ps = null;
			Connection con = null;
			ResultSet results = null;
			Map<String, List<CheckSumDetailsVO>> resultsMap = null;
			try{
				con = getConnection(true);
				ps = con.prepareStatement(QueryConfigUtility.getValue("output.audit.get.checksum.detl.query"));
				results = ps.executeQuery();
				if(results != null){
					resultsMap = new HashMap<String, List<CheckSumDetailsVO>>();
					while(results.next()){
						List<CheckSumDetailsVO> outputFieldsList = null;
						String cntryProd_trl = results.getString("CNTRY_PROD_NM")+"_"+results.getString("TRL_NM");
						CheckSumDetailsVO checksumDetails = new CheckSumDetailsVO();
						checksumDetails.setOutputBalTypFieldPos(results.getString("BALTYP_FLD_POS"));
						checksumDetails.setOutputBalValFieldPos(results.getString("CKSUM_FLD_POS"));
						checksumDetails.setCksumFieldName(results.getString("CKSUM_FLD_NM"));
						checksumDetails.setCksumBalType(results.getString("CKSUM_BAL_TYP"));
						if(!resultsMap.containsKey(cntryProd_trl)){
							outputFieldsList = new ArrayList<CheckSumDetailsVO>();
							outputFieldsList.add(checksumDetails);
							resultsMap.put(cntryProd_trl, outputFieldsList);
						} else{
							List<CheckSumDetailsVO> existedList = resultsMap.get(cntryProd_trl);
							existedList.add(checksumDetails);
							resultsMap.put(cntryProd_trl, existedList);
						}
						
					}
				}
				
			} catch(Exception e){
				e.printStackTrace();
			}
			return resultsMap;
		}
		
		public List<String> getTRLNamesOnCntryProd(String cntryProd){
			PreparedStatement ps = null;
			Connection con = null;
			ResultSet trlNames = null;
			List<String> trlNamesList = null;
			try{
				con = getConnection(true);
			ps = con.prepareStatement(QueryConfigUtility.getValue("get.trl.names.list.query"));
				ps.setString(1, cntryProd);
				trlNames = ps.executeQuery();
				if(trlNames != null){
					trlNamesList = new ArrayList<String>();
					while(trlNames.next()){
						trlNamesList.add(trlNames.getString("TRL_NM"));
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			} finally{
				
					try {
						if(ps != null){
						ps.close();
						}
						if(con != null){
							con.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
			return trlNamesList;
		}

		public void insertTRLCheckSumDetails(String controlFileName,String trlFileName,CheckSumDetailsVO checkSumDetials, String checkSum, Long auditFileId) {
			
			PreparedStatement ps = null;
			Connection con = null;
			try{
				con = getConnection(true);
				ps=con.prepareStatement(QueryConfigUtility.getValue("insert.trl.cksum.value.query"));
				ps.setString(1, controlFileName);
				ps.setString(2, trlFileName);
				ps.setString(3, checkSumDetials.getCksumFieldName());
				ps.setString(4, checkSumDetials.getOutputBalValFieldPos());
				ps.setString(5, checkSum);
				ps.setTimestamp(6, new java.sql.Timestamp(System.currentTimeMillis()));
				ps.setLong(7, auditFileId);
				ps.executeUpdate();
			}catch(Exception e){
				e.printStackTrace();
			} finally{
				
					try {
						if(ps != null){
						ps.close();
						}
						if(con != null){
							con.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
		}
		
		public Map<String,Long> getInputFilesCountMap(Long controlFileId){
			PreparedStatement ps = null;
			Connection con = null;
			Map<String,Long> inputCountMap = null;
			try{
				con = getConnection(true);
				ps = con.prepareStatement(QueryConfigUtility.getValue("query.get.input.files.count.map"));
				System.out.println("query returned is----->>>>"+QueryConfigUtility.getValue("query.get.input.files.count.map"));
				System.out.println("control file id ----->>>"+controlFileId);
				ps.setLong(1, controlFileId);
				ResultSet results = ps.executeQuery();
				if(results != null){
					inputCountMap = new HashMap<String, Long>();
					while(results.next()){
						inputCountMap.put(results.getString("INPT_FILE_NM"), Long.valueOf(results.getString("CNTL_FILE_REC_COUNT")));
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			} finally{
				try{
					if(ps != null){
						ps.close();
					}
					if(con != null){
						con.close();
					}
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return inputCountMap;
		}
		
		public Long getControlFIleIdByName(String fileName) {
			PreparedStatement ps = null;
			Connection con = null;
			Long fileId = null;
			try{
				con = getConnection(true);
				ps = con.prepareStatement(QueryConfigUtility.getValue("query.to.get.ctl.file.name.by.id"));
				ps.setString(1, fileName);
				ResultSet results = ps.executeQuery();
				if(results != null){
					while(results.next()){
						fileId = results.getLong("FILE_ID");
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			} finally{
				try{
					if(ps != null){
						ps.close();
					}
					if(con != null){
						con.close();
					}
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return fileId;
		}
		
}
