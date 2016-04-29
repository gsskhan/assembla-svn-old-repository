package com.citi.retail.optima.etl.batch.dynamic.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtMethod;
import javassist.NotFoundException;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.citi.retail.optima.etl.batch.job.mapper.AbstractFieldSetMapper;
import com.citi.retail.optima.etl.common.FileDetailsReader;
import com.citi.retail.optima.etl.common.model.CardsTRLRecord;
import com.citi.retail.optima.etl.common.model.DataAcqCardsBaseRecord;
import com.citi.retail.optima.etl.common.model.DataAcqMtgBaseRecord;
import com.citi.retail.optima.etl.common.model.DataAcqPLBaseRecord;
import com.citi.retail.optima.etl.common.model.ExcludableRecord;
import com.citi.retail.optima.etl.common.model.FileColumnDetails;
import com.citi.retail.optima.etl.common.model.HkRcBaseRecord;
import com.citi.retail.optima.etl.common.model.InRcTRLRecord;
import com.citi.retail.optima.etl.common.model.LoansTRLRecord;
import com.citi.retail.optima.etl.common.model.MortgageTRLRecord;

public class PojoGenerator {

	public static Class<?> generate(String className,
			 String productCode,String countryCd,String fileCd,List<FileColumnDetails> columnDetails,boolean isSupportFile)
			throws NotFoundException, CannotCompileException,ClassNotFoundException {

		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.makeClass(className);
		/**
		 * add this to define a super class to extend
		 */
		setSuperClass(cc, productCode,countryCd,fileCd,isSupportFile);

		/**
		 * add this to define an interface to implement
		 */
		cc.addInterface(resolveCtClass(Serializable.class));
		
		for(FileColumnDetails details: columnDetails) {
			cc.addField(new CtField(resolveCtClass(getClassDetails(details.getColumnType())), details
					.getColumnName(), cc));
			cc.addMethod(generateGetter(cc, details.getColumnName(), getClassDetails(details.getColumnType())));
			cc.addMethod(generateSetter(cc, details.getColumnName(), getClassDetails(details.getColumnType())));
			
		}
		//**
		/*cc.addMethod(generateGetter(cc, "acNo", getClassDetails("string")));
		cc.addMethod(generateSetter(cc, "acNo", getClassDetails("string")));
		cc.addMethod(generateGetter(cc, "currAccountNo", getClassDetails("string")));
		cc.addMethod(generateSetter(cc, "currAccountNo", getClassDetails("string")));*/
		
		
//		CtClass cc = pool.getOrNull(className);
//		if(cc != null) {
//			cc.defrost();
//			cc = generateBlankClass(className, productCode, countryCd, isSupportFile);
//			addDynamicMethod(columnDetails, cc);
//			ClassLoader.getSystemClassLoader().loadClass(className);
//		}
//		else {
//			
//			cc = pool.makeClass(className);
//		}
		return cc.toClass();
	}
	public static CtClass generateBlankClass(String className,
			 String productCode,String countryCd,boolean isSupportFile)
			throws NotFoundException, CannotCompileException,ClassNotFoundException {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.makeClass(className);
		/**
		 * add this to define a super class to extend
		 */
//		setSuperClass(cc, productCode,countryCd,fileisSupportFile);

		/**
		 * add this to define an interface to implement
		 */
		cc.addInterface(resolveCtClass(Serializable.class));
		
		return cc;
	}
	@SuppressWarnings("unused")
	private static void addDynamicMethod(final List<FileColumnDetails> columnDetails,CtClass declaringClass) throws CannotCompileException, NotFoundException {
		for(FileColumnDetails details: columnDetails) {
			declaringClass.addField(new CtField(resolveCtClass(getClassDetails(details.getColumnType())), details
					.getColumnName(), declaringClass));
			declaringClass.addMethod(generateGetter(declaringClass, details.getColumnName(), getClassDetails(details.getColumnType())));
			declaringClass.addMethod(generateSetter(declaringClass, details.getColumnName(), getClassDetails(details.getColumnType())));
		}
	}
	private static Class<?> getClassDetails(String classType){
		Class<?>  typeClass = null;
		try{
			switch (classType.toLowerCase()) {
			case "integer":typeClass =  Integer.class; break;
			case "date":typeClass =  Date.class; break;
			case "double":typeClass = Double.class; break;
			case "long":typeClass =  Long.class; break;
			case "string":typeClass = String.class; break;
			default:
				typeClass= Class.forName(classType);
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		return typeClass;
	}

	public static Class<?> generateTRLPojo(String className,
			String productCode, List<FileColumnDetails> columnDetails)
			throws NotFoundException, CannotCompileException {

		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.makeClass(className);
		pool.importPackage("org.springframework.batch.item.file.transform.FieldSet");
		pool.importPackage("org.springframework.validation.BindException");
		pool.importPackage("com.citi.retail.optima.etl.common.log.LoggingMarker");
		pool.importPackage("com.citi.retail.optima.etl.common.model.*");
		pool.appendClassPath("src\\main\\java");
		pool.appendClassPath("src\\main\\resources");
		pool.appendClassPath("src\\main\\java");
		/**
		 * add this to define a super class to extend
		 */
		setTRLSuperClass(cc, productCode);

		/**
		 * add this to define an interface to implement
		 */
		cc.addInterface(resolveCtClass(Serializable.class));
		
		for(FileColumnDetails details: columnDetails) {
			cc.addField(new CtField(resolveCtClass(getClassDetails(details.getColumnType())), details
					.getColumnName(), cc));
			cc.addMethod(generateTRLGetter(cc, details.getColumnName(), getClassDetails(details.getColumnType())));
			cc.addMethod(generateSetter(cc, details.getColumnName(), getClassDetails(details.getColumnType())));
		}
		//System.out.println("TRL Classess ::"+cc);
		return cc.toClass();
	}

	private static void setTRLSuperClass(CtClass cc, String productCode) {
			try {
				cc.setSuperclass(resolveCtClass(ExcludableRecord.class));
			} catch (CannotCompileException e) {
				e.printStackTrace();
			} catch (NotFoundException e) {
				e.printStackTrace();
			}
		
	}
	public static Class<?> generateMapper(String className,
			Class<?> recordName, String productCode,
			List<FileColumnDetails> colDetails) throws NotFoundException,
			CannotCompileException {

		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.makeClass(className);

		/**
		 * add this to define a super class to extend
		 */
		cc.setSuperclass(resolveCtClass(AbstractFieldSetMapper.class));

		/**
		 * add this to define an interface to implement
		 */
		cc.addInterface(resolveCtClass(FieldSetMapper.class));
		cc.addMethod(generateMapperMethod(cc, recordName,colDetails));

		Class<?> tempClass = cc.toClass();
		//System.out.println("******** Creating Mapper : "+ tempClass);
 		return tempClass;
	}

	private static CtMethod generateSetter(CtClass declaringClass,
			String fieldName, Class<?> fieldClass)
			throws CannotCompileException {

		String setterName = "set" + fieldName.substring(0, 1).toUpperCase()
				+ fieldName.substring(1);

		StringBuffer sb = new StringBuffer();
		sb.append("public void ").append(setterName).append("(")
				.append(fieldClass.getName()).append(" ").append(fieldName)
				.append(")").append("{").append("this.").append(fieldName)
				.append("=").append(fieldName).append(";").append("}");
		return CtMethod.make(sb.toString(), declaringClass);
	}

	private static CtMethod generateGetter(CtClass declaringClass,
			String fieldName, Class<?> fieldClass)
			throws CannotCompileException {
		String getterName = "";
		if(DynamicPojoFactory.POJO_PACKAGE_NAME.equalsIgnoreCase(fieldClass.getPackage().getName())){
			getterName = "get" + fieldName;
		} else {
			getterName = "get" + fieldName.substring(0, 1).toUpperCase()
				+ fieldName.substring(1);
		}
		StringBuffer sb = new StringBuffer();
		sb.append("public ").append(fieldClass.getName()).append(" ")
				.append(getterName).append("(){").append("return this.")
				.append(fieldName).append(";").append("}");
		return CtMethod.make(sb.toString(), declaringClass);
	}
	private static CtMethod generateTRLGetter(CtClass declaringClass,
			String fieldName, Class<?> fieldClass)
			throws CannotCompileException {
		String getterName = null;
		if(fieldName.substring(1,2).equals(fieldName.substring(1, 2).toLowerCase())){
			getterName = "get" + fieldName.substring(0, 1).toUpperCase()
					+ fieldName.substring(1);
		} else{
			getterName = "get" + fieldName;
		}
		

		StringBuffer sb = new StringBuffer();
		sb.append("public ").append(fieldClass.getName()).append(" ")
				.append(getterName).append("(){").append("return this.")
				.append(fieldName).append(";").append("}");
		if(declaringClass.getName().contains("CardsTRLPOCRecord")){
			if(sb.toString().contains("common")) {
				//System.out.println("Method ------------------------>"+sb.toString());
			}
		}
		return CtMethod.make(sb.toString(), declaringClass);
	}
	private static CtMethod generateMapperMethod(CtClass declaringClass,
			Class<?> record,List<FileColumnDetails> colDetails)
			throws CannotCompileException, NotFoundException {

		StringBuffer sb = new StringBuffer();
		CtMethod method = null;
		try {
		sb.append("public ").append("java.lang.Object").append(" ")
				.append("mapFieldSet(").append(FieldSet.class.getName())
				.append(" fieldSet").append(") throws ")
				.append(BindException.class.getName()).append(" {");
		sb.append(record.getName())
				.append(" ")
				.append(DynamicPojoFactory.changeFirstLetterCase(
						record.getSimpleName(), false)).append("= new ")
				.append(record.getName()).append("()").append(";");
		for (FileColumnDetails  detail : colDetails) {
			if(detail.getColumnType() != null && !(detail.getColumnType().contains("Date")
										&&declaringClass.getSimpleName().contains("In")&&(declaringClass.getSimpleName().contains("Pl")||
										declaringClass.getSimpleName().contains("Rc"))) 
					&& !detail.getColumnType().contains("com.citi.retail.optima.etl.common.model")&& 
					!detail.getColumnType().contains("java")) {
				sb.append(
						DynamicPojoFactory.changeFirstLetterCase(
								record.getSimpleName(), false))
						.append(".set")
						.append(DynamicPojoFactory.changeFirstLetterCase(
								detail.getColumnName(), true)).append("(")
						.append(getDataType(getClassDetails(detail.getColumnType()).getSimpleName()))
						.append("\"").append(detail.getColumnName()).append("\""+checkForFormat(detail.getColumnFormat())+"))")
						.append(";");
			} else if(declaringClass.getSimpleName().contains("In")&&(declaringClass.getSimpleName().contains("Pl")||
					declaringClass.getSimpleName().contains("Rc")) && detail.getColumnType().contains("Date")) {
				if(detail.getColumnName().contains("bookingDate")){
					if(declaringClass.getSimpleName().contains("In")&&declaringClass.getSimpleName().contains("Pl")) {
						sb.append("if (fieldSet.readString(\"bookingDate\").contains(\"/\")){")
						.append(DynamicPojoFactory.changeFirstLetterCase(record.getSimpleName(),false))
						.append(".setBookingDate(readDate(fieldSet, \"bookingDate\",\"dd/MM/yyyy\"));")
						.append("}else{").append(DynamicPojoFactory.changeFirstLetterCase(record.getSimpleName(),false))
						.append(".setBookingDate(readDate(fieldSet,\"bookingDate\",\"ddMMMyyyy:HH:mm:ss\"));")
						.append("}");	
					}
				}
				if(detail.getColumnName().contains("bkgDate")) {
					if(declaringClass.getSimpleName().contains("In")&&
							declaringClass.getSimpleName().toLowerCase().contains("rc") && 
							(declaringClass.getSimpleName().toLowerCase().contains("corp")||declaringClass.getSimpleName().toLowerCase().contains("ret"))) {
						 sb.append("if (fieldSet.readString(\"bkgDate\").contains(\"/\")){")
	                       .append("if (fieldSet.readString(\"bkgDate\").length() == 8){")
	                       .append(DynamicPojoFactory.changeFirstLetterCase(record.getSimpleName(),false))
	                       .append(".setBkgDate(readDate (fieldSet,\"bkgDate\",\"dd/MM/yy\"));")        
	                       .append("}else{").append(DynamicPojoFactory.changeFirstLetterCase(record.getSimpleName(),false))
	                       .append(".setBkgDate(readDate (fieldSet,\"bkgDate\",\"dd/MM/yyyy\"));}")
	                       .append("}else{").append(DynamicPojoFactory.changeFirstLetterCase(record.getSimpleName(),false))
	                       .append(".setBkgDate(readDate (fieldSet,\"bkgDate\"));}");
					}else if (declaringClass.getSimpleName().contains("In")&&
							declaringClass.getSimpleName().toLowerCase().contains("rc") && 
							declaringClass.getSimpleName().toLowerCase().contains("rw")){
						sb.append("if (fieldSet.readString(\"bkgDt\").contains(\"/\")){")
	                       .append("if (fieldSet.readString(\"bkgDt\").length() == 8){")
	                       .append(DynamicPojoFactory.changeFirstLetterCase(record.getSimpleName(),false))
	                       .append(".setBkgDate(readDate (fieldSet,\"bkgDt\",\"dd/MM/yy\"));")        
	                       .append("}else{").append(DynamicPojoFactory.changeFirstLetterCase(record.getSimpleName(),false))
	                       .append(".setBkgDate(readDate (fieldSet,\"bkgDt\",\"dd/MM/yyyy\"));}")
	                       .append("}else{").append(DynamicPojoFactory.changeFirstLetterCase(record.getSimpleName(),false))
	                       .append(".setBkgDate(readDate (fieldSet,\"bkgDt\"));}");
					}
				}
			}
		}
		sb.append("if(getExceptionList().size() > 0) {");
		sb.append("KPILOGGER.error(com.citi.retail.optima.etl.common.log.LoggingMarker.KPI.getMarker(), \"ERROR OCCURED: \\n\"")
		.append(");")
		.append("for (int i=0;i<getExceptionList().size();i++) {")
		.append("KPILOGGER.error(com.citi.retail.optima.etl.common.log.LoggingMarker.KPI.getMarker(), \"ERROR DETAILS: \"+((java.lang.Exception)getExceptionList().get(i)).getMessage());")
		.append("}")
		.append(" getExceptionList().clear();")
		.append("KPILOGGER.error(com.citi.retail.optima.etl.common.log.LoggingMarker.KPI.getMarker(), \"\\n\");")
		.append("}");

		sb.append("return ")
				.append(DynamicPojoFactory.changeFirstLetterCase(
						record.getSimpleName(), false)).append(";");
		sb.append("}");
		//System.out.println(sb.toString());
		method = CtMethod.make(sb.toString(), declaringClass);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return method;
	}

	private static String checkForFormat(String columnFormat) {
		String format = "";
		if(columnFormat != null && !columnFormat.isEmpty()){
			format = ",\""+columnFormat+"\"";
		}
		return format;
	}
	private static String getDataType(String value) {
		switch (value) {
		case "Integer":
			return "readInt(fieldSet,";
		case "Double":
			return "readDouble(fieldSet,";
		case "Long":
			return "readLong(fieldSet,";
		case "Date":
			return "readDate(fieldSet,";
		default:
			return "fieldSet.readString(";
		}
	}

	public static CtClass resolveCtClass(Class<?> clazz)
			throws NotFoundException {
		ClassPool pool = ClassPool.getDefault();
		return pool.get(clazz.getName());
	}

	private static void setSuperClass(CtClass cc, String productType,String countryCd,String fileCd,boolean isSupportFile)
			throws CannotCompileException, NotFoundException,ClassNotFoundException {
		String superClassName= FileDetailsReader.getInstance().getSuperClassName(countryCd,productType,fileCd);
		switch (productType) {
		case "CARDS":
			if(superClassName!=null){
				cc.setSuperclass(resolveCtClass(Class.forName(DynamicPojoFactory.POJO_PACKAGE_NAME+"."+superClassName)));
			} else if(isSupportFile) {
				cc.setSuperclass(resolveCtClass(DataAcqCardsBaseRecord.class));
			} else {
				cc.setSuperclass(resolveCtClass(CardsTRLRecord.class));
			}
			break;
		case "PL":
			if(superClassName!=null){
				cc.setSuperclass(resolveCtClass(Class.forName(DynamicPojoFactory.POJO_PACKAGE_NAME+"."+superClassName)));
			} else if(isSupportFile) {
				cc.setSuperclass(resolveCtClass(DataAcqPLBaseRecord.class));
			} else {
				cc.setSuperclass(resolveCtClass(LoansTRLRecord.class));
			}
			break;
		case "MTG":
			if(superClassName!=null){
				cc.setSuperclass(resolveCtClass(Class.forName(DynamicPojoFactory.POJO_PACKAGE_NAME+"."+superClassName)));
			} else if(isSupportFile) {
				cc.setSuperclass(resolveCtClass(DataAcqMtgBaseRecord.class));
			} else {
				cc.setSuperclass(resolveCtClass(MortgageTRLRecord.class));
			}
			break;
		case "RC":
			//superClassName=FileDetailsReader.getInstance().getSuperClassName(countryCd);
			if(superClassName!=null){
				cc.setSuperclass(resolveCtClass(Class.forName(DynamicPojoFactory.POJO_PACKAGE_NAME+"."+superClassName)));
			} else if(isSupportFile) {
					cc.setSuperclass(resolveCtClass(HkRcBaseRecord.class));
			} else {
				cc.setSuperclass(resolveCtClass(InRcTRLRecord.class));
			}
			break;
		default:
			throw new NotFoundException("Product type not found");
		}
	}
}