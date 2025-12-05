package Helper;

import java.util.List;
import java.util.Scanner;

import DBConfiguration.DBInitialize;
import Model.StudentModel;
import pdfdownload.ReportDownloadHelper;
import pdfdownload.StudentPdfDownload;

public class StudentHelper {

	public static void startStudentOperation(){
		boolean adminHome=true;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("ADMIN CAN PERFORM STUDENT OPERATIONS \n");
			
			System.out.println("1. Add New Student");
			System.out.println("2. View All Student");
			System.out.println("3. Delete Student Using Student ID");
			System.out.println("4. Update Student Details by Student Id");
			System.out.println("5. Search Student by Department");
			System.out.println("6. Search Student by Email ID");
			System.out.println("7. Download Student Report :");
			System.out.println("8. Back To Admin Page\n");
			
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
				
			case 3:
				System.out.println("Enter Student ID which we want to delete : ");
				int sid = sc.nextInt();
				
				b = ServiceHelper.studentService.isDeleteStudentById(sid);
				if(b) {
					System.out.println("Student Deleted SuccessFully");
				}
				else {
					System.out.println("Student NOT Deleted Something Wrong...");
				}
				System.out.println("______________________________________");
				break;
				
			case 4:
				System.out.println("Enter Student id Which we want to Update : ");
				sid=sc.nextInt();
				sc.nextLine(); // here i add new line
				System.out.println("Enter New Student Details which we want to set \n");
				System.out.println("Enter Student name : ");
				name=sc.nextLine();
				System.out.println("Enter Student Email : ");
				email =sc.nextLine();
				System.out.println("Enter Student Contact : ");
				contact =sc.nextLine();
				System.out.println("Enter Student Password : ");
				password =sc.nextLine();
				System.out.println("Enter Student Department : ");
				dept =sc.nextLine();
				
				StudentModel model1 = new StudentModel();
				model1.setSid(sid); // eith id ne update kar to ye to is model la set kar n garje ch ye
				model1.setSname(name);
				model1.setEmail(email);
				model1.setContact(contact);
				model1.setPassword(password);
				model1.setDept(dept);
				
				StudentModel studentModel = ServiceHelper.studentService.isUpdateStudent(model1);
				
				if(studentModel != null) {
					System.out.println("Student Updated SuccessFully....");
					System.out.println(studentModel.getSid()+"\t\t"+studentModel.getSname()+"\t\t"+
							studentModel.getEmail()+"\t\t"+studentModel.getContact()+"\t\t"+
							studentModel.getPassword()+"\t\t"+studentModel.getDept());
				}
				else {
					System.out.println("Student NOT Updated Something Wrong......");
				}
				System.out.println("______________________________________");
				break;
				
			case 5:
				System.out.println("Enter Depart Name to search Student : ");
				dept = sc.nextLine();
				
				List<StudentModel> list1 = ServiceHelper.studentService.isSearchStudentByDept(dept);
				list1.forEach((slist)->System.out.println(slist.getSid()+"\t\t"+slist.getSname()+"\t\t"+
						slist.getEmail()+"\t\t"+slist.getContact()+"\t\t"+slist.getPassword()+"\t\t"+slist.getDept()));
						System.out.println("______________________________________");
				break;
				
			case 6:
				System.out.println("Enter Email of the  Student to Search: ");
				email = sc.nextLine();
				
				List<StudentModel> list2 = ServiceHelper.studentService.isSearchStudentByEmail(email);
				list2.forEach((slist)->System.out.println(slist.getSid()+"\t\t"+slist.getSname()+"\t\t"+
						slist.getEmail()+"\t\t"+slist.getContact()+"\t\t"+slist.getPassword()+"\t\t"+slist.getDept()));
				System.out.println("______________________________________");
				break;
				
			case 7:
				ReportDownloadHelper ref = new ReportDownloadHelper();
				b = ref.studentReportDownload();
				if(b) {
					System.out.println("Student Report Download Success....\n");
				}
				else {
					System.out.println("Student Report NOT Download Success....");
				}
				break;
				
			case 8:
				adminHome=false;
				break;
			}
		}while(adminHome == true);
	}
}
