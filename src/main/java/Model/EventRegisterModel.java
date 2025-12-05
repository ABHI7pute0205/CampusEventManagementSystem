package Model;

import java.sql.Date;

import lombok.*;

@Data
public class EventRegisterModel {

	private int rid;
	private int eid;
	private int sid;
	private Date regdate;
}
