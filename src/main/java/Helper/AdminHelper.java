package Helper;
import java.util.*;

import Model.EventModel;

public class AdminHelper {
 
	public static void startWorking() {
		do {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("______________________________________");
			System.out.println("1.  Add New Event");
			System.out.println("2.  View All Events");
			System.out.println("3. View Upcoming Events");
			System.out.println("4. Delete Event Using event ID");
			System.out.println("5. Update Event Details by Event Name");
			
			System.out.println("______________________________________");
			int ch = sc.nextInt();
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
				System.out.println("eid"+"\t"+"name"+"\t\t"+"edate"+"\t\t"+"venue"+"\t\t"+"capacity");
				
				list1.forEach((lst)->System.out.println(lst.getEid()+"\t"+lst.getName()+"\t"+
						lst.getEdate()+"\t"+lst.getVenue()+"\t\t"+lst.getCapacity()));
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
				System.out.println("Enter Event Name to update Event Details : ");
				name=sc.nextLine();
				System.out.println("Enter New Event Details which we want to change : ");
				
				System.out.println("Enter Event Name : ");
				String ename=sc.nextLine();
				System.out.println("Enter Event Date : ");
				inputDate=sc.nextLine();
				
				eventDate = java.sql.Date.valueOf(inputDate);
				
				System.out.println("Enter Event Venue : ");
				venue=sc.nextLine();
				System.out.println("Enter Student Capacity for the  given Event : ");
				capacity=sc.nextInt();
				
				EventModel emodel1 = new EventModel();
				emodel1.setName(ename);
				emodel1.setEdate(eventDate);
				emodel1.setVenue(venue);
				emodel1.setCapacity(capacity);
				
				EventModel eventModel = ServiceHelper.eventService.isUpdateEvent(emodel1);
				if(eventModel != null) {
					System.out.println("Event Details Updated SuccessFully............");
					System.out.println(eventModel.getEid()+"\t\t"+eventModel.getName()+"\t\t"+
							eventModel.getEdate()+"\t\t"+eventModel.getVenue()+"\t\t"+eventModel.getCapacity());
				}
				else {
					System.out.println("Event Details NOT Updated Something Wrong ....");
				}
				
				break;
			case 8:
				System.exit(ch);
				break;
				
				default:
					System.out.println("Please Enter Valid Choice....");
			}
		}while(true);
	}
	
}
