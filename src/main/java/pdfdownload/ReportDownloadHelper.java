package pdfdownload;

import DBConfiguration.DBInitialize;
import Model.EventModel;

public class ReportDownloadHelper extends DBInitialize {

	public boolean studentReportDownload() {
		
		try {

		    psmt = conn.prepareStatement("SELECT * FROM student");
		    rs = psmt.executeQuery();

		    String path = System.getProperty("user.home") + "\\Downloads\\students.pdf";

		    StudentPdfDownload.generateStudentPdf(rs, path); 

		    System.out.println("PDF Download Successfully: " + path);
		    return true;

		} catch (Exception e) {
		    System.out.println("Error is "+e);  
		    return false;
		}
		
	}
	// ----------------------
	public boolean eventReportDownload() {
		
		try {

		    psmt = conn.prepareStatement("SELECT * FROM event");
		    rs = psmt.executeQuery();

		    String path = System.getProperty("user.home") + "\\Downloads\\events.pdf";

		    StudentPdfDownload.generateEventPdf(rs, path); 

		    System.out.println("PDF Download Successfully: " + path);
		    return true;

		} catch (Exception e) {
		    System.out.println("Error is "+e);  
		    return false;
		}
	}
	//------------------------------------
//	public boolean registeredStudentEventReportDownload(int  eventId) {
//		
//		try {
//
//	        psmt = conn.prepareStatement(
//	            "select s.sid , s.sname , s.email , s.contact , s.dept " +
//	            "from student s " +
//	            "join registration r on r.sid = s.sid " +
//	            "join event e on e.eid = r.eid " +
//	            "where e.eid = ?"        // ← use event ID
//	        );
//	        
//	        psmt.setInt(1, eventId);
//
//	        rs = psmt.executeQuery();
//
//	        String path = System.getProperty("user.home") + "\\Downloads\\studentEventRegister.pdf";
//
//	        StudentPdfDownload.generateEventPdf(rs, path); 
//
//	        System.out.println("PDF Download Successfully: " + path);
//	        return true;
//
//	    } catch (Exception e) {
//	        System.out.println("Error is " + e);  
//	        return false;
//	    }
//		
//	}
	
}
