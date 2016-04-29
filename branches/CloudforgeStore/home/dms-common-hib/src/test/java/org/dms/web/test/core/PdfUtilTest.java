package org.dms.web.test.core;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.dms.web.core.PdfUtil;
import org.junit.Ignore;
import org.junit.Test;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfUtilTest {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Test
	@Ignore
	public void TestAddHeader() throws FileNotFoundException, DocumentException{
		Document doc = new Document();
		PdfWriter.getInstance(doc, new FileOutputStream("target/header.pdf"));
		doc.open();
		PdfUtil.addHeader(doc);
		String[] tablecolumns = {"colummn1","column2"};
		List<ArrayList<Object>> tabdatalist = new LinkedList<ArrayList<Object>>();
		tabdatalist.add(new ArrayList<>());
		String tabTitle = "All constants list.";
		PdfUtil.addTable(doc, tabTitle, 2, tablecolumns, tabdatalist);
		doc.close();
		log.info("test complete.");
	}

}
