package org.dms.web.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.draw.LineSeparator;

public final class PdfUtil {
	private static Logger log = Logger.getLogger(PdfUtil.class);

	public static Font catFont = new Font(Font.FontFamily.COURIER, 18, Font.BOLD);
	public static Font redFont = new Font(Font.FontFamily.COURIER, 12, Font.NORMAL, BaseColor.RED);
	public static Font subFont = new Font(Font.FontFamily.COURIER, 16, Font.BOLD);
	public static Font smallBold = new Font(Font.FontFamily.COURIER, 10, Font.BOLD);
	public static Font small = new Font(Font.FontFamily.COURIER, 10, Font.NORMAL);

	public static void addHeader(Document document) throws DocumentException {
		Paragraph headtext = new Paragraph("Document Management System", catFont);
			headtext.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(headtext);
		addLine(document);
		Paragraph reportdatetext = new Paragraph("Report date: " + new Date(), smallBold);
		addEmptyLine(reportdatetext,1);	
		document.add(reportdatetext);
		log.info("header added to document.");
	}
	
	public static void addTable(Document document, String titletext, int numColumns, String[] columnNames, List<ArrayList<Object>> tabledata) throws DocumentException{
		// Add title text
		Paragraph titlepara = new Paragraph(titletext);
		titlepara.setAlignment(Element.ALIGN_CENTER);		
		PdfUtil.addEmptyLine(titlepara, 1);
		document.add(titlepara);
		// create table
		PdfPTable table = new PdfPTable(numColumns);
		if (numColumns != columnNames.length ) {
			throw new DocumentException("Total columns for table and column header entry dont match.");
		}
		// add column headers
		for (String colname : columnNames) {
			PdfPCell cell = new PdfPCell(new Phrase(colname , PdfUtil.smallBold));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);
		}
		// add data to the table
		for (ArrayList<Object> datarow : tabledata) {
			if (numColumns != datarow.size()) {
				throw new DocumentException("Total columns for table and data in row dont match.");
			}
			for (Object celldata : datarow) {
				table.addCell(new Phrase(celldata.toString(), small));
			}
		}
		document.add(table);
		log.info("added table to pdf.");
	}

	public static void addLine(Document document) throws DocumentException {
		LineSeparator ls = new LineSeparator();
		document.add(new Chunk(ls));
	}
	
	public static void addEmptyLine(Paragraph paragraph, int line) throws DocumentException {
		for (int i = 0; i < line; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}

}
