package com.citi.retail.optima.etl.batch.job.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.file.transform.FieldSet;

import com.citi.retail.optima.etl.common.log.LoggingMarker;

public class AbstractFieldSetMapper {
	
	private static final Logger LOGGER = LoggerFactory
	.getLogger(AbstractFieldSetMapper.class);
	protected static final Logger KPILOGGER = LoggerFactory
			.getLogger(AbstractFieldSetMapper.class);
	private SimpleDateFormat dateFormat;
	private List<Exception> exceptionList = new ArrayList<Exception>();
	private Exception exception = new Exception();
	/**
	 * @return the exceptionList
	 */
	public List<Exception> getExceptionList() {
		return exceptionList;
	}

	/**
	 * @param exceptionList the exceptionList to set
	 */
	public void setExceptionList(List<Exception> exceptionList) {
		this.exceptionList = exceptionList;
	}

	protected Double readDouble(FieldSet fieldSet,String name) {
		try {
		if (fieldSet.readString(name) != null
				&& fieldSet.readString(name).length() != 0) {
			if(!isDot(fieldSet.readString(name))){
				return fieldSet.readDouble(name);
			}
		}
		} catch(NumberFormatException e) {
			exception = new NumberFormatException("Datatype mismatch in column '"+name+"' Expected 'Double' Actual value = "+fieldSet.readString(name)+"\n");
			exceptionList.add(exception);
		} catch(IllegalArgumentException e) {
			exception = new IllegalArgumentException("Column '"+name+"' is not defined in reader");
			exceptionList.add(exception);
		}  catch(Exception e) {
			exception = new IllegalArgumentException("Column '"+name+"' is not defined in reader");
			exceptionList.add(exception);
		} 
		return null;
	}
	
	protected Integer readInt(FieldSet fieldSet,String name) {
		try{
		if (fieldSet.readString(name) != null
				&& fieldSet.readString(name).length() != 0) {
			if(!isDot(fieldSet.readString(name))){
				return fieldSet.readInt(name);
			}
		}
		} catch(NumberFormatException e) {
			exception = new NumberFormatException("Datatype mismatch in column '"+name+"' Expected 'Double' Actual value = "+fieldSet.readString(name)+"\n");
			exceptionList.add(exception);
		} catch(IllegalArgumentException e) {
			exception = new IllegalArgumentException("Column '"+name+"' is not defined in reader");
			exceptionList.add(exception);
		} catch(Exception e) {
			exception = new ClassCastException("Datatype mismatch in column '"+name+"' Expected 'Integer' Actual  value = "+fieldSet.readString(name));
			exceptionList.add(exception);
		}
		return null;
	}
	
	
	protected Long readLong(FieldSet fieldSet,String name) {
		try {
		if (fieldSet.readString(name) != null
				&& fieldSet.readString(name).length() != 0) {
			if(!isDot(fieldSet.readString(name))){
				return fieldSet.readLong(name);
			}
		}
		} catch(NumberFormatException e) {
			exception = new NumberFormatException("Datatype mismatch in column '"+name+"' Expected 'Double' Actual value = "+fieldSet.readString(name)+"\n");
			exceptionList.add(exception);
		} catch(IllegalArgumentException e) {
			exception = new IllegalArgumentException("Column '"+name+"' is not defined in reader");
			exceptionList.add(exception);
		} catch(Exception e) {
			exception = new ClassCastException("Datatype mismatch in column '"+name+"' Expected 'Long' Actual  value = "+fieldSet.readString(name));
			exceptionList.add(exception);
		}
		return null;
	}
	
	
	protected Date readDate(FieldSet fieldSet,String name) {
		try {
		if (fieldSet.readString(name) != null 
				&& fieldSet.readString(name).trim().length() != 0) {
			try {
				return dateFormat.parse(fieldSet.readString(name));
			} catch (Exception e) {
				exception = new ParseException("Datatype or format mismatch in column '"+name+"' Expected 'Date' Actual value = "+fieldSet.readString(name)+"\n",0);
				//e.printStackTrace();
				exceptionList.add(exception);
				LOGGER.error(" Error while converting Date "+e);
			}
		}
		} catch(NumberFormatException e) {
			exception = new NumberFormatException("Datatype mismatch in column '"+name+"' Expected 'Date' Actual value = "+fieldSet.readString(name)+"\n");
			KPILOGGER.error(LoggingMarker.KPI.getMarker(),e.getStackTrace()[0].toString());
			//e.printStackTrace();
			exceptionList.add(exception);
		} catch(IllegalArgumentException e) {
			exception = new IllegalArgumentException("Column '"+name+"' not found in reader");
			exceptionList.add(exception);
		}
		return null;
	}
	
