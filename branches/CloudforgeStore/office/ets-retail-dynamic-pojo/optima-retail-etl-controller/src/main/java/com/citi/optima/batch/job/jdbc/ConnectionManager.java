package com.citi.optima.batch.job.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.sql.DataSource;

import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;

public class ConnectionManager implements InitializingBean {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ConnectionManager.class);
	private DataSource ds = null;
	
	//public static final ConnectionManager INSTANCE = new ConnectionManager();
	
	//@Value("${optima.db.driverClassName}")
	private String dbDriverName;

	//@Value("${optima.db.url}")
	private String dbUri;

	//@Value("${optima.db.user}")
	private String dbUser;

	//@Value("${optima.db.pass}")
	private String dbPwd;


	/**
	 * @param config
	 *            configuration from an XML file.
	 */
	private ConnectionManager() {
		
	}

	/**
	 * destructor
	 */
	protected void finalize() {
		LOGGER.debug("Finalizing ConnectionManager");
		try {
			super.finalize();
		} catch (Throwable ex) {
			LOGGER.error(
					"ConnectionManager finalize failed to disconnect from mysql: ",
					ex);
		}
	}
	
	/**
	 * connectToDB - Connect to the DB
	 */
	private void connectToDB() {
		try {
			java.lang.Class.forName(dbDriverName).newInstance();
		} catch (Exception e) {
			LOGGER.error(
					"Error when attempting to obtain DB Driver: "
							+ dbDriverName + " on "
							+ new Date().toString(), e);
		}

		LOGGER.debug("Trying to connect to database...");
		try {
			ds = setupDataSource(dbUri,
					dbUser, dbPwd,
					2, 10);

			LOGGER.debug("Connection attempt to database succeeded.");
		} catch (Exception e) {
			LOGGER.error("Error when attempting to connect to DB ", e);
		}
	}
	
	/**
	 * 
	 * @param connectURI
	 *            - JDBC Connection URI
	 * @param username
	 *            - JDBC Connection username
	 * @param password
	 *            - JDBC Connection password
	 * @param minIdle
	 *            - Minimum number of idel connection in the connection pool
	 * @param maxActive
	 *            - Connection Pool Maximum Capacity (Size)
	 * @throws Exception
	 */
	private DataSource setupDataSource(String connectURI,
			String username, String password, int minIdle, int maxActive)
			throws Exception {
		//
		// First, we'll need a ObjectPool that serves as the
		// actual pool of connections.
		//
		// We'll use a GenericObjectPool instance, although
		// any ObjectPool implementation will suffice.
		//
		GenericObjectPool connectionPool = new GenericObjectPool(null);

		connectionPool.setMinIdle(minIdle);
		connectionPool.setMaxActive(maxActive);

		// we keep it for two reasons
		// #1 We need it for statistics/debugging
		// #2 PoolingDataSource does not have getPool()
		// method, for some obscure, weird reason.

		//
		// Next, we'll create a ConnectionFactory that the
		// pool will use to create Connections.
		// We'll use the DriverManagerConnectionFactory,
		// using the connect string from configuration
		//
		ConnectionFactory connectionFactory = new DriverManagerConnectionFactory(
				connectURI, username, password);

		//
		// Now we'll create the PoolableConnectionFactory, which wraps
		// the "real" Connections created by the ConnectionFactory with
		// the classes that implement the pooling functionality.
		//
		new PoolableConnectionFactory(connectionFactory, connectionPool, null,
				null, false, true);

		PoolingDataSource dataSource = new PoolingDataSource(connectionPool);

		return dataSource;
	}

	/** Return connection
	 * 	
	 * @return
	 */
	public Connection getConnection() {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			LOGGER.error("Sql Exception",e);
			return null;
		}
	}
	
	/** Closes connection
	 * 
	 * @param con
	 */
	public static void closeConnection(Connection con) {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				//ignore
			}
		}
	}
	
	public static void closeResources(Connection con, Statement stmt) {
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				//ignore
			}
		}
		closeConnection(con);
	}
	
	public static void closeResources(Connection con, PreparedStatement pstmt) {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				//ignore
			}
		}
		closeConnection(con);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		try {
			connectToDB();
		} catch (Exception e) {
			LOGGER.error("Failed to construct ConnectionManager", e);
		}
	}

	/**
	 * @return the ds
	 */
	public DataSource getDs() {
		return ds;
	}

	/**
	 * @param ds the ds to set
	 */
	public void setDs(DataSource ds) {
		this.ds = ds;
	}

	/**
	 * @return the dbDriverName
	 */
	public String getDbDriverName() {
		return dbDriverName;
	}

	/**
	 * @param dbDriverName the dbDriverName to set
	 */
	public void setDbDriverName(String dbDriverName) {
		this.dbDriverName = dbDriverName;
	}

	/**
	 * @return the dbUri
	 */
	public String getDbUri() {
		return dbUri;
	}

	/**
	 * @param dbUri the dbUri to set
	 */
	public void setDbUri(String dbUri) {
		this.dbUri = dbUri;
	}

	/**
	 * @return the dbUser
	 */
	public String getDbUser() {
		return dbUser;
	}

	/**
	 * @param dbUser the dbUser to set
	 */
	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}

	/**
	 * @return the dbPwd
	 */
	public String getDbPwd() {
		return dbPwd;
	}

	/**
	 * @param dbPwd the dbPwd to set
	 */
	public void setDbPwd(String dbPwd) {
		this.dbPwd = dbPwd;
	}

	
}
