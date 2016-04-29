/**
 * 
 */
package com.citi.retail.optima.etl.controller.file.mover;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.citi.retail.optima.etl.common.ETLConstants;
import com.citi.retail.optima.etl.controller.dao.impl.JobMessageDaoImpl;

/**
 * @author av51190
 *
 */
public class FileMoverBasicImpl implements FileMover {
	
	private static final Logger LOGGER = LoggerFactory
			.getLogger(FileMoverBasicImpl.class);
	
	private final static String OS = System.getProperty("os.name").toLowerCase();
	
	/* (non-Javadoc)
	 * @see com.citi.retail.optima.etl.controller.file.mover.FileMover#moveFile(java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String)
	 */
	public boolean moveFile(String inputLocation,String outputLocation
			,String inputFileName,String outputFileName) throws Exception{
		boolean isMoved = false;
		String status = "";
		try{

			File inputfile =new File(inputLocation + inputFileName);
			File outputfile =new File(outputLocation + outputFileName);
			LOGGER.debug("inputfile1 : "+inputfile.getAbsolutePath());
			LOGGER.debug("outputfile1 : "+outputfile.getAbsolutePath());
			//isMoved = inputfile.renameTo(outputfile);
			if (inputfile.exists())
			{
				if(!(OS.indexOf(ETLConstants.WIN_OS) >= 0)){
					Process p;
					try {
						String filemoverCommand = "./FileMover.sh "  +  inputfile +" "+outputfile;
						LOGGER.info(" File mover command "+filemoverCommand);
						p = Runtime.getRuntime().exec(filemoverCommand);
						p.waitFor();
						BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
						status = reader.readLine();
						if (status.trim().equals("0")){
							isMoved = true;
						}
						LOGGER.info(" File mover command is Successfull");
					} catch (InterruptedException e) {
						LOGGER.error("ERROR while runnig file mover"+e);
					} catch (IOException e) {
						LOGGER.error("ERROR while runnig file mover"+e);
					}
				}else{
					isMoved = inputfile.renameTo(outputfile);
				}
				
			}else{
				inputfile =new File(outputLocation + inputFileName + ETLConstants.CTL_MOVED_FILE_STR);
				outputfile =new File(outputLocation + outputFileName);
				LOGGER.debug("inputfile2 : "+inputfile.getAbsolutePath());
				LOGGER.debug("outputfile2 : "+outputfile.getAbsolutePath());
				if (inputfile.exists())
				{
					LOGGER.debug("inputfile3 : "+inputfile.getAbsolutePath());
					LOGGER.debug("outputfile3 : "+outputfile.getAbsolutePath());
					isMoved = inputfile.renameTo(outputfile);
				}
			}
			LOGGER.debug("isMoved : "+isMoved);

		}catch(Exception e){
			LOGGER.error("Error happens in file mover"+e.getMessage());
			throw e;
		}
		
		return isMoved;
	}

}