	/**protected Date readDate(FieldSet fieldSet,String name, String formatStr) {
		try { 
		if (fieldSet.readString(name) != null
				&& fieldSet.readString(name).length() != 0) {
			try {
				dateFormat.applyPattern(formatStr);
				return dateFormat.parse(fieldSet.readString(name));
			} catch (Exception e) {
				exception = new ParseException("Datatype or format mismatch in column '"+name+"' Expected 'Date' Actual value = '"+fieldSet.readString(name)+"'\n",0);
//				KPILOGGER.error(LoggingMarker.KPI.getMarker(),e.getStackTrace()[0].toString());
				//e.printStackTrace();
				exceptionList.add(exception);
				LOGGER.error(" Error while converting Date "+e);
			}
		}
		} catch(NumberFormatException e) {
			//e.printStackTrace();
			exception = new NumberFormatException("Datatype mismatch in column '"+name+"' Expected 'Date' Actual value = '"+fieldSet.readString(name)+"'\n");
			exceptionList.add(exception);
		} catch(IllegalArgumentException e) {
			//e.printStackTrace();
			exception = new IllegalArgumentException("Column '"+name+"' not found in reader");
			exceptionList.add(exception);
		}
		return null;
	}**/
	
	protected Date readDate(FieldSet fieldSet,String name, String formatStr) {
		try { 
		if (fieldSet.readString(name) != null
				&& fieldSet.readString(name).length() != 0) {
			try {
				//dateFormat.applyPattern(formatStr);
				SimpleDateFormat dateFormat1 = new SimpleDateFormat(formatStr);
				return dateFormat1.parse(fieldSet.readString(name));
			} catch (Exception e) {
				exception = new ParseException("Datatype or format mismatch in column '"+name+"' Expected 'Date' Actual value = '"+fieldSet.readString(name)+"'\n",0);
//				KPILOGGER.error(LoggingMarker.KPI.getMarker(),e.getStackTrace()[0].toString());
				//e.printStackTrace();
				exceptionList.add(exception);
				LOGGER.error(" Error while converting Date "+e);
			}
		}
		} catch(NumberFormatException e) {
			//e.printStackTrace();
			exception = new NumberFormatException("Datatype mismatch in column '"+name+"' Expected 'Date' Actual value = '"+fieldSet.readString(name)+"'\n");
			exceptionList.add(exception);
		} catch(IllegalArgumentException e) {
			//e.printStackTrace();
			exception = new IllegalArgumentException("Column '"+name+"' not found in reader");
			exceptionList.add(exception);
		}
		return null;
	}
	
//	public static void main(String[] args) throws Exception{
//		SimpleDateFormat sdf = new SimpleDateFormat();
//		sdf.applyPattern("ddMMMyyyy");
//		System.out.println(sdf.parse("25MAY1999:00:50:00").toString());
//	}

	public void setDateFormat(SimpleDateFormat dateFormat) {
		this.dateFormat = dateFormat;
	}
	
	private boolean isDot(String fieldSetStr)
	{
		if (fieldSetStr.trim().equals(".")) {
			return true;
		}
		return false;
	}
}