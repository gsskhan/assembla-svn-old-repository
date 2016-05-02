package org.demo.commandrun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

public class DumpDbMysqlCmd {

	public static Logger log = Logger.getLogger(DumpDbMysqlCmd.class);

	public static void main(String[] args) {
		try {
			log.info("Starting...");
			Process p = Runtime
					.getRuntime()
					.exec("cmd /c /SELF_WORKSPACE/demo-general-common/src/main/resources/dump_dms_mysql.bat");
			p.waitFor();
			BufferedReader brIn = new BufferedReader(new InputStreamReader(
					p.getInputStream()));
			BufferedReader brErr = new BufferedReader(new InputStreamReader(
					p.getErrorStream()));

			String runresult = "";
			log.info("Command output");
			while ((runresult = brIn.readLine()) != null) {
				log.info(runresult);
			}
			log.info("Command error(if any)");
			while ((runresult = brErr.readLine()) != null) {
				System.out.println(runresult);
			}

		} catch (Exception e) {
			log.error("error", e);
		}
		log.info("end ...");
	}

}
