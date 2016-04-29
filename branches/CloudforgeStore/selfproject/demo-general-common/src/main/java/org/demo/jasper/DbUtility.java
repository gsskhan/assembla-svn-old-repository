package org.demo.jasper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class DbUtility {
	
	private static Logger log = Logger.getLogger("DbUtility");
	
	public static Connection getMysqldbConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dms","root", "password");
		return conn;		
	}	

	public static void closeConnection(Connection conn)	{
		try {
			if(conn != null){
				conn.close();
				log.info("closed db connection successfully ..." );
			}			
		} catch (Exception e) {
			log.error("couldn't close obtained db connection ...", e);
		}		
	}
}
