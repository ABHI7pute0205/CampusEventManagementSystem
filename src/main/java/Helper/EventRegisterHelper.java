package Helper;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import Model.EventModel;
import Model.EventRegisterModel;
import Model.StudentModel;
import pdfdownload.ReportDownloadHelper;

public class EventRegisterHelper {

	public static void startEventRegisterOperation() {
		boolean moveToAdmin = true;
		do {
			Scanner sc =  new Scanner(System.in);
			
			System.out.println("WELCOME TO THE EVENT REGISTER OPERATION PAGE \n");
			System.out.println("1. All Students of Specific Event");
			System.out.println("2. All events Register by specific student : ");
			System.out.println("3. Check Event Capacity: (Registered count < capacity)");
			
			System.out.println("7. Back to home Page\n");
			System.out.println("Enter Your Choice : ");
			System.out.println("__________________________________________");
			int ch = sc.nextInt();
			sc.nextLine();
			
			switch(ch) {
			case 1:
				System.out.println("Enter Event Name To Check Register Students For This Event :");
				String eventName=sc.nextLine();
				
					List<StudentModel> list = ServiceHelper.eventRegService.viewEventWiseStudentRegistrations(eventName);
					if(list != null) {
						list.forEach((lst)->System.out.println(lst.getSid()+"\t\t"+lst.getSname()+"\t\t"+
								"\t\t"+lst.getEmail()+"\t\t"+lst.getContact()+"\t\t"+lst.getDept()));
					}
					else {
						System.out.println("No Student Register for the given event : "+eventName);
					}
					System.out.println("__________________________________________");
				break;
				
			case 2:
				System.out.println("Enter Student ID  to check  Register event  :");
				int studentId=sc.nextInt();

				List<EventModel> list1 = ServiceHelper.eventRegService.viewStudentWiseEventRegistrations(studentId);
				if(list1 != null) {
					list1.forEach((lst)->System.out.println(lst.getEid()+"\t\t"+lst.getName()+"\t\t"+
							"\t\t"+lst.getEdate()+"\t\t"+lst.getVenue()+"\t\t"+lst.getCapacity()));
				}
				else {
					System.out.println("This Student is not Register for the Any Event : "+new StudentModel().getSname());
				}
				System.out.println("__________________________________________");
				break;
				
			case 3:
				
				List<EventModel> list2 = ServiceHelper.eventService.getAllEvents();
				list2.forEach((lst)->System.out.println(lst.getEid()+"\t\t"+lst.getName()+"\t\t"+
							"\t\t"+lst.getEdate()+"\t\t"+lst.getVenue()+"\t\t"+lst.getCapacity()));
				
				System.out.println("\nEnter Event Id to Display Capacity");
				int eventId=sc.nextInt();
				
				EventModel model = new EventModel();
				model=ServiceHelper.eventRegService.getEventCapacityDetails(eventId);
				if(model!=null){
					System.out.println("\n________Event Capacity Status____________");
				    System.out.println("Event ID        : "+model.getEid());
				    System.out.println("Event Name      : "+model.getName());
				    System.out.println("Capacity        : "+model.getCapacity());
				    System.out.println("Registered      : "+model.getRegistered());
				    System.out.println("Available Seats : "+model.getAvailable());
				    System.out.println("____________________________________________\n");
				}
				else {
					System.out.println("Event Not Found");
				}
				break;
				
//			case 4:
//			    System.out.println("Enter Event ID to Download Student Report :");
//			    eventId = sc.nextInt();
//
//			    ReportDownloadHelper ref = new ReportDownloadHelper();
//			    boolean b = ref.registeredStudentEventReportDownload(eventId);
//
//			    if(b) {
//			        System.out.println("Student Report Download Success....\n");
//			    } else {
//			        System.out.println("Student Report NOT Download Success....");
//			    }
//			    break;

				
			case 7:
				moveToAdmin=false;
				break;
				
			}
		}
		while(moveToAdmin==true);
	}
}
