package Helper;

import java.util.List;
import java.util.Scanner;

import Model.*;
import pdfdownload.ReportDownloadHelper;

public class EventHelper {

	public static void startEventOperation() {
		boolean moveAdmin = true;
		do {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("1. Add New Event");
			System.out.println("2. View All Events");
			System.out.println("3. View Upcoming Events");
			System.out.println("4. Delete Event Using event ID");
			System.out.println("5. Update Event Details by Event Name");
			System.out.println("6. Download Event Report ");
			System.out.println("7. Back to Admin Page :\n");
			
			System.out.println("Enter Your choice  :");
			System.out.println("______________________________________");
			int ch =sc.nextInt();
			sc.nextLine();
			
			switch(ch) {

			case 1:
				System.out.println("Enter Event Name : ");
				String name=sc.nextLine();
				
				System.out.println("Enter Date of the event i.e. on which date event is paln (yyyy-mm-dd) : ");
				String inputDate=sc.nextLine();
				// need to convert sting into java.sql.Date
				// if we not convert this sting into date then value is not inserted in 
				// DB and we get exception : java.sql.SQLException: Data truncated for column 'edate'
				java.sql.Date eventDate = java.sql.Date.valueOf(inputDate);
				
				System.out.println("Enter Event Venue i.e Location of the Event  : ");
				String venue=sc.nextLine();
				System.out.println("Enter Student Capacity for the  given Event : ");
				int capacity=sc.nextInt();
				
				EventModel emodel = new EventModel();
				emodel.setName(name);
				emodel.setEdate(eventDate);
				emodel.setVenue(venue);
				emodel.setCapacity(capacity);
				
				boolean b = ServiceHelper.eventService.isAddEvent(emodel);
				if(b) {
					System.out.println("Event Added SuccessFully in DB.....");
				}
				else {
					System.out.println("Event Not Added Something Wrong..... ");
				}
				System.out.println("______________________________________");
				break;
				
			case 2:
				List<EventModel> list = ServiceHelper.eventService.getAllEvents();
				
				System.out.println("eid"+"\t"+"name"+"\t"+"edate"+"\t"+"venue"+"\t"+"capacity");
				
				list.forEach((lst)->System.out.println(lst.getEid()+"\t"+lst.getName()+"\t\t"+
						lst.getEdate()+"\t\t"+lst.getVenue()+"\t\t"+lst.getCapacity()));
				System.out.println("______________________________________");
				break;
				
			case 3:
//				System.out.println("View UpComming Events ");
				List<EventModel> list1 = ServiceHelper.eventService.getUpComingEvents();
				System.out.println("eid"+"\t\t\t"+"name"+"\t\t\t"+"edate"+"\t\t\t"+"venue"+"\t\t\t"+"capacity");
				
				list1.forEach((lst)->System.out.println(lst.getEid()+"\t\t\t"+lst.getName()+"\t\t\t"+
						lst.getEdate()+"\t\t\t"+lst.getVenue()+"\t\t\t"+lst.getCapacity()));
				System.out.println("______________________________________");
				break;
				
			case 4:
				System.out.println("Enter Event id to Delete particular event from the list");
				int eid=sc.nextInt();
				
				b = ServiceHelper.eventService.isDeleteEvent(eid);
				if(b) {
					System.out.println("Event Delete SuccessFully from the List...........");
				}
				else {
					System.out.println("Event Not Deleted some Error is Occure");
				}
				System.out.println("______________________________________");
				break;
				
			case 5:
				System.out.println("Enter OLD Event Name to update Event Details : \n");
				String oldEventname=sc.nextLine();
				System.out.println("Enter New Event Details which we want to change : \n");
				
				System.out.println("Enter New Event Name : ");
				String newName=sc.nextLine();
				System.out.println("Enter Event Date : ");
				inputDate=sc.nextLine();
				
				eventDate = java.sql.Date.valueOf(inputDate);
				
				System.out.println("Enter Event Venue : ");
				venue=sc.nextLine();
				System.out.println("Enter Student Capacity for the  given Event : ");
				capacity=sc.nextInt();
				
				EventModel emodel1 = new EventModel();
				
				emodel1.setName(newName);
				emodel1.setEdate(eventDate);
				emodel1.setVenue(venue);
				emodel1.setCapacity(capacity);
				emodel1.setOldName(oldEventname); // eith name ne details update kar to ye so jya name chya update kara y chya ye te name eith dya y ch 
				
				EventModel eventModel = ServiceHelper.eventService.isUpdateEvent(emodel1);
				if(eventModel != null) {
					System.out.println("Event Details Updated SuccessFully............");
					System.out.println(eventModel.getEid()+"\t\t\t"+eventModel.getName()+"\t\t\t"+
							eventModel.getEdate()+"\t\t\t"+eventModel.getVenue()+"\t\t\t"+eventModel.getCapacity());
				}
				else {
					System.out.println("Event Details NOT Updated Something Wrong ....");
				}
				System.out.println("______________________________________");
				break;
				
			case 6:
//				from pdfDownload package  
				ReportDownloadHelper ref = new ReportDownloadHelper();
				b = ref.eventReportDownload();
				if(b) {
					System.out.println("Student Report Download Success....\n");
				}
				else {
					System.out.println("Student Report NOT Download Success....");
				}
				break;
				
			case 7:
				moveAdmin = false;
				
			break;
				default:
					System.out.println("Please Enter Valid Choice....");
			}
		}while(moveAdmin==true);
	}
}
