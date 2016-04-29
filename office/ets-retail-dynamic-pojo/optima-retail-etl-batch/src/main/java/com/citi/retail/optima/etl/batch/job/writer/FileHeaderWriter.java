package com.citi.retail.optima.etl.batch.job.writer;

import java.io.IOException;
import java.io.Writer;

import org.springframework.batch.item.file.FlatFileHeaderCallback;

public class FileHeaderWriter implements FlatFileHeaderCallback{

	private String headerString;
	
	@Override
	public void writeHeader(Writer writer) throws IOException {
		
		writer.write(headerString);
		
	}

	public String getHeaderString() {
		return headerString;
	}

	public void setHeaderString(String headerString) {
		this.headerString = headerString;
	}
	
	

}
