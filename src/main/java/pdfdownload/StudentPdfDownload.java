package pdfdownload;

import java.io.*;
import java.sql.ResultSet;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

public class StudentPdfDownload {

    public static void generateStudentPdf(ResultSet rs , String fileName){
        try {
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream(fileName));
            doc.open();

            Paragraph title = new Paragraph("Student Report",
                    new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD));
            title.setAlignment(Element.ALIGN_CENTER);

            doc.add(title);
            doc.add(new Paragraph("\n"));

            PdfPTable table = new PdfPTable(5);
            table.addCell("ID");
            table.addCell("Name");
            table.addCell("Email");
            table.addCell("Contact");
            table.addCell("Department");

            while (rs.next()) {
                table.addCell(String.valueOf(rs.getInt("sid")));
                table.addCell(rs.getString("sname"));
                table.addCell(rs.getString("email"));
                table.addCell(rs.getString("contact"));
                table.addCell(rs.getString("dept"));
            }

            doc.add(table);
            doc.close();

            System.out.println("\nPDF Created: " + fileName);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    -----------------------
    
    public static void generateEventPdf(ResultSet rs , String fileName){
        try {
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream(fileName));
            doc.open();

            Paragraph title = new Paragraph("Event Report",
                    new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD));
            title.setAlignment(Element.ALIGN_CENTER);

            doc.add(title);
            doc.add(new Paragraph("\n"));

            PdfPTable table = new PdfPTable(5);
            table.addCell("Event id");
            table.addCell("Event Name");
            table.addCell("Event Date");
            table.addCell("Event Venue");
            table.addCell("Event Capacity");

            while (rs.next()) {
                table.addCell(String.valueOf(rs.getInt("eid")));
                table.addCell(rs.getString("name"));
                table.addCell(rs.getString("edate"));
                table.addCell(rs.getString("venue"));
                table.addCell(rs.getString("capacity"));
            }

            doc.add(table);
            doc.close();

            System.out.println("\nPDF Created: " + fileName);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // -------------------
//    public static void generateregisteredStudentEventPdf(ResultSet rs , String fileName){
//    	 try {
//    	        Document doc = new Document();
//    	        PdfWriter.getInstance(doc, new FileOutputStream(fileName));
//    	        doc.open();
//
//    	        Paragraph title = new Paragraph("Event Report",
//    	                new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD));
//    	        title.setAlignment(Element.ALIGN_CENTER);
//
//    	        doc.add(title);
//    	        doc.add(new Paragraph("\n"));
//
//    	        PdfPTable table = new PdfPTable(5);
//    	        table.addCell("ID");
//    	        table.addCell("Name");
//    	        table.addCell("Email");
//    	        table.addCell("Contact");
//    	        table.addCell("Department");
//
//    	        while (rs.next()) {
//    	            table.addCell(String.valueOf(rs.getInt("sid")));
//    	            table.addCell(rs.getString("sname"));
//    	            table.addCell(rs.getString("email"));
//    	            table.addCell(rs.getString("contact"));
//    	            table.addCell(rs.getString("dept"));
//    	        }
//
//    	        doc.add(table);
//    	        doc.close();
//
//    	        System.out.println("\nPDF Created: " + fileName);
//
//    	    } catch (Exception e) {
//    	        e.printStackTrace();
//    	    }
//    }
    
}
