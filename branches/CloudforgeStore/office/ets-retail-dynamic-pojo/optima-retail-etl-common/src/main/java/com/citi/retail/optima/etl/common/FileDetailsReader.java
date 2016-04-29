/**
 * 
 */
package com.citi.retail.optima.etl.common;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.citi.retail.optima.etl.common.model.FileColumnDetails;
import com.citi.retail.optima.etl.common.model.POCFileDetailsVO;

/**
 * @author sm59053
 * 
 */
public class FileDetailsReader {

	private static Properties props = null;
	private static Properties sqlProps = null;
	private static Connection connection = null;
	private StringBuilder columnNameList = new StringBuilder();
	public static Map<String, String> fileColumnDetailsMap = null;
	public static List<POCFileDetailsVO> pocFileDetailsVOs = null;
	public static Map<String, String> fileOutputColumnDetailsMap = null;
	public static Map<String, String> tabColumnsDetailsMap = null;
	private static FileDetailsReader fileDetailsReader;
	
	
	private FileDetailsReader() {

	}

	public static FileDetailsReader getInstance() {
		if (fileDetailsReader == null) {
			fileDetailsReader = new FileDetailsReader();
			fileDetailsReader.initPropeties();
		}
		return fileDetailsReader;
	}

	public void initPropeties() {
		props = new Properties();
		sqlProps = new Properties();
		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			InputStream stream = loader
					.getResourceAsStream("retail.optima.etl.batch.datasource.props");
			props.load(stream);
			InputStream sqlFileStream = loader
					.getResourceAsStream("retail.optima.etl.sql.queries.properties");
			sqlProps.load(sqlFileStream);
			fileColumnDetailsMap = new Hashtable<String, String>();
			fileOutputColumnDetailsMap = new Hashtable<String, String>();
			tabColumnsDetailsMap = new Hashtable<String, String>();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	private static Connection getConnection() throws Exception {

		Class.forName(props.getProperty("optima.db.sit.driverClassName"));
		connection = DriverManager.getConnection(
				props.getProperty("optima.db.sit.url"),
				props.getProperty("optima.db.sit.user"),
				props.getProperty("optima.db.sit.pass"));
		return connection;
	}
	public static final String getQuery(String name) {
		return sqlProps.getProperty(name);
	}
	private static PreparedStatement getStatement(String sql) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		return preparedStatement;

	}

