package Model;

import java.sql.Date;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EventModel {
	private int eid;
	private String name;
	private Date edate;
	private String venue;
	private int capacity;
	
	private String oldName;
	private int registered;
	private int available;
	

}
