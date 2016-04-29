/**
 * 
 */
package com.citi.retail.optima.etl.batch;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.citi.retail.optima.etl.batch.dynamic.pojo.DynamicPojoFactory;
import com.citi.retail.optima.etl.common.FileDetailsReader;
import com.citi.retail.optima.etl.common.model.POCFileDetailsVO;

/**
 * @author gv74035
 *
 */
public class ControllerBatchInitiator {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ControllerBatchInitiator.class);

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ControllerBatchInitiator controllerBatchInitiator = new ControllerBatchInitiator();
		controllerBatchInitiator.createPojos();
		controllerBatchInitiator.launch();
	}
	
	public void launch() {
		MDC.put("LogFileName", "Controller-Batch-Log-Test" );
		try {
			ClassPathXmlApplicationContext context = null;
			String env="DEV";
			env = System.getenv("VAR");
			if (null == env){
				env = "DEV";
			}
	        if(env.equalsIgnoreCase("DEV")){
	        	context = new ClassPathXmlApplicationContext(
	                    new String[] {"/retail.optima.etl.controller-batch.integration.xml","/retail.optima.etl.controller.datasource.dev.xml","/retail.optima.etl.batch.datasource.dev.xml"});
	            }else if(env.equalsIgnoreCase("SIT")){
	            	context = new ClassPathXmlApplicationContext(
	                        new String[] {"/retail.optima.etl.controller-batch.integration.xml","/retail.optima.etl.controller.datasource.sit.xml","/retail.optima.etl.batch.datasource.sit.xml"});
	            }else if(env.equalsIgnoreCase("UAT")){
	            	context = new ClassPathXmlApplicationContext(
	                        new String[] {"/retail.optima.etl.controller-batch.integration.xml","/retail.optima.etl.controller.datasource.uat.xml","/retail.optima.etl.batch.datasource.uat.xml"});
	            }else if(env.equalsIgnoreCase("PROD")){
	            	context = new ClassPathXmlApplicationContext(
	                        new String[] {"/retail.optima.etl.controller-batch.integration.xml","/retail.optima.etl.controller.datasource.prod.xml","/retail.optima.etl.batch.datasource.prod.xml"});
	            }
			context.start();
		} catch (BeansException e) {
			e.printStackTrace();
			LOGGER.error("Exception occured while loading Controller  - Batch Main"
					+ e);
		}
	}
private void createPojos(){
		
		DynamicPojoFactory factoryImpl = new DynamicPojoFactory();
		FileDetailsReader reader = null;
		try {
			reader = FileDetailsReader.getInstance();
			
			System.out.println("Creating SupportingPojo *********************");
			List<POCFileDetailsVO> supportingFileList = reader.getFileColumnDetails(reader.getFileDetails(FileDetailsReader.getQuery("query.file.load.supporting.file.details")));
			for(POCFileDetailsVO detailsVO: supportingFileList) {
				factoryImpl.createPojo(detailsVO.getFileCd(), detailsVO.getProductcd(), detailsVO.getCountryCd(),detailsVO.getColumnDetails(),detailsVO.isSupportFile());
			}
			
			System.out.println("Creating TRLPojo *********************");
//			List<POCFileDetailsVO> outputFileList =  reader.getTRLFileDetails(FileDetailsReader.getQuery("query.file.load.trl.file.details"));
//			for(POCFileDetailsVO opDetailsVO: outputFileList) {
//				System.out.println("opDetailsVO.isSupportFile() = " + opDetailsVO.isSupportFile());
//				//factoryImpl.createTRLPojo(opDetailsVO.getProductcd(),opDetailsVO.getColumnDetails());
//				if(opDetailsVO.isSupportFile()){
//					factoryImpl.createPojo(opDetailsVO.getFileCd(), opDetailsVO.getProductcd(), opDetailsVO.getCountryCd(),opDetailsVO.getColumnDetails(),opDetailsVO.isSupportFile());
//				}else{
//					factoryImpl.createTRLPojo(opDetailsVO.getProductcd(),opDetailsVO.getColumnDetails());
//				}
//				
//				factoryImpl.createTRLPojo(opDetailsVO.getProductcd(),opDetailsVO.getColumnDetails());
//			}
			System.out.println("Creating InputPojo *********************");
			List<POCFileDetailsVO> fileList = reader.getFileColumnDetails(reader.getFileDetails(FileDetailsReader.getQuery("query.file.load.file.details")));
			for(POCFileDetailsVO detailsVO: fileList) {
				factoryImpl.createPojo(detailsVO.getFileCd(), detailsVO.getProductcd(), detailsVO.getCountryCd(),detailsVO.getColumnDetails(),detailsVO.isSupportFile());
			}		
			
			System.out.println("Creating Data Processors *********************");
			Map<String,String> classNamewithMethodStringMap = reader.getClassNamewithMethodStringMap(FileDetailsReader.getQuery("query.file.load.dataProcessor.details"));
			Set<String> classNames = classNamewithMethodStringMap.keySet();
			Iterator<String> classNameItr = classNames.iterator();
			while (classNameItr.hasNext()) {
				
				String className = classNameItr.next();
				String methodStr = classNamewithMethodStringMap.get(className);
				factoryImpl.createDataProcessorPojo(className, methodStr);
				
			}
	}catch (BeansException e) {
		
		} catch (Exception e) {
		e.printStackTrace();
	}
	}

}
