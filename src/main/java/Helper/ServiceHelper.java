package Helper;

import Service.*;

public class ServiceHelper {

	public static AdminLoginService adminService = new AdminLoginServiceImpl();
	public static EventService eventService = new EventServiceImpl();
	public static StudentService studentService = new StudentServiceImpl();
	public static EventRegisterService eventRegService = new EventRegisterServiceImpl();
	public static StudentLoginService studentLogin = new StudentLoginServiceImpl();
	public static StudentEventRegisterService studentERService = new StudentEventRegisterServiceImpl();
	
}
