package Repository;

import Model.StudentModel;

public interface StudentLoginRepo {
	public boolean isValidateStudent(StudentModel model);
	public int getStudentId(String name,String password);
}
