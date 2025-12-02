package Model;

import lombok.*;

@Data
@Getter
@Setter
public class StudentModel {

	private int sid;
	private String sname;
	private String email;
	private String contact;
	private String password;
	private String dept;
}
