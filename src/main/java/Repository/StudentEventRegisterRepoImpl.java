package Repository;

import java.util.ArrayList;
import java.util.List;

import DBConfiguration.DBInitialize;
import Model.EventModel;
import Model.EventRegisterModel;

public class StudentEventRegisterRepoImpl extends DBInitialize implements StudentEventRegisterRepo{

	@Override
	public boolean registerStudentForEvent(EventRegisterModel model) {
		try {
			// get event capacity
						psmt=conn.prepareStatement("select capacity from event where eid = ?");
						psmt.setInt(1, model.getEid());
						rs = psmt.executeQuery();
						
						int capacity=0;
						if(rs.next()) {
							capacity=rs.getInt(1);
						}
						else {
							System.out.println("Event Not Found");
							return false;
						}
			// count already register student
						psmt=conn.prepareStatement("select count(*) from registration where eid=?");
						psmt.setInt(1, model.getEid());
						rs=psmt.executeQuery();
						
						int regStudentCount=0;
						if(rs.next()) {
							regStudentCount=rs.getInt(1);
						}
			// check the capacity of the event
						if(regStudentCount >= capacity) {
							System.out.println("Event is Full No more students Register for this event...");
							return false;
						}
			// insert registration 
						psmt=conn.prepareStatement("insert into registration (eid , sid , regdate) values(?,?,curdate())");
						
						psmt.setInt(1, model.getEid());
						psmt.setInt(2, model.getSid());
						//psmt.setDate(3, model.getRegdate());
						
						int val = psmt.executeUpdate();
						if(val > 0) {
							return true;
						}
						else {
							return false;
						}
		}
		catch(Exception e) {
			System.out.println("Error is : "+e);
			return false;
		}
	}

}
