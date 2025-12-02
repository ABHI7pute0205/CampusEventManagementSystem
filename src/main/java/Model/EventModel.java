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

//	public String getOldName() { 
//		return oldName; 
//	}
//	public void setOldName(String oldName) {
//		this.oldName = oldName; 
//	}

}
