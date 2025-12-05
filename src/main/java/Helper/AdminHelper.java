package Helper;
import java.util.*;

import Model.EventModel;

public class AdminHelper {
 
	public static void startWorking() {
		boolean home = true;
		do {
			Scanner sc = new Scanner(System.in);

			System.out.println("Welcome to perform Admin Operations...\n");

			System.out.println("1. Event Operations");
			System.out.println("2. Student Operations");
			System.out.println("3. Event Registraion Operations");
			System.out.println("4. Back to Home Page\n");
			
			System.out.println("Enter Your Choice : ");
			System.out.println("______________________________________");
		
			int ch = sc.nextInt();
			sc.nextLine();
			
			
			switch(ch) {
			case 1: 
				System.out.println("Welcome to Event Operation Page \n");
				EventHelper.startEventOperation();
				break;
			case 2:
				System.out.println("Welcome to Student Operation Page \n");
				StudentHelper.startStudentOperation();
				break;
			case 3:
				System.out.println("Welcome to Event Register Operation Page \n");
				EventRegisterHelper.startEventRegisterOperation();
				break;
			case 4:
				System.out.println("back to home page");
				home=false;
				break;
			}
		}while(home==true);
	}
	
}
