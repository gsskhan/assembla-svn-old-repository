/**
 * 
 */
package com.citi.retail.optima.etl.batch.dynamic.pojo;

import java.lang.reflect.Method;
import java.util.List;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.InitializingBean;

import com.citi.retail.optima.etl.batch.job.processor.da.AbstractDataProcessor;
import com.citi.retail.optima.etl.common.FileDetailsReader;
import com.citi.retail.optima.etl.common.model.FileColumnDetails;
import com.citi.retail.optima.etl.context.CustomMethodsProvider;

/**
 * @author sm59053
 *
 */
public class DynamicPojoFactory implements InitializingBean{
	
	public static final String POJO_PACKAGE_NAME="com.citi.retail.optima.etl.common.model";
	public static final String MAPPER_PACKAGE_NAME="com.citi.retail.optima.etl.batch.job.mapper";
	
	@Override
	public void afterPropertiesSet() throws Exception {
		
	}


	public void createPojo(String fileCd, String productCode,String countryCode, List<FileColumnDetails> fileColumnList,boolean isSupportFile) throws Exception{
	
	try {
	//System.out.println("isSupportFile = "+isSupportFile);
	Class<?> record = PojoGenerator.generate(POJO_PACKAGE_NAME+"."
			+convertCase(countryCode, true)+convertCase(productCode, true)
			+convertCase(fileCd, true)
			+"POCRecord", productCode,countryCode,fileCd,fileColumnList,isSupportFile);
	System.out.println("Creating What ::: "+record.getName());
	PojoGenerator.generateMapper(MAPPER_PACKAGE_NAME+"."
			+convertCase(countryCode, true)+convertCase(productCode, true)+convertCase(fileCd, true)
			+"FieldSetMapper", record, productCode,fileColumnList);
	} catch(Exception e) {
		e.printStackTrace();
		throw e;
	}finally {
	}
	}
	
	public void createTRLPojo(String productCode, List<FileColumnDetails> fileColumnList) throws Exception{
	try {
	System.out.println("Creating TRL Pojo ........");
	PojoGenerator.generateTRLPojo(POJO_PACKAGE_NAME+"."
			+convertCase(productCode, true)
			+"TRLPOCRecord",productCode,fileColumnList);
	
	} catch(Exception e) {
		throw e;
	}finally {
	}
	}
	public static String convertCase(String name,boolean firstLetterCaps) {
		String lowercase = name.toLowerCase();
		String firstChar = null;
		String restChars = null;
		if(name!=  null && name.length() > 0) {
			if(firstLetterCaps) {
				firstChar = lowercase.substring(0,1).toUpperCase();
			} else {
				firstChar = lowercase.substring(0,1);
			}
			restChars = lowercase.substring(1);
		}
		return firstChar+restChars;
	} 
	public static String changeFirstLetterCase(String name,boolean uppercase) {
		String firstChar = null;
		String restChars = null;
		if(name!=  null && name.length() > 0) {
			if(uppercase){
				firstChar = name.substring(0,1).toUpperCase();
			}else {
				firstChar = name.substring(0,1).toLowerCase();
			}
			restChars = name.substring(1);
		}
		return firstChar+restChars;
	}
	/**
	 * Added by Subhamoy for dynamically Generate Data Processors
	 * @param methodStr 
	 * @param className 
	 * @throws NotFoundException 
	 * @throws CannotCompileException 

	 */

