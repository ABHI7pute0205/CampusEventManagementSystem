package Repository;

import java.util.List;

import Model.EventModel;
import Model.EventRegisterModel;

public interface StudentEventRegisterRepo {
	public boolean registerStudentForEvent(EventRegisterModel model);
}
