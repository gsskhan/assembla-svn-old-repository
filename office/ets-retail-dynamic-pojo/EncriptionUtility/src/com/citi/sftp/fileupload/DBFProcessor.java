package com.citi.sftp.fileupload;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import nl.knaw.dans.common.dbflib.Field;
import nl.knaw.dans.common.dbflib.IfNonExistent;
import nl.knaw.dans.common.dbflib.Record;
import nl.knaw.dans.common.dbflib.Table;


public class DBFProcessor {
	
	public void getTableData(Table table, CSVDataContainer dataContainer, 
			int[] intArr, RecordProcessor recordProcessor){
		try
		{
		    table.open(IfNonExistent.ERROR);
		    List<Field> fields = table.getFields();
		    SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
		    Iterator<Record> iterator = table.recordIterator();
		    String[] dataArr = null;
		    String[] headerArr = new String[fields.size()];
		    Field field = null;
		    
		    for(int i= 0; i < fields.size();i++){
		    	headerArr[i] = fields.get(i).getName();
		    }
		    recordProcessor.processData(headerArr,dataContainer,intArr);
		    
		    
		    while (iterator.hasNext())
		    {
		        Record record = iterator.next();
		        dataArr = new String[fields.size()];
		        for(int j= 0; j < fields.size();j++)
                {     
		        	field = fields.get(j);
		        	dataArr[j] = field.getType().toString().equalsIgnoreCase("DATE") ? 
                        		dateFormat.format(record.getDateValue(field.getName())) : 
                        			new String(record.getRawValue(field)).trim(); 
                         
                }
		        recordProcessor.processData(dataArr,dataContainer,intArr);
		    }
		} catch (Exception e) {
			e.printStackTrace();
		} 
		finally
		{
		    try {
				table.close();
			} catch (IOException e) {
				e.printStackTrace();
			}  
		}
	}

	/**
	 * @param args
	 *//*
	public static void main(String[] args) {
		//String path  = "input"+File.separator+"Corp_0804.DBF";
		//String path  = "input"+File.separator+"retail_0804.DBF";
		String path  = "input"+File.separator+"rwcc_0804.DBF";
		Table table = new Table(new File(path));
		new DBFClass().getTableData(table);

		

	}*/

}
