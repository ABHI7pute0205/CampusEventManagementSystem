package Service;

import java.util.List;

import Model.EventModel;
import Model.EventRegisterModel;

public interface StudentEventRegisterService {
	
	public boolean registerStudentForEvent(EventRegisterModel model);
}
