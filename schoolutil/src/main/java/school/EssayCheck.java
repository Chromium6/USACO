package school;
import java.util.List;

import java.io.*; // General file io
import org.apache.poi.xwpf.usermodel.*; // MS word io

public class EssayCheck {
	File doc;
	FileInputStream docIn;
	XWPFDocument stdin;
	
	public EssayCheck(String filePath) {
		try {
			doc = new File(filePath);
			docIn = new FileInputStream(doc.getAbsolutePath());
			stdin = new XWPFDocument(docIn);
			
			List<XWPFParagraph> data = stdin.getParagraphs();
			for (XWPFParagraph item : data) {
				System.out.println(item.getText());
			}
			docIn.close();
		}
		catch (Exception e) {
			System.err.println("Error reading from " + filePath + ": " + e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		EssayCheck k = new EssayCheck("../../../../../01/18/Paly/1018PA+APBioMock2.docx");
	}

}
