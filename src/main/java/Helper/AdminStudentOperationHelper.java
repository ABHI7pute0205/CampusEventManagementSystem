package Helper;

import java.util.*;

import Model.StudentModel;

public class AdminStudentOperationHelper {

	public static void startStudentOperations() {
		do {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("ADMIN CAN PERFORM STUDENT OPERATIONS \n");
			System.out.println("1. Add New Student");
			System.out.println("2. View All Student");
			
			System.out.println("Enter Your Choice : ");
			System.out.println("______________________________________");
			
			int ch = sc.nextInt();
			sc.nextLine();
			
			switch(ch) {
			case 1:
				System.out.println("Enter Student Name : ");
				String name=sc.nextLine();
				System.out.println("Enter Student Email : ");
				String email =sc.nextLine();
				System.out.println("Enter Student Contact : ");
				String contact =sc.nextLine();
				System.out.println("Enter Student Password : ");
				String password =sc.nextLine();
				System.out.println("Enter Student Department : ");
				String dept =sc.nextLine();
				
				StudentModel model = new StudentModel();
				model.setSname(name);
				model.setEmail(email);
				model.setContact(contact);
				model.setPassword(password);
				model.setDept(dept);
				
				boolean b = ServiceHelper.studentService.isAddStudent(model);
				if(b) {
					System.out.println("Student Added SuccessFully...........");
				}
				else {
					System.out.println("Student Not Added Something Wrong....");
				}
				System.out.println("______________________________________");
				break;
				
			case 2:
				List<StudentModel> list = ServiceHelper.studentService.viewAllStudents();
				list.forEach((slist)->System.out.println(slist.getSid()+"\t\t"+slist.getSname()+"\t\t"+
				slist.getEmail()+"\t\t"+slist.getContact()+"\t\t"+slist.getPassword()+"\t\t"+slist.getDept()));
				System.out.println("______________________________________");	
				break;
				
			case 8:
				System.exit(0);
				break;
			}
		}while(true);
	}
}
