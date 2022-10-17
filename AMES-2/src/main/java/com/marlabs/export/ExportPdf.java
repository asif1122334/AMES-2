package com.marlabs.export;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.marlabs.model.AssociateDetails;

public class ExportPdf {

	public static ByteArrayInputStream employeesReport(List<AssociateDetails> associate)
			throws MalformedURLException, IOException {

		Document document = new Document(PageSize.A4);

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {

			Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			Paragraph p = new Paragraph("Resource Performance Report - In MFRP", headFont);
			p.setAlignment(Paragraph.ALIGN_CENTER);
			PdfPTable table = new PdfPTable(7); // p 3
			table.setWidthPercentage(110);
			table.setWidths(new int[] { 4, 4, 4, 4, 4, 4, 4 });// 4 added

//			table.setSpacingBefore(10);

			// added lines
//Font title=FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//title.setSize(20);
//Paragraph p=new  Paragraph("Resource Performance Report - In MFRP",headFont);
//p.setAlignment(Paragraph.ALIGN_TOP);

//document.add(p);

			/*
			 * water mark code String urlOfWaterMarKImage =
			 * "https://lh5.googleusercontent.com/" +
			 * "koRHmyNXUGLIjtkHFOJ-1tE5KKl-vZAW3AWLlynkAZSY3Z9m9HBn" +
			 * "boAPiakPTUiySX7W1I8xDwD4g49sD2JfgDDNJIPUdYVDWHfVomeh" +
			 * "FJHWUk1tDPYlpiB32eZ5TDCKUAAZUIQ" ;
			 * 
			 * //Get waterMarkImage from some URL Image waterMarkImage =
			 * Image.getInstance(new URL(urlOfWaterMarKImage));
			 * 
			 * //Get width and height of whole page float pdfPageWidth =
			 * document.getPageSize().getWidth(); float pdfPageHeight =
			 * document.getPageSize().getHeight();
			 * 
			 * PdfContentByte pdfContentByte = new PdfContentByte(null); //Set
			 * waterMarkImage on whole page pdfContentByte.addImage(waterMarkImage,
			 * pdfPageWidth, 0, 0, pdfPageHeight, 0, 0);
			 */

			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("associateMaster.pdf"));

			// add header and footer
			writer.setPageEvent(new WatermarkPageEvent());

			// write to document

//			 
			Image imgSoc = Image.getInstance("C:\\Users\\Expert 12\\3D Objects\\Marlabs_Logo.jpg");
			imgSoc.scaleToFit(110, 110);
			imgSoc.setAbsolutePosition(390, 720);

			PdfPCell hcell;

			hcell = new PdfPCell(new Phrase("batchCode", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.YELLOW);
			;
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("associateId", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.YELLOW);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("associateName", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.YELLOW);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("assessorMark", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.YELLOW);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("mentorMark", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.YELLOW);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("assessorRemarks", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.YELLOW);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("mentorRemarks", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.YELLOW);
			table.addCell(hcell);

			for (AssociateDetails a : associate) {

				PdfPCell cell;

				cell = new PdfPCell(new Phrase(a.getBatchCode()));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(String.valueOf(a.getAssociateId())));
				cell.setPaddingLeft(5);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(String.valueOf(a.getAssociateName())));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setPaddingRight(5);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(String.valueOf(a.getAssessorMark())));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setPaddingRight(5);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(String.valueOf(a.getMentorMark())));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setPaddingRight(5);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(String.valueOf(a.getAssessorRemarks())));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setPaddingRight(5);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(String.valueOf(a.getMentorRemarks())));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setPaddingRight(5);
				table.addCell(cell);
			}

			PdfWriter.getInstance(document, out);

			document.open();
			document.add(table);
			document.add(imgSoc);
			document.add(p);
			document.close();

		} catch (DocumentException ex) {

		}

		return new ByteArrayInputStream(out.toByteArray());
	}

}