	public void createDataProcessorPojo(String className, String methodStr) throws CannotCompileException, NotFoundException{

		System.out.println("Going to add com.citi.retail.optima.etl.batch.job.processor.da." +className +" class dynamically to memory");
		ClassPool pool = ClassPool.getDefault();
		
		
		/*pool.importPackage("org.springframework.batch.item.file.transform.FieldSet");
		pool.importPackage("org.springframework.validation.BindException");
		pool.importPackage("com.citi.retail.optima.etl.common.log.LoggingMarker");
		pool.importPackage("com.citi.retail.optima.etl.common.model.*");*/
		
		pool.importPackage("com.citi.retail.optima.etl.common.model");
		pool.importPackage("java.util.Map");
							
		pool.appendClassPath("src\\main\\java");
		pool.appendClassPath("src\\main\\resources");
		CtClass cc = pool.makeClass("com.citi.retail.optima.etl.batch.job.processor.da."+className.trim());
		cc.setSuperclass(resolveCtClass(AbstractDataProcessor.class));
		cc.setInterfaces(new CtClass[]{resolveCtClass(ItemProcessor.class)});
		CtMethod  m = CtMethod.make(methodStr,cc);
		cc.addMethod(m);
		cc.toClass();
	}
	
	
	public void addCustomMethods(String methodStr) throws CannotCompileException, NotFoundException{

		System.out.println("Going to add custom Method -- "+methodStr+ " --to  class dynamically to memory");
		ClassPool pool = ClassPool.getDefault();
		
		
		/*pool.importPackage("org.springframework.batch.item.file.transform.FieldSet");
		pool.importPackage("org.springframework.validation.BindException");
		pool.importPackage("com.citi.retail.optima.etl.common.log.LoggingMarker");
		pool.importPackage("com.citi.retail.optima.etl.common.model.*");*/
		
		pool.importPackage("com.citi.retail.optima.etl.common.model");
		pool.importPackage("java.util.*");
		pool.importPackage("java.text.*");
		pool.importPackage("java.math.BigDecimal");
							
		pool.appendClassPath("src\\main\\java");
		pool.appendClassPath("src\\main\\resources"); 
		CtClass cc = resolveCtClass(CustomMethodsProvider.class);
	
		try {
			/**
			 * Adding method received from DB
			 */
			CtMethod  m = CtMethod.make(methodStr,cc);
			cc.addMethod(m);
			cc.toClass();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		CtMethod[] modifiedMethods =  cc.getMethods();
		/*for(int i=0;i<modifiedMethods.length;i++){

			System.out.println("==>"+modifiedMethods[i].getName());
		}*/

	}
	public static CtClass resolveCtClass(Class<?> clazz)
			throws NotFoundException {
		ClassPool pool = ClassPool.getDefault();
		return pool.get(clazz.getName());
	}


	public static void main(String[] args) {
		DynamicPojoFactory factoryImpl = new DynamicPojoFactory();
		FileDetailsReader reader = null;
		try{
			reader = FileDetailsReader.getInstance();
			System.out.println("Creating Data Processors *********************");
//			Map<String,String> classNamewithMethodStringMap = reader.getClassNamewithMethodStringMap(FileDetailsReader.getQuery("query.file.load.dataProcessor.details"));
//			Set<String> classNames = classNamewithMethodStringMap.keySet();
//			Iterator<String> classNameItr = classNames.iterator();
//			while (classNameItr.hasNext()) {
//				String className = classNameItr.next();
//				String methodStr = classNamewithMethodStringMap.get(className);
//				factoryImpl.createDataProcessorPojo(className, methodStr);
//			}
//			
			
			List<String> customMethodList = reader.getCustomMethods(FileDetailsReader.getQuery("query.file.load.method.details"));
			for (String methodBody : customMethodList) {
				factoryImpl.addCustomMethods(methodBody);
			}
			System.out.println("calling the class...");
			/*
			 * calling the test class
			 */
			Class<?> cls = Class.forName(CustomMethodsProvider.class.getName());
			//Object obj = cls.newInstance();
			
			Method[] meth = cls.getMethods();
			
			for(Method m :meth) {
				System.out.println(m.getName());
			}
			//no paramater
			//Class noparams[] = {};
			
			//int parameter
			/*Class[] paramInt = new Class[1];	
			paramInt[0] = new HkRcCardTransferRecord;*/
			
//			Class<?>[] param_types = new Class<?>[1];
//			param_types[0] = HkRcCardTransferRecord.class;
//           	
//			Method setContactNo = cls.getDeclaredMethod("process", param_types);
//			setContactNo.invoke(obj, new HkRcCardTransferRecord());
			
			
			//HkCardTransferDataProcessorTest
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}

