package ClientApplication;
import java.util.*;

import Exceptions.LoginAttemptsUserDefinedException;
import Helper.AdminHelper;
import Helper.AdminStudentOperationHelper;
import Helper.ServiceHelper;
import Helper.StudentRegisterHelper;
import Model.AdminLoginModel;
import Model.StudentModel;
public class CampusEventClientApp {

	public static int id;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("1. Admin Login ");
			System.out.println("2. Student Login ");
			System.out.println("3. Exit \n");
			
			System.out.println("Enter Your Choice : ");
			System.out.println("_____________________________________________");
			
			int ch = sc.nextInt();
			sc.nextLine();
			
			switch(ch) {
			case 1:
				try {
					System.out.println("Admin Login Details : \n");
					System.out.println("Enter UserName To Login Admin :");
					String uname=sc.nextLine();
					System.out.println("Enter Password To Login Admin :");
					String password = sc.nextLine();
					
					AdminLoginModel model = new AdminLoginModel();
					model.setUsername(uname);
					model.setPassword(password);
					
					boolean b = ServiceHelper.adminService.validateAdminLogin(model);
					if(b) {
						System.out.println("_____________________________________________");
						System.out.println("Admin Login SuccessFully..........\n");
// here we write a seperate helper class which contains a static methods and we show other 
// menue to the admin after successfully login | startWorking is a static method that's why
// we call this method directly using the class name 
						
						AdminHelper.startWorking();
						//AdminStudentOperationHelper.startStudentOperations();
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
				System.out.println("Student Login Details : \n");
				System.out.println("Enter Email as UserName :");
				String uname=sc.nextLine();
				System.out.println("Enter Password To Login Student :");
				String password = sc.nextLine();
				
				StudentModel smodel = new StudentModel();
				smodel.setEmail(uname);
				smodel.setPassword(password);
				
				boolean b = ServiceHelper.studentLogin.isValidateStudent(smodel);
				id=ServiceHelper.studentLogin.getStudentId(uname, password);
				if(b) {
					System.out.println("Student Login SuccessFully.....\n");
					StudentRegisterHelper.startStudentRegisterOperations();
				}
				else {
					System.out.println("Student NOT Login Something Wrong...");
				}
				break;
				
				
			case 3:
				System.out.println("Thank you...");
				System.exit(0);
				break;
				
				default:
					System.out.println("Invalid Choice.......");
			}
		
		}while(true);
	}
}
