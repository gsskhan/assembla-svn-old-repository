/**
 * 
 */
package com.citi.retail.optima.etl.controller.file.mover;


/**
 * @author av51190
 *
 */
public interface FileMover {
	
	public boolean moveFile(String inputLocation,String outputLocation,String inputFileName,String outputFileName) throws Exception;

}
