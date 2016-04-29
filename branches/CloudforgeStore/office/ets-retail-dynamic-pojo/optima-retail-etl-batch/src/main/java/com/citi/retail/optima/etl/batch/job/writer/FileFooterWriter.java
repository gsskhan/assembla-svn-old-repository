package com.citi.retail.optima.etl.batch.job.writer;

import java.io.IOException;
import java.io.Writer;

import org.springframework.batch.item.file.FlatFileFooterCallback;

public class FileFooterWriter implements FlatFileFooterCallback{

	@Override
	public void writeFooter(Writer writer) throws IOException {
		
		writer.write("footer created");
		
	}

}
