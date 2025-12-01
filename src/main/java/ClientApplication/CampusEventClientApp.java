package ClientApplication;
import java.util.*;

import Exceptions.LoginAttemptsUserDefinedException;
import Helper.AdminHelper;
import Helper.ServiceHelper;
import Model.AdminLoginModel;
public class CampusEventClientApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("_____________________________________________");
			System.out.println("1. Admin Login ");
			System.out.println("_____________________________________________");
			
			int ch = sc.nextInt();
			sc.nextLine();
			
			switch(ch) {
			case 1:
				try {
					System.out.println("Enter UserName and Password to Login Admin :");
					String uname=sc.nextLine();
					String password = sc.nextLine();
					
					AdminLoginModel model = new AdminLoginModel();
					model.setUsername(uname);
					model.setPassword(password);
					
					boolean b = ServiceHelper.adminService.validateAdminLogin(model);
					if(b) {
						System.out.println("Admin Login SuccessFully..........");
// here we write a seperate helper class which contains a static methods and we show other 
// menue to the admin after successfully login | startWorking is a static method that's why
// we call this method directly using the class name 
						AdminHelper.startWorking();
					}
					else {
						System.out.println("Admin Not Login Something Wrong please check userName Or Password");
					}
					System.out.println("_____________________________________________");
				}
				catch(LoginAttemptsUserDefinedException ex) {
					System.out.println(ex.getMessage());
					System.exit(0);
				}
				break;
				
			case 2:
				break;
				
			case 3:
				break;
				
			case 8:
				System.exit(0);
				break;
				
				default:
					System.out.println("Invalid Choice.......");
			}
		
		}while(true);
	}
}
