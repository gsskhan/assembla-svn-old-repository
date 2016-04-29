package org.demo.poi.wordgen;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class FirstWordGenApp {

	private static Logger LOG = Logger.getLogger(FirstWordGenApp.class);
	
	public static void main(String[] args) {
		
		// create a blank document
		XWPFDocument document = new XWPFDocument();
		
		// create a paragraph
		XWPFParagraph paragraph = document.createParagraph();
		paragraph.setAlignment(ParagraphAlignment.CENTER);
		XWPFRun run = paragraph.createRun();
		run.setText("Hello world!!");
		run.setBold(true);
		
		
		// Write the document to Filesystem.
		File outputDocxFile = new File("FirstWordGenApp.docx");
		try( FileOutputStream fos = new FileOutputStream(outputDocxFile)) {			
			document.write(fos);
			fos.close();
			document.close();
			LOG.info("Word document written successfully to disk, at "+ outputDocxFile.getAbsolutePath());
		} catch (IOException e) {
			LOG.error("error writing file to disk.", e);
		}
		LOG.info("program completed...");
		
	}

}
