package Service;

import java.util.List;

import Model.EventModel;
import Model.EventRegisterModel;
import Repository.EventRepoImpl;
import Repository.StudentEventRegisterRepo;
import Repository.StudentEventRegisterRepoImpl;

public class StudentEventRegisterServiceImpl implements StudentEventRegisterService{

	StudentEventRegisterRepo stdEventReg = new StudentEventRegisterRepoImpl();
	

	@Override
	public boolean registerStudentForEvent(EventRegisterModel model) {
		// TODO Auto-generated method stub
		return stdEventReg.registerStudentForEvent(model);
	}

}
