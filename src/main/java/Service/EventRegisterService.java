package Service;

import java.util.List;

import Model.EventModel;
import Model.EventRegisterModel;
import Model.StudentModel;

public interface EventRegisterService {

	public List<StudentModel> viewEventWiseStudentRegistrations(String eventName);
	public List<EventModel> viewStudentWiseEventRegistrations(int studentId);
	public EventModel getEventCapacityDetails(int eventId);
}