	public List<POCFileDetailsVO> getTRLFileDetails(String sql) throws Exception {
		PreparedStatement prepStatement = getStatement(sql);
		ResultSet resultSet = prepStatement.executeQuery();
		List<POCFileDetailsVO> detailsVOs = new ArrayList<POCFileDetailsVO>();
		POCFileDetailsVO fileDetailsVO = null;
		
		try {
			while (resultSet.next()) {
				fileDetailsVO = new POCFileDetailsVO();
				fileDetailsVO.setDetailId(resultSet.getInt(1));
				fileDetailsVO.setBatchId(resultSet.getInt(3));
				fileDetailsVO.setFileCd(resultSet.getString(2));
				fileDetailsVO.setCountryCd(resultSet.getString(4));
				fileDetailsVO.setProductcd(resultSet.getString(5));
//				String supportingFile = resultSet.getString(6);
//				if("Y".equalsIgnoreCase(supportingFile)){
//					fileDetailsVO.setSupportFile(true);
//				}else{
//					fileDetailsVO.setSupportFile(false);
//				}
				
//				fileDetailsVO.setColumnNameList(columnNameList.substring(0,
//						columnNameList.lastIndexOf(",")).toString());
				getColumnsListForTabs(fileDetailsVO);
				detailsVOs.add(fileDetailsVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			resultSet.close();
		} finally {
			
		}
		return getFileColumnDetails(detailsVOs);
	}

	private void getColumnsListForTabs(POCFileDetailsVO fileDetailsVO) {
		String sql = getQuery("query.file.load.trl.tab.details");
		PreparedStatement prepStatement;
		try {
			prepStatement = getStatement(sql);
			prepStatement.setInt(1, fileDetailsVO.getDetailId());
			ResultSet resultSet = prepStatement.executeQuery();
			while (resultSet.next()) {
				int tabId = resultSet.getInt(1);
				String tabName = resultSet.getString(2);
				String productName = resultSet.getString(3);
				prepStatement = getStatement(getQuery("query.file.load.tab.col.map.details"));
				prepStatement.setInt(1, tabId);
				ResultSet colDetailsResultSet = prepStatement.executeQuery();
				StringBuilder columnsInTabList = new StringBuilder();
				while (colDetailsResultSet.next()) {
					columnsInTabList.append(colDetailsResultSet.getString(1)
							+ ",");
				}
				System.out.println(columnsInTabList);
				tabColumnsDetailsMap.put(
						productName + "_" + tabName,
						columnsInTabList.substring(0,
								columnsInTabList.lastIndexOf(",")).toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<POCFileDetailsVO> getFileDetails(String sql) throws Exception {
		
		List<POCFileDetailsVO> detailsVOs = new ArrayList<POCFileDetailsVO>();
		POCFileDetailsVO fileDetailsVO = null;
		ResultSet resultSet = null;
		PreparedStatement prepStatement = null;
		try {
			prepStatement = getStatement(sql);
			resultSet = prepStatement.executeQuery();

			while (resultSet.next()) {
				fileDetailsVO = new POCFileDetailsVO();
				fileDetailsVO.setDetailId(resultSet.getInt(1));
				fileDetailsVO.setBatchId(resultSet.getInt(3));
				fileDetailsVO.setFileCd(resultSet.getString(2));
				fileDetailsVO.setCountryCd(resultSet.getString(4));
				fileDetailsVO.setProductcd(resultSet.getString(5));
				if ("Y".equalsIgnoreCase(resultSet.getString(6).trim())) {
					fileDetailsVO.setSupportFile(true);
				} else {
					fileDetailsVO.setSupportFile(false);
				}
				detailsVOs.add(fileDetailsVO);
			}
		} catch (Exception e) {
			resultSet.close();
		} finally {
			// resultSet.close();
			// prepStatement.closeOnCompletion();
		}
		return detailsVOs;
	}

	public List<POCFileDetailsVO> getFileColumnDetails(List<POCFileDetailsVO> pocFileDetailsVOs) throws Exception {
		
		String colDetailsSQL = null;
		ResultSet resultSet = null;
		List<FileColumnDetails> detailsVOs = null;
		List<POCFileDetailsVO> fileDetailsVOs = new ArrayList<POCFileDetailsVO>();
		FileColumnDetails fileColumnDetailsVO = null;
		PreparedStatement stmt = null;
		try {
			
//			for (POCFileDetailsVO fileDetailsVO : pocFileDetailsVOs) {
//				System.out.println("******* "+ fileDetailsVO.getDetailId());
//			}
			for (POCFileDetailsVO fileDetailsVO : pocFileDetailsVOs) {
				colDetailsSQL = getQuery("query.file.load.column.details");
				stmt = getStatement(colDetailsSQL);
				fileDetailsVO.getDetailId();
				//System.out.println("******* fileDetailsVO.getDetailId() "+ x);
				stmt.setInt(1, fileDetailsVO.getDetailId());
				
				resultSet = stmt.executeQuery();
				columnNameList = new StringBuilder();
				detailsVOs = new ArrayList<FileColumnDetails>();
				
				
				
				while (resultSet.next()) {
					fileColumnDetailsVO = new FileColumnDetails();
					fileColumnDetailsVO.setColumnDetailsId(resultSet.getInt(1));
					fileColumnDetailsVO.setDetailId(resultSet.getInt(2));
					fileColumnDetailsVO.setColumnOrder(resultSet.getInt(6));
					fileColumnDetailsVO.setColumnName(resultSet.getString(3).trim());
					fileColumnDetailsVO.setColumnType(resultSet.getString(4));
					fileColumnDetailsVO.setColumnFormat(resultSet.getString(5));
					if (fileColumnDetailsVO.getColumnName() != null
							&& !fileColumnDetailsVO.getColumnType().contains(
									"com.citi.retail.optima.etl.common.model")&& !fileColumnDetailsVO.getColumnType().contains(
											"java")) {
						columnNameList.append(fileColumnDetailsVO
								.getColumnName() + ",");
					}
					detailsVOs.add(fileColumnDetailsVO);

				}
				fileDetailsVO.setColumnDetails(detailsVOs);
				
				if(columnNameList.lastIndexOf(",") >= 0) {
					fileDetailsVO.setColumnNameList(columnNameList.substring(0,
						columnNameList.lastIndexOf(",")).toString());
				}else{
					fileDetailsVO.setColumnNameList("");
				}
				fileColumnDetailsMap.put(
						fileDetailsVO.getCountryCd() + "_"
								+ fileDetailsVO.getProductcd() + "_"
								+ fileDetailsVO.getFileCd(),
						fileDetailsVO.getColumnNameList());
				
//				if(fileDetailsVO.getDetailId() == 67){
//					System.out.println("******************** fileDetailsVO.getDetailId() = "+ fileDetailsVO.getDetailId());
//					System.out.println(fileDetailsVO.getColumnNameList());
//				}
				fileDetailsVOs.add(fileDetailsVO);

			}
		} catch (Exception e) {
			
			resultSet.close();
			stmt.close();
			e.printStackTrace();
		} finally {
			
		}
		System.out.println("fileDetailsVOs = " + fileDetailsVOs.size());
		return fileDetailsVOs;
	}

	public static void main(String[] args) {
		FileDetailsReader reader = getInstance();

		try {
			reader.initPropeties();
			reader.getFileDetails(getQuery("query.file.load.file.details"));
			List<POCFileDetailsVO> poc=reader.getFileColumnDetails(getInstance().getFileDetails(getQuery("query.file.load.file.details")));
			for (POCFileDetailsVO string : poc) {
				System.out.println(string.getBatchId()+"  :: "+string.getColumnNameList()+"  :: "+string.getColumnDetails());
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getSuperClassName(String countryCd,String prodCd,String fileCd) {
		PreparedStatement stmt = null;
		String superClassName = null;
		try {
			stmt = getStatement(getQuery("query.file.load.file.details.extend.class"));
			stmt.setString(1, countryCd);
			stmt.setString(2, prodCd);
			stmt.setString(3, fileCd);
			ResultSet resultSet = stmt.executeQuery();
			columnNameList = new StringBuilder();
			while (resultSet.next()) {
				superClassName=resultSet.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return superClassName;
	}

	public Map<String, String> getClassNamewithMethodStringMap(String query) {
		PreparedStatement stmt = null;
		try {
			Map<String,String> classNamewithMethodStringMap = new HashMap<String, String>();
			String className;
			stmt = getStatement(query);
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				className = resultSet.getString(1);
				if(null!=className)
				{
					classNamewithMethodStringMap.put(className, resultSet.getString(2));
				}
				
			}
			System.out.println("Before Return from getClassNamewithMethodStringMap size = "+classNamewithMethodStringMap.size());
			return classNamewithMethodStringMap;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
public List<String> getCustomMethods(String query) {
		
		try {
			List<String> customMethodsList = new ArrayList< String>();
			Integer methodId;
			PreparedStatement stmt = getStatement(query);
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				methodId = resultSet.getInt(1);
				if(null!=methodId) {
					customMethodsList.add(resultSet.getString(2));
				}
			}
			System.out.println("Before Return from getClassNamewithMethodStringMap size = "+customMethodsList.size());
			return customMethodsList;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
