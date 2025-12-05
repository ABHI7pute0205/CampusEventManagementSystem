package Helper;

import java.util.List;
import java.util.Scanner;

import ClientApplication.CampusEventClientApp;
import Model.EventModel;
import Model.EventRegisterModel;

public class StudentRegisterHelper {

	public static void startStudentRegisterOperations() {
		boolean adminPage=true;
		
		do {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("WELCOME TO THE STUDENT OPERATION PAGE...\n");
			System.out.println("1. View All  Events : ");
			System.out.println("2. View Upcoming  Events : ");
			System.out.println("3. Register for the  Events : ");
			System.out.println("4. Back to Home Page\n");
			
			System.out.println("Enter Your Choice : ");
			System.out.println("______________________________________");
			int ch = sc.nextInt();
			
			switch(ch) {
			case 1:
				List<EventModel> list = ServiceHelper.eventService.getAllEvents();
				
				System.out.println("eid"+"\t"+"name"+"\t"+"edate"+"\t"+"venue"+"\t"+"capacity");
				
				list.forEach((lst)->System.out.println(lst.getEid()+"\t"+lst.getName()+"\t\t"+
						lst.getEdate()+"\t\t"+lst.getVenue()+"\t\t"+lst.getCapacity()));
				System.out.println("______________________________________");
				break;
				
			case 2:
				List<EventModel> list1 = ServiceHelper.eventService.getUpComingEvents();
				System.out.println("eid"+"\t\t"+"name"+"\t\t"+"edate"+"\t\t"+"venue"+"\t\t"+"capacity");
				
				list1.forEach((lst)->System.out.println(lst.getEid()+"\t\t"+lst.getName()+"\t\t"+
						lst.getEdate()+"\t\t"+lst.getVenue()+"\t\t"+lst.getCapacity()));
				System.out.println("______________________________________");
				break;
				
			case 3:
//				System.out.println("Enter Student id which we want to register to the event :");
//				int sid=sc.nextInt();
				System.out.println("Enter Event Id which we want to allow to register to Student :");
				int eid=sc.nextInt();
				
				EventRegisterModel model = new EventRegisterModel();
				model.setSid(CampusEventClientApp.id);
				model.setEid(eid);
				//model.setRegdate(regDate);
				
				boolean b = ServiceHelper.studentERService.registerStudentForEvent(model);
				if(b) {
					System.out.println("Student Registration for the Event Succesfull... ");
				}
				else {
					System.out.println("Student NOT Register Some thing Wrong... ");
				}
				break;
				

			case 4:
				adminPage=false;
				break;
				
				default:
					System.out.println("Invalid Choice ....... ");
			}
		}while(adminPage == true);
	}
}
