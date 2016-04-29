package org.demo.jasper;

import java.sql.Connection;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import org.apache.log4j.Logger;

public class DmsConstants {
	
	private static Logger log = Logger.getLogger("DmsConstants");
	
	public static String SAMPLE_TEST_JRXML = "/media/gsskhan/RUN_FILESTORE/ireport_workspace/sampleTest1.jrxml";
	public static String JREPORT_OUTPUT_PATH = "/media/gsskhan/RUN_FILESTORE/ireport_workspace/output/";

	public static void main(String[] args) {
		Connection con = null;
		try {
			con = DbUtility.getMysqldbConnection();			
			log.info("obtained db connection successfully ...");
			
			JasperReport jasperReport = JasperCompileManager.compileReport(SAMPLE_TEST_JRXML);
			log.info("compiled jrxml successfully ...");
			
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, con);
			log.info("filled report successfully ...");
			
			JasperExportManager.exportReportToPdfFile(jasperPrint, JREPORT_OUTPUT_PATH + "DmsConstantsReport.pdf");
			log.info("exported report successfully ...");
			
		} catch (Exception e) {
			log.error("error in main ...", e);
		} finally {
			DbUtility.closeConnection(con);
		}
		
		log.info("program end ...");
	}
	

}
